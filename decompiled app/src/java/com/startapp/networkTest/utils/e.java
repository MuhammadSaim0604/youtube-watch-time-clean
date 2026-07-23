package com.startapp.networkTest.utils;

import android.content.Context;
import java.net.URL;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class e {
    private final String a;
    private final URL b;
    private final String c;

    public static boolean a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    private e(String str, URL url, String str2) {
        this.a = str;
        this.b = url;
        this.c = str2;
    }

    public static e a(String str, URL url, String str2) {
        com.iab.omid.library.startapp.b.b(str, "VendorKey is null or empty");
        com.iab.omid.library.startapp.b.a(url, "ResourceURL is null");
        com.iab.omid.library.startapp.b.b(str2, "VerificationParameters is null or empty");
        return new e(str, url, str2);
    }

    public final String a() {
        return this.a;
    }

    public final URL b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
