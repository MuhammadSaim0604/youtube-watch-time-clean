package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.k;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b extends c {
    private final FailuresHandler b;
    private int c;
    private boolean d;

    public b(e eVar) {
        super(eVar);
        this.b = CacheMetaData.a().b().f();
        this.c = 0;
        this.d = false;
    }

    @Override // com.startapp.sdk.adsbase.cache.c
    public final void a() {
        super.a();
        this.c = 0;
        this.d = false;
    }

    @Override // com.startapp.sdk.adsbase.cache.c
    protected final void b() {
        if (this.c == this.b.a().size() - 1) {
            this.d = true;
            new StringBuilder("Reached end index: ").append(this.c);
        } else {
            this.c++;
            new StringBuilder("Advanced to index: ").append(this.c);
        }
        super.b();
    }

    @Override // com.startapp.sdk.adsbase.cache.c
    protected final boolean c() {
        if (!k.a().l()) {
            return false;
        }
        if (!((this.b == null || this.b.a() == null) ? false : true)) {
            return false;
        }
        if (this.d) {
            return this.b.b();
        }
        return true;
    }

    @Override // com.startapp.sdk.adsbase.cache.c
    protected final long d() {
        Long i;
        if (this.c < this.b.a().size() && (i = i()) != null) {
            long millis = TimeUnit.SECONDS.toMillis(this.b.a().get(this.c).intValue()) - (System.currentTimeMillis() - i.longValue());
            if (millis >= 0) {
                return millis;
            }
            return 0L;
        }
        return -1L;
    }

    @Override // com.startapp.sdk.adsbase.cache.c
    protected final String e() {
        return "CacheErrorReloadTimer";
    }
}
