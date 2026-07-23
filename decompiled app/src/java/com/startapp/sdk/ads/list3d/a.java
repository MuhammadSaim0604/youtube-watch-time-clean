package com.startapp.sdk.ads.list3d;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.AnimationUtils;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class a implements Parcelable {
    protected float a;
    protected float b;
    private float c;
    private float d;
    private long e;

    protected abstract void a(int i);

    public a() {
        this.c = Float.MAX_VALUE;
        this.d = -3.4028235E38f;
        this.e = 0L;
    }

    public a(Parcel parcel) {
        this.c = Float.MAX_VALUE;
        this.d = -3.4028235E38f;
        this.e = 0L;
        this.a = parcel.readFloat();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void a(float f, float f2, long j) {
        this.b = f2;
        this.a = f;
        this.e = j;
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final boolean c() {
        return ((Math.abs(this.b) > 0.5f ? 1 : (Math.abs(this.b) == 0.5f ? 0 : -1)) < 0) && (((this.a - 0.4f) > this.c ? 1 : ((this.a - 0.4f) == this.c ? 0 : -1)) < 0 && ((this.a + 0.4f) > this.d ? 1 : ((this.a + 0.4f) == this.d ? 0 : -1)) > 0);
    }

    public final void a(float f) {
        this.c = f;
    }

    public final void b(float f) {
        this.d = f;
    }

    public final void a(long j) {
        if (this.e != 0) {
            int i = (int) (j - this.e);
            int i2 = i;
            if (i > 50) {
                i2 = 50;
            }
            a(i2);
        }
        this.e = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float d() {
        float f = 0.0f;
        if (this.a > this.c) {
            f = this.c - this.a;
        } else if (this.a < this.d) {
            f = this.d - this.a;
        }
        return f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
    }

    public void a(double d) {
        this.a = (float) (this.a * d);
    }

    public String toString() {
        return "Position: [" + this.a + "], Velocity:[" + this.b + "], MaxPos: [" + this.c + "], mMinPos: [" + this.d + "] LastTime:[" + this.e + "]";
    }
}
