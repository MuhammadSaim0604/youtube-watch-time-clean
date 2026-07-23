package com.startapp.sdk.ads.interstitials;

import android.content.Context;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class OverlayAd extends InterstitialAd {
    private static final long serialVersionUID = 1;

    public OverlayAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OVERLAY);
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        new a(this.a, this, adPreferences, bVar).c();
    }
}
