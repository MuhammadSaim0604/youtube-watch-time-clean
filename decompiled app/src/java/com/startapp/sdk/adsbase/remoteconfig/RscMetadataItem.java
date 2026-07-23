package com.startapp.sdk.adsbase.remoteconfig;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class RscMetadataItem implements Serializable {
    private static final long serialVersionUID = 1691586261519008915L;
    private String config;
    private Integer ief;
    private Integer limit;
    private int noCache;
    private Integer output;
    private int[] sortBy;
    private int triggers;
    private Integer ttl;

    public final String a() {
        return this.config;
    }

    public final int b() {
        return this.triggers;
    }

    public final int c() {
        return this.noCache;
    }

    public final Integer d() {
        return this.ttl;
    }

    public final int[] e() {
        return this.sortBy;
    }

    public final Integer f() {
        return this.limit;
    }

    public final Integer g() {
        return this.output;
    }

    public final Integer h() {
        return this.ief;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RscMetadataItem rscMetadataItem = (RscMetadataItem) obj;
        return this.triggers == rscMetadataItem.triggers && this.noCache == rscMetadataItem.noCache && u.b(this.config, rscMetadataItem.config) && u.b(this.ttl, rscMetadataItem.ttl) && u.b(this.output, rscMetadataItem.output) && u.b(this.ief, rscMetadataItem.ief);
    }

    public int hashCode() {
        return u.a(this.config, Integer.valueOf(this.triggers), Integer.valueOf(this.noCache), this.ttl, this.output, this.ief);
    }
}
