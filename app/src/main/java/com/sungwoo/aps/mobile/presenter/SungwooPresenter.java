package com.sungwoo.aps.mobile.presenter;

import com.sungwoo.aps.mobile.data.remote.SungwooApi;
import com.sungwoo.aps.mobile.data.remote.SungwooService;
import com.sungwoo.aps.mobile.injection.PerActivity;
import com.sungwoo.aps.mobile.ui.mvpview.SungwooMvpView;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Ikorn Solutions Co.,Ltd ... on 21-Aug-17.
 * All rights reserved
 */

public class SungwooPresenter implements Presenter {
    private final SungwooApi api;
    private SungwooMvpView view;

    @Inject
    public SungwooPresenter(SungwooApi sungwooService) {
        this.api = sungwooService;
    }
    public void setView(SungwooMvpView view) {
        this.view = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
