package com.sungwoo.aps.mobile.injection.module;

import android.content.Context;

import com.sungwoo.aps.mobile.SungwooApplication;
import com.sungwoo.aps.mobile.common.utils.SharePrefsUtils;
import com.sungwoo.aps.mobile.common.utils.ToastUtil;
import com.sungwoo.aps.mobile.common.utils.implement.SharePrefsUtilsImpl;
import com.sungwoo.aps.mobile.common.utils.implement.ToastUtilImpl;

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

    @Provides
    @Singleton
    ToastUtilImpl provideToastUtilImpl(Context context) {
        return new ToastUtilImpl(context);
    }

    @Provides
    @Singleton
    ToastUtil provideToastUtil(ToastUtilImpl toastUtil) {
        return toastUtil;
    }

    @Provides
    @Singleton
    SharePrefsUtilsImpl provideSharePrefsUtilsImpl(Context context) {
        return new SharePrefsUtilsImpl(context);
    }

    @Provides
    @Singleton
    SharePrefsUtils provideSharePrefsUtils (SharePrefsUtilsImpl sharePrefsUtils) {
        return sharePrefsUtils;
    }
}
