package com.iab.omid.library.startapp.adsession;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public enum AdSessionContextType {
    HTML("html"),
    NATIVE("native");
    
    private final String typeString;

    AdSessionContextType(String str) {
        this.typeString = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.typeString;
    }
}
