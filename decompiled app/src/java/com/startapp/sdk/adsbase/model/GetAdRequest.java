package com.startapp.sdk.adsbase.model;

import android.content.Context;
import android.util.Pair;
import com.startapp.common.SDKException;
import com.startapp.common.b.a;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.SDKAdPreferences;
import com.startapp.sdk.adsbase.adrules.b;
import com.startapp.sdk.adsbase.c;
import com.startapp.sdk.adsbase.j.k;
import com.startapp.sdk.adsbase.j.m;
import com.startapp.sdk.adsbase.j.p;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class GetAdRequest extends c {
    private long A;
    private int B;
    private String C;
    private String D;
    private String E;
    private boolean F;
    private Boolean G;
    private Boolean H;
    private String I;
    private String J;
    private Ad.AdType K;
    protected String b;
    private AdPreferences.Placement c;
    private boolean d;
    private Integer e;
    private Long f;
    private Boolean g;
    private SDKAdPreferences.Gender h;
    private String i;
    private String j;
    private int k;
    private boolean l;
    private Boolean m;
    private boolean n;
    private Double o;
    private String p;
    private Integer q;
    private boolean r;
    private int s;
    private Set<String> t;
    private Set<String> u;
    private Set<String> v;
    private Set<String> w;
    private Set<String> x;
    private Pair<String, String> y;
    private boolean z;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    protected enum VideoRequestMode {
        INTERSTITIAL,
        REWARDED
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    protected enum VideoRequestType {
        ENABLED,
        DISABLED,
        FORCED,
        FORCED_NONVAST
    }

    public GetAdRequest() {
        super(4);
        this.k = 1;
        this.l = true;
        this.n = AdsCommonMetaData.a().E();
        this.r = true;
        this.s = 0;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.z = true;
        this.I = null;
        this.J = null;
        this.K = null;
        this.A = System.currentTimeMillis() - p.d().b();
        if (!u.a()) {
            this.B = b.a().c();
        }
        this.C = MetaData.E().z();
    }

    public void a(Context context) {
        this.b = com.startapp.sdk.b.c.a(context).h().a(this.c);
    }

    public final AdPreferences.Placement g() {
        return this.c;
    }

    public final void h() {
        this.n = true;
    }

    public final void e(int i) {
        this.k = i;
    }

    public final void c(String str) {
        this.D = str;
    }

    public final void d(String str) {
        this.E = str;
    }

    public final void b(boolean z) {
        this.F = z;
    }

    public final void a(Set<String> set) {
        this.v = set;
    }

    public final boolean i() {
        return this.x != null && this.x.size() > 0;
    }

    public final void b(Set<String> set) {
        this.x = set;
    }

    public final void f(int i) {
        this.s = i;
    }

    public final void c(boolean z) {
        this.z = z;
    }

    @Override // com.startapp.sdk.adsbase.c
    public final void b(int i) {
        this.a = Integer.valueOf(i);
    }

    @Override // com.startapp.sdk.adsbase.c
    public String toString() {
        return super.toString();
    }

    public final void a(Integer num, Long l, Boolean bool) {
        this.e = num;
        this.f = l;
        this.g = bool;
    }

    public void a(Context context, AdPreferences adPreferences, AdPreferences.Placement placement, Pair<String, String> pair) {
        this.c = placement;
        this.y = pair;
        this.G = adPreferences.getAi();
        this.H = adPreferences.getAs();
        this.h = adPreferences.getGender(context);
        this.i = adPreferences.getKeywords();
        this.d = adPreferences.isTestMode();
        this.t = adPreferences.getCategories();
        this.u = adPreferences.getCategoriesExclude();
        this.l = adPreferences.b();
        this.q = adPreferences.a();
        this.m = Boolean.valueOf(com.startapp.common.b.b.b(context));
        this.o = adPreferences.getMinCpm();
        this.p = adPreferences.getAdTag();
        this.r = !MetaData.b(context);
        this.I = adPreferences.country;
        this.J = adPreferences.advertiserId;
        this.j = adPreferences.template;
        this.K = adPreferences.type;
        this.w = adPreferences.packageInclude;
    }

    public final boolean j() {
        return this.K == Ad.AdType.VIDEO || this.K == Ad.AdType.REWARDED_VIDEO;
    }

    @Override // com.startapp.sdk.adsbase.c
    public m a() throws SDKException {
        m a = super.a();
        k kVar = a;
        if (a == null) {
            kVar = new k();
        }
        m mVar = kVar;
        mVar.a("placement", this.c.name(), true);
        mVar.a("testMode", Boolean.toString(this.d), false);
        mVar.a("gender", this.h, false);
        mVar.a("keywords", this.i, false);
        mVar.a("template", this.j, false);
        mVar.a("adsNumber", Integer.toString(this.k), false);
        mVar.a("category", this.t);
        mVar.a("categoryExclude", this.u);
        mVar.a("packageExclude", this.v);
        mVar.a("campaignExclude", this.x);
        mVar.a("offset", Integer.toString(this.s), false);
        mVar.a("ai", this.G, false);
        mVar.a("as", this.H, false);
        mVar.a("minCPM", u.a(this.o), false);
        mVar.a("adTag", this.p, false);
        mVar.a("previousAdId", this.b, false);
        mVar.a("twoClicks", Boolean.valueOf(!this.n), false);
        mVar.a("engInclude", Boolean.toString(this.z), false);
        if (this.K == Ad.AdType.INTERSTITIAL || this.K == Ad.AdType.RICH_TEXT) {
            mVar.a("type", this.K, false);
        }
        mVar.a("timeSinceSessionStart", Long.valueOf(this.A), true);
        mVar.a("adsDisplayed", Integer.valueOf(this.B), true);
        mVar.a("profileId", this.C, false);
        mVar.a("hardwareAccelerated", Boolean.valueOf(this.l), false);
        mVar.a("autoLoadAmount", this.q, false);
        mVar.a("dts", this.m, false);
        mVar.a("downloadingMode", "CACHE", false);
        mVar.a("primaryImg", this.D, false);
        mVar.a("moreImg", this.E, false);
        mVar.a("contentAd", Boolean.toString(this.F), false);
        mVar.a("ct", this.e, false);
        mVar.a("tsc", this.f, false);
        mVar.a("apc", this.g, false);
        mVar.a("testAdsEnabled", com.startapp.sdk.adsbase.k.a().o() ? Boolean.TRUE : null, false);
        String d = a.d();
        mVar.a(a.a(), d, true);
        mVar.a(a.c(), a.b(c() + this.c.name() + e() + d() + d), true, false);
        if (this.I != null) {
            mVar.a("country", this.I, false);
        }
        if (this.J != null) {
            mVar.a("advertiserId", this.J, false);
        }
        if (this.w != null) {
            mVar.a("packageInclude", this.w);
        }
        mVar.a("defaultMetaData", Boolean.valueOf(this.r), true);
        mVar.a((String) this.y.first, this.y.second, false);
        return kVar;
    }

    public final Ad.AdType k() {
        return this.K;
    }
}
