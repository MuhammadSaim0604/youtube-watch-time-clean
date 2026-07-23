package com.startapp.sdk.ads.video;

import android.content.Context;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class VideoEnabledAd extends InterstitialAd {
    private static final long serialVersionUID = 1;
    private VideoAdDetails videoAdDetails;

    public VideoEnabledAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OVERLAY);
        this.videoAdDetails = null;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        new b(this.a, this, adPreferences, bVar).c();
    }

    @Override // com.startapp.sdk.adsbase.HtmlAd
    public final void b(String str) {
        super.b(str);
        String a = u.a(str, "@videoJson@", "@videoJson@");
        if (a == null) {
            return;
        }
        this.videoAdDetails = (VideoAdDetails) com.startapp.common.parser.b.a(a, VideoAdDetails.class);
    }

    @Override // com.startapp.sdk.ads.interstitials.InterstitialAd
    protected final boolean a() {
        return this.videoAdDetails != null;
    }

    public final VideoAdDetails g() {
        return this.videoAdDetails;
    }

    public final void a(com.startapp.sdk.ads.video.vast.model.c cVar, boolean z) {
        if (cVar != null) {
            this.videoAdDetails = new VideoAdDetails(cVar, z);
            com.startapp.sdk.ads.video.vast.model.a.b f = cVar.f();
            if (f != null) {
                if (f.d().intValue() > f.e().intValue()) {
                    a(SplashConfig.Orientation.LANDSCAPE);
                } else {
                    a(SplashConfig.Orientation.PORTRAIT);
                }
            }
        }
    }

    public final void h() {
        this.videoAdDetails = null;
    }
}
