package com.startapp.sdk.adsbase.j;

import android.os.Build;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class c {
    private final Queue<Runnable> a;
    private final Executor b;
    private Runnable c;

    static {
        c.class.getSimpleName();
    }

    public c(Executor executor) {
        if (Build.VERSION.SDK_INT >= 9) {
            this.a = new ArrayDeque();
        } else {
            this.a = new LinkedList();
        }
        this.b = executor;
    }

    public final synchronized void a(final b bVar) {
        this.a.offer(new Runnable() { // from class: com.startapp.sdk.adsbase.j.c.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVar2 = bVar;
                final c cVar = c.this;
                bVar2.a(new Runnable() { // from class: com.startapp.sdk.adsbase.j.c.2
                    private boolean a;

                    @Override // java.lang.Runnable
                    public final void run() {
                        synchronized (this) {
                            if (!this.a) {
                                this.a = true;
                                c.this.a();
                            }
                        }
                    }
                });
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
