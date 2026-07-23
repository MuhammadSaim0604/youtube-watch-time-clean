package com.startapp.sdk.ads.offerWall.offerWallJson;

import android.content.Context;
import android.content.Intent;
import com.startapp.sdk.ads.list3d.List3DActivity;
import com.startapp.sdk.ads.list3d.g;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.b;
import com.startapp.sdk.adsbase.f;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.UUID;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class OfferWall3DAd extends JsonAd implements f {
    private static String b = null;
    private static final long serialVersionUID = 1;
    private final String uuid;

    public OfferWall3DAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OFFER_WALL);
        this.uuid = UUID.randomUUID().toString();
        if (b == null) {
            b = u.f(context);
        }
    }

    @Override // com.startapp.sdk.adsbase.Ad
    protected final void a(AdPreferences adPreferences, b bVar) {
        new a(this.a, this, adPreferences, bVar).c();
    }

    @Override // com.startapp.sdk.adsbase.f
    public final boolean a(String str) {
        boolean z;
        g.a().a(this.uuid).b(com.startapp.sdk.adsbase.a.a());
        if (this.activityExtra != null) {
            z = this.activityExtra.a();
        } else {
            z = false;
        }
        boolean z2 = z;
        if (super.e_()) {
            a(AdDisplayListener.NotDisplayedReason.AD_EXPIRED);
            return false;
        }
        Intent intent = new Intent(this.a, List3DActivity.class);
        intent.putExtra("adInfoOverride", getAdInfoOverride());
        intent.putExtra("fullscreen", z2);
        intent.putExtra("adTag", str);
        intent.putExtra("lastLoadTime", super.b());
        intent.putExtra("adCacheTtl", super.c());
        intent.putExtra("position", com.startapp.sdk.adsbase.a.b());
        intent.putExtra("listModelUuid", this.uuid);
        intent.addFlags(343932928);
        this.a.startActivity(intent);
        if (!AdsConstants.b.booleanValue()) {
            setState(Ad.AdState.UN_INITIALIZED);
        }
        return true;
    }

    public final String a() {
        return this.uuid;
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final Long b() {
        return super.b();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final Long c() {
        return super.c();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final boolean e_() {
        return super.e_();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final boolean e() {
        return super.e();
    }

    @Override // com.startapp.sdk.adsbase.Ad, com.startapp.sdk.adsbase.f
    public final void a(boolean z) {
        super.a(z);
    }
}
