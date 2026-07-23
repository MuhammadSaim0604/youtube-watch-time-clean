package com.startapp.sdk.ads.splash;

import android.content.Context;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class SplashAd extends InterstitialAd {
    private static final long serialVersionUID = 1;

    public SplashAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OVERLAY);
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    @Deprecated
    public boolean load(AdPreferences adPreferences, AdEventListener adEventListener) {
        return super.load(adPreferences, com.startapp.sdk.adsbase.adlisteners.b.a(this.a, adEventListener), false);
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        new a(this.a, this, adPreferences, bVar).c();
    }
}
