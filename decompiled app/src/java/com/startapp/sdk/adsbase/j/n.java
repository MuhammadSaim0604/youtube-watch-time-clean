package com.startapp.sdk.adsbase.j;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class n {
    private static boolean a = true;

    public static void a(Context context, boolean z) {
        if (z) {
            a = true;
            com.startapp.sdk.adsbase.j.b(context, "copyDrawables", Boolean.TRUE);
        }
        if (a) {
            boolean booleanValue = com.startapp.sdk.adsbase.j.a(context, "copyDrawables", Boolean.TRUE).booleanValue();
            a = booleanValue;
            if (booleanValue) {
                try {
                    String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
                    String a2 = a(context);
                    if (!a(context, str, "", "drawable-hdpi.zip") && !a(context, str, "assets/", "drawable-hdpi.zip") && !a(context, a2, "", "drawable-hdpi.zip")) {
                        a(context, a2, "assets/", "drawable-hdpi.zip");
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private static String a(Context context) {
        String str = Environment.getExternalStorageDirectory() + "/Android/obb/" + context.getPackageName() + "/";
        String str2 = "main.1." + context.getPackageName() + ".obb";
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            final Pattern compile = Pattern.compile("main[.][1-9][0-9]*[.]" + context.getPackageName() + "[.]obb");
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.startapp.sdk.adsbase.j.n.1
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return compile.matcher(file2.getName()).matches();
                }
            });
            if (listFiles.length > 0) {
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    try {
                        int parseInt = Integer.parseInt(listFiles[i3].getName().split("[.]")[1]);
                        if (parseInt > i2) {
                            i2 = parseInt;
                            i = i3;
                        }
                    } catch (Exception e) {
                    }
                }
                str2 = listFiles[i].getName();
            }
        }
        return str + str2;
    }

    private static boolean a(Context context, String str, String str2, String str3) {
        new StringBuilder("Trying to copy resources from ").append(str).append(" in /").append(str2);
        if (!a(str, str2 + str3, context.getFilesDir().getPath() + "/" + str3)) {
            new StringBuilder("Failed copying resources from ").append(str).append(" in /").append(str2);
            return false;
        }
        a(context, context.getFilesDir().getPath() + "/" + str3);
        a(str, str2 + "drawable.zip", context.getFilesDir().getPath() + "/drawable.zip");
        a(context, context.getFilesDir().getPath() + "/drawable.zip");
        com.startapp.sdk.adsbase.j.b(context, "copyDrawables", Boolean.FALSE);
        new StringBuilder("Copy from ").append(str).append(" in /").append(str2).append(" succeeded");
        return true;
    }

    private static boolean a(String str, String str2, String str3) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                zipFile = zipFile2;
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                ZipEntry zipEntry = null;
                while (true) {
                    if (!entries.hasMoreElements()) {
                        break;
                    }
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory() && nextElement.getName().equals(str2)) {
                        zipEntry = nextElement;
                        break;
                    }
                }
                if (zipEntry == null) {
                    try {
                        zipFile.close();
                    } catch (Exception e) {
                    }
                    return false;
                }
                inputStream = zipFile.getInputStream(zipEntry);
                fileOutputStream = new FileOutputStream(str3);
                byte[] bArr = new byte[256];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                try {
                    inputStream.close();
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
                return true;
            } finally {
                try {
                    zipFile.close();
                } catch (Exception e3) {
                }
            }
        } catch (IOException e4) {
            try {
                inputStream.close();
                fileOutputStream.close();
            } catch (Exception e5) {
            }
            try {
                zipFile.close();
            } catch (Exception e6) {
            }
            return false;
        }
    }

    private static void a(Context context, String str) {
        ZipEntry zipEntry;
        byte[] bArr = new byte[1024];
        ZipInputStream zipInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(str));
            zipInputStream = zipInputStream2;
            ZipEntry nextEntry = zipInputStream2.getNextEntry();
            while (true) {
                if (nextEntry == null) {
                    break;
                }
                fileOutputStream = new FileOutputStream(context.getFilesDir().getPath() + "/" + zipEntry.getName());
                while (true) {
                    int read = zipInputStream.read(bArr, 0, 1024);
                    if (read < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
            }
            try {
                zipInputStream.close();
            } catch (IOException e2) {
            }
        } catch (FileNotFoundException e3) {
            try {
                fileOutputStream.close();
            } catch (IOException e4) {
            }
            try {
                zipInputStream.close();
            } catch (IOException e5) {
            }
        } catch (IOException e6) {
            try {
                fileOutputStream.close();
            } catch (IOException e7) {
            }
            try {
                zipInputStream.close();
            } catch (IOException e8) {
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (IOException e9) {
            }
            try {
                zipInputStream.close();
            } catch (IOException e10) {
            }
            throw th;
        }
    }
}
