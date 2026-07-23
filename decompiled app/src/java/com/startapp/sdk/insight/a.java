package com.startapp.sdk.insight;

import android.content.Context;
import android.os.Build;
import com.startapp.networkTest.startapp.NetworkTester;
import com.startapp.networkTest.startapp.a;
import com.startapp.sdk.adsbase.infoevents.e;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class a {
    static {
        a.class.getSimpleName();
    }

    public static void a(final Context context, NetworkTestsMetaData networkTestsMetaData) {
        if (Build.VERSION.SDK_INT >= 14) {
            com.startapp.networkTest.startapp.a.a(new a.InterfaceC0026a() { // from class: com.startapp.sdk.insight.a.1
                @Override // com.startapp.networkTest.startapp.a.InterfaceC0026a
                public final void a(Throwable th) {
                    if (th != null) {
                        new e(th).a(context);
                    }
                }
            });
            if (networkTestsMetaData == null || !networkTestsMetaData.a()) {
                NetworkTester.stopListening();
                return;
            }
            try {
                NetworkTester.Config config = new NetworkTester.Config();
                config.PROJECT_ID = networkTestsMetaData.b();
                config.CONNECTIVITY_TEST_HOSTNAME = networkTestsMetaData.c();
                config.CONNECTIVITY_TEST_FILENAME = networkTestsMetaData.d();
                config.CONNECTIVITY_TEST_ENABLED = networkTestsMetaData.e();
                config.NIR_COLLECT_CELLINFO = networkTestsMetaData.f();
                config.CT_COLLECT_CELLINFO = networkTestsMetaData.g();
                config.CONNECTIVITY_TEST_CDNCONFIG_URL = networkTestsMetaData.h();
                config.GEOIP_URL = networkTestsMetaData.i();
                b a = b.a(context);
                NetworkTester.init(context, config);
                NetworkTester.setOnConnectivityLatencyListener(a);
                NetworkTester.setOnNetworkInfoListener(a);
                NetworkTester.startListening(networkTestsMetaData.j(), networkTestsMetaData.l());
            } catch (Throwable th) {
                new e(th).a(context);
            }
        }
    }
}
