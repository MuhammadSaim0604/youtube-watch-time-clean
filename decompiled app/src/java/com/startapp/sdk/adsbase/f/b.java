package com.startapp.sdk.adsbase.f;

import android.content.Context;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class b extends a {
    static {
        b.class.getSimpleName();
    }

    public b(Context context, Runnable runnable, com.startapp.sdk.adsbase.infoevents.a aVar) {
        super(context, runnable, aVar);
    }

    @Override // com.startapp.sdk.adsbase.f.a
    protected final void b() {
        try {
            long millis = TimeUnit.SECONDS.toMillis(MetaData.E().B().a());
            final com.startapp.sdk.adsbase.b.b bVar = new com.startapp.sdk.adsbase.b.b(this.a, this);
            a(new Runnable() { // from class: com.startapp.sdk.adsbase.f.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    bVar.a();
                    b.this.a(bVar.b());
                }
            }, millis);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = currentTimeMillis - j.a(this.a, "lastBtDiscoveringTime", (Long) 0L).longValue() >= ((long) MetaData.E().B().b()) * 60000;
            if (z) {
                j.b(this.a, "lastBtDiscoveringTime", Long.valueOf(currentTimeMillis));
            }
            bVar.a(z);
        } catch (Throwable th) {
            new e(th).a(this.a);
            a(null);
        }
    }

    @Override // com.startapp.sdk.adsbase.f.a, com.startapp.common.d
    public final void a(Object obj) {
        if (obj != null) {
            this.b.d(obj.toString());
        }
        super.a(obj);
    }
}
