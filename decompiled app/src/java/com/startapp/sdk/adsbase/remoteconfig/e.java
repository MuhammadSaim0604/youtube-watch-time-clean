package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import com.startapp.common.jobrunner.interfaces.RunnerJob;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class e implements RunnerJob {
    static {
        e.class.getSimpleName();
    }

    @Override // com.startapp.common.jobrunner.interfaces.RunnerJob
    public final void a(final Context context, final RunnerJob.a aVar) {
        try {
            com.startapp.common.c.b(context);
            MetaData.a(context);
            if (!MetaData.E().l()) {
                return;
            }
            final AdPreferences adPreferences = new AdPreferences();
            new a(context, adPreferences, MetaDataRequest.RequestReason.PERIODIC) { // from class: com.startapp.sdk.adsbase.remoteconfig.e.1
                private MetaData b;

                @Override // com.startapp.sdk.adsbase.remoteconfig.a
                protected final Boolean c() {
                    try {
                        SimpleTokenUtils.b(context);
                        MetaDataRequest metaDataRequest = new MetaDataRequest(context, MetaDataRequest.RequestReason.PERIODIC);
                        metaDataRequest.a(context, adPreferences);
                        this.b = (MetaData) com.startapp.sdk.b.c.a(context).m().a(AdsConstants.a(AdsConstants.ServiceApiType.METADATA)).a(metaDataRequest).a(MetaData.class);
                        return Boolean.TRUE;
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                        return Boolean.FALSE;
                    }
                }

                @Override // com.startapp.sdk.adsbase.remoteconfig.a
                protected final void a(Boolean bool) {
                    try {
                        if (bool.booleanValue() && this.b != null && context != null) {
                            MetaData.a(context, this.b, MetaDataRequest.RequestReason.PERIODIC, this.a);
                        }
                        com.startapp.sdk.adsbase.j.e.c(context);
                        if (aVar != null) {
                            aVar.a(RunnerJob.Result.SUCCESS);
                        }
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                    }
                }
            }.a();
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }
}
