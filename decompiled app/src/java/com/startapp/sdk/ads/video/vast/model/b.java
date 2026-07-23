package com.startapp.sdk.ads.video.vast.model;

import android.content.Context;
import java.util.Comparator;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b extends a {
    private final double c;
    private final int d;
    private final int e;

    static /* synthetic */ Double a(int i, int i2, double d, int i3) {
        return Double.valueOf((40.0d * Math.abs(Math.log((i / i2) / d))) + (60.0d * Math.abs(Math.log((i * i2) / i3))));
    }

    public b(Context context, int i) {
        super(context);
        this.e = i;
        this.c = this.a / this.b;
        this.d = this.a * this.b;
    }

    @Override // com.startapp.sdk.ads.video.vast.model.a
    protected final Comparator<com.startapp.sdk.ads.video.vast.model.a.b> a() {
        return new Comparator<com.startapp.sdk.ads.video.vast.model.a.b>() { // from class: com.startapp.sdk.ads.video.vast.model.b.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(com.startapp.sdk.ads.video.vast.model.a.b bVar, com.startapp.sdk.ads.video.vast.model.a.b bVar2) {
                com.startapp.sdk.ads.video.vast.model.a.b bVar3 = bVar;
                com.startapp.sdk.ads.video.vast.model.a.b bVar4 = bVar2;
                double doubleValue = b.a(bVar3.d().intValue(), bVar3.e().intValue(), b.this.c, b.this.d).doubleValue();
                double doubleValue2 = b.a(bVar4.d().intValue(), bVar4.e().intValue(), b.this.c, b.this.d).doubleValue();
                if (doubleValue < doubleValue2) {
                    return -1;
                }
                if (doubleValue > doubleValue2) {
                    return 1;
                }
                Integer c = bVar3.c();
                Integer c2 = bVar4.c();
                if (c == null && c2 == null) {
                    return 0;
                }
                if (c == null) {
                    return 1;
                }
                if (c2 != null) {
                    Integer valueOf = Integer.valueOf(Math.abs(b.this.e - c.intValue()));
                    Integer valueOf2 = Integer.valueOf(Math.abs(b.this.e - c2.intValue()));
                    int intValue = valueOf.intValue();
                    int intValue2 = valueOf2.intValue();
                    if (intValue < intValue2) {
                        return -1;
                    }
                    return intValue == intValue2 ? 0 : 1;
                }
                return -1;
            }
        };
    }
}
