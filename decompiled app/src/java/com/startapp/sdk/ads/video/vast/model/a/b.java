package com.startapp.sdk.ads.video.vast.model.a;

import android.text.TextUtils;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    private String a;
    private String b;
    private String c;
    private String d;
    private Integer e;
    private Integer f;
    private Integer g;
    private Boolean h;
    private Boolean i;
    private String j;

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final String b() {
        return this.d;
    }

    public final void d(String str) {
        this.d = str;
    }

    public final Integer c() {
        return this.e;
    }

    public final void a(Integer num) {
        this.e = num;
    }

    public final Integer d() {
        return this.f;
    }

    public final void b(Integer num) {
        this.f = num;
    }

    public final Integer e() {
        return this.g;
    }

    public final void c(Integer num) {
        this.g = num;
    }

    public final void a(Boolean bool) {
        this.h = bool;
    }

    public final void b(Boolean bool) {
        this.i = bool;
    }

    public final void e(String str) {
        this.j = str;
    }

    public final boolean f() {
        if (TextUtils.isEmpty(this.d)) {
            return false;
        }
        Integer num = this.g;
        Integer num2 = this.f;
        if (num == null || num2 == null || !a(num.intValue()) || !a(num2.intValue())) {
            return false;
        }
        if (TextUtils.isEmpty(this.a)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "MediaFile [url=" + this.a + ", id=" + this.b + ", delivery=" + this.c + ", type=" + this.d + ", bitrate=" + this.e + ", width=" + this.f + ", height=" + this.g + ", scalable=" + this.h + ", maintainAspectRatio=" + this.i + ", apiFramework=" + this.j + "]";
    }

    private static boolean a(int i) {
        return i > 0 && i < 5000;
    }
}
