package com.startapp.sdk.adsbase.model;

import android.content.Context;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.SDKAdPreferences;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.k;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdPreferences implements Serializable {
    public static final String TYPE_APP_WALL = "APP_WALL";
    public static final String TYPE_BANNER = "BANNER";
    public static final String TYPE_INAPP_EXIT = "INAPP_EXIT";
    public static final String TYPE_SCRINGO_TOOLBAR = "SCRINGO_TOOLBAR";
    public static final String TYPE_TEXT = "TEXT";
    private static final long serialVersionUID = 1;
    private String adTag;
    protected String advertiserId;
    private String age;
    private Boolean ai;
    private Boolean as;
    private Integer autoLoadAmount;
    private Set<String> categories;
    private Set<String> categoriesExclude;
    protected String country;
    protected boolean forceFullpage;
    protected boolean forceOfferWall2D;
    protected boolean forceOfferWall3D;
    protected boolean forceOverlay;
    private SDKAdPreferences.Gender gender;
    private boolean hardwareAccelerated;
    private String keywords;
    private Double latitude;
    private Double longitude;
    protected Double minCpm;
    protected Set<String> packageInclude;
    protected String template;
    private boolean testMode;
    protected Ad.AdType type;
    private boolean videoMuted;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum Placement {
        INAPP_FULL_SCREEN(1),
        INAPP_BANNER(2),
        INAPP_OFFER_WALL(3),
        INAPP_SPLASH(4),
        INAPP_OVERLAY(5),
        INAPP_NATIVE(6),
        DEVICE_SIDEBAR(7),
        INAPP_RETURN(8),
        INAPP_BROWSER(9);
        
        private int index;

        Placement(int i) {
            this.index = i;
        }

        public final int a() {
            return this.index;
        }

        public static Placement a(int i) {
            Placement placement = INAPP_FULL_SCREEN;
            Placement[] values = values();
            for (int i2 = 0; i2 < values.length; i2++) {
                if (values[i2].index == i) {
                    placement = values[i2];
                }
            }
            return placement;
        }
    }

    public AdPreferences() {
        this.country = null;
        this.advertiserId = null;
        this.template = null;
        this.type = null;
        this.packageInclude = null;
        this.forceOfferWall3D = false;
        this.forceOfferWall2D = false;
        this.forceFullpage = false;
        this.forceOverlay = false;
        this.minCpm = null;
        this.testMode = false;
        this.longitude = null;
        this.latitude = null;
        this.keywords = null;
        this.gender = null;
        this.age = null;
        this.ai = null;
        this.as = null;
        this.videoMuted = false;
        this.adTag = null;
        this.hardwareAccelerated = k.a().f();
        this.categories = null;
        this.categoriesExclude = null;
    }

    public AdPreferences(AdPreferences adPreferences) {
        this.country = null;
        this.advertiserId = null;
        this.template = null;
        this.type = null;
        this.packageInclude = null;
        this.forceOfferWall3D = false;
        this.forceOfferWall2D = false;
        this.forceFullpage = false;
        this.forceOverlay = false;
        this.minCpm = null;
        this.testMode = false;
        this.longitude = null;
        this.latitude = null;
        this.keywords = null;
        this.gender = null;
        this.age = null;
        this.ai = null;
        this.as = null;
        this.videoMuted = false;
        this.adTag = null;
        this.hardwareAccelerated = k.a().f();
        this.categories = null;
        this.categoriesExclude = null;
        this.country = adPreferences.country;
        this.advertiserId = adPreferences.advertiserId;
        this.template = adPreferences.template;
        this.type = adPreferences.type;
        if (adPreferences.packageInclude != null) {
            this.packageInclude = new HashSet(adPreferences.packageInclude);
        }
        this.minCpm = adPreferences.minCpm;
        this.forceOfferWall3D = adPreferences.forceOfferWall3D;
        this.forceOfferWall2D = adPreferences.forceOfferWall2D;
        this.forceFullpage = adPreferences.forceFullpage;
        this.forceOverlay = adPreferences.forceOverlay;
        this.testMode = adPreferences.testMode;
        this.longitude = adPreferences.longitude;
        this.latitude = adPreferences.latitude;
        this.keywords = adPreferences.keywords;
        this.gender = adPreferences.gender;
        this.age = adPreferences.age;
        this.ai = adPreferences.ai;
        this.as = adPreferences.as;
        this.videoMuted = adPreferences.videoMuted;
        this.adTag = adPreferences.adTag;
        this.hardwareAccelerated = adPreferences.hardwareAccelerated;
        this.autoLoadAmount = adPreferences.autoLoadAmount;
        if (adPreferences.categories != null) {
            this.categories = new HashSet(adPreferences.categories);
        }
        if (adPreferences.categoriesExclude != null) {
            this.categoriesExclude = new HashSet(adPreferences.categoriesExclude);
        }
    }

    public boolean isForceOfferWall3D() {
        return this.forceOfferWall3D;
    }

    public boolean isForceOfferWall2D() {
        return this.forceOfferWall2D;
    }

    public boolean isForceFullpage() {
        return this.forceFullpage;
    }

    public boolean isForceOverlay() {
        return this.forceOverlay;
    }

    public String getCountry() {
        return this.country;
    }

    public String getAdvertiserId() {
        return this.advertiserId;
    }

    public String getTemplate() {
        return this.template;
    }

    public boolean isTestMode() {
        return this.testMode;
    }

    public AdPreferences setTestMode(boolean z) {
        this.testMode = z;
        return this;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public AdPreferences setLongitude(double d) {
        this.longitude = Double.valueOf(d);
        return this;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public AdPreferences setLatitude(double d) {
        this.latitude = Double.valueOf(d);
        return this;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public AdPreferences setKeywords(String str) {
        this.keywords = str;
        return this;
    }

    public SDKAdPreferences.Gender getGender(Context context) {
        if (this.gender != null) {
            return this.gender;
        }
        return k.a().f(context).getGender();
    }

    public AdPreferences setGender(SDKAdPreferences.Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getAge(Context context) {
        if (this.age != null) {
            return this.age;
        }
        return k.a().f(context).getAge();
    }

    public AdPreferences setAge(Integer num) {
        this.age = Integer.toString(num.intValue());
        return this;
    }

    public AdPreferences setAge(String str) {
        this.age = str;
        return this;
    }

    public Boolean getAi() {
        return this.ai;
    }

    public AdPreferences setAi(Boolean bool) {
        this.ai = bool;
        return this;
    }

    public Boolean getAs() {
        return this.as;
    }

    public AdPreferences setAs(Boolean bool) {
        this.as = bool;
        return this;
    }

    public AdPreferences muteVideo() {
        this.videoMuted = true;
        return this;
    }

    public boolean isVideoMuted() {
        return this.videoMuted;
    }

    public AdPreferences setAdTag(String str) {
        this.adTag = str;
        return this;
    }

    public void setAutoLoadAmount(int i) {
        if (i > 0) {
            this.autoLoadAmount = Integer.valueOf(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Integer a() {
        return this.autoLoadAmount;
    }

    public String getAdTag() {
        return this.adTag;
    }

    public Set<String> getCategories() {
        return this.categories;
    }

    public AdPreferences addCategory(String str) {
        if (this.categories == null) {
            this.categories = new HashSet();
        }
        this.categories.add(str);
        return this;
    }

    public Set<String> getCategoriesExclude() {
        return this.categoriesExclude;
    }

    public AdPreferences addCategoryExclude(String str) {
        if (this.categoriesExclude == null) {
            this.categoriesExclude = new HashSet();
        }
        this.categoriesExclude.add(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.hardwareAccelerated;
    }

    public void setHardwareAccelerated(boolean z) {
        this.hardwareAccelerated = z;
    }

    public boolean isSimpleToken() {
        return true;
    }

    public Ad.AdType getType() {
        return this.type;
    }

    public void setType(Ad.AdType adType) {
        this.type = adType;
    }

    public Double getMinCpm() {
        return this.minCpm;
    }

    public void setMinCpm(Double d) {
        this.minCpm = d;
    }

    public String toString() {
        return super.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdPreferences adPreferences = (AdPreferences) obj;
        return this.forceOfferWall3D == adPreferences.forceOfferWall3D && this.forceOfferWall2D == adPreferences.forceOfferWall2D && this.forceFullpage == adPreferences.forceFullpage && this.forceOverlay == adPreferences.forceOverlay && this.testMode == adPreferences.testMode && this.videoMuted == adPreferences.videoMuted && this.hardwareAccelerated == adPreferences.hardwareAccelerated && u.b(this.autoLoadAmount, adPreferences.autoLoadAmount) && u.b(this.country, adPreferences.country) && u.b(this.advertiserId, adPreferences.advertiserId) && u.b(this.template, adPreferences.template) && this.type == adPreferences.type && u.b(this.packageInclude, adPreferences.packageInclude) && u.b(this.minCpm, adPreferences.minCpm) && u.b(this.longitude, adPreferences.longitude) && u.b(this.latitude, adPreferences.latitude) && u.b(this.keywords, adPreferences.keywords) && this.gender == adPreferences.gender && u.b(this.age, adPreferences.age) && u.b(this.ai, adPreferences.ai) && u.b(this.as, adPreferences.as) && u.b(this.adTag, adPreferences.adTag) && u.b(this.categories, adPreferences.categories) && u.b(this.categoriesExclude, adPreferences.categoriesExclude);
    }

    public int hashCode() {
        return u.a(this.country, this.advertiserId, this.template, this.type, this.packageInclude, Boolean.valueOf(this.forceOfferWall3D), Boolean.valueOf(this.forceOfferWall2D), Boolean.valueOf(this.forceFullpage), Boolean.valueOf(this.forceOverlay), this.minCpm, Boolean.valueOf(this.testMode), this.longitude, this.latitude, this.keywords, this.gender, this.age, this.ai, this.as, Boolean.valueOf(this.videoMuted), this.adTag, Boolean.valueOf(this.hardwareAccelerated), this.autoLoadAmount, this.categories, this.categoriesExclude);
    }
}
