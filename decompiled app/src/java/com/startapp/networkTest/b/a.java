package com.startapp.networkTest.b;

import com.startapp.networkTest.c;
import com.startapp.networkTest.data.IspInfo;
import com.startapp.networkTest.data.WifiInfo;
import com.startapp.networkTest.net.WebApiClient;
import com.startapp.networkTest.utils.h;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private static a a;
    private boolean b = false;
    private boolean c = false;
    private HashMap<String, IspInfo> d = new HashMap<>();
    private IspInfo e;

    static {
        a.class.getSimpleName();
    }

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public final IspInfo a(WifiInfo wifiInfo) {
        b bVar;
        IspInfo ispInfo = new IspInfo();
        try {
            com.startapp.sdk.adsbase.k.a a2 = WebApiClient.a(WebApiClient.RequestMethod.GET, c.d().r() + "ispinfo");
            if (a2.b.length() > 0 && (bVar = (b) com.startapp.common.parser.b.a(a2.b, b.class)) != null) {
                ispInfo.AutonomousSystemNumber = h.a(bVar.AutonomousSystemNumber);
                ispInfo.AutonomousSystemOrganization = h.a(bVar.AutonomousSystemOrganization);
                ispInfo.IpAddress = h.a(bVar.IpAddress);
                ispInfo.IspName = h.a(bVar.IspName);
                ispInfo.IspOrganizationalName = h.a(bVar.IspOrganizationalName);
                ispInfo.SuccessfulIspLookup = true;
                if (wifiInfo != null) {
                    synchronized (this.d) {
                        this.d.put(wifiInfo.WifiBSSID_Full, ispInfo);
                    }
                } else {
                    this.e = ispInfo;
                }
            }
        } catch (IOException e) {
            new StringBuilder("getIspInfo: ").append(e.getMessage());
        }
        return ispInfo;
    }
}
