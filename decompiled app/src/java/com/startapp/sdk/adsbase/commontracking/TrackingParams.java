package com.startapp.sdk.adsbase.commontracking;

import android.content.Context;
import android.location.Location;
import com.startapp.common.b.a;
import com.startapp.sdk.adsbase.j.p;
import com.startapp.sdk.adsbase.k;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.b.c;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class TrackingParams implements Serializable {
    private static final long serialVersionUID = 1;
    private String adTag;
    private String clientSessionId;
    private String location;
    private String nonImpressionReason;
    private int offset;
    private String profileId;

    public TrackingParams() {
        this(null);
    }

    public TrackingParams(String str) {
        this.adTag = str;
        this.clientSessionId = p.d().a();
        this.profileId = MetaData.E().z();
        this.offset = 0;
    }

    public final String f() {
        return this.adTag;
    }

    public final String g() {
        return this.profileId;
    }

    public final int h() {
        return this.offset;
    }

    public final TrackingParams a(int i) {
        this.offset = i;
        return this;
    }

    public final TrackingParams c(String str) {
        this.nonImpressionReason = str;
        return this;
    }

    public final void a(Context context) {
        k.a();
        k.g(context);
        Collection<Location> c = c.a(context).i().c();
        if (c.size() > 0) {
            this.location = "&locations=" + a(a.c(com.startapp.sdk.c.c.a.a(c)));
        } else {
            this.location = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return this.offset > 0 ? "&offset=" + this.offset : "";
    }

    private static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.adTag == null || this.adTag.equals("")) {
            str = "";
        } else {
            str = "&adTag=" + a(this.adTag.substring(0, this.adTag.length() < 200 ? this.adTag.length() : 200));
        }
        StringBuilder append = sb.append(str).append(this.clientSessionId != null ? "&clientSessionId=" + a(this.clientSessionId) : "").append(this.profileId != null ? "&profileId=" + a(this.profileId) : "").append(d()).append((this.nonImpressionReason == null || this.nonImpressionReason.equals("")) ? "" : "&isShown=false&reason=" + a(this.nonImpressionReason));
        String str2 = this.location;
        return append.append(str2 != null ? str2 : "").toString();
    }
}
