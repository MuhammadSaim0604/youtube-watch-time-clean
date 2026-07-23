package com.startapp.sdk.adsbase;

import android.content.Context;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.j.p;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class Ad implements Serializable {
    private static boolean b = false;
    private static final long serialVersionUID = 1;
    protected transient Context a;
    protected ActivityExtra activityExtra;
    private AdInformationOverrides adInfoOverride;
    protected String errorMessage;
    private AdDisplayListener.NotDisplayedReason notDisplayedReason;
    protected AdPreferences.Placement placement;
    private AdType type;
    private boolean videoCancelCallBack;
    protected Serializable extraData = null;
    protected Long adCacheTtl = null;
    private AdState state = AdState.UN_INITIALIZED;
    private Long lastLoadTime = null;
    protected boolean belowMinCPM = false;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum AdState {
        UN_INITIALIZED,
        PROCESSING,
        READY
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum AdType {
        INTERSTITIAL,
        RICH_TEXT,
        VIDEO,
        REWARDED_VIDEO,
        NON_VIDEO,
        VIDEO_NO_VAST
    }

    protected abstract void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar);

    public abstract String getAdId();

    public Ad(Context context, AdPreferences.Placement placement) {
        this.a = context;
        this.placement = placement;
        if (u.e()) {
            this.adInfoOverride = AdInformationOverrides.a();
        }
    }

    public Serializable getExtraData() {
        return this.extraData;
    }

    public Context getContext() {
        return this.a;
    }

    public void setContext(Context context) {
        this.a = context;
    }

    public void setActivityExtra(ActivityExtra activityExtra) {
        this.activityExtra = activityExtra;
    }

    public void setExtraData(Serializable serializable) {
        this.extraData = serializable;
    }

    public AdState getState() {
        return this.state;
    }

    public boolean isBelowMinCPM() {
        return this.belowMinCPM;
    }

    public void setState(AdState adState) {
        this.state = adState;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public AdInformationOverrides getAdInfoOverride() {
        return this.adInfoOverride;
    }

    public void setAdInfoOverride(AdInformationOverrides adInformationOverrides) {
        this.adInfoOverride = adInformationOverrides;
    }

    public Integer getConsentType() {
        return null;
    }

    public void setConsentType(Integer num) {
    }

    public Long getConsentTimestamp() {
        return null;
    }

    public void setConsentTimestamp(Long l) {
    }

    public Boolean getConsentApc() {
        return null;
    }

    public void setConsentApc(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdPreferences.Placement i() {
        return this.placement;
    }

    @Deprecated
    public boolean load() {
        return load(new AdPreferences(), null);
    }

    @Deprecated
    public boolean load(AdEventListener adEventListener) {
        return load(new AdPreferences(), adEventListener);
    }

    @Deprecated
    public boolean load(AdPreferences adPreferences) {
        return load(adPreferences, null);
    }

    @Deprecated
    public boolean load(AdPreferences adPreferences, AdEventListener adEventListener) {
        return load(adPreferences, com.startapp.sdk.adsbase.adlisteners.b.a(this.a, adEventListener), true);
    }

    public boolean load(AdPreferences adPreferences, final com.startapp.sdk.adsbase.adlisteners.b bVar, boolean z) {
        final com.startapp.sdk.adsbase.consent.a f = com.startapp.sdk.b.c.a(this.a).f();
        com.startapp.sdk.adsbase.adlisteners.b bVar2 = new com.startapp.sdk.adsbase.adlisteners.b() { // from class: com.startapp.sdk.adsbase.Ad.1
            @Override // com.startapp.sdk.adsbase.adlisteners.b
            public final void a(Ad ad) {
                Ad.this.lastLoadTime = Long.valueOf(System.currentTimeMillis());
                bVar.a(ad);
                f.a(ad.getConsentType(), ad.getConsentTimestamp(), ad.getConsentApc(), false, true);
                u.a(Ad.this.a, false, "Loaded " + u.a(ad) + " ad with creative ID - " + ad.getAdId());
            }

            @Override // com.startapp.sdk.adsbase.adlisteners.b
            public final void b(Ad ad) {
                bVar.b(ad);
                String errorMessage = ad.getErrorMessage();
                String str = errorMessage;
                if (errorMessage == null) {
                    str = "";
                } else if (str.contains("204")) {
                    str = "NO FILL";
                }
                u.a(Ad.this.a, true, "Failed to load " + u.a(ad) + " ad: " + str);
            }
        };
        if (!b) {
            SimpleTokenUtils.c(this.a);
            b = true;
        }
        boolean z2 = false;
        Object obj = "";
        if (this.state != AdState.UN_INITIALIZED) {
            z2 = true;
            obj = "load() was already called.";
        }
        if (!u.c(this.a)) {
            z2 = true;
            obj = "network not available.";
        }
        if (!MetaData.E().K()) {
            z2 = true;
            obj = "serving ads disabled";
        }
        if (z2) {
            setErrorMessage("Ad wasn't loaded: ".concat(String.valueOf(obj)));
            bVar2.b(this);
            return false;
        }
        setConsentType(f.d());
        setConsentTimestamp(f.e());
        setConsentApc(f.f());
        setState(AdState.PROCESSING);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(adPreferences, bVar2);
        if (adPreferences.getType() != null) {
            this.type = adPreferences.getType();
        }
        MetaData.E().a(this.a, adPreferences, p.d().c(), z, anonymousClass2, false);
        return true;
    }

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.Ad$2  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public class AnonymousClass2 implements com.startapp.sdk.adsbase.remoteconfig.b {
        private /* synthetic */ AdPreferences a;
        private /* synthetic */ com.startapp.sdk.adsbase.adlisteners.b b;

        AnonymousClass2(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
            this.a = adPreferences;
            this.b = bVar;
        }

        @Override // com.startapp.sdk.adsbase.remoteconfig.b
        public final void a(MetaDataRequest.RequestReason requestReason, boolean z) {
            Ad.this.a(this.a, this.b);
        }

        @Override // com.startapp.sdk.adsbase.remoteconfig.b
        public final void a() {
            Ad.this.a(this.a, this.b);
        }

        public static String a(Node node) {
            String str = null;
            try {
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                newTransformer.setOutputProperty("omit-xml-declaration", "yes");
                newTransformer.setOutputProperty("method", "xml");
                newTransformer.setOutputProperty("indent", "no");
                newTransformer.setOutputProperty("encoding", "UTF-8");
                StringWriter stringWriter = new StringWriter();
                newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
                str = stringWriter.toString();
            } catch (Exception e) {
            }
            return str;
        }

        public static Document a(String str) {
            Document document = null;
            try {
                DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
                newInstance.setIgnoringElementContentWhitespace(true);
                newInstance.setIgnoringComments(true);
                DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
                InputSource inputSource = new InputSource();
                inputSource.setCharacterStream(new StringReader(str));
                document = newDocumentBuilder.parse(inputSource);
            } catch (Exception e) {
            }
            return document;
        }

        public static String b(Node node) {
            NodeList childNodes = node.getChildNodes();
            String str = null;
            for (int i = 0; i < childNodes.getLength(); i++) {
                String trim = ((CharacterData) childNodes.item(i)).getData().trim();
                str = trim;
                if (trim.length() != 0) {
                    return str;
                }
            }
            return str;
        }
    }

    public boolean isReady() {
        return this.state == AdState.READY && !e_();
    }

    @Deprecated
    public boolean show() {
        return false;
    }

    public AdDisplayListener.NotDisplayedReason getNotDisplayedReason() {
        return this.notDisplayedReason;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AdDisplayListener.NotDisplayedReason notDisplayedReason) {
        this.notDisplayedReason = notDisplayedReason;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long c() {
        long f = f();
        return Long.valueOf(this.adCacheTtl == null ? f : Math.min(this.adCacheTtl.longValue(), f));
    }

    protected long f() {
        return CacheMetaData.a().b().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long b() {
        return this.lastLoadTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e_() {
        if (this.lastLoadTime != null && System.currentTimeMillis() - this.lastLoadTime.longValue() > c().longValue()) {
            return true;
        }
        return false;
    }

    public AdType getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        return this.videoCancelCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.videoCancelCallBack = z;
    }
}
