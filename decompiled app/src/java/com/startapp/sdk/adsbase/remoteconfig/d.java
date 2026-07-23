package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import com.startapp.common.jobrunner.interfaces.RunnerJob;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class d implements RunnerJob {
    @Override // com.startapp.common.jobrunner.interfaces.RunnerJob
    public final void a(final Context context, final RunnerJob.a aVar) {
        try {
            com.startapp.common.c.b(context);
            MetaData.a(context);
            MetaData.E().j();
            if (MetaData.E().n()) {
                com.startapp.sdk.b.c.a(context).l().a(true, new com.startapp.common.d() { // from class: com.startapp.sdk.adsbase.remoteconfig.d.1
                    @Override // com.startapp.common.d
                    public final void a(Object obj) {
                        if (aVar != null) {
                            com.startapp.sdk.adsbase.j.e.d(context);
                            aVar.a(RunnerJob.Result.SUCCESS);
                        }
                    }
                });
            } else {
                com.startapp.sdk.adsbase.j.e.d(context);
                aVar.a(RunnerJob.Result.SUCCESS);
            }
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }
}
