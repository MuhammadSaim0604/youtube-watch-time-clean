package com.startapp.sdk.ads.banner.banner3d;

import android.content.Context;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class Banner3DAd extends JsonAd {
    private static final long serialVersionUID = 1;
    private boolean fixedSize;
    private int offset;

    public Banner3DAd(Context context, int i) {
        super(context, AdPreferences.Placement.INAPP_BANNER);
        this.offset = i;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        new b(this.a, this, this.offset, adPreferences, bVar).c();
        this.offset++;
    }

    public final int a() {
        return this.offset;
    }

    public final void a_() {
        this.fixedSize = true;
    }

    public final boolean b_() {
        return this.fixedSize;
    }
}
