package com.sungwoo.aps.mobile.presenter;

import android.util.Log;

import com.sungwoo.aps.mobile.data.interactor.DefaultObserver;
import com.sungwoo.aps.mobile.data.interactor.ParkingUseCase;
import com.sungwoo.aps.mobile.data.model.ParkingPoint;
import com.sungwoo.aps.mobile.ui.mvpview.SungwooMvpView;

import javax.inject.Inject;

/**
 * Ikorn Solutions Co.,Ltd ... on 21-Aug-17.
 * All rights reserved
 */

public class SungwooPresenter implements Presenter {
    private final ParkingUseCase parkingUseCase;
    private SungwooMvpView view;

    @Inject
    public SungwooPresenter(ParkingUseCase parkingUseCase) {
        this.parkingUseCase = parkingUseCase;
    }

    public void setView(SungwooMvpView view) {
        this.view = view;
    }

    public void getParkingLot(String uid) {
        this.parkingUseCase.execute(new ParkingLotObserver(), ParkingUseCase.Params.forparking(uid));
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    private final class ParkingLotObserver extends DefaultObserver<ParkingPoint> {
        @Override
        public void onNext(ParkingPoint parkingPoint) {
            super.onNext(parkingPoint);
            Log.d("1111111111111", "On next");
        }

        @Override
        public void onComplete() {
            super.onComplete();
            Log.d("11111111111", "On Complete");
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
            Log.d("1111111111111", "On Error");
        }
    }
}
