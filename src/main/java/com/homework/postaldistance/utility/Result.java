package com.homework.postaldistance.utility;

/**
 *
 * @author Milos
 */
public class Result {
    private String postal1;
    private String postalLat1;
    private String postalLng1;
    
    private String postal2;
    private String postalLat2;
    private String postalLng2;
    
    private String distance;
    private final String unit = "km";
    

    public Result(String postal1, String postalLat1, String postalLng1, String postal2, String postalLat2, String postalLng2, String distance) {
        this.postal1 = postal1;
        this.postalLat1 = postalLat1;
        this.postalLng1 = postalLng1;
        this.postal2 = postal2;
        this.postalLat2 = postalLat2;
        this.postalLng2 = postalLng2;
        this.distance = distance;
    }
   
    public String getPostal1() {
        return postal1;
    }

    public String getPostalLat1() {
        return postalLat1;
    }

    public String getPostalLng1() {
        return postalLng1;
    }

    public String getPostal2() {
        return postal2;
    }

    public String getPostalLat2() {
        return postalLat2;
    }

    public String getPostalLng2() {
        return postalLng2;
    }

    public String getDistance() {
        return distance;
    }

    public String getUnit() {
        return unit;
    }

}
