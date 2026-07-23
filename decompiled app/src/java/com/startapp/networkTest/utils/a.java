package com.startapp.networkTest.utils;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private final String a;
    private final String b;

    private a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static a a(String str, String str2) {
        com.iab.omid.library.startapp.b.b(str, "Name is null or empty");
        com.iab.omid.library.startapp.b.b(str2, "Version is null or empty");
        return new a(str, str2);
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }
}
