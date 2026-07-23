package com.startapp.sdk.insight;

import android.content.Context;
import com.startapp.common.ThreadManager;
import com.startapp.networkTest.results.BaseResult;
import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;
import com.startapp.networkTest.results.NetworkInformationResult;
import com.startapp.networkTest.startapp.ConnectivityTestListener;
import com.startapp.networkTest.startapp.CoverageMapperManager;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j;
import com.startapp.sdk.adsbase.j.c;
import com.startapp.sdk.adsbase.j.r;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Executor;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class b implements ConnectivityTestListener, CoverageMapperManager.OnNetworkInfoResultListener {
    private static final Comparator<File> d;
    final Context a;
    final c b;
    final File c;
    private File e;

    static {
        b.class.getSimpleName();
        d = new Comparator<File>() { // from class: com.startapp.sdk.insight.b.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        };
    }

    public static b a(Context context) {
        j.b(context, "SuccessfulSentTimeKey", Long.valueOf(System.currentTimeMillis()));
        return new b(context.getApplicationContext(), new r(ThreadManager.Priority.DEFAULT), new File(context.getFilesDir(), "StartApp-Events"));
    }

    private b(Context context, Executor executor, File file) {
        this.a = context;
        this.b = new c(executor);
        this.c = new File(file, "saved");
        this.e = new File(file, "sending");
    }

    private static NetworkTestsMetaData a() {
        NetworkTestsMetaData c = MetaData.E().c();
        NetworkTestsMetaData networkTestsMetaData = c;
        if (c == null) {
            networkTestsMetaData = new NetworkTestsMetaData();
        }
        return networkTestsMetaData;
    }

    final boolean a(InfoEventCategory infoEventCategory, BaseResult baseResult, long j, Runnable runnable) {
        String str = null;
        try {
            str = u.b(baseResult);
        } catch (Throwable th) {
            new e(th).a(this.a);
        }
        if (str != null) {
            if (u.d(this.a)) {
                e eVar = new e(infoEventCategory);
                eVar.a(j);
                eVar.g(str);
                eVar.n(a(infoEventCategory));
                eVar.a(this.a, new AnonymousClass5(infoEventCategory, str, j, runnable));
                return false;
            }
            try {
                a(infoEventCategory, str, j);
            } catch (Throwable th2) {
                new e(th2).a(this.a);
            }
        }
        return true;
    }

    final void a(InfoEventCategory infoEventCategory, String str, long j) throws IOException {
        int r;
        if (!this.c.exists() && !this.c.mkdirs()) {
            throw new IOException();
        }
        PrintStream printStream = new PrintStream(new File(this.c, j + "-" + infoEventCategory.a()));
        printStream.print(str);
        printStream.close();
        File[] listFiles = this.c.listFiles();
        if (listFiles != null && listFiles.length > (r = a().r()) && r > 10) {
            Arrays.sort(listFiles, d);
            int length = listFiles.length;
            for (int min = Math.min(Math.max(10, a().q()), r); min < length; min++) {
                a(listFiles[min]);
            }
        }
    }

    final boolean a(final Runnable runnable) {
        e eVar = null;
        e eVar2 = null;
        File[] listFiles = this.c.listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles, d);
            long currentTimeMillis = System.currentTimeMillis() - a().m();
            for (File file : listFiles) {
                int indexOf = file.getName().indexOf("-");
                if (indexOf < 0) {
                    a(file);
                } else {
                    InfoEventCategory a = InfoEventCategory.a(file.getName().substring(indexOf + 1));
                    if (a == null) {
                        a(file);
                    } else {
                        try {
                            long parseLong = Long.parseLong(file.getName().substring(0, indexOf));
                            if (parseLong < currentTimeMillis) {
                                a(file);
                            } else {
                                File a2 = a(file, this.e);
                                if (a2 != null) {
                                    e eVar3 = new e(a);
                                    eVar3.a(parseLong);
                                    eVar3.a(a2);
                                    eVar3.n(a(a));
                                    if (eVar == null) {
                                        eVar = eVar3;
                                    }
                                    if (eVar2 != null) {
                                        eVar2.a(eVar3);
                                    }
                                    eVar2 = eVar3;
                                } else {
                                    a(file);
                                }
                            }
                        } catch (NumberFormatException e) {
                            a(file);
                        }
                    }
                }
            }
        }
        if (eVar == null) {
            return true;
        }
        eVar.a(this.a, new com.startapp.sdk.adsbase.infoevents.c() { // from class: com.startapp.sdk.insight.b.6
            @Override // com.startapp.sdk.adsbase.infoevents.c
            public final void a(e eVar4, final boolean z) {
                final File i = eVar4.i();
                if (i != null) {
                    b.this.b.a(new com.startapp.sdk.adsbase.j.b() { // from class: com.startapp.sdk.insight.b.6.1
                        @Override // com.startapp.sdk.adsbase.j.b
                        public final void a(Runnable runnable2) {
                            try {
                                if (!z) {
                                    if (b.a(i, b.this.c) == null) {
                                        b.a(i);
                                    }
                                } else {
                                    b.a(i);
                                }
                            } finally {
                                runnable2.run();
                            }
                        }
                    });
                }
            }

            @Override // com.startapp.sdk.adsbase.infoevents.c
            public final void a() {
                runnable.run();
            }
        });
        return false;
    }

    private static String a(InfoEventCategory infoEventCategory) {
        switch (infoEventCategory) {
            case INSIGHT_CORE_CT:
                return a().n();
            case INSIGHT_CORE_LT:
                return a().o();
            case INSIGHT_CORE_NIR:
                return a().p();
            default:
                return null;
        }
    }

    static void a(File file) {
        if (!file.delete()) {
            file.deleteOnExit();
        }
    }

    private void a(final InfoEventCategory infoEventCategory, final BaseResult baseResult, final long j) {
        this.b.a(new com.startapp.sdk.adsbase.j.b() { // from class: com.startapp.sdk.insight.b.2
            @Override // com.startapp.sdk.adsbase.j.b
            public final void a(Runnable runnable) {
                try {
                    if (b.this.a(infoEventCategory, baseResult, j, runnable)) {
                    }
                } finally {
                    runnable.run();
                }
            }
        });
    }

    @Override // com.startapp.networkTest.startapp.ConnectivityTestListener
    public void onConnectivityTestResult(ConnectivityTestResult connectivityTestResult) {
        if (connectivityTestResult != null) {
            a(InfoEventCategory.INSIGHT_CORE_CT, connectivityTestResult, System.currentTimeMillis());
        }
    }

    @Override // com.startapp.networkTest.startapp.ConnectivityTestListener
    public void onLatencyTestResult(LatencyResult latencyResult) {
        if (latencyResult != null) {
            a(InfoEventCategory.INSIGHT_CORE_LT, latencyResult, System.currentTimeMillis());
        }
    }

    @Override // com.startapp.networkTest.startapp.CoverageMapperManager.OnNetworkInfoResultListener
    public void onNetworkInfoResult(NetworkInformationResult networkInformationResult) {
        if (networkInformationResult != null) {
            a(InfoEventCategory.INSIGHT_CORE_NIR, networkInformationResult, System.currentTimeMillis());
        }
    }

    @Override // com.startapp.networkTest.startapp.ConnectivityTestListener
    public void onConnectivityTestFinished(final Runnable runnable) {
        this.b.a(new com.startapp.sdk.adsbase.j.b() { // from class: com.startapp.sdk.insight.b.3
            @Override // com.startapp.sdk.adsbase.j.b
            public final void a(Runnable runnable2) {
                boolean z = true;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = currentTimeMillis - j.a(b.this.a, "SuccessfulSentTimeKey", Long.valueOf(currentTimeMillis)).longValue();
                    if (u.d(b.this.a) || longValue > MetaData.E().c().k()) {
                        j.b(b.this.a, "SuccessfulSentTimeKey", Long.valueOf(System.currentTimeMillis()));
                        z = b.this.a(runnable2);
                    }
                    if (z) {
                    }
                } finally {
                    runnable2.run();
                }
            }
        });
        if (runnable != null) {
            this.b.a(new com.startapp.sdk.adsbase.j.b() { // from class: com.startapp.sdk.insight.b.4
                @Override // com.startapp.sdk.adsbase.j.b
                public final void a(Runnable runnable2) {
                    try {
                        runnable.run();
                    } finally {
                        runnable2.run();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.insight.b$5  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
    public final class AnonymousClass5 implements com.startapp.sdk.adsbase.infoevents.c, com.startapp.sdk.adsbase.j.b {
        private /* synthetic */ InfoEventCategory a;
        private /* synthetic */ String b;
        private /* synthetic */ long c;
        private /* synthetic */ Runnable d;

        AnonymousClass5(InfoEventCategory infoEventCategory, String str, long j, Runnable runnable) {
            this.a = infoEventCategory;
            this.b = str;
            this.c = j;
            this.d = runnable;
        }

        @Override // com.startapp.sdk.adsbase.infoevents.c
        public final void a(e eVar, boolean z) {
            if (!z) {
                b.this.b.a(this);
            }
        }

        @Override // com.startapp.sdk.adsbase.infoevents.c
        public final void a() {
            this.d.run();
        }

        @Override // com.startapp.sdk.adsbase.j.b
        public final void a(Runnable runnable) {
            try {
                b.this.a(this.a, this.b, this.c);
            } catch (Throwable th) {
                try {
                    new e(th).a(b.this.a);
                } finally {
                    runnable.run();
                }
            }
        }
    }

    static File a(File file, File file2) {
        if (!file2.exists() && !file2.mkdirs()) {
            return null;
        }
        File file3 = new File(file2, file.getName());
        if (file.renameTo(file3)) {
            return file3;
        }
        return null;
    }
}
