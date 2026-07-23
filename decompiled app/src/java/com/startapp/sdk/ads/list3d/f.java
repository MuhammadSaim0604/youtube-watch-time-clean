package com.startapp.sdk.ads.list3d;

import android.content.Context;
import android.graphics.Bitmap;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdDetails;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class f {
    private List<d> b;
    private String c = "";
    private b a = new b();

    public final void a() {
        this.b = new ArrayList();
        this.c = "";
    }

    public final void a(AdDetails adDetails) {
        d dVar = new d(adDetails);
        this.b.add(dVar);
        this.a.a(this.b.size() - 1, dVar.a(), dVar.i());
    }

    public final void b() {
        b bVar = this.a;
        for (String str : bVar.a.keySet()) {
            if (bVar.a.get(str) != null) {
                bVar.a.get(str).b();
            }
        }
    }

    public final void c() {
        b bVar = this.a;
        for (String str : bVar.a.keySet()) {
            if (bVar.a.get(str) != null) {
                bVar.a.get(str).a();
            }
        }
    }

    public final void d() {
        b bVar = this.a;
        for (String str : bVar.a.keySet()) {
            if (bVar.a.get(str) != null) {
                bVar.a.get(str).a(false);
            }
        }
    }

    public final List<d> e() {
        return this.b;
    }

    public final Bitmap a(int i, String str, String str2) {
        return this.a.a(i, str, str2);
    }

    public final void a(Context context, String str, TrackingParams trackingParams, long j) {
        b bVar = this.a;
        String str2 = str + this.c;
        if (bVar.a.containsKey(str2)) {
            return;
        }
        com.startapp.sdk.adsbase.h hVar = new com.startapp.sdk.adsbase.h(context, new String[]{str2}, trackingParams, j);
        bVar.a.put(str2, hVar);
        hVar.a();
    }

    public final void a(String str) {
        b bVar = this.a;
        String str2 = str + this.c;
        if (bVar.a == null || !bVar.a.containsKey(str2) || bVar.a.get(str2) == null) {
            return;
        }
        bVar.a.get(str2).a(true);
    }

    public final void a(h hVar, boolean z) {
        b bVar = this.a;
        bVar.d = hVar;
        if (!z) {
            return;
        }
        bVar.c.clear();
        bVar.e = 0;
        bVar.f.clear();
        if (bVar.a == null) {
            return;
        }
        for (String str : bVar.a.keySet()) {
            bVar.a.get(str).a(false);
        }
        bVar.a.clear();
    }

    public final void b(String str) {
        this.c = str;
    }
}
