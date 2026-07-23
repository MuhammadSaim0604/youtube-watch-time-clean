package com.startapp.sdk.ads.nativead;

import android.graphics.Bitmap;
import android.view.View;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public interface NativeAdInterface {
    StartAppNativeAd.CampaignAction getCampaignAction();

    String getCategory();

    String getDescription();

    Bitmap getImageBitmap();

    String getImageUrl();

    String getInstalls();

    String getPackacgeName();

    float getRating();

    Bitmap getSecondaryImageBitmap();

    String getSecondaryImageUrl();

    String getTitle();

    boolean isApp();

    boolean isBelowMinCPM();

    void registerViewForInteraction(View view);

    void registerViewForInteraction(View view, List<View> list);

    void registerViewForInteraction(View view, List<View> list, NativeAdDisplayListener nativeAdDisplayListener);

    void unregisterView();
}
