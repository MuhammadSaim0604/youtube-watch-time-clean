package com.startapp.sdk.ads.video.vast.model;

import android.text.TextUtils;
import com.startapp.sdk.ads.video.vast.model.a.d;
import com.startapp.sdk.ads.video.vast.model.a.e;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.omsdk.AdVerification;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class c {
    private HashMap<VASTEventType, List<com.startapp.sdk.ads.video.vast.model.a.c>> a;
    private List<com.startapp.sdk.ads.video.vast.model.a.b> b;
    private int c;
    private e d;
    private List<String> e;
    private List<String> f;
    private int g;
    private com.startapp.sdk.ads.video.vast.model.a.b h = null;
    private List<com.startapp.sdk.ads.video.vast.model.a.a> i;
    private AdVerification j;

    public c(Document document) {
        this.c = c(document);
        this.a = a(document);
        this.b = b(document);
        this.d = d(document);
        this.e = a(document, "//Impression");
        this.f = a(document, "//Error");
        this.g = e(document);
        this.i = f(document);
        this.j = g(document);
    }

    public final boolean a(a aVar) {
        com.startapp.sdk.ads.video.vast.model.a.b bVar;
        com.startapp.sdk.ads.video.vast.model.a.b a;
        boolean z = true;
        List<String> list = this.e;
        if (list == null || list.size() == 0) {
            z = false;
        }
        List<com.startapp.sdk.ads.video.vast.model.a.b> list2 = this.b;
        if (list2 == null || list2.size() == 0) {
            z = false;
        }
        if (!z) {
            bVar = null;
        } else {
            com.startapp.sdk.ads.video.vast.model.a.b bVar2 = null;
            if (aVar != null && (a = aVar.a(this.b)) != null && !TextUtils.isEmpty(a.a())) {
                bVar2 = a;
            }
            new StringBuilder("Validator returns: ").append(bVar2 != null ? "valid" : "not valid (no media file)");
            bVar = bVar2;
        }
        this.h = bVar;
        return this.h != null;
    }

    public final HashMap<VASTEventType, List<com.startapp.sdk.ads.video.vast.model.a.c>> a() {
        return this.a;
    }

    public final e b() {
        return this.d;
    }

    public final List<String> c() {
        return this.e;
    }

    public final List<String> d() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public final com.startapp.sdk.ads.video.vast.model.a.b f() {
        return this.h;
    }

    public final AdVerification g() {
        return this.j;
    }

    private HashMap<VASTEventType, List<com.startapp.sdk.ads.video.vast.model.a.c>> a(Document document) {
        ArrayList arrayList;
        HashMap<VASTEventType, List<com.startapp.sdk.ads.video.vast.model.a.c>> hashMap = new HashMap<>();
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate("/VASTS/VAST/Ad/InLine/Creatives/Creative/Linear/TrackingEvents/Tracking|/VASTS/VAST/Ad/InLine/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking|/VASTS/VAST/Ad/Wrapper/Creatives/Creative/Linear/TrackingEvents/Tracking|/VASTS/VAST/Ad/Wrapper/Creatives/Creative/NonLinearAds/TrackingEvents/Tracking", document, XPathConstants.NODESET);
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node item = nodeList.item(i);
                    NamedNodeMap attributes = item.getAttributes();
                    String nodeValue = attributes.getNamedItem("event").getNodeValue();
                    try {
                        VASTEventType valueOf = VASTEventType.valueOf(nodeValue);
                        String b = Ad.AnonymousClass2.b(item);
                        int i2 = -1;
                        Node namedItem = attributes.getNamedItem("offset");
                        if (namedItem != null) {
                            String nodeValue2 = namedItem.getNodeValue();
                            if (nodeValue2 != null) {
                                try {
                                    if (nodeValue2.contains("%")) {
                                        i2 = (this.c / 100) * Integer.parseInt(nodeValue2.replace("%", ""));
                                    } else {
                                        i2 = a(nodeValue2) * 1000;
                                    }
                                } catch (Exception e) {
                                }
                            }
                        }
                        if (hashMap.containsKey(valueOf)) {
                            arrayList = hashMap.get(valueOf);
                        } else {
                            arrayList = new ArrayList();
                            hashMap.put(valueOf, arrayList);
                        }
                        arrayList.add(new com.startapp.sdk.ads.video.vast.model.a.c(b, i2));
                    } catch (IllegalArgumentException e2) {
                        new StringBuilder("Event:").append(nodeValue).append(" is not valid. Skipping it.");
                    }
                }
            }
            return hashMap;
        } catch (Exception e3) {
            e3.getMessage();
            return null;
        }
    }

    private static List<com.startapp.sdk.ads.video.vast.model.a.b> b(Document document) {
        ArrayList arrayList = new ArrayList();
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate("//MediaFile", document, XPathConstants.NODESET);
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    com.startapp.sdk.ads.video.vast.model.a.b bVar = new com.startapp.sdk.ads.video.vast.model.a.b();
                    Node item = nodeList.item(i);
                    NamedNodeMap attributes = item.getAttributes();
                    Node namedItem = attributes.getNamedItem("apiFramework");
                    bVar.e(namedItem == null ? null : namedItem.getNodeValue());
                    Node namedItem2 = attributes.getNamedItem("bitrate");
                    bVar.a(namedItem2 == null ? null : Integer.valueOf(namedItem2.getNodeValue()));
                    Node namedItem3 = attributes.getNamedItem("delivery");
                    bVar.c(namedItem3 == null ? null : namedItem3.getNodeValue());
                    Node namedItem4 = attributes.getNamedItem("height");
                    bVar.c(namedItem4 == null ? null : Integer.valueOf(namedItem4.getNodeValue()));
                    Node namedItem5 = attributes.getNamedItem("width");
                    bVar.b(namedItem5 == null ? null : Integer.valueOf(namedItem5.getNodeValue()));
                    Node namedItem6 = attributes.getNamedItem("id");
                    bVar.b(namedItem6 == null ? null : namedItem6.getNodeValue());
                    Node namedItem7 = attributes.getNamedItem("maintainAspectRatio");
                    bVar.b(namedItem7 == null ? null : Boolean.valueOf(namedItem7.getNodeValue()));
                    Node namedItem8 = attributes.getNamedItem("scalable");
                    bVar.a(namedItem8 == null ? null : Boolean.valueOf(namedItem8.getNodeValue()));
                    Node namedItem9 = attributes.getNamedItem("type");
                    bVar.d(namedItem9 == null ? null : namedItem9.getNodeValue());
                    bVar.a(Ad.AnonymousClass2.b(item));
                    if (bVar.f()) {
                        arrayList.add(bVar);
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private static int c(Document document) {
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate("//Duration", document, XPathConstants.NODESET);
            if (nodeList != null && 0 < nodeList.getLength()) {
                return a(Ad.AnonymousClass2.b(nodeList.item(0)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return Integer.MAX_VALUE;
    }

    private static e d(Document document) {
        e eVar = new e();
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate("//VideoClicks", document, XPathConstants.NODESET);
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    NodeList childNodes = nodeList.item(i).getChildNodes();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        Node item = childNodes.item(i2);
                        String nodeName = item.getNodeName();
                        String b = Ad.AnonymousClass2.b(item);
                        if (nodeName.equalsIgnoreCase("ClickTracking")) {
                            eVar.b().add(b);
                        } else if (nodeName.equalsIgnoreCase("ClickThrough")) {
                            eVar.a(b);
                        } else if (nodeName.equalsIgnoreCase("CustomClick")) {
                            eVar.c().add(b);
                        }
                    }
                }
            }
            return eVar;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private static int e(Document document) {
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate("//Linear", document, XPathConstants.NODESET);
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    try {
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    if (nodeList.item(i).getAttributes().getNamedItem("skipoffset") == null) {
                        continue;
                    } else {
                        return a(nodeList.item(i).getAttributes().getNamedItem("skipoffset").getNodeValue());
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return Integer.MAX_VALUE;
    }

    private static List<com.startapp.sdk.ads.video.vast.model.a.a> f(Document document) {
        ArrayList arrayList = new ArrayList();
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate("//Icon", document, XPathConstants.NODESET);
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    com.startapp.sdk.ads.video.vast.model.a.a aVar = new com.startapp.sdk.ads.video.vast.model.a.a();
                    Node item = nodeList.item(i);
                    NamedNodeMap attributes = item.getAttributes();
                    Node namedItem = attributes.getNamedItem("program");
                    aVar.a(namedItem == null ? null : namedItem.getNodeValue());
                    Node namedItem2 = attributes.getNamedItem("width");
                    aVar.a(namedItem2 == null ? null : Integer.valueOf(namedItem2.getNodeValue()));
                    Node namedItem3 = attributes.getNamedItem("height");
                    aVar.b(namedItem3 == null ? null : Integer.valueOf(namedItem3.getNodeValue()));
                    Node namedItem4 = attributes.getNamedItem("xPosition");
                    aVar.c(namedItem4 == null ? null : Integer.valueOf(namedItem4.getNodeValue()));
                    Node namedItem5 = attributes.getNamedItem("yPosition");
                    aVar.d(namedItem5 == null ? null : Integer.valueOf(namedItem5.getNodeValue()));
                    Node namedItem6 = attributes.getNamedItem("duration");
                    aVar.e(namedItem6 == null ? null : Integer.valueOf(namedItem6.getNodeValue()));
                    Node namedItem7 = attributes.getNamedItem("offset");
                    aVar.f(namedItem7 == null ? null : Integer.valueOf(namedItem7.getNodeValue()));
                    Node namedItem8 = attributes.getNamedItem("apiFramework");
                    aVar.b(namedItem8 == null ? null : namedItem8.getNodeValue());
                    Node namedItem9 = attributes.getNamedItem("pxratio");
                    aVar.g(namedItem9 == null ? null : Integer.valueOf(namedItem9.getNodeValue()));
                    NodeList childNodes = item.getChildNodes();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        Node item2 = childNodes.item(i2);
                        String nodeName = item2.getNodeName();
                        String b = Ad.AnonymousClass2.b(item2);
                        if (nodeName.equalsIgnoreCase("IconClicks")) {
                            NodeList childNodes2 = item.getChildNodes();
                            for (int i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                Node item3 = childNodes.item(i2);
                                String nodeName2 = item3.getNodeName();
                                String b2 = Ad.AnonymousClass2.b(item3);
                                if (nodeName2.equalsIgnoreCase("ClickThrough")) {
                                    aVar.c(b2);
                                } else if (nodeName2.equalsIgnoreCase("IconViewTracking")) {
                                    aVar.c().add(b2);
                                }
                            }
                        } else if (nodeName.equalsIgnoreCase("ClickTracking")) {
                            aVar.b().add(b);
                        } else if (nodeName.equalsIgnoreCase("StaticResource")) {
                            d dVar = new d();
                            dVar.b(b);
                            Node namedItem10 = item.getAttributes().getNamedItem("creativeType");
                            dVar.a(namedItem10 == null ? null : namedItem10.getNodeValue());
                            if (dVar.a()) {
                                aVar.a().add(dVar);
                            }
                        }
                    }
                    if (aVar.d()) {
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private static List<String> a(Document document, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate(str, document, XPathConstants.NODESET);
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    arrayList.add(Ad.AnonymousClass2.b(nodeList.item(i)));
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private static AdVerification g(Document document) {
        AdVerification adVerification = null;
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().evaluate("//AdVerifications", document, XPathConstants.NODESET);
            if (nodeList != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    NodeList childNodes = nodeList.item(i).getChildNodes();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        Node item = childNodes.item(i2);
                        if (item.getNodeName().equalsIgnoreCase("Verification")) {
                            String str = null;
                            String str2 = null;
                            String str3 = null;
                            String str4 = "";
                            NamedNodeMap attributes = item.getAttributes();
                            if (attributes != null && attributes.getNamedItem("vendor") != null) {
                                str = attributes.getNamedItem("vendor").getNodeValue();
                            }
                            NodeList childNodes2 = item.getChildNodes();
                            for (int i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                Node item2 = childNodes2.item(i3);
                                if (item2.getNodeName().equalsIgnoreCase("JavaScriptResource")) {
                                    Node namedItem = item2.getAttributes().getNamedItem("apiFramework");
                                    if (namedItem != null) {
                                        str4 = namedItem.getNodeValue();
                                    }
                                    str2 = Ad.AnonymousClass2.b(item2);
                                } else if (item2.getNodeName().equalsIgnoreCase("VerificationParameters")) {
                                    str3 = Ad.AnonymousClass2.b(item2);
                                }
                            }
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && "omid".equalsIgnoreCase(str4)) {
                                arrayList.add(new VerificationDetails(str, str2, str3));
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    adVerification = new AdVerification((VerificationDetails[]) arrayList.toArray(new VerificationDetails[arrayList.size()]));
                }
            }
            return adVerification;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private static int a(String str) {
        String[] split = str.split(":");
        return (Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]);
    }
}
