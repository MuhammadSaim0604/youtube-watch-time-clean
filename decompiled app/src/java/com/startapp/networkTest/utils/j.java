package com.startapp.networkTest.utils;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PublicKey;
import java.security.Signature;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class j {
    static {
        j.class.getSimpleName();
    }

    /* JADX WARN: Finally extract failed */
    public static boolean a(Context context) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(com.startapp.networkTest.c.d().i().replace("[PROJECTID]", com.startapp.networkTest.c.d().a())).openConnection();
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(10000);
                long e = com.startapp.networkTest.c.c().e();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                httpURLConnection2.setRequestProperty("If-Modified-Since", simpleDateFormat.format(Long.valueOf(e)));
                httpURLConnection2.setRequestProperty("Connection", "close");
                if (httpURLConnection2.getResponseCode() == 304) {
                    com.startapp.networkTest.c.c().b(com.startapp.networkTest.e.b.b());
                } else if (httpURLConnection2.getResponseCode() == 200) {
                    long lastModified = httpURLConnection2.getLastModified();
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    try {
                        a(inputStream, d(context));
                        inputStream.close();
                        boolean z = true;
                        if (com.startapp.networkTest.c.d().j()) {
                            z = a(new File(d(context), "truststore.bin"), new File(d(context), "truststore.bin.sig"));
                        }
                        if (z) {
                            if (new File(d(context), "truststore.bin").renameTo(b(context)) && new File(d(context), "truststore.bin.sig").renameTo(c(context))) {
                                com.startapp.networkTest.c.c().b(com.startapp.networkTest.e.b.b());
                                com.startapp.networkTest.c.c().c(lastModified);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return true;
                            }
                            throw new IOException("Moving of cached files failed.");
                        }
                        throw new IOException("Verification of downloaded truststore failed");
                    } catch (Throwable th) {
                        inputStream.close();
                        throw th;
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (IOException e2) {
                File file = new File(d(context), "truststore.bin");
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(d(context), "truststore.bin.sig");
                if (file2.exists()) {
                    file2.delete();
                }
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
            }
            return false;
        } catch (Throwable th2) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    public static File b(Context context) {
        File file = new File(context.getFilesDir() + "/insight/truststore/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "truststore.bin");
    }

    public static File c(Context context) {
        File file = new File(context.getFilesDir() + "/insight/truststore/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "truststore.bin.sig");
    }

    private static File d(Context context) {
        File file = new File(context.getCacheDir() + "/insight/truststore/", "truststoreunzip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void a(InputStream inputStream, File file) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (nextEntry.isDirectory()) {
                        File file2 = new File(file + File.separator + nextEntry.getName());
                        if (!file2.isDirectory()) {
                            file2.mkdirs();
                        }
                    } else {
                        FileOutputStream fileOutputStream = new FileOutputStream(file + File.separator + nextEntry.getName());
                        for (int read = zipInputStream.read(); read != -1; read = zipInputStream.read()) {
                            fileOutputStream.write(read);
                        }
                        zipInputStream.closeEntry();
                        fileOutputStream.close();
                    }
                } else {
                    return;
                }
            } finally {
                zipInputStream.close();
            }
        }
    }

    public static boolean a(File file, File file2) {
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[512];
            for (int read = fileInputStream.read(bArr); read != -1; read = fileInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            fileInputStream2 = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            for (int read2 = fileInputStream2.read(bArr); read2 != -1; read2 = fileInputStream2.read(bArr)) {
                byteArrayOutputStream2.write(bArr, 0, read2);
            }
            byteArrayOutputStream2.flush();
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify((PublicKey) null);
            signature.update(byteArray2);
            boolean verify = signature.verify(byteArray);
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return verify;
        } catch (Exception e3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
    }
}
