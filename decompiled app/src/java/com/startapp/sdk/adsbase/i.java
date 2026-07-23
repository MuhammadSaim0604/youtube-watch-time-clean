package com.startapp.sdk.adsbase;

import android.content.Context;
import android.os.Build;
import com.startapp.common.SDKException;
import com.startapp.sdk.adsbase.j.m;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class i extends c {
    private com.startapp.sdk.adsbase.g.b b;
    private String c;

    public i(Context context) {
        super(1);
        this.b = com.startapp.sdk.adsbase.g.a.a(context);
        this.c = com.startapp.common.b.b.j(context);
    }

    @Override // com.startapp.sdk.adsbase.c
    public final m a() throws SDKException {
        m a = super.a();
        com.startapp.sdk.adsbase.j.k kVar = a;
        if (a == null) {
            kVar = new com.startapp.sdk.adsbase.j.k();
        }
        kVar.a("placement", "INAPP_DOWNLOAD", true);
        if (this.b != null) {
            kVar.a("install_referrer", this.b.a(), true);
            kVar.a("referrer_click_timestamp_seconds", Long.valueOf(this.b.b()), true);
            kVar.a("install_begin_timestamp_seconds", Long.valueOf(this.b.c()), true);
        }
        kVar.a("apkSig", this.c, true);
        if (Build.VERSION.SDK_INT >= 9) {
            long a2 = SimpleTokenUtils.a();
            if (a2 != 0) {
                kVar.a("firstInstalledAppTS", Long.valueOf(a2), false);
            }
        }
        return kVar;
    }
}
