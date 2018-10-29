package com.homework.postaldistance.utility;

/**
 *
 * @author Milos
 */
public class RepresentationOfLatLng {

    public static String getDecimalInDegree(double decimal, boolean isLatitude) {
        
        int seconds = (int) Math.round(decimal * 3600);
        int degrees = seconds / 3600;
        seconds = Math.abs(seconds % 3600);
        int minutes = seconds / 60;
        seconds %= 60;

        String postfiks;
        if (isLatitude) {
            postfiks = decimal >= 0 ? "N" : "S";
        } else {
            postfiks = decimal >= 0 ? "E" : "W";
        }
        
        //return Math.abs(degrees) + "°" + minutes + "'" + seconds + "\" " + postfiks;
        //u json-u uvijek dobijam \" umjesto samo "
        //privremeno rješenje je ''
        return Math.abs(degrees) + "°" + minutes + "'" + seconds + "'' " + postfiks;

    }
}
