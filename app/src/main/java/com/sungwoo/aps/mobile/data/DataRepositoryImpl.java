package com.sungwoo.aps.mobile.data;

import com.sungwoo.aps.mobile.data.model.ParkingPoint;
import com.sungwoo.aps.mobile.data.remote.SungwooService;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Ikorn Solutions Co.,Ltd ... on 22-Aug-17.
 * All rights reserved
 */

public class DataRepositoryImpl implements DataRepository {
    private final SungwooService sungwooApi;

    @Inject
    public DataRepositoryImpl(SungwooService sungwooApi) {
        this.sungwooApi = sungwooApi;
    }

    @Override
    public Observable<ParkingPoint> getParkingUid(String uid) {
        return sungwooApi.getParkingLotData(uid);
    }
}
