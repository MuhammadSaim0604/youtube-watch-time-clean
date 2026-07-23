package com.startapp.sdk.adsbase.consent;

import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class ConsentConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean allowCT;
    private String clickUrl;
    private Integer consentType;
    @d(a = true)
    private ConsentTypeInfoConfig consentTypeInfo;
    private String dParam;
    private boolean detectConsentCovering;
    private String impressionUrl;
    private String template;
    private Integer templateId;
    private Integer templateName;
    private long timeStamp = 0;

    public final boolean a() {
        return this.allowCT;
    }

    public final boolean b() {
        return this.detectConsentCovering;
    }

    public final Integer c() {
        return this.consentType;
    }

    public final String d() {
        return this.template;
    }

    public final long e() {
        return this.timeStamp;
    }

    public final String f() {
        return this.impressionUrl;
    }

    public final String g() {
        return this.clickUrl;
    }

    public final Integer h() {
        return this.templateName;
    }

    public final Integer i() {
        return this.templateId;
    }

    public final String j() {
        return this.dParam;
    }

    public final ConsentTypeInfoConfig k() {
        return this.consentTypeInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConsentConfig consentConfig = (ConsentConfig) obj;
        return this.allowCT == consentConfig.allowCT && this.detectConsentCovering == consentConfig.detectConsentCovering && this.timeStamp == consentConfig.timeStamp && u.b(this.template, consentConfig.template) && u.b(this.impressionUrl, consentConfig.impressionUrl) && u.b(this.clickUrl, consentConfig.clickUrl) && u.b(this.templateName, consentConfig.templateName) && u.b(this.templateId, consentConfig.templateId) && u.b(this.dParam, consentConfig.dParam) && u.b(this.consentTypeInfo, consentConfig.consentTypeInfo);
    }

    public final int hashCode() {
        return u.a(Boolean.valueOf(this.allowCT), Boolean.valueOf(this.detectConsentCovering), this.template, Long.valueOf(this.timeStamp), this.impressionUrl, this.clickUrl, this.templateName, this.templateId, this.dParam, this.consentTypeInfo);
    }
}
