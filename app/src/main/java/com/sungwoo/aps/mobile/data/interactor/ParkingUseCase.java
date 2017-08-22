package com.sungwoo.aps.mobile.data.interactor;

import com.sungwoo.aps.mobile.data.DataRepository;
import com.sungwoo.aps.mobile.data.executor.PostExecutionThread;
import com.sungwoo.aps.mobile.data.executor.ThreadExecutor;
import com.sungwoo.aps.mobile.data.model.ParkingPoint;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Ikorn Solutions Co.,Ltd ... on 22-Aug-17.
 * All rights reserved
 */

public class ParkingUseCase extends UseCase<ParkingPoint, ParkingUseCase.Params> {
    final DataRepository dataRepository;

    @Inject
    public ParkingUseCase(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread,
                          DataRepository dataRepository) {
        super(threadExecutor, postExecutionThread);
        this.dataRepository = dataRepository;
    }

    @Override
    Observable<ParkingPoint> buildUseCaseObservable(Params params) {
        return dataRepository.getParkingUid(params.uid);
    }


    public static class Params {
        private final String uid;

        public Params(String uid) {
            this.uid = uid;
        }

        public static Params forparking(String uid) {
            return new Params(uid);
        }
    }

}
