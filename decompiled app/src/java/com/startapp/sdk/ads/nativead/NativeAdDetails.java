package com.startapp.sdk.ads.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import com.startapp.common.a;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.h;
import com.startapp.sdk.adsbase.k.b;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class NativeAdDetails implements NativeAdInterface {
    private AdDetails a;
    private int b;
    private Bitmap c;
    private Bitmap d;
    private a g;
    private String h;
    private com.startapp.sdk.adsbase.k.b i;
    private View.OnAttachStateChangeListener k;
    private b l;
    private boolean e = false;
    private boolean f = false;
    private WeakReference<View> j = new WeakReference<>(null);

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        void onNativeAdDetailsLoaded(int i);
    }

    static /* synthetic */ void a(NativeAdDetails nativeAdDetails, View view) {
        Context context = view.getContext();
        switch (nativeAdDetails.getCampaignAction()) {
            case OPEN_MARKET:
                boolean a2 = com.startapp.sdk.adsbase.a.a(context, AdPreferences.Placement.INAPP_NATIVE);
                if (nativeAdDetails.a.l() && !a2) {
                    com.startapp.sdk.adsbase.a.a(context, nativeAdDetails.a.c(), nativeAdDetails.a.e(), nativeAdDetails.a.n(), new TrackingParams(nativeAdDetails.h), AdsCommonMetaData.a().B(), AdsCommonMetaData.a().C(), nativeAdDetails.a.w(), nativeAdDetails.a.z());
                    break;
                } else {
                    com.startapp.sdk.adsbase.a.a(context, nativeAdDetails.a.c(), nativeAdDetails.a.e(), new TrackingParams(nativeAdDetails.h), nativeAdDetails.a.w() && !a2, false);
                    break;
                }
                break;
            case LAUNCH_APP:
                com.startapp.sdk.adsbase.a.a(nativeAdDetails.getPackacgeName(), nativeAdDetails.a.p(), nativeAdDetails.a.c(), context, new TrackingParams(nativeAdDetails.h));
                break;
        }
        if (nativeAdDetails.l != null) {
            nativeAdDetails.l.adClicked(nativeAdDetails);
        }
    }

    static /* synthetic */ boolean d(NativeAdDetails nativeAdDetails) {
        nativeAdDetails.e = true;
        return true;
    }

    static /* synthetic */ boolean g(NativeAdDetails nativeAdDetails) {
        nativeAdDetails.f = true;
        return true;
    }

    public NativeAdDetails(AdDetails adDetails, NativeAdPreferences nativeAdPreferences, int i, a aVar) {
        new StringBuilder("Initializiang SingleAd [").append(i).append("]");
        this.a = adDetails;
        this.b = i;
        this.g = aVar;
        if (nativeAdPreferences.isAutoBitmapDownload()) {
            new com.startapp.common.a(getImageUrl(), new a.InterfaceC0015a() { // from class: com.startapp.sdk.ads.nativead.NativeAdDetails.1
                @Override // com.startapp.common.a.InterfaceC0015a
                public final void a(Bitmap bitmap, int i2) {
                    NativeAdDetails.this.c = bitmap;
                    new com.startapp.common.a(NativeAdDetails.this.getSecondaryImageUrl(), new a.InterfaceC0015a() { // from class: com.startapp.sdk.ads.nativead.NativeAdDetails.1.1
                        @Override // com.startapp.common.a.InterfaceC0015a
                        public final void a(Bitmap bitmap2, int i3) {
                            NativeAdDetails.this.d = bitmap2;
                            NativeAdDetails.this.b();
                        }
                    }, i2).a();
                }
            }, i).a();
        } else {
            b();
        }
    }

    public String toString() {
        String description = getDescription();
        String str = description;
        if (description != null) {
            str = str.substring(0, Math.min(30, str.length()));
        }
        return "         Title: [" + getTitle() + "]\n         Description: [" + str + "]...\n         Rating: [" + getRating() + "]\n         Installs: [" + getInstalls() + "]\n         Category: [" + getCategory() + "]\n         PackageName: [" + getPackacgeName() + "]\n         CampaginAction: [" + getCampaignAction() + "]\n";
    }

    protected void finalize() throws Throwable {
        super.finalize();
        unregisterView();
    }

    public int getIdentifier() {
        return this.b;
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public boolean isBelowMinCPM() {
        return this.a != null && this.a.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        new Handler().post(new Runnable() { // from class: com.startapp.sdk.ads.nativead.NativeAdDetails.2
            @Override // java.lang.Runnable
            public final void run() {
                new StringBuilder("SingleAd [").append(NativeAdDetails.this.b).append("] Loaded");
                if (NativeAdDetails.this.g != null) {
                    NativeAdDetails.this.g.onNativeAdDetailsLoaded(NativeAdDetails.this.b);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        this.h = str;
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public String getTitle() {
        return this.a != null ? this.a.f() : "";
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public String getDescription() {
        return this.a != null ? this.a.g() : "";
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public float getRating() {
        float f = 5.0f;
        if (this.a != null) {
            f = this.a.k();
        }
        return f;
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public String getImageUrl() {
        return this.a != null ? this.a.h() : "";
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public String getSecondaryImageUrl() {
        return this.a != null ? this.a.j() : "";
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public Bitmap getImageBitmap() {
        return this.c;
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public Bitmap getSecondaryImageBitmap() {
        return this.d;
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public String getInstalls() {
        return this.a != null ? this.a.s() : "";
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public String getCategory() {
        return this.a != null ? this.a.t() : "";
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public String getPackacgeName() {
        return this.a != null ? this.a.n() : "";
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public StartAppNativeAd.CampaignAction getCampaignAction() {
        StartAppNativeAd.CampaignAction campaignAction = StartAppNativeAd.CampaignAction.OPEN_MARKET;
        if (this.a != null && this.a.r()) {
            campaignAction = StartAppNativeAd.CampaignAction.LAUNCH_APP;
        }
        return campaignAction;
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public boolean isApp() {
        boolean z = true;
        if (this.a != null) {
            z = this.a.u();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AdDetails a() {
        return this.a;
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public void registerViewForInteraction(View view) {
        a(view);
        this.j.get().setOnClickListener(new View.OnClickListener() { // from class: com.startapp.sdk.ads.nativead.NativeAdDetails.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NativeAdDetails.a(NativeAdDetails.this, view2);
            }
        });
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public void registerViewForInteraction(View view, List<View> list) {
        registerViewForInteraction(view, list, null);
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public void registerViewForInteraction(View view, List<View> list, NativeAdDisplayListener nativeAdDisplayListener) {
        if (list != null && !list.isEmpty() && this.j.get() == null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.startapp.sdk.ads.nativead.NativeAdDetails.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NativeAdDetails.a(NativeAdDetails.this, view2);
                }
            };
            for (View view2 : list) {
                view2.setOnClickListener(onClickListener);
            }
            a(view);
        } else {
            registerViewForInteraction(view);
        }
        if (nativeAdDisplayListener != null) {
            this.l = new b(nativeAdDisplayListener);
        }
    }

    @Override // com.startapp.sdk.ads.nativead.NativeAdInterface
    public void unregisterView() {
        e();
        View view = this.j.get();
        this.j.clear();
        if (view != null && Build.VERSION.SDK_INT >= 12 && this.k != null) {
            view.removeOnAttachStateChangeListener(this.k);
        }
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
        if (this.d != null) {
            this.d.recycle();
            this.d = null;
        }
    }

    private void a(View view) {
        this.j = new WeakReference<>(view);
        if (view.hasWindowFocus() || Build.VERSION.SDK_INT < 12) {
            c();
        } else {
            view.addOnAttachStateChangeListener(g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.i == null && !this.e) {
            View view = this.j.get();
            if (view == null) {
                if (this.l != null) {
                    this.l.adNotDisplayed(this);
                    return;
                }
                return;
            }
            h hVar = new h(view.getContext(), new String[]{this.a.d()}, new TrackingParams(this.h), f());
            hVar.a(new h.a() { // from class: com.startapp.sdk.ads.nativead.NativeAdDetails.5
                @Override // com.startapp.sdk.adsbase.h.a
                public final void onSent() {
                    NativeAdDetails.d(NativeAdDetails.this);
                    if (NativeAdDetails.this.l != null) {
                        NativeAdDetails.this.l.adDisplayed(NativeAdDetails.this);
                    }
                }
            });
            this.i = new com.startapp.sdk.adsbase.k.b(this.j, hVar, d());
            this.i.a(new b.a() { // from class: com.startapp.sdk.ads.nativead.NativeAdDetails.6
                @Override // com.startapp.sdk.adsbase.k.b.a
                public final void a() {
                    if (NativeAdDetails.this.l != null && !NativeAdDetails.this.f) {
                        NativeAdDetails.this.l.adHidden(NativeAdDetails.this);
                        NativeAdDetails.g(NativeAdDetails.this);
                    }
                }
            });
            this.i.a();
        }
    }

    private static int d() {
        return BannerMetaData.a().b().q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.i != null) {
            this.i.b();
            this.i = null;
        }
    }

    private long f() {
        return this.a.y() != null ? TimeUnit.SECONDS.toMillis(this.a.y().longValue()) : TimeUnit.SECONDS.toMillis(MetaData.E().F());
    }

    private View.OnAttachStateChangeListener g() {
        if (this.k == null) {
            this.k = new View.OnAttachStateChangeListener() { // from class: com.startapp.sdk.ads.nativead.NativeAdDetails.7
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View view) {
                    NativeAdDetails.this.c();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View view) {
                    NativeAdDetails.this.e();
                    view.removeOnAttachStateChangeListener(NativeAdDetails.this.k);
                }
            };
        }
        return this.k;
    }
}
