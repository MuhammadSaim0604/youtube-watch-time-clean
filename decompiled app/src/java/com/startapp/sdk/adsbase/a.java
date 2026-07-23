package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.startapp.common.Constants;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.adsbase.activities.OverlayActivity;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private static ProgressDialog f;
    public int a;
    public int b;
    public int c;
    public float d;
    public float e;

    public static String a(Context context, String str) {
        try {
            return context.getResources().getString(context.getApplicationInfo().labelRes);
        } catch (Resources.NotFoundException e) {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            } catch (PackageManager.NameNotFoundException e2) {
            }
            return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : str);
        }
    }

    public static boolean a(Activity activity) {
        boolean z = activity.getTheme().obtainStyledAttributes(new int[]{16843277}).getBoolean(0, false);
        if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
            z = true;
        }
        return z;
    }

    public static int a(String str) {
        String[] split = str.split("&");
        return Integer.parseInt(split[split.length - 1].split("=")[1]);
    }

    public static void a(Context context, String[] strArr, String str, String str2) {
        a(context, strArr, str, 0, str2);
    }

    public static void a(Context context, String[] strArr, String str, int i, String str2) {
        u.a(context, true, "Dropped impression because ".concat(String.valueOf(str2)));
        TrackingParams c = new TrackingParams(str).a(i).c(str2);
        if (strArr != null && strArr.length != 0) {
            for (String str3 : strArr) {
                if (str3 != null && !str3.equalsIgnoreCase("")) {
                    a(context, str3, c, false);
                }
            }
            return;
        }
        new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Non-impression without trackingUrls: ".concat(String.valueOf(str2))).g(c.g()).a(context);
    }

    public static void a(Context context, String str, TrackingParams trackingParams) {
        if (str != null && !str.equalsIgnoreCase("")) {
            u.a(context, false, "Sending impression");
            if (trackingParams != null) {
                trackingParams.a(context);
            }
            a(context, str, trackingParams, true);
        }
    }

    public static void a(Context context, String[] strArr, TrackingParams trackingParams) {
        if (strArr != null) {
            for (String str : strArr) {
                a(context, str, trackingParams);
            }
        }
    }

    public static List<String> a(List<String> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i += 5) {
            int i2 = i;
            arrayList.add(AdsConstants.a + "?" + TextUtils.join("&", list.subList(i2, Math.min(i2 + 5, list.size()))) + "&isShown=" + str + "&appPresence=".concat(String.valueOf(str2)));
        }
        new StringBuilder("newUrlList size = ").append(arrayList.size());
        return arrayList;
    }

    public static final void a(Context context, String str, String str2, TrackingParams trackingParams, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str2)) {
            b(context, str2, trackingParams);
        }
        k.a().e();
        String str3 = null;
        if (!z2) {
            try {
                str3 = a(str, str2);
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
            }
        }
        try {
            String str4 = str + (d(str2) ? com.startapp.common.b.a.a(str3) : "");
            if (MetaData.E().y() && z) {
                a(context, str4, str3);
            } else if (TextUtils.isEmpty(str2) && d(context)) {
                j.b(context, "shared_prefs_CookieFeatureTS", Long.valueOf(System.currentTimeMillis()));
                new StringBuilder("forceExternal - write to sp - TS : ").append(SimpleDateFormat.getDateInstance().format(new Date()));
                d(context, str4 + "&cki=1");
            } else {
                d(context, str4);
            }
        } catch (Throwable th2) {
            new com.startapp.sdk.adsbase.infoevents.e(th2).a(context);
        }
    }

    private static boolean d(String str) {
        return AdsCommonMetaData.a().E() || TextUtils.isEmpty(str);
    }

    public static final void a(Context context, String str, String str2, String str3, TrackingParams trackingParams, long j, long j2, boolean z, Boolean bool) {
        a(context, str, str2, str3, trackingParams, j, j2, z, bool, false, null);
    }

    public static final void a(Context context, String str, String str2, String str3, TrackingParams trackingParams, long j, long j2, boolean z, Boolean bool, boolean z2, Runnable runnable) {
        if (AdsCommonMetaData.a().D()) {
            k.a().e();
            String str4 = null;
            if (!z2) {
                try {
                    str4 = a(str, str2);
                } catch (Throwable th) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                }
            }
            if (str2 != null && !str2.equals("")) {
                b(context, str2, trackingParams);
            }
            a(context, str + (d(str2) ? com.startapp.common.b.a.a(str4) : ""), str3, str4, j, j2, z, bool, runnable);
            return;
        }
        a(context, str, str2, trackingParams, z, z2);
    }

    public static void b(Context context, String str, TrackingParams trackingParams) {
        a(context, str, trackingParams, true);
        u.a(context, false, TextUtils.isEmpty(str) ? "Closed Ad" : "Clicked Ad");
    }

    private static void a(final Context context, final String str, final TrackingParams trackingParams, final boolean z) {
        if (!str.equals("")) {
            ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.sdk.adsbase.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.startapp.sdk.b.c.a(context).m().a(str + (z ? com.startapp.common.b.a.a(a.a(str, (String) null)) : "") + trackingParams.a()).a();
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                    }
                }
            });
        }
    }

    public static void b(final Context context, final String str) {
        ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.sdk.adsbase.a.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.startapp.sdk.b.c.a(context).m().a(str).a();
                } catch (Throwable th) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                }
            }
        });
    }

    private static final void a(Context context, String str, String str2, String str3, long j, long j2, boolean z, Boolean bool, Runnable runnable) {
        com.startapp.common.b.a(context).a(new Intent("com.startapp.android.OnClickCallback"));
        if (b(str)) {
            if (str2 != null && !str2.equals("") && !str.toLowerCase().contains(str2.toLowerCase())) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Wrong package reached, expected: ".concat(String.valueOf(str2))).g("Link: ".concat(String.valueOf(str))).h(str3).a(context);
            }
            d(context, str);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            u.a((Activity) context, true);
        }
        try {
            final WebView webView = new WebView(context);
            if (f == null) {
                if (Build.VERSION.SDK_INT >= 22) {
                    f = new ProgressDialog(context, 16974545);
                } else {
                    f = new ProgressDialog(context);
                }
                f.setTitle((CharSequence) null);
                f.setMessage("Loading....");
                f.setIndeterminate(false);
                f.setCancelable(false);
                f.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.startapp.sdk.adsbase.a.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        webView.stopLoading();
                    }
                });
                if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                    if (!(context instanceof Activity) && b(context) && f.getWindow() != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            f.getWindow().setType(2038);
                        } else {
                            f.getWindow().setType(2003);
                        }
                    }
                }
                f.show();
            }
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient());
            webView.setWebViewClient(new C0034a(j, j2, z, bool, f, str, str2, str3, runnable));
            webView.loadUrl(str);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
            d(context, str);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private static boolean b(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return com.startapp.common.b.b.a(context, "android.permission.SYSTEM_ALERT_WINDOW");
        }
        return Settings.canDrawOverlays(context);
    }

    public static boolean b(String str) {
        return str.startsWith("market") || str.startsWith("http://play.google.com") || str.startsWith("https://play.google.com");
    }

    public static boolean c(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith("https://"));
    }

    public static final void a(Context context) {
        if (context != null && (context instanceof Activity)) {
            u.a((Activity) context, false);
        }
        if (f != null) {
            synchronized (f) {
                if (f != null && f.isShowing()) {
                    f.cancel();
                    f = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class C0034a extends WebViewClient {
        protected String a;
        protected String b;
        protected boolean d;
        protected Runnable e;
        private long i;
        private long j;
        private Boolean k;
        private String l;
        private ProgressDialog m;
        private long o;
        private Timer p;
        protected boolean c = false;
        private boolean h = false;
        protected boolean f = false;
        protected boolean g = false;
        private LinkedHashMap<String, Float> n = new LinkedHashMap<>();

        public C0034a(long j, long j2, boolean z, Boolean bool, ProgressDialog progressDialog, String str, String str2, String str3, Runnable runnable) {
            this.a = "";
            this.d = true;
            this.k = null;
            this.i = j;
            this.j = j2;
            this.d = z;
            this.k = bool;
            this.m = progressDialog;
            this.a = str;
            this.l = str2;
            this.b = str3;
            this.e = runnable;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new StringBuilder("MyWebViewClientSmartRedirect::onPageStarted - [").append(str).append("]");
            super.onPageStarted(webView, str, bitmap);
            if (!this.h) {
                this.o = System.currentTimeMillis();
                this.n.put(str, Float.valueOf(-1.0f));
                final Context context = webView.getContext();
                ThreadManager.a(new Runnable() { // from class: com.startapp.sdk.adsbase.a.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!C0034a.this.c) {
                            try {
                                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Failed smart redirect hop info: " + (C0034a.this.g ? "Page Finished" : "Timeout")).a(C0034a.this.a()).h(C0034a.this.b).a(context);
                            } catch (Throwable th) {
                                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                            }
                            try {
                                C0034a.this.f = true;
                                a.a(context);
                                C0034a.this.b();
                                if (!C0034a.this.d || !MetaData.E().y()) {
                                    a.d(context, C0034a.this.a);
                                } else {
                                    a.a(context, C0034a.this.a, C0034a.this.b);
                                }
                                if (C0034a.this.e != null) {
                                    C0034a.this.e.run();
                                }
                            } catch (Throwable th2) {
                                new com.startapp.sdk.adsbase.infoevents.e(th2).a(context);
                            }
                        }
                    }
                }, this.i);
                this.h = true;
            }
            this.g = false;
            b();
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String lowerCase;
            float f;
            if (webView == null || str == null) {
                return true;
            }
            if (u.a(webView.getContext(), str)) {
                return true;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Float valueOf = Float.valueOf(((float) (currentTimeMillis - this.o)) / 1000.0f);
                this.o = currentTimeMillis;
                this.n.put(this.a, valueOf);
                this.n.put(str, Float.valueOf(-1.0f));
                this.a = str;
                lowerCase = str.toLowerCase();
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(webView.getContext());
            }
            if (!a.b(lowerCase) && !lowerCase.startsWith("intent://")) {
                return false;
            }
            if (!this.f) {
                this.c = true;
                a.a(webView.getContext());
                b();
                a.c(webView.getContext(), lowerCase.startsWith("intent://") ? webView.getUrl() : str);
                if (this.l != null && !this.l.equals("") && !this.a.toLowerCase().contains(this.l.toLowerCase())) {
                    new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Wrong package reached, expected: " + this.l).g("Link: " + this.a).h(this.b).a(webView.getContext());
                } else {
                    boolean z = MetaData.E().analytics.e() && j.a(webView.getContext(), "firstSucceededSmartRedirect", Boolean.TRUE).booleanValue();
                    if (this.k == null) {
                        f = MetaData.E().analytics.d();
                    } else {
                        f = this.k.booleanValue() ? 100.0f : 0.0f;
                    }
                    float f2 = f;
                    if (z || Math.random() * 100.0d < f2) {
                        new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.SUCCESS_SMART_REDIRECT_HOP_INFO).a(a()).h(this.b).a(webView.getContext());
                        j.b(webView.getContext(), "firstSucceededSmartRedirect", Boolean.FALSE);
                    }
                }
                if (this.e != null) {
                    this.e.run();
                }
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            if (!this.c && !this.f && this.a.equals(str) && str != null && !a.b(str) && (str.startsWith("http://") || str.startsWith("https://"))) {
                this.g = true;
                try {
                    a(str);
                } catch (Exception e) {
                }
                final Context context = webView.getContext();
                b();
                try {
                    this.p = new Timer();
                    this.p.schedule(new TimerTask() { // from class: com.startapp.sdk.adsbase.a.a.2
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public final void run() {
                            if (!C0034a.this.f && !C0034a.this.c) {
                                try {
                                    C0034a.this.c = true;
                                    a.a(context);
                                    if (!C0034a.this.d || !MetaData.E().y()) {
                                        a.d(context, C0034a.this.a);
                                    } else {
                                        a.a(context, C0034a.this.a, C0034a.this.b);
                                    }
                                    if (C0034a.this.e != null) {
                                        C0034a.this.e.run();
                                    }
                                } catch (Throwable th) {
                                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                                }
                            }
                        }
                    }, this.j);
                } catch (Exception e2) {
                    this.p = null;
                }
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            b();
            if (str2 != null && !a.b(str2) && a.c(str2)) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Failed smart redirect: ".concat(String.valueOf(i))).g(str2).h(this.b).a(webView.getContext());
            }
            super.onReceivedError(webView, i, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.p != null) {
                this.p.cancel();
                this.p = null;
            }
        }

        private void a(String str) {
            if (this.n.get(str).floatValue() < 0.0f) {
                this.n.put(str, Float.valueOf(((float) (System.currentTimeMillis() - this.o)) / 1000.0f));
            }
        }

        protected final JSONArray a() {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.n.keySet()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    a(str);
                    jSONObject.put("time", this.n.get(str).toString());
                    jSONObject.put("url", str);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    new StringBuilder("error puting url into json [").append(str).append("]");
                }
            }
            return jSONArray;
        }
    }

    public static void c(Context context, String str) {
        d(context, str);
    }

    public static void d(Context context, String str) {
        a(context, str, c(str));
    }

    private static void a(Context context, String str, boolean z) {
        if (context != null) {
            int i = 76021760;
            if (AdsCommonMetaData.a().H() || !(context instanceof Activity)) {
                i = 344457216;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(i);
            boolean a = a(context, intent);
            if (!a) {
                try {
                    if (Build.VERSION.SDK_INT >= 18 && MetaData.E().O() && c(context)) {
                        b(context, str, z);
                        return;
                    }
                } catch (Throwable th) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                    a(context, str, i);
                    return;
                }
            }
            if (z && !a) {
                a(context, intent, i);
            }
            context.startActivity(intent);
        }
    }

    private static void a(Context context, Intent intent, int i) {
        String[] strArr = {"com.android.chrome", "com.android.browser", "com.opera.mini.native", "org.mozilla.firefox", "com.opera.browser"};
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, i);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 1) {
                return;
            }
            for (int i2 = 0; i2 < 5; i2++) {
                String str = strArr[i2];
                if (com.startapp.common.b.b.a(context, str, 0)) {
                    intent.setPackage(str);
                    return;
                }
            }
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }

    private static void a(Context context, String str, int i) {
        try {
            Intent parseUri = Intent.parseUri(str, i);
            a(context, parseUri);
            if (!(context instanceof Activity)) {
                parseUri.addFlags(268435456);
            }
            context.startActivity(parseUri);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Can not open in app browser, clickUrl is empty").h(str2).a(context);
        } else if (b(str) || !u.a(256L)) {
            d(context, str);
        } else {
            try {
                if (Build.VERSION.SDK_INT >= 18 && MetaData.E().N() && c(context)) {
                    b(context, str, true);
                    return;
                }
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
            }
            Intent intent = new Intent(context, OverlayActivity.class);
            if (Build.VERSION.SDK_INT >= 21) {
                intent.addFlags(524288);
            }
            if (Build.VERSION.SDK_INT >= 11) {
                intent.addFlags(32768);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            intent.putExtra("placement", AdPreferences.Placement.INAPP_BROWSER.a());
            intent.putExtra("activityShouldLockOrientation", false);
            try {
                context.startActivity(intent);
            } catch (Throwable th2) {
                new com.startapp.sdk.adsbase.infoevents.e(th2).a(context);
            }
        }
    }

    private static void b(Context context, String str, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Bundle bundle = new Bundle();
        bundle.putBinder("android.support.customtabs.extra.SESSION", null);
        intent.putExtras(bundle);
        if (z) {
            try {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() > 1) {
                    intent.setPackage(queryIntentActivities.get(0).activityInfo.packageName);
                }
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
            }
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private static boolean c(Context context) {
        return j.a(context, "chromeTabs", Boolean.FALSE).booleanValue();
    }

    public static void a(String str, String str2, String str3, Context context, TrackingParams trackingParams) {
        a(context, str3, trackingParams, true);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (str2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    launchIntentForPackage.putExtra(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException e) {
            }
        }
        try {
            context.startActivity(launchIntentForPackage);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[Catch: Exception -> 0x0033, TRY_LEAVE, TryCatch #0 {Exception -> 0x0033, blocks: (B:5:0x0009, B:8:0x0012, B:10:0x0020), top: B:17:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r6, java.lang.String r7) {
        /*
            r0 = r6
            r1 = r7
            java.lang.String r3 = ""
            r2 = r3
            r3 = r1
            if (r3 == 0) goto L31
            r3 = r1
            java.lang.String r4 = ""
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L33
            if (r3 != 0) goto L31
            r3 = r1
        L12:
            java.lang.String r4 = "[?&]d="
            java.lang.String[] r3 = r3.split(r4)     // Catch: java.lang.Exception -> L33
            r5 = r3
            r3 = r5
            r4 = r5
            r0 = r4
            int r3 = r3.length     // Catch: java.lang.Exception -> L33
            r4 = 2
            if (r3 < r4) goto L2e
            r3 = r0
            r4 = 1
            r3 = r3[r4]     // Catch: java.lang.Exception -> L33
            java.lang.String r4 = "[?&]"
            java.lang.String[] r3 = r3.split(r4)     // Catch: java.lang.Exception -> L33
            r4 = 0
            r3 = r3[r4]     // Catch: java.lang.Exception -> L33
            r2 = r3
        L2e:
            r3 = r2
            r0 = r3
            return r0
        L31:
            r3 = r0
            goto L12
        L33:
            r3 = move-exception
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.a.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static boolean a(Context context, Intent intent) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.equalsIgnoreCase(Constants.a)) {
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                return true;
            }
        }
        return false;
    }

    public static String a() {
        return "&position=" + b();
    }

    public static String b() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i = 0; i < 8; i++) {
            if (stackTrace[i].getMethodName().compareTo("doHome") == 0) {
                return "home";
            }
            if (stackTrace[i].getMethodName().compareTo("onBackPressed") == 0) {
                if (k.a().i() || k.p()) {
                    k.a().m();
                    return "back";
                } else {
                    return "interstitial";
                }
            }
        }
        return "interstitial";
    }

    public static String[] a(f fVar) {
        if (!(fVar instanceof HtmlAd)) {
            if (fVar instanceof JsonAd) {
                return a(((JsonAd) fVar).g());
            }
            return new String[0];
        }
        return ((HtmlAd) fVar).trackingUrls;
    }

    public static String[] a(List<AdDetails> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (AdDetails adDetails : list) {
                arrayList.add(adDetails.d());
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean a(Context context, AdPreferences.Placement placement) {
        new StringBuilder("forceExternal - check -placement is : ").append(placement);
        if (placement.equals(AdPreferences.Placement.INAPP_SPLASH) || !AdsCommonMetaData.a().N()) {
            return false;
        }
        return d(context);
    }

    private static boolean d(Context context) {
        return !com.startapp.sdk.b.c.a(context).d().b().c() && a(j.a(context, "shared_prefs_CookieFeatureTS", (Long) 0L).longValue(), System.currentTimeMillis());
    }

    private static boolean a(long j, long j2) {
        if (j != 0 && j + (86400000 * AdsCommonMetaData.a().M()) > j2) {
            return false;
        }
        return true;
    }
}
