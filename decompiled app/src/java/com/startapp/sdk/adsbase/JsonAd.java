package com.startapp.sdk.adsbase;

import android.content.Context;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class JsonAd extends Ad {
    private static final long serialVersionUID = 1;
    private List<AdDetails> adsDetails;
    private Boolean consentApc;
    private Long consentTimeStamp;
    private Integer consentType;

    public JsonAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
        this.adsDetails = null;
    }

    public final void a(List<AdDetails> list) {
        this.adsDetails = list;
        Long l = null;
        if (this.adsDetails != null) {
            for (AdDetails adDetails : this.adsDetails) {
                if (adDetails != null && adDetails.x() != null && (l == null || adDetails.x().longValue() < l.longValue())) {
                    l = adDetails.x();
                }
            }
        }
        if (l != null) {
            this.adCacheTtl = Long.valueOf(TimeUnit.SECONDS.toMillis(l.longValue()));
        }
        boolean z = true;
        for (AdDetails adDetails2 : this.adsDetails) {
            if (!adDetails2.i()) {
                z = false;
            }
        }
        this.belowMinCPM = z;
    }

    public final List<AdDetails> g() {
        return this.adsDetails;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public String getAdId() {
        if (this.adsDetails == null || this.adsDetails.size() <= 0) {
            return null;
        }
        return this.adsDetails.get(0).a();
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public Integer getConsentType() {
        return this.consentType;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public void setConsentType(Integer num) {
        this.consentType = num;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public Long getConsentTimestamp() {
        return this.consentTimeStamp;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public void setConsentTimestamp(Long l) {
        this.consentTimeStamp = l;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public Boolean getConsentApc() {
        return this.consentApc;
    }

    @Override // com.startapp.sdk.adsbase.Ad
    public void setConsentApc(Boolean bool) {
        this.consentApc = bool;
    }
}
