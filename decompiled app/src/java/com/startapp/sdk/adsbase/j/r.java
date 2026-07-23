package com.startapp.sdk.adsbase.j;

import com.startapp.common.ThreadManager;
import java.util.concurrent.Executor;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class r implements Executor {
    private final ThreadManager.Priority a;

    public r(ThreadManager.Priority priority) {
        this.a = priority;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ThreadManager.a(this.a, runnable);
    }
}
