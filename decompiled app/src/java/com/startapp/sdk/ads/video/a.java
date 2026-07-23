package com.startapp.sdk.ads.video;

import android.content.Context;
import android.util.Pair;
import com.startapp.common.SDKException;
import com.startapp.sdk.ads.video.VideoUtil;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.j.k;
import com.startapp.sdk.adsbase.j.m;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a extends GetAdRequest {
    private GetAdRequest.VideoRequestType c;
    private GetAdRequest.VideoRequestMode d = GetAdRequest.VideoRequestMode.INTERSTITIAL;

    @Override // com.startapp.sdk.adsbase.model.GetAdRequest
    public final void a(Context context, AdPreferences adPreferences, AdPreferences.Placement placement, Pair<String, String> pair) {
        super.a(context, adPreferences, placement, pair);
        if (k() != null) {
            if (k() != Ad.AdType.NON_VIDEO) {
                if (k() == Ad.AdType.VIDEO_NO_VAST) {
                    this.c = GetAdRequest.VideoRequestType.FORCED_NONVAST;
                } else if (j()) {
                    this.c = GetAdRequest.VideoRequestType.FORCED;
                }
            }
            this.c = GetAdRequest.VideoRequestType.DISABLED;
        } else {
            if (VideoUtil.a(context) == VideoUtil.VideoEligibility.ELIGIBLE) {
                if (!u.a(2L)) {
                    this.c = GetAdRequest.VideoRequestType.FORCED;
                } else {
                    this.c = GetAdRequest.VideoRequestType.ENABLED;
                }
            }
            this.c = GetAdRequest.VideoRequestType.DISABLED;
        }
        if (k() == Ad.AdType.REWARDED_VIDEO) {
            this.d = GetAdRequest.VideoRequestMode.REWARDED;
        }
        if (k() != Ad.AdType.VIDEO) {
            return;
        }
        this.d = GetAdRequest.VideoRequestMode.INTERSTITIAL;
    }

    @Override // com.startapp.sdk.adsbase.model.GetAdRequest, com.startapp.sdk.adsbase.c
    public final m a() throws SDKException {
        m a = super.a();
        k kVar = a;
        if (a == null) {
            kVar = new k();
        }
        kVar.a("video", this.c, false);
        kVar.a("videoMode", this.d, false);
        return kVar;
    }
}
