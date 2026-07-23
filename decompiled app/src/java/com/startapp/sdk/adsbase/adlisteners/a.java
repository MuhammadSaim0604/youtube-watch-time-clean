package com.startapp.sdk.adsbase.adlisteners;

import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.adsbase.Ad;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a implements AdDisplayListener {
    AdDisplayListener a;

    public a(AdDisplayListener adDisplayListener) {
        this.a = adDisplayListener;
    }

    @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
    public final void adHidden(final Ad ad) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.adlisteners.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a.adHidden(ad);
                }
            });
        }
    }

    @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
    public final void adDisplayed(final Ad ad) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.adlisteners.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a.adDisplayed(ad);
                }
            });
        }
    }

    @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
    public final void adClicked(final Ad ad) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.adlisteners.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a.adClicked(ad);
                }
            });
        }
    }

    @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
    public final void adNotDisplayed(final Ad ad) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.adlisteners.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a.adNotDisplayed(ad);
                }
            });
        }
    }
}
