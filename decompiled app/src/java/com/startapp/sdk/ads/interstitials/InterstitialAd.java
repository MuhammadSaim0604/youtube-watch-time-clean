package com.startapp.sdk.ads.interstitials;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.adsbase.activities.AppWallActivity;
import com.startapp.sdk.adsbase.activities.FullScreenActivity;
import com.startapp.sdk.adsbase.activities.OverlayActivity;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.f;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.b.c;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class InterstitialAd extends HtmlAd implements f {
    private static final long serialVersionUID = 1;

    public InterstitialAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
    }

    /* JADX WARN: Type inference failed for: r10v41, types: [java.lang.Boolean[], java.io.Serializable] */
    @Override // com.startapp.sdk.adsbase.f
    public final boolean a(String str) {
        boolean z;
        Class a;
        int i;
        String b = com.startapp.sdk.adsbase.a.b();
        if (a() && AdsCommonMetaData.a().I().a().equals(VideoConfig.BackMode.DISABLED) && b.equals("back")) {
            a(AdDisplayListener.NotDisplayedReason.VIDEO_BACK);
            return false;
        }
        if (!AdsConstants.b.booleanValue()) {
            setState(Ad.AdState.UN_INITIALIZED);
        }
        if (j() == null) {
            a(AdDisplayListener.NotDisplayedReason.INTERNAL_ERROR);
            return false;
        } else if (super.e_()) {
            a(AdDisplayListener.NotDisplayedReason.AD_EXPIRED);
            return false;
        } else {
            if (this.activityExtra != null) {
                z = this.activityExtra.a();
            } else {
                z = false;
            }
            boolean z2 = z;
            Context context = this.a;
            if (((r() != 0 && r() != this.a.getResources().getConfiguration().orientation) || a() || v() || b.equals("back")) && u.a(getContext(), (Class<? extends Activity>) FullScreenActivity.class)) {
                a = FullScreenActivity.class;
            } else {
                a = u.a(getContext(), OverlayActivity.class, AppWallActivity.class);
            }
            Intent intent = new Intent(context, a);
            intent.putExtra("fileUrl", "exit.html");
            String[] strArr = this.trackingUrls;
            String a2 = com.startapp.sdk.adsbase.a.a();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2] != null && !"".equals(strArr[i2])) {
                    strArr[i2] = strArr[i] + a2;
                }
            }
            intent.putExtra("tracking", strArr);
            intent.putExtra("trackingClickUrl", q());
            intent.putExtra("packageNames", s());
            intent.putExtra("htmlUuid", k());
            intent.putExtra("smartRedirect", this.smartRedirect);
            intent.putExtra("browserEnabled", this.inAppBrowserEnabled);
            intent.putExtra("placement", this.placement.a());
            intent.putExtra("adInfoOverride", getAdInfoOverride());
            intent.putExtra("ad", this);
            intent.putExtra("videoAd", a());
            intent.putExtra("fullscreen", z2);
            intent.putExtra("orientation", r() == 0 ? this.a.getResources().getConfiguration().orientation : r());
            intent.putExtra("adTag", str);
            intent.putExtra("lastLoadTime", super.b());
            intent.putExtra("adCacheTtl", super.c());
            intent.putExtra("closingUrl", m());
            intent.putExtra("rewardDuration", o());
            intent.putExtra("rewardedHideTimer", p());
            if (t() != null) {
                intent.putExtra("delayImpressionSeconds", t());
            }
            intent.putExtra("sendRedirectHops", (Serializable) u());
            intent.putExtra("mraidAd", v());
            if (v()) {
                intent.putExtra("activityShouldLockOrientation", false);
            }
            if (u.a(8L) && (this instanceof SplashAd)) {
                intent.putExtra("isSplash", true);
            }
            intent.putExtra("position", b);
            intent.addFlags(343932928);
            com.startapp.sdk.adsbase.consent.a f = c.a(this.a).f();
            if (!f.b()) {
                this.a.startActivity(intent);
            } else {
                f.a(intent);
            }
            return true;
        }
    }

    protected boolean a() {
        return false;
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final Long b() {
        return super.b();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final Long c() {
        return super.c();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final boolean e_() {
        return super.e_();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final boolean e() {
        return super.e();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final void a(boolean z) {
        super.a(z);
    }
}
