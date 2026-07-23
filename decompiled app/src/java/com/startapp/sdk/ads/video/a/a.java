package com.startapp.sdk.ads.video.a;

import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private List<String> a;
    private String b;

    public a(List<String> list, String str) {
        this.a = list;
        this.b = str;
    }

    public final List<String> a() {
        return this.a;
    }

    public final String toString() {
        return "[VideoEvent: tag=" + this.b + ", fullUrls=" + this.a.toString() + "]";
    }
}
