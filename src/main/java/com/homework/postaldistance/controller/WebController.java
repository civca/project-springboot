package com.homework.postaldistance.controller;

import com.homework.postaldistance.exception.LatAndLngNotValidException;
import com.homework.postaldistance.exception.PostalNotFoundException;
import com.homework.postaldistance.model.PostCodeLatLng;
import com.homework.postaldistance.utility.Distance;
import com.homework.postaldistance.utility.RepresentationOfLatLng;
import com.homework.postaldistance.utility.Result;
import com.homework.postaldistance.utility.NewLatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.homework.postaldistance.repository.PostCodeLatLngRepository;
import javax.validation.Valid;


/**
 *
 * @author Milos
 */
@RestController
@RequestMapping("/postalService")
public class WebController {

    @Autowired
    private PostCodeLatLngRepository postcodelatlngRepository;

    @GetMapping("/getDistanceBetween/{postalFrom}/{postalTo}")
    public Result getDistance(@PathVariable String postalFrom, @PathVariable String postalTo) {

        PostCodeLatLng postcodelatlngFrom = postcodelatlngRepository.findByPostcode(postalFrom.toUpperCase());
        if (postcodelatlngFrom == null) {
            throw new PostalNotFoundException("Post code " + postalFrom + " not found.");
        }
        PostCodeLatLng postcodelatlngTo = postcodelatlngRepository.findByPostcode(postalTo.toUpperCase());
        if (postcodelatlngTo == null) {
            throw new PostalNotFoundException("Post code " + postalTo + " not found.");
        }
        
        String distance = Distance.calculateDistance(postcodelatlngFrom.getLatitude(), postcodelatlngFrom.getLongitude(),
                postcodelatlngTo.getLatitude(), postcodelatlngTo.getLongitude());
        
        String latDegreesFrom = RepresentationOfLatLng.getDecimalInDegree(postcodelatlngFrom.getLatitude(), true);
        String lngDegreesFrom = RepresentationOfLatLng.getDecimalInDegree(postcodelatlngFrom.getLongitude(), false);
        
        String latDegreesTo = RepresentationOfLatLng.getDecimalInDegree(postcodelatlngTo.getLatitude(), true);
        String lngDegreesTo = RepresentationOfLatLng.getDecimalInDegree(postcodelatlngTo.getLongitude(), false);
        
        return new Result(postcodelatlngFrom.getPostcode(), latDegreesFrom, lngDegreesFrom,
                postcodelatlngTo.getPostcode(), latDegreesTo, lngDegreesTo, distance);
    }

    @GetMapping("/getPostal/{postCode}")
    public PostCodeLatLng getPostal(@PathVariable(value = "postCode") String postCode) {
        PostCodeLatLng postal = postcodelatlngRepository.findByPostcode(postCode.toUpperCase());
        if (postal == null) {
            throw new PostalNotFoundException("Post code " + postCode + " not found.");
        } else {
            return postal;
        }
    }

    @PutMapping("/updateLatLng/{postCode}")
    public PostCodeLatLng updateLatLng(@PathVariable String postCode,@RequestBody NewLatLng newLatLng) {
        
        if(newLatLng.getLatitude() == null) {
          throw new LatAndLngNotValidException("Latitude value is missing!");  
        }
        if(newLatLng.getLongitude() == null) {
          throw new LatAndLngNotValidException("Longitude value is missing!");
        }
        
        if(newLatLng.getLatitude().isEmpty() || !newLatLng.isLatValid()) {
            throw new LatAndLngNotValidException("Latitude value " + newLatLng.getLatitude() + " is not valid number!");
        }
        if(newLatLng.getLongitude().isEmpty() || !newLatLng.isLngValid()) {
            throw new LatAndLngNotValidException("Longitude value " + newLatLng.getLongitude()+ " is not valid number!");
        }
        
        PostCodeLatLng postal = postcodelatlngRepository.findByPostcode(postCode.toUpperCase());
        if (postal == null) {
            throw new PostalNotFoundException("Post code " + postCode + " not found.");
        } else {
            postal.setLatitude(newLatLng.getLatitudeDouble());
            postal.setLongitude(newLatLng.getLongitudeDouble());
            postcodelatlngRepository.save(postal);
            return postal;
        }

    }

}
