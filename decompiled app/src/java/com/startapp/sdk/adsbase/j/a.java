package com.startapp.sdk.adsbase.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.startapp.common.ThreadManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private static final Map<String, Bitmap> a = new ConcurrentHashMap();

    private static Bitmap a(Context context, String str, boolean z) {
        Bitmap bitmap = a.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        n.a(context, z);
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(context.getFilesDir().getPath() + "/" + str);
            fileInputStream = fileInputStream2;
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2);
            decodeStream.setDensity(context.getResources() != null ? context.getResources().getDisplayMetrics().densityDpi : 160);
            a.put(str, decodeStream);
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
            return decodeStream;
        } catch (Exception e2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
            }
            return null;
        } catch (Throwable th) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }

    public static Bitmap a(Context context, String str) {
        Bitmap a2 = a(context, str, false);
        Bitmap bitmap = a2;
        if (a2 == null) {
            bitmap = a(context, str, true);
        }
        return bitmap;
    }

    public static void a(final Context context, final Bitmap bitmap, final String str, final String str2) {
        ThreadManager.a(ThreadManager.Priority.DEFAULT, new Runnable() { // from class: com.startapp.sdk.adsbase.j.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.a.put(str + str2, bitmap);
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(context.getFilesDir().getPath() + "/" + str + str2);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public static boolean a(Context context, String str, String str2) {
        String str3 = str;
        boolean z = true;
        if (!str3.endsWith(str2)) {
            str3 = str3 + str2;
        }
        if (!a.containsKey(str3) && !new File(context.getFilesDir().getPath() + "/" + str3).exists()) {
            z = false;
        }
        return z;
    }
}
