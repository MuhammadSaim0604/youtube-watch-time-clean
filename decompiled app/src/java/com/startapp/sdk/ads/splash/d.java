package com.startapp.sdk.ads.splash;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class d extends com.startapp.sdk.ads.a.b {
    private SplashScreen d;
    private SplashConfig c = null;
    private boolean e = false;
    private boolean f = false;

    @Override // com.startapp.sdk.ads.a.b
    public final void a(Bundle bundle) {
        this.c = (SplashConfig) b().getSerializableExtra("SplashConfig");
    }

    @Override // com.startapp.sdk.ads.a.b
    public final boolean a(int i, KeyEvent keyEvent) {
        if (this.e) {
            if (i == 25) {
                if (!this.f) {
                    this.f = true;
                    SplashScreen splashScreen = this.d;
                    splashScreen.e = true;
                    splashScreen.b.e();
                    Toast.makeText(c(), "Test Mode", 0).show();
                    return true;
                }
            } else if (i == 24 && this.f) {
                c().finish();
                return true;
            }
        }
        if (i == 4) {
            return true;
        }
        return false;
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void s() {
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void t() {
        if (this.d != null) {
            this.d.b();
        }
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void u() {
        AdPreferences adPreferences;
        if (this.c != null) {
            Serializable serializableExtra = b().getSerializableExtra("AdPreference");
            if (serializableExtra != null) {
                adPreferences = (AdPreferences) serializableExtra;
            } else {
                adPreferences = new AdPreferences();
            }
            this.e = b().getBooleanExtra("testMode", false);
            this.d = new SplashScreen(c(), this.c, adPreferences);
            this.d.a();
        }
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void w() {
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void q() {
    }
}
