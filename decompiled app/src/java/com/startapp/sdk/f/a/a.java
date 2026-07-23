package com.startapp.sdk.f.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class a extends e {
    private final int a;

    public a(int i) {
        this.a = i;
    }

    @Override // com.startapp.sdk.f.a.e
    public final boolean a(Object obj) {
        if (obj instanceof com.startapp.sdk.adsbase.c) {
            int b = ((com.startapp.sdk.adsbase.c) obj).b();
            return (this.a & b) == b;
        }
        return false;
    }
}
