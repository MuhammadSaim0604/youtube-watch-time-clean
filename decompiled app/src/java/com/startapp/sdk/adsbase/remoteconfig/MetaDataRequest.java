package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.startapp.common.SDKException;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.j;
import com.startapp.sdk.adsbase.j.m;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.k;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class MetaDataRequest extends com.startapp.sdk.adsbase.c {
    private int b;
    private int c;
    private boolean d;
    private float e;
    private RequestReason f;
    private String g;
    private String h;
    private Integer i;
    private Pair<String, String> j;
    private Integer k;
    private Boolean l;
    private long m;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
    public enum RequestReason {
        LAUNCH(1),
        APP_IDLE(2),
        IN_APP_PURCHASE(3),
        CUSTOM(4),
        PERIODIC(5),
        PAS(6),
        CONSENT(7);
        
        private int index;

        RequestReason(int i) {
            this.index = i;
        }
    }

    public MetaDataRequest(Context context, RequestReason requestReason) {
        super(2);
        int f;
        this.b = j.a(context, "totalSessions", (Integer) 0).intValue();
        this.c = (int) ((System.currentTimeMillis() - j.a(context, "firstSessionTime", Long.valueOf(System.currentTimeMillis())).longValue()) / 86400000);
        this.e = j.a(context, "inAppPurchaseAmount", Float.valueOf(0.0f)).floatValue();
        this.d = j.a(context, "payingUser", Boolean.FALSE).booleanValue();
        this.g = MetaData.E().z();
        this.f = requestReason;
        SharedPreferences a = j.a(context);
        boolean g = k.a().g();
        new u();
        String string = a.getString("shared_prefs_app_apk_hash", null);
        String str = string;
        if (TextUtils.isEmpty(string) || g) {
            str = u.a("SHA-256", context);
            a.edit().putString("shared_prefs_app_apk_hash", str).commit();
        }
        this.h = str;
        SimpleTokenConfig e = MetaData.E().e();
        if (e != null && e.a(context) && (f = com.startapp.common.b.b.f(context)) > 0) {
            this.i = Integer.valueOf(f);
        }
        this.j = SimpleTokenUtils.c();
        this.m = SimpleTokenUtils.a();
        com.startapp.sdk.adsbase.consent.a f2 = com.startapp.sdk.b.c.a(context).f();
        this.k = f2.d();
        this.l = f2.f();
    }

    @Override // com.startapp.sdk.adsbase.c
    public final String toString() {
        return "MetaDataRequest [totalSessions=" + this.b + ", daysSinceFirstSession=" + this.c + ", payingUser=" + this.d + ", paidAmount=" + this.e + ", reason=" + this.f + ", ct=" + this.k + ", apc=" + this.l + ", profileId=" + this.g + "]";
    }

    @Override // com.startapp.sdk.adsbase.c
    public final m a() throws SDKException {
        m a = super.a();
        com.startapp.sdk.adsbase.j.k kVar = a;
        if (a == null) {
            kVar = new com.startapp.sdk.adsbase.j.k();
        }
        m mVar = kVar;
        mVar.a(com.startapp.common.b.a.a(), com.startapp.common.b.a.d(), true);
        mVar.a("totalSessions", Integer.valueOf(this.b), true);
        mVar.a("daysSinceFirstSession", Integer.valueOf(this.c), true);
        mVar.a("payingUser", Boolean.valueOf(this.d), true);
        mVar.a("profileId", this.g, false);
        mVar.a("paidAmount", Float.valueOf(this.e), true);
        mVar.a("reason", this.f, true);
        mVar.a("ct", this.k, false);
        mVar.a("apc", this.l, false);
        mVar.a("testAdsEnabled", k.a().o() ? Boolean.TRUE : null, false);
        mVar.a("apkHash", this.h, false);
        mVar.a("ian", this.i, false);
        mVar.a((String) this.j.first, this.j.second, false);
        if (Build.VERSION.SDK_INT >= 9 && this.m != 0) {
            mVar.a("firstInstalledAppTS", Long.valueOf(this.m), false);
        }
        return kVar;
    }
}
