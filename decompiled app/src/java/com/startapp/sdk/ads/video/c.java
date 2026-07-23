package com.startapp.sdk.ads.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class c {
    private boolean a;
    private VideoPlayerInterface.c b;
    private String c;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        void a(String str);
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private c() {
        this.a = true;
        this.b = null;
        this.c = null;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    static class b {
        private static final c a = new c((byte) 0);
    }

    public static c a() {
        return b.a;
    }

    public final void a(VideoPlayerInterface.c cVar) {
        this.b = cVar;
    }

    public final String a(Context context, URL url, String str, final a aVar) {
        String str2;
        File file;
        int read;
        new StringBuilder("Downloading video from ").append(url);
        this.c = url.toString();
        this.a = true;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fileOutputStream = null;
        boolean z = false;
        int l = AdsCommonMetaData.a().I().l();
        try {
            try {
                str2 = VideoUtil.a(context, str);
                file = new File(str2);
            } catch (Exception e) {
                new StringBuilder("Error downloading video from ").append(url);
                new File(VideoUtil.a(context, (String) null)).delete();
                str2 = null;
                try {
                    this.c = null;
                    inputStream.close();
                    dataInputStream.close();
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
            }
            if (file.exists()) {
                try {
                    this.c = null;
                    InputStream inputStream2 = null;
                    inputStream2.close();
                    DataInputStream dataInputStream2 = null;
                    dataInputStream2.close();
                    FileOutputStream fileOutputStream2 = null;
                    fileOutputStream2.close();
                } catch (Exception e3) {
                }
                return str2;
            }
            URLConnection openConnection = url.openConnection();
            openConnection.connect();
            int contentLength = openConnection.getContentLength();
            int i = 0;
            InputStream inputStream3 = openConnection.getInputStream();
            DataInputStream dataInputStream3 = new DataInputStream(inputStream3);
            byte[] bArr = new byte[4096];
            int i2 = 0;
            String str3 = str + ".temp";
            final String str4 = str2 + ".temp";
            FileOutputStream openFileOutput = context.openFileOutput(str3, 0);
            while (true) {
                read = dataInputStream3.read(bArr);
                if (read <= 0 || !this.a) {
                    break;
                }
                openFileOutput.write(bArr, 0, read);
                int i3 = i + read;
                i = i3;
                final int i4 = (int) ((i3 * 100.0d) / contentLength);
                if (i4 >= l) {
                    if (!z && aVar != null) {
                        z = true;
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.ads.video.c.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                aVar.a(str4);
                            }
                        });
                    }
                    if (i4 >= i2 + 1) {
                        if (this.b != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.ads.video.c.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (c.this.b != null) {
                                        c.this.b.g(i4);
                                    }
                                }
                            });
                        }
                        i2 = i4;
                    }
                }
            }
            if (this.a || read <= 0) {
                a(new File(VideoUtil.a(context, str3)), file);
                try {
                    this.c = null;
                    inputStream3.close();
                    dataInputStream3.close();
                    openFileOutput.close();
                } catch (Exception e4) {
                }
                return str2;
            }
            new File(VideoUtil.a(context, str3)).delete();
            try {
                this.c = null;
                inputStream3.close();
                dataInputStream3.close();
                openFileOutput.close();
            } catch (Exception e5) {
            }
            return "downloadInterrupted";
        } catch (Throwable th) {
            try {
                this.c = null;
                inputStream.close();
                dataInputStream.close();
                fileOutputStream.close();
            } catch (Exception e6) {
            }
            throw th;
        }
    }

    public final void a(String str) {
        if (str != null && str.equals(this.c)) {
            this.a = false;
        }
    }

    private static void a(File file, File file2) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        fileInputStream.close();
                        fileOutputStream.close();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception e4) {
            }
            throw th;
        }
    }

    public static boolean b(String str) {
        return str != null && str.endsWith(".temp");
    }

    public static void c(String str) {
        if (b(str)) {
            new File(str).delete();
        }
    }
}
