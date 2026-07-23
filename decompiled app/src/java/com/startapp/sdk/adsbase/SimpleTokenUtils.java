package com.startapp.sdk.adsbase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Pair;
import com.startapp.common.Constants;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class SimpleTokenUtils {
    private static List<PackageInfo> a;
    private static List<PackageInfo> b;
    private static long c;
    private static volatile Pair<TokenType, String> d;
    private static volatile Pair<TokenType, String> e;
    private static boolean f;
    private static boolean g;
    private static TokenType h;

    static {
        SimpleTokenUtils.class.getSimpleName();
        d = null;
        e = null;
        f = true;
        g = false;
        h = TokenType.UNDEFINED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum TokenType {
        T1("token"),
        T2("token2"),
        UNDEFINED("");
        
        private final String text;

        TokenType(String str) {
            this.text = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.text;
        }
    }

    public static long a() {
        return c;
    }

    public static void a(final Context context) {
        c(context);
        f = true;
        g = false;
        h = TokenType.UNDEFINED;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        context.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: com.startapp.sdk.adsbase.SimpleTokenUtils.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                SimpleTokenUtils.b();
                SimpleTokenUtils.c(context2);
            }
        }, intentFilter);
        MetaData.E().a(new com.startapp.sdk.adsbase.remoteconfig.b() { // from class: com.startapp.sdk.adsbase.SimpleTokenUtils.2
            @Override // com.startapp.sdk.adsbase.remoteconfig.b
            public final void a(MetaDataRequest.RequestReason requestReason, boolean z) {
                if (z) {
                    SimpleTokenUtils.b();
                    SimpleTokenUtils.c(context);
                }
                MetaData.E().a(this);
            }

            @Override // com.startapp.sdk.adsbase.remoteconfig.b
            public final void a() {
                MetaData.E().a(this);
            }
        });
    }

    public static void b(Context context) {
        a(context, MetaData.E().e().a(context));
    }

    public static void c(final Context context) {
        try {
            if ((d == null || e == null) && MetaData.E().e().a(context)) {
                ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.sdk.adsbase.SimpleTokenUtils.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimpleTokenUtils.b(context);
                    }
                });
            }
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }

    private static synchronized void a(Context context, boolean z) {
        synchronized (SimpleTokenUtils.class) {
            if ((d == null || e == null) && z) {
                PackageManager packageManager = context.getPackageManager();
                Set<String> t = MetaData.E().t();
                Set<String> u = MetaData.E().u();
                a = new CopyOnWriteArrayList();
                b = new CopyOnWriteArrayList();
                try {
                    List<PackageInfo> a2 = com.startapp.common.b.b.a(packageManager);
                    c = System.currentTimeMillis();
                    PackageInfo packageInfo = null;
                    for (PackageInfo packageInfo2 : a2) {
                        if (!com.startapp.common.b.b.a(packageInfo2)) {
                            if (Build.VERSION.SDK_INT >= 9) {
                                long j = packageInfo2.firstInstallTime;
                                if (j < c && j >= 1291593600000L) {
                                    c = j;
                                }
                            }
                            a.add(packageInfo2);
                            try {
                                String installerPackageName = packageManager.getInstallerPackageName(packageInfo2.packageName);
                                if (t != null && t.contains(installerPackageName)) {
                                    b.add(packageInfo2);
                                }
                            } catch (Throwable th) {
                                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                            }
                        } else if (u.contains(packageInfo2.packageName)) {
                            a.add(packageInfo2);
                        } else if (packageInfo2.packageName.equals(Constants.a)) {
                            packageInfo = packageInfo2;
                        }
                    }
                    a = b(a);
                    b = b(b);
                    if (packageInfo != null) {
                        a.add(0, packageInfo);
                    }
                } catch (Throwable th2) {
                    new com.startapp.sdk.adsbase.infoevents.e(th2).a(context);
                }
                d = new Pair<>(TokenType.T1, com.iab.omid.library.startapp.b.a(a(a)));
                e = new Pair<>(TokenType.T2, com.iab.omid.library.startapp.b.a(a(b)));
            }
        }
    }

    public static void b() {
        d = null;
        e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<String, String> d(Context context) {
        return a(context, MetaData.E().e().a(context), MetaData.E().v(), MetaData.E().w());
    }

    private static synchronized Pair<String, String> a(Context context, boolean z, boolean z2, boolean z3) {
        Pair<String, String> pair;
        Pair<TokenType, String> f2;
        Pair<TokenType, String> e2;
        boolean z4;
        synchronized (SimpleTokenUtils.class) {
            Pair<TokenType, String> pair2 = new Pair<>(TokenType.T1, "");
            if (z) {
                if (h == TokenType.UNDEFINED) {
                    boolean z5 = f;
                    if (!g || f) {
                        e2 = e(context);
                    } else {
                        e2 = f(context);
                    }
                    Pair<TokenType, String> pair3 = e2;
                    if (z3) {
                        z4 = z5;
                    } else {
                        z4 = !g;
                    }
                    g = z4;
                    if (z2) {
                        pair2 = pair3;
                    } else if (!j.a(context, "shared_prefs_simple_token", "").equals(pair3.second)) {
                        pair2 = pair3;
                    }
                    pair = new Pair<>(((TokenType) pair2.first).toString(), pair2.second);
                } else {
                    if (h == TokenType.T1) {
                        f2 = e(context);
                    } else {
                        f2 = f(context);
                    }
                    pair2 = f2;
                }
            }
            pair = new Pair<>(((TokenType) pair2.first).toString(), pair2.second);
        }
        return pair;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Pair<String, String> pair) {
        h = TokenType.valueOf((String) pair.first);
    }

    public static Pair<String, String> c() {
        return d != null ? new Pair<>(((TokenType) d.first).toString(), d.second) : new Pair<>(TokenType.T1.toString(), "");
    }

    public static Pair<String, String> d() {
        return e != null ? new Pair<>(((TokenType) e.first).toString(), e.second) : new Pair<>(TokenType.T2.toString(), "");
    }

    private static Pair<TokenType, String> e(Context context) {
        if (d == null) {
            b(context);
        }
        j.b(context, "shared_prefs_simple_token", (String) d.second);
        f = false;
        h = TokenType.UNDEFINED;
        return new Pair<>(TokenType.T1, d.second);
    }

    private static Pair<TokenType, String> f(Context context) {
        if (e == null) {
            b(context);
        }
        j.b(context, "shared_prefs_simple_token2", (String) e.second);
        f = false;
        h = TokenType.UNDEFINED;
        return new Pair<>(TokenType.T2, e.second);
    }

    private static List<String> a(List<PackageInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (PackageInfo packageInfo : list) {
            arrayList.add(packageInfo.packageName);
        }
        return arrayList;
    }

    private static List<PackageInfo> b(List<PackageInfo> list) {
        if (list.size() > 100) {
            ArrayList arrayList = new ArrayList(list);
            c(arrayList);
            return arrayList.subList(0, 100);
        }
        return list;
    }

    private static void c(List<PackageInfo> list) {
        if (Build.VERSION.SDK_INT >= 9) {
            Collections.sort(list, new Comparator<PackageInfo>() { // from class: com.startapp.sdk.adsbase.SimpleTokenUtils.4
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(PackageInfo packageInfo, PackageInfo packageInfo2) {
                    long j = packageInfo.firstInstallTime;
                    long j2 = packageInfo2.firstInstallTime;
                    if (j > j2) {
                        return -1;
                    }
                    return j == j2 ? 0 : 1;
                }
            });
        }
    }
}
