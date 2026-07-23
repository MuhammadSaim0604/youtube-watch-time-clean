package com.startapp.sdk.ads.video.vast.a;

import android.content.Context;
import com.startapp.common.b.e;
import com.startapp.sdk.ads.video.vast.model.VASTErrorCodes;
import com.startapp.sdk.ads.video.vast.model.c;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.j;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class a {
    private final int a;
    private final int b;
    private c c;
    private StringBuilder d = new StringBuilder(500);
    private long e = -1;

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final c a() {
        return this.c;
    }

    public final VASTErrorCodes a(Context context, String str, com.startapp.sdk.ads.video.vast.model.a aVar) {
        Document document;
        this.c = null;
        this.e = System.currentTimeMillis();
        VASTErrorCodes a = a(context, str, 0);
        VASTErrorCodes vASTErrorCodes = a;
        if (a == VASTErrorCodes.XMLParsingError) {
            new StringBuilder("processXml error ").append(vASTErrorCodes);
            return VASTErrorCodes.XMLParsingError;
        }
        String sb = this.d.toString();
        if (sb != null && sb.length() > 0) {
            document = Ad.AnonymousClass2.a("<VASTS>" + sb + "</VASTS>");
        } else {
            document = null;
        }
        Document document2 = document;
        if (document2 == null) {
            new StringBuilder("wrapMergedVastDocWithVasts error ").append(vASTErrorCodes);
            return VASTErrorCodes.XMLParsingError;
        }
        this.c = new c(document2);
        if (!this.c.a(aVar)) {
            new StringBuilder("validate error ").append(vASTErrorCodes);
            if (vASTErrorCodes == VASTErrorCodes.ErrorNone) {
                vASTErrorCodes = VASTErrorCodes.MediaNotSupported;
            }
        }
        return vASTErrorCodes;
    }

    private VASTErrorCodes a(Context context, String str, int i) {
        String str2;
        VASTErrorCodes vASTErrorCodes;
        NodeList elementsByTagName;
        if (i >= this.a) {
            new StringBuilder("VAST wrapping exceeded max limit of ").append(this.a);
            return VASTErrorCodes.WrapperLimitReached;
        } else if (System.currentTimeMillis() - this.e > this.b && this.e > 0) {
            return VASTErrorCodes.WrapperTimeout;
        } else {
            Document a = Ad.AnonymousClass2.a(str);
            if (a != null) {
                a.getDocumentElement().normalize();
            }
            if (a == null) {
                return VASTErrorCodes.XMLParsingError;
            }
            if (a != null && (elementsByTagName = a.getElementsByTagName("VAST")) != null && elementsByTagName.getLength() > 0) {
                str2 = Ad.AnonymousClass2.a(elementsByTagName.item(0));
            } else {
                str2 = null;
            }
            String str3 = str2;
            if (a.getChildNodes().getLength() == 0 || a.getChildNodes().item(0).getChildNodes().getLength() == 0 || str3 == null) {
                return VASTErrorCodes.WrapperNoReponse;
            }
            this.d.append(str3);
            NodeList elementsByTagName2 = a.getElementsByTagName("VASTAdTagURI");
            if (elementsByTagName2 == null || elementsByTagName2.getLength() == 0) {
                return VASTErrorCodes.ErrorNone;
            }
            try {
                e.a a2 = e.a(Ad.AnonymousClass2.b(elementsByTagName2.item(0)).replace(" ", "%20"), null, j.a(context, "User-Agent", "-1"), false);
                if (a2.a() != null) {
                    vASTErrorCodes = a(context, a2.a(), i + 1);
                } else {
                    vASTErrorCodes = VASTErrorCodes.WrapperNoReponse;
                }
                return vASTErrorCodes;
            } catch (Exception e) {
                return VASTErrorCodes.GeneralWrapperError;
            }
        }
    }
}
