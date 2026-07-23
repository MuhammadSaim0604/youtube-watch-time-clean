package com.startapp.networkTest.startapp;

import com.startapp.networkTest.results.ConnectivityTestResult;
import com.startapp.networkTest.results.LatencyResult;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public interface ConnectivityTestListener {
    void onConnectivityTestFinished(Runnable runnable);

    void onConnectivityTestResult(ConnectivityTestResult connectivityTestResult);

    void onLatencyTestResult(LatencyResult latencyResult);
}
