package com.startapp.sdk.adsbase.adlisteners;

import com.startapp.sdk.adsbase.Ad;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public interface AdDisplayListener {

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum NotDisplayedReason {
        NETWORK_PROBLEM,
        AD_RULES,
        AD_NOT_READY,
        AD_EXPIRED,
        VIDEO_BACK,
        VIDEO_ERROR,
        INTERNAL_ERROR,
        AD_NOT_READY_VIDEO_FALLBACK,
        APP_IN_BACKGROUND,
        AD_CLOSED_TOO_QUICKLY,
        SERVING_ADS_DISABLED
    }

    void adClicked(Ad ad);

    void adDisplayed(Ad ad);

    void adHidden(Ad ad);

    void adNotDisplayed(Ad ad);
}
