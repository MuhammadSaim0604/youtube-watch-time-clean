package com.startapp.sdk.adsbase.model;

import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.BaseResponse;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class GetAdResponse extends BaseResponse {
    private static final long serialVersionUID = 1;
    @d(a = true)
    private AdInformationOverrides adInfoOverrides = AdInformationOverrides.a();
    @d(b = ArrayList.class, c = AdDetails.class)
    private List<AdDetails> adsDetails = new ArrayList();
    private boolean inAppBrowser;
    @d(b = inAppBrowserPreLoad.class)
    private inAppBrowserPreLoad inAppBrowserPreLoad;
    private String productId;
    private String publisherId;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    private enum inAppBrowserPreLoad {
        DISABLED,
        CONTENT,
        FULL
    }

    public final List<AdDetails> c() {
        return this.adsDetails;
    }

    public final AdInformationOverrides d() {
        return this.adInfoOverrides;
    }
}
