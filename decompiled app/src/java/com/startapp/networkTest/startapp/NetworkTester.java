package com.startapp.networkTest.startapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.startapp.common.b.b;
import com.startapp.common.jobrunner.RunnerRequest;
import com.startapp.common.jobrunner.interfaces.RunnerJob;
import com.startapp.networkTest.c;
import com.startapp.networkTest.d.a.e;
import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;
import com.startapp.networkTest.startapp.CoverageMapperManager;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class NetworkTester {
    private static final String CTLT_CHECK_INTERVAL_KEY = "StartappCtLtCheckIntervalKey";
    private static final String CTLT_GUARD_DIFF_KEY = "StartappGuardDiffKey";
    private static final int CTLT_JOB_ID = 1156916329;
    private static final String CTLT_PREV_TIME_CHECK_KEY = "StartappCtLtPrevTimeCheckKey";
    private static final String P3WRAPPER_PREFS = "StartappP3WrapperPrefs";
    static final String TAG = b.a(NetworkTester.class);
    static NetworkTester sInstance;
    Thread mActiveThread;
    ConnectivityTestListener mConnectivityTestListener;
    private Context mContext;
    CoverageMapperManager mCoverageMapper;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public static final class Config {
        public String PROJECT_ID = "20050";
        public String CONNECTIVITY_TEST_HOSTNAME = "d2to8y50b3n6dq.cloudfront.net";
        public String CONNECTIVITY_TEST_FILENAME = "/favicon.ico";
        public boolean CONNECTIVITY_TEST_ENABLED = true;
        public boolean NIR_COLLECT_CELLINFO = true;
        public boolean CT_COLLECT_CELLINFO = true;
        public int NIR_COLLECT_CELLINFO_THRESHOLD = 2;
        public String CONNECTIVITY_TEST_CDNCONFIG_URL = "https://d2to8y50b3n6dq.cloudfront.net/truststores/[PROJECTID]/cdnconfig.zip";
        public String GEOIP_URL = "https://geoip.api.c0nnectthed0ts.com/geoip/";
    }

    private NetworkTester() {
    }

    public static void init(Context context, Config config) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        if (config == null) {
            throw new IllegalArgumentException("config is null");
        }
        String b = com.iab.omid.library.startapp.b.b(config);
        if (b == null) {
            throw new IllegalArgumentException("Wrong format of config");
        }
        if (sInstance == null) {
            com.startapp.common.jobrunner.a.a(context).a();
            com.startapp.common.jobrunner.a.a(new a((byte) 0));
            NetworkTester networkTester = new NetworkTester();
            sInstance = networkTester;
            networkTester.mContext = context;
            c.a(context, b.getBytes());
            sInstance.mCoverageMapper = new CoverageMapperManager(context);
        }
    }

    public static void setOnConnectivityLatencyListener(ConnectivityTestListener connectivityTestListener) {
        sInstance.mConnectivityTestListener = connectivityTestListener;
    }

    public static void setOnNetworkInfoListener(CoverageMapperManager.OnNetworkInfoResultListener onNetworkInfoResultListener) {
        sInstance.mCoverageMapper.a(onNetworkInfoResultListener);
    }

    public static void startListening(long j, long j2) {
        SharedPreferences sharedPreferences = sInstance.mContext.getSharedPreferences(P3WRAPPER_PREFS, 0);
        sharedPreferences.edit().putLong(CTLT_CHECK_INTERVAL_KEY, j).commit();
        sharedPreferences.edit().putLong(CTLT_GUARD_DIFF_KEY, j2).commit();
        com.startapp.common.jobrunner.a.a(new RunnerRequest.a(CTLT_JOB_ID).a(j).a().a(true).b());
        sInstance.mCoverageMapper.a();
    }

    public static void stopListening() {
        com.startapp.common.jobrunner.a.a((int) CTLT_JOB_ID, true);
        if (sInstance != null && sInstance.mCoverageMapper != null) {
            sInstance.mCoverageMapper.b();
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    static final class a implements com.startapp.common.jobrunner.interfaces.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.startapp.common.jobrunner.interfaces.a
        public final RunnerJob a(int i) {
            if (i == NetworkTester.CTLT_JOB_ID) {
                return new RunnerJob() { // from class: com.startapp.networkTest.startapp.NetworkTester.a.1
                    @Override // com.startapp.common.jobrunner.interfaces.RunnerJob
                    public final void a(Context context, RunnerJob.a aVar) {
                        if (NetworkTester.sInstance == null) {
                            aVar.a(RunnerJob.Result.SUCCESS);
                        } else if (!b.a(context, "android.permission.ACCESS_FINE_LOCATION") && !b.a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                            NetworkTester.sInstance.mCoverageMapper.b();
                            aVar.a(RunnerJob.Result.SUCCESS);
                        } else {
                            SharedPreferences sharedPreferences = context.getSharedPreferences(NetworkTester.P3WRAPPER_PREFS, 0);
                            long j = sharedPreferences.getLong(NetworkTester.CTLT_GUARD_DIFF_KEY, 120000L);
                            if (System.currentTimeMillis() - sharedPreferences.getLong(NetworkTester.CTLT_PREV_TIME_CHECK_KEY, 0L) < sharedPreferences.getLong(NetworkTester.CTLT_CHECK_INTERVAL_KEY, j) - j) {
                                aVar.a(RunnerJob.Result.SUCCESS);
                            } else if (!c.a()) {
                                aVar.a(RunnerJob.Result.FAILED);
                            } else if (NetworkTester.sInstance.mActiveThread != null) {
                                aVar.a(RunnerJob.Result.FAILED);
                            } else {
                                sharedPreferences.edit().putLong(NetworkTester.CTLT_PREV_TIME_CHECK_KEY, System.currentTimeMillis()).commit();
                                NetworkTester.sInstance.mCoverageMapper.a();
                                NetworkTester.sInstance.mActiveThread = new Thread(new RunnableC00231(context, aVar));
                                NetworkTester.sInstance.mActiveThread.start();
                            }
                        }
                    }

                    /* compiled from: StartAppSDK */
                    /* renamed from: com.startapp.networkTest.startapp.NetworkTester$a$1$1  reason: invalid class name and collision with other inner class name */
                    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
                    final class RunnableC00231 implements Runnable {
                        final /* synthetic */ RunnerJob.a a;
                        private /* synthetic */ Context b;

                        RunnableC00231(Context context, RunnerJob.a aVar) {
                            this.b = context;
                            this.a = aVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            final boolean[] zArr = new boolean[2];
                            Looper.prepare();
                            final Looper myLooper = Looper.myLooper();
                            final com.startapp.networkTest.d.a.b bVar = new com.startapp.networkTest.d.a.b(this.b.getApplicationContext());
                            bVar.a();
                            bVar.a(new e() { // from class: com.startapp.networkTest.startapp.NetworkTester.a.1.1.1
                                @Override // com.startapp.networkTest.d.a.e
                                public final void a(ConnectivityTestResult connectivityTestResult) {
                                    if (zArr[0]) {
                                        if (myLooper != null) {
                                            NetworkTester.sInstance.mActiveThread = null;
                                            myLooper.quit();
                                            RunnableC00231.this.a.a(RunnerJob.Result.SUCCESS);
                                            return;
                                        }
                                        return;
                                    }
                                    zArr[0] = true;
                                    if (NetworkTester.sInstance.mConnectivityTestListener != null) {
                                        NetworkTester.sInstance.mConnectivityTestListener.onConnectivityTestResult(connectivityTestResult);
                                    }
                                }

                                @Override // com.startapp.networkTest.d.a.e
                                public final void a(LatencyResult latencyResult) {
                                    if (zArr[1]) {
                                        if (myLooper != null) {
                                            NetworkTester.sInstance.mActiveThread = null;
                                            myLooper.quit();
                                            RunnableC00231.this.a.a(RunnerJob.Result.SUCCESS);
                                            return;
                                        }
                                        return;
                                    }
                                    zArr[1] = true;
                                    if (NetworkTester.sInstance.mConnectivityTestListener != null) {
                                        NetworkTester.sInstance.mConnectivityTestListener.onLatencyTestResult(latencyResult);
                                    }
                                }

                                @Override // com.startapp.networkTest.d.a.e
                                public final void a() {
                                    bVar.b();
                                    if (myLooper != null) {
                                        NetworkTester.sInstance.mActiveThread = null;
                                        myLooper.quit();
                                    }
                                    if (NetworkTester.sInstance.mConnectivityTestListener != null) {
                                        NetworkTester.sInstance.mConnectivityTestListener.onConnectivityTestFinished(new Runnable() { // from class: com.startapp.networkTest.startapp.NetworkTester.a.1.1.1.1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                RunnableC00231.this.a.a(RunnerJob.Result.SUCCESS);
                                            }
                                        });
                                    } else {
                                        RunnableC00231.this.a.a(RunnerJob.Result.SUCCESS);
                                    }
                                }
                            });
                            Looper.loop();
                        }
                    }
                };
            }
            return null;
        }
    }
}
