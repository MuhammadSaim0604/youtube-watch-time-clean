package com.startapp.sdk.ads.offerWall.offerWallHtml;

import android.content.Context;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.adlisteners.b;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class OfferWallAd extends InterstitialAd {
    private static final long serialVersionUID = 1;

    public OfferWallAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OFFER_WALL);
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, b bVar) {
        new a(this.a, this, adPreferences, bVar).c();
    }
}
