package com.startapp.sdk.ads.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.startapp.sdk.ads.video.VideoMode;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public abstract class b {
    protected AdPreferences.Placement b;
    private Intent c;
    private Activity d;
    private String[] f;
    private boolean[] g;
    private String i;
    private String[] j;
    private String[] k;
    private String[] l;
    private Ad m;
    private String n;
    private boolean o;
    private AdInformationOverrides p;
    private String q;
    private Long r;
    protected AdInformationObject a = null;
    private BroadcastReceiver e = new BroadcastReceiver() { // from class: com.startapp.sdk.ads.a.b.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            b.this.p();
        }
    };
    private boolean[] h = {true};
    private Boolean[] s = null;
    private int t = 0;
    private boolean u = false;
    private boolean v = false;

    public abstract void u();

    public static b a(Activity activity, Intent intent, AdPreferences.Placement placement) {
        b bVar = null;
        switch (placement) {
            case INAPP_OFFER_WALL:
                if (u.a(128L) || u.a(64L)) {
                    bVar = new e();
                    break;
                }
                break;
            case INAPP_RETURN:
            case INAPP_OVERLAY:
                if (u.a(4L) && intent.getBooleanExtra("videoAd", false)) {
                    bVar = new VideoMode();
                    break;
                } else if (intent.getBooleanExtra("mraidAd", false)) {
                    bVar = new d();
                    break;
                } else {
                    bVar = new f();
                    break;
                }
                break;
            case INAPP_SPLASH:
                if (u.a(8L)) {
                    bVar = new com.startapp.sdk.ads.splash.d();
                    break;
                }
                break;
            case INAPP_FULL_SCREEN:
            case INAPP_BROWSER:
                if (u.a(256L)) {
                    Uri data = intent.getData();
                    if (data == null) {
                        return null;
                    }
                    bVar = new com.startapp.sdk.inappbrowser.a(data.toString());
                    break;
                }
                break;
            default:
                bVar = new a();
                break;
        }
        bVar.c = intent;
        bVar.d = activity;
        bVar.i = intent.getStringExtra("position");
        bVar.j = intent.getStringArrayExtra("tracking");
        bVar.k = intent.getStringArrayExtra("trackingClickUrl");
        bVar.l = intent.getStringArrayExtra("packageNames");
        bVar.f = intent.getStringArrayExtra("closingUrl");
        bVar.g = intent.getBooleanArrayExtra("smartRedirect");
        bVar.h = intent.getBooleanArrayExtra("browserEnabled");
        bVar.q = intent.getStringExtra("adTag");
        String stringExtra = intent.getStringExtra("htmlUuid");
        if (stringExtra != null) {
            if (AdsConstants.b.booleanValue()) {
                bVar.a(com.startapp.sdk.adsbase.cache.a.a().a(stringExtra));
            } else {
                bVar.a(com.startapp.sdk.adsbase.cache.a.a().b(stringExtra));
            }
        }
        bVar.o = intent.getBooleanExtra("isSplash", false);
        bVar.p = (AdInformationOverrides) intent.getSerializableExtra("adInfoOverride");
        bVar.b = placement;
        bVar.f = intent.getStringArrayExtra("closingUrl");
        bVar.t = intent.getIntExtra("rewardDuration", 0);
        bVar.u = intent.getBooleanExtra("rewardedHideTimer", false);
        if (bVar.g == null) {
            bVar.g = new boolean[]{true};
        }
        if (bVar.h == null) {
            bVar.h = new boolean[]{true};
        }
        bVar.m = (Ad) intent.getSerializableExtra("ad");
        long longExtra = intent.getLongExtra("delayImpressionSeconds", -1L);
        if (longExtra != -1) {
            bVar.r = Long.valueOf(longExtra);
        }
        bVar.s = (Boolean[]) intent.getSerializableExtra("sendRedirectHops");
        new StringBuilder("Placement=[").append(bVar.b).append("]");
        return bVar;
    }

    public final Intent b() {
        return this.c;
    }

    public final Activity c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        if (str != null && this.q != null && this.q.length() > 0) {
            this.n = str.replaceAll("startapp_adtag_placeholder", this.q);
        } else {
            this.n = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean[] d() {
        return this.g;
    }

    public final int e() {
        return this.t;
    }

    public final boolean f() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i) {
        if (this.h == null || i < 0 || i >= this.h.length) {
            return true;
        }
        return this.h[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String g() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String h() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String[] i() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String[] j() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String[] k() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String[] l() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String m() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(RelativeLayout relativeLayout) {
        this.a = new AdInformationObject(this.d, AdInformationObject.Size.LARGE, this.b, this.p);
        this.a.a(relativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String n() {
        try {
            String[] strArr = this.j;
            if (strArr != null && strArr.length > 0) {
                return com.startapp.sdk.adsbase.a.a(strArr[0], (String) null);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public final Long o() {
        return this.r;
    }

    public final Boolean b(int i) {
        if (this.s == null || i < 0 || i >= this.s.length) {
            return null;
        }
        return this.s[i];
    }

    public void p() {
        this.d.runOnUiThread(new Runnable() { // from class: com.startapp.sdk.ads.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.this.c().finish();
            }
        });
    }

    public void q() {
        com.startapp.common.b.a(this.d).a(new Intent("com.startapp.android.HideDisplayBroadcastListener"));
    }

    public void a(Bundle bundle) {
        com.startapp.common.b.a(this.d).a(this.e, new IntentFilter("com.startapp.android.CloseAdActivity"));
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean r() {
        return false;
    }

    public void s() {
        p();
    }

    public void t() {
    }

    public void b(Bundle bundle) {
    }

    public void v() {
    }

    public void w() {
        if (this.e != null) {
            com.startapp.common.b.a(this.d).a(this.e);
        }
        this.e = null;
    }

    public final Ad x() {
        return this.m;
    }
}
