package com.startapp.b.a.c;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class d {
    static {
        char c = File.separatorChar;
        PrintWriter printWriter = new PrintWriter(new f((byte) 0));
        printWriter.println();
        printWriter.close();
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
