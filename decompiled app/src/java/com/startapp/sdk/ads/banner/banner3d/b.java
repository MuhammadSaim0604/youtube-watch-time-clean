package com.startapp.sdk.ads.banner.banner3d;

import android.content.Context;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b extends com.startapp.sdk.json.a {
    private int g;

    public b(Context context, Banner3DAd banner3DAd, int i, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        super(context, banner3DAd, adPreferences, bVar, AdPreferences.Placement.INAPP_BANNER);
        this.g = 0;
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public final GetAdRequest a() {
        Banner3DAd banner3DAd = (Banner3DAd) this.b;
        com.startapp.sdk.ads.banner.a aVar = new com.startapp.sdk.ads.banner.a();
        b(aVar);
        aVar.e(BannerMetaData.a().b().f());
        aVar.f(this.g);
        aVar.a(banner3DAd.b_());
        aVar.a(this.a);
        return aVar;
    }

    @Override // com.startapp.sdk.json.a
    protected final void a(Ad ad) {
    }
}
