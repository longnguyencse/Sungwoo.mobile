package com.sungwoo.aps.mobile;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.sungwoo.aps.mobile.injection.compoment.DaggerSungwooComponent;
import com.sungwoo.aps.mobile.injection.compoment.SungwooComponent;
import com.sungwoo.aps.mobile.injection.module.ApplicationModule;
import com.sungwoo.aps.mobile.injection.module.NetworkModule;
import com.sungwoo.aps.mobile.injection.module.SungwooModule;

import io.realm.Realm;

/**
 * Ikorn Solutions Co.,Ltd ... on 18-Aug-17.
 * All rights reserved
 */

public class SungwooApplication extends Application {
    private static SungwooApplication sSumSungwooApplication;
    public static SungwooComponent mApplicationComponent;

    public SungwooApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // singleton
        initSingletonApp();
        // initialize injection
        initializeInjection();

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

    private void initializeInjection(){
        mApplicationComponent = DaggerSungwooComponent
                .builder()
                .sungwooModule(new SungwooModule())
                .networkModule(new NetworkModule())
                .applicationModule(new ApplicationModule(this))
                .build();
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

    public static SungwooApplication get(Context context) {
        return (SungwooApplication) context.getApplicationContext();
    }
}
