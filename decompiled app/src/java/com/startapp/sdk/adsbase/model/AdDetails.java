package com.startapp.sdk.adsbase.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdDetails implements Parcelable, Serializable {
    public static final Parcelable.Creator<AdDetails> CREATOR = new Parcelable.Creator<AdDetails>() { // from class: com.startapp.sdk.adsbase.model.AdDetails.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AdDetails[] newArray(int i) {
            return new AdDetails[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AdDetails createFromParcel(Parcel parcel) {
            return new AdDetails(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    private String adId;
    private boolean app;
    private String appPresencePackage;
    private boolean belowMinCPM;
    private String category;
    private String clickUrl;
    private String closeUrl;
    private Long delayImpressionInSeconds;
    private String description;
    private String imageUrl;
    private String installs;
    private String intentDetails;
    private String intentPackageName;
    private int minAppVersion;
    private String packageName;
    private float rating;
    private String secondaryImageUrl;
    private Boolean sendRedirectHops;
    private boolean smartRedirect;
    private boolean startappBrowserEnabled;
    private String template;
    private String title;
    private String trackingClickUrl;
    private String trackingUrl;
    private Long ttl;

    public AdDetails() {
        this.rating = 5.0f;
        this.belowMinCPM = false;
    }

    public final String a() {
        return this.adId;
    }

    public final String b() {
        return this.closeUrl;
    }

    public final String c() {
        return this.clickUrl;
    }

    public final String d() {
        return this.trackingUrl;
    }

    public final String e() {
        return this.trackingClickUrl;
    }

    public final String f() {
        return this.title;
    }

    public final String g() {
        return this.description;
    }

    public final String h() {
        return this.imageUrl;
    }

    public final boolean i() {
        return this.belowMinCPM;
    }

    public final String j() {
        return this.secondaryImageUrl;
    }

    public final float k() {
        return this.rating;
    }

    public final boolean l() {
        return this.smartRedirect;
    }

    public final String m() {
        return this.template;
    }

    public final String n() {
        return this.packageName;
    }

    public final String o() {
        return this.appPresencePackage;
    }

    public final String p() {
        return this.intentDetails;
    }

    public final String q() {
        return this.intentPackageName;
    }

    public final boolean r() {
        return this.intentPackageName != null;
    }

    public final String s() {
        return this.installs;
    }

    public final String t() {
        return this.category;
    }

    public final boolean u() {
        return this.app;
    }

    public final int v() {
        return this.minAppVersion;
    }

    public final boolean w() {
        return this.startappBrowserEnabled;
    }

    public final Long x() {
        return this.ttl;
    }

    public final Long y() {
        return this.delayImpressionInSeconds;
    }

    public final Boolean z() {
        return this.sendRedirectHops;
    }

    public String toString() {
        return "AdDetails [adId=" + this.adId + ", clickUrl=" + this.clickUrl + ", trackingUrl=" + this.trackingUrl + ", trackingClickUrl=" + this.trackingClickUrl + ", closeUrl=" + this.closeUrl + ", title=" + this.title + ", description=" + this.description + ", imageUrl=" + this.imageUrl + ", secondaryImageUrl=" + this.secondaryImageUrl + ", rating=" + this.rating + ", smartRedirect=" + this.smartRedirect + ", template=" + this.template + ", packageName=" + this.packageName + ", appPresencePackage=" + this.appPresencePackage + ", intentDetails=" + this.intentDetails + ", intentPackageName=" + this.intentPackageName + ", minAppVersion=" + this.minAppVersion + ", startappBrowserEnabled=" + this.startappBrowserEnabled + ", ttl=" + this.ttl + ", app=" + this.app + ", belowMinCPM=" + this.belowMinCPM + ", installs=" + this.installs + ", category=" + this.category + ", delayImpressionInSeconds=" + this.delayImpressionInSeconds + ", sendRedirectHops=" + this.sendRedirectHops + "]";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AdDetails(Parcel parcel) {
        this.rating = 5.0f;
        this.belowMinCPM = false;
        this.adId = parcel.readString();
        this.clickUrl = parcel.readString();
        this.trackingUrl = parcel.readString();
        this.trackingClickUrl = parcel.readString();
        this.closeUrl = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.imageUrl = parcel.readString();
        this.secondaryImageUrl = parcel.readString();
        this.rating = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        this.smartRedirect = false;
        if (readInt == 1) {
            this.smartRedirect = true;
        }
        this.startappBrowserEnabled = true;
        if (readInt2 == 0) {
            this.startappBrowserEnabled = false;
        }
        this.template = parcel.readString();
        this.packageName = parcel.readString();
        this.appPresencePackage = parcel.readString();
        this.intentPackageName = parcel.readString();
        this.intentDetails = parcel.readString();
        this.minAppVersion = parcel.readInt();
        this.installs = parcel.readString();
        this.category = parcel.readString();
        int readInt3 = parcel.readInt();
        this.app = false;
        if (readInt3 == 1) {
            this.app = true;
        }
        int readInt4 = parcel.readInt();
        this.belowMinCPM = false;
        if (readInt4 == 1) {
            this.belowMinCPM = true;
        }
        this.ttl = Long.valueOf(parcel.readLong());
        if (this.ttl.longValue() == -1) {
            this.ttl = null;
        }
        this.delayImpressionInSeconds = Long.valueOf(parcel.readLong());
        if (this.delayImpressionInSeconds.longValue() == -1) {
            this.delayImpressionInSeconds = null;
        }
        int readInt5 = parcel.readInt();
        if (readInt5 == 0) {
            this.sendRedirectHops = null;
        } else {
            this.sendRedirectHops = Boolean.valueOf(readInt5 == 1);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2;
        int i2;
        parcel.writeString(this.adId);
        parcel.writeString(this.clickUrl);
        parcel.writeString(this.trackingUrl);
        parcel.writeString(this.trackingClickUrl);
        parcel.writeString(this.closeUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.secondaryImageUrl);
        parcel.writeFloat(this.rating);
        int i3 = 0;
        int i4 = 1;
        if (this.smartRedirect) {
            i3 = 1;
        }
        if (!this.startappBrowserEnabled) {
            i4 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(i4);
        parcel.writeString(this.template);
        parcel.writeString(this.packageName);
        parcel.writeString(this.appPresencePackage);
        parcel.writeString(this.intentPackageName);
        parcel.writeString(this.intentDetails);
        parcel.writeInt(this.minAppVersion);
        parcel.writeString(this.installs);
        parcel.writeString(this.category);
        int i5 = 0;
        if (this.app) {
            i5 = 1;
        }
        parcel.writeInt(i5);
        int i6 = 0;
        if (this.belowMinCPM) {
            i6 = 1;
        }
        parcel.writeInt(i6);
        if (this.ttl != null) {
            parcel.writeLong(this.ttl.longValue());
        } else {
            parcel.writeLong(-1L);
        }
        if (this.delayImpressionInSeconds != null) {
            parcel.writeLong(this.delayImpressionInSeconds.longValue());
        } else {
            parcel.writeLong(-1L);
        }
        if (this.sendRedirectHops == null) {
            parcel2 = parcel;
            i2 = 0;
        } else {
            parcel2 = parcel;
            i2 = this.sendRedirectHops.booleanValue() ? 1 : -1;
        }
        parcel2.writeInt(i2);
    }
}
