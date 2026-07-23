package com.iab.omid.library.startapp.walking;

import android.support.annotation.VisibleForTesting;
import com.iab.omid.library.startapp.walking.a.b;
import com.iab.omid.library.startapp.walking.a.d;
import com.iab.omid.library.startapp.walking.a.e;
import com.iab.omid.library.startapp.walking.a.f;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b implements b.InterfaceC0005b {
    private JSONObject a;
    private final com.iab.omid.library.startapp.walking.a.c b;

    public b(com.iab.omid.library.startapp.walking.a.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.startapp.walking.a.b.InterfaceC0005b
    @VisibleForTesting
    public final JSONObject a() {
        return this.a;
    }

    @Override // com.iab.omid.library.startapp.walking.a.b.InterfaceC0005b
    @VisibleForTesting
    public final void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public final void a(JSONObject jSONObject, HashSet<String> hashSet, double d) {
        this.b.a(new f(this, hashSet, jSONObject, d));
    }

    public final void b() {
        this.b.a(new d(this));
    }

    public final void b(JSONObject jSONObject, HashSet<String> hashSet, double d) {
        this.b.a(new e(this, hashSet, jSONObject, d));
    }
}
