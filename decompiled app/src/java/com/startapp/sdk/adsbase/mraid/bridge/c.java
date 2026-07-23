package com.startapp.sdk.adsbase.mraid.bridge;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.startapp.sdk.adsbase.j.u;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class c extends WebViewClient {
    private static final String MRAID_JS = "mraid.js";
    private static final String MRAID_PREFIX = "mraid://";
    private static final String TAG = "MraidWebViewClient";
    private b controller;
    private boolean isMraidInjected = false;

    public c(b bVar) {
        this.controller = bVar;
    }

    protected boolean isMraidUrl(String str) {
        return str != null && str.startsWith(MRAID_PREFIX);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (webView == null || str == null) {
            return true;
        }
        if (u.a(webView.getContext(), str)) {
            return true;
        }
        if (isMraidUrl(str)) {
            return invokeMraidMethod(str);
        }
        return this.controller.open(str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.isMraidInjected || !matchesInjectionUrl(str)) {
            return super.shouldInterceptRequest(webView, str);
        }
        this.isMraidInjected = true;
        return createMraidInjectionResponse();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    public boolean matchesInjectionUrl(String str) {
        try {
            return MRAID_JS.equals(Uri.parse(str.toLowerCase(Locale.US)).getLastPathSegment());
        } catch (Exception e) {
            new StringBuilder("matchesInjectionUrl Exception: ").append(e.getMessage());
            return false;
        }
    }

    @TargetApi(11)
    private WebResourceResponse createMraidInjectionResponse() {
        return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(("javascript:" + com.startapp.sdk.adsbase.mraid.c.a.a()).getBytes()));
    }

    public boolean invokeMraidMethod(String str) {
        String str2;
        boolean containsKey;
        HashMap hashMap;
        Object obj;
        String[] split;
        String[] strArr = {"close", "resize"};
        String[] strArr2 = {"createCalendarEvent", "expand", "open", "playVideo", "storePicture", "useCustomClose"};
        String[] strArr3 = {"setOrientationProperties", "setResizeProperties"};
        try {
            String substring = str.substring(8);
            HashMap hashMap2 = new HashMap();
            int indexOf = substring.indexOf(63);
            if (indexOf != -1) {
                str2 = substring.substring(0, indexOf);
                for (String str3 : substring.substring(indexOf + 1).split("&")) {
                    int indexOf2 = str3.indexOf(61);
                    hashMap2.put(str3.substring(0, indexOf2), str3.substring(indexOf2 + 1));
                }
            } else {
                str2 = substring;
            }
            if (!Arrays.asList("close", "createCalendarEvent", "expand", "open", "playVideo", "resize", "setOrientationProperties", "setResizeProperties", "storePicture", "useCustomClose").contains(str2)) {
                new StringBuilder("command ").append(str2).append(" is unknown");
                hashMap = null;
            } else {
                String str4 = str2;
                if (str4.equals("createCalendarEvent")) {
                    containsKey = hashMap2.containsKey("eventJSON");
                } else if (str4.equals("open") || str4.equals("playVideo") || str4.equals("storePicture")) {
                    containsKey = hashMap2.containsKey("url");
                } else if (str4.equals("setOrientationProperties")) {
                    if (!hashMap2.containsKey("allowOrientationChange") || !hashMap2.containsKey("forceOrientation")) {
                        containsKey = false;
                    }
                    containsKey = true;
                } else if (str4.equals("setResizeProperties")) {
                    if (!hashMap2.containsKey("width") || !hashMap2.containsKey("height") || !hashMap2.containsKey("offsetX") || !hashMap2.containsKey("offsetY") || !hashMap2.containsKey("customClosePosition") || !hashMap2.containsKey("allowOffscreen")) {
                        containsKey = false;
                    }
                    containsKey = true;
                } else {
                    if (str4.equals("useCustomClose")) {
                        containsKey = hashMap2.containsKey("useCustomClose");
                    }
                    containsKey = true;
                }
                if (!containsKey) {
                    new StringBuilder("command URL ").append(str).append(" is missing parameters");
                    hashMap = null;
                } else {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("command", str2);
                    hashMap3.putAll(hashMap2);
                    hashMap = hashMap3;
                }
            }
            HashMap hashMap4 = hashMap;
            String str5 = (String) hashMap4.get("command");
            if (Arrays.asList(strArr).contains(str5)) {
                b.class.getDeclaredMethod(str5, new Class[0]).invoke(this.controller, new Object[0]);
            } else if (Arrays.asList(strArr2).contains(str5)) {
                Method declaredMethod = b.class.getDeclaredMethod(str5, String.class);
                boolean z = true;
                switch (str5.hashCode()) {
                    case -733616544:
                        if (str5.equals("createCalendarEvent")) {
                            z = false;
                            break;
                        }
                        break;
                    case 1614272768:
                        if (str5.equals("useCustomClose")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        obj = "eventJSON";
                        break;
                    case true:
                        obj = "useCustomClose";
                        break;
                    default:
                        obj = "url";
                        break;
                }
                declaredMethod.invoke(this.controller, (String) hashMap4.get(obj));
            } else if (Arrays.asList(strArr3).contains(str5)) {
                b.class.getDeclaredMethod(str5, Map.class).invoke(this.controller, hashMap4);
            }
            return true;
        } catch (Exception e) {
            new StringBuilder("failed to invoke ").append(str).append(". ").append(e.getMessage());
            return false;
        }
    }
}
