package com.startapp.common;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.startapp.common.ThreadManager;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    String a;
    InterfaceC0015a b;
    int c;

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.common.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public interface InterfaceC0015a {
        void a(Bitmap bitmap, int i);
    }

    public a(String str, InterfaceC0015a interfaceC0015a, int i) {
        this.a = str;
        this.b = interfaceC0015a;
        this.c = i;
    }

    public final void a() {
        ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.common.a.1
            @Override // java.lang.Runnable
            public final void run() {
                final Bitmap b = com.startapp.common.b.c.b(a.this.a);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.common.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.b != null) {
                            a.this.b.a(b, a.this.c);
                        }
                    }
                });
            }
        });
    }
}
