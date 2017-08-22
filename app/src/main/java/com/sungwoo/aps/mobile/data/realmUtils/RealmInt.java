package com.sungwoo.aps.mobile.data.realmUtils;

import org.parceler.Parcel;

import io.realm.RealmIntRealmProxy;
import io.realm.RealmObject;

@Parcel(implementations = {RealmIntRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {RealmInt.class})
public class RealmInt extends RealmObject {
    public int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
