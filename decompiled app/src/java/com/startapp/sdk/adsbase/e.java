package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class e {
    protected StartAppAd a;
    private boolean b;
    private AutoInterstitialPreferences c;
    private long d;
    private int e;

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        this.b = false;
        this.c = null;
        this.d = -1L;
        this.e = -1;
        this.a = null;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    static class a {
        private static final e a = new e((byte) 0);

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ e a() {
            return a;
        }
    }

    public final void a() {
        this.b = true;
    }

    public final void b() {
        this.b = false;
    }

    public final void a(AutoInterstitialPreferences autoInterstitialPreferences) {
        this.c = autoInterstitialPreferences;
        this.d = -1L;
        this.e = -1;
    }

    protected final void c() {
        this.d = System.currentTimeMillis();
        this.e = 0;
    }

    public final void a(Activity activity, Bundle bundle) {
        boolean equals = activity.getClass().getName().equals(u.b((Context) activity));
        if (bundle != null) {
            return;
        }
        String name = activity.getClass().getName();
        if (!(name.startsWith(new StringBuilder().append("com.startapp.sdk.").append("adsbase.activities.OverlayActivity").toString()) || name.startsWith(new StringBuilder().append("com.startapp.sdk.").append("adsbase.activities.FullScreenActivity").toString()) || name.startsWith(new StringBuilder().append("com.startapp.sdk.").append("ads.list3d.List3DActivity").toString())) && !equals) {
            this.e++;
            if (!(this.b && AdsCommonMetaData.a().J())) {
                return;
            }
            if (this.c == null) {
                this.c = new AutoInterstitialPreferences();
            }
            if (!(((this.d > 0L ? 1 : (this.d == 0L ? 0 : -1)) <= 0 || (System.currentTimeMillis() > (this.d + ((long) (this.c.getSecondsBetweenAds() * 1000))) ? 1 : (System.currentTimeMillis() == (this.d + ((long) (this.c.getSecondsBetweenAds() * 1000))) ? 0 : -1)) >= 0) && (this.e <= 0 || this.e >= this.c.getActivitiesBetweenAds()))) {
                return;
            }
            if (this.a == null) {
                this.a = new StartAppAd(activity);
            }
            this.a.loadAd(StartAppAd.AdMode.AUTOMATIC, new AdPreferences().setAi(Boolean.TRUE), new AdEventListener() { // from class: com.startapp.sdk.adsbase.e.1
                @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
                public final void onReceiveAd(Ad ad) {
                    if (e.this.a.showAd()) {
                        e.this.c();
                    }
                }

                @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
                public final void onFailedToReceiveAd(Ad ad) {
                    new StringBuilder("FailedToShowInterActivityAd, error: [").append(ad.errorMessage).append("]");
                }
            });
        }
    }
}
