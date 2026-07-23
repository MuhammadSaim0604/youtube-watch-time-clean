package com.startapp.sdk.ads.list3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class c extends ArrayAdapter<d> {
    private String a;
    private String b;

    public c(Context context, List<d> list, String str, String str2) {
        super(context, 0, list);
        this.a = str;
        this.b = str2;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        long millis;
        RelativeLayout relativeLayout = view;
        if (relativeLayout == null) {
            e eVar2 = new e(getContext());
            eVar = eVar2;
            relativeLayout = eVar2.a();
        } else {
            eVar = (e) relativeLayout.getTag();
        }
        d item = getItem(i);
        eVar.a(AdsCommonMetaData.a().a(item.m()));
        eVar.c().setText(item.g());
        eVar.d().setText(item.h());
        Bitmap a = g.a().a(this.b).a(i, item.a(), item.i());
        if (a != null) {
            eVar.b().setImageBitmap(a);
            eVar.b().setTag("tag_ok");
        } else {
            eVar.b().setImageResource(17301651);
            eVar.b().setTag("tag_error");
        }
        eVar.e().setRating(item.j());
        eVar.a(item.p());
        f a2 = g.a().a(this.b);
        Context context = getContext();
        String c = item.c();
        TrackingParams trackingParams = new TrackingParams(this.a);
        if (item.q() != null) {
            millis = TimeUnit.SECONDS.toMillis(item.q().longValue());
        } else {
            millis = TimeUnit.SECONDS.toMillis(MetaData.E().F());
        }
        a2.a(context, c, trackingParams, millis);
        return relativeLayout;
    }
}
