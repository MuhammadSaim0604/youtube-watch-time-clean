package com.startapp.sdk.adsbase.f;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class c extends a {
    public c(Context context, Runnable runnable, com.startapp.sdk.adsbase.infoevents.a aVar) {
        super(context, runnable, aVar);
    }

    @Override // com.startapp.sdk.adsbase.f.a
    protected final void b() {
        try {
            long millis = TimeUnit.SECONDS.toMillis(MetaData.E().A().a());
            final com.startapp.sdk.adsbase.h.b bVar = new com.startapp.sdk.adsbase.h.b(this.a, this);
            a(new Runnable() { // from class: com.startapp.sdk.adsbase.f.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    bVar.b();
                    c.this.a(bVar.c());
                }
            }, millis);
            bVar.a();
        } catch (Exception e) {
            a(null);
        }
    }

    @Override // com.startapp.sdk.adsbase.f.a, com.startapp.common.d
    public final void a(Object obj) {
        if (obj != null) {
            this.b.c(obj.toString());
        }
        super.a(obj);
    }
}
