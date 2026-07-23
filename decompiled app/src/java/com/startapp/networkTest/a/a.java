package com.startapp.networkTest.a;

import android.content.Context;
import com.startapp.networkTest.enums.CtTestTypes;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a implements X509TrustManager {
    private static String d;
    private static boolean f;
    private static X509TrustManager g;
    private static X509TrustManager h;
    private static final X509TrustManager i;
    private X509TrustManager[] a;
    private CtTestTypes[] b;
    private String c;
    private CtTestTypes e = CtTestTypes.Unknown;

    static {
        a.class.getSimpleName();
        d = "";
        f = false;
        i = new X509TrustManager() { // from class: com.startapp.networkTest.a.a.1
            @Override // javax.net.ssl.X509TrustManager
            public final X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override // javax.net.ssl.X509TrustManager
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }
        };
    }

    public a(Context context, boolean z) {
        this.c = "";
        a(context, z);
        this.a = new X509TrustManager[3];
        this.b = new CtTestTypes[3];
        this.a[0] = g;
        this.b[0] = CtTestTypes.SSLOwnTs;
        this.a[1] = h;
        this.b[1] = CtTestTypes.SSLDeviceTs;
        this.a[2] = i;
        this.b[2] = CtTestTypes.SSLTrustAll;
        this.c = d;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (int i2 = 0; i2 < this.a.length; i2++) {
            X509TrustManager x509TrustManager = this.a[i2];
            if (x509TrustManager != null) {
                try {
                    this.e = this.b[i2];
                    x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                    return;
                } catch (CertificateException e) {
                    if (i2 == 0) {
                        this.c += e.getMessage();
                    }
                    if (i2 + 1 == this.a.length) {
                        throw e;
                    }
                }
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return h.getAcceptedIssuers();
    }

    public final String a() {
        return this.c;
    }

    public final CtTestTypes b() {
        return this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
        com.startapp.networkTest.a.a.h = (javax.net.ssl.X509TrustManager) r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.networkTest.a.a.a(android.content.Context, boolean):void");
    }
}
