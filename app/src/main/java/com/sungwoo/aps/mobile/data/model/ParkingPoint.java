package com.sungwoo.aps.mobile.data.model;

import java.util.List;

/**
 * Ikorn Solutions Co.,Ltd ... on 19-Aug-17.
 * All rights reserved
 */

public class ParkingPoint {
    private final static int AVAIBEL_STATE = 0;
    private final static int FULL_STATE = 1;

    private String name;
    private int state;
    List<GpsPoint> gpsPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setAvaibelState() {
        this.state = AVAIBEL_STATE;
    }

    public void setFullState() {
        this.state = FULL_STATE;
    }

    public List<GpsPoint> getGpsPoints() {
        return gpsPoints;
    }

    public void setGpsPoints(List<GpsPoint> gpsPoints) {
        this.gpsPoints = gpsPoints;
    }
}
