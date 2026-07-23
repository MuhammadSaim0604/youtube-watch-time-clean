package com.iab.omid.library.startapp.walking.a;

import com.iab.omid.library.startapp.walking.a.b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c implements b.a {
    private final ArrayDeque<b> c = new ArrayDeque<>();
    private b d = null;
    private final BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.a);

    private void b() {
        this.d = this.c.poll();
        if (this.d != null) {
            this.d.a(this.b);
        }
    }

    @Override // com.iab.omid.library.startapp.walking.a.b.a
    public final void a() {
        this.d = null;
        b();
    }

    public final void a(b bVar) {
        bVar.a(this);
        this.c.add(bVar);
        if (this.d == null) {
            b();
        }
    }
}
