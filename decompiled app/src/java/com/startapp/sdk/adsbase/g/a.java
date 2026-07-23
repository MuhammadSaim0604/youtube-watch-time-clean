package com.startapp.sdk.adsbase.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.finsky.externalreferrer.a;
import com.startapp.common.parser.d;
import com.startapp.networkTest.enums.bluetooth.BluetoothConnectionState;
import com.startapp.sdk.adsbase.infoevents.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private static CountDownLatch b;
    private static volatile b c;
    private BluetoothConnectionState d = BluetoothConnectionState.Unknown;
    private BluetoothConnectionState e = BluetoothConnectionState.Unknown;
    private BluetoothConnectionState f = BluetoothConnectionState.Unknown;
    public boolean a = false;
    @d(b = ArrayList.class, c = com.startapp.networkTest.data.d.class)
    private ArrayList<com.startapp.networkTest.data.d> g = new ArrayList<>();
    @d(b = ArrayList.class, c = com.startapp.networkTest.data.d.class)
    private ArrayList<com.startapp.networkTest.data.d> h = new ArrayList<>();
    @d(b = ArrayList.class, c = com.startapp.networkTest.data.d.class)
    private ArrayList<com.startapp.networkTest.data.d> i = new ArrayList<>();
    @d(b = ArrayList.class, c = com.startapp.networkTest.data.d.class)
    private ArrayList<com.startapp.networkTest.data.d> j = new ArrayList<>();

    public static b a(Context context) {
        if (c == null) {
            try {
                b = new CountDownLatch(1);
                ServiceConnectionC0040a serviceConnectionC0040a = new ServiceConnectionC0040a(context.getPackageName(), (byte) 0);
                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                    ResolveInfo resolveInfo = queryIntentServices.get(0);
                    if (resolveInfo.serviceInfo != null) {
                        String str = resolveInfo.serviceInfo.packageName;
                        String str2 = resolveInfo.serviceInfo.name;
                        if ("com.android.vending".equals(str) && str2 != null && b(context)) {
                            if (context.bindService(new Intent(intent), serviceConnectionC0040a, 1)) {
                                try {
                                    b.await(1L, TimeUnit.SECONDS);
                                } catch (InterruptedException e) {
                                }
                                context.unbindService(serviceConnectionC0040a);
                            } else {
                                throw new Exception("failed to connect to referrer service");
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                new e(th).a(context);
            }
        }
        return c;
    }

    private static boolean b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.g.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    static final class ServiceConnectionC0040a implements ServiceConnection {
        private String a;

        /* synthetic */ ServiceConnectionC0040a(String str, byte b) {
            this(str);
        }

        private ServiceConnectionC0040a(String str) {
            this.a = str;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.google.android.finsky.externalreferrer.a a = a.a.a(iBinder);
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.a);
            try {
                b unused = a.c = new b(a.a(bundle));
            } catch (RemoteException e) {
            }
            a.b.countDown();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            a.b.countDown();
        }
    }
}
