package com.startapp.networkTest;

import android.content.Context;
import java.security.PublicKey;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c {
    private static c a;
    private a b;
    private com.startapp.networkTest.e.b c;
    private d d;
    private Context e;
    private PublicKey f;

    public static boolean a() {
        return a != null;
    }

    public static void a(Context context, byte[] bArr) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("config is null");
        }
        if (a == null) {
            try {
                b a2 = b.a(bArr);
                c cVar = new c(context);
                a = cVar;
                cVar.f = null;
                a.b = a2.a;
                c cVar2 = a;
                cVar2.c = new com.startapp.networkTest.e.b();
                cVar2.d = new d(cVar2.e);
            } catch (Exception e) {
                throw new IllegalArgumentException("configuration is invalid");
            }
        }
    }

    private c(Context context) {
        this.e = context;
    }

    public static synchronized com.startapp.networkTest.e.b b() {
        com.startapp.networkTest.e.b bVar;
        synchronized (c.class) {
            bVar = a.c;
        }
        return bVar;
    }

    public static d c() {
        return a.d;
    }

    public static a d() {
        return a.b;
    }
}
