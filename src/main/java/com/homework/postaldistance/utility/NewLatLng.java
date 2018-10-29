package com.homework.postaldistance.utility;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Milos
 */

public class NewLatLng {
    
    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public double getLatitudeDouble() {
        return Double.valueOf(latitude);
    }
    
    public double getLongitudeDouble() {
        return Double.valueOf(longitude);
    }
    
    public boolean isLatValid() {
        double d;
        try {
            d = Double.valueOf(latitude);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean isLngValid() {
        double d;
        try {
            d = Double.valueOf(longitude);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
