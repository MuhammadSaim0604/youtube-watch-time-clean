package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.startapp.common.ThreadManager;
import com.startapp.common.b.e;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.p;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class k implements com.startapp.sdk.adsbase.a.b {
    private static final String b = k.class.getSimpleName();
    private static final AtomicBoolean c = new AtomicBoolean();
    private boolean A;
    private boolean B;
    private f C;
    private com.startapp.sdk.adsbase.a.a D;
    private com.startapp.sdk.triggeredlinks.c E;
    private com.startapp.sdk.adsbase.c.b F;
    private boolean G;
    protected com.startapp.sdk.adsbase.f.d a;
    private SDKAdPreferences d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private long j;
    private Application k;
    private HashMap<Integer, Integer> l;
    private Object m;
    private Activity n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private Map<String, String> t;
    private Bundle u;
    private AdPreferences v;
    private CacheKey w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* synthetic */ k(byte b2) {
        this();
    }

    static /* synthetic */ void a(k kVar, Context context) {
        if (kVar.E != null) {
            return;
        }
        kVar.E = com.startapp.sdk.b.c.a(context).j();
        kVar.E.d();
    }

    static /* synthetic */ void a(k kVar, final Context context, long j) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.startapp.sdk.adsbase.k.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    j.b(context, "User-Agent", new WebView(context).getSettings().getUserAgentString());
                } catch (Throwable th) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                }
            }
        }, j);
    }

    static /* synthetic */ void q() {
    }

    private k() {
        this.e = u.a(512L);
        this.g = false;
        this.h = false;
        this.i = false;
        this.k = null;
        this.l = new HashMap<>();
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = false;
        this.u = null;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class a {
        private static final k a = new k((byte) 0);
    }

    public static k a() {
        return a.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context, String str, String str2, SDKAdPreferences sDKAdPreferences, boolean z) {
        Application application;
        if (!c.getAndSet(true)) {
            final Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("\n+-------------------------------------------------------------+\n|                S   T   A   R   T   A   P   P                |\n| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |\n| Invalid App ID passed to init, please provide valid App ID  |\n|                                                             |\n| https://support.startapp.com/hc/en-us/articles/360002411114 |\n+-------------------------------------------------------------+\n");
            }
            try {
                com.startapp.sdk.b.c a2 = com.startapp.sdk.b.c.a(applicationContext);
                a2.k().a(str, str2);
                if (!com.startapp.common.b.b.a(applicationContext, "android.permission.INTERNET") || !com.startapp.common.b.b.a(applicationContext, "android.permission.ACCESS_NETWORK_STATE")) {
                    u.a(applicationContext, true, "Please grant the mandatory permissions : INTERNET & ACCESS_NETWORK_STATE, SDK could not be initialized.");
                }
                this.q = !u.i(applicationContext);
                TreeMap treeMap = new TreeMap();
                if (c("org.apache.cordova.CordovaPlugin")) {
                    treeMap.put("Cordova", u.b());
                }
                if (c("com.startapp.android.mediation.admob.StartAppCustomEvent")) {
                    treeMap.put("AdMob", d("com.startapp.android.mediation.admob"));
                }
                if (c("com.mopub.mobileads.StartAppCustomEventInterstitial")) {
                    treeMap.put("MoPub", d("com.mopub.mobileads"));
                }
                if (c("anywheresoftware.b4a.BA") && !a.a.t.containsKey("B4A")) {
                    treeMap.put("MoPub", "0");
                }
                if (!treeMap.isEmpty()) {
                    j.a(applicationContext, "sharedPrefsWrappers", treeMap);
                }
                if (this.F == null) {
                    com.startapp.sdk.adsbase.c.b bVar = new com.startapp.sdk.adsbase.c.b(applicationContext, Thread.getDefaultUncaughtExceptionHandler());
                    this.F = bVar;
                    Thread.setDefaultUncaughtExceptionHandler(bVar);
                }
                a2.d().a();
                if (Build.VERSION.SDK_INT >= 14) {
                    if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                    } else if (applicationContext instanceof Activity) {
                        application = ((Activity) applicationContext).getApplication();
                    } else if (applicationContext instanceof Service) {
                        application = ((Service) applicationContext).getApplication();
                    } else {
                        Context applicationContext2 = applicationContext.getApplicationContext();
                        if (applicationContext2 instanceof Application) {
                            application = (Application) applicationContext2;
                        } else {
                            application = null;
                        }
                    }
                    Application application2 = application;
                    if (application2 != null && this.D == null) {
                        com.startapp.sdk.adsbase.a.a aVar = new com.startapp.sdk.adsbase.a.a(this);
                        this.D = aVar;
                        application2.registerActivityLifecycleCallbacks(aVar);
                    }
                }
                com.startapp.common.c.b(applicationContext);
                com.startapp.sdk.adsbase.j.e.a(applicationContext);
                MetaData.a(applicationContext);
                if (!u.a()) {
                    AdsCommonMetaData.a(applicationContext);
                    if (u.a(16L) || u.a(32L)) {
                        BannerMetaData.a(applicationContext);
                    }
                    if (u.a(8L)) {
                        SplashMetaData.a(applicationContext);
                    }
                    if (this.e) {
                        CacheMetaData.a(applicationContext);
                    }
                    if (u.e()) {
                        AdInformationMetaData.a(applicationContext);
                    }
                }
                SimpleTokenUtils.a(applicationContext);
                MetaData.E().a(a2.f());
                a(applicationContext, sDKAdPreferences);
                com.startapp.common.c.a.a(applicationContext);
                Integer a3 = j.a(applicationContext, "shared_prefs_app_version_id", (Integer) (-1));
                int c2 = com.startapp.common.b.b.c(applicationContext);
                if (a3.intValue() > 0 && c2 > a3.intValue()) {
                    this.s = true;
                }
                j.b(applicationContext, "shared_prefs_app_version_id", Integer.valueOf(c2));
                this.x = false;
                this.f = false;
                if (com.startapp.common.b.b.b() && u.a(2L)) {
                    this.x = z;
                    this.f = true;
                    new StringBuilder("Return Ads: [").append(z).append("]");
                }
                if (this.e) {
                    if (this.s || !CacheMetaData.a().b().d()) {
                        com.startapp.sdk.adsbase.cache.a.a().b(applicationContext);
                    } else if (this.f) {
                        com.startapp.sdk.adsbase.cache.a.a().a(applicationContext);
                    }
                    h(applicationContext);
                    com.startapp.sdk.adsbase.cache.a.a().c(applicationContext);
                }
                a(applicationContext, MetaDataRequest.RequestReason.LAUNCH);
                String i = i(applicationContext);
                if (Build.VERSION.SDK_INT < 18 || i == null) {
                    j.b(applicationContext, "chromeTabs", Boolean.FALSE);
                } else {
                    Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                    intent.setPackage(i);
                    List<ResolveInfo> queryIntentServices = applicationContext.getPackageManager().queryIntentServices(intent, 0);
                    j.b(applicationContext, "chromeTabs", Boolean.valueOf((queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true));
                }
                com.startapp.sdk.adsbase.infoevents.e f = new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.GENERAL).f("initialize");
                int i2 = this.o + 1;
                this.o = i2;
                f.g(String.valueOf(i2)).a(applicationContext);
                j.b(applicationContext, "periodicInfoEventPaused", Boolean.FALSE);
                j.b(applicationContext, "periodicMetadataPaused", Boolean.FALSE);
                com.startapp.sdk.adsbase.remoteconfig.b bVar2 = new com.startapp.sdk.adsbase.remoteconfig.b() { // from class: com.startapp.sdk.adsbase.k.1
                    @Override // com.startapp.sdk.adsbase.remoteconfig.b
                    public final void a(MetaDataRequest.RequestReason requestReason, boolean z2) {
                        if (MetaData.E().I()) {
                            k.a(k.this, applicationContext, TimeUnit.SECONDS.toMillis(MetaData.E().H()));
                        }
                        com.startapp.sdk.adsbase.j.e.c(applicationContext);
                        com.startapp.sdk.adsbase.j.e.d(applicationContext);
                        final k kVar = k.this;
                        final Context context2 = applicationContext;
                        if (j.a(context2, "shared_prefs_first_init", Boolean.TRUE).booleanValue()) {
                            j.b(context2, "totalSessions", (Integer) 0);
                            j.b(context2, "firstSessionTime", Long.valueOf(System.currentTimeMillis()));
                            ThreadManager.a(ThreadManager.Priority.DEFAULT, new Runnable() { // from class: com.startapp.sdk.adsbase.k.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        i iVar = new i(context2);
                                        iVar.a(context2, new AdPreferences());
                                        e.a a4 = com.startapp.sdk.b.c.a(context2).m().a(AdsConstants.a(AdsConstants.ServiceApiType.DOWNLOAD)).a(iVar).a();
                                        if (a4 != null) {
                                            String a5 = a4.a();
                                            if (!TextUtils.isEmpty(a5)) {
                                                String a6 = u.a(a5, "@ct@", "@ct@");
                                                String a7 = u.a(a5, "@tsc@", "@tsc@");
                                                String a8 = u.a(a5, "@apc@", "@apc@");
                                                Integer num = null;
                                                Long l = null;
                                                Boolean bool = null;
                                                if (!TextUtils.isEmpty(a6)) {
                                                    num = Integer.valueOf(Integer.parseInt(a6));
                                                }
                                                if (!TextUtils.isEmpty(a7)) {
                                                    l = Long.valueOf(Long.parseLong(a7));
                                                }
                                                if (!TextUtils.isEmpty(a8)) {
                                                    bool = Boolean.valueOf(Boolean.parseBoolean(a8));
                                                }
                                                if (num != null || l != null || bool != null) {
                                                    com.startapp.sdk.b.c.a(context2).f().a(num, l, bool, false, true);
                                                }
                                            }
                                        }
                                        j.b(context2, "shared_prefs_first_init", Boolean.FALSE);
                                    } catch (Throwable th) {
                                        new com.startapp.sdk.adsbase.infoevents.e(th).a(context2);
                                    }
                                }
                            });
                        }
                        com.startapp.sdk.b.c a4 = com.startapp.sdk.b.c.a(applicationContext);
                        k.this.a = a4.l();
                        k.this.a.a(false, null);
                        k.q();
                        k.a(applicationContext);
                        k.a(k.this, applicationContext);
                        a4.e().a();
                    }

                    @Override // com.startapp.sdk.adsbase.remoteconfig.b
                    public final void a() {
                        String unused = k.b;
                        if (MetaData.E().I()) {
                            k.a(k.this, applicationContext, TimeUnit.SECONDS.toMillis(10L));
                        }
                    }
                };
                if (MetaData.E().i()) {
                    bVar2.a(null, false);
                } else {
                    MetaData.E().a(bVar2);
                }
                if (com.startapp.common.b.b.b()) {
                    if (applicationContext instanceof Activity) {
                        this.n = (Activity) applicationContext;
                        this.k = this.n.getApplication();
                    } else if (applicationContext.getApplicationContext() instanceof Application) {
                        this.k = (Application) applicationContext.getApplicationContext();
                    }
                    try {
                        if (this.m != null && this.k != null) {
                            this.k.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) this.m);
                        }
                    } catch (Exception e) {
                    }
                    Application application3 = this.k;
                    Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.startapp.sdk.adsbase.k.3
                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityStopped(Activity activity) {
                            String unused = k.b;
                            new StringBuilder("onActivityStopped [").append(activity.getClass().getName()).append("]");
                            k.a().c(activity);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityStarted(Activity activity) {
                            String unused = k.b;
                            new StringBuilder("onActivityStarted [").append(activity.getClass().getName()).append("]");
                            k.a().a(activity);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            String unused = k.b;
                            new StringBuilder("onActivitySaveInstanceState [").append(activity.getClass().getName()).append("]");
                            k.a();
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityResumed(Activity activity) {
                            String unused = k.b;
                            new StringBuilder("onActivityResumed [").append(activity.getClass().getName()).append("]");
                            k.a().b(activity);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityPaused(Activity activity) {
                            String unused = k.b;
                            new StringBuilder("onActivityPaused [").append(activity.getClass().getName()).append("]");
                            k.a().h();
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityDestroyed(Activity activity) {
                            String unused = k.b;
                            new StringBuilder("onActivityDestroyed [").append(activity.getClass().getName()).append("]");
                            k.a().d(activity);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityCreated(Activity activity, Bundle bundle) {
                            String unused = k.b;
                            new StringBuilder("onActivityCreated [").append(activity.getClass().getName()).append(", ").append(bundle).append("]");
                            k.a().a(activity, bundle);
                            if (u.a(2L)) {
                                e.a.a().a(activity, bundle);
                            }
                        }
                    };
                    application3.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    this.m = activityLifecycleCallbacks;
                }
                u.a(applicationContext, false, "StartApp SDK initialized with App ID: ".concat(String.valueOf(str2)));
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(applicationContext);
            }
        }
    }

    @Override // com.startapp.sdk.adsbase.a.b
    public final void b() {
        if (this.E != null) {
            this.E.a();
        }
        if (this.a != null) {
            this.a.a(false, null);
        }
    }

    @Override // com.startapp.sdk.adsbase.a.b
    public final void c() {
        if (this.E != null) {
            this.E.b();
        }
        if (this.a != null) {
            this.a.a(false, null);
        }
    }

    @Override // com.startapp.sdk.adsbase.a.b
    public final void d() {
        if (this.E != null) {
            this.E.c();
        }
        if (this.a != null) {
            this.a.a(false, null);
        }
    }

    public static void a(Context context) {
        com.startapp.sdk.insight.a.a(context, MetaData.E().c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        j.b(context, "periodicInfoEventPaused", Boolean.TRUE);
        com.startapp.sdk.adsbase.j.e.a(786564404);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context) {
        j.b(context, "periodicMetadataPaused", Boolean.TRUE);
        com.startapp.sdk.adsbase.j.e.a(586482792);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context) {
        j.b(context, "periodicInfoEventPaused", Boolean.FALSE);
        com.startapp.sdk.adsbase.j.e.a(context, j.a(context, "periodicInfoEventTriggerTime", Long.valueOf(com.startapp.sdk.adsbase.j.e.b(context))).longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context) {
        j.b(context, "periodicMetadataPaused", Boolean.FALSE);
        com.startapp.sdk.adsbase.j.e.a(context, Long.valueOf(j.a(context, "periodicMetadataTriggerTime", Long.valueOf(com.startapp.sdk.adsbase.j.e.a())).longValue()));
    }

    private static boolean e(Activity activity) {
        return activity.getClass().getName().equals(u.b((Context) activity));
    }

    private boolean f(Activity activity) {
        return this.B || e(activity);
    }

    public final void a(Activity activity, Bundle bundle) {
        if (e(activity)) {
            this.B = true;
        }
        this.u = bundle;
    }

    public final void a(Activity activity) {
        new StringBuilder("onActivityStarted [").append(activity.getClass().getName()).append("]");
        boolean f = f(activity);
        boolean z = !this.A && f && this.u == null && this.l.size() == 0;
        if (z) {
            com.startapp.sdk.b.c.a(activity).f().h();
        }
        if (u.a(8L) && !com.startapp.sdk.b.c.a(activity).f().b() && !AdsCommonMetaData.a().A() && !this.z && !b("MoPub") && !b("AdMob") && !this.y && z) {
            StartAppAd.a(activity, this.u, new SplashConfig(), new AdPreferences(), null, false);
        }
        if (f) {
            this.B = false;
            this.A = true;
        }
        if (this.g) {
            if (MetaData.E().K() && this.x && !AdsCommonMetaData.a().z() && !u.a() && !this.r) {
                if (System.currentTimeMillis() - this.j > AdsCommonMetaData.a().y()) {
                    this.C = com.startapp.sdk.adsbase.cache.a.a().a(this.w);
                    if (this.C != null && this.C.isReady()) {
                        AdRulesResult a2 = AdsCommonMetaData.a().G().a(AdPreferences.Placement.INAPP_RETURN, (String) null);
                        if (a2.a()) {
                            if (this.C.a((String) null)) {
                                com.startapp.sdk.adsbase.adrules.b.a().a(new com.startapp.sdk.adsbase.adrules.a(AdPreferences.Placement.INAPP_RETURN, null));
                            }
                        } else {
                            com.startapp.sdk.adsbase.a.a(activity, ((ReturnAd) this.C).trackingUrls, (String) null, a2.c());
                        }
                    }
                }
            }
            if (System.currentTimeMillis() - this.j > MetaData.E().s()) {
                a(activity, MetaDataRequest.RequestReason.APP_IDLE);
            }
        }
        this.i = false;
        this.g = false;
        if (this.l.get(Integer.valueOf(activity.hashCode())) == null) {
            this.l.put(Integer.valueOf(activity.hashCode()), 1);
            new StringBuilder("Activity Added:[").append(activity.getClass().getName()).append("]");
            return;
        }
        new StringBuilder("Activity [").append(activity.getClass().getName()).append("] already exists");
    }

    public final void b(Activity activity) {
        if (this.e && this.h) {
            this.h = false;
            com.startapp.sdk.adsbase.cache.a.a().b();
        }
        if (this.p) {
            this.p = false;
            SimpleTokenUtils.c(activity.getApplicationContext());
        }
        this.n = activity;
    }

    public final void e() {
        this.p = true;
        this.h = true;
    }

    public final void a(boolean z) {
        this.r = z;
    }

    public final boolean f() {
        return this.q;
    }

    public final boolean g() {
        return this.s;
    }

    public final void h() {
        this.j = System.currentTimeMillis();
        this.n = null;
    }

    public final void c(Activity activity) {
        new StringBuilder("onActivityStopped [").append(activity.getClass().getName()).append("]");
        Integer num = this.l.get(Integer.valueOf(activity.hashCode()));
        if (num != null) {
            Integer valueOf = Integer.valueOf(num.intValue() - 1);
            if (valueOf.intValue() != 0) {
                this.l.put(Integer.valueOf(activity.hashCode()), valueOf);
            } else {
                this.l.remove(Integer.valueOf(activity.hashCode()));
            }
            new StringBuilder("Activity removed:[").append(activity.getClass().getName()).append("]");
            if (this.l.size() == 0) {
                if (!this.i) {
                    this.g = true;
                    h(activity);
                    if (com.startapp.common.c.a() != null) {
                        com.startapp.common.c.a().a(activity);
                    }
                }
                if (this.e) {
                    com.startapp.sdk.adsbase.cache.a.a().a(activity.getApplicationContext(), this.i);
                    this.h = true;
                    return;
                }
                return;
            }
            return;
        }
        new StringBuilder("Activity hadn't been found:[").append(activity.getClass().getName()).append("]");
    }

    public final void d(Activity activity) {
        if (f(activity)) {
            this.A = false;
        }
        if (this.l.size() == 0) {
            this.g = false;
        }
    }

    public final boolean i() {
        if (this.n != null) {
            return this.n.isTaskRoot();
        }
        return true;
    }

    public final boolean j() {
        return this.x;
    }

    public final void b(boolean z) {
        this.y = z;
    }

    public final void c(boolean z) {
        this.z = !z;
        if (!z) {
            com.startapp.sdk.adsbase.cache.a.a().b(AdPreferences.Placement.INAPP_SPLASH);
        }
    }

    public final boolean k() {
        return !this.z;
    }

    public final boolean l() {
        return (!this.f || this.g || this.i) ? false : true;
    }

    public final boolean a(AdPreferences.Placement placement) {
        if (this.f && !this.i) {
            if (this.g) {
                return placement == AdPreferences.Placement.INAPP_RETURN && CacheMetaData.a().b().e();
            }
            return true;
        }
        return false;
    }

    public final void m() {
        this.g = false;
        this.i = true;
    }

    public final boolean n() {
        return this.f && this.g;
    }

    public final void a(Context context, String str, String str2) {
        if (this.t == null) {
            this.t = new TreeMap();
        }
        this.t.put(str, str2);
        j.a(context, "sharedPrefsWrappers", this.t);
    }

    private String a(String str) {
        if (this.t != null) {
            return this.t.get(str);
        }
        return null;
    }

    private boolean b(String str) {
        return a(str) != null;
    }

    public final SDKAdPreferences f(Context context) {
        if (this.d == null) {
            SDKAdPreferences sDKAdPreferences = (SDKAdPreferences) com.startapp.common.b.d.a(context, "shared_prefs_sdk_ad_prefs");
            if (sDKAdPreferences == null) {
                this.d = new SDKAdPreferences();
            } else {
                this.d = sDKAdPreferences;
            }
        }
        return this.d;
    }

    public final void a(Context context, SDKAdPreferences sDKAdPreferences) {
        this.d = sDKAdPreferences;
        com.startapp.common.b.d.b(context, "shared_prefs_sdk_ad_prefs", this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, MetaDataRequest.RequestReason requestReason) {
        p.d().a(context, requestReason);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(boolean z) {
        boolean z2 = z && com.startapp.common.b.b.b();
        this.x = z2;
        if (!z2) {
            com.startapp.sdk.adsbase.cache.a.a().b(AdPreferences.Placement.INAPP_RETURN);
        }
    }

    public final boolean o() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(boolean z) {
        this.G = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, boolean z, boolean z2) {
        if ("pas".equalsIgnoreCase(str)) {
            String string = context.getSharedPreferences("com.startapp.sdk", 0).getString("USER_CONSENT_PERSONALIZED_ADS_SERVING", null);
            if (!TextUtils.isEmpty(string)) {
                if (string.equalsIgnoreCase(z ? "1" : "0")) {
                    return;
                }
            }
            new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.GENERAL).f("User consent: ".concat(String.valueOf(str))).g((z ? "1" : "0") + (z2 ? "M" : "A")).a(context);
            j.b(context, "USER_CONSENT_PERSONALIZED_ADS_SERVING", z ? "1" : "0");
            p.d().a(context, MetaDataRequest.RequestReason.PAS);
        }
    }

    public static void g(Context context) {
        b(context, "android.permission.ACCESS_FINE_LOCATION", "USER_CONSENT_FINE_LOCATION");
        b(context, "android.permission.ACCESS_COARSE_LOCATION", "USER_CONSENT_COARSE_LOCATION");
    }

    private static void b(Context context, String str, String str2) {
        boolean booleanValue = j.a(context, str2, Boolean.FALSE).booleanValue();
        boolean a2 = com.startapp.common.b.b.a(context, str);
        if (booleanValue != a2) {
            j.b(context, str2, Boolean.valueOf(a2));
            System.currentTimeMillis();
            a(context, str, a2, false);
        }
    }

    private void h(Context context) {
        if (this.x && !AdsCommonMetaData.a().z()) {
            this.w = com.startapp.sdk.adsbase.cache.a.a().a(context, s());
        }
    }

    private static boolean c(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    private static String d(String str) {
        try {
            return (String) Class.forName(str + ".StartAppConstants").getField("WRAPPER_VERSION").get(null);
        } catch (Exception e) {
            return "0";
        }
    }

    private static String i(Context context) {
        String str = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            String str2 = null;
            if (resolveActivity != null) {
                str2 = resolveActivity.activityInfo.packageName;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                Intent intent2 = new Intent();
                intent2.setAction("android.support.customtabs.action.CustomTabsService");
                intent2.setPackage(resolveInfo.activityInfo.packageName);
                if (packageManager.resolveService(intent2, 0) != null) {
                    arrayList.add(resolveInfo.activityInfo.packageName);
                }
            }
            if (arrayList.isEmpty()) {
                str = null;
            } else if (arrayList.size() == 1) {
                str = (String) arrayList.get(0);
            } else if (!TextUtils.isEmpty(str2) && !a(context, intent) && arrayList.contains(str2)) {
                str = str2;
            } else if (arrayList.contains("com.android.chrome")) {
                str = "com.android.chrome";
            }
        } catch (Exception e) {
        }
        return str;
    }

    private static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        try {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (RuntimeException e) {
        }
        if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            IntentFilter intentFilter = resolveInfo.filter;
            if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                return true;
            }
        }
        return false;
    }

    private AdPreferences s() {
        AdPreferences adPreferences = this.v;
        return adPreferences != null ? new AdPreferences(adPreferences) : new AdPreferences();
    }

    public final void a(AdPreferences adPreferences) {
        AdPreferences adPreferences2;
        boolean z = !u.b(this.v, adPreferences);
        if (adPreferences != null) {
            adPreferences2 = r4;
            AdPreferences adPreferences3 = new AdPreferences(adPreferences);
        } else {
            adPreferences2 = null;
        }
        this.v = adPreferences2;
        if (z) {
            com.startapp.sdk.adsbase.cache.a.a().a(AdPreferences.Placement.INAPP_RETURN);
        }
    }

    public static boolean p() {
        return a.a.a("Unity") != null;
    }
}
