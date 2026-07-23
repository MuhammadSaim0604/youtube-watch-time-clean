package com.startapp.sdk.ads.video.vast.model.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class e {
    private String a;
    private List<String> b;
    private List<String> c;

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final List<String> b() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        return this.b;
    }

    public final List<String> c() {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        return this.c;
    }

    public final String toString() {
        return "VASTVideoClicks [clickThrough=" + this.a + ", clickTracking=[" + this.b + "], customClick=[" + this.c + "] ]";
    }
}
