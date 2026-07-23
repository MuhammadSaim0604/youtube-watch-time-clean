package com.startapp.sdk.adsbase.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.startapp.sdk.ads.a.b;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.a;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.b.c;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class OverlayActivity extends Activity {
    private b a;
    private boolean b;
    private int c;
    private boolean d;
    private Bundle e;
    private boolean f = false;
    private int g = -1;

    static {
        OverlayActivity.class.getSimpleName();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("placement", -1);
        Serializable serializableExtra = getIntent().getSerializableExtra("ad");
        if (intExtra >= 0 && (serializableExtra instanceof Ad)) {
            c.a(getApplicationContext()).h().a(AdPreferences.Placement.a(intExtra), ((Ad) serializableExtra).getAdId());
        }
        boolean booleanExtra = getIntent().getBooleanExtra("videoAd", false);
        requestWindowFeature(1);
        if (getIntent().getBooleanExtra("fullscreen", false) || booleanExtra) {
            getWindow().setFlags(1024, 1024);
        }
        this.d = getIntent().getBooleanExtra("activityShouldLockOrientation", true);
        if (bundle == null && !booleanExtra) {
            com.startapp.common.b.a(this).a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
        }
        if (bundle != null) {
            this.g = bundle.getInt("activityLockedOrientation", -1);
            this.d = bundle.getBoolean("activityShouldLockOrientation", true);
        }
        this.c = getIntent().getIntExtra("orientation", getResources().getConfiguration().orientation);
        this.b = getResources().getConfiguration().orientation != this.c;
        if (!this.b) {
            a();
            this.a.a(bundle);
            return;
        }
        this.e = bundle;
    }

    private void a() {
        this.a = b.a(this, getIntent(), AdPreferences.Placement.a(getIntent().getIntExtra("placement", 0)));
        if (this.a == null) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.b) {
            a();
            this.a.a(this.e);
            this.a.u();
            this.b = false;
        }
        this.a.v();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.a == null || this.a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (!this.b) {
            this.a.s();
            a.a((Context) this);
        }
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!this.b) {
            this.a.b(bundle);
            bundle.putInt("activityLockedOrientation", this.g);
            bundle.putBoolean("activityShouldLockOrientation", this.d);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.g == -1) {
            this.g = u.a(this, this.c, this.d);
        } else {
            com.startapp.common.b.b.a(this, this.g);
        }
        if (!this.b) {
            this.a.u();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (!this.b) {
            this.a.t();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (!this.b) {
            this.a.w();
            this.a = null;
            u.a((Activity) this, false);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.a.r()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.a != null) {
            this.a.q();
        }
        super.finish();
    }
}
