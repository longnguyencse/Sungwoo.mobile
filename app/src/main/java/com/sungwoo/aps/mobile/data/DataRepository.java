package com.sungwoo.aps.mobile.data;

import com.sungwoo.aps.mobile.data.model.ParkingPoint;

import io.reactivex.Observable;

/**
 * Ikorn Solutions Co.,Ltd ... on 22-Aug-17.
 * All rights reserved
 */

public interface DataRepository {
    Observable<ParkingPoint> getParkingUid(String uid);
}
