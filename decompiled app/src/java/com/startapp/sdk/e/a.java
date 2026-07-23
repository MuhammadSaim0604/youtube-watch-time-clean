package com.startapp.sdk.e;

import android.content.SharedPreferences;
import java.util.UUID;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class a {
    private final SharedPreferences a;
    private volatile String b;

    public a(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public final String a() {
        String str = this.b;
        String str2 = str;
        if (str == null) {
            synchronized (this) {
                String str3 = this.b;
                str2 = str3;
                if (str3 == null) {
                    String string = this.a.getString("e695c6d894060903", null);
                    str2 = string;
                    if (string == null) {
                        str2 = UUID.randomUUID().toString();
                        if (!this.a.edit().putString("e695c6d894060903", str2).commit()) {
                            str2 = "00000000-0000-0000-0000-000000000000";
                        }
                    }
                    this.b = str2;
                }
            }
        }
        return str2;
    }
}
