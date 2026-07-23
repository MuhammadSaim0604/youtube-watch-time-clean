package com.startapp.sdk.adsbase.adrules;

import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    private static b a = new b();
    private List<a> b = new ArrayList();
    private Map<AdPreferences.Placement, List<a>> c = new HashMap();
    private Map<String, List<a>> d = new HashMap();

    public static b a() {
        return a;
    }

    public final void b() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    public final List<a> a(AdPreferences.Placement placement) {
        return this.c.get(placement);
    }

    public final List<a> a(String str) {
        return this.d.get(str);
    }

    public final synchronized void a(a aVar) {
        this.b.add(0, aVar);
        List<a> list = this.c.get(aVar.a());
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
            this.c.put(aVar.a(), arrayList);
        }
        arrayList.add(0, aVar);
        List<a> list2 = this.d.get(aVar.b());
        ArrayList arrayList2 = list2;
        if (list2 == null) {
            arrayList2 = new ArrayList();
            this.d.put(aVar.b(), arrayList2);
        }
        arrayList2.add(0, aVar);
    }

    public final int c() {
        return this.b.size();
    }
}
