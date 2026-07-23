package com.startapp.networkTest.threads;

import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private static final a a = new a();
    private final ScheduledThreadPoolExecutor b = new ScheduledThreadPoolExecutor(1);
    private final ExecutorService c = a(1, a.class.getSimpleName() + "-Single");
    private final ExecutorService d = a(4, a.class.getSimpleName() + "-Cached");

    private a() {
        this.b.setKeepAliveTime(60L, TimeUnit.SECONDS);
        if (Build.VERSION.SDK_INT >= 9) {
            this.b.allowCoreThreadTimeOut(true);
        }
    }

    public static a a() {
        return a;
    }

    public final ExecutorService b() {
        return this.d;
    }

    public final ScheduledExecutorService c() {
        return this.b;
    }

    public final ExecutorService d() {
        return this.c;
    }

    private static ExecutorService a(int i, final String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, i, 30L, TimeUnit.SECONDS, new LinkedTransferQueue<Runnable>() { // from class: com.startapp.networkTest.threads.ThreadManager$1
                @Override // java.util.concurrent.LinkedTransferQueue, java.util.Queue, java.util.concurrent.BlockingQueue
                public final /* synthetic */ boolean offer(Object obj) {
                    return tryTransfer((Runnable) obj);
                }
            }, new ThreadFactory() { // from class: com.startapp.networkTest.threads.a.1
                private AtomicInteger a = new AtomicInteger();

                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return new Thread(runnable, str + "-" + this.a.incrementAndGet());
                }
            }, new RejectedExecutionHandler() { // from class: com.startapp.networkTest.threads.a.2
                @Override // java.util.concurrent.RejectedExecutionHandler
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                    try {
                        threadPoolExecutor2.getQueue().put(runnable);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        } else if (i < 2) {
            return Executors.newSingleThreadExecutor();
        } else {
            return Executors.newCachedThreadPool();
        }
    }
}
