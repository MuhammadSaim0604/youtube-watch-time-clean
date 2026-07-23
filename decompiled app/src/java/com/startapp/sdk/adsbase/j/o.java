package com.startapp.sdk.adsbase.j;

import android.os.Build;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class o implements Executor {
    private final Queue<Runnable> a;
    private final Executor b;
    private Runnable c;

    public o(Executor executor) {
        if (Build.VERSION.SDK_INT >= 9) {
            this.a = new ArrayDeque();
        } else {
            this.a = new LinkedList();
        }
        this.b = executor;
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(final Runnable runnable) {
        this.a.offer(new Runnable() { // from class: com.startapp.sdk.adsbase.j.o.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    o.this.a();
                }
            }
        });
        if (this.c == null) {
            a();
        }
    }

    protected final synchronized void a() {
        Runnable poll = this.a.poll();
        this.c = poll;
        if (poll != null) {
            this.b.execute(this.c);
        }
    }
}
