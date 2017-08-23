package com.sungwoo.aps.mobile.common.utils;

import android.widget.Toast;

/**
 * Ikorn Solutions Co.,Ltd ... on 23-Aug-17.
 * All rights reserved
 */

public interface ToastUtil {
    void showError(final String message);
    void showShortMessage(String message);
    Toast getToast(String message);
    Toast getToast(String message, int length);
}
