package com.startapp.sdk.json;

import android.content.Context;
import android.content.Intent;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adlisteners.b;
import com.startapp.sdk.adsbase.d;
import com.startapp.sdk.adsbase.j.q;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.adsbase.model.GetAdResponse;
import com.startapp.sdk.b.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class a extends d {
    private int g;
    private Set<String> h;

    protected abstract void a(Ad ad);

    public a(Context context, Ad ad, AdPreferences adPreferences, b bVar, AdPreferences.Placement placement) {
        super(context, ad, adPreferences, bVar, placement);
        this.g = 0;
        this.h = new HashSet();
    }

    @Override // com.startapp.sdk.adsbase.d
    protected final Object e() {
        GetAdRequest a = a();
        if (a == null) {
            return null;
        }
        if (this.h.size() == 0) {
            this.h.add(this.a.getPackageName());
        }
        if (this.g > 0) {
            a.c(false);
        }
        a.a(this.h);
        a.c(this.g == 0);
        return c.a(this.a).m().a(AdsConstants.a(AdsConstants.AdApiType.JSON, f())).a(a).a(new q<String>() { // from class: com.startapp.sdk.json.a.1
            @Override // com.startapp.sdk.adsbase.j.q
            public final /* bridge */ /* synthetic */ void a(String str) {
                a.this.f = str;
            }
        }).a(GetAdResponse.class);
    }

    @Override // com.startapp.sdk.adsbase.d
    protected final boolean a(Object obj) {
        GetAdResponse getAdResponse = (GetAdResponse) obj;
        if (obj == null) {
            this.f = "Empty Response";
            return false;
        } else if (!getAdResponse.a()) {
            this.f = getAdResponse.b();
            new StringBuilder("Error msg = [").append(this.f).append("]");
            return false;
        } else {
            JsonAd jsonAd = (JsonAd) this.b;
            List<AdDetails> a = com.iab.omid.library.startapp.b.a(this.a, getAdResponse.c(), this.g, this.h);
            jsonAd.a(a);
            jsonAd.setAdInfoOverride(getAdResponse.d());
            boolean z = getAdResponse.c() != null && getAdResponse.c().size() > 0;
            if (!z) {
                this.f = "Empty Response";
            } else if (a.size() == 0 && this.g == 0) {
                this.g++;
                return d().booleanValue();
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public final void a(Boolean bool) {
        super.a(bool);
        Intent intent = new Intent("com.startapp.android.OnReceiveResponseBroadcastListener");
        intent.putExtra("adHashcode", this.b.hashCode());
        intent.putExtra("adResult", bool);
        com.startapp.common.b.a(this.a).a(intent);
        if (bool.booleanValue()) {
            a((Ad) ((JsonAd) this.b));
            this.d.a(this.b);
        }
    }
}
