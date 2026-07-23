package com.startapp.sdk.ads.banner;

import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class BannerOptions implements Serializable {
    private static final long serialVersionUID = 1;
    private int adsNumber;
    private int delayFaceTime;
    @d(b = Effect.class)
    private Effect effect;
    private int height;
    private float heightRatio;
    private int htmlAdsNumber;
    private float minScale;
    private int minViewabilityPercentage;
    private int refreshRate;
    private int refreshRate3D;
    private boolean rotateThroughOnStart;
    private int rotateThroughSpeedMult;
    private int scalePower;
    private int stepSize;
    private int timeBetweenFrames;
    private int width;
    private float widthRatio;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Effect {
        ROTATE_3D(1),
        EXCHANGE(2),
        FLY_IN(3);
        
        private int index;

        Effect(int i) {
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getRotationMultiplier() {
            return (int) Math.pow(2.0d, this.index - 1);
        }

        public static Effect getByIndex(int i) {
            Effect effect = ROTATE_3D;
            Effect[] values = values();
            for (int i2 = 0; i2 < values.length; i2++) {
                if (values[i2].getIndex() == i) {
                    effect = values[i2];
                }
            }
            return effect;
        }

        public static Effect getByName(String str) {
            Effect effect = ROTATE_3D;
            Effect[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(str.toLowerCase()) == 0) {
                    effect = values[i];
                }
            }
            return effect;
        }
    }

    public BannerOptions() {
        this.width = 300;
        this.height = 50;
        this.minViewabilityPercentage = 50;
        this.timeBetweenFrames = 25;
        this.stepSize = 5;
        this.delayFaceTime = 5000;
        this.adsNumber = 4;
        this.htmlAdsNumber = 10;
        this.refreshRate3D = 60000;
        this.widthRatio = 1.0f;
        this.heightRatio = 1.0f;
        this.minScale = 0.88f;
        this.scalePower = 4;
        this.effect = Effect.ROTATE_3D;
        this.rotateThroughOnStart = true;
        this.rotateThroughSpeedMult = 2;
        this.refreshRate = 60000;
    }

    public BannerOptions(BannerOptions bannerOptions) {
        this.width = 300;
        this.height = 50;
        this.minViewabilityPercentage = 50;
        this.timeBetweenFrames = 25;
        this.stepSize = 5;
        this.delayFaceTime = 5000;
        this.adsNumber = 4;
        this.htmlAdsNumber = 10;
        this.refreshRate3D = 60000;
        this.widthRatio = 1.0f;
        this.heightRatio = 1.0f;
        this.minScale = 0.88f;
        this.scalePower = 4;
        this.effect = Effect.ROTATE_3D;
        this.rotateThroughOnStart = true;
        this.rotateThroughSpeedMult = 2;
        this.refreshRate = 60000;
        this.width = bannerOptions.width;
        this.height = bannerOptions.height;
        this.timeBetweenFrames = bannerOptions.timeBetweenFrames;
        this.stepSize = bannerOptions.stepSize;
        this.delayFaceTime = bannerOptions.delayFaceTime;
        this.adsNumber = bannerOptions.adsNumber;
        this.htmlAdsNumber = bannerOptions.htmlAdsNumber;
        this.refreshRate3D = bannerOptions.refreshRate3D;
        this.widthRatio = bannerOptions.widthRatio;
        this.heightRatio = bannerOptions.heightRatio;
        this.minScale = bannerOptions.minScale;
        this.scalePower = bannerOptions.scalePower;
        this.effect = bannerOptions.effect;
        this.rotateThroughOnStart = bannerOptions.rotateThroughOnStart;
        this.rotateThroughSpeedMult = bannerOptions.rotateThroughSpeedMult;
        this.refreshRate = bannerOptions.refreshRate;
    }

    public final void a(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int a() {
        return this.timeBetweenFrames;
    }

    public final int b() {
        return this.stepSize;
    }

    public final int c() {
        return this.delayFaceTime;
    }

    public final int d() {
        return this.width;
    }

    public final int e() {
        return this.height;
    }

    public final int f() {
        return this.adsNumber;
    }

    public final int g() {
        return this.htmlAdsNumber;
    }

    public final int h() {
        return this.refreshRate3D;
    }

    public final int i() {
        return this.refreshRate;
    }

    public final float j() {
        return this.widthRatio;
    }

    public final float k() {
        return this.heightRatio;
    }

    public final float l() {
        return this.minScale;
    }

    public final int m() {
        return this.scalePower;
    }

    public final Effect n() {
        return this.effect;
    }

    public final boolean o() {
        return this.rotateThroughOnStart;
    }

    public final int p() {
        return this.rotateThroughSpeedMult;
    }

    public final int q() {
        return this.minViewabilityPercentage;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BannerOptions bannerOptions = (BannerOptions) obj;
        return this.width == bannerOptions.width && this.height == bannerOptions.height && this.minViewabilityPercentage == bannerOptions.minViewabilityPercentage && this.timeBetweenFrames == bannerOptions.timeBetweenFrames && this.stepSize == bannerOptions.stepSize && this.delayFaceTime == bannerOptions.delayFaceTime && this.adsNumber == bannerOptions.adsNumber && this.htmlAdsNumber == bannerOptions.htmlAdsNumber && this.refreshRate3D == bannerOptions.refreshRate3D && Float.compare(bannerOptions.widthRatio, this.widthRatio) == 0 && Float.compare(bannerOptions.heightRatio, this.heightRatio) == 0 && Float.compare(bannerOptions.minScale, this.minScale) == 0 && this.scalePower == bannerOptions.scalePower && this.rotateThroughOnStart == bannerOptions.rotateThroughOnStart && this.rotateThroughSpeedMult == bannerOptions.rotateThroughSpeedMult && this.refreshRate == bannerOptions.refreshRate && this.effect == bannerOptions.effect;
    }

    public int hashCode() {
        return u.a(Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.minViewabilityPercentage), Integer.valueOf(this.timeBetweenFrames), Integer.valueOf(this.stepSize), Integer.valueOf(this.delayFaceTime), Integer.valueOf(this.adsNumber), Integer.valueOf(this.htmlAdsNumber), Integer.valueOf(this.refreshRate3D), Float.valueOf(this.widthRatio), Float.valueOf(this.heightRatio), Float.valueOf(this.minScale), Integer.valueOf(this.scalePower), this.effect, Boolean.valueOf(this.rotateThroughOnStart), Integer.valueOf(this.rotateThroughSpeedMult), Integer.valueOf(this.refreshRate));
    }
}
