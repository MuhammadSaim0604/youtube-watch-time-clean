package com.my.youtubewatchtime.view.sa;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import java.lang.Thread;

/* JADX WARN: Classes with same name are omitted:
  /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex
 */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class SketchApplication extends Application {
    private static Context mApplicationContext;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public static Context getContext() {
        return mApplicationContext;
    }

    @Override // android.app.Application
    public void onCreate() {
        mApplicationContext = getApplicationContext();
        this.uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.my.youtubewatchtime.view.sa.SketchApplication.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Intent intent = new Intent(SketchApplication.this.getApplicationContext(), DebugActivity.class);
                intent.setFlags(32768);
                intent.putExtra("error", Log.getStackTraceString(th));
                ((AlarmManager) SketchApplication.this.getSystemService("alarm")).set(2, 1000L, PendingIntent.getActivity(SketchApplication.this.getApplicationContext(), 11111, intent, 1073741824));
                SketchLogger.broadcastLog(Log.getStackTraceString(th));
                Process.killProcess(Process.myPid());
                System.exit(1);
                SketchApplication.this.uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        });
        SketchLogger.startLogging();
        super.onCreate();
    }
}
