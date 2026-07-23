package com.startapp.sdk.adsbase.j;

import com.startapp.common.SDKException;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class m {
    public abstract void a(String str, Object obj, boolean z, boolean z2) throws SDKException;

    public abstract void a(String str, Set<String> set) throws SDKException;

    public final void a(String str, Object obj, boolean z) throws SDKException {
        a(str, obj, z, true);
    }
}
