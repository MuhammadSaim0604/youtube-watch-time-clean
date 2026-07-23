package com.startapp.b.a.h;

import java.util.HashMap;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c {
    private final Map<a, b> a = new HashMap();

    public c() {
        this.a.put(a.ZERO, new g());
        this.a.put(a.THREE, new f());
        this.a.put(a.FOUR, new e());
        this.a.put(a.FIVE, new d());
    }

    public final com.startapp.b.a.a.a a(a aVar) {
        return this.a.get(aVar).b();
    }

    public final com.startapp.b.a.d.c b(a aVar) {
        return this.a.get(aVar).a();
    }
}
