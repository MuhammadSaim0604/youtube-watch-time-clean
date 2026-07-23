package com.startapp.sdk.adsbase.i;

import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class a {
    private final Map<C0041a, String> a = new ConcurrentHashMap();

    static {
        a.class.getSimpleName();
    }

    public final String a(AdPreferences.Placement placement) {
        if (placement == null) {
            return null;
        }
        return this.a.get(new C0041a(placement));
    }

    public final String a(AdPreferences.Placement placement, int i) {
        if (placement == null) {
            return null;
        }
        return this.a.get(new C0041a(placement, i));
    }

    public final void a(AdPreferences.Placement placement, String str) {
        if (str != null) {
            this.a.put(new C0041a(placement), str);
        }
    }

    public final void a(AdPreferences.Placement placement, int i, String str) {
        if (str != null) {
            this.a.put(new C0041a(placement, i), str);
        }
    }

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.i.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    static class C0041a {
        private AdPreferences.Placement a;
        private int b;

        C0041a(AdPreferences.Placement placement) {
            this(placement, -1);
        }

        C0041a(AdPreferences.Placement placement, int i) {
            this.a = placement;
            this.b = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0041a c0041a = (C0041a) obj;
            return this.b == c0041a.b && this.a == c0041a.a;
        }

        public final int hashCode() {
            return u.a(this.a, Integer.valueOf(this.b));
        }
    }
}
