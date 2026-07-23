package com.startapp.networkTest.controller;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.startapp.networkTest.data.e;
import com.startapp.networkTest.data.f;
import com.startapp.networkTest.enums.AppCategoryTypes;
import com.startapp.networkTest.enums.IdleStates;
import com.startapp.networkTest.enums.MemoryStates;
import com.startapp.networkTest.enums.MultiSimVariants;
import com.startapp.networkTest.enums.Os;
import com.startapp.networkTest.enums.PhoneTypes;
import com.startapp.networkTest.enums.ScreenStates;
import com.startapp.networkTest.enums.SimStates;
import com.startapp.networkTest.enums.ThreeState;
import com.startapp.networkTest.utils.g;
import com.startapp.networkTest.utils.h;
import com.startapp.networkTest.utils.i;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager;
import com.startapp.sdk.adsbase.j.j;
import de.hdodenhof.circleimageview.BuildConfig;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class b {
    private static final String a = b.class.getSimpleName();

    public static com.startapp.networkTest.data.a a(Context context) {
        String[] b;
        SimStates simStates;
        PhoneTypes phoneTypes;
        com.startapp.networkTest.data.a aVar = new com.startapp.networkTest.data.a();
        aVar.DeviceManufacturer = Build.MANUFACTURER;
        aVar.DeviceName = Build.MODEL;
        aVar.OS = Os.Android;
        aVar.OSVersion = Build.VERSION.RELEASE;
        aVar.BuildFingerprint = Build.FINGERPRINT;
        aVar.DeviceUpTime = SystemClock.elapsedRealtime();
        aVar.UserLocal = Locale.getDefault().toString();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            aVar.SimOperator = h.a(telephonyManager.getSimOperator());
            aVar.SimOperatorName = h.a(telephonyManager.getSimOperatorName());
            if (Build.VERSION.SDK_INT >= 29) {
                String typeAllocationCode = telephonyManager.getTypeAllocationCode();
                if (typeAllocationCode != null && !typeAllocationCode.isEmpty()) {
                    aVar.TAC = typeAllocationCode;
                } else {
                    String manufacturerCode = telephonyManager.getManufacturerCode();
                    if (manufacturerCode != null && !manufacturerCode.isEmpty()) {
                        aVar.TAC = manufacturerCode;
                    }
                }
            }
            SimStates simStates2 = SimStates.Unknown;
            switch (telephonyManager.getSimState()) {
                case 1:
                    simStates = SimStates.Absent;
                    break;
                case 2:
                    simStates = SimStates.PinRequired;
                    break;
                case 3:
                    simStates = SimStates.PukRequired;
                    break;
                case 4:
                    simStates = SimStates.NetworkLocked;
                    break;
                case 5:
                    simStates = SimStates.Ready;
                    break;
                default:
                    simStates = SimStates.Unknown;
                    break;
            }
            aVar.SimState = simStates;
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    aVar.PhoneCount = ((Integer) telephonyManager.getClass().getDeclaredMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
                } catch (Exception e) {
                    Log.e(a, "getPhoneCount: " + e.getMessage());
                }
            }
            PhoneTypes phoneTypes2 = PhoneTypes.Unknown;
            switch (telephonyManager.getPhoneType()) {
                case 0:
                    phoneTypes = PhoneTypes.None;
                    break;
                case 1:
                    phoneTypes = PhoneTypes.GSM;
                    break;
                case 2:
                    phoneTypes = PhoneTypes.CDMA;
                    break;
                case 3:
                    phoneTypes = PhoneTypes.SIP;
                    break;
                default:
                    phoneTypes = PhoneTypes.Unknown;
                    break;
            }
            aVar.PhoneType = phoneTypes;
        }
        aVar.IsRooted = a();
        if (Build.VERSION.SDK_INT <= 24) {
            b = g.a("/proc/version");
        } else {
            b = g.b("uname -a");
        }
        if (b.length > 0) {
            aVar.OsSystemVersion = h.a(b[0]);
        }
        com.startapp.sdk.adsbase.g.a aVar2 = new com.startapp.sdk.adsbase.g.a();
        aVar2.a = true;
        aVar.BluetoothInfo$3e5b9058 = aVar2;
        aVar.PowerSaveMode = i(context);
        aVar.MultiSimInfo = g(context);
        aVar.HostAppInfo$41202ccd = h(context);
        return aVar;
    }

    private static j h(Context context) {
        String[] strArr;
        AppCategoryTypes appCategoryTypes;
        j jVar = new j();
        jVar.a = context.getPackageName();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        ApplicationInfo applicationInfo2 = applicationInfo;
        if (applicationInfo == null) {
            try {
                applicationInfo2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        if (applicationInfo2 != null) {
            jVar.d = applicationInfo2.targetSdkVersion;
            jVar.c = (String) applicationInfo2.loadLabel(context.getPackageManager());
            if (Build.VERSION.SDK_INT >= 26) {
                int i = applicationInfo2.category;
                AppCategoryTypes appCategoryTypes2 = AppCategoryTypes.Unknown;
                switch (i) {
                    case BuildConfig.VERSION_CODE /* -1 */:
                        appCategoryTypes = AppCategoryTypes.Undefined;
                        break;
                    case 0:
                        appCategoryTypes = AppCategoryTypes.Game;
                        break;
                    case 1:
                        appCategoryTypes = AppCategoryTypes.Audio;
                        break;
                    case 2:
                        appCategoryTypes = AppCategoryTypes.Video;
                        break;
                    case 3:
                        appCategoryTypes = AppCategoryTypes.Image;
                        break;
                    case 4:
                        appCategoryTypes = AppCategoryTypes.Social;
                        break;
                    case 5:
                        appCategoryTypes = AppCategoryTypes.News;
                        break;
                    case 6:
                        appCategoryTypes = AppCategoryTypes.Maps;
                        break;
                    case 7:
                        appCategoryTypes = AppCategoryTypes.Productivity;
                        break;
                    default:
                        appCategoryTypes = AppCategoryTypes.Unknown;
                        break;
                }
                jVar.b = appCategoryTypes;
            }
        }
        ArrayList<DiskAdCacheManager> arrayList = new ArrayList<>();
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                DiskAdCacheManager diskAdCacheManager = new DiskAdCacheManager();
                diskAdCacheManager.a = str.toLowerCase();
                if (str.equalsIgnoreCase("android.permission.PACKAGE_USAGE_STATS")) {
                    diskAdCacheManager.b = Build.VERSION.SDK_INT < 21 || ((AppOpsManager) context.getApplicationContext().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getApplicationContext().getPackageName()) == 0 ? 1 : 0;
                } else {
                    diskAdCacheManager.b = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
                }
                arrayList.add(diskAdCacheManager);
            }
        } catch (Exception e2) {
        } finally {
            jVar.e = arrayList;
        }
        return jVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005f -> B:8:0x001e). Please submit an issue!!! */
    private static ThreeState i(Context context) {
        String string;
        try {
            string = Settings.System.getString(context.getContentResolver(), "user_powersaver_enable");
        } catch (Exception e) {
            Log.e(a, "getPowerSaveMode: " + e.getMessage());
        }
        if (string != null) {
            return string.equals("1") ? ThreeState.Enabled : ThreeState.Disabled;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.MANUFACTURER.toLowerCase().startsWith("sony") && Build.VERSION.SDK_INT < 23) {
                return ThreeState.Unknown;
            }
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isPowerSaveMode() ? ThreeState.Enabled : ThreeState.Disabled;
            }
        }
        return ThreeState.Unknown;
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

    @SuppressLint({"NewApi"})
    public static com.startapp.networkTest.data.b b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        com.startapp.networkTest.data.b bVar = new com.startapp.networkTest.data.b();
        bVar.MemoryFree = memoryInfo.availMem;
        if (Build.VERSION.SDK_INT >= 16) {
            bVar.MemoryTotal = memoryInfo.totalMem;
            bVar.MemoryUsed = memoryInfo.totalMem - memoryInfo.availMem;
        }
        if (memoryInfo.lowMemory) {
            bVar.MemoryState = MemoryStates.Low;
        } else {
            bVar.MemoryState = MemoryStates.Normal;
        }
        return bVar;
    }

    public static e c(Context context) {
        StatFs statFs;
        StatFs statFs2;
        e eVar = new e();
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        eVar.StorageInternalSize = blockSize * statFs.getBlockCount();
        eVar.StorageInternalAvailable = blockSize * statFs.getAvailableBlocks();
        eVar.StorageInternalAudio = a(context, MediaStore.Audio.Media.INTERNAL_CONTENT_URI);
        eVar.StorageInternalImages = a(context, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        eVar.StorageInternalVideo = a(context, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        if (b()) {
            try {
                long blockSize2 = new StatFs(Environment.getExternalStorageDirectory().getPath()).getBlockSize();
                eVar.StorageExternalSize = blockSize2 * statFs2.getBlockCount();
                eVar.StorageExternalAvailable = blockSize2 * statFs2.getAvailableBlocks();
            } catch (IllegalArgumentException e) {
                eVar.StorageExternalSize = -1L;
                eVar.StorageExternalAvailable = -1L;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                eVar.StorageExternalAudio = a(context, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                eVar.StorageExternalImages = a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                eVar.StorageExternalVideo = a(context, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            }
        }
        return eVar;
    }

    private static long a(Context context, Uri uri) {
        long j = 0;
        Cursor cursor = null;
        try {
            try {
                Cursor query = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
                cursor = query;
                if (query != null) {
                    if (cursor.getCount() == 0) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return 0L;
                    }
                    while (cursor.moveToNext()) {
                        j += cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static boolean b() {
        boolean z = false;
        try {
            z = Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            new StringBuilder("isExternalMemoryAvailable: ").append(e.getMessage());
        }
        return z;
    }

    public static f a(d dVar) {
        f fVar = new f();
        fVar.MobileRxBytes = i.b();
        fVar.MobileTxBytes = i.a();
        fVar.TotalRxBytes = TrafficStats.getTotalRxBytes();
        fVar.TotalTxBytes = TrafficStats.getTotalTxBytes();
        if (dVar != null) {
            fVar.WifiRxBytes = dVar.b();
            fVar.WifiTxBytes = dVar.c();
        } else {
            fVar.WifiRxBytes = -1L;
            fVar.WifiTxBytes = -1L;
        }
        return fVar;
    }

    public static ScreenStates d(Context context) {
        ScreenStates screenStates = ScreenStates.Unknown;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            screenStates = powerManager.isScreenOn() ? ScreenStates.On : ScreenStates.Off;
        }
        return screenStates;
    }

    public static IdleStates e(Context context) {
        PowerManager powerManager;
        IdleStates idleStates = IdleStates.Unknown;
        if (Build.VERSION.SDK_INT >= 23 && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    if (((Boolean) powerManager.getClass().getDeclaredMethod("isLightDeviceIdleMode", new Class[0]).invoke(powerManager, new Object[0])).booleanValue()) {
                        idleStates = IdleStates.LightIdle;
                    }
                } catch (Exception e) {
                    Log.e(a, "getIdleState: " + e.getMessage());
                }
            }
            if (idleStates != IdleStates.LightIdle) {
                idleStates = powerManager.isDeviceIdleMode() ? IdleStates.DeepIdle : IdleStates.NonIdle;
            }
        }
        return idleStates;
    }

    public static com.startapp.networkTest.data.a.b f(Context context) {
        com.startapp.networkTest.data.a.a g = g(context);
        Iterator<com.startapp.networkTest.data.a.b> it = g.SimInfos.iterator();
        while (it.hasNext()) {
            com.startapp.networkTest.data.a.b next = it.next();
            if (next.SubscriptionId == g.DefaultDataSimId) {
                return next;
            }
        }
        return new com.startapp.networkTest.data.a.b();
    }

    public static com.startapp.networkTest.data.a.a g(Context context) {
        String replaceAll;
        SimStates simStates;
        String replaceAll2;
        com.startapp.networkTest.data.a.a aVar = new com.startapp.networkTest.data.a.a();
        if (Build.VERSION.SDK_INT >= 22 && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            if (subscriptionManager != null) {
                aVar.ActiveSimCount = subscriptionManager.getActiveSubscriptionInfoCount();
                aVar.ActiveSimCountMax = subscriptionManager.getActiveSubscriptionInfoCountMax();
                List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList != null && activeSubscriptionInfoList.size() > 0) {
                    com.startapp.networkTest.data.a.b[] bVarArr = new com.startapp.networkTest.data.a.b[activeSubscriptionInfoList.size()];
                    int i = 0;
                    for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                        com.startapp.networkTest.data.a.b bVar = new com.startapp.networkTest.data.a.b();
                        try {
                            if (subscriptionInfo.getCarrierName() != null) {
                                bVar.CarrierName = h.a(subscriptionInfo.getCarrierName().toString());
                            }
                        } catch (Exception e) {
                            Log.e(a, "getMultiSimInfo: " + e.getMessage());
                        }
                        try {
                            if (subscriptionInfo.getCountryIso() != null) {
                                bVar.CountryIso = h.a(subscriptionInfo.getCountryIso());
                            }
                        } catch (Exception e2) {
                            Log.e(a, "getMultiSimInfo: " + e2.getMessage());
                        }
                        try {
                            if (subscriptionInfo.getIccId() != null) {
                                String a2 = h.a(subscriptionInfo.getIccId());
                                if (a2.length() == 0) {
                                    replaceAll2 = a2;
                                } else {
                                    switch (com.startapp.networkTest.c.d().u()) {
                                        case Full:
                                            replaceAll2 = a2;
                                            break;
                                        case Anonymized:
                                            if (a2.length() >= 11) {
                                                replaceAll2 = a2.substring(0, 7) + a2.substring(7, a2.length()).replaceAll("[\\d\\w]", "*");
                                                break;
                                            } else {
                                                replaceAll2 = a2.replaceAll("[\\d\\w]", "*");
                                                break;
                                            }
                                        default:
                                            replaceAll2 = "";
                                            break;
                                    }
                                }
                                bVar.IccId = replaceAll2;
                            }
                        } catch (Exception e3) {
                            Log.e(a, "getMultiSimInfo: " + e3.getMessage());
                        }
                        bVar.Mcc = subscriptionInfo.getMcc() == Integer.MAX_VALUE ? -1 : subscriptionInfo.getMcc();
                        bVar.Mnc = subscriptionInfo.getMnc() == Integer.MAX_VALUE ? -1 : subscriptionInfo.getMnc();
                        bVar.SimSlotIndex = subscriptionInfo.getSimSlotIndex();
                        bVar.SubscriptionId = subscriptionInfo.getSubscriptionId();
                        bVar.DataRoaming = subscriptionInfo.getDataRoaming() == 1;
                        int i2 = bVar.SubscriptionId;
                        String str = "content://telephony/carriers/preferapn";
                        Cursor cursor = null;
                        if (i2 != -1) {
                            str = "content://telephony/carriers/preferapn/subId/".concat(String.valueOf(i2));
                        }
                        try {
                            try {
                                Cursor query = context.getContentResolver().query(Uri.parse(str), new String[]{"apn", "type"}, null, null, null);
                                cursor = query;
                                if (query != null && cursor.moveToFirst()) {
                                    String string = cursor.getString(cursor.getColumnIndex("apn"));
                                    String string2 = cursor.getString(cursor.getColumnIndex("type"));
                                    bVar.Apn = string;
                                    bVar.ApnTypes = string2;
                                    cursor.close();
                                    cursor = null;
                                }
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e4) {
                                    }
                                }
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            new StringBuilder("saveApnItemsToSimInfo: ").append(e6.toString());
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e7) {
                                }
                            }
                        }
                        bVarArr[i] = bVar;
                        i++;
                    }
                    aVar.SimInfos = new ArrayList<>(Arrays.asList(bVarArr));
                }
                Method method = null;
                try {
                    method = subscriptionManager.getClass().getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
                } catch (NoSuchMethodException e8) {
                }
                if (method == null) {
                    try {
                        method = subscriptionManager.getClass().getDeclaredMethod("getDefaultDataSubId", new Class[0]);
                    } catch (NoSuchMethodException e9) {
                    }
                }
                if (method != null) {
                    try {
                        aVar.DefaultDataSimId = ((Integer) method.invoke(subscriptionManager, new Object[0])).intValue();
                    } catch (Exception e10) {
                    }
                }
                Method method2 = null;
                try {
                    method2 = subscriptionManager.getClass().getDeclaredMethod("getDefaultSmsSubscriptionId", new Class[0]);
                } catch (NoSuchMethodException e11) {
                }
                if (method2 == null) {
                    try {
                        method2 = subscriptionManager.getClass().getDeclaredMethod("getDefaultSmsSubId", new Class[0]);
                    } catch (NoSuchMethodException e12) {
                    }
                }
                if (method2 != null) {
                    try {
                        aVar.DefaultSmsSimId = ((Integer) method2.invoke(subscriptionManager, new Object[0])).intValue();
                    } catch (Exception e13) {
                    }
                }
                Method method3 = null;
                try {
                    method3 = subscriptionManager.getClass().getDeclaredMethod("getDefaultSubscriptionId", new Class[0]);
                } catch (NoSuchMethodException e14) {
                }
                if (method3 == null) {
                    try {
                        method3 = subscriptionManager.getClass().getDeclaredMethod("getDefaultSubId", new Class[0]);
                    } catch (NoSuchMethodException e15) {
                    }
                }
                if (method3 != null) {
                    try {
                        aVar.DefaultSimId = ((Integer) method3.invoke(subscriptionManager, new Object[0])).intValue();
                    } catch (Exception e16) {
                    }
                }
                Method method4 = null;
                try {
                    method4 = subscriptionManager.getClass().getDeclaredMethod("getDefaultVoiceSubscriptionId", new Class[0]);
                } catch (NoSuchMethodException e17) {
                }
                if (method4 == null) {
                    try {
                        method4 = subscriptionManager.getClass().getDeclaredMethod("getDefaultVoiceSubId", new Class[0]);
                    } catch (NoSuchMethodException e18) {
                    }
                }
                if (method4 != null) {
                    try {
                        aVar.DefaultVoiceSimId = ((Integer) method4.invoke(subscriptionManager, new Object[0])).intValue();
                    } catch (Exception e19) {
                    }
                }
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                Method method5 = null;
                try {
                    method5 = telephonyManager.getClass().getDeclaredMethod("getMultiSimConfiguration", new Class[0]);
                } catch (NoSuchMethodException e20) {
                }
                if (method5 != null) {
                    try {
                        Object invoke = method5.invoke(telephonyManager, new Object[0]);
                        if (invoke instanceof Enum) {
                            String obj = invoke.toString();
                            boolean z = true;
                            switch (obj.hashCode()) {
                                case 2107724:
                                    if (obj.equals("DSDA")) {
                                        z = false;
                                        break;
                                    }
                                    break;
                                case 2107742:
                                    if (obj.equals("DSDS")) {
                                        z = true;
                                        break;
                                    }
                                    break;
                                case 2584894:
                                    if (obj.equals("TSTS")) {
                                        z = true;
                                        break;
                                    }
                                    break;
                            }
                            switch (z) {
                                case false:
                                    aVar.MultiSimVariant = MultiSimVariants.DSDA;
                                    break;
                                case true:
                                    aVar.MultiSimVariant = MultiSimVariants.DSDS;
                                    break;
                                case true:
                                    aVar.MultiSimVariant = MultiSimVariants.TSTS;
                                    break;
                                default:
                                    aVar.MultiSimVariant = MultiSimVariants.Unknown;
                                    break;
                            }
                        }
                    } catch (Exception e21) {
                    }
                }
                Iterator<com.startapp.networkTest.data.a.b> it = aVar.SimInfos.iterator();
                while (it.hasNext()) {
                    com.startapp.networkTest.data.a.b next = it.next();
                    Method method6 = null;
                    try {
                        method6 = telephonyManager.getClass().getDeclaredMethod("getSimState", Integer.TYPE);
                    } catch (NoSuchMethodException e22) {
                    }
                    if (method6 != null) {
                        try {
                            switch (((Integer) method6.invoke(telephonyManager, Integer.valueOf(next.SimSlotIndex))).intValue()) {
                                case 1:
                                    simStates = SimStates.Absent;
                                    break;
                                case 2:
                                    simStates = SimStates.PinRequired;
                                    break;
                                case 3:
                                    simStates = SimStates.PukRequired;
                                    break;
                                case 4:
                                    simStates = SimStates.NetworkLocked;
                                    break;
                                case 5:
                                    simStates = SimStates.Ready;
                                    break;
                                case 6:
                                    simStates = SimStates.NotReady;
                                    break;
                                case 7:
                                    simStates = SimStates.PermanentlyDisabled;
                                    break;
                                case 8:
                                    simStates = SimStates.CardIoError;
                                    break;
                                case 9:
                                    simStates = SimStates.CardRestricted;
                                    break;
                                default:
                                    simStates = SimStates.Unknown;
                                    break;
                            }
                            next.SimState = simStates;
                        } catch (Exception e23) {
                        }
                    }
                    Method method7 = null;
                    try {
                        method7 = telephonyManager.getClass().getDeclaredMethod("getSubscriberId", Integer.TYPE);
                    } catch (NoSuchMethodException e24) {
                    }
                    if (method7 != null) {
                        try {
                            String a3 = h.a((String) method7.invoke(telephonyManager, Integer.valueOf(next.SubscriptionId)));
                            if (a3.length() == 0) {
                                replaceAll = a3;
                            } else {
                                switch (com.startapp.networkTest.c.d().v()) {
                                    case Full:
                                        replaceAll = a3;
                                        break;
                                    case Anonymized:
                                        if (a3.length() >= 14) {
                                            replaceAll = a3.substring(0, 10) + a3.substring(10, a3.length()).replaceAll("[\\d\\w]", "*");
                                            break;
                                        } else {
                                            replaceAll = a3.replaceAll("[\\d\\w]", "*");
                                            break;
                                        }
                                    default:
                                        replaceAll = "";
                                        break;
                                }
                            }
                            next.IMSI = replaceAll;
                        } catch (Exception e25) {
                        }
                    }
                    Method method8 = null;
                    try {
                        method8 = telephonyManager.getClass().getDeclaredMethod("getGroupIdLevel1", Integer.TYPE);
                    } catch (NoSuchMethodException e26) {
                    }
                    if (method8 != null) {
                        try {
                            next.GroupIdentifierLevel1 = h.a((String) method8.invoke(telephonyManager, Integer.valueOf(next.SubscriptionId)));
                        } catch (Exception e27) {
                        }
                    }
                }
            }
        }
        return aVar;
    }
}
