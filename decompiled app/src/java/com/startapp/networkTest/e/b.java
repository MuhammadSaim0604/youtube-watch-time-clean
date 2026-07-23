package com.startapp.networkTest.e;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import com.startapp.networkTest.c;
import com.startapp.networkTest.data.TimeInfo;
import com.startapp.networkTest.enums.TimeSources;
import com.startapp.sdk.f.a.f;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class b {
    private static final String a = b.class.getSimpleName();
    private long e;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private long f = -1;
    private long g = -1;
    private long h = -1;
    private long i = -1;
    private com.startapp.networkTest.e.a j = new com.startapp.networkTest.e.a();

    static /* synthetic */ boolean c(b bVar) {
        bVar.c = true;
        return true;
    }

    public b() {
        if (c.d().w()) {
            d();
        }
    }

    private void d() {
        if (Build.VERSION.SDK_INT < 11) {
            new a().execute(new Void[0]);
        } else {
            new a().executeOnExecutor(com.startapp.networkTest.threads.a.a().b(), new Void[0]);
        }
    }

    private void e() {
        if (c.d().w() && !this.b && SystemClock.elapsedRealtime() - this.e > 30000) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
            return a();
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Void r5) {
            b.this.b = false;
        }

        @Override // android.os.AsyncTask
        protected final void onPreExecute() {
            b.this.b = true;
        }

        private Void a() {
            try {
                String unused = b.a;
                if (b.this.j.a("0.de.pool.ntp.org")) {
                    long a = b.this.j.a();
                    if (a > 1458564533202L && a < 3468524400000L) {
                        b.this.f = SystemClock.elapsedRealtime();
                        b.this.g = a;
                        String unused2 = b.a;
                        new StringBuilder("Time: ").append(new Date(b.this.g).toString());
                        b.c(b.this);
                    }
                } else {
                    String unused3 = b.a;
                    b.this.e = SystemClock.elapsedRealtime();
                }
            } catch (Exception e) {
            }
            return null;
        }
    }

    public static TimeInfo a() {
        long currentTimeMillis;
        b b = c.b();
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.IsSynced = b.c || b.d;
        if (b.d && b.h > b.f) {
            currentTimeMillis = b.i + (SystemClock.elapsedRealtime() - b.h);
            timeInfo.DeviceDriftMillis = System.currentTimeMillis() - currentTimeMillis;
            timeInfo.MillisSinceLastSync = currentTimeMillis - b.i;
            timeInfo.TimeSource = TimeSources.GPS;
            if (SystemClock.elapsedRealtime() - b.f > 28800000) {
                b.e();
            }
        } else if (b.c) {
            if (SystemClock.elapsedRealtime() - b.f > 28800000) {
                b.e();
            }
            currentTimeMillis = b.g + (SystemClock.elapsedRealtime() - b.f);
            timeInfo.DeviceDriftMillis = System.currentTimeMillis() - currentTimeMillis;
            timeInfo.MillisSinceLastSync = currentTimeMillis - b.g;
            timeInfo.TimeSource = TimeSources.NTP;
        } else {
            b.e();
            currentTimeMillis = System.currentTimeMillis();
            timeInfo.TimeSource = TimeSources.Device;
        }
        long j = currentTimeMillis;
        timeInfo.TimestampTableau = com.iab.omid.library.startapp.b.a(j);
        timeInfo.TimestampDateTime = com.iab.omid.library.startapp.b.b(j);
        timeInfo.TimestampOffset = ((TimeZone.getDefault().getOffset(j) / 1000.0f) / 60.0f) / 60.0f;
        timeInfo.TimestampMillis = j;
        f c = com.iab.omid.library.startapp.b.c(j);
        timeInfo.year = c.a;
        timeInfo.month = c.b;
        timeInfo.day = c.c;
        timeInfo.hour = c.d;
        timeInfo.minute = c.e;
        timeInfo.second = c.f;
        timeInfo.millisecond = c.g;
        return timeInfo;
    }

    public static long b() {
        b b = c.b();
        if (b.d && b.h > b.f) {
            if (SystemClock.elapsedRealtime() - b.f > 28800000) {
                b.e();
            }
            return b.i + (SystemClock.elapsedRealtime() - b.h);
        } else if (b.c) {
            if (SystemClock.elapsedRealtime() - b.f > 28800000) {
                b.e();
            }
            return b.g + (SystemClock.elapsedRealtime() - b.f);
        } else {
            b.e();
            return System.currentTimeMillis();
        }
    }

    public final void a(Location location) {
        this.i = location.getTime();
        this.h = SystemClock.elapsedRealtime();
        this.d = true;
    }
}
