package com.startapp.sdk.ads.offerWall.offerWallHtml;

import android.content.Context;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.adlisteners.b;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a extends com.startapp.sdk.d.a {
    public a(Context context, OfferWallAd offerWallAd, AdPreferences adPreferences, b bVar) {
        super(context, offerWallAd, adPreferences, bVar, AdPreferences.Placement.INAPP_OFFER_WALL, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public final GetAdRequest a() {
        GetAdRequest a = super.a();
        if (a == null) {
            return null;
        }
        a.e(AdsCommonMetaData.a().g());
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.d.a, com.startapp.sdk.adsbase.d
    public final void a(Boolean bool) {
        super.a(bool);
        a(bool.booleanValue());
    }
}
