package com.startapp.sdk.ads.video.vast.model;

import android.content.Context;
import android.util.DisplayMetrics;
import com.startapp.common.b.e;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class a {
    protected int a;
    protected int b;
    private int c;

    public a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.a = displayMetrics.widthPixels;
        this.b = displayMetrics.heightPixels;
        this.c = this.a * this.b;
        if (e.a(context).equals("WIFI")) {
            return;
        }
        this.c = (int) (0.75f * this.c);
    }

    public final com.startapp.sdk.ads.video.vast.model.a.b a(List<com.startapp.sdk.ads.video.vast.model.a.b> list) {
        if (list != null) {
            Iterator<com.startapp.sdk.ads.video.vast.model.a.b> it = list.iterator();
            while (it.hasNext()) {
                com.startapp.sdk.ads.video.vast.model.a.b next = it.next();
                if (!next.f() || !next.b().matches("video/.*(?i)(mp4|3gpp|mp2t|webm|matroska)")) {
                    it.remove();
                }
            }
            if (list.size() != 0) {
                Collections.sort(list, a());
                if (list != null && list.size() > 0) {
                    return list.get(0);
                }
                return null;
            }
        }
        return null;
    }

    protected Comparator<com.startapp.sdk.ads.video.vast.model.a.b> a() {
        return new C0032a(this, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.ads.video.vast.model.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public class C0032a implements Comparator<com.startapp.sdk.ads.video.vast.model.a.b> {
        private C0032a() {
        }

        /* synthetic */ C0032a(a aVar, byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.startapp.sdk.ads.video.vast.model.a.b bVar, com.startapp.sdk.ads.video.vast.model.a.b bVar2) {
            com.startapp.sdk.ads.video.vast.model.a.b bVar3 = bVar;
            com.startapp.sdk.ads.video.vast.model.a.b bVar4 = bVar2;
            int intValue = bVar3.d().intValue() * bVar3.e().intValue();
            int intValue2 = bVar4.d().intValue() * bVar4.e().intValue();
            int abs = Math.abs(intValue - a.this.c);
            int abs2 = Math.abs(intValue2 - a.this.c);
            if (abs < abs2) {
                return -1;
            }
            if (abs > abs2) {
                return 1;
            }
            return 0;
        }
    }
}
