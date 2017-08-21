package com.sungwoo.aps.mobile.data.remote;

import com.sungwoo.aps.mobile.data.model.ParkingPoint;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Ikorn Solutions Co.,Ltd ... on 18-Aug-17.
 * All rights reserved
 */

public interface SungwooService {
    String ENDPOINT = "https://api.ikorn.vn/";

    @GET("pakingSlot")
    Observable<ParkingPoint> getParkingLotData(String location);

}
