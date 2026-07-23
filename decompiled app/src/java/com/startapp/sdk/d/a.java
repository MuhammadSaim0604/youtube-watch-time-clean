package com.startapp.sdk.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.startapp.common.b.e;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.d;
import com.startapp.sdk.adsbase.j.q;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.b.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class a extends d {
    protected Set<String> g;
    protected GetAdRequest h;
    private Set<String> i;
    private int j;
    private boolean k;

    static {
        a.class.getSimpleName();
    }

    public a(Context context, Ad ad, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar, AdPreferences.Placement placement, boolean z) {
        super(context, ad, adPreferences, bVar, placement);
        this.i = new HashSet();
        this.g = new HashSet();
        this.j = 0;
        this.k = z;
    }

    @Override // com.startapp.sdk.adsbase.d
    protected final Object e() {
        this.h = a();
        if (a(this.h)) {
            if (this.i.size() == 0) {
                this.i.add(this.a.getPackageName());
            }
            this.h.a(this.i);
            this.h.b(this.g);
            if (this.j > 0) {
                this.h.c(false);
                if (MetaData.E().e().a(this.a)) {
                    SimpleTokenUtils.b(this.a);
                }
            }
            return c.a(this.a).m().a(AdsConstants.a(AdsConstants.AdApiType.HTML, f())).a(this.h).a(new q<String>() { // from class: com.startapp.sdk.d.a.1
                @Override // com.startapp.sdk.adsbase.j.q
                public final /* bridge */ /* synthetic */ void a(String str) {
                    a.this.f = str;
                }
            }).a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(GetAdRequest getAdRequest) {
        return getAdRequest != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public boolean a(Object obj) {
        if (obj == null) {
            if (this.f == null) {
                this.f = "No response";
            }
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String a = ((e.a) obj).a();
            if (TextUtils.isEmpty(a)) {
                if (this.f == null) {
                    if (this.h != null && this.h.j()) {
                        this.f = "Video isn't available";
                    } else {
                        this.f = "Empty Ad";
                    }
                }
                return false;
            }
            List<AppPresenceDetails> a2 = com.iab.omid.library.startapp.b.a(a, this.j);
            boolean z = false;
            if (AdsCommonMetaData.a().F()) {
                z = com.iab.omid.library.startapp.b.a(this.a, a2, this.j, this.i, arrayList).booleanValue();
            }
            if (!z) {
                ((HtmlAd) this.b).a(a2);
                ((HtmlAd) this.b).b(a);
                return true;
            }
            this.j++;
            new com.startapp.sdk.adsbase.apppresence.a(this.a, arrayList).a();
            return d().booleanValue();
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.a);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public void a(Boolean bool) {
        super.a(bool);
        new StringBuilder("Html onPostExecute, result=[").append(bool).append("]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.sdk.adsbase.d
    public void b(Boolean bool) {
        super.b(bool);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        Intent intent = new Intent("com.startapp.android.OnReceiveResponseBroadcastListener");
        intent.putExtra("adHashcode", this.b.hashCode());
        intent.putExtra("adResult", z);
        com.startapp.common.b.a(this.a).a(intent);
        if (!z || this.b == null) {
            new StringBuilder("Html onPostExecute failed error=[").append(this.f).append("]");
        } else if (this.k) {
            u.a(this.a, ((HtmlAd) this.b).j(), new u.a() { // from class: com.startapp.sdk.d.a.2
                @Override // com.startapp.sdk.adsbase.j.u.a
                public final void a() {
                    a.this.d.a(a.this.b);
                }

                @Override // com.startapp.sdk.adsbase.j.u.a
                public final void a(String str) {
                    a.this.b.setErrorMessage(str);
                    a.this.d.b(a.this.b);
                }
            });
        } else if (z) {
            this.d.a(this.b);
        } else {
            this.d.b(this.b);
        }
    }
}
