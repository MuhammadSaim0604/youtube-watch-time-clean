package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class CacheKey implements Serializable {
    private static final long serialVersionUID = 1;
    private String adTag;
    private String advertiserId;
    private Set<String> categories;
    private Set<String> categoriesExclude;
    private String country;
    private boolean forceFullpage;
    private boolean forceOfferWall2D;
    private boolean forceOfferWall3D;
    private boolean forceOverlay;
    private Double minCpm;
    private AdPreferences.Placement placement;
    private String template;
    private boolean testMode;
    private Ad.AdType type;
    private boolean videoMuted;

    public CacheKey(AdPreferences.Placement placement, AdPreferences adPreferences) {
        this.placement = placement;
        this.categories = adPreferences.getCategories();
        this.categoriesExclude = adPreferences.getCategoriesExclude();
        this.videoMuted = adPreferences.isVideoMuted();
        this.minCpm = adPreferences.getMinCpm();
        this.forceOfferWall3D = adPreferences.isForceOfferWall3D();
        this.forceOfferWall2D = adPreferences.isForceOfferWall2D();
        this.forceFullpage = adPreferences.isForceFullpage();
        this.forceOverlay = adPreferences.isForceOverlay();
        this.testMode = adPreferences.isTestMode();
        this.adTag = adPreferences.getAdTag();
        this.country = adPreferences.getCountry();
        this.advertiserId = adPreferences.getAdvertiserId();
        this.template = adPreferences.getTemplate();
        this.type = adPreferences.getType();
    }

    public final AdPreferences.Placement a() {
        return this.placement;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) obj;
        return this.forceOfferWall3D == cacheKey.forceOfferWall3D && this.forceOfferWall2D == cacheKey.forceOfferWall2D && this.forceFullpage == cacheKey.forceFullpage && this.forceOverlay == cacheKey.forceOverlay && this.testMode == cacheKey.testMode && this.videoMuted == cacheKey.videoMuted && this.placement == cacheKey.placement && u.b(this.categories, cacheKey.categories) && u.b(this.categoriesExclude, cacheKey.categoriesExclude) && u.b(this.minCpm, cacheKey.minCpm) && u.b(this.adTag, cacheKey.adTag) && u.b(this.country, cacheKey.country) && u.b(this.advertiserId, cacheKey.advertiserId) && u.b(this.template, cacheKey.template) && this.type == cacheKey.type;
    }

    public int hashCode() {
        return u.a(this.placement, this.categories, this.categoriesExclude, this.minCpm, Boolean.valueOf(this.forceOfferWall3D), Boolean.valueOf(this.forceOfferWall2D), Boolean.valueOf(this.forceFullpage), Boolean.valueOf(this.forceOverlay), Boolean.valueOf(this.testMode), Boolean.valueOf(this.videoMuted), this.adTag, this.country, this.advertiserId, this.template, this.type);
    }

    public String toString() {
        return "CacheKey [placement=" + this.placement + ", categories=" + this.categories + ", categoriesExclude=" + this.categoriesExclude + ", forceOfferWall3D=" + this.forceOfferWall3D + ", forceOfferWall2D=" + this.forceOfferWall2D + ", forceFullpage=" + this.forceFullpage + ", forceOverlay=" + this.forceOverlay + ", testMode=" + this.testMode + ", minCpm=" + this.minCpm + ", country=" + this.country + ", advertiserId=" + this.advertiserId + ", template=" + this.template + ", type=" + this.type + ", adTag=" + this.adTag + ", videoMuted=" + this.videoMuted + "]";
    }
}
