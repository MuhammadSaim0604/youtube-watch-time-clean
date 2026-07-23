package com.iab.omid.library.startapp.adsession;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public enum Owner {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE("none");
    
    private final String owner;

    Owner(String str) {
        this.owner = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.owner;
    }
}
