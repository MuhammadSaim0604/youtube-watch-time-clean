package com.startapp.sdk.ads.banner.bannerstandard;

import android.content.Context;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class BannerStandardAd extends HtmlAd {
    private static final long serialVersionUID = 1;
    private int bannerType;
    private boolean fixedSize;
    private int offset;

    public BannerStandardAd(Context context, int i) {
        super(context, AdPreferences.Placement.INAPP_BANNER);
        this.offset = 0;
        this.offset = i;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        new a(this.a, this, this.offset, adPreferences, bVar).c();
        this.offset++;
    }

    public final int a() {
        return this.offset;
    }

    public final void c_() {
        this.fixedSize = true;
    }

    public final boolean d_() {
        return this.fixedSize;
    }

    public final int d() {
        return this.bannerType;
    }

    public final void a(int i) {
        this.bannerType = i;
    }
}
