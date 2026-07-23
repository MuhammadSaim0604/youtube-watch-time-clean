package com.startapp.sdk.ads.banner.banner3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.startapp.common.a;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.h;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class a implements Parcelable, a.InterfaceC0015a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.startapp.sdk.ads.banner.banner3d.a.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    private AdDetails a;
    private Point b;
    private Bitmap c;
    private Bitmap d;
    private AtomicBoolean e;
    private TrackingParams f;
    private h g;
    private Banner3DView h;

    public a(Context context, ViewGroup viewGroup, AdDetails adDetails, BannerOptions bannerOptions, TrackingParams trackingParams) {
        this.c = null;
        this.d = null;
        this.e = new AtomicBoolean(false);
        this.g = null;
        this.h = null;
        this.a = adDetails;
        this.f = trackingParams;
        a(context, bannerOptions, viewGroup);
    }

    public final Bitmap a() {
        return this.d;
    }

    public final void a(Context context, BannerOptions bannerOptions, ViewGroup viewGroup) {
        int a = t.a(context, bannerOptions.e() - 5);
        this.b = new Point((int) (t.a(context, bannerOptions.d()) * bannerOptions.j()), (int) (t.a(context, bannerOptions.e()) * bannerOptions.k()));
        this.h = new Banner3DView(context, new Point(bannerOptions.d(), bannerOptions.e()));
        this.h.setText(this.a.f());
        this.h.setRating(this.a.k());
        this.h.setDescription(this.a.g());
        this.h.setButtonText(this.a.r());
        if (this.c != null) {
            this.h.setImage(this.c, a, a);
        } else {
            this.h.setImage(17301651, a, a);
            new com.startapp.common.a(this.a.h(), this, 0).a();
            new StringBuilder(" Banner Face Image Async Request: [").append(this.a.f()).append("]");
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b.x, this.b.y);
        layoutParams.addRule(13);
        viewGroup.addView(this.h, layoutParams);
        this.h.setVisibility(8);
        d();
    }

    private void d() {
        this.d = a(this.h);
        if (this.b.x > 0 && this.b.y > 0) {
            this.d = Bitmap.createScaledBitmap(this.d, this.b.x, this.b.y, false);
        }
    }

    private static Bitmap a(View view) {
        view.measure(view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return createBitmap;
    }

    @Override // com.startapp.common.a.InterfaceC0015a
    public final void a(Bitmap bitmap, int i) {
        if (bitmap != null && this.h != null) {
            this.c = bitmap;
            this.h.setImage(bitmap);
            d();
        }
    }

    public final h a(Context context) {
        long millis;
        if (this.a.d() != null && this.e.compareAndSet(false, true)) {
            String[] strArr = {this.a.d()};
            TrackingParams trackingParams = this.f;
            if (this.a.y() != null) {
                millis = TimeUnit.SECONDS.toMillis(this.a.y().longValue());
            } else {
                millis = TimeUnit.SECONDS.toMillis(MetaData.E().F());
            }
            this.g = new h(context, strArr, trackingParams, millis);
            return this.g;
        }
        return null;
    }

    public final void b() {
        if (this.g != null) {
            this.g.a(false);
        }
    }

    public final void b(Context context) {
        String q = this.a.q();
        boolean a = com.startapp.sdk.adsbase.a.a(context, AdPreferences.Placement.INAPP_BANNER);
        if (this.g != null) {
            this.g.a(true);
        }
        if (q != null && !"null".equals(q) && !TextUtils.isEmpty(q)) {
            com.startapp.sdk.adsbase.a.a(q, this.a.p(), this.a.c(), context, this.f);
        } else if (!this.a.l() || a) {
            com.startapp.sdk.adsbase.a.a(context, this.a.c(), this.a.e(), this.f, this.a.w() && !a, false);
        } else {
            com.startapp.sdk.adsbase.a.a(context, this.a.c(), this.a.e(), this.a.n(), this.f, AdsCommonMetaData.a().B(), AdsCommonMetaData.a().C(), this.a.w(), this.a.z());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeInt(this.b.x);
        parcel.writeInt(this.b.y);
        parcel.writeParcelable(this.c, i);
        parcel.writeBooleanArray(new boolean[]{this.e.get()});
        parcel.writeSerializable(this.f);
    }

    public a(Parcel parcel) {
        this.c = null;
        this.d = null;
        this.e = new AtomicBoolean(false);
        this.g = null;
        this.h = null;
        this.a = (AdDetails) parcel.readParcelable(AdDetails.class.getClassLoader());
        this.b = new Point(1, 1);
        this.b.x = parcel.readInt();
        this.b.y = parcel.readInt();
        this.c = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.e.set(zArr[0]);
        this.f = (TrackingParams) parcel.readSerializable();
    }

    public final void c() {
        a(this.c);
        a(this.d);
        this.c = null;
        this.d = null;
        if (this.g != null) {
            this.g.a(false);
        }
        if (this.h != null) {
            this.h.removeAllViews();
            this.h = null;
        }
    }

    private static void a(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.recycle();
        }
    }
}
