package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.f;
import com.startapp.sdk.adsbase.k;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class d extends c {
    public d(e eVar) {
        super(eVar);
    }

    @Override // com.startapp.sdk.adsbase.cache.c
    protected final boolean c() {
        return k.a().a(this.a.c());
    }

    @Override // com.startapp.sdk.adsbase.cache.c
    protected final long d() {
        f b = this.a.b();
        if (b == null) {
            return -1L;
        }
        Long c = b.c();
        Long b2 = b.b();
        if (c == null || b2 == null) {
            return -1L;
        }
        long longValue = c.longValue() - (System.currentTimeMillis() - b2.longValue());
        if (longValue >= 0) {
            return longValue;
        }
        return 0L;
    }

    @Override // com.startapp.sdk.adsbase.cache.c
    protected final String e() {
        return "CacheTTLReloadTimer";
    }
}
