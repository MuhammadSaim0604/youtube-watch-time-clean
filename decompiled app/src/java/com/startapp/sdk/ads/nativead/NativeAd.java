package com.startapp.sdk.ads.nativead;

import android.content.Context;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class NativeAd extends JsonAd {
    private static final long serialVersionUID = 1;
    private NativeAdPreferences config;

    public NativeAd(Context context, NativeAdPreferences nativeAdPreferences) {
        super(context, AdPreferences.Placement.INAPP_NATIVE);
        this.config = nativeAdPreferences;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        new a(this.a, this, adPreferences, bVar, this.config).c();
    }
}
