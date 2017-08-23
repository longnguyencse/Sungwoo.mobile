package com.sungwoo.aps.mobile.common.utils.implement;

import android.content.Context;
import android.widget.Toast;

import com.sungwoo.aps.mobile.common.utils.ToastUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Ikorn Solutions Co.,Ltd ... on 23-Aug-17.
 * All rights reserved
 */
@Singleton
public class ToastUtilImpl implements ToastUtil {
    final Context context;

    @Inject
    public ToastUtilImpl(Context context) {
        this.context = context;
    }

    @Override
    public void showError(String message) {
        getToast(message).show();
    }

    @Override
    public void showShortMessage(String message) {
        getToast(message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Toast getToast(String message) {
        return getToast(message, Toast.LENGTH_LONG);
    }

    @Override
    public Toast getToast(String message, int length) {
        return Toast.makeText(context, message, length);
    }
}
