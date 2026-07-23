package com.startapp.sdk.triggeredlinks;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.JsonReader;
import android.util.MalformedJsonException;
import android.webkit.WebSettings;
import com.startapp.common.a.d;
import com.startapp.common.jobrunner.RunnerRequest;
import com.startapp.common.jobrunner.interfaces.RunnerJob;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.g;
import com.startapp.sdk.adsbase.j.j;
import com.startapp.sdk.adsbase.j.o;
import com.startapp.sdk.adsbase.j.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class c {
    protected final Context a;
    private final SharedPreferences c;
    private Executor d;
    private final d g;
    private final g<TriggeredLinksMetadata> h;
    protected final Runnable b = new Runnable() { // from class: com.startapp.sdk.triggeredlinks.c.1
        @Override // java.lang.Runnable
        public final void run() {
            c.this.e();
        }
    };
    private final Handler e = new Handler(Looper.getMainLooper());
    private final Map<String, Long> f = new HashMap();

    static {
        c.class.getSimpleName();
    }

    public c(Context context, SharedPreferences sharedPreferences, Executor executor, d dVar, g<TriggeredLinksMetadata> gVar) {
        this.a = context;
        this.c = sharedPreferences;
        this.d = new o(executor);
        this.g = dVar;
        this.h = gVar;
    }

    private String f() {
        String a = this.g.b().a();
        String str = a;
        if (a.equals("0")) {
            str = "00000000-0000-0000-0000-000000000000";
        }
        return str;
    }

    private String g() {
        return this.g.b().c() ? "1" : "0";
    }

    private TriggeredLinksMetadata h() {
        TriggeredLinksMetadata a = this.h.a();
        if (a == null || !a.a()) {
            return null;
        }
        return a;
    }

    protected final boolean a(int i) {
        TriggeredLinksMetadata h = h();
        return h != null && (h.f() & i) == i;
    }

    public final void a() {
        TriggeredLinksMetadata h = h();
        AppEventsMetadata d = h != null ? h.d() : null;
        Map<String, String> a = d != null ? d.a() : null;
        if (a != null) {
            b(h, a, "Launch");
        }
    }

    public final void b() {
        TriggeredLinksMetadata h = h();
        AppEventsMetadata d = h != null ? h.d() : null;
        Map<String, String> b = d != null ? d.b() : null;
        if (b != null) {
            b(h, b, "Active");
        }
    }

    public final void c() {
        TriggeredLinksMetadata h = h();
        AppEventsMetadata d = h != null ? h.d() : null;
        Map<String, String> c = d != null ? d.c() : null;
        if (c != null) {
            b(h, c, "Inactive");
        }
    }

    public final void d() {
        com.startapp.common.jobrunner.a.a(this.a);
        com.startapp.common.jobrunner.a.a(new b());
        e();
    }

    protected final void a(long j) {
        if (j > 0) {
            this.e.postDelayed(this.b, j);
        } else {
            this.e.post(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final RunnerJob.a aVar) {
        if (aVar != null) {
            this.e.post(new Runnable() { // from class: com.startapp.sdk.triggeredlinks.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        c.this.b.run();
                    } finally {
                        aVar.a(RunnerJob.Result.SUCCESS);
                    }
                }
            });
        } else {
            this.e.post(this.b);
        }
    }

    protected final void e() {
        String a;
        this.e.removeCallbacks(this.b);
        com.startapp.common.jobrunner.a.a(1347213260, false);
        TriggeredLinksMetadata h = h();
        AppEventsMetadata d = h != null ? h.d() : null;
        Map<String, PeriodicAppEventMetadata> d2 = d != null ? d.d() : null;
        if (d2 != null && d2.size() > 0) {
            SharedPreferences.Editor edit = this.c.edit();
            long currentTimeMillis = System.currentTimeMillis();
            long j = Long.MAX_VALUE;
            for (Map.Entry<String, PeriodicAppEventMetadata> entry : d2.entrySet()) {
                String key = entry.getKey();
                PeriodicAppEventMetadata value = entry.getValue();
                if (key != null && key.length() > 0 && value != null && (a = value.a()) != null && a.length() > 0) {
                    int b = value.b();
                    int i = b;
                    if (b < 5) {
                        i = 5;
                    }
                    long j2 = this.c.getLong(key, 0L);
                    if (j2 > currentTimeMillis) {
                        edit.putLong(key, j2);
                        if (j > j2) {
                            j = j2;
                        }
                    } else {
                        edit.putLong(key, currentTimeMillis + (i * 1000));
                        a(h, key, a, i);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
            if (j != Long.MAX_VALUE) {
                long j3 = j - currentTimeMillis;
                if (j3 < 5000) {
                    a(j3);
                } else {
                    com.startapp.common.jobrunner.a.a(new RunnerRequest.a(1347213260).a(j3).a(RunnerRequest.NetworkType.ANY).b());
                }
            }
        }
    }

    private void a(final TriggeredLinksMetadata triggeredLinksMetadata, final String str, final String str2, final int i) {
        this.d.execute(new Runnable() { // from class: com.startapp.sdk.triggeredlinks.c.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    c.this.a(triggeredLinksMetadata, "Periodic", str, str2);
                } catch (Throwable th) {
                    try {
                        if (c.this.a(1)) {
                            new e(th).a(c.this.a);
                        }
                    } finally {
                        c.this.a(str, i);
                        c.this.a(0L);
                    }
                }
            }
        });
    }

    protected final void a(String str, int i) {
        SharedPreferences.Editor edit = this.c.edit();
        edit.putLong(str, System.currentTimeMillis() + (i * 1000));
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private void b(final TriggeredLinksMetadata triggeredLinksMetadata, final Map<String, String> map, final String str) {
        this.d.execute(new Runnable() { // from class: com.startapp.sdk.triggeredlinks.c.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    c.this.a(triggeredLinksMetadata, map, str);
                } catch (Throwable th) {
                    if (c.this.a(2)) {
                        new e(th).a(c.this.a);
                    }
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0040 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata r18, java.util.Map<java.lang.String, java.lang.String> r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.triggeredlinks.c.a(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata, java.util.Map, java.lang.String):void");
    }

    protected final void a(TriggeredLinksMetadata triggeredLinksMetadata, String str, String str2, String str3) throws IOException, JSONException {
        URLConnection uRLConnection = null;
        InputStream inputStream = null;
        int i = 0;
        String uri = a(Uri.parse(str3)).toString();
        try {
            URLConnection openConnection = new URL(uri).openConnection();
            uRLConnection = openConnection;
            if (openConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setReadTimeout(triggeredLinksMetadata.b() * 1000);
                httpURLConnection.setConnectTimeout(triggeredLinksMetadata.b() * 1000);
                if (Build.VERSION.SDK_INT >= 17) {
                    httpURLConnection.setRequestProperty("User-Agent", WebSettings.getDefaultUserAgent(this.a));
                }
                httpURLConnection.connect();
                i = httpURLConnection.getResponseCode();
                inputStream = httpURLConnection.getInputStream();
                if (Build.VERSION.SDK_INT >= 11) {
                    a(str, str2, inputStream);
                }
            }
            u.a((Closeable) inputStream);
            a(uRLConnection);
            if (triggeredLinksMetadata.c() && i / 100 == 2) {
                new e(InfoEventCategory.TRIGGERED_LINK).f(str2).h().g(new JSONObject().put("eventType", str).put("url", uri).toString()).a(this.a);
            }
        } catch (Throwable th) {
            u.a((Closeable) inputStream);
            a(uRLConnection);
            throw th;
        }
    }

    private void a(String str, String str2, InputStream inputStream) throws IOException {
        try {
            Object a = j.a(new JsonReader(new InputStreamReader(inputStream)));
            if (a instanceof Map) {
                Object obj = ((Map) a).get("throttleSec");
                if (obj instanceof Number) {
                    a(str2, str, ((Number) obj).intValue());
                }
            }
        } catch (IOException e) {
            if (!(e instanceof MalformedJsonException)) {
                throw e;
            }
        }
    }

    private static String a(String str, String str2) {
        return str + "-" + str2;
    }

    private void a(String str, String str2, int i) {
        this.f.put(a(str, str2), Long.valueOf(SystemClock.elapsedRealtime() + (i * 1000)));
    }

    private Uri a(Uri uri) {
        String queryParameter;
        Uri.Builder buildUpon = uri.buildUpon();
        if (Build.VERSION.SDK_INT >= 11) {
            buildUpon.query(null);
            for (String str : uri.getQueryParameterNames()) {
                if (str != null && (queryParameter = uri.getQueryParameter(str)) != null) {
                    boolean z = true;
                    switch (queryParameter.hashCode()) {
                        case -1089147532:
                            if (queryParameter.equals("startapp_package_id")) {
                                z = true;
                                break;
                            }
                            break;
                        case 613582261:
                            if (queryParameter.equals("startapp_no_tracking")) {
                                z = false;
                                break;
                            }
                            break;
                        case 1311708630:
                            if (queryParameter.equals("startapp_advertising_id")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            buildUpon.appendQueryParameter(str, g());
                            continue;
                        case true:
                            buildUpon.appendQueryParameter(str, f());
                            continue;
                        case true:
                            buildUpon.appendQueryParameter(str, this.a.getPackageName());
                            continue;
                        default:
                            buildUpon.appendQueryParameter(str, queryParameter);
                            continue;
                    }
                }
            }
        }
        return buildUpon.build();
    }

    private static void a(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        } catch (Throwable th) {
        }
    }
}
