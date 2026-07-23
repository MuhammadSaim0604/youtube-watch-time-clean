package com.iab.omid.library.startapp.d;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private static com.startapp.a.b.a a;

    public static float a(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            return 0.0f;
        }
        float f = i / i2;
        float f2 = f;
        if (f > 1.0f) {
            f2 = 1.0f;
        }
        return f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iab.omid.library.startapp.d.a.a(android.content.Context):boolean");
    }

    private static boolean a() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean b() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            boolean z = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() != null;
            if (process != null) {
                process.destroy();
            }
            return z;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    private static boolean c() {
        try {
            return new File("/system/app/Superuser.apk").exists();
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
