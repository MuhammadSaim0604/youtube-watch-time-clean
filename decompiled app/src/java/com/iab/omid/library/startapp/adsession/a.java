package com.iab.omid.library.startapp.adsession;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private final b a;

    private a(b bVar) {
        this.a = bVar;
    }

    public static a a(b bVar) {
        b bVar2 = bVar;
        com.iab.omid.library.startapp.b.a(bVar, "AdSession is null");
        if (bVar2.e().d() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
        com.iab.omid.library.startapp.b.a(bVar2);
        a aVar = new a(bVar2);
        bVar2.e().a(aVar);
        return aVar;
    }

    public final void a() {
        com.iab.omid.library.startapp.b.a(this.a);
        if (!this.a.k()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
        if (!this.a.h()) {
            try {
                this.a.a();
            } catch (Exception e) {
            }
        }
        if (this.a.h()) {
            this.a.d();
        }
    }
}
