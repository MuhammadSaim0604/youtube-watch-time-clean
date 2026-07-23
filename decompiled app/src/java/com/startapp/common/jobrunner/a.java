package com.startapp.common.jobrunner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.util.Log;
import com.startapp.common.b.b;
import com.startapp.common.jobrunner.RunnerRequest;
import com.startapp.common.jobrunner.interfaces.RunnerJob;
import com.startapp.sdk.adsbase.InfoEventService;
import com.startapp.sdk.adsbase.PeriodicJobService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a b;
    private Context d;
    private List<com.startapp.common.jobrunner.interfaces.a> e = Collections.synchronizedList(new ArrayList());
    private Map<Integer, Integer> f = new ConcurrentHashMap();
    private AtomicInteger g = new AtomicInteger(0);
    private boolean h;
    private static final String a = a.class.getSimpleName();
    private static volatile int c = 60000;
    private static final ExecutorService i = Executors.newSingleThreadExecutor();
    private static final ScheduledExecutorService j = Executors.newScheduledThreadPool(1);

    private a(Context context) {
        this.d = context.getApplicationContext();
        this.h = d(context);
    }

    public static a a(Context context) {
        Context context2 = context;
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    if (context2.getApplicationContext() != null) {
                        context2 = context2.getApplicationContext();
                    }
                    b = new a(context2);
                    try {
                        SharedPreferences sharedPreferences = context2.getSharedPreferences("com.startapp.android.publish.RunnerPrefsFile", 0);
                        String string = sharedPreferences.getString("RegisteredClassesNames", null);
                        if (string != null) {
                            String[] split = string.split(",");
                            StringBuilder sb = new StringBuilder(string.length());
                            for (String str : split) {
                                try {
                                    Class<?> cls = Class.forName(str);
                                    if (com.startapp.common.jobrunner.interfaces.a.class.isAssignableFrom(cls)) {
                                        b.e.add((com.startapp.common.jobrunner.interfaces.a) cls.newInstance());
                                        if (sb.length() > 0) {
                                            sb.append(',');
                                        }
                                        sb.append(str);
                                    }
                                } catch (ClassNotFoundException e) {
                                } catch (Throwable th) {
                                }
                            }
                            if (!sb.toString().equals(string)) {
                                sharedPreferences.edit().putString("RegisteredClassesNames", sb.length() > 0 ? sb.toString() : null).commit();
                            }
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        }
        return b;
    }

    public static void a(com.startapp.common.jobrunner.interfaces.a aVar) {
        b.e.add(aVar);
        String name = aVar.getClass().getName();
        SharedPreferences sharedPreferences = b.d.getSharedPreferences("com.startapp.android.publish.RunnerPrefsFile", 0);
        String string = sharedPreferences.getString("RegisteredClassesNames", null);
        if (string == null) {
            sharedPreferences.edit().putString("RegisteredClassesNames", name).commit();
        } else if (!string.contains(name)) {
            sharedPreferences.edit().putString("RegisteredClassesNames", string + "," + name).commit();
        }
    }

    public final void a() {
        if (b.e(this.d)) {
            Intent intent = new Intent(this.d, InfoEventService.class);
            intent.putExtra("__RUNNER_TASK_ID__", Integer.MAX_VALUE);
            this.d.startService(intent);
            return;
        }
        a(this.d, 2147483646);
    }

    @TargetApi(24)
    public static void a(Context context, int i2) {
        JobInfo a2;
        JobScheduler c2 = c(context);
        if (c2 != null && (a2 = a(context, c2, i2)) != null) {
            c2.schedule(a2);
        }
    }

    @TargetApi(24)
    private static JobInfo a(Context context, JobScheduler jobScheduler, int i2) {
        int i3 = i2 == Integer.MAX_VALUE ? 2147483646 : Integer.MAX_VALUE;
        JobInfo b2 = b(context, i3);
        JobInfo pendingJob = jobScheduler.getPendingJob(i3);
        if (pendingJob == null || !pendingJob.getService().equals(b2.getService())) {
            return b2;
        }
        Log.e(a, "Cached process: 2 jobs are pending, must never happened");
        return null;
    }

    @TargetApi(24)
    private static JobInfo b(Context context, int i2) {
        JobInfo.Builder minimumLatency = new JobInfo.Builder(i2, new ComponentName(context, PeriodicJobService.class)).setMinimumLatency(60000L);
        if (b.a(context, "android.permission.RECEIVE_BOOT_COMPLETED")) {
            minimumLatency.setPersisted(true);
        }
        return minimumLatency.build();
    }

    public static boolean a(final RunnerRequest runnerRequest) {
        try {
            final int b2 = b(runnerRequest.a(), runnerRequest.e());
            new StringBuilder("schedule ").append(b2).append(" ").append(runnerRequest);
            if (b.h) {
                if (f()) {
                    return a(b2, runnerRequest);
                }
                return b(b2, runnerRequest);
            }
            final int incrementAndGet = b.g.incrementAndGet();
            Runnable runnable = new Runnable() { // from class: com.startapp.common.jobrunner.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    Integer num = (Integer) a.b.f.get(Integer.valueOf(b2));
                    if (num != null && num.intValue() == incrementAndGet) {
                        if (!runnerRequest.e()) {
                            a.b.f.remove(Integer.valueOf(b2));
                        }
                        a.b(runnerRequest, new RunnerJob.a() { // from class: com.startapp.common.jobrunner.a.1.1
                            @Override // com.startapp.common.jobrunner.interfaces.RunnerJob.a
                            public final void a(RunnerJob.Result result) {
                            }
                        });
                    }
                }
            };
            if (runnerRequest.e()) {
                j.scheduleAtFixedRate(runnable, runnerRequest.d(), runnerRequest.d(), TimeUnit.MILLISECONDS);
            } else {
                j.schedule(runnable, runnerRequest.c(), TimeUnit.MILLISECONDS);
            }
            b.f.put(Integer.valueOf(b2), Integer.valueOf(incrementAndGet));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @TargetApi(21)
    private static boolean a(int i2, RunnerRequest runnerRequest) {
        int i3;
        JobScheduler c2 = c(b.d);
        if (c2 == null) {
            return false;
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        Map<String, String> b2 = runnerRequest.b();
        for (String str : b2.keySet()) {
            persistableBundle.putString(str, b2.get(str));
        }
        persistableBundle.putInt("__RUNNER_RECURRING_ID__", runnerRequest.e() ? 1 : 0);
        persistableBundle.putLong("__RUNNER_TRIGGER_ID__", runnerRequest.c());
        JobInfo.Builder builder = new JobInfo.Builder(i2, new ComponentName(b.d, PeriodicJobService.class));
        builder.setExtras(persistableBundle);
        if (runnerRequest.e()) {
            builder.setPeriodic(runnerRequest.c());
        } else {
            builder.setMinimumLatency(runnerRequest.c()).setOverrideDeadline(runnerRequest.c() + c);
        }
        if (runnerRequest.f() == RunnerRequest.NetworkType.WIFI) {
            i3 = 2;
        } else {
            i3 = runnerRequest.f() == RunnerRequest.NetworkType.ANY ? 1 : 0;
        }
        builder.setRequiredNetworkType(i3);
        if (runnerRequest.g() && b.a(b.d, "android.permission.RECEIVE_BOOT_COMPLETED")) {
            builder.setPersisted(true);
        }
        return c2.schedule(builder.build()) == 1;
    }

    private static boolean b(int i2, RunnerRequest runnerRequest) {
        AlarmManager b2 = b(b.d);
        if (b2 == null) {
            return false;
        }
        Intent intent = new Intent(b.d, InfoEventService.class);
        Map<String, String> b3 = runnerRequest.b();
        for (String str : b3.keySet()) {
            intent.putExtra(str, b3.get(str));
        }
        intent.putExtra("__RUNNER_TASK_ID__", i2);
        intent.putExtra("__RUNNER_RECURRING_ID__", runnerRequest.e());
        intent.putExtra("__RUNNER_TRIGGER_ID__", runnerRequest.c());
        PendingIntent service = PendingIntent.getService(b.d, i2, intent, 134217728);
        b2.cancel(service);
        if (runnerRequest.e()) {
            b2.setRepeating(0, System.currentTimeMillis() + runnerRequest.d(), runnerRequest.c(), service);
        } else {
            b2.set(3, SystemClock.elapsedRealtime() + runnerRequest.c(), service);
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    public static void a(int i2, boolean z) {
        try {
            int b2 = b(i2, z);
            if (b.h) {
                if (f()) {
                    JobScheduler c2 = c(b.d);
                    if (c2 != null) {
                        c2.cancel(b2);
                        return;
                    }
                    return;
                }
                AlarmManager b3 = b(b.d);
                if (b3 != null) {
                    Intent intent = new Intent(b.d, InfoEventService.class);
                    Context context = b.d;
                    PendingIntent service = PendingIntent.getService(context, b2, intent, 134217728);
                    if (PendingIntent.getService(context, 0, intent, 268435456) != null) {
                        b3.cancel(service);
                        service.cancel();
                    }
                    return;
                }
                return;
            }
            b.f.remove(Integer.valueOf(b2));
        } catch (Exception e) {
        }
    }

    public static void b() {
    }

    public static void c() {
    }

    public static boolean a(Intent intent, RunnerJob.a aVar) {
        new StringBuilder("runJob ").append(intent != null ? intent : "NULL");
        if (intent != null) {
            b(a(intent), aVar);
            return true;
        }
        return false;
    }

    @TargetApi(21)
    public static boolean a(JobParameters jobParameters, RunnerJob.a aVar) {
        new StringBuilder("runJob ").append(jobParameters);
        return b(a(jobParameters), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(final RunnerRequest runnerRequest, final RunnerJob.a aVar) {
        new StringBuilder("RunnerJob ").append(runnerRequest.a()).append(" ").append(runnerRequest.a() & Integer.MAX_VALUE);
        final int a2 = runnerRequest.a() & Integer.MAX_VALUE;
        final RunnerJob a3 = a(a2);
        if (a3 == null) {
            i.execute(new Runnable() { // from class: com.startapp.common.jobrunner.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    String unused = a.a;
                    new StringBuilder("runJob: failed to get job for ID ").append(RunnerRequest.this.a());
                    a.b();
                    aVar.a(RunnerJob.Result.FAILED);
                }
            });
        } else {
            i.execute(new Runnable() { // from class: com.startapp.common.jobrunner.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    RunnerJob.this.a(a.b.d, new RunnerJob.a() { // from class: com.startapp.common.jobrunner.a.2.1
                        @Override // com.startapp.common.jobrunner.interfaces.RunnerJob.a
                        public final void a(RunnerJob.Result result) {
                            String unused = a.a;
                            new StringBuilder("job.execute ").append(runnerRequest.a()).append(" ").append(result);
                            a.b();
                            if (result == RunnerJob.Result.RESCHEDULE && !runnerRequest.e()) {
                                a.a(runnerRequest);
                            }
                            aVar.a(result);
                        }
                    });
                }
            });
        }
        return true;
    }

    private static RunnerJob a(int i2) {
        RunnerJob runnerJob = null;
        for (com.startapp.common.jobrunner.interfaces.a aVar : b.e) {
            RunnerJob a2 = aVar.a(i2);
            runnerJob = a2;
            if (a2 != null) {
                break;
            }
        }
        return runnerJob;
    }

    private static RunnerRequest a(Intent intent) {
        int intExtra = intent.getIntExtra("__RUNNER_TASK_ID__", -1);
        boolean booleanExtra = intent.getBooleanExtra("__RUNNER_RECURRING_ID__", false);
        long longExtra = intent.getLongExtra("__RUNNER_TRIGGER_ID__", 0L);
        HashMap hashMap = null;
        if (intent.getExtras() != null) {
            hashMap = new HashMap(intent.getExtras().keySet().size());
            for (String str : intent.getExtras().keySet()) {
                Object obj = intent.getExtras().get(str);
                if (obj instanceof String) {
                    hashMap.put(str, (String) obj);
                }
            }
        }
        return new RunnerRequest.a(intExtra).a(hashMap).a(booleanExtra).a(longExtra).b();
    }

    @TargetApi(21)
    private static RunnerRequest a(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        boolean z = extras.getInt("__RUNNER_RECURRING_ID__") == 1;
        long j2 = extras.getLong("__RUNNER_TRIGGER_ID__", 0L);
        HashMap hashMap = new HashMap(extras.keySet().size());
        for (String str : extras.keySet()) {
            Object obj = extras.get(str);
            if (obj instanceof String) {
                hashMap.put(str, (String) obj);
            }
        }
        return new RunnerRequest.a(jobParameters.getJobId()).a(hashMap).a(z).a(j2).b();
    }

    private static AlarmManager b(Context context) {
        return (AlarmManager) context.getSystemService("alarm");
    }

    @TargetApi(21)
    private static JobScheduler c(Context context) {
        return (JobScheduler) context.getSystemService("jobscheduler");
    }

    private static int b(int i2, boolean z) {
        int i3 = i2;
        if (z) {
            i3 |= Integer.MIN_VALUE;
        }
        return i3;
    }

    private static boolean f() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private static boolean d(Context context) {
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services) {
                if (serviceInfo.name.equals(InfoEventService.class.getName())) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }
}
