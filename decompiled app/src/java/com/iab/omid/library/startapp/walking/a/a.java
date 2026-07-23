package com.iab.omid.library.startapp.walking.a;

import com.iab.omid.library.startapp.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public abstract class a extends b {
    protected final HashSet<String> a;
    protected final JSONObject b;
    protected final double c;

    public a(b.InterfaceC0005b interfaceC0005b, HashSet<String> hashSet, JSONObject jSONObject, double d) {
        super(interfaceC0005b);
        this.a = new HashSet<>(hashSet);
        this.b = jSONObject;
        this.c = d;
    }
}
