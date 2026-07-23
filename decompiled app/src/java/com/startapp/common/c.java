package com.startapp.common;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c {
    private static volatile c a = null;
    private volatile PhoneStateListener b = null;
    private volatile String c = "e106";

    static /* synthetic */ void a(c cVar, Context context) {
        cVar.b = new PhoneStateListener() { // from class: com.startapp.common.c.2
            @Override // android.telephony.PhoneStateListener
            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        c.this.c = String.valueOf(signalStrength.getLevel());
                    } else {
                        try {
                            Method method = SignalStrength.class.getMethod("getLevel", new Class[0]);
                            c.this.c = String.valueOf(method.invoke(signalStrength, new Object[0]));
                        } catch (NoSuchMethodException e) {
                            c.this.c = "e104";
                        }
                    }
                } catch (Exception e2) {
                    c.this.c = "e105";
                }
            }
        };
        cVar.a(context, 256);
    }

    public final void a(Context context) {
        a(context, 0);
    }

    private void a(Context context, int i) {
        ((TelephonyManager) context.getSystemService("phone")).listen(this.b, i);
    }

    public static synchronized void b(final Context context) {
        synchronized (c.class) {
            if (a == null) {
                a = new c();
                new Thread(new Runnable() { // from class: com.startapp.common.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Looper.prepare();
                        try {
                            c.a(c.a(), context);
                        } catch (Throwable th) {
                            c.a().c = "e107";
                        }
                        Looper.loop();
                    }
                }).start();
            }
        }
    }

    public static c a() {
        return a;
    }

    public final String b() {
        return this.c;
    }
}
