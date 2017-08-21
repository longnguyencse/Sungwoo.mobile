package com.sungwoo.aps.mobile.injection.module;

import android.content.Context;

import com.sungwoo.aps.mobile.SungwooApplication;

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
