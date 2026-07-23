package com.startapp.sdk.ads.banner;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandard;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class Cover extends BannerStandard {
    public Cover(Activity activity) {
        super(activity);
    }

    public Cover(Activity activity, AdPreferences adPreferences) {
        super(activity, adPreferences);
    }

    public Cover(Activity activity, BannerListener bannerListener) {
        super(activity, bannerListener);
    }

    public Cover(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        super(activity, adPreferences, bannerListener);
    }

    public Cover(Activity activity, AttributeSet attributeSet) {
        super(activity, attributeSet);
    }

    public Cover(Activity activity, AttributeSet attributeSet, int i) {
        super(activity, attributeSet, i);
    }

    @Deprecated
    public Cover(Context context) {
        super(context);
    }

    @Deprecated
    public Cover(Context context, AdPreferences adPreferences) {
        super(context, adPreferences);
    }

    @Deprecated
    public Cover(Context context, BannerListener bannerListener) {
        super(context, bannerListener);
    }

    @Deprecated
    public Cover(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        super(context, adPreferences, bannerListener);
    }

    @Deprecated
    public Cover(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Deprecated
    public Cover(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.startapp.sdk.ads.banner.bannerstandard.BannerStandard, com.startapp.sdk.ads.banner.BannerBase
    protected final int c() {
        return 157;
    }

    @Override // com.startapp.sdk.ads.banner.bannerstandard.BannerStandard, com.startapp.sdk.ads.banner.BannerBase
    protected final String d() {
        return "StartApp Cover";
    }

    @Override // com.startapp.sdk.ads.banner.bannerstandard.BannerStandard
    protected final int s() {
        return 2;
    }

    @Override // com.startapp.sdk.ads.banner.BannerBase
    public void loadAd(int i, int i2) {
        super.loadAd(300, 157);
    }
}
