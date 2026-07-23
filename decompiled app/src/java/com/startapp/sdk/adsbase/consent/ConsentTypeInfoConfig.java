package com.startapp.sdk.adsbase.consent;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class ConsentTypeInfoConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private Integer falseClick;
    private Integer impression;
    private Integer trueClick;

    public final Integer a() {
        return this.impression;
    }

    public final Integer b() {
        return this.trueClick;
    }

    public final Integer c() {
        return this.falseClick;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConsentTypeInfoConfig consentTypeInfoConfig = (ConsentTypeInfoConfig) obj;
        return u.b(this.impression, consentTypeInfoConfig.impression) && u.b(this.trueClick, consentTypeInfoConfig.trueClick) && u.b(this.falseClick, consentTypeInfoConfig.falseClick);
    }

    public final int hashCode() {
        return u.a(this.impression, this.trueClick, this.falseClick);
    }
}
