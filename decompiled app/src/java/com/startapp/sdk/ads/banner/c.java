package com.startapp.sdk.ads.banner;

import android.graphics.Point;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class c {
    private Point a = new Point();

    public c() {
    }

    public c(int i, int i2) {
        a(i, i2);
    }

    private void a(int i) {
        this.a.x = i;
    }

    private void b(int i) {
        this.a.y = i;
    }

    public final void a(int i, int i2) {
        a(i);
        b(i2);
    }

    public final int a() {
        return this.a.x;
    }

    public final int b() {
        return this.a.y;
    }
}
