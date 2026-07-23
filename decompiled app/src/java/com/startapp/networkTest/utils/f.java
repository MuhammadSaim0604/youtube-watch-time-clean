package com.startapp.networkTest.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class f {
    static {
        f.class.getSimpleName();
    }

    public static String a(String str) {
        String str2 = "";
        String str3 = null;
        try {
            str3 = InetAddress.getByName(str).getCanonicalHostName();
        } catch (UnknownHostException e) {
            new StringBuilder("serverResult: ").append(e.toString());
        }
        if (str3 != null && !str3.equals(str) && str3.contains("cloudfront")) {
            String[] split = str3.split("\\.");
            if (split.length > 0) {
                str2 = b(split[1]);
            }
        }
        return str2;
    }

    public static String b(String str) {
        return (str == null || str.length() <= 2) ? "" : str.substring(0, 3);
    }
}
