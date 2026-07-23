package com.startapp.sdk.ads.video;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import com.startapp.sdk.adsbase.j;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class VideoUtil {
    private final HashMap<View, String> a = new HashMap<>();
    private final HashMap<View, ArrayList<String>> b = new HashMap<>();
    private final HashSet<View> c = new HashSet<>();
    private final HashSet<String> d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();
    private boolean f;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum VideoEligibility {
        ELIGIBLE(""),
        INELIGIBLE_NO_STORAGE("Not enough storage for video"),
        INELIGIBLE_MISSING_ACTIVITY("FullScreenActivity not declared in AndroidManifest.xml"),
        INELIGIBLE_ERRORS_THRESHOLD_REACHED("Video errors threshold reached.");
        
        private String desctiption;

        VideoEligibility(String str) {
            this.desctiption = str;
        }

        public final String a() {
            return this.desctiption;
        }
    }

    public static String a(Context context, URL url, String str) {
        String str2;
        File file;
        new StringBuilder("Downloading video from ").append(url);
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                str2 = a(context, str);
                file = new File(str2);
            } catch (Exception e) {
                Log.e("StartAppWall.VideoUtil", "Error downloading video from ".concat(String.valueOf(url)), e);
                new File(a(context, str + ".temp")).delete();
                str2 = null;
                try {
                    inputStream.close();
                    dataInputStream.close();
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
            }
            if (file.exists()) {
                InputStream inputStream2 = null;
                try {
                    inputStream2.close();
                    DataInputStream dataInputStream2 = null;
                    dataInputStream2.close();
                    FileOutputStream fileOutputStream2 = null;
                    fileOutputStream2.close();
                } catch (Exception e3) {
                }
                return str2;
            }
            inputStream = url.openStream();
            dataInputStream = new DataInputStream(inputStream);
            byte[] bArr = new byte[4096];
            fileOutputStream = context.openFileOutput(str + ".temp", 0);
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            new File(a(context, str + ".temp")).renameTo(file);
            try {
                inputStream.close();
                dataInputStream.close();
                fileOutputStream.close();
            } catch (Exception e4) {
            }
            return str2;
        } catch (Throwable th) {
            try {
                inputStream.close();
                dataInputStream.close();
                fileOutputStream.close();
            } catch (Exception e5) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.startapp.sdk.ads.video.VideoUtil.VideoEligibility a(android.content.Context r13) {
        /*
            r0 = r13
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r7 = com.startapp.sdk.ads.video.VideoUtil.VideoEligibility.ELIGIBLE
            r1 = r7
            r7 = r0
            r2 = r7
            com.startapp.sdk.adsbase.AdsCommonMetaData r7 = com.startapp.sdk.adsbase.AdsCommonMetaData.a()
            com.startapp.sdk.adsbase.VideoConfig r7 = r7.I()
            int r7 = r7.e()
            if (r7 < 0) goto L7d
            r7 = r2
            java.lang.String r8 = "videoErrorsCount"
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Integer r7 = com.startapp.sdk.adsbase.j.a(r7, r8, r9)
            int r7 = r7.intValue()
            com.startapp.sdk.adsbase.AdsCommonMetaData r8 = com.startapp.sdk.adsbase.AdsCommonMetaData.a()
            com.startapp.sdk.adsbase.VideoConfig r8 = r8.I()
            int r8 = r8.e()
            if (r7 < r8) goto L7d
            r7 = 1
        L33:
            if (r7 == 0) goto L38
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r7 = com.startapp.sdk.ads.video.VideoUtil.VideoEligibility.INELIGIBLE_ERRORS_THRESHOLD_REACHED
            r1 = r7
        L38:
            r7 = r0
            java.lang.Class<com.startapp.sdk.adsbase.activities.FullScreenActivity> r8 = com.startapp.sdk.adsbase.activities.FullScreenActivity.class
            boolean r7 = com.startapp.sdk.adsbase.j.u.a(r7, r8)
            if (r7 != 0) goto L44
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r7 = com.startapp.sdk.ads.video.VideoUtil.VideoEligibility.INELIGIBLE_MISSING_ACTIVITY
            r1 = r7
        L44:
            r7 = r0
            java.io.File r7 = r7.getFilesDir()
            long r7 = com.startapp.sdk.adsbase.j.u.a(r7)
            r11 = r7
            r7 = r11
            r9 = r11
            r3 = r9
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L7f
            com.startapp.sdk.adsbase.AdsCommonMetaData r7 = com.startapp.sdk.adsbase.AdsCommonMetaData.a()
            com.startapp.sdk.adsbase.VideoConfig r7 = r7.I()
            long r7 = r7.c()
            r5 = r7
            r7 = r3
            r9 = 1024(0x400, double:5.06E-321)
            long r7 = r7 / r9
            r3 = r7
            r7 = r5
            r9 = 10
            long r7 = r7 << r9
            r5 = r7
            r7 = r3
            r9 = r5
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L7f
            r7 = 1
        L75:
            if (r7 != 0) goto L7a
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r7 = com.startapp.sdk.ads.video.VideoUtil.VideoEligibility.INELIGIBLE_NO_STORAGE
            r1 = r7
        L7a:
            r7 = r1
            r0 = r7
            return r0
        L7d:
            r7 = 0
            goto L33
        L7f:
            r7 = 0
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.VideoUtil.a(android.content.Context):com.startapp.sdk.ads.video.VideoUtil$VideoEligibility");
    }

    public static void b(Context context) {
        j.b(context, "videoErrorsCount", Integer.valueOf(j.a(context, "videoErrorsCount", (Integer) 0).intValue() + 1));
    }

    public static void a(Context context, com.startapp.sdk.ads.video.a.a aVar) {
        if (aVar != null) {
            for (String str : aVar.a()) {
                com.startapp.sdk.adsbase.a.b(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        return context.getFilesDir() + "/" + str;
    }

    public final HashSet<String> a() {
        return this.d;
    }

    public final HashSet<String> b() {
        return this.e;
    }

    public final void c() {
        boolean z;
        com.iab.omid.library.startapp.b.a a = com.iab.omid.library.startapp.b.a.a();
        if (a != null) {
            for (com.iab.omid.library.startapp.adsession.b bVar : a.c()) {
                View g = bVar.g();
                if (bVar.h()) {
                    if (g != null) {
                        View view = g;
                        if (view.hasWindowFocus()) {
                            HashSet hashSet = new HashSet();
                            while (true) {
                                if (view == null) {
                                    this.c.addAll(hashSet);
                                    z = true;
                                    break;
                                } else if (!com.iab.omid.library.startapp.d.c.c(view)) {
                                    z = false;
                                    break;
                                } else {
                                    hashSet.add(view);
                                    ViewParent parent = view.getParent();
                                    view = parent instanceof View ? (View) parent : null;
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            this.d.add(bVar.f());
                            this.a.put(g, bVar.f());
                            a(bVar);
                        }
                    }
                    this.e.add(bVar.f());
                }
            }
        }
    }

    private void a(com.iab.omid.library.startapp.adsession.b bVar) {
        for (com.iab.omid.library.startapp.e.a aVar : bVar.c()) {
            View view = (View) aVar.get();
            if (view != null) {
                ArrayList<String> arrayList = this.b.get(view);
                ArrayList<String> arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(view, arrayList2);
                }
                arrayList2.add(bVar.f());
            }
        }
    }

    public final void d() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f = false;
    }

    public final void e() {
        this.f = true;
    }

    public final String a(View view) {
        if (this.a.size() == 0) {
            return null;
        }
        String str = this.a.get(view);
        if (str != null) {
            this.a.remove(view);
        }
        return str;
    }

    public final ArrayList<String> b(View view) {
        if (this.b.size() == 0) {
            return null;
        }
        ArrayList<String> arrayList = this.b.get(view);
        if (arrayList != null) {
            this.b.remove(view);
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public final com.iab.omid.library.startapp.walking.c c(View view) {
        return this.c.contains(view) ? com.iab.omid.library.startapp.walking.c.PARENT_VIEW : this.f ? com.iab.omid.library.startapp.walking.c.OBSTRUCTION_VIEW : com.iab.omid.library.startapp.walking.c.UNDERLYING_VIEW;
    }
}
