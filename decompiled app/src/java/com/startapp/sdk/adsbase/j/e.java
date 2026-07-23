package com.startapp.sdk.adsbase.j;

import android.content.Context;
import android.os.SystemClock;
import com.startapp.common.jobrunner.RunnerRequest;
import com.startapp.common.jobrunner.interfaces.RunnerJob;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class e {
    private static volatile boolean a = false;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static final class a implements com.startapp.common.jobrunner.interfaces.a {
        @Override // com.startapp.common.jobrunner.interfaces.a
        public final RunnerJob a(int i) {
            switch (i) {
                case 586482792:
                    return new com.startapp.sdk.adsbase.remoteconfig.e();
                case 786564404:
                    return new com.startapp.sdk.adsbase.remoteconfig.d();
                default:
                    return null;
            }
        }
    }

    public static void a(Context context) {
        if (!a) {
            a = true;
            com.startapp.common.jobrunner.a.a(context);
            com.startapp.common.jobrunner.a.a(new a());
        }
    }

    public static long a() {
        return SystemClock.elapsedRealtime() + (MetaData.E().m() * 60000);
    }

    public static long b(Context context) {
        return SystemClock.elapsedRealtime() + (MetaData.E().c(context) * 60000);
    }

    public static void c(Context context) {
        a(context, Long.valueOf(a()));
    }

    public static void a(Context context, Long l) {
        new StringBuilder("setMetaDataPeriodicAlarm executes ").append(l);
        if (!com.startapp.sdk.adsbase.j.a(context, "periodicMetadataPaused", Boolean.FALSE).booleanValue() && MetaData.E().l()) {
            a(context, 586482792, l.longValue() - SystemClock.elapsedRealtime(), "periodicMetadataTriggerTime");
        }
    }

    public static void d(Context context) {
        a(context, b(context));
    }

    public static void a(Context context, long j) {
        if (!com.startapp.sdk.adsbase.j.a(context, "periodicInfoEventPaused", Boolean.FALSE).booleanValue() && MetaData.E().n()) {
            a(context, 786564404, j - SystemClock.elapsedRealtime(), "periodicInfoEventTriggerTime");
        }
    }

    public static void a(int i) {
        com.startapp.common.jobrunner.a.a(i, false);
    }

    private static void a(Context context, int i, long j, String str) {
        if (com.startapp.common.jobrunner.a.a(new RunnerRequest.a(i).a(j).b())) {
            com.startapp.sdk.adsbase.j.b(context, str, Long.valueOf(j + SystemClock.elapsedRealtime()));
        } else {
            new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Util.setPeriodicAlarm - failed setting alarm ".concat(String.valueOf(i))).a(context);
        }
    }
}
