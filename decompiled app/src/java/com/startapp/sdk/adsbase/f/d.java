package com.startapp.sdk.adsbase.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.startapp.sdk.adsbase.infoevents.b;
import com.startapp.sdk.adsbase.j.g;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class d {
    protected final SharedPreferences a;
    protected volatile boolean b;
    private final Context c;
    private final g<com.startapp.sdk.adsbase.remoteconfig.c> d;
    private final b.a e;

    static {
        d.class.getSimpleName();
    }

    public d(Context context, SharedPreferences sharedPreferences, g<com.startapp.sdk.adsbase.remoteconfig.c> gVar, b.a aVar) {
        this.c = context;
        this.a = sharedPreferences;
        this.d = gVar;
        this.e = aVar;
    }

    public final void a(boolean z, final com.startapp.common.d dVar) {
        com.startapp.sdk.adsbase.remoteconfig.c a = this.d.a();
        if (a == null) {
            return;
        }
        long a2 = a.a() * 60000;
        long j = a2;
        if (a2 < 10000) {
            j = 10000;
        }
        if ((this.a.getLong("6955cb8b653a5b89", 0L) + j <= System.currentTimeMillis() || z) && !this.b) {
            new com.startapp.sdk.adsbase.infoevents.b(this.c, z, new com.startapp.common.d() { // from class: com.startapp.sdk.adsbase.f.d.1
                @Override // com.startapp.common.d
                public final void a(Object obj) {
                    d.this.b = false;
                    if (Boolean.TRUE.equals(obj)) {
                        d.this.a.edit().putLong("6955cb8b653a5b89", System.currentTimeMillis()).commit();
                    }
                    if (dVar != null) {
                        dVar.a(obj);
                    }
                }
            }).a();
            this.b = true;
        }
    }
}
