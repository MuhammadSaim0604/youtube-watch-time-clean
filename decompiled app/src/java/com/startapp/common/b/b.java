package com.startapp.common.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.startapp.common.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class b {
    private static final String a = a(b.class);

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public interface a {
        void a();
    }

    public static String a(Class<?> cls) {
        return "startapp." + cls.getSimpleName();
    }

    @SuppressLint({"NewApi"})
    public static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 9) {
            a(activity, 7);
        } else {
            a(activity, 1);
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 9) {
            a(activity, 6);
        } else {
            a(activity, 0);
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static void a(View view, float f) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.setAlpha(f);
        }
    }

    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 12) {
            view.animate().alpha(1.0f).setDuration(1500L).setListener(null);
        }
    }

    public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public static boolean a(Context context) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT < 17 || Build.VERSION.SDK_INT >= 21) {
                z = Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps") == 1;
            } else {
                z = Settings.Global.getInt(context.getContentResolver(), "install_non_market_apps") == 1;
            }
        } catch (Settings.SettingNotFoundException e) {
            Log.w(a, e);
        }
        return z;
    }

    public static void a(WebView webView) {
        if (Build.VERSION.SDK_INT >= 17) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(Activity activity, int i, boolean z) {
        int i2;
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        switch (i) {
            case 1:
                if (Build.VERSION.SDK_INT > 8) {
                    if (!z && (rotation == 1 || rotation == 2)) {
                        i2 = 9;
                        break;
                    } else {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 1;
                break;
            case 2:
                if (Build.VERSION.SDK_INT <= 8) {
                    i2 = 0;
                    break;
                } else if (z || rotation == 0 || rotation == 1) {
                    i2 = 0;
                    break;
                } else {
                    i2 = 8;
                    break;
                }
                break;
            default:
                i2 = 1;
                break;
        }
        int i3 = i2;
        a(activity, i3);
        return i3;
    }

    public static void a(Activity activity, int i) {
        try {
            activity.setRequestedOrientation(i);
        } catch (Exception e) {
            Log.w(a, e);
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 14;
    }

    public static void b(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.onPause();
            return;
        }
        try {
            Class.forName("android.webkit.WebView").getMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception e) {
            Log.w(a, e);
        }
    }

    public static void c(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.onResume();
            return;
        }
        try {
            Class.forName("android.webkit.WebView").getMethod("onResume", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception e) {
            Log.w(a, e);
        }
    }

    public static void d(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.setLayerType(1, null);
        }
    }

    public static void a(View view, final a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.startapp.common.b.b.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    a.this.a();
                }
            });
        }
    }

    public static Long a(ActivityManager.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Long.valueOf(memoryInfo.totalMem);
        }
        return null;
    }

    public static boolean a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 11 && 1 != view.getLayerType() && z) {
            return view.isHardwareAccelerated();
        }
        return false;
    }

    public static long a(File file) {
        long j;
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    if (Build.VERSION.SDK_INT >= 9) {
                        j = file.getFreeSpace();
                    } else {
                        StatFs statFs = new StatFs(file.getPath());
                        j = statFs.getBlockSize() * statFs.getFreeBlocks();
                    }
                    return j;
                }
            } catch (Exception e) {
                Log.w(a, e);
                return -1L;
            }
        }
        j = -1;
        return j;
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "auto_time", 0) > 0 : Settings.System.getInt(context.getContentResolver(), "auto_time", 0) > 0;
    }

    public static boolean a(Context context, String str) {
        boolean z;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                z = context.checkSelfPermission(str) == 0;
            } else {
                z = context.checkCallingOrSelfPermission(str) == 0;
            }
            return z;
        } catch (Exception e) {
            Log.w(a, e);
            return false;
        }
    }

    public static List<CellInfo> a(Context context, TelephonyManager telephonyManager) {
        if (context == null || telephonyManager == null) {
            return null;
        }
        if ((a(context, "android.permission.ACCESS_FINE_LOCATION") || a(context, "android.permission.ACCESS_COARSE_LOCATION")) && Build.VERSION.SDK_INT >= 17) {
            return telephonyManager.getAllCellInfo();
        }
        return null;
    }

    @SuppressLint({"RtlHardcoded"})
    public static int a(int i) {
        int i2 = i;
        if (Build.VERSION.SDK_INT < 17) {
            switch (i) {
                case 16:
                    i2 = 0;
                    break;
                case 17:
                    i2 = 1;
                    break;
                case 20:
                    i2 = 9;
                    break;
                case 21:
                    i2 = 11;
                    break;
                case 8388611:
                    if (Build.VERSION.SDK_INT < 14) {
                        i2 = 3;
                        break;
                    }
                    break;
                case 8388613:
                    if (Build.VERSION.SDK_INT < 14) {
                        i2 = 5;
                        break;
                    }
                    break;
            }
        }
        return i2;
    }

    public static String b(Context context, TelephonyManager telephonyManager) {
        List<CellInfo> allCellInfo;
        if (Build.VERSION.SDK_INT >= 17 && ((a(context, "android.permission.ACCESS_FINE_LOCATION") || a(context, "android.permission.ACCESS_COARSE_LOCATION")) && (allCellInfo = telephonyManager.getAllCellInfo()) != null)) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo != null && cellInfo.isRegistered()) {
                    try {
                        Object invoke = cellInfo.getClass().getMethod("getCellSignalStrength", new Class[0]).invoke(cellInfo, new Object[0]);
                        Object invoke2 = invoke.getClass().getMethod("getTimingAdvance", new Class[0]).invoke(invoke, new Object[0]);
                        if (invoke2 instanceof Integer) {
                            return invoke2.toString();
                        }
                        continue;
                    } catch (Exception e) {
                        Log.w(a, e);
                    }
                }
            }
        }
        return null;
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            Log.w(a, e);
            return 0;
        }
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            Log.w(a, e);
            return null;
        }
    }

    public static String a(String str, Context context) throws FileNotFoundException {
        String str2 = null;
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).sourceDir;
        } catch (Exception e) {
            Log.w(a, e);
        }
        if (str2 != null) {
            return a(new FileInputStream(str2), str);
        }
        return null;
    }

    private static int k(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (Exception e) {
            Log.w(a, e);
            return Build.VERSION.SDK_INT;
        }
    }

    public static boolean e(Context context) {
        return Build.VERSION.SDK_INT < 26 || k(context) < 26;
    }

    private static String a(InputStream inputStream, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            }
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
        } catch (Exception e) {
            Log.w(a, e);
        } finally {
            a(inputStream);
        }
        return sb.toString().toUpperCase(Locale.ENGLISH);
    }

    public static int f(Context context) {
        int i = 0;
        try {
            for (PackageInfo packageInfo : a(context.getPackageManager())) {
                if (!a(packageInfo) || packageInfo.packageName.equals(Constants.a)) {
                    i++;
                }
            }
        } catch (Exception e) {
            Log.w(a, e);
        }
        return i;
    }

    public static boolean a(PackageInfo packageInfo) {
        return ((packageInfo.applicationInfo.flags & 1) == 0 && (packageInfo.applicationInfo.flags & 128) == 0) ? false : true;
    }

    public static boolean a(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionCode >= i;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<PackageInfo> a(PackageManager packageManager) throws Exception {
        return (List) packageManager.getClass().getMethod("getInstalledPackages", Integer.TYPE).invoke(packageManager, 8192);
    }

    public static boolean g(Context context) {
        int i;
        try {
            if (Build.VERSION.SDK_INT < 17) {
                i = Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0);
            } else {
                i = Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0);
            }
            return i != 0;
        } catch (Exception e) {
            Log.w(a, e);
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            return com.iab.omid.library.startapp.d.a.a(context);
        } catch (Exception e) {
            Log.w(a, e);
            return false;
        }
    }

    public static boolean i(Context context) {
        try {
            return com.startapp.a.a.a.a(context);
        } catch (Exception e) {
            Log.w(a, e);
            return false;
        }
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String j(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                if (signatureArr.length == 1) {
                    return signatureArr[0].toCharsString();
                }
                Arrays.sort(signatureArr, new Comparator<Signature>() { // from class: com.startapp.common.b.b.2
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(Signature signature, Signature signature2) {
                        return signature.toCharsString().compareTo(signature2.toCharsString());
                    }
                });
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < signatureArr.length; i++) {
                    sb.append(signatureArr[i].toCharsString());
                    if (i < signatureArr.length - 1) {
                        sb.append(';');
                    }
                }
                return sb.toString();
            }
        } catch (Exception e) {
            Log.w(a, e);
        }
        return null;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        if (serviceConnection != null) {
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable th) {
            }
        }
    }
}
