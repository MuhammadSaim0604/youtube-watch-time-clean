package com.startapp.sdk.ads.nativead;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b implements NativeAdDisplayListener {
    private NativeAdDisplayListener a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NativeAdDisplayListener nativeAdDisplayListener) {
        this.a = nativeAdDisplayListener;
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdDisplayListener
    public final void adHidden(final NativeAdInterface nativeAdInterface) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.ads.nativead.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a.adHidden(nativeAdInterface);
                }
            });
        }
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdDisplayListener
    public final void adDisplayed(final NativeAdInterface nativeAdInterface) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.ads.nativead.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a.adDisplayed(nativeAdInterface);
                }
            });
        }
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdDisplayListener
    public final void adClicked(final NativeAdInterface nativeAdInterface) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.ads.nativead.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a.adClicked(nativeAdInterface);
                }
            });
        }
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdDisplayListener
    public final void adNotDisplayed(final NativeAdInterface nativeAdInterface) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.ads.nativead.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a.adNotDisplayed(nativeAdInterface);
                }
            });
        }
    }
}
