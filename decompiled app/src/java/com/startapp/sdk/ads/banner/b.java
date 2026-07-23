package com.startapp.sdk.ads.banner;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
final class b {
    private Context a;
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, AttributeSet attributeSet) {
        this.a = context;
        this.b = a(attributeSet, "adTag");
    }

    private String a(AttributeSet attributeSet, String str) {
        String str2 = null;
        try {
            int attributeResourceValue = attributeSet.getAttributeResourceValue(null, str, -1);
            if (attributeResourceValue != -1) {
                str2 = this.a.getResources().getString(attributeResourceValue);
            } else {
                str2 = attributeSet.getAttributeValue(null, str);
            }
        } catch (Exception e) {
        }
        return str2;
    }

    public final String a() {
        return this.b;
    }
}
