package com.iab.omid.library.startapp.adsession;

import android.os.Build;
import android.view.View;
import com.iab.omid.library.startapp.b.c;
import com.iab.omid.library.startapp.b.d;
import com.iab.omid.library.startapp.publisher.AdSessionStatePublisher;
import com.startapp.common.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b {
    private final com.startapp.common.c.a a;
    private final e b;
    private final List<com.iab.omid.library.startapp.e.a> c;
    private com.iab.omid.library.startapp.e.a d;
    private AdSessionStatePublisher e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;

    public b() {
    }

    public final void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        com.iab.omid.library.startapp.b.a.a().b(this);
        this.e.a(com.iab.omid.library.startapp.b.e.a().d());
        AdSessionStatePublisher adSessionStatePublisher = this.e;
        com.startapp.common.c.a aVar = this.a;
        String str = this.h;
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.startapp.d.b.a(jSONObject, "environment", "app");
        com.iab.omid.library.startapp.d.b.a(jSONObject, "adSessionType", aVar.g());
        JSONObject jSONObject2 = new JSONObject();
        com.iab.omid.library.startapp.d.b.a(jSONObject2, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        com.iab.omid.library.startapp.d.b.a(jSONObject2, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        com.iab.omid.library.startapp.d.b.a(jSONObject2, "os", "Android");
        com.iab.omid.library.startapp.d.b.a(jSONObject, "deviceInfo", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        com.iab.omid.library.startapp.d.b.a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        com.iab.omid.library.startapp.d.b.a(jSONObject3, "partnerName", aVar.b().a());
        com.iab.omid.library.startapp.d.b.a(jSONObject3, "partnerVersion", aVar.b().b());
        com.iab.omid.library.startapp.d.b.a(jSONObject, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        com.iab.omid.library.startapp.d.b.a(jSONObject4, "libraryVersion", "1.2.0-Startapp");
        com.iab.omid.library.startapp.d.b.a(jSONObject4, "appId", c.a().b().getApplicationContext().getPackageName());
        com.iab.omid.library.startapp.d.b.a(jSONObject, "app", jSONObject4);
        if (aVar.e() != null) {
            com.iab.omid.library.startapp.d.b.a(jSONObject, "customReferenceData", aVar.e());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (com.startapp.networkTest.utils.e eVar : aVar.c()) {
            com.iab.omid.library.startapp.d.b.a(jSONObject5, eVar.a(), eVar.c());
        }
        d.a().a(adSessionStatePublisher.c(), str, jSONObject, jSONObject5);
    }

    public final void a(View view) {
        if (this.g) {
            return;
        }
        com.iab.omid.library.startapp.b.a(view, "AdView is null");
        if (g() == view) {
            return;
        }
        d(view);
        this.e.f();
        Collection<b> b = com.iab.omid.library.startapp.b.a.a().b();
        if (b == null || b.size() <= 0) {
            return;
        }
        for (b bVar : b) {
            if (bVar != this && bVar.g() == view) {
                bVar.d.clear();
            }
        }
    }

    public final void b() {
        if (this.g) {
            return;
        }
        this.d.clear();
        if (!this.g) {
            this.c.clear();
        }
        this.g = true;
        d.a().a(this.e.c());
        com.iab.omid.library.startapp.b.a.a().c(this);
        this.e.b();
        this.e = null;
    }

    public final void b(View view) {
        if (this.g) {
            return;
        }
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (c(view) == null) {
            this.c.add(new com.iab.omid.library.startapp.e.a(view));
        }
    }

    public static b a(e eVar, com.startapp.common.c.a aVar) {
        if (com.iab.omid.library.startapp.a.b()) {
            com.iab.omid.library.startapp.b.a(eVar, "AdSessionConfiguration is null");
            com.iab.omid.library.startapp.b.a(aVar, "AdSessionContext is null");
            return new b(eVar, aVar);
        }
        throw new IllegalStateException("Method called before OMID activation");
    }

    private b(e eVar, com.startapp.common.c.a aVar) {
        this();
        this.c = new ArrayList();
        this.f = false;
        this.g = false;
        this.b = eVar;
        this.a = aVar;
        this.h = UUID.randomUUID().toString();
        d(null);
        if (aVar.g() == AdSessionContextType.HTML) {
            this.e = new com.iab.omid.library.startapp.publisher.a(aVar.d());
        } else {
            this.e = new com.iab.omid.library.startapp.publisher.b(aVar.c(), aVar.f());
        }
        this.e.a();
        com.iab.omid.library.startapp.b.a.a().a(this);
        d.a().a(this.e.c(), eVar.c());
    }

    private com.iab.omid.library.startapp.e.a c(View view) {
        for (com.iab.omid.library.startapp.e.a aVar : this.c) {
            if (aVar.get() == view) {
                return aVar;
            }
        }
        return null;
    }

    public final List<com.iab.omid.library.startapp.e.a> c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        if (this.i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
        d.a().b(this.e.c());
        this.i = true;
    }

    public final AdSessionStatePublisher e() {
        return this.e;
    }

    public final String f() {
        return this.h;
    }

    public final View g() {
        return (View) this.d.get();
    }

    private void d(View view) {
        this.d = new com.iab.omid.library.startapp.e.a(view);
    }

    public final boolean h() {
        return this.f && !this.g;
    }

    public final boolean i() {
        return this.f;
    }

    public final boolean j() {
        return this.g;
    }

    public final boolean k() {
        return this.b.a();
    }

    public final boolean l() {
        return this.b.b();
    }
}
