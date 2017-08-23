package com.sungwoo.aps.mobile.common.utils;

/**
 * Ikorn Solutions Co.,Ltd ... on 23-Aug-17.
 * All rights reserved
 */

public interface SharePrefsUtils {
    String getStringPreference(String key);
    boolean setStringPreference(String key, String value);
    float getFloatPreference(String key, float defaultValue);
    boolean setFloatPreference(String key, float value);
    long getLongPreference(String key, long defaultValue);
    boolean setLongPreference(String key, long value);
    int getIntegerPreference(String key, int defaultValue);
    boolean setIntegerPreference(String key, int value);
    boolean getBooleanPreference(String key, boolean defaultValue);
    boolean setBooleanPreference(String key, boolean value);
}
