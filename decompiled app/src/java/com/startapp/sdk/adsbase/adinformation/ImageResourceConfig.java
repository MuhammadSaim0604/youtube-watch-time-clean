package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import android.graphics.Bitmap;
import com.startapp.common.a;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class ImageResourceConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private transient Bitmap a;
    private transient Bitmap b;
    private String name;
    private String imageUrlSecured = "";
    private String imageFallbackUrl = "";
    private transient Bitmap c = null;
    private int width = 1;
    private int height = 1;

    private ImageResourceConfig() {
    }

    public final String a() {
        return this.name;
    }

    public final Bitmap a(Context context) {
        if (this.c == null) {
            this.c = this.a;
            if (this.c == null) {
                if (this.b == null) {
                    this.b = com.startapp.sdk.adsbase.j.a.a(context, this.imageFallbackUrl);
                }
                this.c = this.b;
            }
        }
        return this.c;
    }

    public final int b() {
        return this.width;
    }

    public final int c() {
        return this.height;
    }

    public final void a(int i) {
        this.width = i;
    }

    public final void b(int i) {
        this.height = i;
    }

    public final String d() {
        return this.imageUrlSecured != null ? this.imageUrlSecured : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        a((Bitmap) null);
        new com.startapp.common.a(d(), new a.InterfaceC0015a() { // from class: com.startapp.sdk.adsbase.adinformation.ImageResourceConfig.1
            @Override // com.startapp.common.a.InterfaceC0015a
            public final void a(Bitmap bitmap, int i) {
                ImageResourceConfig.this.a(bitmap);
            }
        }, 0).a();
    }

    public final void a(String str) {
        this.imageFallbackUrl = str;
    }

    protected final void a(Bitmap bitmap) {
        this.a = bitmap;
        if (bitmap != null) {
            this.c = bitmap;
        }
    }

    public static ImageResourceConfig b(String str) {
        ImageResourceConfig imageResourceConfig = new ImageResourceConfig();
        imageResourceConfig.name = str;
        return imageResourceConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageResourceConfig imageResourceConfig = (ImageResourceConfig) obj;
        return this.width == imageResourceConfig.width && this.height == imageResourceConfig.height && u.b(this.imageUrlSecured, imageResourceConfig.imageUrlSecured) && u.b(this.imageFallbackUrl, imageResourceConfig.imageFallbackUrl) && u.b(this.name, imageResourceConfig.name);
    }

    public int hashCode() {
        return u.a(this.imageUrlSecured, this.imageFallbackUrl, Integer.valueOf(this.width), Integer.valueOf(this.height), this.name);
    }
}
