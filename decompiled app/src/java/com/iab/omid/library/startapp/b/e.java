package com.iab.omid.library.startapp.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.startapp.b.b;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class e implements com.iab.omid.library.startapp.a.a, b.a {
    private static e a;
    private float b = 0.0f;
    private final com.startapp.common.b.c c;
    private final com.iab.omid.library.startapp.d.c d;
    private com.iab.omid.library.startapp.a.b e;
    private a f;

    private e(com.startapp.common.b.c cVar, com.iab.omid.library.startapp.d.c cVar2) {
        this.c = cVar;
        this.d = cVar2;
    }

    public static e a() {
        if (a == null) {
            a = new e(new com.startapp.common.b.c(), new com.iab.omid.library.startapp.d.c());
        }
        return a;
    }

    @Override // com.iab.omid.library.startapp.b.b.a
    public final void a(boolean z) {
        if (z) {
            com.iab.omid.library.startapp.walking.a.a();
            com.iab.omid.library.startapp.walking.a.b();
            return;
        }
        com.iab.omid.library.startapp.walking.a.a();
        com.iab.omid.library.startapp.walking.a.d();
    }

    public final void b() {
        b.a().a(this);
        b.a().b();
        if (b.a().d()) {
            com.iab.omid.library.startapp.walking.a.a();
            com.iab.omid.library.startapp.walking.a.b();
        }
        this.e.a();
    }

    public final void c() {
        com.iab.omid.library.startapp.walking.a.a().c();
        b.a().c();
        this.e.b();
    }

    public final float d() {
        return this.b;
    }

    public final void a(Context context) {
        this.e = new com.iab.omid.library.startapp.a.b(new Handler(), context, new com.iab.omid.library.startapp.d.a(), this);
    }

    @Override // com.iab.omid.library.startapp.a.a
    public final void a(float f) {
        this.b = f;
        if (this.f == null) {
            this.f = a.a();
        }
        for (com.iab.omid.library.startapp.adsession.b bVar : this.f.c()) {
            bVar.e().a(f);
        }
    }
}
