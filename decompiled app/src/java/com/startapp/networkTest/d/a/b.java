package com.startapp.networkTest.d.a;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.data.BatteryInfo;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.CtCriteriaTypes;
import com.startapp.networkTest.enums.CtTestTypes;
import com.startapp.networkTest.enums.voice.CallStates;
import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;
import com.startapp.networkTest.speedtest.SpeedtestEngineStatus;
import com.startapp.networkTest.utils.f;
import com.startapp.networkTest.utils.j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class b {
    private Context a;
    private com.startapp.networkTest.controller.c b;
    private com.startapp.networkTest.controller.d c;
    private LocationController d;
    private com.startapp.networkTest.d e;
    private e f;
    private String g;
    private String h;
    private String i;
    private String j;
    private Random k;
    private float l;
    private boolean m;

    static /* synthetic */ String a(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return str.replaceAll("(?:[0-9]{1,3}\\.){3}[0-9]{1,3}", "XXX").replaceAll("([A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4}", "XXX");
    }

    static {
        b.class.getSimpleName();
    }

    public b(Context context) {
        this.a = context;
        this.e = new com.startapp.networkTest.d(context);
        com.startapp.networkTest.a d = com.startapp.networkTest.c.d();
        this.g = d.a();
        this.h = d.d();
        this.i = d.e();
        this.j = d.f();
        this.k = new Random();
        this.l = d.h();
        this.m = d.g();
        this.d = new LocationController(context);
        this.b = new com.startapp.networkTest.controller.c(context);
        this.c = new com.startapp.networkTest.controller.d(context);
    }

    public final void a() {
        this.d.a(LocationController.ProviderMode.Passive);
        this.b.a();
    }

    public final void b() {
        this.d.a();
        this.b.b();
    }

    public final void a(e eVar) {
        this.f = eVar;
        if (Build.VERSION.SDK_INT < 11) {
            new a().execute(new Void[0]);
        } else {
            new a().executeOnExecutor(com.startapp.networkTest.threads.a.a().b(), new Void[0]);
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    class a extends AsyncTask<Void, String, ConnectivityTestResult> implements com.startapp.networkTest.speedtest.a {
        private ConnectivityTestResult a;
        private com.startapp.networkTest.c.a b;

        a() {
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ ConnectivityTestResult doInBackground(Void[] voidArr) {
            return a();
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(ConnectivityTestResult connectivityTestResult) {
            ConnectivityTestResult connectivityTestResult2 = connectivityTestResult;
            b.this.e.a(SystemClock.elapsedRealtime());
            if (b.this.f != null) {
                b.this.f.a(connectivityTestResult2);
            }
            if (connectivityTestResult2 == null) {
                if (b.this.f != null) {
                    b.this.f.a();
                    return;
                }
                return;
            }
            boolean z = false;
            if (b.this.e.b() && connectivityTestResult2.ServerIp.length() > 0) {
                this.b = new com.startapp.networkTest.c.a(this, b.this.a);
                this.b.c(connectivityTestResult2.CtId);
                this.b.b(connectivityTestResult2.AirportCode);
                this.b.a(String.valueOf(connectivityTestResult2.TimeInfo.TimestampMillis + connectivityTestResult2.DurationDNS + connectivityTestResult2.DurationTcpConnect + connectivityTestResult2.DurationHttpReceive));
                this.b.a(com.startapp.networkTest.c.d().o());
                this.b.d(connectivityTestResult2.ServerIp);
                z = true;
            }
            if (!z && b.this.f != null) {
                b.this.f.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StartAppSDK */
        /* renamed from: com.startapp.networkTest.d.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
        public class C0022a {
            final int a;
            final String b;
            final boolean c;

            public C0022a(int i, String str, boolean z) {
                this.a = i;
                this.b = str;
                this.c = z;
            }
        }

        private C0022a a(InputStream inputStream) throws IOException {
            int i = 0;
            byte[] bArr = new byte[1024];
            int i2 = 0;
            boolean z = false;
            while (true) {
                int read = inputStream.read();
                i++;
                if (read == 10) {
                    break;
                } else if (read < 0) {
                    z = true;
                    break;
                } else {
                    int i3 = i2;
                    i2++;
                    bArr[i3] = (byte) read;
                    if (i2 == bArr.length) {
                        bArr = Arrays.copyOf(bArr, i2 + 1024);
                    }
                }
            }
            if (i2 > 0 && bArr[i2 - 1] == 13) {
                i2--;
            }
            return new C0022a(i, new String(bArr, 0, i2, "UTF-8"), z);
        }

        private ConnectivityTestResult a() {
            CallStates callStates;
            BatteryInfo a = new com.startapp.networkTest.controller.a(b.this.a).a();
            if (b.this.l == -1.0f || a.BatteryLevel >= b.this.l) {
                com.startapp.networkTest.data.a.b f = com.startapp.networkTest.controller.b.f(b.this.a);
                if (!b.this.m && b.this.b.f() == ConnectionTypes.Mobile && b.this.b.c(f.SubscriptionId)) {
                    return null;
                }
                String str = null;
                boolean z = false;
                try {
                    long d = com.startapp.networkTest.c.c().d();
                    long b = com.startapp.networkTest.e.b.b();
                    if (d + com.startapp.networkTest.c.d().k() < b || d > b) {
                        z = j.a(b.this.a);
                    }
                } catch (Exception e) {
                    str = "checkAndLoadTruststore: " + e.toString();
                }
                try {
                    long i = com.startapp.networkTest.c.c().i();
                    long b2 = com.startapp.networkTest.e.b.b();
                    if (i + com.startapp.networkTest.c.d().l() < b2 || i > b2) {
                        com.startapp.networkTest.utils.b.a();
                    }
                } catch (Exception e2) {
                }
                if (!com.startapp.networkTest.c.a() || b.this.c == null) {
                    return null;
                }
                this.a = new ConnectivityTestResult(b.this.g, b.this.e.a());
                this.a.LocationInfo = b.this.d.b();
                String[] j = com.startapp.networkTest.c.c().j();
                CtCriteriaTypes valueOf = CtCriteriaTypes.valueOf(com.startapp.networkTest.c.c().l());
                if (str != null) {
                    StringBuilder sb = new StringBuilder();
                    ConnectivityTestResult connectivityTestResult = this.a;
                    connectivityTestResult.ErrorReason = sb.append(connectivityTestResult.ErrorReason).append(str).toString();
                }
                this.a.Version = "20200514123200";
                this.a.ServerFilename = b.this.i + "?id=" + b.this.k.nextLong();
                this.a.BatteryInfo = a;
                this.a.DeviceInfo = com.startapp.networkTest.controller.b.a(b.this.a);
                this.a.MemoryInfo = com.startapp.networkTest.controller.b.b(b.this.a);
                this.a.RadioInfo = b.this.b.c();
                if (com.startapp.networkTest.c.d().z()) {
                    this.a.CellInfo = new ArrayList<>(Arrays.asList(b.this.b.d()));
                }
                this.a.ApnInfo = new ArrayList<>(Arrays.asList(b.this.b.e()));
                this.a.NetworkRegistrationInfo = new ArrayList<>(Arrays.asList(b.this.b.a(b.this.b.g().DefaultDataSimId)));
                this.a.VoiceNetworkType = b.this.b.d(b.this.b.g().DefaultDataSimId);
                ConnectivityTestResult connectivityTestResult2 = this.a;
                TelephonyManager telephonyManager = (TelephonyManager) b.this.a.getSystemService("phone");
                if (telephonyManager != null) {
                    switch (telephonyManager.getCallState()) {
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
                connectivityTestResult2.CallState = callStates;
                this.a.StorageInfo = com.startapp.networkTest.controller.b.c(b.this.a);
                this.a.WifiInfo = b.this.c.a();
                this.a.TrafficInfo = com.startapp.networkTest.controller.b.a(b.this.c);
                this.a.ScreenState = com.startapp.networkTest.controller.b.d(b.this.a);
                this.a.IdleStateOnStart = com.startapp.networkTest.controller.b.e(b.this.a);
                this.a.SimInfo = f;
                this.a.TimeInfo = com.startapp.networkTest.e.b.a();
                this.a.TestTimestamp = this.a.TimeInfo.TimestampTableau;
                this.a.TruststoreTimestamp = com.startapp.networkTest.c.c().e();
                this.a.CtId = com.iab.omid.library.startapp.b.a(this.a.TimeInfo, this.a.GUID);
                if (b.this.e.c() && !b.this.e.b()) {
                    this.a.IsKeepAlive = true;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean z2 = false;
                HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
                com.startapp.networkTest.a.a aVar = new com.startapp.networkTest.a.a(b.this.a, z);
                List<c> a2 = a(j, valueOf);
                LinkedList linkedList = new LinkedList();
                String str2 = b.this.h;
                String str3 = b.this.j;
                c cVar = null;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                boolean z3 = false;
                SSLSocket sSLSocket = null;
                SSLCertificateSocketFactory sSLCertificateSocketFactory = null;
                int i6 = 0;
                while (true) {
                    if (i6 < a2.size() || (a2.isEmpty() && str2.length() > 0)) {
                        z3 = true;
                        boolean z4 = false;
                        com.startapp.networkTest.data.c cVar2 = new com.startapp.networkTest.data.c();
                        try {
                            elapsedRealtime = SystemClock.elapsedRealtime();
                            uptimeMillis = SystemClock.uptimeMillis();
                            cVar = new c();
                            i2 = 0 + 1;
                            this.a.LocalhostPingSuccess = b();
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            if (!a2.isEmpty()) {
                                z4 = true;
                                cVar = a2.get(i6);
                                this.a.ServerHostname = cVar.address;
                                cVar.totalTests++;
                                cVar2.Try = i6 + 1;
                                cVar2.HostFile = this.a.ServerHostname + this.a.ServerFilename;
                                this.a.ServerIp = new com.startapp.networkTest.net.a().a(this.a.ServerHostname);
                                this.a.DurationDNS = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            } else if (str3.length() > 0 && str2.length() > 0) {
                                this.a.ServerIp = str3;
                                this.a.ServerHostname = str2;
                                this.a.DurationDNS = 0L;
                                int i7 = i6 - 1;
                            } else {
                                this.a.ServerHostname = str2;
                                int i8 = i6 - 1;
                                this.a.ServerIp = new com.startapp.networkTest.net.a().a(this.a.ServerHostname);
                                this.a.DurationDNS = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            }
                            if (this.a.DurationDNS > 30000) {
                                this.a.DurationDNS = -1L;
                                throw new TimeoutException("DNS Timeout");
                            }
                            cVar2.ServerIp = this.a.ServerIp;
                            cVar2.DurationDNS = this.a.DurationDNS;
                            cVar.DNSSuccess++;
                            i3 = 0 + 1;
                            SSLCertificateSocketFactory sSLCertificateSocketFactory2 = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(30000);
                            sSLCertificateSocketFactory = sSLCertificateSocketFactory2;
                            sSLCertificateSocketFactory2.setTrustManagers(new TrustManager[]{aVar});
                            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.a.ServerIp, 443);
                            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket();
                            long elapsedRealtime3 = SystemClock.elapsedRealtime();
                            sSLSocket.connect(inetSocketAddress, 30000);
                            this.a.DurationTcpConnect = SystemClock.elapsedRealtime() - elapsedRealtime3;
                            cVar.TCPSuccess++;
                            i4 = 0 + 1;
                            if (z4) {
                            }
                        } catch (Exception e3) {
                            try {
                                String a3 = b.a(e3.toString());
                                StringBuilder sb2 = new StringBuilder();
                                ConnectivityTestResult connectivityTestResult3 = this.a;
                                connectivityTestResult3.ErrorReason = sb2.append(connectivityTestResult3.ErrorReason).append(a3).append("; ").toString();
                                z3 = false;
                                if (0 != 0) {
                                    linkedList.add(cVar2);
                                }
                                i6++;
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    linkedList.add(cVar2);
                                }
                                throw th;
                            }
                        }
                    }
                }
                try {
                    if (z3) {
                        try {
                            long elapsedRealtime4 = SystemClock.elapsedRealtime();
                            if (Build.VERSION.SDK_INT >= 17) {
                                sSLCertificateSocketFactory.setHostname(sSLSocket, this.a.ServerHostname);
                            } else {
                                try {
                                    sSLCertificateSocketFactory.getClass().getMethod("setHostname", String.class).invoke(sSLCertificateSocketFactory, this.a.ServerHostname);
                                } catch (Exception e4) {
                                    StringBuilder sb3 = new StringBuilder();
                                    ConnectivityTestResult connectivityTestResult4 = this.a;
                                    connectivityTestResult4.SslException = sb3.append(connectivityTestResult4.SslException).append("SNI not available:").append(e4.getMessage()).append("; ").toString();
                                }
                            }
                            try {
                                if (!defaultHostnameVerifier.verify(this.a.ServerHostname, sSLSocket.getSession())) {
                                    z3 = false;
                                    StringBuilder sb4 = new StringBuilder();
                                    ConnectivityTestResult connectivityTestResult5 = this.a;
                                    connectivityTestResult5.SslException = sb4.append(connectivityTestResult5.SslException).append("Expected ").append(this.a.ServerHostname).append(" found ").append(sSLSocket.getSession().getPeerPrincipal()).append("; ").toString();
                                }
                            } catch (Exception e5) {
                                StringBuilder sb5 = new StringBuilder();
                                ConnectivityTestResult connectivityTestResult6 = this.a;
                                connectivityTestResult6.SslException = sb5.append(connectivityTestResult6.SslException).append("Cannot validate hostname: ").append(e5.getMessage()).append("; ").toString();
                                z3 = false;
                            }
                            this.a.DurationSSL = SystemClock.elapsedRealtime() - elapsedRealtime4;
                            if (z3) {
                                i5 = 0 + 1;
                            }
                            this.a.TestType = aVar.b();
                            if (!this.a.TestType.equals(CtTestTypes.SSLOwnTs)) {
                                StringBuilder sb6 = new StringBuilder();
                                ConnectivityTestResult connectivityTestResult7 = this.a;
                                connectivityTestResult7.SslException = sb6.append(connectivityTestResult7.SslException).append("We couldn't use our own truststore, used: ").append(this.a.TestType).append("; ").toString();
                                z3 = false;
                            }
                            StringBuilder sb7 = new StringBuilder();
                            ConnectivityTestResult connectivityTestResult8 = this.a;
                            connectivityTestResult8.SslException = sb7.append(connectivityTestResult8.SslException).append(aVar.a()).append("; ").toString();
                            z2 = true;
                            byte[] bArr = new byte[2048];
                            PrintWriter printWriter = new PrintWriter(sSLSocket.getOutputStream());
                            long elapsedRealtime5 = SystemClock.elapsedRealtime();
                            printWriter.print("GET ");
                            printWriter.print(this.a.ServerFilename);
                            printWriter.print(" HTTP/1.1");
                            printWriter.print("\r\n");
                            printWriter.print("HOST: ");
                            printWriter.print(this.a.ServerHostname);
                            printWriter.print("\r\n");
                            printWriter.print("Connection: close");
                            printWriter.print("\r\n");
                            printWriter.print("\r\n");
                            printWriter.print("\r\n");
                            printWriter.flush();
                            this.a.DurationHttpGetCommand = SystemClock.elapsedRealtime() - elapsedRealtime5;
                            long elapsedRealtime6 = SystemClock.elapsedRealtime();
                            long j2 = Long.MAX_VALUE;
                            int i9 = -1;
                            long j3 = 0;
                            InputStream inputStream = sSLSocket.getInputStream();
                            while (true) {
                                try {
                                    C0022a a4 = a(inputStream);
                                    j3 += a4.a;
                                    String upperCase = a4.b.toUpperCase();
                                    if (upperCase.startsWith("HTTP")) {
                                        this.a.HTTPStatus = Integer.parseInt(upperCase.split(" ")[1]);
                                        if (this.a.HTTPStatus != 200) {
                                            StringBuilder sb8 = new StringBuilder();
                                            ConnectivityTestResult connectivityTestResult9 = this.a;
                                            connectivityTestResult9.ErrorReason = sb8.append(connectivityTestResult9.ErrorReason).append("Request failed! Unexcepted HTTP code: ").append(this.a.HTTPStatus).append("; ").toString();
                                            z3 = false;
                                        }
                                    } else if (upperCase.startsWith("CONTENT-LENGTH:")) {
                                        try {
                                            i9 = Integer.parseInt(upperCase.substring(15).trim());
                                        } catch (NumberFormatException e6) {
                                        }
                                    } else if (upperCase.startsWith("X-AMZ-CF-ID:")) {
                                        this.a.AmazonId = a4.b.substring(15).trim();
                                    } else if (!a4.c && !upperCase.equals("")) {
                                        if (upperCase.startsWith("X-AMZ-CF-POP:")) {
                                            this.a.AirportCode = f.b(a4.b.toLowerCase().substring(13).trim());
                                        }
                                    }
                                } finally {
                                    if (j3 > 0) {
                                        this.a.DurationHttpReceive = SystemClock.elapsedRealtime() - elapsedRealtime6;
                                        this.a.BytesRead = j3;
                                    }
                                }
                            }
                            this.a.HeaderBytesRead = j3;
                            if (i9 != -1) {
                                j2 = ((int) j3) + i9;
                            }
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    long j4 = j3 + read;
                                    j3 = j4;
                                    if (j4 < j2) {
                                        if (read <= 0) {
                                        }
                                    }
                                } else if (j3 < j2) {
                                    throw new IOException("Could not read all bytes");
                                }
                            }
                            if (z3) {
                                this.a.Success = true;
                                cVar.successfulTests++;
                            }
                            if (sSLSocket != null) {
                                try {
                                    sSLSocket.close();
                                } catch (Exception e7) {
                                }
                            }
                        } catch (Exception e8) {
                            String a5 = b.a(e8.toString());
                            StringBuilder sb9 = new StringBuilder();
                            ConnectivityTestResult connectivityTestResult10 = this.a;
                            connectivityTestResult10.ErrorReason = sb9.append(connectivityTestResult10.ErrorReason).append(a5).append("; ").toString();
                            if (sSLSocket != null) {
                                try {
                                    sSLSocket.close();
                                } catch (Exception e9) {
                                }
                            }
                        }
                    }
                    if (z2) {
                        if (this.a.RadioInfo.ConnectionType == ConnectionTypes.WiFi) {
                            this.a.IspInfo = com.startapp.networkTest.b.a.a().a(this.a.WifiInfo);
                        } else if (com.startapp.networkTest.c.d().s() && this.a.RadioInfo.ConnectionType == ConnectionTypes.Mobile) {
                            this.a.IspInfo = com.startapp.networkTest.b.a.a().a(null);
                        }
                    }
                    this.a.RadioInfoOnEnd = b.this.b.c();
                    this.a.DurationOverallNoSleep = SystemClock.uptimeMillis() - uptimeMillis;
                    this.a.DurationOverall = SystemClock.elapsedRealtime() - elapsedRealtime;
                    this.a.IdleStateOnEnd = com.startapp.networkTest.controller.b.e(b.this.a);
                    this.a.MultiCdnInfo = new ArrayList<>(linkedList);
                    this.a.ServerMultiSuccess = i2 + (i3 * Math.round(Math.pow(10.0d, 2.0d))) + (i4 * Math.round(Math.pow(10.0d, 4.0d))) + (i5 * Math.round(Math.pow(10.0d, 6.0d)));
                    if (this.a.AirportCode.isEmpty()) {
                        this.a.AirportCode = f.a(this.a.ServerIp);
                    }
                    if (a2.size() > 0) {
                        a(a2);
                    }
                    if (com.startapp.networkTest.c.d().A()) {
                        this.a.LocationInfo = new LocationInfo();
                    }
                    return this.a;
                } catch (Throwable th2) {
                    if (sSLSocket != null) {
                        try {
                            sSLSocket.close();
                        } catch (Exception e10) {
                        }
                    }
                    throw th2;
                }
            }
            return null;
        }

        @Override // com.startapp.networkTest.speedtest.a
        public final void a(SpeedtestEngineStatus speedtestEngineStatus) {
            if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ABORTED) {
                this.b.b();
                if (b.this.f != null) {
                    b.this.f.a((LatencyResult) this.b.a());
                    b.this.f.a();
                }
            }
        }

        private List<c> a(String[] strArr, CtCriteriaTypes ctCriteriaTypes) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            Set<String> f = com.startapp.networkTest.c.c().f();
            LinkedList<c> linkedList3 = new LinkedList();
            if (f != null) {
                for (String str : f) {
                    c cVar = (c) com.startapp.common.parser.b.a(str, c.class);
                    if (cVar != null) {
                        linkedList3.add(cVar);
                    }
                }
            }
            for (String str2 : strArr) {
                c cVar2 = new c();
                cVar2.address = str2;
                linkedList2.add(cVar2);
            }
            for (c cVar3 : linkedList3) {
                for (int i = 0; i < linkedList2.size(); i++) {
                    if (((c) linkedList2.get(i)).address.equals(cVar3.address)) {
                        linkedList2.set(i, cVar3);
                    }
                }
            }
            switch (ctCriteriaTypes) {
                case NoChange:
                    linkedList = linkedList2;
                    break;
                case Random:
                    Collections.shuffle(linkedList2, new Random(System.nanoTime()));
                    linkedList = new LinkedList(linkedList2);
                    break;
                case DNSSuccessful:
                    Collections.sort(linkedList2, new Comparator<c>() { // from class: com.startapp.networkTest.d.a.b.a.1
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(c cVar4, c cVar5) {
                            return cVar4.DNSSuccess - cVar5.DNSSuccess;
                        }
                    });
                    linkedList = new LinkedList(linkedList2);
                    break;
                case TCPSuccessful:
                    Collections.sort(linkedList2, new Comparator<c>() { // from class: com.startapp.networkTest.d.a.b.a.2
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(c cVar4, c cVar5) {
                            return cVar4.TCPSuccess - cVar5.TCPSuccess;
                        }
                    });
                    linkedList = new LinkedList(linkedList2);
                    break;
                case FullSuccessful:
                    Collections.sort(linkedList2, new Comparator<c>() { // from class: com.startapp.networkTest.d.a.b.a.3
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(c cVar4, c cVar5) {
                            return cVar4.successfulTests - cVar5.successfulTests;
                        }
                    });
                    linkedList = new LinkedList(linkedList2);
                    break;
                case TotalTests:
                    Collections.sort(linkedList2, new Comparator<c>() { // from class: com.startapp.networkTest.d.a.b.a.4
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(c cVar4, c cVar5) {
                            return cVar4.totalTests - cVar5.totalTests;
                        }
                    });
                    linkedList = new LinkedList(linkedList2);
                    break;
            }
            return linkedList;
        }

        private static void a(List<c> list) {
            HashSet hashSet = new HashSet();
            for (c cVar : list) {
                hashSet.add(cVar.toString());
            }
            com.startapp.networkTest.c.c().a(hashSet);
        }

        private static boolean b() {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ping -W 3 -c 1 -s 56 127.0.0.1").getInputStream()));
                    bufferedReader = bufferedReader2;
                    bufferedReader2.readLine();
                    String readLine = bufferedReader.readLine();
                    if (readLine != null && readLine.length() > 0) {
                        if (readLine.split(" ").length == 8) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return true;
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            }
            return false;
        }
    }
}
