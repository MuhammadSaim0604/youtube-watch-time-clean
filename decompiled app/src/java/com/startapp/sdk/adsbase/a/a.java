package com.startapp.sdk.adsbase.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private final b a;
    private int b;
    private boolean c;
    private boolean d;

    static {
        a.class.getSimpleName();
    }

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            this.b++;
            if (this.b == 1 && !this.c) {
                if (!this.d) {
                    this.d = true;
                    this.a.b();
                }
                this.a.c();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity != null) {
            this.b--;
            this.c = activity.isChangingConfigurations();
            if (this.b == 0 && !this.c) {
                this.a.d();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }
}
