package com.startapp.sdk.ads.interstitials;

import android.content.Context;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class ReturnAd extends InterstitialAd {
    private static final long serialVersionUID = 1;

    public ReturnAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_RETURN);
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        new b(this.a, this, adPreferences, bVar).c();
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final long f() {
        return CacheMetaData.a().b().b();
    }
}
