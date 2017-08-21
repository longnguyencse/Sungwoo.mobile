package com.sungwoo.aps.mobile.injection.compoment;

import android.content.Context;

import com.google.gson.Gson;
import com.sungwoo.aps.mobile.SungwooApplication;
import com.sungwoo.aps.mobile.data.remote.SungwooService;
import com.sungwoo.aps.mobile.injection.PerActivity;
import com.sungwoo.aps.mobile.injection.module.ApplicationModule;
import com.sungwoo.aps.mobile.injection.module.NetworkModule;
import com.sungwoo.aps.mobile.injection.module.SungwooModule;
import com.sungwoo.aps.mobile.ui.activity.BaseActivity;
import com.sungwoo.aps.mobile.ui.activity.SungwooActivity;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Ikorn Solutions Co.,Ltd ... on 21-Aug-17.
 * All rights reserved
 */
@Singleton
@Component( modules = {NetworkModule.class, ApplicationModule.class, SungwooModule.class})
public interface SungwooComponent {
    SungwooApplication sungwooApplication();
    Context context();
    SungwooService sungwooService();

    void inject(SungwooActivity activity);

}
