package com.startapp.sdk.adsbase;

import android.content.SharedPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    private final Object a = new Object();
    private final SharedPreferences b;
    private volatile String c;
    private volatile String d;

    public b(SharedPreferences sharedPreferences) {
        this.b = sharedPreferences;
    }

    public final void a(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (str3 != null) {
            str3 = str3.trim();
        }
        if (str4 != null) {
            str4 = str4.trim();
        }
        synchronized (this.a) {
            this.c = str3;
            this.d = str4;
            this.b.edit().putString("c88d4eab540fab77", str3).putString("2696a7f502faed4b", str4).commit();
        }
    }

    public final String a() {
        String str = this.c;
        String str2 = str;
        if (str == null) {
            synchronized (this.a) {
                String str3 = this.c;
                str2 = str3;
                if (str3 == null) {
                    str2 = this.b.getString("c88d4eab540fab77", null);
                }
            }
        }
        return str2;
    }

    public final String b() {
        String str = this.d;
        String str2 = str;
        if (str == null) {
            synchronized (this.a) {
                String str3 = this.d;
                str2 = str3;
                if (str3 == null) {
                    str2 = this.b.getString("2696a7f502faed4b", null);
                }
            }
        }
        return str2;
    }
}
