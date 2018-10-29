package com.homework.postaldistance.utility;

import java.text.DecimalFormat;

/**
 *
 * @author Milos
 */
public class Distance {
    
    private static final DecimalFormat df = new DecimalFormat("#.##");
    
    public static String calculateDistance(double latitude, double longitude, double latitude2,
            double longitude2) {
        
        double EARTH_RADIUS = 6371; // radius in kilometers
        
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);
        double a = haversine(lat1Radians, lat2Radians) + Math.cos(lat1Radians)
                * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return df.format(EARTH_RADIUS * c);
    }

    private static double haversine(double deg1, double deg2) {
        return square(Math.sin((deg1 - deg2) / 2.0));
    }

    private static double square(double x) {
        return x * x;
    }
    
}