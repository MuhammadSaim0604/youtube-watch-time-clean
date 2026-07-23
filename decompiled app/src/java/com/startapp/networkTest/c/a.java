package com.startapp.networkTest.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.controller.c;
import com.startapp.networkTest.controller.d;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.enums.IpVersions;
import com.startapp.networkTest.enums.LtrCriteriaTypes;
import com.startapp.networkTest.enums.MeasurementTypes;
import com.startapp.networkTest.enums.SpeedtestEndStates;
import com.startapp.networkTest.results.LatencyResult;
import com.startapp.networkTest.results.P3TestResult;
import com.startapp.networkTest.results.speedtest.MeasurementPointLatency;
import com.startapp.networkTest.speedtest.SpeedtestEngineError;
import com.startapp.networkTest.speedtest.SpeedtestEngineStatus;
import com.startapp.networkTest.utils.f;
import com.startapp.networkTest.utils.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    public static final String a = a.class.getSimpleName();
    private com.startapp.networkTest.speedtest.a b;
    private Context c;
    private c d;
    private d e;
    private LocationController f;
    private com.startapp.networkTest.controller.a g;
    private P3TestResult h;
    private ArrayList<com.startapp.networkTest.data.d> i;
    private String j;
    private com.startapp.networkTest.d k;
    private String l;
    private String m = "";
    private String n = "";
    private String o = "";
    private String p = "";
    private String q = "";
    private String r = "";
    private String s = "";

    public a(com.startapp.networkTest.speedtest.a aVar, Context context) {
        this.b = aVar;
        this.c = context;
        com.startapp.networkTest.a d = com.startapp.networkTest.c.d();
        this.j = d.a();
        this.k = new com.startapp.networkTest.d(this.c);
        this.d = new c(context);
        this.e = new d(context);
        this.f = new LocationController(this.c);
        this.g = new com.startapp.networkTest.controller.a(this.c);
        this.i = new ArrayList<>();
        if (!d.t()) {
            return;
        }
        context.getSystemService("phone");
    }

    public final P3TestResult a() {
        return this.h;
    }

    public final void b() {
        if (this.f != null) {
            this.f.a();
        }
        if (this.d != null) {
            this.d.b();
        }
    }

    public final void a(LocationController.ProviderMode providerMode) {
        if (this.f != null) {
            this.f.a(providerMode);
        }
        if (this.d != null) {
            this.d.a();
        }
    }

    public final void a(String str) {
        this.m = str;
    }

    public final void b(String str) {
        this.s = str;
    }

    public final void c(String str) {
        this.l = str;
    }

    public final void d(String str) {
        this.i = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 11) {
            new AsyncTaskC0018a(str).execute(new Void[0]);
        } else {
            new AsyncTaskC0018a(str).executeOnExecutor(com.startapp.networkTest.threads.a.a().b(), new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.networkTest.c.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class AsyncTaskC0018a extends AsyncTask<Void, Void, LatencyResult> {
        private String b;
        private int d;
        private String[] g;
        private LtrCriteriaTypes h;
        private int c = 10;
        private int e = 30000;
        private int f = 56;
        private boolean i = true;

        @Override // android.os.AsyncTask
        protected final /* synthetic */ LatencyResult doInBackground(Void[] voidArr) {
            return a();
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(LatencyResult latencyResult) {
            LatencyResult latencyResult2 = latencyResult;
            super.onPostExecute(latencyResult2);
            a.this.h = latencyResult2;
            if (latencyResult2 != null) {
                if (a.this.b != null) {
                    com.startapp.networkTest.speedtest.a aVar = a.this.b;
                    SpeedtestEngineStatus speedtestEngineStatus = SpeedtestEngineStatus.END;
                    SpeedtestEngineError speedtestEngineError = SpeedtestEngineError.OK;
                    aVar.a(speedtestEngineStatus);
                }
            } else if (a.this.b != null) {
                com.startapp.networkTest.speedtest.a aVar2 = a.this.b;
                SpeedtestEngineStatus speedtestEngineStatus2 = SpeedtestEngineStatus.ABORTED;
                SpeedtestEngineError speedtestEngineError2 = SpeedtestEngineError.OK;
                aVar2.a(speedtestEngineStatus2);
            }
        }

        public AsyncTaskC0018a(String str) {
            this.b = str;
            this.d = 200;
            if (this.d < 200) {
                this.d = 200;
            }
            if (a.this.b != null) {
                com.startapp.networkTest.speedtest.a aVar = a.this.b;
                SpeedtestEngineStatus speedtestEngineStatus = SpeedtestEngineStatus.CONNECT;
                SpeedtestEngineError speedtestEngineError = SpeedtestEngineError.OK;
                aVar.a(speedtestEngineStatus);
            }
            com.startapp.networkTest.d c = com.startapp.networkTest.c.c();
            this.g = c.m();
            this.h = LtrCriteriaTypes.valueOf(c.o());
        }

        /* JADX WARN: Finally extract failed */
        private LatencyResult a() {
            Network[] allNetworks;
            LinkProperties linkProperties;
            if (isCancelled()) {
                return null;
            }
            List<com.startapp.networkTest.d.a.d> a = this.i ? a(this.g, this.h, this.b) : a(this.g, LtrCriteriaTypes.CTItem, this.b);
            LatencyResult latencyResult = null;
            int i = 0;
            while (true) {
                if (i >= a.size()) {
                    break;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long uptimeMillis = SystemClock.uptimeMillis();
                com.startapp.networkTest.d.a.d dVar = a.get(i);
                dVar.totalTests++;
                this.b = dVar.address;
                final ArrayList<MeasurementPointLatency> arrayList = new ArrayList<>();
                LatencyResult latencyResult2 = new LatencyResult(a.this.j, a.this.k.a());
                latencyResult = latencyResult2;
                latencyResult2.BatteryInfoOnStart = a.this.g.a();
                latencyResult.LocationInfoOnStart = a.this.f.b();
                latencyResult.ScreenStateOnStart = com.startapp.networkTest.controller.b.d(a.this.c);
                latencyResult.MeasurementType = MeasurementTypes.IPING;
                latencyResult.TimeInfoOnStart = com.startapp.networkTest.e.b.a();
                latencyResult.LtrId = com.iab.omid.library.startapp.b.a(latencyResult.TimeInfoOnStart, latencyResult.GUID);
                latencyResult.MemoryInfoOnStart = com.startapp.networkTest.controller.b.b(a.this.c);
                latencyResult.RadioInfoOnStart = a.this.d.c();
                latencyResult.WifiInfoOnStart = a.this.e.a();
                latencyResult.TrafficInfoOnStart = com.startapp.networkTest.controller.b.a(a.this.e);
                latencyResult.DeviceInfo = com.startapp.networkTest.controller.b.a(a.this.c);
                latencyResult.Pings = this.c;
                latencyResult.Pause = this.d;
                latencyResult.Server = this.b;
                latencyResult.IpVersion = IpVersions.IPv4;
                String str = "ping";
                String str2 = this.b;
                InetAddress inetAddress = null;
                try {
                    InetAddress byName = InetAddress.getByName(this.b);
                    inetAddress = byName;
                    str2 = byName.getHostAddress();
                    if (inetAddress instanceof Inet6Address) {
                        latencyResult.IpVersion = IpVersions.IPv6;
                        str = "ping6";
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                String str3 = str + " -i " + (this.d / 1000.0d) + " -W " + (this.e / 1000.0d) + " -c " + this.c + " -s " + this.f;
                if (str.equals("ping6")) {
                    try {
                        String str4 = "";
                        ConnectivityManager connectivityManager = (ConnectivityManager) a.this.c.getSystemService("connectivity");
                        if (connectivityManager != null && a.this.c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                            if (Build.VERSION.SDK_INT >= 23) {
                                LinkProperties linkProperties2 = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
                                if (linkProperties2 != null) {
                                    str4 = linkProperties2.getInterfaceName();
                                }
                            } else if (Build.VERSION.SDK_INT >= 21) {
                                for (Network network : connectivityManager.getAllNetworks()) {
                                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                                    if (networkInfo != null && networkInfo.isConnected() && (linkProperties = connectivityManager.getLinkProperties(network)) != null) {
                                        str4 = linkProperties.getInterfaceName();
                                    }
                                }
                            }
                        }
                        if (str4 != null && !str4.isEmpty()) {
                            str3 = str3 + " -I " + str4;
                        }
                    } catch (Exception e2) {
                        Log.e(a.a, e2.toString());
                    }
                }
                Process process = null;
                BufferedReader bufferedReader = null;
                final boolean[] zArr = {false};
                final int[] iArr = {0};
                boolean z = false;
                try {
                    try {
                        process = Runtime.getRuntime().exec(str3 + " " + str2);
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        bufferedReader = bufferedReader2;
                        z = bufferedReader2.readLine() == null && inetAddress != null && Build.VERSION.SDK_INT >= 21;
                        if (a.this.b != null) {
                            com.startapp.networkTest.speedtest.a aVar = a.this.b;
                            SpeedtestEngineStatus speedtestEngineStatus = SpeedtestEngineStatus.PING;
                            SpeedtestEngineError speedtestEngineError = SpeedtestEngineError.OK;
                            aVar.a(speedtestEngineStatus);
                        }
                        if (!z) {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            for (int i2 = 0; i2 < this.c; i2++) {
                                if (isCancelled()) {
                                    bufferedReader.close();
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                    if (process != null) {
                                        process.destroy();
                                    }
                                    return null;
                                }
                                String readLine = bufferedReader.readLine();
                                long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                int i3 = -1;
                                if (readLine != null && readLine.length() > 0) {
                                    String[] split = readLine.split(" ");
                                    int i4 = -1;
                                    if (split.length == 8 || split.length == 9) {
                                        i4 = split.length - 2;
                                    }
                                    if (i4 == 6 || i4 == 7) {
                                        i3 = (int) Math.round(Double.parseDouble(split[i4].replace("time=", "")));
                                        zArr[0] = true;
                                        iArr[0] = iArr[0] + 1;
                                        if (a.this.b != null) {
                                            com.startapp.networkTest.speedtest.a unused = a.this.b;
                                        }
                                    }
                                }
                                arrayList.add(a(elapsedRealtime3, i3));
                            }
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        if (process != null) {
                            process.destroy();
                        }
                    } catch (Exception e5) {
                        Log.e(a.a, "IcmpTestAsyncTask: " + e5.getMessage());
                        e5.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                    }
                    if (z) {
                        latencyResult.MeasurementType = MeasurementTypes.APIIPING;
                        final com.startapp.networkTest.c.a.a aVar2 = new com.startapp.networkTest.c.a.a(inetAddress, this.c, this.d, this.e, this.f);
                        aVar2.a(new com.startapp.networkTest.c.a.c() { // from class: com.startapp.networkTest.c.a.a.1
                            @Override // com.startapp.networkTest.c.a.c
                            public final void a(long j, long j2) {
                                if (j2 >= 0) {
                                    zArr[0] = true;
                                    int[] iArr2 = iArr;
                                    iArr2[0] = iArr2[0] + 1;
                                }
                                arrayList.add(AsyncTaskC0018a.this.a(j, (int) j2));
                                if (a.this.b != null) {
                                    com.startapp.networkTest.speedtest.a unused2 = a.this.b;
                                    int unused3 = AsyncTaskC0018a.this.c;
                                }
                                if (AsyncTaskC0018a.this.isCancelled()) {
                                    aVar2.b();
                                }
                            }
                        });
                        aVar2.a();
                    }
                    latencyResult.TestEndState = SpeedtestEndStates.Finish;
                    latencyResult.TestErrorReason = SpeedtestEngineError.OK;
                    latencyResult.Success = zArr[0];
                    latencyResult.SuccessfulPings = iArr[0];
                    if (arrayList.size() > 0) {
                        latencyResult.a(arrayList);
                        latencyResult.b(latencyResult.MeasurementPoints);
                    }
                    latencyResult.BatteryInfoOnEnd = a.this.g.a();
                    latencyResult.LocationInfoOnEnd = a.this.f.b();
                    latencyResult.ScreenStateOnEnd = com.startapp.networkTest.controller.b.d(a.this.c);
                    latencyResult.MemoryInfoOnEnd = com.startapp.networkTest.controller.b.b(a.this.c);
                    latencyResult.RadioInfoOnEnd = a.this.d.c();
                    latencyResult.TimeInfoOnEnd = com.startapp.networkTest.e.b.a();
                    latencyResult.WifiInfoOnEnd = a.this.e.a();
                    latencyResult.TrafficInfoOnEnd = com.startapp.networkTest.controller.b.a(a.this.e);
                    latencyResult.DurationOverallNoSleep = SystemClock.uptimeMillis() - uptimeMillis;
                    latencyResult.DurationOverall = SystemClock.elapsedRealtime() - elapsedRealtime;
                    latencyResult.AirportCode = this.h == LtrCriteriaTypes.CTItem ? a.this.s : f.a(this.b);
                    latencyResult.Meta = a.this.m;
                    latencyResult.QuestionnaireName = h.a(a.this.l);
                    if (zArr[0]) {
                        dVar.successfulTests++;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            }
            if (this.h != LtrCriteriaTypes.CTItem) {
                a(a);
            }
            if (com.startapp.networkTest.c.d().B() && latencyResult != null) {
                latencyResult.LocationInfoOnStart = new LocationInfo();
                latencyResult.LocationInfoOnEnd = new LocationInfo();
            }
            return latencyResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MeasurementPointLatency a(long j, int i) {
            MeasurementPointLatency measurementPointLatency = new MeasurementPointLatency();
            measurementPointLatency.Delta = j;
            RadioInfo c = a.this.d.c();
            measurementPointLatency.ConnectionType = c.ConnectionType;
            measurementPointLatency.NetworkType = c.NetworkType;
            measurementPointLatency.NrAvailable = c.NrAvailable;
            measurementPointLatency.NrState = c.NrState;
            measurementPointLatency.RxLev = c.RXLevel;
            measurementPointLatency.Rtt = i;
            return measurementPointLatency;
        }

        private static void a(List<com.startapp.networkTest.d.a.d> list) {
            HashSet hashSet = new HashSet();
            for (com.startapp.networkTest.d.a.d dVar : list) {
                hashSet.add(dVar.toString());
            }
            com.startapp.networkTest.c.c().b(hashSet);
        }

        private List<com.startapp.networkTest.d.a.d> a(String[] strArr, LtrCriteriaTypes ltrCriteriaTypes, String str) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            Set<String> g = com.startapp.networkTest.c.c().g();
            LinkedList<com.startapp.networkTest.d.a.d> linkedList3 = new LinkedList();
            if (g != null) {
                for (String str2 : g) {
                    com.startapp.networkTest.d.a.d dVar = (com.startapp.networkTest.d.a.d) com.startapp.common.parser.b.a(str2, com.startapp.networkTest.d.a.d.class);
                    if (dVar != null) {
                        linkedList3.add(dVar);
                    }
                }
            }
            for (String str3 : strArr) {
                com.startapp.networkTest.d.a.d dVar2 = new com.startapp.networkTest.d.a.d();
                dVar2.address = str3;
                linkedList2.add(dVar2);
            }
            for (com.startapp.networkTest.d.a.d dVar3 : linkedList3) {
                for (int i = 0; i < strArr.length; i++) {
                    if (strArr[i].equals(dVar3.address)) {
                        linkedList2.set(i, dVar3);
                    }
                }
            }
            switch (ltrCriteriaTypes) {
                case CTItem:
                    com.startapp.networkTest.d.a.d dVar4 = new com.startapp.networkTest.d.a.d();
                    dVar4.address = str;
                    linkedList.add(dVar4);
                    break;
                case NoChange:
                    linkedList = linkedList2;
                    break;
                case Random:
                    Collections.shuffle(linkedList2, new Random(System.nanoTime()));
                    linkedList = new LinkedList(linkedList2);
                    break;
                case FullSuccessful:
                    Collections.sort(linkedList2, new Comparator<com.startapp.networkTest.d.a.d>() { // from class: com.startapp.networkTest.c.a.a.2
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(com.startapp.networkTest.d.a.d dVar5, com.startapp.networkTest.d.a.d dVar6) {
                            return dVar5.successfulTests - dVar6.successfulTests;
                        }
                    });
                    linkedList = new LinkedList(linkedList2);
                    break;
                case TotalTests:
                    Collections.sort(linkedList2, new Comparator<com.startapp.networkTest.d.a.d>() { // from class: com.startapp.networkTest.c.a.a.3
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(com.startapp.networkTest.d.a.d dVar5, com.startapp.networkTest.d.a.d dVar6) {
                            return dVar5.totalTests - dVar6.totalTests;
                        }
                    });
                    linkedList = new LinkedList(linkedList2);
                    break;
            }
            return linkedList;
        }
    }
}
