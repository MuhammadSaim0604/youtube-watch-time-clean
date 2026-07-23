package com.iab.omid.library.startapp;

import android.content.Context;
import android.net.LinkProperties;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.iab.omid.library.startapp.b.e;
import com.startapp.common.parser.d;
import com.startapp.networkTest.data.TimeInfo;
import com.startapp.networkTest.data.radio.NetworkRegistrationInfo;
import com.startapp.networkTest.enums.ThreeStateShort;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.mraid.bridge.MraidState;
import com.startapp.sdk.f.a.f;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b {
    private boolean a;

    public static String a(String str, String str2) {
        return c.a(str, str2);
    }

    private static int b(String str) {
        c(str);
        return Integer.parseInt(str.split("\\.", 2)[0]);
    }

    private static void c(String str) {
        a((Object) str, "Version cannot be null");
        if (!str.matches("[0-9]+\\.[0-9]+\\.[0-9]+.*")) {
            throw new IllegalArgumentException("Invalid version format : ".concat(String.valueOf(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(String str, Context context) {
        c(str);
        a(context, "Application Context cannot be null");
        if (b("1.2.0-Startapp") == b(str)) {
            if (!this.a) {
                this.a = true;
                e.a().a(context);
                com.iab.omid.library.startapp.b.b.a().a(context);
                com.iab.omid.library.startapp.d.b.a(context);
                com.iab.omid.library.startapp.b.c.a().a(context);
            }
            return true;
        }
        return false;
    }

    public static void a(String str, Exception exc) {
        Log.e("OMIDLIB", str, exc);
    }

    public static double b() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void c(String str, String str2) {
        if (str.length() > 256) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void a(com.iab.omid.library.startapp.adsession.b bVar) {
        if (bVar.j()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void b(com.iab.omid.library.startapp.adsession.b bVar) {
        if (!bVar.i()) {
            throw new IllegalStateException("AdSession is not started");
        }
        a(bVar);
    }

    public static String a(List<String> list) {
        return new com.startapp.b.a.b.a().a(list);
    }

    public static String a(Field field) {
        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        if (declaredAnnotations != null && declaredAnnotations.length > 0) {
            Annotation annotation = field.getDeclaredAnnotations()[0];
            if (annotation.annotationType().equals(d.class)) {
                d dVar = (d) annotation;
                if (!"".equals(dVar.f())) {
                    return dVar.f();
                }
            }
        }
        return field.getName();
    }

    public static boolean a(Object obj) {
        Class<?> cls = obj.getClass();
        return cls.equals(Boolean.class) || cls.equals(Integer.class) || cls.equals(Character.class) || cls.equals(Byte.class) || cls.equals(Short.class) || cls.equals(Double.class) || cls.equals(Long.class) || cls.equals(Float.class) || cls.equals(String.class);
    }

    public static double b(List<Integer> list) {
        long j = 0;
        for (int i = 0; i < list.size(); i++) {
            j += list.get(i).intValue();
        }
        double size = j / list.size();
        double d = 0.0d;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d += Math.pow(list.get(i2).intValue() - size, 2.0d);
        }
        double sqrt = Math.sqrt(d / list.size());
        double d2 = sqrt;
        if (Double.isNaN(sqrt)) {
            d2 = 0.0d;
        }
        return d2;
    }

    public static int c(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).intValue();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i));
        }
        Collections.sort(arrayList);
        if (arrayList.size() % 2 == 0) {
            return (int) Math.round((((Integer) arrayList.get(arrayList.size() / 2)).intValue() + ((Integer) arrayList.get((arrayList.size() / 2) - 1)).intValue()) / 2.0d);
        }
        return ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
    }

    public static int d(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).intValue();
        }
        long j = 0;
        for (int i = 0; i < list.size(); i++) {
            j += list.get(i).intValue();
        }
        return Math.round((float) (j / list.size()));
    }

    public static int e(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).intValue();
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).intValue() < i) {
                i = list.get(i2).intValue();
            }
        }
        return i;
    }

    public static int f(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0).intValue();
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).intValue() > i) {
                i = list.get(i2).intValue();
            }
        }
        return i;
    }

    public static String a(NetworkCapabilities networkCapabilities) {
        String str = "";
        if (networkCapabilities != null) {
            try {
                str = d(networkCapabilities.toString(), "Capabilities:").replaceAll("&", ",").toLowerCase();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static int b(NetworkCapabilities networkCapabilities) {
        int i = -1;
        if (networkCapabilities != null) {
            try {
                i = Integer.parseInt(d(networkCapabilities.toString(), "Specifier:").replaceAll("<", "").replaceAll(">", ""));
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static String a(LinkProperties linkProperties) {
        String str = "";
        if (linkProperties != null) {
            try {
                String d = d(linkProperties.toString().replaceAll("\\[ ", "\\[").replaceAll(" \\]", "\\]"), "PcscfAddresses:");
                if (!d.isEmpty()) {
                    String replace = d.replace("[", "").replace("]", "");
                    String str2 = replace;
                    if (replace.lastIndexOf(",") == str2.length() - 1) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    str = str2;
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    private static String d(String str, String str2) throws Exception {
        String replaceAll = str.substring(str.indexOf(str2)).replaceAll(str2 + " ", "");
        return replaceAll.substring(0, replaceAll.contains(" ") ? replaceAll.indexOf(" ") : replaceAll.length() - 1);
    }

    public static String a(long j) {
        return a(j, true);
    }

    public static String b(long j) {
        return a(j, false);
    }

    private static String a(long j, boolean z) {
        f c = c(j);
        return a(c.a, c.b, c.c, c.d, c.e, c.f, c.g, z, c.h);
    }

    public static f c(long j) {
        return a(j, TimeZone.getDefault().getOffset(j));
    }

    private static f a(long j, int i) {
        long j2 = j + i;
        long j3 = j2 / 1000;
        int i2 = (int) (j2 % 1000);
        long j4 = j3 / 60;
        int i3 = (int) (j3 % 60);
        long j5 = j4 / 60;
        int i4 = (int) (j4 % 60);
        int i5 = (int) (j5 / 24);
        int i6 = (int) (j5 % 24);
        boolean z = false;
        int i7 = 1970;
        int i8 = 1;
        int i9 = 0;
        int i10 = 365;
        while (i10 < i5 + 1) {
            i7++;
            i9 = i10;
            i10 += 365;
            z = false;
            if ((i7 % 4 == 0 && i7 % 100 != 0) || i7 % 400 == 0) {
                i10++;
                z = true;
            }
        }
        int i11 = (i5 + 1) - i9;
        int i12 = 0;
        int i13 = 31;
        while (i13 < i11) {
            i8++;
            i12 = i13;
            if (z && i8 == 2) {
                i13 += 29;
            } else if (i8 == 2) {
                i13 += 28;
            } else if (i8 == 4 || i8 == 6 || i8 == 9 || i8 == 11) {
                i13 += 30;
            } else {
                i13 += 31;
            }
        }
        return new f(i7, i8, i11 - i12, i6, i4, i3, i2, i);
    }

    private static String a(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, int i8) {
        String valueOf = String.valueOf(i3);
        String valueOf2 = String.valueOf(i2);
        String valueOf3 = String.valueOf(i4);
        String valueOf4 = String.valueOf(i5);
        String valueOf5 = String.valueOf(i6);
        String valueOf6 = String.valueOf(i7);
        if (i3 < 10) {
            valueOf = "0".concat(String.valueOf(i3));
        }
        if (i2 < 10) {
            valueOf2 = "0".concat(String.valueOf(i2));
        }
        if (i4 < 10) {
            valueOf3 = "0".concat(String.valueOf(i4));
        }
        if (i5 < 10) {
            valueOf4 = "0".concat(String.valueOf(i5));
        }
        if (i6 < 10) {
            valueOf5 = "0".concat(String.valueOf(i6));
        }
        if (i7 < 10) {
            valueOf6 = "00".concat(String.valueOf(i7));
        } else if (i7 < 100) {
            valueOf6 = "0".concat(String.valueOf(i7));
        }
        String str = i + "-" + valueOf2 + "-" + valueOf + " " + valueOf3 + ":" + valueOf4 + ":" + valueOf5 + "." + valueOf6;
        if (z) {
            String str2 = "+";
            int i9 = (i8 / 1000) / 60;
            if (i8 < 0) {
                str2 = "-";
                i9 = -i9;
            }
            int i10 = i9 / 60;
            int i11 = i9 % 60;
            String valueOf7 = String.valueOf(i10);
            String valueOf8 = String.valueOf(i11);
            if (i10 < 10) {
                valueOf7 = "0".concat(String.valueOf(i10));
            }
            if (i11 < 10) {
                valueOf8 = "0".concat(String.valueOf(i11));
            }
            str = str + " " + str2 + valueOf7 + valueOf8;
        }
        return str;
    }

    public static String a(TimeInfo timeInfo, String str) {
        if (timeInfo == null || str == null || str.length() == 0) {
            return null;
        }
        byte[] bArr = null;
        try {
            bArr = com.startapp.networkTest.a.a.a.a((str + timeInfo.TimestampMillis).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (bArr == null) {
            return null;
        }
        return com.startapp.networkTest.utils.c.a(bArr);
    }

    public static String b(Object obj) {
        obj.getClass();
        return com.startapp.common.parser.b.a(obj);
    }

    public static NetworkRegistrationInfo[] a(String str) {
        try {
            String str2 = "mNetworkRegistrationStates=";
            int indexOf = str.indexOf(str2);
            int i = indexOf;
            if (indexOf == -1) {
                str2 = "mNetworkRegistrationInfos=";
                i = str.indexOf(str2);
            }
            if (i == -1) {
                return new NetworkRegistrationInfo[0];
            }
            String replaceAll = str.substring(i).substring(str2.length() + 1).replaceAll("\\[\\w@", "@");
            String str3 = replaceAll;
            int indexOf2 = replaceAll.indexOf("]");
            int indexOf3 = str3.indexOf("[");
            while (indexOf3 != -1 && indexOf2 > indexOf3) {
                String replaceFirst = str3.replaceFirst("\\[", "").replaceFirst("]", "");
                str3 = replaceFirst;
                indexOf3 = replaceFirst.indexOf("[");
                indexOf2 = str3.indexOf("]");
            }
            String[] split = str3.substring(0, indexOf2).split(", ");
            NetworkRegistrationInfo[] networkRegistrationInfoArr = new NetworkRegistrationInfo[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                split[i2] = split[i2].replace("isDcNrRestricted = false", "isDcNrRestricted=false").replace("isDcNrRestricted = true", "isDcNrRestricted=true").replace("isNrAvailable = false", "isNrAvailable=false").replace("isNrAvailable = true", "isNrAvailable=true").replace("isEnDcAvailable = false", "isEnDcAvailable=false").replace("isEnDcAvailable = true", "isEnDcAvailable=true").replace("mIsUsingCarrierAggregation = false", "mIsUsingCarrierAggregation=false").replace("mIsUsingCarrierAggregation = true", "mIsUsingCarrierAggregation=true");
                split[i2] = split[i2].trim();
                networkRegistrationInfoArr[i2] = a(split[i2].replace("NetworkRegistrationState", " ").replace("NetworkRegistrationInfo", " ").replace("}", " ").replace("{", " ").replace(":", "").replaceAll(" +", " ").trim().split(" "));
            }
            return networkRegistrationInfoArr;
        } catch (Exception e) {
            e.printStackTrace();
            return new NetworkRegistrationInfo[0];
        }
    }

    private static NetworkRegistrationInfo a(String[] strArr) {
        NetworkRegistrationInfo networkRegistrationInfo = new NetworkRegistrationInfo();
        for (String str : strArr) {
            if (str.startsWith("transportType")) {
                networkRegistrationInfo.TransportType = e(d(str));
            } else if (str.startsWith("domain")) {
                networkRegistrationInfo.Domain = d(str);
            } else if (str.startsWith("regState")) {
                networkRegistrationInfo.RegState = d(str);
            } else if (str.startsWith("accessNetworkTechnology")) {
                networkRegistrationInfo.NetworkTechnology = d(str);
            } else if (str.startsWith("reasonForDenial")) {
                networkRegistrationInfo.ReasonForDenial = d(str);
            } else if (str.startsWith("emergencyEnabled")) {
                networkRegistrationInfo.EmergencyEnabled = d(str).equals("true");
            } else if (str.startsWith("mIsUsingCarrierAggregation")) {
                networkRegistrationInfo.CarrierAggregation = d(str).equals("true") ? ThreeStateShort.Yes : ThreeStateShort.No;
            } else if (str.startsWith("cellIdentity")) {
                networkRegistrationInfo.CellTechnology = d(str);
                networkRegistrationInfo.CellTechnology = networkRegistrationInfo.CellTechnology.replace("CellIdentity", "");
            } else if (str.startsWith("mCid") || str.startsWith("mCi") || str.startsWith("mNetworkId") || str.startsWith("mNci")) {
                networkRegistrationInfo.CellId = d(str);
            } else if (str.startsWith("mLac") || str.startsWith("mTac") || str.startsWith("mSystemId")) {
                networkRegistrationInfo.Tac = d(str);
            } else if (str.startsWith("mBsic") || str.startsWith("mPsc") || str.startsWith("mPci") || str.startsWith("mBasestationId")) {
                String d = d(str);
                String str2 = d;
                if (d.startsWith("0x") && str2.length() > 2) {
                    try {
                        str2 = String.valueOf((int) Long.parseLong(str2.substring(2), 16));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        str2 = "";
                    }
                }
                networkRegistrationInfo.Pci = str2;
            } else if (str.startsWith("mArfcn") || str.startsWith("mUarfcn") || str.startsWith("mEarfcn") || str.startsWith("mNrArfcn")) {
                try {
                    networkRegistrationInfo.Arfcn = Integer.parseInt(d(str));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            } else if (str.startsWith("mBandwidth")) {
                try {
                    networkRegistrationInfo.Bandwidth = Integer.parseInt(d(str));
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                }
            } else if (str.startsWith("mMcc")) {
                networkRegistrationInfo.Mcc = d(str);
            } else if (str.startsWith("mMnc")) {
                networkRegistrationInfo.Mnc = d(str);
            } else if (str.startsWith("mAlphaLong")) {
                networkRegistrationInfo.OperatorLong = d(str);
            } else if (str.startsWith("mAlphaShort")) {
                networkRegistrationInfo.OperatorShort = d(str);
            } else if (str.startsWith("mMaxDataCalls")) {
                try {
                    networkRegistrationInfo.MaxDataCalls = Integer.parseInt(d(str));
                } catch (NumberFormatException e4) {
                    e4.printStackTrace();
                }
            } else if (str.startsWith("availableServices")) {
                networkRegistrationInfo.AvailableServices = d(str);
            } else if (str.startsWith("nrState") || str.startsWith("nrStatus")) {
                networkRegistrationInfo.NrState = d(str);
            } else if (str.startsWith("isDcNrRestricted")) {
                networkRegistrationInfo.DcNrRestricted = d(str).equals("true") ? ThreeStateShort.Yes : ThreeStateShort.No;
            } else if (str.startsWith("isNrAvailable")) {
                networkRegistrationInfo.NrAvailable = d(str).equals("true") ? ThreeStateShort.Yes : ThreeStateShort.No;
            } else if (str.startsWith("isEnDcAvailable")) {
                networkRegistrationInfo.EnDcAvailable = d(str).equals("true") ? ThreeStateShort.Yes : ThreeStateShort.No;
            }
        }
        return networkRegistrationInfo;
    }

    private static String d(String str) {
        String[] split = str.split("=");
        return split.length > 1 ? split[1] : "";
    }

    private static String e(String str) {
        String str2 = str;
        try {
            int parseInt = Integer.parseInt(str2);
            switch (parseInt) {
                case 1:
                    return "WWAN";
                case 2:
                    return "WLAN";
                default:
                    str2 = Integer.toString(parseInt);
                    return str2;
            }
        } catch (Exception e) {
            return str2;
        }
    }

    public static List<AdDetails> a(Context context, List<AdDetails> list, int i, Set<String> set) {
        return a(context, list, i, set, true);
    }

    public static List<AdDetails> a(Context context, List<AdDetails> list, int i, Set<String> set, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z2 = false;
        for (AdDetails adDetails : list) {
            AppPresenceDetails appPresenceDetails = new AppPresenceDetails(adDetails.d(), adDetails.o(), i, adDetails.v());
            boolean z3 = adDetails.o() != null && adDetails.o().startsWith("!");
            boolean a = com.startapp.common.b.b.a(context, z3 ? adDetails.o().substring(1) : adDetails.o(), adDetails.v());
            boolean z4 = AdsCommonMetaData.a().F() && ((a && !z3) || (!a && z3));
            arrayList3.add(appPresenceDetails);
            if (z4) {
                appPresenceDetails.b(a);
                appPresenceDetails.a(false);
                if (!z3) {
                    arrayList2.add(adDetails);
                    arrayList4.add(appPresenceDetails);
                }
                set.add(adDetails.n());
                new StringBuilder("App Presence:[").append(adDetails.n()).append("]");
                z2 = true;
            } else {
                arrayList.add(adDetails);
            }
            new StringBuilder("App Not Presence:[").append(adDetails.n()).append("]");
        }
        if (arrayList.size() < 5 && (list.size() != 1 || i > 0)) {
            int min = Math.min(5 - arrayList.size(), arrayList2.size());
            arrayList.addAll(arrayList2.subList(0, min));
            for (AppPresenceDetails appPresenceDetails2 : arrayList4.subList(0, min)) {
                appPresenceDetails2.a(true);
            }
        }
        if (z2) {
            SimpleTokenUtils.c(context);
            if (z) {
                new com.startapp.sdk.adsbase.apppresence.a(context, arrayList3).a();
            }
        }
        return arrayList;
    }

    public static List<AppPresenceDetails> a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = new String[0];
        String a = u.a(str, "@tracking@", "@tracking@");
        if (a != null) {
            strArr = a.split(",");
        }
        String[] strArr2 = new String[0];
        String a2 = u.a(str, "@appPresencePackage@", "@appPresencePackage@");
        if (a2 != null) {
            strArr2 = a2.split(",");
        }
        String[] strArr3 = new String[0];
        String a3 = u.a(str, "@minAppVersion@", "@minAppVersion@");
        if (a3 != null) {
            strArr3 = a3.split(",");
        }
        int i2 = 0;
        while (i2 < strArr2.length) {
            arrayList.add(new AppPresenceDetails(strArr.length > i2 ? strArr[i2] : null, strArr2[i2], i, strArr3.length > i2 ? Integer.valueOf(strArr3[i2]).intValue() : 0));
            i2++;
        }
        while (i2 < strArr.length) {
            arrayList.add(new AppPresenceDetails(strArr[i2], "", i, strArr3.length > i2 ? Integer.valueOf(strArr3[i2]).intValue() : 0));
            i2++;
        }
        return arrayList;
    }

    public static Boolean a(Context context, List<AppPresenceDetails> list, int i, Set<String> set, List<AppPresenceDetails> list2) {
        String b;
        boolean z = false;
        for (AppPresenceDetails appPresenceDetails : list) {
            boolean startsWith = appPresenceDetails.b().startsWith("!");
            if (startsWith) {
                b = appPresenceDetails.b().substring(1);
            } else {
                b = appPresenceDetails.b();
            }
            boolean a = com.startapp.common.b.b.a(context, b, appPresenceDetails.e());
            if ((!startsWith && a) || (startsWith && !a)) {
                appPresenceDetails.b(a);
                boolean z2 = i == 0;
                z = z2;
                if (z2 && !startsWith) {
                    set.add(appPresenceDetails.b());
                } else if (!z && appPresenceDetails.a() != null) {
                    appPresenceDetails.a(appPresenceDetails.a() + "&isShown=" + appPresenceDetails.c() + "&appPresence=" + appPresenceDetails.d());
                }
            }
            list2.add(appPresenceDetails);
        }
        if (z) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                list2.get(i2).a(false);
            }
        }
        return Boolean.valueOf(z);
    }

    public static void a(String str, WebView webView) {
        u.a(webView, "mraid.setPlacementType", str);
    }

    public static void a(MraidState mraidState, WebView webView) {
        new StringBuilder("fireStateChangeEvent: ").append(mraidState);
        u.a(webView, "mraid.fireStateChangeEvent", mraidState.toString());
    }

    public static void a(Context context, int i, int i2, WebView webView) {
        new StringBuilder("setScreenSize ").append(i).append("x").append(i2);
        u.a(webView, "mraid.setScreenSize", Integer.valueOf(t.b(context, i)), Integer.valueOf(t.b(context, i2)));
    }

    public static void b(Context context, int i, int i2, WebView webView) {
        new StringBuilder("setMaxSize ").append(i).append("x").append(i2);
        u.a(webView, "mraid.setMaxSize", Integer.valueOf(t.b(context, i)), Integer.valueOf(t.b(context, i2)));
    }

    public static void a(Context context, int i, int i2, int i3, int i4, WebView webView) {
        new StringBuilder("setCurrentPosition [").append(i).append(",").append(i2).append("] (").append(i3).append("x").append(i4).append(")");
        u.a(webView, "mraid.setCurrentPosition", Integer.valueOf(t.b(context, i)), Integer.valueOf(t.b(context, i2)), Integer.valueOf(t.b(context, i3)), Integer.valueOf(t.b(context, i4)));
    }

    public static void b(Context context, int i, int i2, int i3, int i4, WebView webView) {
        new StringBuilder("setDefaultPosition [").append(i).append(",").append(i2).append("] (").append(i3).append("x").append(i4).append(")");
        u.a(webView, "mraid.setDefaultPosition", Integer.valueOf(t.b(context, i)), Integer.valueOf(t.b(context, i2)), Integer.valueOf(t.b(context, i3)), Integer.valueOf(t.b(context, i4)));
    }

    public static void a(WebView webView) {
        u.a(webView, "mraid.fireReadyEvent", new Object[0]);
    }

    public static void a(WebView webView, boolean z) {
        u.a(webView, "mraid.fireViewableChangeEvent", Boolean.valueOf(z));
    }

    public static void a(WebView webView, String str, String str2) {
        new StringBuilder("fireErrorEvent message: ").append(str).append(", action:").append(str2);
        u.a(webView, "mraid.fireErrorEvent", str, str2);
    }

    private static void a(WebView webView, String str, boolean z) {
        new StringBuilder("setSupports feature: ").append(str).append(", isSupported:").append(z);
        u.a(webView, false, "mraid.setSupports", str, Boolean.valueOf(z));
    }

    public static void a(Context context, WebView webView, com.startapp.sdk.adsbase.mraid.a.a aVar) {
        com.startapp.sdk.adsbase.mraid.a.a aVar2 = aVar;
        if (aVar2 == null) {
            aVar2 = new com.startapp.sdk.adsbase.mraid.a.a(context);
        }
        a(webView, "mraid.SUPPORTED_FEATURES.CALENDAR", aVar2.a());
        a(webView, "mraid.SUPPORTED_FEATURES.INLINEVIDEO", aVar2.b());
        a(webView, "mraid.SUPPORTED_FEATURES.SMS", aVar2.c());
        a(webView, "mraid.SUPPORTED_FEATURES.STOREPICTURE", aVar2.d());
        a(webView, "mraid.SUPPORTED_FEATURES.TEL", aVar2.e());
    }
}
