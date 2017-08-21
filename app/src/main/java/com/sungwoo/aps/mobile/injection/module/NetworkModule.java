package com.sungwoo.aps.mobile.injection.module;

import android.app.Activity;
import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sungwoo.aps.mobile.BuildConfig;
import com.sungwoo.aps.mobile.SungwooApplication;
import com.sungwoo.aps.mobile.data.realm.RealmInt;
import com.sungwoo.aps.mobile.data.realm.RealmString;
import com.sungwoo.aps.mobile.data.remote.SungwooApi;
import com.sungwoo.aps.mobile.data.remote.SungwooService;
import com.sungwoo.aps.mobile.data.remote.SungwooApiImp;

import java.lang.reflect.Type;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmList;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {
    private final static int CONNECTION_TIMEOUT = 10;
    private final static int WRITE_TIMEOUT = 10;
    private final static int READ_TIMEOUT = 30;

    public NetworkModule(){
    }


    @Provides
    @Singleton
    Cache provideHttpCache(SungwooApplication application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        Type stringToken = new TypeToken<RealmList<RealmString>>() {
        }.getType();
        Type intToken = new TypeToken<RealmList<RealmInt>>() {
        }.getType();

        return new GsonBuilder()
//                .registerTypeAdapter(stringToken, RealmStringListTypeAdapter.INSTANCE)
//                .registerTypeAdapter(intToken, RealmIntListTypeAdapter.INSTANCE)
//                .registerTypeAdapter(accountToken, RealmAccountDeserialize.INSTANCE)
//                .registerTypeAdapter(brandToken, RealmBrandDeserialize.INSTANCE)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache, Context context) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                // bug: HTTP FAILED: java.io.IOException: unexpected end of stream on okhttp3.Address
                // References : https://github.com/square/okhttp/issues/2738
                .retryOnConnectionFailure(true);
//                .addInterceptor(new LanguageParamInterceptor())
//                .addInterceptor(new NetworkStatusInterceptor(context))
//                .addInterceptor(new AutoLoginInterceptor(context));

        if (BuildConfig.DEBUG) {
//            client.addNetworkInterceptor(new LoggingInterceptor().setLevel(LoggingInterceptor.Level.BODY))
//                    .addNetworkInterceptor(new StethoInterceptor());
        }
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
//        client.cookieJar(new JavaNetCookieJar(cookieManager));

        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.ikorn.vn/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }


    @Provides
    @Singleton
    SungwooApi provideSungwooApi(SungwooApiImp api) {
        return api;
    }

    @Provides
    @Singleton
    SungwooService provideSungwooService(Retrofit retrofit) {
        return retrofit.create(SungwooService.class);
    }

}
