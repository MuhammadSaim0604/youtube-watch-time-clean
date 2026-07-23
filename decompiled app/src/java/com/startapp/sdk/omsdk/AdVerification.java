package com.startapp.sdk.omsdk;

import com.startapp.common.parser.d;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class AdVerification implements Serializable {
    private static final long serialVersionUID = 1;
    @d(b = VerificationDetails.class, f = "adVerifications")
    private VerificationDetails[] adVerification;

    public AdVerification() {
    }

    public AdVerification(VerificationDetails[] verificationDetailsArr) {
        this.adVerification = verificationDetailsArr;
    }

    public final List<VerificationDetails> a() {
        if (this.adVerification == null) {
            return null;
        }
        return Arrays.asList(this.adVerification);
    }
}
