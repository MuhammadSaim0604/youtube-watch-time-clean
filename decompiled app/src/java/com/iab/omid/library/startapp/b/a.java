package com.iab.omid.library.startapp.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private static a a = new a();
    private final ArrayList<com.iab.omid.library.startapp.adsession.b> b = new ArrayList<>();
    private final ArrayList<com.iab.omid.library.startapp.adsession.b> c = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return a;
    }

    private boolean d() {
        return this.c.size() > 0;
    }

    public final void a(com.iab.omid.library.startapp.adsession.b bVar) {
        this.b.add(bVar);
    }

    public final Collection<com.iab.omid.library.startapp.adsession.b> b() {
        return Collections.unmodifiableCollection(this.b);
    }

    public final void b(com.iab.omid.library.startapp.adsession.b bVar) {
        boolean d = d();
        this.c.add(bVar);
        if (d) {
            return;
        }
        e.a().b();
    }

    public final Collection<com.iab.omid.library.startapp.adsession.b> c() {
        return Collections.unmodifiableCollection(this.c);
    }

    public final void c(com.iab.omid.library.startapp.adsession.b bVar) {
        boolean d = d();
        this.b.remove(bVar);
        this.c.remove(bVar);
        if (!d || d()) {
            return;
        }
        e.a().c();
    }
}
