package com.sungwoo.aps.mobile.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sungwoo.aps.mobile.data.model.ParkingPoint;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Ikorn Solutions Co.,Ltd ... on 18-Aug-17.
 * All rights reserved
 */

public interface SungwooService {
    String ENDPOINT = "https://api.ikorn.vn/";

    @GET("pakingSlot")
    Observable<ParkingPoint> getParkingLotData(String location);

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static SungwooService newSungwooService() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(SungwooService.class);
        }
    }
}
