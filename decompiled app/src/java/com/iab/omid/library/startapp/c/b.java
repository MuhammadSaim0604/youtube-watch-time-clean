package com.iab.omid.library.startapp.c;

import android.view.View;
import com.iab.omid.library.startapp.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b implements a {
    private final a a;

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.iab.omid.library.startapp.c.a
    public final JSONObject a(View view) {
        return com.iab.omid.library.startapp.d.b.a(0, 0, 0, 0);
    }

    @Override // com.iab.omid.library.startapp.c.a
    public final void a(View view, JSONObject jSONObject, a.InterfaceC0004a interfaceC0004a, boolean z) {
        View rootView;
        ArrayList arrayList = new ArrayList();
        com.iab.omid.library.startapp.b.a a = com.iab.omid.library.startapp.b.a.a();
        if (a != null) {
            Collection<com.iab.omid.library.startapp.adsession.b> c = a.c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() << 1) + 3);
            for (com.iab.omid.library.startapp.adsession.b bVar : c) {
                View g = bVar.g();
                if (g != null && com.iab.omid.library.startapp.d.c.b(g) && (rootView = g.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = com.iab.omid.library.startapp.d.c.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && com.iab.omid.library.startapp.d.c.a((View) arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            interfaceC0004a.a((View) it.next(), this.a, jSONObject);
        }
    }
}
