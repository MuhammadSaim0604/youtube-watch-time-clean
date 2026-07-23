package com.startapp.sdk.adsbase.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.startapp.common.SDKException;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.g;
import com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class a {
    protected final Executor a;
    private Context b;
    private final SharedPreferences c;
    private b d;
    private final g<NetworkDiagnosticConfig> e;
    private boolean f;
    private final Runnable g = new Runnable() { // from class: com.startapp.sdk.adsbase.e.a.1
        @Override // java.lang.Runnable
        public final void run() {
            a.this.b();
        }
    };

    static {
        a.class.getSimpleName();
    }

    public a(Context context, SharedPreferences sharedPreferences, b bVar, Executor executor, g<NetworkDiagnosticConfig> gVar) {
        this.b = context;
        this.c = sharedPreferences;
        this.d = bVar;
        this.a = executor;
        this.e = gVar;
    }

    private NetworkDiagnosticConfig c() {
        NetworkDiagnosticConfig a = this.e.a();
        if (a == null || !a.a()) {
            return null;
        }
        return a;
    }

    private boolean a(int i) {
        NetworkDiagnosticConfig c = c();
        return c != null && (c.e() & i) == i;
    }

    public final c a() {
        return new c(this);
    }

    public final void a(String str, String str2, SDKException sDKException, final long j) {
        int i;
        String str3;
        NetworkDiagnosticConfig c = c();
        if (c != null) {
            if (sDKException != null) {
                if (sDKException.getCause() != null) {
                    i = 2;
                    str3 = "Failure: " + sDKException.getCause().getClass().getName();
                } else {
                    i = 1;
                    str3 = "Error: " + sDKException.b();
                }
            } else {
                i = 4;
                str3 = "Success";
            }
            if ((c.d() & i) != 0) {
                Uri a = sDKException != null ? sDKException.a() : null;
                Uri uri = a;
                if (a == null) {
                    uri = Uri.parse(str2).buildUpon().query(null).build();
                }
                final String str4 = str + ' ' + uri;
                final String str5 = str3;
                this.a.execute(new Runnable() { // from class: com.startapp.sdk.adsbase.e.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(str4, str5, j);
                    }
                });
            }
            if (i == 4) {
                this.a.execute(this.g);
            }
        }
    }

    protected final void a(String str, String str2, long j) {
        try {
            this.d.a(str, str2, System.currentTimeMillis(), j);
        } catch (Throwable th) {
            if (a(1)) {
                new e(th).a(this.b);
            }
        }
    }

    protected final void b() {
        NetworkDiagnosticConfig c = c();
        if (c != null && !this.f) {
            long j = this.c.getLong("181bb7005f9db75a", 0L) + (c.b() * 60000);
            long currentTimeMillis = System.currentTimeMillis();
            if (j <= currentTimeMillis) {
                this.f = a(c, currentTimeMillis);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0156 A[Catch: Throwable -> 0x019d, TRY_LEAVE, TryCatch #0 {Throwable -> 0x019d, blocks: (B:3:0x0014, B:5:0x002a, B:7:0x0032, B:9:0x0079, B:14:0x013e, B:16:0x014a, B:20:0x0156, B:27:0x018c), top: B:46:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig r37, long r38) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.e.a.a(com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig, long):boolean");
    }

    protected final void a(long j, List<C0039a> list) {
        this.f = false;
        try {
            for (C0039a c0039a : list) {
                this.d.a(c0039a.a, c0039a.b, j);
            }
        } catch (Throwable th) {
            if (a(4)) {
                new e(th).a(this.b);
            }
        }
        try {
            a(j);
        } catch (Throwable th2) {
            if (a(8)) {
                new e(th2).a(this.b);
            }
        }
    }

    private void a(long j) {
        this.c.edit().putLong("181bb7005f9db75a", j).commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.e.a$3  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public final class AnonymousClass3 implements com.startapp.sdk.adsbase.infoevents.c {
        List<C0039a> a = new LinkedList();
        final /* synthetic */ long b;

        AnonymousClass3(long j) {
            this.b = j;
        }

        @Override // com.startapp.sdk.adsbase.infoevents.c
        public final void a(e eVar, boolean z) {
            if (z && (eVar.l() instanceof C0039a)) {
                this.a.add((C0039a) eVar.l());
            }
        }

        @Override // com.startapp.sdk.adsbase.infoevents.c
        public final void a() {
            a.this.a.execute(new Runnable() { // from class: com.startapp.sdk.adsbase.e.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a(AnonymousClass3.this.b, AnonymousClass3.this.a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.e.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class C0039a {
        final long a;
        final long b;

        C0039a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }
}
