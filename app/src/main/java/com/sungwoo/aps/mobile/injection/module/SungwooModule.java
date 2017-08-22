package com.sungwoo.aps.mobile.injection.module;

import com.sungwoo.aps.mobile.UIThread;
import com.sungwoo.aps.mobile.data.DataRepository;
import com.sungwoo.aps.mobile.data.DataRepositoryImpl;
import com.sungwoo.aps.mobile.data.executor.JobExecutor;
import com.sungwoo.aps.mobile.data.executor.PostExecutionThread;
import com.sungwoo.aps.mobile.data.executor.ThreadExecutor;
import com.sungwoo.aps.mobile.data.interactor.ParkingUseCase;
import com.sungwoo.aps.mobile.data.interactor.UseCase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Ikorn Solutions Co.,Ltd ... on 21-Aug-17.
 * All rights reserved
 */
@Module
public class SungwooModule {
    public SungwooModule() {
    }
    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Provides
    @Singleton
    DataRepository provideDataRepository(DataRepositoryImpl dataRepository) {
        return dataRepository;

    }

    @Provides
    @Named("parking-lot")
    UseCase provideParkingUseCase (DataRepository dataRepository,
                                   ThreadExecutor threadExecutor,
                                   PostExecutionThread postExecutionThread) {
        return new ParkingUseCase(threadExecutor, postExecutionThread, dataRepository);
    }
}
