package com.startapp.sdk.adsbase;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class StartAppSDK {
    public static void init(Context context, String str) {
        init(context, str, new SDKAdPreferences());
    }

    public static void init(Context context, String str, SDKAdPreferences sDKAdPreferences) {
        init(context, (String) null, str, sDKAdPreferences);
    }

    public static void init(Context context, String str, String str2) {
        init(context, str, str2, new SDKAdPreferences());
    }

    public static void init(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences) {
        init(context, str, str2, sDKAdPreferences, true);
    }

    public static void init(Context context, String str, boolean z) {
        init(context, (String) null, str, z);
    }

    public static void init(Context context, String str, String str2, boolean z) {
        init(context, str, str2, new SDKAdPreferences(), z);
    }

    public static void init(Context context, String str, SDKAdPreferences sDKAdPreferences, boolean z) {
        init(context, null, str, sDKAdPreferences, z);
    }

    public static void init(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z) {
        k.a().a(context, str, str2, sDKAdPreferences, z);
    }

    public static void inAppPurchaseMade(Context context) {
        inAppPurchaseMade(context, 0.0d);
    }

    public static void inAppPurchaseMade(Context context, double d) {
        j.b(context, "payingUser", Boolean.TRUE);
        j.b(context, "inAppPurchaseAmount", Float.valueOf((float) (j.a(context, "inAppPurchaseAmount", Float.valueOf(0.0f)).floatValue() + d)));
        k.a();
        k.a(context, MetaDataRequest.RequestReason.IN_APP_PURCHASE);
    }

    public static void startNewSession(Context context) {
        k.a();
        k.a(context, MetaDataRequest.RequestReason.CUSTOM);
    }

    public static void addWrapper(Context context, String str, String str2) {
        k.a().a(context, str, str2);
    }

    public static void enableReturnAds(boolean z) {
        k.a().d(z);
    }

    public static void setTestAdsEnabled(boolean z) {
        k.a().e(z);
    }

    private static void pauseServices(Context context) {
        k.a();
        k.b(context);
        k.a();
        k.c(context);
    }

    private static void resumeServices(Context context) {
        k.a();
        k.d(context);
        k.a();
        k.e(context);
    }

    public static void setUserConsent(Context context, String str, long j, boolean z) {
        k.a();
        k.a(context, str, z, true);
    }
}
