package com.sungwoo.aps.mobile;

import android.app.Application;

import com.facebook.stetho.*;
import com.squareup.leakcanary.LeakCanary;
import com.sungwoo.aps.mobile.injection.compoment.ApplicationComponent;
import com.sungwoo.aps.mobile.injection.compoment.DaggerApplicationComponent;
import com.sungwoo.aps.mobile.injection.module.ApplicationModule;

import io.realm.Realm;

/**
 * Ikorn Solutions Co.,Ltd ... on 18-Aug-17.
 * All rights reserved
 */

public class SungwooApplication extends Application {
    private static SungwooApplication sSumSungwooApplication;
    private ApplicationComponent mApplicationComponent;

    private SungwooApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // singleton
        initSingletonApp();

        // Leak canary
        initLeakCanary();
        // debug library
        initDebugLibrary();
        // init realm db
        initRealmDb();
        // init release library
        initReleaseLibrary();
    }

    private SungwooApplication initSingletonApp() {
        if (null == sSumSungwooApplication) {
            sSumSungwooApplication = this;
        }
        return sSumSungwooApplication;
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    private void initRealmDb() {
        Realm.init(this);
    }

    private void initReleaseLibrary() {

    }

    private void initDebugLibrary() {
        if (BuildConfig.DEBUG) {
            return;
        }
        Stetho.initializeWithDefaults(this);
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }
}
