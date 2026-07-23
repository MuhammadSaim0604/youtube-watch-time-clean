package com.startapp.sdk.adsbase.remoteconfig;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class RscMetadata implements Serializable {
    private static final long serialVersionUID = 1389056033245684328L;
    private boolean enabled;
    private int ief;
    @com.startapp.common.parser.d(b = ArrayList.class, c = RscMetadataItem.class)
    private List<RscMetadataItem> items;
    private String triggers;

    public final boolean a() {
        return this.enabled;
    }

    public final String b() {
        return this.triggers;
    }

    public final List<RscMetadataItem> c() {
        return this.items;
    }

    public final int d() {
        return this.ief;
    }

    public final int a(RscMetadataItem rscMetadataItem) {
        return rscMetadataItem.h() != null ? rscMetadataItem.h().intValue() : this.ief;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RscMetadata rscMetadata = (RscMetadata) obj;
        return this.enabled == rscMetadata.enabled && this.ief == rscMetadata.ief && u.b(this.triggers, rscMetadata.triggers) && u.b(this.items, rscMetadata.items);
    }

    public int hashCode() {
        return u.a(Boolean.valueOf(this.enabled), this.triggers, this.items, Integer.valueOf(this.ief));
    }
}
