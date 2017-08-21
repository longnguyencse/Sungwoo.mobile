package com.sungwoo.aps.mobile.injection.compoment;

import android.app.Activity;

import com.sungwoo.aps.mobile.injection.PerActivity;
import com.sungwoo.aps.mobile.injection.module.ActivityModule;

import dagger.Component;

/**
 * Ikorn Solutions Co.,Ltd ... on 21-Aug-17.
 * All rights reserved
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
