package com.startapp.sdk.adsbase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.startapp.common.SDKException;
import com.startapp.sdk.adsbase.j.m;
import com.startapp.sdk.adsbase.j.p;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class c {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private int J;
    private int K;
    private float L;
    private Boolean M;
    private String O;
    private String P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private String V;
    private final int W;
    protected Integer a;
    private String c;
    private String d;
    private String h;
    private String i;
    private com.startapp.common.a.a j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private Boolean t;
    private Boolean u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private Map<String, String> b = new HashMap();
    private String e = AdsConstants.c;
    private long f = new BigInteger(AdsConstants.d, 2).longValue();
    private Map<String, String> g = new TreeMap();
    private String I = "android";
    private int N = 3;

    static {
        c.class.getSimpleName();
    }

    public c(int i) {
        this.W = i;
    }

    public final int b() {
        return this.W;
    }

    public final String c() {
        return this.d;
    }

    public void b(int i) {
        this.a = null;
    }

    public final void c(int i) {
        this.J = i;
    }

    public final void d(int i) {
        this.K = i;
    }

    public final String d() {
        return this.e;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final String e() {
        if (this.O != null) {
            return this.O;
        }
        return "";
    }

    private void a(Context context) {
        this.M = Boolean.valueOf(u.h(context));
    }

    public String toString() {
        return "BaseRequest [parameters=" + this.b + "]";
    }

    public final void b(Context context) {
        if (!MetaData.E().P()) {
            com.startapp.common.a.a b = com.startapp.sdk.b.c.a(context).d().b();
            this.j = b;
            if (TextUtils.isEmpty(b.a()) || "0".equals(b.a())) {
                if (!j.a(context, "advertising_id_retrieving_failed", Boolean.FALSE).booleanValue()) {
                    j.b(context, "advertising_id_retrieving_failed", Boolean.TRUE);
                    Throwable[] d = b.d();
                    if (d != null) {
                        com.startapp.sdk.adsbase.infoevents.e eVar = null;
                        for (Throwable th : d) {
                            if (th != null) {
                                if (eVar == null) {
                                    eVar = new com.startapp.sdk.adsbase.infoevents.e(th);
                                } else {
                                    eVar.a(new com.startapp.sdk.adsbase.infoevents.e(th));
                                }
                            }
                        }
                        if (eVar != null) {
                            eVar.a(context);
                        }
                    }
                }
                this.m = com.startapp.sdk.b.c.a(context).g().a();
            }
        }
    }

    public final void a(Context context, AdPreferences adPreferences) {
        d(context);
        try {
            b(context, adPreferences);
        } catch (Throwable th) {
        }
        try {
            c(context);
        } catch (Throwable th2) {
            new com.startapp.sdk.adsbase.infoevents.e(th2).a(context);
        }
        try {
            e(context);
        } catch (Throwable th3) {
            new com.startapp.sdk.adsbase.infoevents.e(th3).a(context);
        }
        try {
            this.H = com.startapp.sdk.b.c.a(context).e().a(this);
        } catch (Throwable th4) {
            new com.startapp.sdk.adsbase.infoevents.e(th4).a(context);
        }
        try {
            a(adPreferences, context);
        } catch (Throwable th5) {
            new com.startapp.sdk.adsbase.infoevents.e(th5).a(context);
        }
        try {
            b(context);
        } catch (Throwable th6) {
            new com.startapp.sdk.adsbase.infoevents.e(th6).a(context);
        }
    }

    public final void c(Context context) {
        this.v = com.startapp.common.b.e.a(context);
        this.w = "e106";
        this.F = "e106";
        com.startapp.common.c a = com.startapp.common.c.a();
        if (a != null) {
            String b = a.b();
            this.F = b;
            this.w = b;
        }
    }

    public final void d(Context context) {
        b k = com.startapp.sdk.b.c.a(context).k();
        this.c = k.a();
        this.d = k.b();
    }

    public final void b(Context context, AdPreferences adPreferences) {
        DisplayMetrics displayMetrics;
        this.o = Build.MANUFACTURER;
        this.n = Build.MODEL;
        this.p = Integer.toString(Build.VERSION.SDK_INT);
        if (adPreferences != null) {
            this.i = adPreferences.getAge(context);
        }
        this.k = context.getPackageName();
        this.l = u.g(context);
        this.P = com.startapp.common.b.b.d(context);
        this.Q = com.startapp.common.b.b.c(context);
        this.t = Boolean.valueOf(com.startapp.common.b.b.a(context));
        this.R = com.startapp.common.b.b.g(context);
        this.S = com.startapp.common.b.b.h(context);
        this.T = com.startapp.common.b.b.i(context);
        this.u = com.startapp.common.b.e.b(context);
        this.U = u.m(context);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.J = displayMetrics.widthPixels;
            this.K = displayMetrics.heightPixels;
            this.L = displayMetrics.density;
        }
        com.startapp.sdk.b.c a = com.startapp.sdk.b.c.a(context);
        com.startapp.sdk.c.b.a c = a.a().c();
        this.q = c.a();
        this.r = c.b();
        this.s = a.b().c().a();
        this.V = j.a(context, "USER_CONSENT_PERSONALIZED_ADS_SERVING", (String) null);
        j.b(context, "sharedPrefsWrappers", this.g);
        a(context);
        this.O = p.d().a();
    }

    public final void e(Context context) {
        Object systemService = context.getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            a(telephonyManager);
            b(telephonyManager);
            f(context);
            this.G = com.startapp.common.b.b.b(context, telephonyManager);
        }
    }

    public m f() throws SDKException {
        com.startapp.sdk.adsbase.j.i iVar = new com.startapp.sdk.adsbase.j.i();
        a(iVar);
        return iVar;
    }

    public m a() throws SDKException {
        com.startapp.sdk.adsbase.j.k kVar = new com.startapp.sdk.adsbase.j.k();
        a(kVar);
        return kVar;
    }

    private void a(m mVar) throws SDKException {
        mVar.a("publisherId", this.c, false);
        mVar.a("productId", this.d, true);
        mVar.a("os", this.I, true);
        mVar.a("sdkVersion", this.e, false);
        mVar.a("flavor", Long.valueOf(this.f), false);
        if (this.g != null && !this.g.isEmpty()) {
            String str = "";
            for (String str2 : this.g.keySet()) {
                str = str + str2 + ":" + this.g.get(str2) + ";";
            }
            mVar.a("frameworksData", str.substring(0, str.length() - 1), false, false);
        }
        mVar.a("packageId", this.k, false);
        mVar.a("installerPkg", this.l, false);
        mVar.a("age", this.i, false);
        if (this.j != null) {
            mVar.a("userAdvertisingId", this.j.a(), false);
            if (this.j.c()) {
                mVar.a("limat", Boolean.valueOf(this.j.c()), false);
            }
            mVar.a("advertisingIdSource", this.j.b(), false);
        } else if (this.m != null) {
            mVar.a("userId", this.m, false);
        }
        mVar.a("model", this.n, false);
        mVar.a("manufacturer", this.o, false);
        mVar.a("deviceVersion", this.p, false);
        mVar.a("locale", this.q, false);
        mVar.a("localeList", this.r, false);
        mVar.a("inputLangs", this.s, false);
        mVar.a("isp", this.x, false);
        mVar.a("ispName", this.y, false);
        mVar.a("netOper", this.z, false);
        mVar.a("networkOperName", this.A, false);
        mVar.a("cid", this.B, false);
        mVar.a("lac", this.C, false);
        mVar.a("blat", this.D, false);
        mVar.a("blon", this.E, false);
        mVar.a("rsc", this.H, false, true);
        mVar.a("subPublisherId", null, false);
        mVar.a("subProductId", null, false);
        mVar.a("retryCount", this.a, false);
        mVar.a("roaming", this.u, false);
        mVar.a("grid", this.v, false);
        mVar.a("silev", this.w, false);
        mVar.a("cellSignalLevel", this.F, false);
        mVar.a("cellTimingAdv", this.G, false);
        mVar.a("outsource", this.t, false);
        mVar.a("width", String.valueOf(this.J), false);
        mVar.a("height", String.valueOf(this.K), false);
        mVar.a("density", String.valueOf(this.L), false);
        mVar.a("fgApp", this.M, false);
        mVar.a("sdkId", String.valueOf(this.N), true);
        mVar.a("clientSessionId", this.O, false);
        mVar.a("appVersion", this.P, false);
        mVar.a("appCode", Integer.valueOf(this.Q), false);
        mVar.a("timeSinceBoot", Long.valueOf(SystemClock.elapsedRealtime()), false);
        mVar.a("locations", this.h, false);
        mVar.a("udbg", Boolean.valueOf(this.R), false);
        mVar.a("root", Boolean.valueOf(this.S), false);
        mVar.a("smltr", Boolean.valueOf(this.T), false);
        mVar.a("isddbg", Boolean.valueOf(this.U), false);
        mVar.a("pas", this.V, false);
    }

    private void a(TelephonyManager telephonyManager) {
        if (telephonyManager.getSimState() != 5) {
            return;
        }
        this.x = telephonyManager.getSimOperator();
        this.y = telephonyManager.getSimOperatorName();
    }

    private void b(TelephonyManager telephonyManager) {
        int phoneType = telephonyManager.getPhoneType();
        if (phoneType != 0 && phoneType != 2) {
            String networkOperator = telephonyManager.getNetworkOperator();
            if (networkOperator != null) {
                this.z = com.startapp.common.b.a.c(networkOperator);
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName == null) {
                return;
            }
            this.A = com.startapp.common.b.a.c(networkOperatorName);
        }
    }

    @SuppressLint({"MissingPermission"})
    private void f(Context context) {
        com.startapp.sdk.c.d.a c = com.startapp.sdk.b.c.a(context).c().c();
        this.B = c.d();
        this.C = c.c();
        this.D = c.a();
        this.E = c.b();
    }

    public final void a(AdPreferences adPreferences, Context context) {
        LinkedList linkedList = null;
        if (adPreferences != null && adPreferences.getLatitude() != null && adPreferences.getLongitude() != null) {
            Location location = new Location("loc");
            location.setLongitude(adPreferences.getLongitude().doubleValue());
            location.setLongitude(adPreferences.getLongitude().doubleValue());
            location.setProvider("API");
            LinkedList linkedList2 = new LinkedList();
            linkedList = linkedList2;
            linkedList2.add(location);
        }
        k.a();
        k.g(context);
        Collection<Location> c = com.startapp.sdk.b.c.a(context).i().c();
        if (c.size() > 0) {
            if (linkedList != null) {
                linkedList.addAll(c);
            } else {
                linkedList = c;
            }
        }
        this.h = linkedList != null ? com.startapp.common.b.a.c(com.startapp.sdk.c.c.a.a(linkedList)) : null;
        a(context, linkedList != null);
    }

    private static void a(Context context, boolean z) {
        j.b(context, "shared_prefs_using_location", Boolean.valueOf(z));
    }

    public final void b(String str) {
        this.H = str;
    }
}
