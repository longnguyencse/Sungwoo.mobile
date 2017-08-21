package com.sungwoo.aps.mobile.injection.compoment;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.sungwoo.aps.mobile.SungwooApplication;
import com.sungwoo.aps.mobile.data.remote.SungwooService;
import com.sungwoo.aps.mobile.injection.ApplicationContext;
import com.sungwoo.aps.mobile.injection.module.ApplicationModule;
import com.sungwoo.aps.mobile.ui.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Ikorn Solutions Ltd,.. on 11/23/2016.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
    @ApplicationContext Context context();
    SungwooService sungwooService();
}
