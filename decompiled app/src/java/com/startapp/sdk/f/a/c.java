package com.startapp.sdk.f.a;

import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class c extends e {
    private final List<InfoEventCategory> a;

    public c(List<InfoEventCategory> list) {
        this.a = list;
    }

    @Override // com.startapp.sdk.f.a.e
    public final boolean a(Object obj) {
        if (obj instanceof com.startapp.sdk.adsbase.infoevents.e) {
            return this.a.contains(((com.startapp.sdk.adsbase.infoevents.e) obj).g());
        }
        return false;
    }
}
