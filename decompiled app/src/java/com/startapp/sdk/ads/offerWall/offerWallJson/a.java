package com.startapp.sdk.ads.offerWall.offerWallJson;

import android.content.Context;
import com.startapp.sdk.ads.list3d.f;
import com.startapp.sdk.ads.list3d.g;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.adlisteners.b;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a extends com.startapp.sdk.json.a {
    public a(Context context, OfferWall3DAd offerWall3DAd, AdPreferences adPreferences, b bVar) {
        super(context, offerWall3DAd, adPreferences, bVar, AdPreferences.Placement.INAPP_OFFER_WALL);
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

    @Override // com.startapp.sdk.json.a
    protected final void a(Ad ad) {
        OfferWall3DAd offerWall3DAd = (OfferWall3DAd) ad;
        List<AdDetails> g = offerWall3DAd.g();
        f a = g.a().a(offerWall3DAd.a());
        a.a();
        if (g != null) {
            for (AdDetails adDetails : g) {
                a.a(adDetails);
            }
        }
    }
}
