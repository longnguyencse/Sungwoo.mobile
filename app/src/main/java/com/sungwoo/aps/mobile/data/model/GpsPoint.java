package com.sungwoo.aps.mobile.data.model;

/**
 * Ikorn Solutions Co.,Ltd ... on 19-Aug-17.
 * All rights reserved
 */

public class GpsPoint {
    private final long lat;
    private final long lon;

    public GpsPoint(long lat, long lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public long getLat() {
        return lat;
    }

    public long getLon() {
        return lon;
    }
}
