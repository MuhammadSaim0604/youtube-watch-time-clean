package com.startapp.networkTest.utils;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class h {
    static {
        h.class.getSimpleName();
    }

    public static String a(String str) {
        if (str != null) {
            return str.replaceAll("[\u0000-\u001f]", "").trim();
        }
        return "";
    }
}
