package com.startapp.a.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
@TargetApi(14)
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private static final String[] a = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
    private static final String[] b = {"goldfish"};
    private static final String[] c = {"/dev/socket/qemud", "/dev/qemu_pipe"};
    private static final String[] d = {"ueventd.android_x86.rc", "x86.prop", "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc", "fstab.ttVM_x86", "fstab.vbox86", "init.vbox86.rc", "ueventd.vbox86.rc"};
    private static final String[] e = {"fstab.andy", "ueventd.andy.rc"};
    private static final String[] f = {"fstab.nox", "init.nox.rc", "ueventd.nox.rc", "/BigNoxGameHD", "/YSLauncher"};
    private static final b[] g = {new b("init.svc.qemud", null), new b("init.svc.qemu-props", null), new b("qemu.hw.mainkeys", null), new b("qemu.sf.fake_camera", null), new b("qemu.sf.lcd_density", null), new b("ro.bootloader", "unknown"), new b("ro.bootmode", "unknown"), new b("ro.hardware", "goldfish"), new b("ro.kernel.android.qemud", null), new b("ro.kernel.qemu.gles", null), new b("ro.kernel.qemu", "1"), new b("ro.product.device", "generic"), new b("ro.product.model", "sdk"), new b("ro.product.name", "sdk"), new b("ro.serialno", null), new b("ro.build.description", "72656C656173652D6B657973"), new b("ro.build.fingerprint", "3A757365722F72656C656173652D6B657973"), new b("net.eth0.dns1", null), new b("rild.libpath", "2F73797374656D2F6C69622F6C69627265666572656E63652D72696C2E736F"), new b("ro.radio.use-ppp", null), new b("gsm.version.baseband", null), new b("ro.build.tags", "72656C656173652D6B65"), new b("ro.build.display.id", "746573742D"), new b("init.svc.console", null)};
    @SuppressLint({"StaticFieldLeak"})
    private static a k;
    private static Boolean l;
    private final Context h;
    private boolean i = true;
    private List<String> j = new ArrayList();

    public static boolean a(Context context) {
        if (l == null) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            if (k == null) {
                k = new a(context.getApplicationContext());
            }
            a aVar = k;
            boolean z = Build.FINGERPRINT.startsWith("generic") || Build.MODEL.contains("google_sdk") || Build.MODEL.toLowerCase().contains("droid4x") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for") || Build.MANUFACTURER.contains("Genymotion") || Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.PRODUCT.equals("sdk") || Build.PRODUCT.equals("google_sdk") || Build.PRODUCT.equals("sdk_x86") || Build.PRODUCT.equals("vbox86p") || Build.BOARD.toLowerCase().contains("nox") || Build.BOOTLOADER.toLowerCase().contains("nox") || Build.HARDWARE.toLowerCase().contains("nox") || Build.PRODUCT.toLowerCase().contains("nox") || Build.SERIAL.toLowerCase().contains("nox") || Build.FINGERPRINT.startsWith("unknown") || Build.FINGERPRINT.contains("Andy") || Build.FINGERPRINT.contains("ttVM_Hdragon") || Build.FINGERPRINT.contains("vbox86p") || Build.HARDWARE.contains("ttVM_x86") || Build.MODEL.equals("sdk") || Build.MODEL.contains("Droid4X") || Build.MODEL.contains("TiantianVM") || Build.MODEL.contains("Andy") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"));
            boolean z2 = z;
            if (!z) {
                z2 = aVar.a(a, "Geny") || aVar.a(e, "Andy") || aVar.a(f, "Nox") || b() || aVar.a(c, "Pipes") || aVar.d() || (aVar.c() && aVar.a(d, "X86"));
            }
            if (!z2) {
                z2 = aVar.a();
            }
            l = Boolean.valueOf(z2);
        }
        return l.booleanValue();
    }

    private a(Context context) {
        this.h = context;
        this.j.add("com.google.android.launcher.layouts.genymotion");
        this.j.add("com.bluestacks");
        this.j.add("com.bignox.app");
        this.j.add("com.vphone.launcher");
    }

    private boolean a() {
        if (!this.i || this.j.isEmpty()) {
            return false;
        }
        PackageManager packageManager = this.h.getPackageManager();
        for (String str : this.j) {
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null && !packageManager.queryIntentActivities(launchIntentForPackage, 65536).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static boolean b() {
        File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
        for (int i = 0; i < 2; i++) {
            File file = fileArr[i];
            if (file.exists() && file.canRead()) {
                char[] cArr = new char[1024];
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(cArr, 0, read);
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                    }
                    String sb2 = sb.toString();
                    String[] strArr = b;
                    for (int i2 = 0; i2 <= 0; i2++) {
                        if (sb2.contains(strArr[i2])) {
                            return true;
                        }
                    }
                    continue;
                } catch (Exception e3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        }
        return false;
    }

    private boolean a(String[] strArr, String str) {
        File file;
        for (String str2 : strArr) {
            if (b(this.h, "android.permission.READ_EXTERNAL_STORAGE") && str2.contains("/") && str.equals("Nox")) {
                file = new File(Environment.getExternalStorageDirectory() + str2);
            } else {
                file = new File(str2);
            }
            if (file.exists()) {
                return true;
            }
        }
        return false;
    }

    private boolean c() {
        int i = 0;
        b[] bVarArr = g;
        for (int i2 = 0; i2 < 24; i2++) {
            b bVar = bVarArr[i2];
            String a2 = a(this.h, bVar.a);
            if (bVar.b == null && a2 != null) {
                i++;
            }
            if (bVar.b != null && a2 != null && a2.contains(bVar.b)) {
                i++;
            }
        }
        return i >= 5;
    }

    private boolean d() {
        boolean z = false;
        if (b(this.h, "android.permission.INTERNET")) {
            String[] strArr = {"/system/bin/netcfg"};
            StringBuilder sb = new StringBuilder();
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(strArr);
                processBuilder.directory(new File("/system/bin/"));
                processBuilder.redirectErrorStream(true);
                InputStream inputStream = processBuilder.start().getInputStream();
                byte[] bArr = new byte[1024];
                while (inputStream.read(bArr) != -1) {
                    sb.append(new String(bArr));
                }
                inputStream.close();
            } catch (Exception e2) {
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                String[] split = sb2.split("\n");
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = split[i];
                    if ((!str.contains("wlan0") && !str.contains("tunl0") && !str.contains("eth0")) || !str.contains("10.0.2.15")) {
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                }
            }
        }
        return z;
    }

    private static String a(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, str);
        } catch (Exception e2) {
            return null;
        }
    }

    private static boolean b(Context context, String str) {
        boolean z;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                z = context.checkSelfPermission(str) == 0;
            } else {
                z = context.checkCallingOrSelfPermission(str) == 0;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }
}
