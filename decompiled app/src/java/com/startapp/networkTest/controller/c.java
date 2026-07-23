package com.startapp.networkTest.controller;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.startapp.networkTest.data.RadioInfo;
import com.startapp.networkTest.data.radio.ApnInfo;
import com.startapp.networkTest.data.radio.NetworkRegistrationInfo;
import com.startapp.networkTest.enums.CellConnectionStatus;
import com.startapp.networkTest.enums.CellNetworkTypes;
import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.DuplexMode;
import com.startapp.networkTest.enums.FlightModeStates;
import com.startapp.networkTest.enums.NetworkGenerations;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.PreferredNetworkTypes;
import com.startapp.networkTest.enums.ServiceStates;
import com.startapp.networkTest.enums.ThreeState;
import com.startapp.networkTest.enums.ThreeStateShort;
import com.startapp.networkTest.enums.radio.DataConnectionStates;
import com.startapp.networkTest.enums.wifi.WifiDetailedStates;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class c {
    private static final String c = c.class.getSimpleName();
    private Field A;
    private Field B;
    private Field C;
    private Method D;
    private Field E;
    private Field F;
    private Field G;
    private Field H;
    private Field I;
    private Method J;
    private Method K;
    private Method L;
    private Method M;
    private Method N;
    private Method O;
    private Method P;
    private ContentResolver Q;
    private int[] R;
    private boolean S;
    protected final Handler a;
    protected final List<com.startapp.networkTest.controller.a.a> b;
    private TelephonyManager d;
    private SparseArray<TelephonyManager> e;
    private Context f;
    private j g;
    private ArrayList<j> h;
    private ConnectivityManager i;
    private d j;
    private SubscriptionManager.OnSubscriptionsChangedListener k;
    private com.startapp.networkTest.data.a.a l;
    private e m;
    private List<CellInfo> n;
    private Method o;
    private Method p;
    private Method q;
    private Method r;
    private Method s;
    private Method t;
    private Method u;
    private Method v;
    private Method w;
    private Method x;
    private Field y;
    private Field z;

    static /* synthetic */ int e(int i2) {
        if (i2 != 99 && i2 >= 0 && i2 <= 31) {
            return (-113) + (2 * i2);
        }
        return 0;
    }

    public c(Context context) {
        this.f = context;
        this.d = (TelephonyManager) context.getSystemService("phone");
        this.i = (ConnectivityManager) context.getSystemService("connectivity");
        j();
        a(this.R);
        if (Build.VERSION.SDK_INT >= 29) {
            i();
        }
        this.a = new Handler(Looper.getMainLooper());
        this.b = new CopyOnWriteArrayList();
        this.l = new com.startapp.networkTest.data.a.a();
        this.j = new d();
        this.Q = this.f.getContentResolver();
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                this.E = ServiceState.class.getDeclaredField("mIsUsingCarrierAggregation");
                this.E.setAccessible(true);
            } catch (Exception e2) {
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                this.D = SignalStrength.class.getDeclaredMethod("isUsingCarrierAggregation", new Class[0]);
            } catch (Exception e3) {
            }
        }
        if (Build.VERSION.SDK_INT < 29) {
            try {
                this.p = SignalStrength.class.getDeclaredMethod("getLteSignalStrength", new Class[0]);
            } catch (Exception e4) {
            }
            try {
                this.s = SignalStrength.class.getDeclaredMethod("getLteCqi", new Class[0]);
            } catch (Exception e5) {
            }
            try {
                this.t = SignalStrength.class.getDeclaredMethod("getLteRsrp", new Class[0]);
            } catch (Exception e6) {
            }
            try {
                this.u = SignalStrength.class.getDeclaredMethod("getLteRsrq", new Class[0]);
            } catch (Exception e7) {
            }
            try {
                this.v = SignalStrength.class.getDeclaredMethod("getLteRssnr", new Class[0]);
            } catch (Exception e8) {
            }
            try {
                this.q = SignalStrength.class.getDeclaredMethod("getLteDbm", new Class[0]);
            } catch (Exception e9) {
            }
            try {
                this.o = SignalStrength.class.getDeclaredMethod("getDbm", new Class[0]);
            } catch (Exception e10) {
            }
        }
        try {
            this.r = SignalStrength.class.getDeclaredMethod("getGsmEcno", new Class[0]);
        } catch (Exception e11) {
        }
        try {
            this.y = SignalStrength.class.getDeclaredField("mWcdmaRscp");
            this.y.setAccessible(true);
        } catch (NoSuchFieldException e12) {
        }
        try {
            this.z = SignalStrength.class.getDeclaredField("mWcdmaEcio");
            this.z.setAccessible(true);
        } catch (NoSuchFieldException e13) {
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                this.A = SignalStrength.class.getDeclaredField("mNrRsrp");
                this.A.setAccessible(true);
            } catch (NoSuchFieldException e14) {
            }
            try {
                this.B = SignalStrength.class.getDeclaredField("mNrRsrq");
                this.B.setAccessible(true);
            } catch (NoSuchFieldException e15) {
            }
            try {
                this.C = SignalStrength.class.getDeclaredField("mNrRssnr");
                this.C.setAccessible(true);
            } catch (NoSuchFieldException e16) {
            }
        }
        try {
            this.J = this.d.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);
        } catch (Exception e17) {
        }
        try {
            this.K = this.d.getClass().getDeclaredMethod("getDataEnabled", Integer.TYPE);
        } catch (Exception e18) {
        }
        try {
            this.L = this.d.getClass().getDeclaredMethod("isNetworkRoaming", Integer.TYPE);
        } catch (Exception e19) {
        }
        try {
            this.M = this.d.getClass().getDeclaredMethod("getNetworkType", Integer.TYPE);
        } catch (Exception e20) {
        }
        try {
            this.N = this.d.getClass().getDeclaredMethod("getNetworkOperatorName", Integer.TYPE);
        } catch (Exception e21) {
        }
        try {
            this.O = this.d.getClass().getDeclaredMethod("getNetworkOperator", Integer.TYPE);
        } catch (Exception e22) {
        }
        try {
            this.P = this.d.getClass().getDeclaredMethod("getNetworkOperatorForSubscription", Integer.TYPE);
        } catch (Exception e23) {
        }
        try {
            Method declaredMethod = this.d.getClass().getDeclaredMethod("getVoiceNetworkType", null);
            if (!Modifier.isAbstract(declaredMethod.getModifiers())) {
                this.w = declaredMethod;
                this.w.setAccessible(true);
            }
        } catch (Exception e24) {
        }
        try {
            Method declaredMethod2 = this.d.getClass().getDeclaredMethod("getVoiceNetworkType", Integer.TYPE);
            if (!Modifier.isAbstract(declaredMethod2.getModifiers())) {
                this.x = declaredMethod2;
                this.x.setAccessible(true);
            }
        } catch (Exception e25) {
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.F = CellSignalStrengthLte.class.getDeclaredField("mSignalStrength");
                this.F.setAccessible(true);
            } catch (NoSuchFieldException e26) {
            }
            try {
                this.G = CellSignalStrengthLte.class.getDeclaredField("mRsrq");
                this.G.setAccessible(true);
            } catch (NoSuchFieldException e27) {
            }
            try {
                this.H = CellSignalStrengthLte.class.getDeclaredField("mRssnr");
                this.H.setAccessible(true);
            } catch (NoSuchFieldException e28) {
            }
            try {
                this.I = CellSignalStrengthLte.class.getDeclaredField("mCqi");
                this.I.setAccessible(true);
            } catch (NoSuchFieldException e29) {
            }
        }
        if (Build.VERSION.SDK_INT < 22) {
            return;
        }
        this.k = new SubscriptionManager.OnSubscriptionsChangedListener() { // from class: com.startapp.networkTest.controller.c.1
            @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
            public final void onSubscriptionsChanged() {
                super.onSubscriptionsChanged();
                if (!c.this.S) {
                    new AsyncTaskC0021c().executeOnExecutor(com.startapp.networkTest.threads.a.a().d(), new Void[0]);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    public void i() {
        this.e = new SparseArray<>();
        for (int i2 = 0; i2 < this.R.length; i2++) {
            this.e.put(this.R[i2], this.d.createForSubscriptionId(this.R[i2]));
        }
    }

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.networkTest.controller.c$c  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    class AsyncTaskC0021c extends AsyncTask<Void, Void, Void> {
        AsyncTaskC0021c() {
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
            c.this.j();
            return null;
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Void r6) {
            c.this.a(c.this.R);
            if (Build.VERSION.SDK_INT >= 29) {
                c.this.i();
            }
            c.this.a(false);
            c.this.S = false;
        }

        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
            c.this.S = true;
            c.this.b(false);
            c.this.R = new int[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr) {
        this.h = new ArrayList<>();
        for (int i2 : iArr) {
            this.h.add(new j(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.l = com.startapp.networkTest.controller.b.g(this.f);
        com.startapp.networkTest.data.a.b[] bVarArr = (com.startapp.networkTest.data.a.b[]) this.l.SimInfos.toArray(new com.startapp.networkTest.data.a.b[this.l.SimInfos.size()]);
        int[] iArr = new int[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            iArr[i2] = bVarArr[i2].SubscriptionId;
        }
        this.R = iArr;
    }

    public final void a() {
        try {
            a(true);
            Context context = this.f;
            if (this.m == null) {
                this.m = new e(this, (byte) 0);
            }
            this.m.getClass();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.ANY_DATA_STATE");
            this.m.getClass();
            intentFilter.addAction("com.samsung.ims.action.IMS_REGISTRATION");
            context.registerReceiver(this.m, intentFilter);
        } catch (Throwable th) {
            com.startapp.networkTest.startapp.a.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        SubscriptionManager subscriptionManager;
        if (z && this.k != null && this.f.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && Build.VERSION.SDK_INT >= 22 && (subscriptionManager = (SubscriptionManager) this.f.getSystemService("telephony_subscription_service")) != null) {
            subscriptionManager.addOnSubscriptionsChangedListener(this.k);
        }
        if (this.d != null) {
            int i2 = 257;
            if (this.f.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                i2 = 273;
                if (Build.VERSION.SDK_INT >= 17) {
                    i2 = 1297;
                }
            }
            if (this.h.size() == 0) {
                if (this.g == null) {
                    this.g = new j();
                }
                this.d.listen(this.g, i2);
                return;
            }
            Iterator<j> it = this.h.iterator();
            while (it.hasNext()) {
                j next = it.next();
                TelephonyManager telephonyManager = null;
                if (this.e != null && this.e.size() > 0) {
                    telephonyManager = this.e.get(next.a());
                }
                if (telephonyManager == null) {
                    telephonyManager = this.d;
                }
                telephonyManager.listen(next, i2);
            }
        }
    }

    public final void b() {
        try {
            b(true);
            Context context = this.f;
            if (context != null && this.m != null) {
                context.unregisterReceiver(this.m);
            }
        } catch (Throwable th) {
            com.startapp.networkTest.startapp.a.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        SubscriptionManager subscriptionManager;
        if (z && this.k != null && this.f.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && Build.VERSION.SDK_INT >= 22 && (subscriptionManager = (SubscriptionManager) this.f.getSystemService("telephony_subscription_service")) != null) {
            subscriptionManager.removeOnSubscriptionsChangedListener(this.k);
        }
        if (this.d != null) {
            if (this.g != null) {
                this.d.listen(this.g, 0);
            }
            Iterator<j> it = this.h.iterator();
            while (it.hasNext()) {
                j next = it.next();
                TelephonyManager telephonyManager = null;
                if (this.e != null && this.e.size() > 0) {
                    telephonyManager = this.e.get(next.a());
                }
                if (telephonyManager == null) {
                    telephonyManager = this.d;
                }
                telephonyManager.listen(next, 0);
            }
        }
    }

    private boolean f(int i2) {
        return this.l.a(i2).SubscriptionId != -1;
    }

    public final RadioInfo c() {
        try {
            return g(this.l.DefaultDataSimId);
        } catch (Throwable th) {
            com.startapp.networkTest.startapp.a.a(th);
            return new RadioInfo();
        }
    }

    @TargetApi(22)
    private RadioInfo g(int i2) {
        PreferredNetworkTypes preferredNetworkTypes;
        if (i2 == -1 || !f(i2) || Build.VERSION.SDK_INT < 22 || this.R.length == 0) {
            return k();
        }
        RadioInfo radioInfo = new RadioInfo();
        radioInfo.SubscriptionId = i2;
        radioInfo.IsDefaultVoiceSim = i2 == this.l.DefaultVoiceSimId;
        radioInfo.IsDefaultDataSim = i2 == this.l.DefaultDataSimId;
        radioInfo.PreferredNetwork = a(this.f, i2);
        if (radioInfo.PreferredNetwork == PreferredNetworkTypes.Unknown && (preferredNetworkTypes = a(this.f).get(this.l.a(i2).SimSlotIndex)) != null) {
            radioInfo.PreferredNetwork = preferredNetworkTypes;
        }
        if (this.d != null) {
            TelephonyManager telephonyManager = null;
            if (this.e != null && this.e.size() > 0) {
                telephonyManager = this.e.get(i2);
            }
            try {
                switch (this.d.getDataState()) {
                    case 0:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Disconnected;
                        break;
                    case 1:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Connecting;
                        break;
                    case 2:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Connected;
                        break;
                    case 3:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Suspended;
                        break;
                    default:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Unknown;
                        break;
                }
            } catch (SecurityException e2) {
                Log.e(c, "getRadioInfo(subscriptionID): getDataState: " + e2.toString());
            }
            radioInfo.FlightMode = m() ? FlightModeStates.Enabled : FlightModeStates.Disabled;
            radioInfo.MobileDataEnabled = ThreeState.Unknown;
            if (telephonyManager != null && Build.VERSION.SDK_INT >= 26) {
                radioInfo.MobileDataEnabled = telephonyManager.isDataEnabled() ? ThreeState.Enabled : ThreeState.Disabled;
            } else if (this.K != null) {
                try {
                    radioInfo.MobileDataEnabled = ((Boolean) this.K.invoke(this.d, Integer.valueOf(i2))).booleanValue() ? ThreeState.Enabled : ThreeState.Disabled;
                } catch (Exception e3) {
                    Log.e(c, "getRadioInfo(subscriptionID): MobileDataEnabled: " + e3.toString());
                }
            }
            if (telephonyManager != null) {
                radioInfo.IsRoaming = telephonyManager.isNetworkRoaming();
            } else if (this.L != null) {
                try {
                    radioInfo.IsRoaming = ((Boolean) this.L.invoke(this.d, Integer.valueOf(i2))).booleanValue();
                } catch (Exception e4) {
                    Log.e(c, "getRadioInfo(subscriptionID): IsRoaming: " + e4.toString());
                }
            }
            radioInfo.IsMetered = l();
            radioInfo.IsVpn = com.startapp.networkTest.utils.c.a(p());
            radioInfo.ConnectionType = f();
            if (telephonyManager != null) {
                radioInfo.NetworkType = b(telephonyManager.getNetworkType());
            } else if (this.M != null) {
                try {
                    radioInfo.NetworkType = b(((Integer) this.M.invoke(this.d, Integer.valueOf(i2))).intValue());
                } catch (Exception e5) {
                    Log.e(c, "getRadioInfo(subscriptionID): NetworkType: " + e5.toString());
                }
            }
            if (telephonyManager != null) {
                radioInfo.OperatorName = com.startapp.networkTest.utils.h.a(telephonyManager.getNetworkOperatorName());
            } else if (this.N != null) {
                try {
                    radioInfo.OperatorName = com.startapp.networkTest.utils.h.a((String) this.N.invoke(this.d, Integer.valueOf(i2)));
                } catch (Exception e6) {
                    Log.e(c, "getRadioInfo(subscriptionID): OperatorName: " + e6.toString());
                }
            }
            String str = "";
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperator();
            } else if (this.P != null) {
                try {
                    str = (String) this.P.invoke(this.d, Integer.valueOf(i2));
                } catch (Exception e7) {
                    Log.e(c, "getRadioInfo(subscriptionID): OperatorName: " + e7.toString());
                }
            } else if (this.O != null) {
                try {
                    str = (String) this.O.invoke(this.d, Integer.valueOf(i2));
                } catch (Exception e8) {
                    Log.e(c, "getRadioInfo(subscriptionID): OperatorName: " + e8.toString());
                }
            }
            if (str.length() > 4) {
                radioInfo.MCC = str.substring(0, 3);
                radioInfo.MNC = str.substring(3);
            }
            NetworkRegistrationInfo[] d2 = this.j.d(i2);
            boolean z = false;
            b c2 = this.j.c(i2);
            b bVar = c2;
            if (c2 == null) {
                bVar = new b(this, (byte) 0);
            }
            if (this.f.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                if (bVar.a == null) {
                    bVar.a = this.d.getCellLocation();
                }
            } else {
                z = true;
            }
            if (bVar.a != null) {
                if (bVar.a.getClass().equals(GsmCellLocation.class)) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) bVar.a;
                    radioInfo.GsmLAC = new StringBuilder().append(gsmCellLocation.getLac()).toString();
                    radioInfo.GsmCellId = new StringBuilder().append(gsmCellLocation.getCid()).toString();
                    radioInfo.PrimaryScramblingCode = new StringBuilder().append(gsmCellLocation.getPsc()).toString();
                } else if (bVar.a.getClass().equals(CdmaCellLocation.class)) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) bVar.a;
                    radioInfo.CdmaBaseStationId = new StringBuilder().append(cdmaCellLocation.getBaseStationId()).toString();
                    radioInfo.CdmaBaseStationLatitude = new StringBuilder().append(cdmaCellLocation.getBaseStationLatitude()).toString();
                    radioInfo.CdmaBaseStationLongitude = new StringBuilder().append(cdmaCellLocation.getBaseStationLongitude()).toString();
                    radioInfo.CdmaNetworkId = new StringBuilder().append(cdmaCellLocation.getNetworkId()).toString();
                    radioInfo.CdmaSystemId = new StringBuilder().append(cdmaCellLocation.getSystemId()).toString();
                }
                if (bVar.b > 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - bVar.b;
                    radioInfo.GsmCellIdAge = elapsedRealtime > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime;
                }
            } else if (d2 != null) {
                for (NetworkRegistrationInfo networkRegistrationInfo : d2) {
                    if (networkRegistrationInfo.Domain.equals("CS")) {
                        radioInfo.GsmCellId = networkRegistrationInfo.CellId;
                        radioInfo.GsmLAC = networkRegistrationInfo.Tac;
                        if (!radioInfo.GsmCellId.isEmpty()) {
                            radioInfo.GsmCellIdAge = networkRegistrationInfo.Age;
                        }
                    }
                }
            }
            if (radioInfo.GsmCellId.isEmpty() && z) {
                radioInfo.MissingPermission = true;
            }
            h b2 = this.j.b(i2);
            radioInfo.ServiceState = b2.a;
            radioInfo.DuplexMode = b2.c;
            radioInfo.ManualSelection = b2.d;
            radioInfo.CarrierAggregation = b2.f;
            radioInfo.ARFCN = b2.e;
            if (b2.b > 0) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - b2.b;
                radioInfo.ServiceStateAge = elapsedRealtime2 > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime2;
            }
            radioInfo.NrState = b(d2);
            radioInfo.NrAvailable = c(d2);
            if (radioInfo.NetworkType == NetworkTypes.Unknown) {
                radioInfo.NetworkType = a(d2);
            }
            i a2 = this.j.a(i2);
            radioInfo.RSCP = a2.j;
            radioInfo.CdmaEcIo = a2.c;
            radioInfo.RXLevel = a2.a;
            radioInfo.NativeDbm = a2.b;
            radioInfo.EcN0 = a2.i;
            radioInfo.LteCqi = a2.d;
            radioInfo.LteRsrp = a2.e;
            radioInfo.LteRsrq = a2.g;
            radioInfo.LteRssnr = a2.f;
            radioInfo.LteRssi = a2.h;
            radioInfo.NrCsiRsrp = a2.l;
            radioInfo.NrCsiRsrq = a2.m;
            radioInfo.NrCsiSinr = a2.n;
            radioInfo.NrSsRsrp = a2.o;
            radioInfo.NrSsRsrq = a2.p;
            radioInfo.NrSsSinr = a2.q;
            if ((radioInfo.NetworkType == NetworkTypes.LTE || radioInfo.NetworkType == NetworkTypes.LTE_CA) && radioInfo.RXLevel >= 0) {
                radioInfo.RXLevel = radioInfo.LteRsrp;
            }
            if (radioInfo.NetworkType == NetworkTypes.LTE_CA) {
                radioInfo.CarrierAggregation = ThreeStateShort.Yes;
            }
            if (radioInfo.CarrierAggregation == ThreeStateShort.Unknown) {
                radioInfo.CarrierAggregation = d(d2);
            }
            if (radioInfo.NetworkType == NetworkTypes.NR) {
                int i3 = 0;
                int i4 = 0;
                try {
                    i3 = Integer.parseInt(radioInfo.MCC);
                    i4 = Integer.parseInt(radioInfo.MNC);
                } catch (NumberFormatException e9) {
                    new StringBuilder("radioInfo: ").append(e9.getMessage());
                }
                f a3 = this.j.a(new StringBuilder().append(i3).append(i4).toString());
                if (a3 != null) {
                    radioInfo.GsmCellId = new StringBuilder().append(a3.a).toString();
                    radioInfo.GsmLAC = new StringBuilder().append(a3.b).toString();
                    radioInfo.PrimaryScramblingCode = new StringBuilder().append(a3.c).toString();
                    radioInfo.GsmCellIdAge = (int) (SystemClock.elapsedRealtime() - (a3.d / 1000000));
                }
            }
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - a2.k;
            radioInfo.RXLevelAge = elapsedRealtime3 > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime3;
        }
        return radioInfo;
    }

    @Deprecated
    private RadioInfo k() {
        RadioInfo radioInfo = new RadioInfo();
        if (this.d != null) {
            PreferredNetworkTypes preferredNetworkTypes = a(this.f).get(0);
            if (preferredNetworkTypes != null) {
                radioInfo.PreferredNetwork = preferredNetworkTypes;
            }
            try {
                switch (this.d.getDataState()) {
                    case 0:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Disconnected;
                        break;
                    case 1:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Connecting;
                        break;
                    case 2:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Connected;
                        break;
                    case 3:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Suspended;
                        break;
                    default:
                        radioInfo.MobileDataConnectionState = DataConnectionStates.Unknown;
                        break;
                }
            } catch (SecurityException e2) {
                Log.e(c, "getRadioInfo: getDataState: " + e2.toString());
            }
            radioInfo.FlightMode = m() ? FlightModeStates.Enabled : FlightModeStates.Disabled;
            radioInfo.MobileDataEnabled = ThreeState.Unknown;
            if (this.J != null) {
                try {
                    radioInfo.MobileDataEnabled = ((Boolean) this.J.invoke(this.d, new Object[0])).booleanValue() ? ThreeState.Enabled : ThreeState.Disabled;
                } catch (Exception e3) {
                    Log.e(c, "getRadioInfo: MobileDataEnabled: " + e3.toString());
                }
            } else if (Build.VERSION.SDK_INT >= 17) {
                try {
                    radioInfo.MobileDataEnabled = Settings.Global.getInt(this.Q, "mobile_data") == 1 ? ThreeState.Enabled : ThreeState.Disabled;
                } catch (Throwable th) {
                    Log.e(c, "getRadioInfo: MobileDataEnabled: " + th.toString());
                }
            } else {
                try {
                    radioInfo.MobileDataEnabled = Settings.Secure.getInt(this.Q, "mobile_data") == 1 ? ThreeState.Enabled : ThreeState.Disabled;
                } catch (Throwable th2) {
                    Log.e(c, "getRadioInfo: MobileDataEnabled: " + th2.toString());
                }
            }
            radioInfo.IsRoaming = this.d.isNetworkRoaming();
            radioInfo.IsMetered = l();
            radioInfo.IsVpn = com.startapp.networkTest.utils.c.a(p());
            radioInfo.ConnectionType = f();
            radioInfo.NetworkType = b(this.d.getNetworkType());
            radioInfo.OperatorName = com.startapp.networkTest.utils.h.a(this.d.getNetworkOperatorName());
            String networkOperator = this.d.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 4) {
                radioInfo.MCC = networkOperator.substring(0, 3);
                radioInfo.MNC = networkOperator.substring(3);
            }
            NetworkRegistrationInfo[] d2 = this.j.d(-1);
            boolean z = false;
            b c2 = this.j.c(-1);
            b bVar = c2;
            if (c2 == null) {
                bVar = new b(this, (byte) 0);
            }
            if (this.f.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                if (bVar.a == null) {
                    bVar.a = this.d.getCellLocation();
                }
            } else {
                z = true;
            }
            if (bVar.a != null) {
                if (bVar.a.getClass().equals(GsmCellLocation.class)) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) bVar.a;
                    radioInfo.GsmLAC = new StringBuilder().append(gsmCellLocation.getLac()).toString();
                    radioInfo.GsmCellId = new StringBuilder().append(gsmCellLocation.getCid()).toString();
                    radioInfo.PrimaryScramblingCode = new StringBuilder().append(gsmCellLocation.getPsc()).toString();
                } else if (bVar.a.getClass().equals(CdmaCellLocation.class)) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) bVar.a;
                    radioInfo.CdmaBaseStationId = new StringBuilder().append(cdmaCellLocation.getBaseStationId()).toString();
                    radioInfo.CdmaBaseStationLatitude = new StringBuilder().append(cdmaCellLocation.getBaseStationLatitude()).toString();
                    radioInfo.CdmaBaseStationLongitude = new StringBuilder().append(cdmaCellLocation.getBaseStationLongitude()).toString();
                    radioInfo.CdmaNetworkId = new StringBuilder().append(cdmaCellLocation.getNetworkId()).toString();
                    radioInfo.CdmaSystemId = new StringBuilder().append(cdmaCellLocation.getSystemId()).toString();
                }
                if (bVar.b > 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - bVar.b;
                    radioInfo.GsmCellIdAge = elapsedRealtime > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime;
                }
            } else if (d2 != null) {
                for (NetworkRegistrationInfo networkRegistrationInfo : d2) {
                    if (networkRegistrationInfo.Domain.equals("CS")) {
                        radioInfo.GsmCellId = networkRegistrationInfo.CellId;
                        radioInfo.GsmLAC = networkRegistrationInfo.Tac;
                        if (!radioInfo.GsmCellId.isEmpty()) {
                            radioInfo.GsmCellIdAge = networkRegistrationInfo.Age;
                        }
                    }
                }
            }
            if (radioInfo.GsmCellId.isEmpty() && z) {
                radioInfo.MissingPermission = true;
            }
            h b2 = this.j.b(-1);
            radioInfo.ServiceState = b2.a;
            radioInfo.DuplexMode = b2.c;
            radioInfo.ManualSelection = b2.d;
            radioInfo.CarrierAggregation = b2.f;
            radioInfo.ARFCN = b2.e;
            if (b2.b > 0) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - b2.b;
                radioInfo.ServiceStateAge = elapsedRealtime2 > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime2;
            }
            radioInfo.NrState = b(d2);
            radioInfo.NrAvailable = c(d2);
            if (radioInfo.NetworkType == NetworkTypes.Unknown) {
                radioInfo.NetworkType = a(d2);
            }
            i a2 = this.j.a(-1);
            radioInfo.RSCP = a2.j;
            radioInfo.CdmaEcIo = a2.c;
            radioInfo.RXLevel = a2.a;
            radioInfo.NativeDbm = a2.b;
            radioInfo.EcN0 = a2.i;
            radioInfo.LteCqi = a2.d;
            radioInfo.LteRsrp = a2.e;
            radioInfo.LteRsrq = a2.g;
            radioInfo.LteRssnr = a2.f;
            radioInfo.LteRssi = a2.h;
            radioInfo.NrCsiRsrp = a2.l;
            radioInfo.NrCsiRsrq = a2.m;
            radioInfo.NrCsiSinr = a2.n;
            radioInfo.NrSsRsrp = a2.o;
            radioInfo.NrSsRsrq = a2.p;
            radioInfo.NrSsSinr = a2.q;
            if ((radioInfo.NetworkType == NetworkTypes.LTE || radioInfo.NetworkType == NetworkTypes.LTE_CA) && radioInfo.RXLevel >= 0) {
                radioInfo.RXLevel = radioInfo.LteRsrp;
            }
            if (radioInfo.NetworkType == NetworkTypes.LTE_CA) {
                radioInfo.CarrierAggregation = ThreeStateShort.Yes;
            }
            if (radioInfo.CarrierAggregation == ThreeStateShort.Unknown) {
                radioInfo.CarrierAggregation = d(d2);
            }
            if (radioInfo.NetworkType == NetworkTypes.NR) {
                int i2 = 0;
                int i3 = 0;
                try {
                    i2 = Integer.parseInt(radioInfo.MCC);
                    i3 = Integer.parseInt(radioInfo.MNC);
                } catch (NumberFormatException e4) {
                    new StringBuilder("radioInfo: ").append(e4.getMessage());
                }
                f a3 = this.j.a(new StringBuilder().append(i2).append(i3).toString());
                if (a3 != null) {
                    radioInfo.GsmCellId = new StringBuilder().append(a3.a).toString();
                    radioInfo.GsmLAC = new StringBuilder().append(a3.b).toString();
                    radioInfo.PrimaryScramblingCode = new StringBuilder().append(a3.c).toString();
                    radioInfo.GsmCellIdAge = (int) (SystemClock.elapsedRealtime() - (a3.d / 1000000));
                }
            }
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - a2.k;
            radioInfo.RXLevelAge = elapsedRealtime3 > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime3;
        }
        return radioInfo;
    }

    public final NetworkRegistrationInfo[] a(int i2) {
        NetworkRegistrationInfo[] d2 = this.j.d(i2);
        if (d2 != null) {
            h b2 = this.j.b(i2);
            for (NetworkRegistrationInfo networkRegistrationInfo : d2) {
                if (b2 != null && b2.b > 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - b2.b;
                    networkRegistrationInfo.Age = elapsedRealtime > 2147483647L ? Integer.MAX_VALUE : (int) elapsedRealtime;
                }
            }
            return d2;
        }
        return new NetworkRegistrationInfo[0];
    }

    @TargetApi(18)
    public final com.startapp.networkTest.data.radio.CellInfo[] d() {
        CellConnectionStatus cellConnectionStatus;
        if (this.f.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return new com.startapp.networkTest.data.radio.CellInfo[0];
        }
        ArrayList arrayList = new ArrayList();
        if (this.d != null && Build.VERSION.SDK_INT >= 18) {
            List<CellInfo> allCellInfo = this.d.getAllCellInfo();
            if (this.n != null && (allCellInfo == null || allCellInfo.isEmpty())) {
                allCellInfo = this.n;
            }
            if (allCellInfo == null) {
                return new com.startapp.networkTest.data.radio.CellInfo[0];
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (CellInfo cellInfo : allCellInfo) {
                com.startapp.networkTest.data.radio.CellInfo cellInfo2 = new com.startapp.networkTest.data.radio.CellInfo();
                if (Build.VERSION.SDK_INT >= 28) {
                    switch (cellInfo.getCellConnectionStatus()) {
                        case 0:
                            cellConnectionStatus = CellConnectionStatus.None;
                            break;
                        case 1:
                            cellConnectionStatus = CellConnectionStatus.Primary;
                            break;
                        case 2:
                            cellConnectionStatus = CellConnectionStatus.Secondary;
                            break;
                        default:
                            cellConnectionStatus = CellConnectionStatus.Unknown;
                            break;
                    }
                    cellInfo2.CellConnectionStatus = cellConnectionStatus;
                }
                if (!(cellInfo instanceof CellInfoGsm)) {
                    if (!(cellInfo instanceof CellInfoLte)) {
                        if (!(cellInfo instanceof CellInfoWcdma)) {
                            if (!(cellInfo instanceof CellInfoCdma)) {
                                if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                                    try {
                                        CellInfoNr cellInfoNr = (CellInfoNr) cellInfo;
                                        cellInfo2.IsRegistered = cellInfoNr.isRegistered();
                                        cellInfo2.CellNetworkType = CellNetworkTypes.Nr;
                                        cellInfo2.CellInfoAge = uptimeMillis - (cellInfoNr.getTimeStamp() / 1000000);
                                        CellIdentity cellIdentity = cellInfoNr.getCellIdentity();
                                        if (cellIdentity instanceof CellIdentityNr) {
                                            CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
                                            cellInfo2.Arfcn = cellIdentityNr.getNrarfcn();
                                            cellInfo2.LtePci = cellIdentityNr.getPci();
                                            cellInfo2.LteTac = cellIdentityNr.getTac();
                                            cellInfo2.CellId = cellIdentityNr.getNci();
                                            if (cellIdentityNr.getMccString() != null) {
                                                try {
                                                    cellInfo2.Mcc = Integer.parseInt(cellIdentityNr.getMccString());
                                                } catch (NumberFormatException e2) {
                                                    new StringBuilder("cellIdentityNr.getMccString: ").append(e2.getMessage());
                                                }
                                            }
                                            if (cellIdentityNr.getMncString() != null) {
                                                try {
                                                    cellInfo2.Mnc = Integer.parseInt(cellIdentityNr.getMncString());
                                                } catch (NumberFormatException e3) {
                                                    new StringBuilder("cellIdentityNr.getMncString: ").append(e3.getMessage());
                                                }
                                            }
                                        }
                                        CellSignalStrength cellSignalStrength = cellInfoNr.getCellSignalStrength();
                                        if (cellSignalStrength instanceof CellSignalStrengthNr) {
                                            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellSignalStrength;
                                            cellInfo2.Dbm = cellSignalStrengthNr.getDbm();
                                            cellInfo2.NrCsiRsrp = cellSignalStrengthNr.getCsiRsrp();
                                            cellInfo2.NrCsiRsrq = cellSignalStrengthNr.getCsiRsrq();
                                            cellInfo2.NrCsiSinr = cellSignalStrengthNr.getCsiSinr();
                                            cellInfo2.NrSsRsrp = cellSignalStrengthNr.getSsRsrp();
                                            cellInfo2.NrSsRsrq = cellSignalStrengthNr.getSsRsrq();
                                            cellInfo2.NrSsSinr = cellSignalStrengthNr.getSsSinr();
                                        }
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            } else {
                                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                                cellInfo2.IsRegistered = cellInfoCdma.isRegistered();
                                cellInfo2.CellNetworkType = CellNetworkTypes.Gsm;
                                cellInfo2.CellInfoAge = uptimeMillis - (cellInfoCdma.getTimeStamp() / 1000000);
                                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                                cellInfo2.CdmaBaseStationLatitude = cellIdentity2.getLatitude();
                                cellInfo2.CdmaBaseStationLongitude = cellIdentity2.getLongitude();
                                if (cellIdentity2.getSystemId() != Integer.MAX_VALUE) {
                                    cellInfo2.CdmaSystemId = cellIdentity2.getSystemId();
                                }
                                if (cellIdentity2.getNetworkId() != Integer.MAX_VALUE) {
                                    cellInfo2.CdmaNetworkId = cellIdentity2.getNetworkId();
                                }
                                if (cellIdentity2.getBasestationId() != Integer.MAX_VALUE) {
                                    cellInfo2.CdmaBaseStationId = cellIdentity2.getBasestationId();
                                }
                                CellSignalStrengthCdma cellSignalStrength2 = cellInfoCdma.getCellSignalStrength();
                                cellInfo2.Dbm = cellSignalStrength2.getDbm();
                                cellInfo2.CdmaDbm = cellSignalStrength2.getCdmaDbm();
                                cellInfo2.CdmaEcio = cellSignalStrength2.getCdmaEcio();
                                cellInfo2.EvdoDbm = cellSignalStrength2.getEvdoDbm();
                                cellInfo2.EvdoEcio = cellSignalStrength2.getEvdoEcio();
                                cellInfo2.EvdoSnr = cellSignalStrength2.getEvdoSnr();
                            }
                        } else {
                            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                            cellInfo2.IsRegistered = cellInfoWcdma.isRegistered();
                            cellInfo2.CellNetworkType = CellNetworkTypes.Wcdma;
                            cellInfo2.CellInfoAge = uptimeMillis - (cellInfoWcdma.getTimeStamp() / 1000000);
                            CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                            if (cellIdentity3.getMcc() != Integer.MAX_VALUE) {
                                cellInfo2.Mcc = cellIdentity3.getMcc();
                            }
                            if (cellIdentity3.getMnc() != Integer.MAX_VALUE) {
                                cellInfo2.Mnc = cellIdentity3.getMnc();
                            }
                            if (cellIdentity3.getCid() != Integer.MAX_VALUE) {
                                cellInfo2.Cid = cellIdentity3.getCid();
                                cellInfo2.CellId = cellInfo2.Cid;
                            }
                            if (cellIdentity3.getLac() != Integer.MAX_VALUE) {
                                cellInfo2.Lac = cellIdentity3.getLac();
                            }
                            if (cellIdentity3.getPsc() != Integer.MAX_VALUE) {
                                cellInfo2.Psc = cellIdentity3.getPsc();
                            }
                            if (Build.VERSION.SDK_INT >= 24 && cellIdentity3.getUarfcn() != Integer.MAX_VALUE) {
                                cellInfo2.Arfcn = cellIdentity3.getUarfcn();
                            }
                            cellInfo2.Dbm = cellInfoWcdma.getCellSignalStrength().getDbm();
                        }
                    } else {
                        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                        cellInfo2.IsRegistered = cellInfoLte.isRegistered();
                        cellInfo2.CellNetworkType = CellNetworkTypes.Lte;
                        cellInfo2.CellInfoAge = uptimeMillis - (cellInfoLte.getTimeStamp() / 1000000);
                        CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                        if (cellIdentity4.getMcc() != Integer.MAX_VALUE) {
                            cellInfo2.Mcc = cellIdentity4.getMcc();
                        }
                        if (cellIdentity4.getMnc() != Integer.MAX_VALUE) {
                            cellInfo2.Mnc = cellIdentity4.getMnc();
                        }
                        if (cellIdentity4.getCi() != Integer.MAX_VALUE) {
                            cellInfo2.Cid = cellIdentity4.getCi();
                            cellInfo2.CellId = cellInfo2.Cid;
                        }
                        if (cellIdentity4.getPci() != Integer.MAX_VALUE) {
                            cellInfo2.LtePci = cellIdentity4.getPci();
                        }
                        if (cellIdentity4.getTac() != Integer.MAX_VALUE) {
                            cellInfo2.LteTac = cellIdentity4.getTac();
                        }
                        if (Build.VERSION.SDK_INT >= 24 && cellIdentity4.getEarfcn() != Integer.MAX_VALUE) {
                            cellInfo2.Arfcn = cellIdentity4.getEarfcn();
                            com.startapp.sdk.adsbase.a a2 = com.startapp.networkTest.utils.d.a(cellInfo2.Arfcn);
                            if (a2 != null) {
                                cellInfo2.LteBand = a2.a;
                                cellInfo2.LteUploadEarfcn = a2.c;
                                cellInfo2.LteDownloadEarfcn = a2.b;
                                cellInfo2.LteUploadFrequency = a2.e;
                                cellInfo2.LteDonwloadFrequency = a2.d;
                            }
                        }
                        CellSignalStrengthLte cellSignalStrength3 = cellInfoLte.getCellSignalStrength();
                        cellInfo2.Dbm = cellSignalStrength3.getDbm();
                        if (cellSignalStrength3.getTimingAdvance() != Integer.MAX_VALUE) {
                            cellInfo2.LteTimingAdvance = cellSignalStrength3.getTimingAdvance();
                        }
                        if (Build.VERSION.SDK_INT >= 29) {
                            int cqi = cellSignalStrength3.getCqi();
                            if (cqi != Integer.MAX_VALUE) {
                                cellInfo2.LteCqi = cqi;
                            }
                            cellInfo2.LteRssnr = cellSignalStrength3.getRssnr();
                            cellInfo2.LteRsrq = cellSignalStrength3.getRsrq();
                            cellInfo2.LteRssi = cellSignalStrength3.getRssi();
                        } else {
                            if (this.I != null) {
                                try {
                                    int i2 = this.I.getInt(cellSignalStrength3);
                                    if (i2 != Integer.MAX_VALUE) {
                                        cellInfo2.LteCqi = i2;
                                    }
                                } catch (IllegalAccessException e5) {
                                }
                            }
                            if (this.G != null) {
                                try {
                                    cellInfo2.LteRsrq = this.G.getInt(cellSignalStrength3);
                                } catch (IllegalAccessException e6) {
                                }
                            }
                            if (this.H != null) {
                                try {
                                    cellInfo2.LteRssnr = this.H.getInt(cellSignalStrength3);
                                } catch (IllegalAccessException e7) {
                                }
                            }
                            if (this.F != null) {
                                try {
                                    cellInfo2.LteRssi = this.F.getInt(cellSignalStrength3);
                                } catch (IllegalAccessException e8) {
                                }
                            }
                        }
                    }
                } else {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    cellInfo2.IsRegistered = cellInfoGsm.isRegistered();
                    cellInfo2.CellNetworkType = CellNetworkTypes.Gsm;
                    cellInfo2.CellInfoAge = uptimeMillis - (cellInfoGsm.getTimeStamp() / 1000000);
                    CellIdentityGsm cellIdentity5 = cellInfoGsm.getCellIdentity();
                    if (cellIdentity5.getMcc() != Integer.MAX_VALUE) {
                        cellInfo2.Mcc = cellIdentity5.getMcc();
                    }
                    if (cellIdentity5.getMnc() != Integer.MAX_VALUE) {
                        cellInfo2.Mnc = cellIdentity5.getMnc();
                    }
                    if (cellIdentity5.getCid() != Integer.MAX_VALUE) {
                        cellInfo2.Cid = cellIdentity5.getCid();
                        cellInfo2.CellId = cellInfo2.Cid;
                    }
                    if (cellIdentity5.getLac() != Integer.MAX_VALUE) {
                        cellInfo2.Lac = cellIdentity5.getLac();
                    }
                    if (cellIdentity5.getPsc() != Integer.MAX_VALUE) {
                        cellInfo2.Psc = cellIdentity5.getPsc();
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (cellIdentity5.getArfcn() != Integer.MAX_VALUE) {
                            cellInfo2.Arfcn = cellIdentity5.getArfcn();
                        }
                        if (cellIdentity5.getBsic() != Integer.MAX_VALUE) {
                            cellInfo2.GsmBsic = cellIdentity5.getBsic();
                        }
                    }
                    cellInfo2.Dbm = cellInfoGsm.getCellSignalStrength().getDbm();
                }
                arrayList.add(cellInfo2);
            }
        }
        return (com.startapp.networkTest.data.radio.CellInfo[]) arrayList.toArray(new com.startapp.networkTest.data.radio.CellInfo[arrayList.size()]);
    }

    @TargetApi(21)
    public final ApnInfo[] e() {
        g e2;
        ArrayList arrayList = new ArrayList();
        for (a aVar : o()) {
            ApnInfo apnInfo = new ApnInfo();
            apnInfo.Apn = aVar.b;
            apnInfo.TxBytes = aVar.g;
            apnInfo.RxBytes = aVar.h;
            apnInfo.ApnTypes = aVar.c;
            apnInfo.Capabilities = aVar.d;
            apnInfo.SubscriptionId = aVar.f;
            apnInfo.PcscfAddresses = aVar.e;
            apnInfo.MobileDataConnectionState = aVar.j;
            apnInfo.NetworkType = b(aVar.a);
            apnInfo.Reason = this.j.a(aVar.f, aVar.c);
            if (apnInfo.ApnTypes.contains("ims") && (e2 = this.j.e(aVar.f)) != null) {
                apnInfo.SamsungSipError = e2.a;
                apnInfo.SamsungImsServices = e2.b;
            }
            arrayList.add(apnInfo);
        }
        return (ApnInfo[]) arrayList.toArray(new ApnInfo[arrayList.size()]);
    }

    private ThreeStateShort l() {
        if (Build.VERSION.SDK_INT < 16 || this.f.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return ThreeStateShort.Unknown;
        }
        return this.i.isActiveNetworkMetered() ? ThreeStateShort.Yes : ThreeStateShort.No;
    }

    public final ConnectionTypes f() {
        NetworkInfo activeNetworkInfo;
        ConnectionTypes connectionTypes = ConnectionTypes.Unknown;
        if (this.i != null && this.f.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && (activeNetworkInfo = this.i.getActiveNetworkInfo()) != null) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    connectionTypes = ConnectionTypes.Mobile;
                    break;
                case 1:
                    connectionTypes = ConnectionTypes.WiFi;
                    break;
                case 6:
                    connectionTypes = ConnectionTypes.WiMAX;
                    break;
                case 7:
                    connectionTypes = ConnectionTypes.Bluetooth;
                    break;
                case 9:
                    connectionTypes = ConnectionTypes.Ethernet;
                    break;
            }
        }
        return connectionTypes;
    }

    public static NetworkTypes b(int i2) {
        switch (i2) {
            case 1:
                return NetworkTypes.GPRS;
            case 2:
                return NetworkTypes.EDGE;
            case 3:
                return NetworkTypes.UMTS;
            case 4:
                return NetworkTypes.CDMA;
            case 5:
                return NetworkTypes.EVDO_0;
            case 6:
                return NetworkTypes.EVDO_A;
            case 7:
                return NetworkTypes.Cdma1xRTT;
            case 8:
                return NetworkTypes.HSDPA;
            case 9:
                return NetworkTypes.HSUPA;
            case 10:
                return NetworkTypes.HSPA;
            case 11:
                return NetworkTypes.IDEN;
            case 12:
                return NetworkTypes.EVDO_B;
            case 13:
                return NetworkTypes.LTE;
            case 14:
                return NetworkTypes.EHRPD;
            case 15:
                return NetworkTypes.HSPAP;
            case 16:
                return NetworkTypes.GSM;
            case 17:
                return NetworkTypes.TD_SCDMA;
            case 18:
                return NetworkTypes.WiFi;
            case 19:
                return NetworkTypes.LTE_CA;
            case 20:
                return NetworkTypes.NR;
            default:
                return NetworkTypes.Unknown;
        }
    }

    @TargetApi(17)
    private boolean m() {
        return Build.VERSION.SDK_INT < 17 ? Settings.System.getInt(this.Q, "airplane_mode_on", 0) != 0 : Settings.Global.getInt(this.Q, "airplane_mode_on", 0) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class j extends PhoneStateListener {
        private Field b;
        private int c;

        public j() {
            this.c = -1;
        }

        public j(int i) {
            this.c = -1;
            this.c = i;
            try {
                this.b = getClass().getSuperclass().getDeclaredField("mSubId");
                this.b.setAccessible(true);
                this.b.set(this, Integer.valueOf(i));
            } catch (Exception e) {
            }
        }

        final int a() {
            int i = -1;
            if (this.b != null) {
                try {
                    i = ((Integer) this.b.get(this)).intValue();
                } catch (IllegalAccessException e) {
                    Log.e(c.c, "getHiddenSubscriptionId: " + e.toString());
                }
            }
            if (Build.VERSION.SDK_INT >= 29 && (i == -1 || i == Integer.MAX_VALUE)) {
                return this.c;
            }
            return i;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int a = a();
            int intValue = RadioInfo.INVALID.intValue();
            int intValue2 = RadioInfo.INVALID.intValue();
            int intValue3 = RadioInfo.INVALID.intValue();
            int intValue4 = RadioInfo.INVALID.intValue();
            int intValue5 = RadioInfo.INVALID.intValue();
            int intValue6 = RadioInfo.INVALID.intValue();
            int intValue7 = RadioInfo.INVALID.intValue();
            int intValue8 = RadioInfo.INVALID.intValue();
            int intValue9 = RadioInfo.INVALID.intValue();
            int intValue10 = RadioInfo.INVALID.intValue();
            int intValue11 = RadioInfo.INVALID.intValue();
            int intValue12 = RadioInfo.INVALID.intValue();
            int intValue13 = RadioInfo.INVALID.intValue();
            int intValue14 = RadioInfo.INVALID.intValue();
            int intValue15 = RadioInfo.INVALID.intValue();
            int intValue16 = RadioInfo.INVALID.intValue();
            TelephonyManager telephonyManager = null;
            if (c.this.e != null) {
                telephonyManager = (TelephonyManager) c.this.e.get(a);
            }
            if (telephonyManager == null) {
                telephonyManager = c.this.d;
            }
            NetworkTypes networkTypes = NetworkTypes.Unknown;
            try {
                if (c.this.e == null && c.this.M != null) {
                    networkTypes = c.b(((Integer) c.this.M.invoke(c.this.d, Integer.valueOf(a))).intValue());
                } else {
                    networkTypes = c.b(telephonyManager.getNetworkType());
                }
            } catch (Exception e) {
                String unused = c.c;
                new StringBuilder("updateSignalStrengthData: ").append(e.getMessage());
            }
            if (networkTypes == NetworkTypes.Unknown) {
                networkTypes = c.a(c.this.j.d(a));
            }
            NetworkGenerations a2 = c.a(networkTypes);
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 29) {
                Iterator<CellSignalStrength> it = signalStrength.getCellSignalStrengths().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CellSignalStrength next = it.next();
                    if (a2 == NetworkGenerations.Gen2 && (next instanceof CellSignalStrengthGsm)) {
                        int dbm = ((CellSignalStrengthGsm) next).getDbm();
                        intValue2 = dbm;
                        intValue9 = dbm;
                        z = true;
                        break;
                    } else if (a2 == NetworkGenerations.Gen3 && (next instanceof CellSignalStrengthWcdma)) {
                        intValue9 = ((CellSignalStrengthWcdma) next).getDbm();
                        if (intValue2 == RadioInfo.INVALID.intValue()) {
                            intValue2 = intValue9;
                        }
                        z = true;
                    } else if (a2 == NetworkGenerations.Gen4 && (next instanceof CellSignalStrengthLte)) {
                        CellSignalStrengthLte cellSignalStrengthLte = (CellSignalStrengthLte) next;
                        int dbm2 = cellSignalStrengthLte.getDbm();
                        intValue9 = dbm2;
                        intValue2 = dbm2;
                        intValue3 = cellSignalStrengthLte.getCqi();
                        intValue4 = cellSignalStrengthLte.getRsrp();
                        intValue5 = cellSignalStrengthLte.getRssnr();
                        intValue6 = cellSignalStrengthLte.getRsrq();
                        intValue7 = cellSignalStrengthLte.getRssi();
                        z = true;
                        break;
                    } else if (a2 == NetworkGenerations.Gen5 && (next instanceof CellSignalStrengthNr)) {
                        CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) next;
                        int dbm3 = cellSignalStrengthNr.getDbm();
                        intValue9 = dbm3;
                        intValue2 = dbm3;
                        intValue11 = cellSignalStrengthNr.getCsiRsrp();
                        intValue12 = cellSignalStrengthNr.getCsiRsrq();
                        intValue13 = cellSignalStrengthNr.getCsiSinr();
                        intValue14 = cellSignalStrengthNr.getSsRsrp();
                        intValue15 = cellSignalStrengthNr.getSsRsrq();
                        intValue16 = cellSignalStrengthNr.getSsSinr();
                        z = true;
                        break;
                    } else if (a2 == NetworkGenerations.Gen2 && (next instanceof CellSignalStrengthCdma)) {
                        CellSignalStrengthCdma cellSignalStrengthCdma = (CellSignalStrengthCdma) next;
                        intValue = cellSignalStrengthCdma.getCdmaEcio();
                        int dbm4 = cellSignalStrengthCdma.getDbm();
                        intValue9 = dbm4;
                        intValue2 = dbm4;
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                if (signalStrength.isGsm()) {
                    if (c.this.y != null && a2 == NetworkGenerations.Gen3) {
                        try {
                            intValue10 = c.this.y.getInt(signalStrength);
                        } catch (IllegalAccessException e2) {
                            Log.e(c.c, "updateSignalStrengthData.WcdmaRscp: " + e2.toString());
                        }
                    }
                    int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                    if (gsmSignalStrength == 0 && intValue10 != RadioInfo.INVALID.intValue()) {
                        intValue2 = intValue10;
                    } else if (gsmSignalStrength < 0) {
                        intValue2 = gsmSignalStrength;
                    } else {
                        intValue2 = c.e(gsmSignalStrength);
                    }
                } else {
                    intValue2 = signalStrength.getCdmaDbm();
                    intValue = signalStrength.getCdmaEcio();
                }
                try {
                    if (c.this.o != null) {
                        intValue9 = ((Integer) c.this.o.invoke(signalStrength, new Object[0])).intValue();
                    }
                } catch (Exception e3) {
                    Log.e(c.c, "updateSignalStrengthData.GetDbm: " + e3.toString());
                }
                if (a2 == NetworkGenerations.Gen4) {
                    try {
                        if (c.this.q != null) {
                            intValue2 = ((Integer) c.this.q.invoke(signalStrength, new Object[0])).intValue();
                        }
                    } catch (Exception e4) {
                        Log.e(c.c, "updateSignalStrengthData.GetLTEDbm: " + e4.toString());
                    }
                    if (c.this.p != null) {
                        try {
                            intValue7 = ((Integer) c.this.p.invoke(signalStrength, new Object[0])).intValue();
                        } catch (Exception e5) {
                            Log.e(c.c, "updateSignalStrengthData.GetLteSignalStrength: " + e5.toString());
                        }
                    }
                    try {
                        if (c.this.s != null) {
                            intValue3 = ((Integer) c.this.s.invoke(signalStrength, new Object[0])).intValue();
                        }
                    } catch (Exception e6) {
                        Log.e(c.c, "updateSignalStrengthData.GetLteCqi: " + e6.toString());
                    }
                    try {
                        if (c.this.t != null) {
                            intValue4 = ((Integer) c.this.t.invoke(signalStrength, new Object[0])).intValue();
                        }
                    } catch (Exception e7) {
                        Log.e(c.c, "updateSignalStrengthData.GetLteRsrp: " + e7.toString());
                    }
                    try {
                        if (c.this.u != null) {
                            intValue6 = ((Integer) c.this.u.invoke(signalStrength, new Object[0])).intValue();
                        }
                    } catch (Exception e8) {
                        Log.e(c.c, "updateSignalStrengthData.GetLteRsrq: " + e8.toString());
                    }
                    try {
                        if (c.this.v != null) {
                            intValue5 = ((Integer) c.this.v.invoke(signalStrength, new Object[0])).intValue();
                        }
                    } catch (Exception e9) {
                        Log.e(c.c, "updateSignalStrengthData.GetLteRssnr: " + e9.toString());
                    }
                }
                if (a2 == NetworkGenerations.Gen5) {
                    if (c.this.A != null) {
                        try {
                            intValue11 = c.this.A.getInt(signalStrength);
                        } catch (IllegalAccessException e10) {
                            Log.e(c.c, "updateSignalStrengthData.NrCsiRsrp: " + e10.toString());
                        }
                    }
                    if (c.this.B != null) {
                        try {
                            intValue12 = c.this.B.getInt(signalStrength);
                        } catch (IllegalAccessException e11) {
                            Log.e(c.c, "updateSignalStrengthData.NrCsiRsrq: " + e11.toString());
                        }
                    }
                    if (c.this.C != null) {
                        try {
                            intValue13 = c.this.C.getInt(signalStrength);
                        } catch (IllegalAccessException e12) {
                            Log.e(c.c, "updateSignalStrengthData.NrCsiSinr: " + e12.toString());
                        }
                    }
                }
                try {
                    if (c.this.r != null) {
                        intValue8 = ((Integer) c.this.r.invoke(signalStrength, new Object[0])).intValue();
                    }
                } catch (Exception e13) {
                    Log.e(c.c, "updateSignalStrengthData.GetEcno: " + e13.toString());
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            i iVar = new i(c.this, (byte) 0);
            iVar.c = intValue;
            iVar.a = intValue2;
            iVar.b = intValue9;
            iVar.d = intValue3;
            iVar.e = intValue4;
            iVar.f = intValue5;
            iVar.g = intValue6;
            iVar.h = intValue7;
            iVar.l = intValue11;
            iVar.m = intValue12;
            iVar.n = intValue13;
            iVar.o = intValue14;
            iVar.p = intValue15;
            iVar.q = intValue16;
            iVar.j = intValue10;
            iVar.i = intValue8;
            iVar.k = elapsedRealtime;
            c.this.j.a(a, iVar);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(final ServiceState serviceState) {
            ServiceStates serviceStates;
            DuplexMode duplexMode;
            final int a = a();
            h hVar = new h(c.this, (byte) 0);
            if (Build.VERSION.SDK_INT >= 25) {
                if (c.this.E != null) {
                    try {
                        hVar.f = c.this.E.getBoolean(serviceState) ? ThreeStateShort.Yes : ThreeStateShort.No;
                    } catch (IllegalAccessException e) {
                        Log.e(c.c, "updateSignalStrengthData.mFieldIsUsingCarrierAggregation: " + e.toString());
                    }
                }
                if (hVar.f == ThreeStateShort.Unknown && c.this.D != null) {
                    try {
                        hVar.f = ((Boolean) c.this.D.invoke(serviceState, new Object[0])).booleanValue() ? ThreeStateShort.Yes : ThreeStateShort.No;
                    } catch (Exception e2) {
                        Log.e(c.c, "updateSignalStrengthData.mMethodIsUsingCarrierAggregation: " + e2.toString());
                    }
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    switch (serviceState.getDuplexMode()) {
                        case 1:
                            duplexMode = DuplexMode.FDD;
                            break;
                        case 2:
                            duplexMode = DuplexMode.TDD;
                            break;
                        default:
                            duplexMode = DuplexMode.Unknown;
                            break;
                    }
                    hVar.c = duplexMode;
                    hVar.e = serviceState.getChannelNumber();
                }
            }
            hVar.d = serviceState.getIsManualSelection() ? ThreeStateShort.Yes : ThreeStateShort.No;
            switch (serviceState.getState()) {
                case 0:
                    serviceStates = ServiceStates.InService;
                    break;
                case 1:
                    serviceStates = ServiceStates.OutOfService;
                    break;
                case 2:
                    serviceStates = ServiceStates.EmergencyOnly;
                    break;
                case 3:
                    serviceStates = ServiceStates.PowerOff;
                    break;
                default:
                    serviceStates = ServiceStates.Unknown;
                    break;
            }
            hVar.a = serviceStates;
            hVar.b = SystemClock.elapsedRealtime();
            NetworkRegistrationInfo[] a2 = com.iab.omid.library.startapp.b.a(serviceState.toString());
            c.this.j.a(a, hVar);
            c.this.j.a(a, a2);
            c.this.a.post(new Runnable() { // from class: com.startapp.networkTest.controller.c.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (com.startapp.networkTest.controller.a.a aVar : c.this.b) {
                        aVar.a(serviceState, a);
                    }
                }
            });
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            if (list != null) {
                c.this.n = list;
                if (Build.VERSION.SDK_INT < 29) {
                    return;
                }
                for (CellInfo cellInfo : list) {
                    if (cellInfo.isRegistered() && (cellInfo instanceof CellInfoNr)) {
                        CellInfoNr cellInfoNr = (CellInfoNr) cellInfo;
                        CellIdentity cellIdentity = cellInfoNr.getCellIdentity();
                        if (cellIdentity instanceof CellIdentityNr) {
                            CellIdentityNr cellIdentityNr = (CellIdentityNr) cellIdentity;
                            int i = 0;
                            int i2 = 0;
                            try {
                                i = Integer.parseInt(cellIdentityNr.getMccString());
                                i2 = Integer.parseInt(cellIdentityNr.getMncString());
                            } catch (NumberFormatException e) {
                                String unused = c.c;
                                new StringBuilder("updateCellInfo: ").append(e.getMessage());
                            }
                            long nci = cellIdentityNr.getNci();
                            int tac = cellIdentityNr.getTac();
                            int pci = cellIdentityNr.getPci();
                            String sb = new StringBuilder().append(i).append(i2).toString();
                            if (nci == 2147483647L) {
                                nci = -1;
                            }
                            if (tac == Integer.MAX_VALUE) {
                                tac = -1;
                            }
                            if (pci == Integer.MAX_VALUE) {
                                pci = -1;
                            }
                            f fVar = new f(c.this, (byte) 0);
                            fVar.a = nci;
                            fVar.b = tac;
                            fVar.c = pci;
                            fVar.d = cellInfoNr.getTimeStamp();
                            c.this.j.a(sb, fVar);
                        }
                    }
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(final CellLocation cellLocation) {
            final int a = a();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            b bVar = new b(c.this, (byte) 0);
            bVar.a = cellLocation;
            bVar.b = elapsedRealtime;
            c.this.j.a(a, bVar);
            c.this.a.post(new Runnable() { // from class: com.startapp.networkTest.controller.c.j.2
                @Override // java.lang.Runnable
                public final void run() {
                    for (com.startapp.networkTest.controller.a.a aVar : c.this.b) {
                        aVar.a(cellLocation, a);
                    }
                }
            });
        }
    }

    public final boolean c(int i2) {
        boolean isNetworkRoaming;
        if (this.L != null) {
            try {
                isNetworkRoaming = ((Boolean) this.L.invoke(this.d, Integer.valueOf(i2))).booleanValue();
            } catch (Exception e2) {
                Log.e(c, "isRoaming: " + e2.toString());
            }
            return isNetworkRoaming;
        }
        isNetworkRoaming = this.d.isNetworkRoaming();
        return isNetworkRoaming;
    }

    public static NetworkGenerations a(NetworkTypes networkTypes) {
        switch (networkTypes) {
            case GPRS:
            case EDGE:
            case GSM:
            case Cdma1xRTT:
            case CDMA:
            case IDEN:
                return NetworkGenerations.Gen2;
            case UMTS:
            case EVDO_0:
            case EVDO_A:
            case EVDO_B:
            case HSPA:
            case HSDPA:
            case HSPAP:
            case HSUPA:
            case EHRPD:
            case TD_SCDMA:
                return NetworkGenerations.Gen3;
            case LTE:
            case LTE_CA:
                return NetworkGenerations.Gen4;
            case NR:
                return NetworkGenerations.Gen5;
            default:
                return NetworkGenerations.Unknown;
        }
    }

    private NetworkTypes n() {
        if (com.startapp.networkTest.utils.e.a(this.f)) {
            if (this.d != null && Build.VERSION.SDK_INT >= 24) {
                return b(this.d.getVoiceNetworkType());
            }
            if (this.w != null) {
                try {
                    return b(((Integer) this.w.invoke(this.d, new Object[0])).intValue());
                } catch (Exception e2) {
                    Log.e(c, "getVoiceNetworkType: " + e2.toString());
                }
            }
        }
        return NetworkTypes.Unknown;
    }

    public final NetworkTypes d(int i2) {
        if (f(i2) && com.startapp.networkTest.utils.e.a(this.f)) {
            if (this.e != null && this.e.get(i2) != null && Build.VERSION.SDK_INT >= 24) {
                return b(this.e.get(i2).getVoiceNetworkType());
            }
            if (this.x != null) {
                try {
                    return b(((Integer) this.x.invoke(this.d, Integer.valueOf(i2))).intValue());
                } catch (Exception e2) {
                    Log.e(c, "getVoiceNetworkType: " + e2.toString());
                }
            }
        }
        return n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class d {
        private SparseArray<i> a = new SparseArray<>();
        private SparseArray<h> b = new SparseArray<>();
        private SparseArray<b> c = new SparseArray<>();
        private HashMap<String, f> d = new HashMap<>();
        private SparseArray<NetworkRegistrationInfo[]> e = new SparseArray<>();
        private Map<String, String> g = new HashMap();
        private SparseArray<g> f = new SparseArray<>();

        d() {
        }

        final void a(int i, i iVar) {
            this.a.put(i, iVar);
        }

        final void a(int i, h hVar) {
            this.b.put(i, hVar);
        }

        final void a(int i, b bVar) {
            this.c.put(i, bVar);
        }

        final void a(int i, NetworkRegistrationInfo[] networkRegistrationInfoArr) {
            this.e.put(i, networkRegistrationInfoArr);
        }

        final void a(String str, f fVar) {
            this.d.put(str, fVar);
        }

        final void a(int i, String str, String str2) {
            this.g.put(i + str, str2);
        }

        final void a(int i, g gVar) {
            this.f.put(i, gVar);
        }

        final i a(int i) {
            i iVar = this.a.get(i);
            if (iVar != null) {
                return iVar;
            }
            return new i(c.this, (byte) 0);
        }

        final h b(int i) {
            h hVar = this.b.get(i);
            if (hVar != null) {
                return hVar;
            }
            return new h(c.this, (byte) 0);
        }

        final b c(int i) {
            return this.c.get(i);
        }

        final f a(String str) {
            return this.d.get(str);
        }

        final NetworkRegistrationInfo[] d(int i) {
            return this.e.get(i);
        }

        final String a(int i, String str) {
            String str2 = this.g.get(i + (str != null ? str.split(",")[0] : ""));
            String str3 = str2;
            if (str2 == null) {
                str3 = "";
            }
            return str3;
        }

        final g e(int i) {
            return this.f.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class i {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        int j;
        long k;
        int l;
        int m;
        int n;
        int o;
        int p;
        int q;

        private i() {
            this.a = RadioInfo.INVALID.intValue();
            this.b = RadioInfo.INVALID.intValue();
            this.c = RadioInfo.INVALID.intValue();
            this.d = RadioInfo.INVALID.intValue();
            this.e = RadioInfo.INVALID.intValue();
            this.f = RadioInfo.INVALID.intValue();
            this.g = RadioInfo.INVALID.intValue();
            this.h = RadioInfo.INVALID.intValue();
            this.i = RadioInfo.INVALID.intValue();
            this.j = RadioInfo.INVALID.intValue();
            this.l = RadioInfo.INVALID.intValue();
            this.m = RadioInfo.INVALID.intValue();
            this.n = RadioInfo.INVALID.intValue();
            this.o = RadioInfo.INVALID.intValue();
            this.p = RadioInfo.INVALID.intValue();
            this.q = RadioInfo.INVALID.intValue();
        }

        /* synthetic */ i(c cVar, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class b {
        CellLocation a;
        long b;

        private b() {
            this.b = 0L;
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class f {
        long a;
        int b;
        int c;
        long d;

        private f() {
            this.a = 0L;
            this.b = 0;
            this.c = 0;
            this.d = 0L;
        }

        /* synthetic */ f(c cVar, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class h {
        ServiceStates a;
        long b;
        DuplexMode c;
        ThreeStateShort d;
        int e;
        ThreeStateShort f;

        private h() {
            this.a = ServiceStates.Unknown;
            this.b = 0L;
            this.c = DuplexMode.Unknown;
            this.d = ThreeStateShort.Unknown;
            this.e = -1;
            this.f = ThreeStateShort.Unknown;
        }

        /* synthetic */ h(c cVar, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class a {
        int a;
        String b;
        String c;
        String d;
        String e;
        int f;
        long g;
        long h;
        String i;
        WifiDetailedStates j;
        private String k;

        private a() {
            this.a = -1;
            this.b = "";
            this.k = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = -1;
            this.g = -1L;
            this.h = -1L;
            this.i = "";
            this.j = WifiDetailedStates.Unknown;
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class g {
        int a;
        String b;

        private g() {
            this.a = -1;
            this.b = "";
        }

        /* synthetic */ g(c cVar, byte b) {
            this();
        }
    }

    private List<a> o() {
        Network[] allNetworks;
        ArrayList arrayList = new ArrayList();
        if (this.i != null && Build.VERSION.SDK_INT >= 21 && this.f.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && (allNetworks = this.i.getAllNetworks()) != null && allNetworks.length > 0) {
            for (Network network : allNetworks) {
                NetworkCapabilities networkCapabilities = this.i.getNetworkCapabilities(network);
                if (networkCapabilities != null && networkCapabilities.hasTransport(0)) {
                    a aVar = new a(this, (byte) 0);
                    NetworkInfo networkInfo = this.i.getNetworkInfo(network);
                    LinkProperties linkProperties = this.i.getLinkProperties(network);
                    ArrayList arrayList2 = new ArrayList();
                    if (networkCapabilities.hasCapability(4)) {
                        arrayList2.add("ims");
                    }
                    if (networkCapabilities.hasCapability(1)) {
                        arrayList2.add("supl");
                    }
                    if (networkCapabilities.hasCapability(9)) {
                        arrayList2.add("xcap");
                    }
                    if (networkCapabilities.hasCapability(2)) {
                        arrayList2.add("dun");
                    }
                    if (networkCapabilities.hasCapability(5)) {
                        arrayList2.add("cbs");
                    }
                    if (networkCapabilities.hasCapability(3)) {
                        arrayList2.add("fota");
                    }
                    if (networkCapabilities.hasCapability(10)) {
                        arrayList2.add("emergency");
                    }
                    if (networkCapabilities.hasCapability(7)) {
                        arrayList2.add("ia");
                    }
                    if (networkCapabilities.hasCapability(0)) {
                        arrayList2.add("mms");
                    }
                    if (networkCapabilities.hasCapability(8)) {
                        arrayList2.add("rcs");
                    }
                    if (networkCapabilities.hasCapability(23)) {
                        arrayList2.add("mcx");
                    }
                    aVar.c = TextUtils.join(",", arrayList2);
                    if (networkInfo != null) {
                        aVar.b = networkInfo.getExtraInfo();
                        aVar.a = networkInfo.getSubtype();
                        aVar.j = WifiDetailedStates.a(networkInfo.getDetailedState());
                    }
                    if (linkProperties != null) {
                        aVar.d = com.iab.omid.library.startapp.b.a(networkCapabilities);
                        aVar.f = com.iab.omid.library.startapp.b.b(networkCapabilities);
                        aVar.e = com.iab.omid.library.startapp.b.a(linkProperties);
                        String interfaceName = linkProperties.getInterfaceName();
                        if (interfaceName != null) {
                            try {
                                aVar.g = com.startapp.networkTest.utils.i.a(interfaceName);
                                aVar.h = com.startapp.networkTest.utils.i.b(interfaceName);
                            } catch (Exception e2) {
                            }
                            aVar.i = interfaceName;
                        }
                    }
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class e extends BroadcastReceiver {
        private String a;
        private String b;

        private e() {
            this.a = "android.intent.action.ANY_DATA_STATE";
            this.b = "com.samsung.ims.action.IMS_REGISTRATION";
        }

        /* synthetic */ e(c cVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                try {
                    String action = intent.getAction();
                    Bundle extras = intent.getExtras();
                    if (action.equalsIgnoreCase("android.intent.action.ANY_DATA_STATE") && extras != null) {
                        String string = extras.getString("reason", "");
                        String string2 = extras.getString("apnType", "");
                        int i = -1;
                        if (extras.get("subscription") instanceof Integer) {
                            i = extras.getInt("subscription", -1);
                        } else if (extras.get("subscription") instanceof Long) {
                            i = (int) extras.getLong("subscription", -1L);
                        }
                        c.this.j.a(i, string2.equalsIgnoreCase("default") ? "supl" : string2, string);
                    } else if (action.equalsIgnoreCase("com.samsung.ims.action.IMS_REGISTRATION") && extras != null) {
                        String string3 = extras.getString("SERVICE");
                        int i2 = extras.getInt("PHONE_ID", -1);
                        int i3 = extras.getInt("SIP_ERROR", -1);
                        extras.getBoolean("VOWIFI", false);
                        extras.getBoolean("REGISTERED", false);
                        g gVar = new g(c.this, (byte) 0);
                        gVar.a = i3;
                        if (string3 != null) {
                            gVar.b = string3.replaceAll("\\[", "").replaceAll("\\]", "").replace(", ", ",");
                        }
                        int i4 = -1;
                        Iterator<com.startapp.networkTest.data.a.b> it = com.startapp.networkTest.controller.b.g(c.this.f).SimInfos.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            com.startapp.networkTest.data.a.b next = it.next();
                            if (next.SimSlotIndex == i2) {
                                i4 = next.SubscriptionId;
                                break;
                            }
                        }
                        c.this.j.a(i4, gVar);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static PreferredNetworkTypes a(Context context, int i2) {
        PreferredNetworkTypes preferredNetworkTypes = PreferredNetworkTypes.Unknown;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                preferredNetworkTypes = h(Settings.Global.getInt(context.getContentResolver(), "preferred_network_mode".concat(String.valueOf(i2))));
            } catch (Exception e2) {
            }
        }
        return preferredNetworkTypes;
    }

    private static SparseArray<PreferredNetworkTypes> a(Context context) {
        SparseArray<PreferredNetworkTypes> sparseArray = new SparseArray<>();
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                String[] split = Settings.Global.getString(context.getContentResolver(), "preferred_network_mode").split(",");
                for (int i2 = 0; i2 < split.length; i2++) {
                    sparseArray.put(i2, h(Integer.valueOf(split[i2]).intValue()));
                }
            } catch (Exception e2) {
            }
        }
        return sparseArray;
    }

    private static PreferredNetworkTypes h(int i2) {
        switch (i2) {
            case 0:
                return PreferredNetworkTypes.WCDMA_PREF;
            case 1:
                return PreferredNetworkTypes.GSM_ONLY;
            case 2:
                return PreferredNetworkTypes.WCDMA_ONLY;
            case 3:
                return PreferredNetworkTypes.GSM_UMTS;
            case 4:
                return PreferredNetworkTypes.CDMA;
            case 5:
                return PreferredNetworkTypes.CDMA_NO_EVDO;
            case 6:
                return PreferredNetworkTypes.EVDO_NO_CDMA;
            case 7:
                return PreferredNetworkTypes.GLOBAL;
            case 8:
                return PreferredNetworkTypes.LTE_CDMA_EVDO;
            case 9:
                return PreferredNetworkTypes.LTE_GSM_WCDMA;
            case 10:
                return PreferredNetworkTypes.LTE_CDMA_EVDO_GSM_WCDMA;
            case 11:
                return PreferredNetworkTypes.LTE_ONLY;
            case 12:
                return PreferredNetworkTypes.LTE_WCDMA;
            case 13:
                return PreferredNetworkTypes.TDSCDMA_ONLY;
            case 14:
                return PreferredNetworkTypes.TDSCDMA_WCDMA;
            case 15:
                return PreferredNetworkTypes.LTE_TDSCDMA;
            case 16:
                return PreferredNetworkTypes.TDSCDMA_GSM;
            case 17:
                return PreferredNetworkTypes.LTE_TDSCDMA_GSM;
            case 18:
                return PreferredNetworkTypes.TDSCDMA_GSM_WCDMA;
            case 19:
                return PreferredNetworkTypes.LTE_TDSCDMA_WCDMA;
            case 20:
                return PreferredNetworkTypes.LTE_TDSCDMA_GSM_WCDMA;
            case 21:
                return PreferredNetworkTypes.TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            case 22:
                return PreferredNetworkTypes.LTE_TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            case 23:
                return PreferredNetworkTypes.NR_ONLY;
            case 24:
                return PreferredNetworkTypes.NR_LTE;
            case 25:
                return PreferredNetworkTypes.NR_LTE_CDMA_EVDO;
            case 26:
                return PreferredNetworkTypes.NR_LTE_GSM_WCDMA;
            case 27:
                return PreferredNetworkTypes.NR_LTE_CDMA_EVDO_GSM_WCDMA;
            case 28:
                return PreferredNetworkTypes.NR_LTE_WCDMA;
            case 29:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA;
            case 30:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA_GSM;
            case 31:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA_WCDMA;
            case 32:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA_GSM_WCDMA;
            case 33:
                return PreferredNetworkTypes.NR_LTE_TDSCDMA_CDMA_EVDO_GSM_WCDMA;
            default:
                return PreferredNetworkTypes.Unknown;
        }
    }

    public final void a(final com.startapp.networkTest.controller.a.a aVar) {
        if (aVar != null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                this.a.post(new Runnable() { // from class: com.startapp.networkTest.controller.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.a(aVar);
                    }
                });
            } else if (!this.b.contains(aVar)) {
                this.b.add(aVar);
            }
        }
    }

    public final void b(final com.startapp.networkTest.controller.a.a aVar) {
        if (aVar != null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                this.a.post(new Runnable() { // from class: com.startapp.networkTest.controller.c.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.b(aVar);
                    }
                });
            } else {
                this.b.remove(aVar);
            }
        }
    }

    public final com.startapp.networkTest.data.a.a g() {
        return this.l;
    }

    private static String b(NetworkRegistrationInfo[] networkRegistrationInfoArr) {
        if (networkRegistrationInfoArr != null) {
            for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoArr) {
                if (networkRegistrationInfo.Domain.equals("PS") && networkRegistrationInfo.TransportType.equals("WWAN")) {
                    return networkRegistrationInfo.NrState;
                }
            }
        }
        return "Unknown";
    }

    private static ThreeStateShort c(NetworkRegistrationInfo[] networkRegistrationInfoArr) {
        if (networkRegistrationInfoArr != null) {
            for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoArr) {
                if (networkRegistrationInfo.Domain.equals("PS") && networkRegistrationInfo.TransportType.equals("WWAN")) {
                    return networkRegistrationInfo.NrAvailable;
                }
            }
        }
        return ThreeStateShort.Unknown;
    }

    public static NetworkTypes a(NetworkRegistrationInfo[] networkRegistrationInfoArr) {
        if (networkRegistrationInfoArr != null) {
            for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoArr) {
                if (networkRegistrationInfo.Domain.equals("PS")) {
                    String str = networkRegistrationInfo.NetworkTechnology;
                    boolean z = true;
                    switch (str.hashCode()) {
                        case -2039427040:
                            if (str.equals("LTE_CA")) {
                                z = true;
                                break;
                            }
                            break;
                        case -908593671:
                            if (str.equals("TD_SCDMA")) {
                                z = true;
                                break;
                            }
                            break;
                        case 2500:
                            if (str.equals("NR")) {
                                z = true;
                                break;
                            }
                            break;
                        case 70881:
                            if (str.equals("GSM")) {
                                z = true;
                                break;
                            }
                            break;
                        case 75709:
                            if (str.equals("LTE")) {
                                z = true;
                                break;
                            }
                            break;
                        case 2063797:
                            if (str.equals("CDMA")) {
                                z = true;
                                break;
                            }
                            break;
                        case 2123197:
                            if (str.equals("EDGE")) {
                                z = true;
                                break;
                            }
                            break;
                        case 2194666:
                            if (str.equals("GPRS")) {
                                z = true;
                                break;
                            }
                            break;
                        case 2227260:
                            if (str.equals("HSPA")) {
                                z = true;
                                break;
                            }
                            break;
                        case 2608919:
                            if (str.equals("UMTS")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3195620:
                            if (str.equals("iDEN")) {
                                z = true;
                                break;
                            }
                            break;
                        case 69034058:
                            if (str.equals("HSDPA")) {
                                z = true;
                                break;
                            }
                            break;
                        case 69045140:
                            if (str.equals("HSPAP")) {
                                z = true;
                                break;
                            }
                            break;
                        case 69050395:
                            if (str.equals("HSUPA")) {
                                z = true;
                                break;
                            }
                            break;
                        case 70083979:
                            if (str.equals("IWLAN")) {
                                z = true;
                                break;
                            }
                            break;
                        case 836263277:
                            if (str.equals("CDMA - 1xRTT")) {
                                z = false;
                                break;
                            }
                            break;
                        case 882856261:
                            if (str.equals("CDMA - eHRPD")) {
                                z = true;
                                break;
                            }
                            break;
                        case 893165057:
                            if (str.equals("CDMA - EvDo rev. 0")) {
                                z = true;
                                break;
                            }
                            break;
                        case 893165074:
                            if (str.equals("CDMA - EvDo rev. A")) {
                                z = true;
                                break;
                            }
                            break;
                        case 893165075:
                            if (str.equals("CDMA - EvDo rev. B")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            return NetworkTypes.Cdma1xRTT;
                        case true:
                            return NetworkTypes.CDMA;
                        case true:
                            return NetworkTypes.EDGE;
                        case true:
                            return NetworkTypes.EHRPD;
                        case true:
                            return NetworkTypes.EVDO_0;
                        case true:
                            return NetworkTypes.EVDO_A;
                        case true:
                            return NetworkTypes.EVDO_B;
                        case true:
                            return NetworkTypes.GPRS;
                        case true:
                            return NetworkTypes.HSPA;
                        case true:
                            return NetworkTypes.HSDPA;
                        case true:
                            return NetworkTypes.HSPAP;
                        case true:
                            return NetworkTypes.HSUPA;
                        case true:
                            return NetworkTypes.IDEN;
                        case true:
                            return NetworkTypes.LTE;
                        case true:
                            return NetworkTypes.UMTS;
                        case true:
                            return NetworkTypes.GSM;
                        case true:
                            return NetworkTypes.TD_SCDMA;
                        case true:
                            return NetworkTypes.WiFi;
                        case true:
                            return NetworkTypes.LTE_CA;
                        case true:
                            return NetworkTypes.NR;
                        default:
                            return NetworkTypes.Unknown;
                    }
                }
            }
        }
        return NetworkTypes.Unknown;
    }

    private static ThreeStateShort d(NetworkRegistrationInfo[] networkRegistrationInfoArr) {
        if (networkRegistrationInfoArr != null) {
            for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoArr) {
                if (networkRegistrationInfo.Domain.equals("PS")) {
                    return networkRegistrationInfo.CarrierAggregation;
                }
            }
        }
        return ThreeStateShort.Unknown;
    }

    private ThreeStateShort p() {
        ThreeStateShort threeStateShort = ThreeStateShort.Unknown;
        if (Build.VERSION.SDK_INT >= 23 && this.f.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && this.i != null) {
            NetworkCapabilities networkCapabilities = this.i.getNetworkCapabilities(this.i.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasTransport(4) ? ThreeStateShort.Yes : ThreeStateShort.No;
            }
        }
        return threeStateShort;
    }
}
