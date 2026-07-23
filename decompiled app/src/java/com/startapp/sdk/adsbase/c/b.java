package com.startapp.sdk.adsbase.c;

import android.content.Context;
import android.os.SystemClock;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.j.s;
import com.startapp.sdk.adsbase.j.u;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.Thread;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class b implements Thread.UncaughtExceptionHandler {
    private final File a;
    private final Thread.UncaughtExceptionHandler b;

    static {
        b.class.getSimpleName();
    }

    public b(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.b = uncaughtExceptionHandler;
        this.a = new File(context.getCacheDir(), "StartApp-767b8b9bfc82ce39");
        this.a.mkdirs();
        File[] listFiles = this.a.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            ThreadManager.a(ThreadManager.Priority.DEFAULT, new c(context, listFiles));
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement a = a(th);
        if (a != null) {
            OutputStream outputStream = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.a, System.currentTimeMillis() + "-" + SystemClock.uptimeMillis()));
                PrintStream printStream = new PrintStream((OutputStream) fileOutputStream, true);
                printStream.println(AdsConstants.c);
                printStream.println(u.a(a));
                outputStream = u.a((OutputStream) fileOutputStream);
                PrintWriter printWriter = new PrintWriter(outputStream);
                a(th, printWriter);
                printWriter.close();
                u.a((Closeable) outputStream);
            } catch (Throwable th2) {
                u.a((Closeable) outputStream);
            }
        }
        if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        String className;
        s sVar = new s(th);
        while (sVar.hasNext()) {
            Throwable next = sVar.next();
            if (sVar.a()) {
                printWriter.println('-');
            }
            printWriter.println(next.toString().trim());
            StackTraceElement[] stackTrace = next.getStackTrace();
            if (stackTrace != null) {
                boolean z = false;
                StackTraceElement stackTraceElement = null;
                int i = 0;
                int i2 = 0;
                int length = stackTrace.length;
                while (i2 < length) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2];
                    if (stackTraceElement2 != null && (className = stackTraceElement2.getClassName()) != null) {
                        boolean z2 = i2 < 3;
                        boolean startsWith = className.startsWith("com.startapp.");
                        if (z2 || startsWith || z) {
                            if (i > 0) {
                                printWriter.print(' ');
                                printWriter.println(i);
                                i = 0;
                            }
                            if (stackTraceElement != null) {
                                printWriter.print(' ');
                                printWriter.print(stackTraceElement.getClassName());
                                printWriter.print('.');
                                printWriter.print(stackTraceElement.getMethodName());
                                printWriter.println("()");
                                stackTraceElement = null;
                            }
                            printWriter.print(' ');
                            printWriter.print(stackTraceElement2.getClassName());
                            printWriter.print('.');
                            printWriter.print(stackTraceElement2.getMethodName());
                            printWriter.println("()");
                        } else {
                            if (stackTraceElement != null) {
                                i++;
                            }
                            stackTraceElement = stackTraceElement2;
                        }
                        z = startsWith;
                    }
                    i2++;
                }
                if (stackTraceElement != null) {
                    i++;
                }
                if (i > 0) {
                    printWriter.print(' ');
                    printWriter.println(i);
                }
            }
        }
    }

    public static StackTraceElement a(Throwable th) {
        String className;
        Throwable th2 = th;
        while (true) {
            Throwable th3 = th2;
            if (th3 != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                if (stackTrace != null) {
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        if (stackTraceElement != null && (className = stackTraceElement.getClassName()) != null && className.startsWith("com.startapp.")) {
                            return stackTraceElement;
                        }
                    }
                    continue;
                }
                th2 = th3.getCause();
            } else {
                return null;
            }
        }
    }
}
