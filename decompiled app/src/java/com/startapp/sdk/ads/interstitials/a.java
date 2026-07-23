package com.startapp.sdk.ads.interstitials;

import android.content.Context;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a extends com.startapp.sdk.d.a {
    public a(Context context, HtmlAd htmlAd, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        super(context, htmlAd, adPreferences, bVar, AdPreferences.Placement.INAPP_OVERLAY, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.d.a, com.startapp.sdk.adsbase.d
    public final void a(Boolean bool) {
        super.a(bool);
        a(bool.booleanValue());
    }
}
