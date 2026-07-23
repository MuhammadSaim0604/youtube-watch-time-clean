package com.startapp.networkTest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b {
    public a a;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(byte[] bArr) throws Exception {
        String str = new String(bArr);
        b bVar = new b();
        bVar.a = (a) com.startapp.common.parser.b.a(str, a.class);
        return bVar;
    }
}
