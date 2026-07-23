package com.startapp.sdk.ads.list3d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.startapp.sdk.adsbase.model.AdDetails;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.startapp.sdk.ads.list3d.d.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ d[] newArray(int i) {
            return new d[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }
    };
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private float j;
    private boolean k;
    private boolean l;
    private Drawable m;
    private String n;
    private String o;
    private Long p;
    private Boolean q;
    private String r;

    public d(AdDetails adDetails) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = 0.0f;
        this.k = false;
        this.l = true;
        this.m = null;
        this.q = null;
        this.r = "";
        this.a = adDetails.a();
        this.b = adDetails.c();
        this.c = adDetails.d();
        this.d = adDetails.e();
        this.e = adDetails.b();
        this.f = adDetails.n();
        this.g = adDetails.f();
        this.h = adDetails.g();
        this.i = adDetails.h();
        this.j = adDetails.k();
        this.k = adDetails.l();
        this.l = adDetails.w();
        this.m = null;
        this.r = adDetails.m();
        this.n = adDetails.p();
        this.o = adDetails.q();
        this.p = adDetails.y();
        this.q = adDetails.z();
    }

    public d(Parcel parcel) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = 0.0f;
        this.k = false;
        this.l = true;
        this.m = null;
        this.q = null;
        this.r = "";
        if (parcel.readInt() == 1) {
            this.m = new BitmapDrawable((Bitmap) Bitmap.CREATOR.createFromParcel(parcel));
        } else {
            this.m = null;
        }
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readFloat();
        if (parcel.readInt() == 1) {
            this.k = true;
        } else {
            this.k = false;
        }
        if (parcel.readInt() == 0) {
            this.l = false;
        } else {
            this.l = true;
        }
        this.r = parcel.readString();
        this.o = parcel.readString();
        this.n = parcel.readString();
        this.p = Long.valueOf(parcel.readLong());
        if (this.p.longValue() == -1) {
            this.p = null;
        }
        int readInt = parcel.readInt();
        if (readInt == 0) {
            this.q = null;
        } else {
            this.q = Boolean.valueOf(readInt == 1);
        }
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.d;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final float j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final boolean l() {
        return this.l;
    }

    public final String m() {
        return this.r;
    }

    public final String n() {
        return this.n;
    }

    public final String o() {
        return this.o;
    }

    public final boolean p() {
        return this.o != null;
    }

    public final Long q() {
        return this.p;
    }

    public final Boolean r() {
        return this.q;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2;
        int i2;
        if (this.m != null) {
            parcel.writeParcelable(((BitmapDrawable) this.m).getBitmap(), i);
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeFloat(this.j);
        int i3 = 0;
        if (this.k) {
            i3 = 1;
        }
        parcel.writeInt(i3);
        int i4 = 1;
        if (!this.l) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        parcel.writeString(this.r);
        parcel.writeString(this.o);
        parcel.writeString(this.n);
        if (this.p == null) {
            parcel.writeLong(-1L);
        } else {
            parcel.writeLong(this.p.longValue());
        }
        if (this.q == null) {
            parcel2 = parcel;
            i2 = 0;
        } else {
            parcel2 = parcel;
            i2 = this.q.booleanValue() ? 1 : -1;
        }
        parcel2.writeInt(i2);
    }
}
