package com.startapp.sdk.ads.banner;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandard;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class Mrec extends BannerStandard {
    public Mrec(Activity activity) {
        super(activity);
    }

    public Mrec(Activity activity, AdPreferences adPreferences) {
        super(activity, adPreferences);
    }

    public Mrec(Activity activity, BannerListener bannerListener) {
        super(activity, bannerListener);
    }

    public Mrec(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        super(activity, adPreferences, bannerListener);
    }

    public Mrec(Activity activity, AttributeSet attributeSet) {
        super(activity, attributeSet);
    }

    public Mrec(Activity activity, AttributeSet attributeSet, int i) {
        super(activity, attributeSet, i);
    }

    @Deprecated
    public Mrec(Context context) {
        super(context);
    }

    @Deprecated
    public Mrec(Context context, AdPreferences adPreferences) {
        super(context, adPreferences);
    }

    @Deprecated
    public Mrec(Context context, BannerListener bannerListener) {
        super(context, bannerListener);
    }

    @Deprecated
    public Mrec(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        super(context, adPreferences, bannerListener);
    }

    @Deprecated
    public Mrec(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Deprecated
    public Mrec(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.startapp.sdk.ads.banner.bannerstandard.BannerStandard, com.startapp.sdk.ads.banner.BannerBase
    protected final int c() {
        return 250;
    }

    @Override // com.startapp.sdk.ads.banner.bannerstandard.BannerStandard, com.startapp.sdk.ads.banner.BannerBase
    protected final String d() {
        return "StartApp Mrec";
    }

    @Override // com.startapp.sdk.ads.banner.bannerstandard.BannerStandard
    protected final int s() {
        return 1;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    public void loadAd(int i, int i2) {
        super.loadAd(300, 250);
    }
}
