package com.startapp.networkTest.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PublicKey;
import java.security.Signature;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class b {
    static {
        b.class.getSimpleName();
    }

    public static void a() {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(com.startapp.networkTest.c.d().m().replace("[PROJECTID]", com.startapp.networkTest.c.d().a())).openConnection();
            httpURLConnection2.setRequestMethod("GET");
            httpURLConnection2.setConnectTimeout(10000);
            httpURLConnection2.setReadTimeout(10000);
            long h = com.startapp.networkTest.c.c().h();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            httpURLConnection2.setRequestProperty("If-Modified-Since", simpleDateFormat.format(Long.valueOf(h)));
            httpURLConnection2.setRequestProperty("Connection", "close");
            if (httpURLConnection2.getResponseCode() == 304) {
                com.startapp.networkTest.c.c().e(com.startapp.networkTest.e.b.b());
            } else if (httpURLConnection2.getResponseCode() == 200) {
                long lastModified = httpURLConnection2.getLastModified();
                InputStream inputStream = httpURLConnection2.getInputStream();
                try {
                    if (!a(inputStream)) {
                        throw new IOException("Verification of downloaded cdn config failed");
                    }
                    com.startapp.networkTest.c.c().e(com.startapp.networkTest.e.b.b());
                    com.startapp.networkTest.c.c().d(lastModified);
                } finally {
                    inputStream.close();
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (IOException e) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static boolean a(InputStream inputStream) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byte[] bArr = new byte[512];
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                } else if (!nextEntry.isDirectory()) {
                    if (nextEntry.getName().equalsIgnoreCase("cdnconfig.txt")) {
                        for (int read = zipInputStream.read(bArr); read != -1; read = zipInputStream.read(bArr)) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        zipInputStream.closeEntry();
                    } else if (nextEntry.getName().equalsIgnoreCase("cdnconfig.txt.sig")) {
                        for (int read2 = zipInputStream.read(bArr); read2 != -1; read2 = zipInputStream.read(bArr)) {
                            byteArrayOutputStream2.write(bArr, 0, read2);
                        }
                        byteArrayOutputStream2.flush();
                        zipInputStream.closeEntry();
                    }
                }
            } finally {
                zipInputStream.close();
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        boolean z = true;
        if (com.startapp.networkTest.c.d().n()) {
            z = a(byteArrayOutputStream, byteArrayOutputStream2);
        }
        if (z && ((com.startapp.networkTest.d.a.a) com.startapp.common.parser.b.a(new String(byteArrayOutputStream.toByteArray(), "UTF-8"), com.startapp.networkTest.d.a.a.class)) != null) {
            com.startapp.networkTest.d c = com.startapp.networkTest.c.c();
            c.a((Set<String>) null);
            c.c(new HashSet((Collection) null));
            c.k();
            c.d(new HashSet((Collection) null));
            c.n();
        }
        return z;
    }

    private static boolean a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        try {
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify((PublicKey) null);
            signature.update(byteArray2);
            return signature.verify(byteArray);
        } catch (Exception e) {
            return false;
        }
    }
}
