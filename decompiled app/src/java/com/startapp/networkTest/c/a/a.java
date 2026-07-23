package com.startapp.networkTest.c.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructPollfd;
import android.util.Log;
import android.util.SparseArray;
import java.io.FileDescriptor;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: StartAppSDK */
@TargetApi(21)
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private static final String a = a.class.getSimpleName();
    private static final short b;
    private InetAddress c;
    private c d;
    private int e;
    private int f;
    private int g;
    private b h;
    private short i = 1;
    private short j = 30583;
    private boolean k = false;
    private boolean l = false;
    private int m;
    private int n;
    private int o;
    private long p;
    private SparseArray<Long> q;

    static /* synthetic */ byte[] a(byte[] bArr) {
        return Arrays.copyOfRange(bArr, 8, bArr.length);
    }

    static /* synthetic */ int j(a aVar) {
        int i = aVar.o;
        aVar.o = i + 1;
        return i;
    }

    static {
        b = (short) (OsConstants.POLLIN == 0 ? 1 : OsConstants.POLLIN);
    }

    public a(InetAddress inetAddress, int i, int i2, int i3, int i4) {
        byte b2;
        this.c = inetAddress;
        this.e = i3;
        this.g = i;
        this.f = i2;
        if (inetAddress instanceof Inet6Address) {
            b2 = Byte.MIN_VALUE;
        } else {
            b2 = 8;
        }
        this.h = new b(b2);
        this.m = i4;
        this.n = i4 + 8;
        this.q = new SparseArray<>();
    }

    public final void a(c cVar) {
        this.d = cVar;
    }

    @TargetApi(21)
    public final void a() {
        int i;
        int i2;
        this.k = false;
        if (this.c instanceof Inet6Address) {
            i = OsConstants.AF_INET6;
            i2 = OsConstants.IPPROTO_ICMPV6;
        } else {
            i = OsConstants.AF_INET;
            i2 = OsConstants.IPPROTO_ICMP;
        }
        this.p = SystemClock.elapsedRealtime();
        try {
            FileDescriptor socket = Os.socket(i, OsConstants.SOCK_DGRAM, i2);
            if (socket.valid()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    Os.setsockoptInt(socket, OsConstants.IPPROTO_IP, OsConstants.IP_TOS, 16);
                } else {
                    try {
                        Os.class.getMethod("setsockoptInt", FileDescriptor.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, socket, Integer.valueOf(OsConstants.IPPROTO_IP), Integer.valueOf(OsConstants.IP_TOS), 16);
                    } catch (Exception e) {
                        Log.e(a, "setLowDelay: setsockoptInt", e);
                    }
                }
                StructPollfd structPollfd = new StructPollfd();
                structPollfd.fd = socket;
                structPollfd.events = b;
                C0019a c0019a = new C0019a(new StructPollfd[]{structPollfd});
                this.l = true;
                this.p = SystemClock.elapsedRealtime();
                c0019a.start();
                for (int i3 = 0; i3 < this.g && !this.k; i3++) {
                    byte[] a2 = b.a(this.m);
                    b bVar = this.h;
                    short s = this.i;
                    this.i = (short) (s + 1);
                    ByteBuffer a3 = bVar.a(s, this.j, a2);
                    try {
                        this.q.put(Arrays.hashCode(a2), Long.valueOf(SystemClock.elapsedRealtime()));
                        if (Os.sendto(socket, a3, 0, this.c, 7) < 0) {
                            break;
                        }
                    } catch (Exception e2) {
                        this.d.a(SystemClock.elapsedRealtime() - this.p, -1L);
                        this.o++;
                    }
                    if (i3 < this.g - 1) {
                        try {
                            Thread.sleep(this.f);
                        } catch (Exception e3) {
                            new StringBuilder("Pause: ").append(e3.toString());
                        }
                    }
                }
                this.l = false;
                if (c0019a.isAlive()) {
                    c0019a.join();
                }
                Os.close(socket);
                this.l = false;
            }
            if (!this.k) {
                for (int i4 = this.o; i4 < this.g; i4++) {
                    this.d.a(SystemClock.elapsedRealtime() - this.p, -1L);
                }
            }
        } catch (Exception e4) {
            new StringBuilder("start: Os.socket: ").append(e4.toString());
        }
    }

    public final void b() {
        this.k = true;
    }

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.networkTest.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    class C0019a extends Thread {
        private StructPollfd[] a;

        C0019a(StructPollfd[] structPollfdArr) {
            this.a = structPollfdArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int poll;
            StructPollfd structPollfd = this.a[0];
            FileDescriptor fileDescriptor = structPollfd.fd;
            byte[] bArr = new byte[a.this.n];
            while (a.this.l && !a.this.k && a.this.o < a.this.g) {
                try {
                    poll = Os.poll(this.a, a.this.e);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!a.this.k) {
                    if (poll >= 0 && structPollfd.revents == a.b) {
                        structPollfd.revents = (short) 0;
                        Os.recvfrom(fileDescriptor, bArr, 0, bArr.length, 64, null);
                        int hashCode = Arrays.hashCode(a.a(bArr));
                        Long l = (Long) a.this.q.get(hashCode);
                        if (l != null) {
                            a.this.q.remove(hashCode);
                            long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
                            a.this.d.a(SystemClock.elapsedRealtime() - a.this.p, elapsedRealtime);
                            a.j(a.this);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }
}
