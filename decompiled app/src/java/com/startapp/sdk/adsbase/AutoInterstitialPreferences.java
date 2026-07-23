package com.startapp.sdk.adsbase;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AutoInterstitialPreferences implements Serializable {
    private static final long serialVersionUID = 1;
    private int activitiesBetweenAds;
    private int secondsBetweenAds;

    public AutoInterstitialPreferences() {
        setActivitiesBetweenAds(AdsCommonMetaData.a().K());
        setSecondsBetweenAds(AdsCommonMetaData.a().L());
    }

    public int getActivitiesBetweenAds() {
        return this.activitiesBetweenAds;
    }

    public int getSecondsBetweenAds() {
        return this.secondsBetweenAds;
    }

    public AutoInterstitialPreferences setActivitiesBetweenAds(int i) {
        this.activitiesBetweenAds = i > 0 ? i : 1;
        return this;
    }

    public AutoInterstitialPreferences setSecondsBetweenAds(int i) {
        this.secondsBetweenAds = i >= 0 ? i : 0;
        return this;
    }

    public String toString() {
        return "AutoInterstitialPreferences [activitiesBetweenAds=" + this.activitiesBetweenAds + ", secondsBetweenAds=" + this.secondsBetweenAds + "]";
    }
}
