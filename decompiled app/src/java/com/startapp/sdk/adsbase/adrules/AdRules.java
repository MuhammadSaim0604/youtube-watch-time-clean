package com.startapp.sdk.adsbase.adrules;

import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdRules implements Serializable {
    private static final long serialVersionUID = 1;
    @d(b = ArrayList.class, c = AdRule.class)
    private List<AdRule> session = new ArrayList();
    @d(b = HashMap.class, c = ArrayList.class, d = AdPreferences.Placement.class, e = AdRule.class)
    private Map<AdPreferences.Placement, List<AdRule>> placements = new HashMap();
    @d(b = HashMap.class, c = ArrayList.class, e = AdRule.class)
    private Map<String, List<AdRule>> tags = new HashMap();
    private boolean applyOnBannerRefresh = true;
    private transient Set<Class<? extends AdRule>> a = new HashSet();

    public final boolean a() {
        return this.applyOnBannerRefresh;
    }

    public final synchronized AdRulesResult a(AdPreferences.Placement placement, String str) {
        AdRulesResult adRulesResult;
        this.a.clear();
        b.a().a(str);
        AdRulesResult a = a(this.tags.get(str), AdRuleLevel.TAG);
        adRulesResult = a;
        if (a.a()) {
            b.a().a(placement);
            AdRulesResult a2 = a(this.placements.get(placement), AdRuleLevel.PLACEMENT);
            adRulesResult = a2;
            if (a2.a()) {
                List<AdRule> list = this.session;
                b.a();
                adRulesResult = a(list, AdRuleLevel.SESSION);
            }
        }
        new StringBuilder("shouldDisplayAd result: ").append(adRulesResult.a()).append(adRulesResult.a() ? "" : " because of rule " + adRulesResult.b());
        return adRulesResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AdRulesResult a(List<AdRule> list, AdRuleLevel adRuleLevel) {
        if (list == null) {
            return new AdRulesResult();
        }
        for (AdRule adRule : list) {
            if (!this.a.contains(adRule.getClass())) {
                if (adRule.a()) {
                    this.a.add(adRule.getClass());
                } else {
                    return new AdRulesResult(false, adRule.getClass().getSimpleName() + "_" + adRuleLevel);
                }
            }
        }
        return new AdRulesResult();
    }

    public final void b() {
        this.a = new HashSet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdRules adRules = (AdRules) obj;
        return this.applyOnBannerRefresh == adRules.applyOnBannerRefresh && u.b(this.session, adRules.session) && u.b(this.placements, adRules.placements) && u.b(this.tags, adRules.tags);
    }

    public int hashCode() {
        return u.a(this.session, this.placements, this.tags, Boolean.valueOf(this.applyOnBannerRefresh));
    }
}
