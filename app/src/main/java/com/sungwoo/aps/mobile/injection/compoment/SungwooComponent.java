package com.sungwoo.aps.mobile.injection.compoment;

import com.sungwoo.aps.mobile.injection.PerActivity;
import com.sungwoo.aps.mobile.injection.module.ActivityModule;
import com.sungwoo.aps.mobile.ui.activity.SungwooActivity;

import dagger.Component;

/**
 * Ikorn Solutions Co.,Ltd ... on 21-Aug-17.
 * All rights reserved
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface SungwooComponent {
    void inject(SungwooActivity activity);
}
