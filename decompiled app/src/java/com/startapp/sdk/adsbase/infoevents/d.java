package com.startapp.sdk.adsbase.infoevents;

import android.content.Context;
import android.os.Build;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.io.File;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class d implements Runnable {
    private final Context a;
    private final e b;
    private final c c;
    private final Exception d = new Exception();

    static {
        d.class.getSimpleName();
    }

    public d(Context context, e eVar, c cVar) {
        this.a = context;
        this.b = eVar;
        this.c = cVar;
    }

    private Throwable a(Throwable th) {
        if (Build.VERSION.SDK_INT >= 19) {
            th.addSuppressed(this.d);
        }
        return th;
    }

    public final void a() {
        AnalyticsConfig analyticsConfig = MetaData.E().analytics;
        if (analyticsConfig != null && !analyticsConfig.dns) {
            ThreadManager.a(ThreadManager.Priority.DEFAULT, this);
        } else if (this.c != null) {
            this.c.a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String[] strArr = null;
        String str = null;
        String[] strArr2 = null;
        e eVar = this.b;
        while (true) {
            e eVar2 = eVar;
            if (eVar2 == null) {
                break;
            }
            if (eVar2.g().e()) {
                if (strArr == null) {
                    strArr = new String[]{u.j(this.a)};
                }
                eVar2.m(strArr[0]);
            }
            if (eVar2.g().b()) {
                if (str == null) {
                    str = u.e(this.a);
                }
                eVar2.i(str);
                if (strArr2 == null) {
                    strArr2 = u.k(this.a);
                }
                eVar2.k(strArr2[0]);
                eVar2.j(strArr2[1]);
            }
            InfoEventCategory g = eVar2.g();
            if (g.h()) {
                SimpleTokenUtils.b(this.a);
            }
            eVar2.d(this.a);
            if (g.b()) {
                try {
                    eVar2.b(this.a, null);
                } catch (Throwable th) {
                }
            }
            if (g.c()) {
                try {
                    eVar2.c(this.a);
                } catch (Throwable th2) {
                    new e(a(th2)).a(this.a);
                }
            }
            if (g.d()) {
                try {
                    eVar2.e(this.a);
                } catch (Throwable th3) {
                    new e(a(th3)).a(this.a);
                }
            }
            if (g.f()) {
                try {
                    eVar2.a((AdPreferences) null, this.a);
                } catch (Throwable th4) {
                    new e(a(th4)).a(this.a);
                }
            }
            if (g.g()) {
                try {
                    eVar2.b(this.a);
                } catch (Throwable th5) {
                    new e(a(th5)).a(this.a);
                }
            }
            try {
                eVar2.b(com.startapp.sdk.b.c.a(this.a).e().a(eVar2));
            } catch (Throwable th6) {
                new e(a(th6)).a(this.a);
            }
            File i = eVar2.i();
            if (i != null) {
                try {
                    eVar2.g(u.b(i));
                } catch (Throwable th7) {
                    new e(a(th7)).a(this.a);
                }
            }
            try {
                AnalyticsConfig analyticsConfig = MetaData.E().analytics;
                String j = eVar2.j();
                String str2 = j;
                if (j == null) {
                    if (InfoEventCategory.PERIODIC.equals(g)) {
                        str2 = analyticsConfig.a();
                    } else {
                        str2 = analyticsConfig.hostSecured;
                    }
                }
                boolean z = com.startapp.sdk.b.c.a(this.a).m().a(str2).a(eVar2).a(analyticsConfig.b()).a(analyticsConfig.c()).b() != null;
                if (this.c != null) {
                    this.c.a(eVar2, z);
                }
            } finally {
                try {
                    eVar = eVar2.k();
                } finally {
                }
            }
            eVar = eVar2.k();
        }
        if (this.c != null) {
            this.c.a();
        }
    }
}
