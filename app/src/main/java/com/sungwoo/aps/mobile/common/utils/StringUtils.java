package com.sungwoo.aps.mobile.common.utils;

/**
 * Ikorn Solutions Co.,Ltd ... on 23-Aug-17.
 * All rights reserved
 */

public final class StringUtils {
    public static boolean isNoBlank(String string) {
        if (null == string) {
            return true;
        }
        if (string.isEmpty()) {
            return true;
        }
        return false;
    }
}
