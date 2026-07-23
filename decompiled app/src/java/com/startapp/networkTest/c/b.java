package com.startapp.networkTest.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.controller.c;
import com.startapp.networkTest.d;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.TriggerEvents;
import com.startapp.networkTest.enums.voice.CallStates;
import com.startapp.networkTest.results.NetworkInformationResult;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class b {
    private SharedPreferences a;
    private Context b;
    private d c;
    private c e;
    private com.startapp.networkTest.controller.d f;
    private LocationController g;
    private TelephonyManager h;
    private a i;
    private C0020b j;
    private int l;
    private boolean m;
    private int k = 0;
    private String d = com.startapp.networkTest.c.d().a();

    static {
        b.class.getSimpleName();
    }

    public b(Context context) {
        int i;
        this.b = context;
        this.c = new d(context);
        this.a = context.getSharedPreferences("p3insnir", 0);
        this.h = (TelephonyManager) context.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 24 && this.h != null && (i = com.startapp.networkTest.controller.b.f(context).SubscriptionId) != -1) {
            this.h = this.h.createForSubscriptionId(i);
        }
        this.e = new c(this.b);
        this.f = new com.startapp.networkTest.controller.d(this.b);
        this.g = new LocationController(this.b);
        this.j = new C0020b(this, (byte) 0);
        this.m = com.startapp.networkTest.c.d().x();
        this.l = com.startapp.networkTest.c.d().y();
        if (this.l <= 0) {
            this.l = 1;
        }
    }

    public final void a() {
        this.g.a(LocationController.ProviderMode.Passive);
        this.e.a();
    }

    public final void b() {
        this.g.a();
        this.e.b();
    }

    public final NetworkInformationResult a(TriggerEvents triggerEvents, boolean z) {
        return a(this.g.b(), triggerEvents, z);
    }

    public final NetworkInformationResult a(LocationInfo locationInfo, TriggerEvents triggerEvents, boolean z) {
        CallStates callStates;
        NetworkInformationResult networkInformationResult = new NetworkInformationResult(this.d, this.c.a());
        if (locationInfo != null) {
            networkInformationResult.LocationInfo = locationInfo;
        } else {
            networkInformationResult.LocationInfo = this.g.b();
        }
        networkInformationResult.TimeInfo = com.startapp.networkTest.e.b.a();
        networkInformationResult.Timestamp = networkInformationResult.TimeInfo.TimestampTableau;
        networkInformationResult.timestampMillis = networkInformationResult.TimeInfo.TimestampMillis;
        networkInformationResult.NirId = com.iab.omid.library.startapp.b.a(networkInformationResult.TimeInfo, networkInformationResult.GUID);
        networkInformationResult.WifiInfo = this.f.a();
        networkInformationResult.TriggerEvent = triggerEvents;
        networkInformationResult.ScreenState = com.startapp.networkTest.controller.b.d(this.b);
        if (this.h != null) {
            switch (this.h.getCallState()) {
                case 0:
                    callStates = CallStates.Idle;
                    break;
                case 1:
                    callStates = CallStates.Ringing;
                    break;
                case 2:
                    callStates = CallStates.Offhook;
                    break;
                default:
                    callStates = CallStates.Unknown;
                    break;
            }
        } else {
            callStates = CallStates.Unknown;
        }
        networkInformationResult.CallState = callStates;
        if (this.m) {
            int i = this.k;
            this.k = i + 1;
            if (i % this.l == 0 || z) {
                networkInformationResult.CellInfo = new ArrayList<>(Arrays.asList(this.e.d()));
            }
        }
        networkInformationResult.RadioInfo = this.e.c();
        String str = "";
        synchronized (this) {
            if (this.i == null) {
                String string = this.a.getString("P3INS_PFK_NIR_FIRSTCELLID_GSMCELLID", "");
                if (!string.isEmpty()) {
                    this.i = new a(string, Double.longBitsToDouble(this.a.getLong("P3INS_PFK_NIR_FIRSTCELLID_LATITUDE", 0L)), Double.longBitsToDouble(this.a.getLong("P3INS_PFK_NIR_FIRSTCELLID_LONGITUDE", 0L)));
                }
            }
            if (!networkInformationResult.RadioInfo.GsmCellId.isEmpty()) {
                if (networkInformationResult.LocationInfo.LocationAge < 30000 && (this.i == null || !this.i.a.equals(networkInformationResult.RadioInfo.GsmCellId))) {
                    this.i = new a(networkInformationResult.RadioInfo.GsmCellId, networkInformationResult.LocationInfo.LocationLatitude, networkInformationResult.LocationInfo.LocationLongitude);
                    networkInformationResult.CellIdDeltaDistance = 0.0d;
                    a(this.i);
                }
                str = networkInformationResult.RadioInfo.GsmCellId;
            } else if (!networkInformationResult.RadioInfo.CdmaBaseStationId.isEmpty()) {
                if (networkInformationResult.LocationInfo.LocationAge < 30000 && (this.i == null || !this.i.a.equals(networkInformationResult.RadioInfo.CdmaBaseStationId))) {
                    this.i = new a(networkInformationResult.RadioInfo.CdmaBaseStationId, networkInformationResult.LocationInfo.LocationLatitude, networkInformationResult.LocationInfo.LocationLongitude);
                    networkInformationResult.CellIdDeltaDistance = 0.0d;
                    a(this.i);
                }
                str = networkInformationResult.RadioInfo.CdmaBaseStationId;
            }
        }
        if ((!networkInformationResult.RadioInfo.GsmCellId.isEmpty() && networkInformationResult.CellIdDeltaDistance == -1.0d && this.i.a.equals(networkInformationResult.RadioInfo.GsmCellId)) || (!networkInformationResult.RadioInfo.CdmaBaseStationId.isEmpty() && networkInformationResult.CellIdDeltaDistance == -1.0d && this.i.a.equals(networkInformationResult.RadioInfo.CdmaBaseStationId))) {
            double d = this.i.b;
            double d2 = this.i.c;
            double d3 = networkInformationResult.LocationInfo.LocationLatitude;
            double radians = Math.toRadians(networkInformationResult.LocationInfo.LocationLongitude - d2) * Math.cos(Math.toRadians(d + d3) / 2.0d);
            double radians2 = Math.toRadians(d3 - d);
            networkInformationResult.CellIdDeltaDistance = Math.sqrt((radians * radians) + (radians2 * radians2)) * 6371000.0d;
        }
        if (!str.isEmpty() && !str.equals(this.j.a)) {
            networkInformationResult.PrevNirId = this.j.b;
            networkInformationResult.PrevCellId = this.j.a;
            networkInformationResult.PrevLAC = this.j.c;
            networkInformationResult.PrevNetworkType = this.j.d;
            networkInformationResult.PrevMCC = this.j.e;
            networkInformationResult.PrevMNC = this.j.f;
            networkInformationResult.PrevRXLevel = this.j.g;
        }
        C0020b c0020b = this.j;
        String str2 = networkInformationResult.NirId;
        String str3 = networkInformationResult.RadioInfo.GsmLAC;
        NetworkTypes networkTypes = networkInformationResult.RadioInfo.NetworkType;
        String str4 = networkInformationResult.RadioInfo.MCC;
        String str5 = networkInformationResult.RadioInfo.MNC;
        int i2 = networkInformationResult.RadioInfo.RXLevel;
        c0020b.b = str2;
        c0020b.a = str;
        c0020b.c = str3;
        c0020b.d = networkTypes;
        c0020b.e = str4;
        c0020b.f = str5;
        c0020b.g = i2;
        return networkInformationResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class a {
        String a;
        double b;
        double c;

        a(String str, double d, double d2) {
            this.a = str;
            this.b = d;
            this.c = d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.networkTest.c.b$b  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class C0020b {
        String a;
        String b;
        String c;
        NetworkTypes d;
        String e;
        String f;
        int g;

        private C0020b() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = NetworkTypes.Unknown;
            this.e = "";
            this.f = "";
        }

        /* synthetic */ C0020b(b bVar, byte b) {
            this();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private void a(a aVar) {
        this.a.edit().putString("P3INS_PFK_NIR_FIRSTCELLID_GSMCELLID", aVar.a).commit();
        this.a.edit().putLong("P3INS_PFK_NIR_FIRSTCELLID_LATITUDE", Double.doubleToRawLongBits(aVar.b)).commit();
        this.a.edit().putLong("P3INS_PFK_NIR_FIRSTCELLID_LONGITUDE", Double.doubleToRawLongBits(aVar.c)).commit();
    }

    public final void a(LocationController.b bVar) {
        if (this.g != null) {
            this.g.a(bVar);
        }
    }

    public final void c() {
        if (this.g != null) {
            this.g.a((LocationController.b) null);
        }
    }

    public final void a(com.startapp.networkTest.controller.a.a aVar) {
        if (this.e != null) {
            this.e.a(aVar);
        }
    }

    public final void b(com.startapp.networkTest.controller.a.a aVar) {
        if (this.e != null) {
            this.e.b(aVar);
        }
    }

    public final c d() {
        return this.e;
    }
}
