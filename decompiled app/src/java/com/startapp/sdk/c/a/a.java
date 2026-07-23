package com.startapp.sdk.c.a;

import com.startapp.sdk.adsbase.j.u;
import java.util.Collection;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class a {
    protected static final a a = new a();
    private final String b;

    public final String a() {
        return this.b;
    }

    public a(Collection<String> collection) {
        this.b = u.a((Iterable) collection, ";");
    }

    private a() {
        this.b = null;
    }
}
