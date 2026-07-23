package com.startapp.b.a.f;

import com.startapp.b.a.a.f;
import com.startapp.b.a.h.c;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private final com.startapp.b.a.e.b a;
    private final c b;

    public a(com.startapp.b.a.e.b bVar, c cVar) {
        this.b = cVar;
        this.a = bVar;
    }

    public final String a(com.startapp.b.a.h.a aVar, f fVar, long j) {
        try {
            String a = com.startapp.b.a.e.b.a(fVar);
            return j + "-" + aVar.a() + "-" + this.b.b(aVar).a(a);
        } catch (Throwable th) {
            return null;
        }
    }
}
