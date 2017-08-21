package com.sungwoo.aps.mobile.data.remote;

import com.sungwoo.aps.mobile.data.model.ParkingPoint;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Ikorn Solutions Co.,Ltd ... on 21-Aug-17.
 * All rights reserved
 */

@Singleton
public class SungwooApiImp implements SungwooApi {
    private final SungwooService service;

    @Inject
    public SungwooApiImp(SungwooService service) {
        this.service = service;
    }
}
