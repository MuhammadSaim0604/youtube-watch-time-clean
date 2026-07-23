package com.startapp.sdk.adsbase;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.startapp.common.jobrunner.interfaces.RunnerJob;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class InfoEventService extends Service {
    static {
        com.startapp.common.b.b.a(InfoEventService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, final int i2) {
        if (intent != null && intent.getIntExtra("__RUNNER_TASK_ID__", -1) == Integer.MAX_VALUE) {
            return 3;
        }
        com.startapp.common.jobrunner.a.a(this);
        "onHandleIntent: RunnerManager.runJob".concat(String.valueOf(com.startapp.common.jobrunner.a.a(intent, new RunnerJob.a() { // from class: com.startapp.sdk.adsbase.InfoEventService.1
            @Override // com.startapp.common.jobrunner.interfaces.RunnerJob.a
            public final void a(RunnerJob.Result result) {
                InfoEventService.this.stopSelf(i2);
            }
        })));
        com.startapp.common.jobrunner.a.c();
        return 3;
    }
}
