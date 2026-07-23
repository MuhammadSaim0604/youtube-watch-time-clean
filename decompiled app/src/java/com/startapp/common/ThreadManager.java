package com.startapp.common;

import android.os.Build;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class ThreadManager {
    private static final String a = com.startapp.common.b.b.a(ThreadManager.class);
    private static final int b;
    private static final int c;
    private static final ThreadFactory d;
    private static final ThreadFactory e;
    private static final RejectedExecutionHandler f;
    private static final Executor g;
    private static final Executor h;
    private static final ScheduledExecutorService i;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public enum Priority {
        DEFAULT,
        HIGH
    }

    static {
        b = Build.VERSION.SDK_INT < 22 ? 10 : 20;
        c = Build.VERSION.SDK_INT < 22 ? 4 : 8;
        d = new ThreadFactory() { // from class: com.startapp.common.ThreadManager.1
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "highPriorityThreadFactory #" + this.a.getAndIncrement());
            }
        };
        e = new ThreadFactory() { // from class: com.startapp.common.ThreadManager.2
            private final AtomicInteger a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "defaultPriorityThreadFactory #" + this.a.getAndIncrement());
            }
        };
        f = new RejectedExecutionHandler() { // from class: com.startapp.common.ThreadManager.3
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Log.e(ThreadManager.a, "ThreadPoolExecutor rejected execution! ".concat(String.valueOf(threadPoolExecutor)));
            }
        };
        int i2 = b;
        g = new ThreadPoolExecutor(i2, i2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d, f);
        int i3 = c;
        h = new ThreadPoolExecutor(i3, i3, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), e, f);
        i = new ScheduledThreadPoolExecutor(1);
    }

    public static ScheduledFuture<?> a(Runnable runnable, long j) {
        return i.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public static void a(Priority priority, Runnable runnable) {
        Executor executor = null;
        try {
            if (priority.equals(Priority.HIGH)) {
                executor = g;
            } else {
                executor = h;
            }
            executor.execute(runnable);
        } catch (Exception e2) {
            Log.e(a, "executeWithPriority failed to execute! ".concat(String.valueOf(executor)), e2);
        }
    }
}
