package com.startapp.sdk.adsbase.adinformation;

import com.startapp.common.parser.d;
import com.startapp.sdk.adsbase.adinformation.AdInformationPositions;
import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class AdInformationOverrides implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean enableOverride = false;
    private boolean enable = true;
    private boolean positionOverride = false;
    @d(b = AdInformationPositions.Position.class)
    private AdInformationPositions.Position position = AdInformationPositions.Position.getByName(AdInformationPositions.a);

    private AdInformationOverrides() {
    }

    public static AdInformationOverrides a() {
        return new AdInformationOverrides();
    }

    public final boolean b() {
        return this.enable;
    }

    public final void a(boolean z) {
        this.enable = z;
        this.enableOverride = true;
    }

    public final AdInformationPositions.Position c() {
        return this.position;
    }

    public final void a(AdInformationPositions.Position position) {
        this.position = position;
        if (position != null) {
            this.positionOverride = true;
        } else {
            this.positionOverride = false;
        }
    }

    public final boolean d() {
        return this.positionOverride;
    }

    public final boolean e() {
        return this.enableOverride;
    }
}
