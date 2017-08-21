package com.sungwoo.aps.mobile.injection.module;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.sungwoo.aps.mobile.SungwooApplication;
import com.sungwoo.aps.mobile.data.remote.SungwooService;
import com.sungwoo.aps.mobile.injection.ActivityContext;
import com.sungwoo.aps.mobile.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    protected final SungwooApplication mApplication;

    public ApplicationModule(SungwooApplication application) {
        mApplication = application;
    }

    @Provides
    SungwooApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication;
    }

}
