package com.startapp.sdk.ads.list3d;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
final class i extends a implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() { // from class: com.startapp.sdk.ads.list3d.i.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ i[] newArray(int i) {
            return new i[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }
    };
    private float c;
    private float d;

    public i() {
        this.c = 0.9f;
        this.d = 0.6f;
    }

    @Override // com.startapp.sdk.ads.list3d.a
    protected final void a(int i) {
        this.b += d() * this.d;
        this.a += (this.b * i) / 1000.0f;
        this.b *= this.c;
    }

    @Override // com.startapp.sdk.ads.list3d.a, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.startapp.sdk.ads.list3d.a, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
    }

    public i(Parcel parcel) {
        super(parcel);
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
    }

    @Override // com.startapp.sdk.ads.list3d.a
    public final void a(double d) {
        super.a(d);
    }

    @Override // com.startapp.sdk.ads.list3d.a
    public final String toString() {
        return super.toString() + ", Friction: [" + this.c + "], Snap:[" + this.d + "]";
    }
}
