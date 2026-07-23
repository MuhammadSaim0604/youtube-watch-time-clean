package com.startapp.sdk.adsbase.mraid.b;

import java.util.Arrays;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private static final List<String> c = Arrays.asList("portrait", "landscape", "none");
    public boolean a;
    public int b;

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.a = true;
        this.b = 2;
    }

    public static int a(String str) {
        int indexOf = c.indexOf(str);
        if (indexOf != -1) {
            return indexOf;
        }
        return 2;
    }
}
