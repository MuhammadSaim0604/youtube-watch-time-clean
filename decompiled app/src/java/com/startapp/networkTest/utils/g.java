package com.startapp.networkTest.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class g {
    static {
        g.class.getSimpleName();
    }

    public static String[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[10240];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(str);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String[] split = new String(byteArrayOutputStream.toByteArray(), "UTF-8").split("\n");
            try {
                fileInputStream.close();
            } catch (IOException e) {
                new StringBuilder("cat: ").append(e.toString());
            }
            return split;
        } catch (Exception e2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    new StringBuilder("cat: ").append(e3.toString());
                }
            }
            return new String[0];
        } catch (Throwable th) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    new StringBuilder("cat: ").append(e4.toString());
                }
            }
            throw th;
        }
    }

    public static String[] b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Process exec = Runtime.getRuntime().exec(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            boolean z = true;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!z) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(readLine);
                z = false;
            }
            bufferedReader.close();
            exec.waitFor();
        } catch (Exception e) {
            new StringBuilder("shellResult: ").append(e.toString());
        }
        return stringBuffer.toString().split("\\n");
    }
}
