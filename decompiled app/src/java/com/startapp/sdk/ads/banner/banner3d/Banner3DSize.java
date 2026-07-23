package com.startapp.sdk.ads.banner.banner3d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.ads.banner.c;
import com.startapp.sdk.adsbase.infoevents.e;
import com.startapp.sdk.adsbase.j.t;
import org.json.JSONObject;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class Banner3DSize {
    private final com.iab.omid.library.startapp.adsession.b a;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Size {
        XXSMALL(new c(280, 50)),
        XSMALL(new c(300, 50)),
        SMALL(new c(320, 50)),
        MEDIUM(new c(468, 60)),
        LARGE(new c(728, 90)),
        XLARGE(new c(1024, 90));
        
        private c size;

        Size(c cVar) {
            this.size = cVar;
        }

        public final c getSize() {
            return this.size;
        }
    }

    public static boolean a(Context context, ViewParent viewParent, BannerOptions bannerOptions, Banner3D banner3D, c cVar) {
        Size[] values;
        c a = a(context, viewParent, bannerOptions, banner3D);
        cVar.a(a.a(), a.b());
        boolean z = false;
        for (Size size : Size.values()) {
            if (size.getSize().a() <= a.a() && size.getSize().b() <= a.b()) {
                new StringBuilder("BannerSize [").append(size.getSize().a()).append(",").append(size.getSize().b()).append("]");
                bannerOptions.a(size.getSize().a(), size.getSize().b());
                z = true;
            }
        }
        if (!z) {
            bannerOptions.a(0, 0);
        }
        new StringBuilder("============== Optimize Size [").append(z).append("] ==========");
        return z;
    }

    private static c a(Context context, ViewParent viewParent, BannerOptions bannerOptions, Banner3D banner3D) {
        Point point = new Point();
        point.x = bannerOptions.d();
        point.y = bannerOptions.e();
        if (banner3D.getLayoutParams() != null && banner3D.getLayoutParams().width > 0) {
            point.x = t.b(context, banner3D.getLayoutParams().width + 1);
        }
        if (banner3D.getLayoutParams() != null && banner3D.getLayoutParams().height > 0) {
            point.y = t.b(context, banner3D.getLayoutParams().height + 1);
        }
        if (banner3D.getLayoutParams() == null || banner3D.getLayoutParams().width <= 0 || banner3D.getLayoutParams().height <= 0) {
            if (context instanceof Activity) {
                View decorView = ((Activity) context).getWindow().getDecorView();
                try {
                    View view = (View) viewParent;
                    View view2 = view;
                    if (view instanceof Banner) {
                        view2 = (View) view2.getParent();
                    }
                    boolean z = false;
                    boolean z2 = false;
                    while (view2 != null && (view2.getMeasuredWidth() <= 0 || view2.getMeasuredHeight() <= 0)) {
                        if (view2.getMeasuredWidth() > 0 && !z) {
                            z = true;
                            b(context, point, view2);
                        }
                        if (view2.getMeasuredHeight() > 0 && !z2) {
                            z2 = true;
                            a(context, point, view2);
                        }
                        view2 = (View) view2.getParent();
                    }
                    if (view2 == null) {
                        c(context, point, decorView);
                    } else {
                        if (!z) {
                            b(context, point, view2);
                        }
                        if (!z2) {
                            a(context, point, view2);
                        }
                    }
                } catch (Exception e) {
                    c(context, point, decorView);
                }
            } else {
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    if (windowManager != null) {
                        if (Build.VERSION.SDK_INT >= 13) {
                            windowManager.getDefaultDisplay().getSize(point);
                        } else {
                            point.x = windowManager.getDefaultDisplay().getWidth();
                            point.y = windowManager.getDefaultDisplay().getHeight();
                        }
                        point.x = t.b(context, point.x);
                        point.y = t.b(context, point.y);
                    }
                } catch (Throwable th) {
                    new e(th).a(context);
                }
            }
        }
        new StringBuilder("============ exit Application Size [").append(point.x).append(",").append(point.y).append("] =========");
        return new c(point.x, point.y);
    }

    private static void a(Context context, Point point, View view) {
        point.y = t.b(context, (view.getMeasuredHeight() - view.getPaddingBottom()) - view.getPaddingTop());
    }

    private static void b(Context context, Point point, View view) {
        point.x = t.b(context, (view.getMeasuredWidth() - view.getPaddingLeft()) - view.getPaddingRight());
    }

    private static void c(Context context, Point point, View view) {
        point.x = t.b(context, view.getMeasuredWidth());
        point.y = t.b(context, view.getMeasuredHeight());
    }

    private Banner3DSize(com.iab.omid.library.startapp.adsession.b bVar) {
        this.a = bVar;
    }

    public static Banner3DSize a(com.iab.omid.library.startapp.adsession.b bVar) {
        com.iab.omid.library.startapp.adsession.b bVar2 = bVar;
        com.iab.omid.library.startapp.b.a(bVar, "AdSession is null");
        if (bVar2.l()) {
            if (bVar2.i()) {
                throw new IllegalStateException("AdSession is started");
            }
            com.iab.omid.library.startapp.b.a(bVar2);
            if (bVar2.e().e() != null) {
                throw new IllegalStateException("VideoEvents already exists for AdSession");
            }
            Banner3DSize banner3DSize = new Banner3DSize(bVar2);
            bVar2.e().a(banner3DSize);
            return banner3DSize;
        }
        throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
    }

    public final void a(float f, float f2) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Video duration");
        }
        b(f2);
        com.iab.omid.library.startapp.b.b(this.a);
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.startapp.d.b.a(jSONObject, "duration", Float.valueOf(f));
        com.iab.omid.library.startapp.d.b.a(jSONObject, "videoPlayerVolume", Float.valueOf(f2));
        com.iab.omid.library.startapp.d.b.a(jSONObject, "deviceVolume", Float.valueOf(com.iab.omid.library.startapp.b.e.a().d()));
        this.a.e().a("start", jSONObject);
    }

    public final void a() {
        com.iab.omid.library.startapp.b.b(this.a);
        this.a.e().a("firstQuartile");
    }

    public final void b() {
        com.iab.omid.library.startapp.b.b(this.a);
        this.a.e().a("midpoint");
    }

    public final void c() {
        com.iab.omid.library.startapp.b.b(this.a);
        this.a.e().a("thirdQuartile");
    }

    public final void d() {
        com.iab.omid.library.startapp.b.b(this.a);
        this.a.e().a("complete");
    }

    public final void e() {
        com.iab.omid.library.startapp.b.b(this.a);
        this.a.e().a("pause");
    }

    public final void f() {
        com.iab.omid.library.startapp.b.b(this.a);
        this.a.e().a("bufferStart");
    }

    public final void g() {
        com.iab.omid.library.startapp.b.b(this.a);
        this.a.e().a("bufferFinish");
    }

    public final void h() {
        com.iab.omid.library.startapp.b.b(this.a);
        this.a.e().a("skipped");
    }

    public final void a(float f) {
        b(f);
        com.iab.omid.library.startapp.b.b(this.a);
        JSONObject jSONObject = new JSONObject();
        com.iab.omid.library.startapp.d.b.a(jSONObject, "videoPlayerVolume", Float.valueOf(f));
        com.iab.omid.library.startapp.d.b.a(jSONObject, "deviceVolume", Float.valueOf(com.iab.omid.library.startapp.b.e.a().d()));
        this.a.e().a("volumeChange", jSONObject);
    }

    private static void b(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Video volume");
        }
    }
}
