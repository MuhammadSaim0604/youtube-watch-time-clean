package com.startapp.sdk.ads.nativead;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a extends com.startapp.sdk.json.a {
    private NativeAdPreferences g;

    public a(Context context, Ad ad, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar, NativeAdPreferences nativeAdPreferences) {
        super(context, ad, adPreferences, bVar, AdPreferences.Placement.INAPP_NATIVE);
        this.g = nativeAdPreferences;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public final GetAdRequest a() {
        GetAdRequest a = super.a();
        if (a == null) {
            return null;
        }
        a.e(this.g.getAdsNumber());
        if (this.g.getImageSize() != null) {
            a.c(this.g.getImageSize().getWidth());
            a.d(this.g.getImageSize().getHeight());
        } else {
            int primaryImageSize = this.g.getPrimaryImageSize();
            int i = primaryImageSize;
            if (primaryImageSize == -1) {
                i = 2;
            }
            a.c(Integer.toString(i));
            int secondaryImageSize = this.g.getSecondaryImageSize();
            int i2 = secondaryImageSize;
            if (secondaryImageSize == -1) {
                i2 = 2;
            }
            a.d(Integer.toString(i2));
        }
        if (this.g.isContentAd()) {
            a.b(this.g.isContentAd());
        }
        return a;
    }

    @Override // com.startapp.sdk.json.a
    protected final void a(Ad ad) {
    }
}
