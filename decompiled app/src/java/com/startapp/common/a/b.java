package com.startapp.common.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
class b implements ServiceConnection {
    private final LinkedBlockingQueue<IBinder> a = new LinkedBlockingQueue<>(1);
    private boolean b = false;

    static {
        b.class.getSimpleName();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.a.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    public final IBinder a() throws InterruptedException {
        if (this.b) {
            throw new IllegalStateException("Binder already retrieved");
        }
        IBinder take = this.a.take();
        if (take == null) {
            throw new IllegalStateException("Binder is null");
        }
        this.b = true;
        return take;
    }
}
