package com.startapp.sdk.adsbase.d;

import com.startapp.common.b.e;
import com.startapp.sdk.adsbase.j.q;
import com.startapp.sdk.adsbase.j.u;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    final String a;
    com.startapp.sdk.adsbase.c b;
    q<String> c;
    int d = 3;
    long e = 0;
    private final b f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, String str) {
        this.f = bVar;
        this.a = str;
    }

    public final a a(com.startapp.sdk.adsbase.c cVar) {
        this.b = cVar;
        return this;
    }

    public final a a(q<String> qVar) {
        this.c = qVar;
        return this;
    }

    public final a a(int i) {
        this.d = i;
        return this;
    }

    public final a a(long j) {
        this.e = j;
        return this;
    }

    public final <T> T a(Class<T> cls) {
        e.a a = a();
        if (a != null) {
            try {
                return (T) u.a(a.a(), (Class<Object>) cls);
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(this.f.a);
            }
        }
        return null;
    }

    public final e.a a() {
        return this.f.a(this);
    }

    public final String b() {
        return this.f.b(this);
    }
}
