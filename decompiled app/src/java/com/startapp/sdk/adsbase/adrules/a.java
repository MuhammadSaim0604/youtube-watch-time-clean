package com.startapp.sdk.adsbase.adrules;

import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a implements Comparable<a> {
    private long a = System.currentTimeMillis();
    private AdPreferences.Placement b;
    private String c;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        long j = this.a - aVar.a;
        if (j > 0) {
            return 1;
        }
        if (j == 0) {
            return 0;
        }
        return -1;
    }

    public a(AdPreferences.Placement placement, String str) {
        String str2 = str;
        this.b = placement;
        this.c = str2 == null ? "" : str2;
    }

    public final AdPreferences.Placement a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String toString() {
        return "AdDisplayEvent [displayTime=" + this.a + ", placement=" + this.b + ", adTag=" + this.c + "]";
    }
}
