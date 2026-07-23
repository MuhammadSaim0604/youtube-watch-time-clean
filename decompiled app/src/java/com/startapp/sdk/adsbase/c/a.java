package com.startapp.sdk.adsbase.c;

import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.u;
import java.io.File;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
class a implements com.startapp.sdk.adsbase.infoevents.c {
    static {
        a.class.getSimpleName();
    }

    @Override // com.startapp.sdk.adsbase.infoevents.c
    public final void a(e eVar, boolean z) {
        if (z) {
            Object l = eVar.l();
            if (l instanceof File) {
                u.d((File) l);
            }
        }
    }

    @Override // com.startapp.sdk.adsbase.infoevents.c
    public final void a() {
    }
}
