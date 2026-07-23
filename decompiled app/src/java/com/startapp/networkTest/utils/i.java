package com.startapp.networkTest.utils;

import android.net.TrafficStats;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class i {
    private static final String a = i.class.getSimpleName();
    private static String[] b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        try {
            Method declaredMethod = TrafficStats.class.getDeclaredMethod("getRxBytes", String.class);
            c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            Method declaredMethod2 = TrafficStats.class.getDeclaredMethod("getTxBytes", String.class);
            d = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            Method declaredMethod3 = TrafficStats.class.getDeclaredMethod("getMobileIfaces", new Class[0]);
            e = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    public static synchronized long a() {
        String[] strArr;
        long j;
        synchronized (i.class) {
            long j2 = 0;
            try {
                j2 = TrafficStats.getMobileTxBytes();
            } catch (Exception e2) {
                Log.e(a, "getMobileTxBytes: " + e2.getMessage());
            }
            if (j2 > 0) {
                if (b == null) {
                    c();
                }
            } else if (b != null) {
                int length = b.length;
                for (int i = 0; i < length; i++) {
                    long c2 = c("/sys/class/net/" + strArr[i] + "/statistics/tx_bytes");
                    if (c2 > -1) {
                        j2 += c2;
                    }
                }
            }
            j = j2;
        }
        return j;
    }

    public static synchronized long b() {
        String[] strArr;
        long j;
        synchronized (i.class) {
            long j2 = 0;
            try {
                j2 = TrafficStats.getMobileRxBytes();
            } catch (Exception e2) {
                Log.e(a, "getMobileRxBytes: " + e2.getMessage());
            }
            if (j2 > 0) {
                if (b == null) {
                    c();
                }
            } else if (b != null) {
                int length = b.length;
                for (int i = 0; i < length; i++) {
                    long c2 = c("/sys/class/net/" + strArr[i] + "/statistics/rx_bytes");
                    if (c2 > -1) {
                        j2 += c2;
                    }
                }
            }
            j = j2;
        }
        return j;
    }

    private static long c(String str) {
        String[] a2 = g.a(str);
        if (a2.length > 0) {
            return Long.parseLong(a2[0]);
        }
        return -1L;
    }

    private static void c() {
        if (e != null) {
            try {
                String[] strArr = (String[]) e.invoke(null, new Object[0]);
                if (strArr != null) {
                    b = strArr;
                }
            } catch (Exception e2) {
                Log.e(a, "getMobileInterfaces: " + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public static long a(String str) {
        if (d != null) {
            try {
                return ((Long) d.invoke(null, str)).longValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return c("/sys/class/net/" + str + "/statistics/tx_bytes");
    }

    public static long b(String str) {
        if (c != null) {
            try {
                return ((Long) c.invoke(null, str)).longValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return c("/sys/class/net/" + str + "/statistics/rx_bytes");
    }
}
