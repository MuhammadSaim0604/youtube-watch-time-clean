package com.startapp.sdk.ads.video.vast.model.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private String a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Integer f;
    private Integer g;
    private String h;
    private Integer i;
    private List<d> j;
    private String k;
    private List<String> l;
    private List<String> m;

    public final void a(String str) {
        this.a = str;
    }

    public final void a(Integer num) {
        this.b = num;
    }

    public final void b(Integer num) {
        this.c = num;
    }

    public final void c(Integer num) {
        this.d = num;
    }

    public final void d(Integer num) {
        this.e = num;
    }

    public final void e(Integer num) {
        this.f = num;
    }

    public final void f(Integer num) {
        this.g = num;
    }

    public final void b(String str) {
        this.h = str;
    }

    public final void g(Integer num) {
        this.i = num;
    }

    public final List<d> a() {
        if (this.j == null) {
            this.j = new ArrayList();
        }
        return this.j;
    }

    public final void c(String str) {
        this.k = str;
    }

    public final List<String> b() {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        return this.l;
    }

    public final List<String> c() {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        return this.m;
    }

    public final boolean d() {
        Integer num = this.c;
        Integer num2 = this.b;
        if (num != null && num2 != null) {
            if (num.intValue() > 0) {
                if (num2.intValue() > 0) {
                    Integer num3 = this.d;
                    Integer num4 = this.e;
                    if (num3 != null && num4 != null) {
                        if (num3.intValue() > 0) {
                            if (num4.intValue() > 0) {
                                if (a().size() == 0) {
                                    return false;
                                }
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
