package com.startapp.sdk.adsbase.adinformation;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import com.startapp.sdk.adsbase.j.t;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdInformationView extends RelativeLayout {
    private ImageView a;
    private RelativeLayout b;
    private View.OnClickListener c;
    private AdInformationConfig d;
    private ImageResourceConfig e;
    private AdPreferences.Placement f;
    private AdInformationPositions.Position g;

    public AdInformationView(Context context, AdInformationObject.Size size, AdPreferences.Placement placement, AdInformationOverrides adInformationOverrides, final View.OnClickListener onClickListener) {
        super(context);
        this.c = null;
        this.f = placement;
        this.c = new View.OnClickListener() { // from class: com.startapp.sdk.adsbase.adinformation.AdInformationView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClickListener.onClick(view);
            }
        };
        getContext();
        this.d = AdInformationObject.c();
        if (this.d == null) {
            this.d = AdInformationConfig.a();
        }
        this.e = this.d.a(size.a());
        if (adInformationOverrides != null && adInformationOverrides.d()) {
            this.g = adInformationOverrides.c();
        } else {
            this.g = this.d.a(this.f);
        }
        this.a = new ImageView(getContext());
        this.a.setContentDescription("info");
        this.a.setId(1475346433);
        this.a.setImageBitmap(this.e.a(getContext()));
        this.b = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.a(getContext(), (int) (this.e.b() * this.d.d())), t.a(getContext(), (int) (this.e.c() * this.d.d())));
        this.b.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(t.a(getContext(), this.e.b()), t.a(getContext(), this.e.c()));
        layoutParams2.setMargins(0, 0, 0, 0);
        this.a.setPadding(0, 0, 0, 0);
        this.g.addRules(layoutParams2);
        this.b.addView(this.a, layoutParams2);
        this.b.setOnClickListener(this.c);
        addView(this.b, layoutParams);
    }
}
