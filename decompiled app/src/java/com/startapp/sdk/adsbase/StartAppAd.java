package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashHideListener;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.activities.AppWallActivity;
import com.startapp.sdk.adsbase.activities.OverlayActivity;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class StartAppAd extends Ad {
    private static final long serialVersionUID = 1;
    public f ad;
    private CacheKey adKey;
    private AdMode adMode;
    private AdPreferences adPreferences;
    AdDisplayListener callback;
    private BroadcastReceiver callbackBroadcastReceiver;
    VideoListener videoListener;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum AdMode {
        AUTOMATIC,
        FULLPAGE,
        OFFERWALL,
        REWARDED_VIDEO,
        VIDEO,
        OVERLAY
    }

    public StartAppAd(Context context) {
        super(context, null);
        this.adKey = null;
        this.ad = null;
        this.adMode = AdMode.AUTOMATIC;
        this.adPreferences = null;
        this.videoListener = null;
        this.callback = null;
        this.callbackBroadcastReceiver = new BroadcastReceiver() { // from class: com.startapp.sdk.adsbase.StartAppAd.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                String str = action;
                if (action == null) {
                    str = "";
                }
                if (str.equals("com.startapp.android.ShowFailedDisplayBroadcastListener")) {
                    Bundle extras = intent.getExtras();
                    Bundle bundle = extras;
                    if (extras == null) {
                        bundle = Bundle.EMPTY;
                    }
                    if (bundle.containsKey("showFailedReason")) {
                        StartAppAd.this.a((AdDisplayListener.NotDisplayedReason) bundle.getSerializable("showFailedReason"));
                    }
                    if (StartAppAd.this.callback != null) {
                        StartAppAd.this.callback.adNotDisplayed(StartAppAd.this);
                    }
                    a(context2);
                } else if (str.equals("com.startapp.android.ShowDisplayBroadcastListener")) {
                    if (StartAppAd.this.callback != null) {
                        StartAppAd.this.callback.adDisplayed(StartAppAd.this);
                    }
                } else if (str.equals("com.startapp.android.OnClickCallback")) {
                    if (StartAppAd.this.callback != null) {
                        StartAppAd.this.callback.adClicked(StartAppAd.this);
                    }
                } else if (str.equals("com.startapp.android.OnVideoCompleted")) {
                    if (StartAppAd.this.videoListener != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.StartAppAd.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                StartAppAd.this.videoListener.onVideoCompleted();
                            }
                        });
                    }
                } else {
                    if (StartAppAd.this.callback != null) {
                        StartAppAd.this.callback.adHidden(StartAppAd.this);
                    }
                    a(context2);
                }
                StartAppAd.this.ad = null;
            }

            private void a(Context context2) {
                com.startapp.common.b.a(context2).a(this);
            }
        };
    }

    public static void init(Context context, String str, String str2) {
        StartAppSDK.init(context, str, str2);
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x020c  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean show(java.lang.String r15, com.startapp.sdk.adsbase.adlisteners.AdDisplayListener r16) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppAd.show(java.lang.String, com.startapp.sdk.adsbase.adlisteners.AdDisplayListener):boolean");
    }

    protected AdRulesResult a(String str, AdPreferences.Placement placement) {
        return AdsCommonMetaData.a().G().a(placement, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.Ad
    public final AdPreferences.Placement i() {
        AdPreferences.Placement i = super.i();
        AdPreferences.Placement placement = i;
        if (i == null && this.adKey != null && com.startapp.sdk.adsbase.cache.a.a().b(this.adKey) != null) {
            placement = ((Ad) com.startapp.sdk.adsbase.cache.a.a().b(this.adKey)).i();
        }
        return placement;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public String getAdId() {
        f b = com.startapp.sdk.adsbase.cache.a.a().b(this.adKey);
        if (b instanceof HtmlAd) {
            return ((HtmlAd) b).getAdId();
        }
        return null;
    }

    private void a(String str) {
        com.startapp.common.b.a(this.a).a(this.callbackBroadcastReceiver, new IntentFilter(str));
    }

    @Override // com.startapp.sdk.adsbase.Ad
    @Deprecated
    public boolean show() {
        return show(null, null);
    }

    public void loadAd() {
        loadAd(AdMode.AUTOMATIC, new AdPreferences(), null);
    }

    public void loadAd(AdPreferences adPreferences) {
        loadAd(AdMode.AUTOMATIC, adPreferences, null);
    }

    public void loadAd(AdEventListener adEventListener) {
        loadAd(AdMode.AUTOMATIC, new AdPreferences(), adEventListener);
    }

    public void loadAd(AdPreferences adPreferences, AdEventListener adEventListener) {
        loadAd(AdMode.AUTOMATIC, adPreferences, adEventListener);
    }

    public void loadAd(AdMode adMode) {
        loadAd(adMode, new AdPreferences(), null);
    }

    public void loadAd(AdMode adMode, AdPreferences adPreferences) {
        loadAd(adMode, adPreferences, null);
    }

    public void loadAd(AdMode adMode, AdEventListener adEventListener) {
        loadAd(adMode, new AdPreferences(), adEventListener);
    }

    public void loadAd(AdMode adMode, AdPreferences adPreferences, AdEventListener adEventListener) {
        this.adMode = adMode;
        this.adPreferences = adPreferences;
        try {
            load(adPreferences, adEventListener);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            if (adEventListener != null) {
                adEventListener.onFailedToReceiveAd(this);
            }
        }
    }

    public boolean showAd() {
        return showAd(null, null);
    }

    public boolean showAd(String str) {
        return showAd(str, null);
    }

    public boolean showAd(AdDisplayListener adDisplayListener) {
        return showAd(null, adDisplayListener);
    }

    public boolean showAd(String str, AdDisplayListener adDisplayListener) {
        try {
            return show(str, adDisplayListener);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            a(AdDisplayListener.NotDisplayedReason.INTERNAL_ERROR);
            if (adDisplayListener != null) {
                adDisplayListener.adNotDisplayed(null);
            }
            return false;
        }
    }

    public void setVideoListener(VideoListener videoListener) {
        this.videoListener = videoListener;
    }

    public void onResume() {
        if (!isReady()) {
            loadAd();
        }
    }

    public void onPause() {
    }

    public void onBackPressed() {
        showAd("exit_ad");
        k.a().m();
    }

    public void onSaveInstanceState(Bundle bundle) {
        int i = 0;
        switch (this.adMode) {
            case FULLPAGE:
                i = 1;
                break;
            case OFFERWALL:
                i = 2;
                break;
            case OVERLAY:
                i = 3;
                break;
            case REWARDED_VIDEO:
                i = 4;
                break;
        }
        if (this.adPreferences != null) {
            bundle.putSerializable("AdPrefs", this.adPreferences);
        }
        bundle.putInt("AdMode", i);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        int i = bundle.getInt("AdMode");
        this.adMode = AdMode.AUTOMATIC;
        if (i == 1) {
            this.adMode = AdMode.FULLPAGE;
        } else if (i == 2) {
            this.adMode = AdMode.OFFERWALL;
        } else if (i == 3) {
            this.adMode = AdMode.OVERLAY;
        } else if (i == 4) {
            this.adMode = AdMode.REWARDED_VIDEO;
        } else if (i == 5) {
            this.adMode = AdMode.VIDEO;
        }
        Serializable serializable = bundle.getSerializable("AdPrefs");
        if (serializable != null) {
            this.adPreferences = (AdPreferences) serializable;
        }
    }

    public void close() {
        if (this.callbackBroadcastReceiver != null) {
            com.startapp.common.b.a(this.a).a(this.callbackBroadcastReceiver);
        }
        com.startapp.common.b.a(this.a).a(new Intent("com.startapp.android.CloseAdActivity"));
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public boolean isReady() {
        f b = com.startapp.sdk.adsbase.cache.a.a().b(this.adKey);
        boolean z = false;
        if (b != null) {
            z = b.isReady();
        }
        return z;
    }

    public boolean isNetworkAvailable() {
        return u.c(this.a);
    }

    public static void enableConsent(Context context, boolean z) {
        com.startapp.sdk.b.c.a(context).f().a(z);
    }

    public static void disableSplash() {
        k.a().c(false);
    }

    public CacheKey loadSplash(AdPreferences adPreferences, AdEventListener adEventListener) {
        this.adKey = com.startapp.sdk.adsbase.cache.a.a().a(this.a, this, adPreferences, com.startapp.sdk.adsbase.adlisteners.b.a(this.a, adEventListener));
        return this.adKey;
    }

    public static void setReturnAdsPreferences(AdPreferences adPreferences) {
        k.a().a(adPreferences);
    }

    public static void setCommonAdsPreferences(Context context, SDKAdPreferences sDKAdPreferences) {
        Context l = u.l(context);
        if (l != null) {
            k.a().a(l, sDKAdPreferences);
        }
    }

    public static void showSplash(Activity activity, Bundle bundle) {
        showSplash(activity, bundle, new SplashConfig());
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig) {
        showSplash(activity, bundle, splashConfig, new AdPreferences());
    }

    public static void showSplash(Activity activity, Bundle bundle, AdPreferences adPreferences) {
        showSplash(activity, bundle, new SplashConfig(), adPreferences);
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences) {
        showSplash(activity, bundle, splashConfig, adPreferences, null);
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences, SplashHideListener splashHideListener) {
        a(activity, bundle, splashConfig, adPreferences, splashHideListener, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences, final SplashHideListener splashHideListener, boolean z) {
        AdPreferences adPreferences2 = adPreferences;
        if (bundle == null && MetaData.E().K() && u.h(activity)) {
            try {
                k a = k.a();
                if (!a.k() && z) {
                    a.c(true);
                }
                a.b(z);
                if (!z) {
                    if (adPreferences2 == null) {
                        adPreferences2 = new AdPreferences();
                    }
                    adPreferences2.setAs(Boolean.TRUE);
                }
                splashConfig.setDefaults(activity);
                u.a(activity, true);
                Intent intent = new Intent(activity, u.a(activity, OverlayActivity.class, AppWallActivity.class));
                intent.putExtra("SplashConfig", splashConfig);
                intent.putExtra("AdPreference", adPreferences2);
                intent.putExtra("testMode", false);
                intent.putExtra("fullscreen", a.a(activity));
                intent.putExtra("placement", AdPreferences.Placement.INAPP_SPLASH.a());
                intent.addFlags(67108864 | (Build.VERSION.SDK_INT >= 11 ? 32768 : 0) | 1073741824);
                activity.startActivity(intent);
                com.startapp.common.b.a(activity).a(new BroadcastReceiver() { // from class: com.startapp.sdk.adsbase.StartAppAd.2
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent2) {
                        u.a(activity, false);
                        if (splashHideListener != null) {
                            splashHideListener.splashHidden();
                        }
                        com.startapp.common.b.a(activity).a(this);
                    }
                }, new IntentFilter("com.startapp.android.splashHidden"));
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) activity);
                if (splashHideListener != null) {
                    splashHideListener.splashHidden();
                }
            }
        }
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public Ad.AdState getState() {
        f b = com.startapp.sdk.adsbase.cache.a.a().b(this.adKey);
        return b != null ? b.getState() : Ad.AdState.UN_INITIALIZED;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public boolean isBelowMinCPM() {
        f b = com.startapp.sdk.adsbase.cache.a.a().b(this.adKey);
        if (b != null) {
            return b.isBelowMinCPM();
        }
        return false;
    }

    public static boolean showAd(Context context) {
        if (context != null) {
            try {
                return new StartAppAd(context).showAd();
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                return false;
            }
        }
        return false;
    }

    public static void onBackPressed(Context context) {
        new StartAppAd(context).onBackPressed();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    @Deprecated
    public boolean load(AdPreferences adPreferences, AdEventListener adEventListener) {
        if (!MetaData.E().K()) {
            if (adEventListener != null) {
                setErrorMessage("serving ads disabled");
                adEventListener.onFailedToReceiveAd(this);
            }
            return false;
        }
        this.adKey = com.startapp.sdk.adsbase.cache.a.a().a(this.a, this, this.adMode, adPreferences, com.startapp.sdk.adsbase.adlisteners.b.a(this.a, adEventListener));
        return this.adKey != null;
    }

    public static void enableAutoInterstitial() {
        e.a.a().a();
    }

    public static void disableAutoInterstitial() {
        e.a.a().b();
    }

    public static void setAutoInterstitialPreferences(AutoInterstitialPreferences autoInterstitialPreferences) {
        e.a.a().a(autoInterstitialPreferences);
    }
}
