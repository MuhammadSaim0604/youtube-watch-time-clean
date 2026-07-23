package com.iab.omid.library.startapp.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.startapp.c.a;
import com.startapp.sdk.ads.video.VideoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a implements a.InterfaceC0004a {
    private static a a = new a();
    private static Handler b = new Handler(Looper.getMainLooper());
    private static Handler c = null;
    private static final Runnable j = new Runnable() { // from class: com.iab.omid.library.startapp.walking.a.2
        @Override // java.lang.Runnable
        public final void run() {
            a.b(a.a());
        }
    };
    private static final Runnable k = new Runnable() { // from class: com.iab.omid.library.startapp.walking.a.3
        @Override // java.lang.Runnable
        public final void run() {
            if (a.c != null) {
                a.c.post(a.j);
                a.c.postDelayed(a.k, 200L);
            }
        }
    };
    private int e;
    private double i;
    private List<Object> d = new ArrayList();
    private VideoUtil g = new VideoUtil();
    private com.startapp.sdk.ads.banner.bannerstandard.b f = new com.startapp.sdk.ads.banner.bannerstandard.b();
    private b h = new b(new com.iab.omid.library.startapp.walking.a.c());

    a() {
    }

    public static a a() {
        return a;
    }

    private void a(View view, com.iab.omid.library.startapp.c.a aVar, JSONObject jSONObject, c cVar) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW);
    }

    public static void d() {
        h();
    }

    private static void h() {
        if (c != null) {
            c.removeCallbacks(k);
            c = null;
        }
    }

    public static void b() {
        if (c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            c = handler;
            handler.post(j);
            c.postDelayed(k, 200L);
        }
    }

    public final void c() {
        h();
        this.d.clear();
        b.post(new Runnable() { // from class: com.iab.omid.library.startapp.walking.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.h.b();
            }
        });
    }

    @Override // com.iab.omid.library.startapp.c.a.InterfaceC0004a
    public final void a(View view, com.iab.omid.library.startapp.c.a aVar, JSONObject jSONObject) {
        c c2;
        boolean z;
        if (com.iab.omid.library.startapp.d.c.c(view) && (c2 = this.g.c(view)) != c.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            com.iab.omid.library.startapp.d.b.a(jSONObject, a2);
            String a3 = this.g.a(view);
            if (a3 != null) {
                com.iab.omid.library.startapp.d.b.a(a2, a3);
                this.g.e();
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ArrayList<String> b2 = this.g.b(view);
                if (b2 != null) {
                    com.iab.omid.library.startapp.d.b.a(a2, b2);
                }
                a(view, aVar, a2, c2);
            }
            this.e++;
        }
    }

    static /* synthetic */ void b(a aVar) {
        aVar.e = 0;
        aVar.i = com.iab.omid.library.startapp.b.b();
        aVar.g.c();
        double b2 = com.iab.omid.library.startapp.b.b();
        com.iab.omid.library.startapp.c.a a2 = aVar.f.a();
        if (aVar.g.b().size() > 0) {
            aVar.h.b(a2.a(null), aVar.g.b(), b2);
        }
        if (aVar.g.a().size() > 0) {
            JSONObject a3 = a2.a(null);
            aVar.a(null, a2, a3, c.PARENT_VIEW);
            com.iab.omid.library.startapp.d.b.a(a3);
            aVar.h.a(a3, aVar.g.a(), b2);
        } else {
            aVar.h.b();
        }
        aVar.g.d();
        com.iab.omid.library.startapp.b.b();
        if (aVar.d.size() > 0) {
            Iterator<Object> it = aVar.d.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
