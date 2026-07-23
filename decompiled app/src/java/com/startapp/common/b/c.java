package com.startapp.common.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class c {
    public static Bitmap a(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable a(Resources resources, String str) {
        return new BitmapDrawable(resources, a(str));
    }

    public static Bitmap b(String str) {
        Bitmap bitmap = null;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection = httpURLConnection2;
            httpURLConnection2.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bitmap = BitmapFactory.decodeStream(new a(inputStream));
            bufferedInputStream.close();
            inputStream.close();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        return bitmap;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    static class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final long skip(long j) throws IOException {
            long j2;
            long j3 = 0;
            while (true) {
                j2 = j3;
                if (j2 >= j) {
                    break;
                }
                long skip = this.in.skip(j - j2);
                long j4 = skip;
                if (skip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    j4 = 1;
                }
                j3 = j2 + j4;
            }
            return j2;
        }
    }
}
