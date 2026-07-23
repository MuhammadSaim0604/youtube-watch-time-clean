package com.startapp.sdk.adsbase.j;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Base64OutputStream;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.startapp.common.SDKException;
import com.startapp.sdk.GeneratedConstants;
import com.startapp.sdk.ads.banner.banner3d.Banner3DAd;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.nativead.NativeAd;
import com.startapp.sdk.ads.offerWall.offerWallHtml.OfferWallAd;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class u {
    protected static int a;
    private static final String b = u.class.getSimpleName();
    private static Map<Activity, Integer> c = new WeakHashMap();

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        void a();

        void a(String str);
    }

    public static boolean a() {
        return new BigInteger(AdsConstants.d, 10).intValue() == 0;
    }

    public static String a(Context context) {
        Drawable loadIcon;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (loadIcon = packageManager.getApplicationInfo(context.getPackageName(), 128).loadIcon(packageManager)) != null) {
                float f = context.getResources().getDisplayMetrics().density;
                int i = (int) (48.0f * f);
                try {
                    return a(loadIcon, i, i, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError e) {
                    int i2 = (int) (24.0f * f);
                    try {
                        return a(loadIcon, i2, i2, Bitmap.Config.ARGB_4444);
                    } catch (OutOfMemoryError e2) {
                        return null;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }

    private static String a(Drawable drawable, int i, int i2, Bitmap.Config config) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Drawable mutate = drawable.mutate();
        mutate.setBounds(0, 0, i, i2);
        mutate.draw(new Canvas(createBitmap));
        f fVar = new f(i * i2);
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, fVar);
        return new String(Base64.encode(fVar.a(), 0, fVar.b(), 2));
    }

    public static String b(Context context) {
        ComponentName component;
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null && (component = launchIntentForPackage.getComponent()) != null) {
            return component.getClassName();
        }
        return null;
    }

    public static String b() {
        String str = GeneratedConstants.INAPP_VERSION;
        if (GeneratedConstants.INAPP_VERSION.equals("${version}")) {
            str = "0";
        }
        new StringBuilder("SDK version: [").append(str).append("]");
        return str;
    }

    public static String c() {
        String str = GeneratedConstants.INAPP_FLAVOR;
        if (GeneratedConstants.INAPP_FLAVOR.equals("${flavor}")) {
            str = GeneratedConstants.INAPP_FLAVOR;
        }
        new StringBuilder("SDK Flavor: [").append(str).append("]");
        return str;
    }

    public static String d() {
        String str = GeneratedConstants.INAPP_PACKAGING;
        if (GeneratedConstants.INAPP_PACKAGING.equals("${packaging}")) {
            str = "";
        }
        return str;
    }

    public static boolean a(long j) {
        String str = AdsConstants.d;
        if (!str.equals("${flavor}") && (new BigInteger(str, 2).longValue() & j) == 0) {
            return false;
        }
        return true;
    }

    public static boolean e() {
        return a(2L) || a(16L) || a(32L) || a(4L);
    }

    public static String a(Double d) {
        if (d != null) {
            return String.format(Locale.US, "%.2f", d);
        }
        return null;
    }

    public static boolean c(Context context) {
        if (AdsConstants.b.booleanValue()) {
            return true;
        }
        if (com.startapp.common.b.b.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                return false;
            }
        }
        return false;
    }

    public static boolean d(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void a(SharedPreferences.Editor editor) {
        com.startapp.common.b.b.a(editor);
    }

    public static String a(String str, String str2, String str3) {
        int indexOf;
        if (str == null) {
            return null;
        }
        int indexOf2 = str.indexOf(str2);
        if (indexOf2 != -1 && (indexOf = str.indexOf(str3, indexOf2 + str2.length())) != -1) {
            return str.substring(indexOf2 + str2.length(), indexOf);
        }
        return null;
    }

    public static String e(Context context) {
        Configuration configuration;
        Resources resources = context.getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            if (configuration.orientation == 2) {
                return "landscape";
            }
            if (configuration.orientation == 1) {
                return "portrait";
            }
        }
        return "undefined";
    }

    public static int a(Activity activity, int i, boolean z) {
        if (z) {
            if (!c.containsKey(activity)) {
                c.put(activity, Integer.valueOf(activity.getRequestedOrientation()));
            }
            if (i == activity.getResources().getConfiguration().orientation) {
                return com.startapp.common.b.b.a(activity, i, false);
            }
            return com.startapp.common.b.b.a(activity, i, true);
        }
        int i2 = -1;
        if (c.containsKey(activity)) {
            int intValue = c.get(activity).intValue();
            i2 = intValue;
            com.startapp.common.b.b.a(activity, intValue);
            c.remove(activity);
        }
        return i2;
    }

    public static void a(Activity activity, boolean z) {
        a(activity, activity.getResources().getConfiguration().orientation, z);
    }

    private static List<Field> a(List<Field> list, Class<?> cls) {
        list.addAll(Arrays.asList(cls.getDeclaredFields()));
        if (cls.getSuperclass() != null) {
            a(list, (Class<?>) cls.getSuperclass());
        }
        return list;
    }

    public static <T> boolean a(T t, T t2) {
        Object obj;
        boolean z = false;
        try {
            for (Field field : a((List<Field>) new LinkedList(), t2.getClass())) {
                int modifiers = field.getModifiers();
                if (!Modifier.isTransient(modifiers) && !Modifier.isStatic(modifiers)) {
                    field.setAccessible(true);
                    if (field.get(t) == null && (obj = field.get(t2)) != null) {
                        field.set(t, obj);
                        z = true;
                    }
                }
            }
        } catch (Exception e) {
            new StringBuilder("Util.mergeDefaultValues failed: ").append(e.getMessage());
        }
        return z;
    }

    public static void a(Context context, String str, final a aVar) {
        if (!"true".equals(a(str, "@doNotRender@", "@doNotRender@"))) {
            try {
                final WebView webView = new WebView(context);
                final Handler handler = new Handler(Looper.getMainLooper());
                if (AdsConstants.b.booleanValue()) {
                    a = 25000;
                    webView.getSettings().setBlockNetworkImage(false);
                    webView.getSettings().setLoadsImagesAutomatically(true);
                    webView.getSettings().setJavaScriptEnabled(true);
                } else {
                    a = 0;
                }
                webView.setWebChromeClient(new WebChromeClient());
                webView.setWebViewClient(new WebViewClient() { // from class: com.startapp.sdk.adsbase.j.u.1
                    @Override // android.webkit.WebViewClient
                    public final void onPageFinished(WebView webView2, String str2) {
                        super.onPageFinished(webView2, str2);
                        String unused = u.b;
                        new StringBuilder("onPageFinished url=[").append(str2).append("]");
                        handler.removeCallbacksAndMessages(null);
                        handler.postDelayed(new Runnable() { // from class: com.startapp.sdk.adsbase.j.u.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                webView.destroy();
                                String unused2 = u.b;
                                aVar.a();
                            }
                        }, u.a);
                    }

                    @Override // android.webkit.WebViewClient
                    public final void onReceivedError(final WebView webView2, int i, final String str2, String str3) {
                        super.onReceivedError(webView2, i, str2, str3);
                        String unused = u.b;
                        new StringBuilder("onReceivedError failingUrl=[").append(str3).append("], description=[").append(str2).append("]");
                        handler.removeCallbacksAndMessages(null);
                        handler.post(new Runnable() { // from class: com.startapp.sdk.adsbase.j.u.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                webView2.destroy();
                                aVar.a(str2);
                            }
                        });
                    }

                    @Override // android.webkit.WebViewClient
                    public final boolean shouldOverrideUrlLoading(WebView webView2, String str2) {
                        if (webView2 == null || str2 == null) {
                            return true;
                        }
                        if (u.a(webView2.getContext(), str2)) {
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView2, str2);
                    }
                });
                a(context, webView, str);
                handler.postDelayed(new Runnable() { // from class: com.startapp.sdk.adsbase.j.u.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        webView.destroy();
                        aVar.a();
                        String unused = u.b;
                    }
                }, 25000L);
                return;
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                aVar.a("WebView instantiation Error");
                return;
            }
        }
        aVar.a();
    }

    public static void a(Context context, WebView webView, String str) {
        try {
            webView.loadDataWithBaseURL(MetaData.E().r(), str, "text/html", "utf-8", null);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
    }

    public static String f(Context context) {
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity != null && resolveActivity.activityInfo != null) {
                String str2 = resolveActivity.activityInfo.packageName;
                str = str2;
                if (str2 != null) {
                    str = str.toLowerCase();
                }
            }
        } catch (Exception e) {
        }
        return str;
    }

    public static String g(Context context) {
        return context.getPackageManager().getInstallerPackageName(context.getPackageName());
    }

    public static void a(WebView webView, String str, Object... objArr) {
        a(webView, true, str, objArr);
    }

    public static void a(WebView webView, boolean z, String str, Object... objArr) {
        if (webView != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("(");
                if (objArr != null) {
                    for (int i = 0; i < objArr.length; i++) {
                        if (z && (objArr[i] instanceof String)) {
                            sb.append("\"").append(objArr[i]).append("\"");
                        } else {
                            sb.append(objArr[i]);
                        }
                        if (i < objArr.length - 1) {
                            sb.append(",");
                        }
                    }
                }
                sb.append(")");
                new StringBuilder("runJavascript: ").append(sb.toString());
                webView.loadUrl("javascript:" + sb.toString());
            } catch (Exception e) {
                new StringBuilder("runJavascript Exception: ").append(e.getMessage());
            }
        }
    }

    public static Class<?> a(Context context, Class<? extends Activity> cls, Class<? extends Activity> cls2) {
        if (a(context, cls) || !a(context, cls2)) {
            return cls;
        }
        Log.w(b, "Expected activity " + cls.getName() + " is missing from AndroidManifest.xml");
        return cls2;
    }

    public static boolean a(Context context, Class<? extends Activity> cls) {
        try {
            for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                if (activityInfo.name.equals(cls.getName())) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean h(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && packageName.equals(runningAppProcessInfo.processName)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean i(Context context) {
        boolean z = false;
        try {
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            int i = 0;
            while (!z) {
                if (i >= activityInfoArr.length) {
                    break;
                }
                int i2 = i;
                i++;
                ActivityInfo activityInfo = activityInfoArr[i2];
                if (activityInfo.name.equals("com.startapp.sdk.adsbase.activities.AppWallActivity") || activityInfo.name.equals("com.startapp.sdk.adsbase.activities.OverlayActivity") || activityInfo.name.equals("com.startapp.sdk.adsbase.activities.FullScreenActivity")) {
                    z = (activityInfo.flags & 512) == 0;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (Exception e2) {
        }
        return z;
    }

    public static String a(String str, Context context) {
        String str2 = null;
        try {
            new com.startapp.common.b.b();
            str2 = com.startapp.common.b.b.a(str, context);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
        return str2;
    }

    public static long a(File file) {
        return com.startapp.common.b.b.a(file);
    }

    public static String a(Context context, int i) {
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeResource.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (Exception e) {
            return "";
        }
    }

    public static <T> T a(String str, Class<T> cls) throws SDKException {
        T t = (T) com.startapp.common.parser.b.a(str, cls);
        if (t == null) {
            throw new SDKException();
        }
        return t;
    }

    public static void a(Object obj) {
        new Handler(Looper.getMainLooper()).postAtTime(null, obj, SystemClock.uptimeMillis() + 1000);
    }

    public static int a(Object... objArr) {
        return Arrays.deepHashCode(objArr);
    }

    public static <T> boolean b(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return t.equals(t2);
    }

    public static String b(Object obj) throws IOException {
        String a2 = com.startapp.common.parser.b.a(obj);
        if (a2 != null) {
            return Base64.encodeToString(b(a2.getBytes()), 11);
        }
        return null;
    }

    public static byte[] a(String str) throws IOException {
        return b(str.getBytes());
    }

    private static byte[] b(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
        deflaterOutputStream.write(bArr);
        deflaterOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream, new Inflater(true));
        inflaterOutputStream.write(bArr);
        inflaterOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String j(Context context) {
        List<CellInfo> a2;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && (a2 = com.startapp.common.b.b.a(context, telephonyManager)) != null && a2.size() > 0) {
                return com.startapp.common.b.a.c(a2.toString());
            }
        } catch (SecurityException e) {
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
        return null;
    }

    public static String[] k(Context context) {
        String[] strArr = {null, null};
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                strArr[0] = Long.toString(memoryInfo.availMem / 1048576);
                Long a2 = com.startapp.common.b.b.a(memoryInfo);
                if (a2 != null) {
                    strArr[1] = Long.toString((a2.longValue() - memoryInfo.availMem) / 1048576);
                }
            }
        } catch (SecurityException e) {
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
        }
        return strArr;
    }

    public static String b(File file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    String sb2 = sb.toString();
                    a((Closeable) bufferedReader);
                    return sb2;
                }
            }
        } catch (Exception e) {
            a((Closeable) bufferedReader);
            return null;
        } catch (Throwable th) {
            a((Closeable) bufferedReader);
            throw th;
        }
    }

    public static List<String> c(File file) {
        ArrayList arrayList = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(readLine);
                } else {
                    ArrayList arrayList2 = arrayList;
                    a((Closeable) bufferedReader);
                    return arrayList2;
                }
            }
        } catch (Exception e) {
            a((Closeable) bufferedReader);
            return arrayList;
        } catch (Throwable th) {
            a((Closeable) bufferedReader);
            throw th;
        }
    }

    public static OutputStream a(OutputStream outputStream) {
        return new DeflaterOutputStream(new Base64OutputStream(outputStream, 10), new Deflater(9, true));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static void d(File file) {
        if (file != null) {
            try {
                if (!file.delete()) {
                    file.deleteOnExit();
                }
            } catch (Exception e) {
            }
        }
    }

    public static <T> String a(Iterable<T> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (T t : iterable) {
            if (z) {
                sb.append(str);
            }
            sb.append(t);
            z = true;
        }
        return sb.toString();
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    static class b {
        b() {
        }

        static StackTraceElement[] a() {
            return Thread.currentThread().getStackTrace();
        }
    }

    public static StackTraceElement f() {
        StackTraceElement[] a2 = b.a();
        if (a2 != null) {
            String name = b.class.getName();
            int i = 0;
            int length = a2.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = a2[i];
                if (stackTraceElement == null || !name.equals(stackTraceElement.getClassName())) {
                    i++;
                } else if (i + 3 < length) {
                    return a2[i + 3];
                }
            }
        }
        return null;
    }

    public static String a(StackTraceElement stackTraceElement) {
        if (stackTraceElement != null) {
            return stackTraceElement.getClassName() + '.' + stackTraceElement.getMethodName() + "()";
        }
        return "null";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0025 -> B:17:0x0008). Please submit an issue!!! */
    public static Context l(Context context) {
        Context context2;
        if (context instanceof Application) {
            return context;
        }
        if (context instanceof ContextWrapper) {
            context2 = l(((ContextWrapper) context).getBaseContext());
        } else {
            if (context != null) {
                context2 = context.getApplicationContext();
            }
            context2 = null;
        }
        return context2;
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        try {
            String[] split = new URL(MetaData.E().q()).getHost().split("\\.");
            if (split.length > 1) {
                return str.toLowerCase(Locale.ENGLISH).contains(split[1].toLowerCase(Locale.ENGLISH));
            }
        } catch (MalformedURLException e) {
        }
        return false;
    }

    public static boolean m(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null && (applicationInfo.flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static void a(Context context, boolean z, String str) {
        if (z) {
            Log.e("StartAppSDK", str);
        } else {
            Log.i("StartAppSDK", str);
        }
        if (m(context) || com.startapp.common.b.b.i(context)) {
            new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.GENERAL).f("Log for a publisher").g(str).a(context);
        }
    }

    public static String a(Ad ad) {
        if (ad instanceof VideoEnabledAd) {
            VideoEnabledAd videoEnabledAd = (VideoEnabledAd) ad;
            if (videoEnabledAd.getType() == Ad.AdType.VIDEO) {
                return "VIDEO";
            }
            if (videoEnabledAd.getType() == Ad.AdType.REWARDED_VIDEO) {
                return "REWARDED_VIDEO";
            }
            return "INTERSTITIAL";
        } else if (ad instanceof ReturnAd) {
            return "RETURN";
        } else {
            if (ad instanceof OfferWallAd) {
                return "OFFER_WALL";
            }
            if (ad instanceof OfferWall3DAd) {
                return "OFFER_WALL_3D";
            }
            if (ad instanceof BannerStandardAd) {
                BannerStandardAd bannerStandardAd = (BannerStandardAd) ad;
                if (bannerStandardAd.d() == 0) {
                    return AdPreferences.TYPE_BANNER;
                }
                if (bannerStandardAd.d() == 1) {
                    return "MREC";
                }
                if (bannerStandardAd.d() == 2) {
                    return "COVER";
                }
                return "BANNER_UNDEFINED";
            } else if (ad instanceof Banner3DAd) {
                return "BANNER_3D";
            } else {
                if (ad instanceof NativeAd) {
                    return "NATIVE";
                }
                if (ad instanceof SplashAd) {
                    return "SPLASH";
                }
                return "UNDEFINED";
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 15) {
            return false;
        }
        if (str.startsWith("sms:") || str.startsWith("smsto:")) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse(str));
            intent.addFlags(268435456);
            try {
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
            }
        }
        return false;
    }
}
