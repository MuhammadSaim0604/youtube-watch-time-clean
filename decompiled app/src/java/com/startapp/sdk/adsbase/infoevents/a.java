package com.startapp.sdk.adsbase.infoevents;

import com.startapp.common.SDKException;
import com.startapp.sdk.adsbase.j.i;
import com.startapp.sdk.adsbase.j.m;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a extends e {
    private String b;
    private String c;
    private boolean d;
    private String e;

    public a(InfoEventCategory infoEventCategory) {
        super(infoEventCategory);
    }

    @Override // com.startapp.sdk.adsbase.infoevents.e, com.startapp.sdk.adsbase.c
    public final m f() throws SDKException {
        m f = super.f();
        i iVar = f;
        if (f == null) {
            iVar = new i();
        }
        iVar.a("sens", this.b, false);
        iVar.a("bt", this.c, false);
        iVar.a("isService", Boolean.valueOf(this.d), false);
        iVar.a("packagingType", this.e, false);
        return iVar;
    }

    public final void c(String str) {
        if (str != null) {
            this.b = com.startapp.common.b.a.c(str);
        }
    }

    public final void d(String str) {
        if (str != null) {
            this.c = com.startapp.common.b.a.c(str);
        }
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void e(String str) {
        this.e = str;
    }

    @Override // com.startapp.sdk.adsbase.infoevents.e, com.startapp.sdk.adsbase.c
    public final String toString() {
        return super.toString() + " DataEventRequest [sensors=" + this.b + ", bluetooth=" + this.c + ", isService=" + this.d + ", packagingType=" + this.e + "]";
    }
}
