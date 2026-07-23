package com.startapp.networkTest.startapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.startapp.networkTest.c.b;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.enums.LocationProviders;
import com.startapp.networkTest.enums.TriggerEvents;
import com.startapp.networkTest.results.NetworkInformationResult;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class CoverageMapperManager implements LocationController.b, com.startapp.networkTest.controller.a.a {
    private Context a;
    private b b;
    private long d;
    private ScheduledFuture<?> e;
    private ScheduledFuture<?> f;
    private long g;
    private long h;
    private long j;
    private OnNetworkInfoResultListener l;
    private boolean c = false;
    private int i = -1;
    private int k = -1;
    private Runnable m = new Runnable() { // from class: com.startapp.networkTest.startapp.CoverageMapperManager.2
        @Override // java.lang.Runnable
        public final void run() {
            CoverageMapperManager.a(CoverageMapperManager.this, null, TriggerEvents.OutOfService, true);
            if (CoverageMapperManager.this.g + 10000 < SystemClock.elapsedRealtime()) {
                CoverageMapperManager.this.e.cancel(false);
            }
        }
    };
    private Runnable n = new Runnable() { // from class: com.startapp.networkTest.startapp.CoverageMapperManager.3
        @Override // java.lang.Runnable
        public final void run() {
            CoverageMapperManager.a(CoverageMapperManager.this, null, TriggerEvents.CellIdChange, true);
            if (CoverageMapperManager.this.j + 1 < SystemClock.elapsedRealtime()) {
                CoverageMapperManager.this.f.cancel(false);
            }
        }
    };
    private BroadcastReceiver o = new BroadcastReceiver() { // from class: com.startapp.networkTest.startapp.CoverageMapperManager.4
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            CoverageMapperManager.this.h = SystemClock.elapsedRealtime();
        }
    };

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public interface OnNetworkInfoResultListener {
        void onNetworkInfoResult(NetworkInformationResult networkInformationResult);
    }

    static {
        com.startapp.common.b.b.a(CoverageMapperManager.class);
    }

    public CoverageMapperManager(Context context) {
        this.b = new b(context);
        this.a = context;
    }

    public final void a(OnNetworkInfoResultListener onNetworkInfoResultListener) {
        this.l = onNetworkInfoResultListener;
    }

    public final void a() {
        if (!this.c) {
            this.c = true;
            this.b.a((com.startapp.networkTest.controller.a.a) this);
            this.b.a((LocationController.b) this);
            this.b.a();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
            intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
            this.a.registerReceiver(this.o, intentFilter);
        }
    }

    public final void b() {
        if (this.c) {
            this.b.b(this);
            this.b.c();
            this.b.b();
            try {
                this.a.unregisterReceiver(this.o);
            } catch (Throwable th) {
                a.a(th);
            }
            this.c = false;
        }
    }

    @Override // com.startapp.networkTest.controller.LocationController.b
    public final void a(final LocationInfo locationInfo) {
        if (locationInfo.LocationProvider == LocationProviders.Gps) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime >= this.d + 500) {
                this.d = elapsedRealtime;
                com.startapp.networkTest.threads.a.a().b().execute(new Runnable() { // from class: com.startapp.networkTest.startapp.CoverageMapperManager.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CoverageMapperManager.a(CoverageMapperManager.this, locationInfo, TriggerEvents.LocationUpdateGps, false);
                    }
                });
            }
        }
    }

    @Override // com.startapp.networkTest.controller.a.a
    public final void a(ServiceState serviceState, int i) {
        if (this.b.d().g().DefaultDataSimId == i) {
            int state = serviceState.getState();
            if (state == 1 && this.i == 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.h + 10000 <= elapsedRealtime) {
                    this.g = elapsedRealtime;
                    if (this.e == null || this.e.isDone()) {
                        this.e = com.startapp.networkTest.threads.a.a().c().scheduleWithFixedDelay(this.m, 0L, 1000L, TimeUnit.MILLISECONDS);
                    }
                }
            }
            this.i = state;
        }
    }

    @Override // com.startapp.networkTest.controller.a.a
    public final void a(CellLocation cellLocation, int i) {
        if (this.b.d().g().DefaultDataSimId == i && cellLocation != null) {
            int i2 = -1;
            if (cellLocation.getClass().equals(GsmCellLocation.class)) {
                i2 = ((GsmCellLocation) cellLocation).getCid();
            } else if (cellLocation.getClass().equals(CdmaCellLocation.class)) {
                i2 = ((CdmaCellLocation) cellLocation).getBaseStationId();
            }
            if (i2 == this.k || this.k == -1 || i2 <= 0 || i2 == Integer.MAX_VALUE) {
                if (i2 > 0 && i2 < Integer.MAX_VALUE) {
                    this.k = i2;
                    return;
                }
                return;
            }
            this.k = i2;
            this.j = SystemClock.elapsedRealtime();
            if (this.f != null && !this.f.isDone()) {
                return;
            }
            this.f = com.startapp.networkTest.threads.a.a().c().scheduleWithFixedDelay(this.n, 0L, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    static /* synthetic */ void a(CoverageMapperManager coverageMapperManager, LocationInfo locationInfo, TriggerEvents triggerEvents, boolean z) {
        NetworkInformationResult a;
        if (locationInfo == null) {
            a = coverageMapperManager.b.a(triggerEvents, z);
        } else {
            a = coverageMapperManager.b.a(locationInfo, triggerEvents, z);
        }
        if (coverageMapperManager.l == null) {
            return;
        }
        coverageMapperManager.l.onNetworkInfoResult(a);
    }
}
