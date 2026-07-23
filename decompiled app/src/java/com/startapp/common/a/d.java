package com.startapp.common.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class d {
    protected final Context a;
    protected final Object b = new Object();
    protected volatile a c;
    protected volatile Future<a> d;

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    public final Future<a> a() {
        synchronized (this.b) {
            Future<a> future = this.d;
            if (future != null) {
                return future;
            }
            final ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Future<a> submit = newSingleThreadExecutor.submit(new Callable<a>() { // from class: com.startapp.common.a.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public a call() {
                    a aVar;
                    Object invoke;
                    String str;
                    try {
                        invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, d.this.a);
                        str = (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Throwable th) {
                        try {
                            aVar = d.a(d.this.a);
                        } catch (Throwable th2) {
                            aVar = new a(th, th2);
                        }
                    }
                    if (str != null && str.length() > 0) {
                        aVar = new a(str, "APP", Boolean.TRUE.equals((Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0])));
                        synchronized (d.this.b) {
                            d.this.d = null;
                        }
                        newSingleThreadExecutor.shutdown();
                        a aVar2 = aVar;
                        d.this.c = aVar2;
                        return aVar2;
                    }
                    throw new Exception("Local advertising id not found");
                }
            });
            this.d = submit;
            return submit;
        }
    }

    public final a b() {
        a aVar = this.c;
        a aVar2 = aVar;
        if (aVar == null) {
            try {
                a aVar3 = a().get(1L, TimeUnit.SECONDS);
                aVar2 = aVar3;
                if (aVar3 == null) {
                    aVar2 = new a(new Exception("impossible null returned"));
                }
            } catch (TimeoutException e) {
                aVar2 = new a(new TimeoutException("Getting advertisingId took too much time."));
            } catch (Throwable th) {
                aVar2 = new a(th);
            }
        }
        return aVar2;
    }

    public static a a(Context context) throws Exception {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            b bVar = new b();
            if (context.bindService(intent, bVar, 1)) {
                c cVar = new c(bVar.a());
                a aVar = new a(cVar.a(), "DEVICE", cVar.b());
                com.startapp.common.b.b.a(context, bVar);
                return aVar;
            }
            throw new Exception("Google Play connection failed");
        } catch (Throwable th) {
            com.startapp.common.b.b.a(context, (ServiceConnection) null);
            throw th;
        }
    }
}
