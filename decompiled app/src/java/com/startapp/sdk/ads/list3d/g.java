package com.startapp.sdk.ads.list3d;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class g {
    private static g a = new g();
    private Map<String, f> b = new ConcurrentHashMap();

    private g() {
    }

    public static g a() {
        return a;
    }

    public final f a(String str) {
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        f fVar = new f();
        this.b.put(str, fVar);
        new StringBuilder("Created new model for uuid ").append(str).append(", Size = ").append(this.b.size());
        return fVar;
    }

    public final void b(String str) {
        this.b.remove(str);
        new StringBuilder("Model for ").append(str).append(" was removed, Size = ").append(this.b.size());
    }
}
