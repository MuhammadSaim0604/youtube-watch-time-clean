package com.startapp.networkTest.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import com.startapp.networkTest.data.WifiInfo;
import com.startapp.networkTest.enums.WifiStates;
import com.startapp.networkTest.utils.i;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class d {
    private ConnectivityManager b;
    private Context d;
    private boolean c = false;
    private String e = "";
    private WifiStates a = WifiStates.Unknown;

    static {
        d.class.getSimpleName();
    }

    public d(Context context) {
        this.d = context.getApplicationContext();
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public final WifiInfo a() {
        WifiInfo wifiInfo = new WifiInfo();
        wifiInfo.MissingPermission = true;
        try {
            if (this.d.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == -1) {
                return wifiInfo;
            }
        } catch (Exception e) {
            new StringBuilder("getWifiInfo: ").append(e.getMessage());
        }
        return wifiInfo;
    }

    public final long b() {
        if (this.e.length() == 0) {
            a();
        }
        if (this.e.length() != 0) {
            return i.b(this.e);
        }
        return -1L;
    }

    public final long c() {
        if (this.e == null || this.e.length() == 0) {
            a();
        }
        if (this.e != null && this.e.length() != 0) {
            return i.a(this.e);
        }
        return -1L;
    }
}
