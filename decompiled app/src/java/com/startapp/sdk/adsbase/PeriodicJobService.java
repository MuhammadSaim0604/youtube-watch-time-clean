package com.startapp.sdk.adsbase;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.startapp.common.jobrunner.interfaces.RunnerJob;

/* compiled from: StartAppSDK */
@TargetApi(21)
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class PeriodicJobService extends JobService {
    static {
        PeriodicJobService.class.getSimpleName();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        int jobId = jobParameters.getJobId();
        if (jobId == Integer.MAX_VALUE || jobId == 2147483646) {
            com.startapp.common.jobrunner.a.a(getApplicationContext(), jobId);
            return false;
        }
        com.startapp.common.jobrunner.a.a(this);
        boolean a = com.startapp.common.jobrunner.a.a(jobParameters, new RunnerJob.a() { // from class: com.startapp.sdk.adsbase.PeriodicJobService.1
            @Override // com.startapp.common.jobrunner.interfaces.RunnerJob.a
            public final void a(RunnerJob.Result result) {
                PeriodicJobService.this.jobFinished(jobParameters, false);
            }
        });
        "onStartJob: RunnerManager.runJob".concat(String.valueOf(a));
        com.startapp.common.jobrunner.a.c();
        return a;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
