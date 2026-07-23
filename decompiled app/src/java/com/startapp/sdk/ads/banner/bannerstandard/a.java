package com.startapp.sdk.ads.banner.bannerstandard;

import android.content.Context;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a extends com.startapp.sdk.d.a {
    private int i;

    public a(Context context, HtmlAd htmlAd, int i, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        super(context, htmlAd, adPreferences, bVar, AdPreferences.Placement.INAPP_BANNER, false);
        this.i = 0;
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public final GetAdRequest a() {
        BannerStandardAd bannerStandardAd = (BannerStandardAd) this.b;
        com.startapp.sdk.ads.banner.a aVar = new com.startapp.sdk.ads.banner.a();
        b(aVar);
        aVar.c(bannerStandardAd.l());
        aVar.d(bannerStandardAd.n());
        aVar.f(this.i);
        aVar.e(BannerMetaData.a().b().g());
        aVar.a(bannerStandardAd.d_());
        aVar.a(bannerStandardAd.d());
        aVar.a(this.a);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.d.a, com.startapp.sdk.adsbase.d
    public final void a(Boolean bool) {
        super.a(bool);
        a(bool.booleanValue());
        new StringBuilder("Html onPostExecute, result=[").append(bool).append("]");
    }
}
