package com.startapp.sdk.adsbase;

import android.app.Activity;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class ActivityExtra implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean isActivityFullScreen;

    public ActivityExtra(Activity activity) {
        this.isActivityFullScreen = a.a(activity);
    }

    public final boolean a() {
        return this.isActivityFullScreen;
    }
}
