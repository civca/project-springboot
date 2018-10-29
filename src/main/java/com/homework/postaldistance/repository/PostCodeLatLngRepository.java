package com.homework.postaldistance.repository;

import com.homework.postaldistance.model.PostCodeLatLng;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Milos
 */
public interface PostCodeLatLngRepository extends JpaRepository<PostCodeLatLng, Integer> {
  
    public PostCodeLatLng findByPostcode(String postcode);
    
    public PostCodeLatLng save(PostCodeLatLng postal);
    
}
