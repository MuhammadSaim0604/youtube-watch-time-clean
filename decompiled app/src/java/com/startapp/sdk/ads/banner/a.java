package com.startapp.sdk.ads.banner;

import android.content.Context;
import com.startapp.common.SDKException;
import com.startapp.sdk.adsbase.j.k;
import com.startapp.sdk.adsbase.j.m;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a extends GetAdRequest {
    private boolean c;
    private int d;

    public final void a(boolean z) {
        this.c = z;
    }

    public final void a(int i) {
        this.d = i;
    }

    @Override // com.startapp.sdk.adsbase.model.GetAdRequest, com.startapp.sdk.adsbase.c
    public final m a() throws SDKException {
        m a = super.a();
        k kVar = a;
        if (a == null) {
            kVar = new k();
        }
        m mVar = kVar;
        mVar.a("fixedSize", Boolean.valueOf(this.c), false);
        mVar.a("bnrt", Integer.valueOf(this.d), false);
        return kVar;
    }

    @Override // com.startapp.sdk.adsbase.model.GetAdRequest
    public final void a(Context context) {
        this.b = com.startapp.sdk.b.c.a(context).h().a(g(), this.d);
    }
}
