package com.startapp.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private final Context a;

    public a(Context context) {
        this.a = context;
    }

    public final boolean a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(b.a));
        return a(arrayList);
    }

    public final boolean b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(b.b));
        return a(arrayList);
    }

    public static boolean a(String str) {
        String[] strArr = b.c;
        boolean z = false;
        for (int i = 0; i < 14; i++) {
            String str2 = strArr[i];
            new StringBuilder().append(str2).append(str);
            if (new File(str2, str).exists()) {
                z = true;
            }
        }
        return z;
    }

    private static String[] f() {
        String[] strArr = new String[0];
        try {
            strArr = new Scanner(Runtime.getRuntime().exec("getprop").getInputStream()).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e) {
            e.printStackTrace();
        }
        return strArr;
    }

    private static String[] g() {
        String[] strArr = new String[0];
        try {
            strArr = new Scanner(Runtime.getRuntime().exec("mount").getInputStream()).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e) {
            e.printStackTrace();
        }
        return strArr;
    }

    private boolean a(List<String> list) {
        boolean z = false;
        PackageManager packageManager = this.a.getPackageManager();
        for (String str : list) {
            try {
                packageManager.getPackageInfo(str, 0);
                z = true;
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return z;
    }

    public static boolean c() {
        String[] f;
        HashMap hashMap = new HashMap();
        hashMap.put("ro.debuggable", "1");
        hashMap.put("ro.secure", "0");
        boolean z = false;
        for (String str : f()) {
            for (String str2 : hashMap.keySet()) {
                if (str.contains(str2)) {
                    if (str.contains("[" + ((String) hashMap.get(str2)) + "]")) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static boolean d() {
        boolean z = false;
        for (String str : g()) {
            String[] split = str.split(" ");
            if (split.length >= 4) {
                String str2 = split[1];
                String str3 = split[3];
                String[] strArr = b.d;
                for (int i = 0; i < 7; i++) {
                    if (str2.equalsIgnoreCase(strArr[i])) {
                        String[] split2 = str3.split(",");
                        int length = split2.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                if (!split2[i2].equalsIgnoreCase("rw")) {
                                    i2++;
                                } else {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public static boolean e() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"which", "su"});
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
}
