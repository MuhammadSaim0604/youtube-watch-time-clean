package com.startapp.sdk.adsbase.remoteconfig;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class MetaDataStyle implements Serializable {
    public static final Integer a = 18;
    public static final Integer b = -1;
    public static final Set<String> c = new HashSet(Arrays.asList("BOLD"));
    public static final Integer d = 14;
    public static final Integer e = -1;
    public static final Set<String> f = new HashSet();
    private static final long serialVersionUID = 1;
    private String name = "";
    private Integer itemGradientTop = -14014151;
    private Integer itemGradientBottom = -8750199;
    private Integer itemTitleTextSize = a;
    private Integer itemTitleTextColor = b;
    @com.startapp.common.parser.d(b = HashSet.class)
    private Set<String> itemTitleTextDecoration = c;
    private Integer itemDescriptionTextSize = d;
    private Integer itemDescriptionTextColor = e;
    @com.startapp.common.parser.d(b = HashSet.class)
    private Set<String> itemDescriptionTextDecoration = f;

    public final Integer a() {
        return this.itemGradientTop;
    }

    public final Integer b() {
        return this.itemGradientBottom;
    }

    public final Integer c() {
        return this.itemTitleTextSize;
    }

    public final Integer d() {
        return this.itemTitleTextColor;
    }

    public final Set<String> e() {
        return this.itemTitleTextDecoration;
    }

    public final Integer f() {
        return this.itemDescriptionTextSize;
    }

    public final Integer g() {
        return this.itemDescriptionTextColor;
    }

    public final Set<String> h() {
        return this.itemDescriptionTextDecoration;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MetaDataStyle metaDataStyle = (MetaDataStyle) obj;
        return u.b(this.name, metaDataStyle.name) && u.b(this.itemGradientTop, metaDataStyle.itemGradientTop) && u.b(this.itemGradientBottom, metaDataStyle.itemGradientBottom) && u.b(this.itemTitleTextSize, metaDataStyle.itemTitleTextSize) && u.b(this.itemTitleTextColor, metaDataStyle.itemTitleTextColor) && u.b(this.itemTitleTextDecoration, metaDataStyle.itemTitleTextDecoration) && u.b(this.itemDescriptionTextSize, metaDataStyle.itemDescriptionTextSize) && u.b(this.itemDescriptionTextColor, metaDataStyle.itemDescriptionTextColor) && u.b(this.itemDescriptionTextDecoration, metaDataStyle.itemDescriptionTextDecoration);
    }

    public int hashCode() {
        return u.a(this.name, this.itemGradientTop, this.itemGradientBottom, this.itemTitleTextSize, this.itemTitleTextColor, this.itemTitleTextDecoration, this.itemDescriptionTextSize, this.itemDescriptionTextColor, this.itemDescriptionTextDecoration);
    }
}
