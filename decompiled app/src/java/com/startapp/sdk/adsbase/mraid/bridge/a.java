package com.startapp.sdk.adsbase.mraid.bridge;

import android.app.Activity;
import android.content.Context;
import com.startapp.sdk.adsbase.infoevents.e;
import java.net.URLDecoder;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class a implements b {
    private static final String TAG = "BaseMraidController";
    protected InterfaceC0043a openListener;

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.mraid.bridge.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface InterfaceC0043a {
        boolean onClickEvent(String str);
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public abstract void close();

    public abstract boolean isFeatureSupported(String str);

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public abstract void setOrientationProperties(Map<String, String> map);

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public abstract void useCustomClose(String str);

    public a(InterfaceC0043a interfaceC0043a) {
        this.openListener = interfaceC0043a;
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public void resize() {
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public void expand(String str) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.startapp.sdk.adsbase.mraid.bridge.a] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public boolean open(String str) {
        boolean z = this;
        String str2 = str;
        try {
            String trim = URLDecoder.decode(str2, "UTF-8").trim();
            str2 = trim;
            if (trim.startsWith("sms")) {
                z = z.openSMS(str2);
            } else if (str2.startsWith("tel")) {
                z = z.openTel(str2);
            } else {
                z = z.openListener.onClickEvent(str2);
            }
            return z;
        } catch (Exception e) {
            e.getMessage();
            return z.openListener.onClickEvent(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyOrientationProperties(Activity activity, com.startapp.sdk.adsbase.mraid.b.a aVar) {
        int i;
        try {
            boolean z = activity.getResources().getConfiguration().orientation == 1;
            if (aVar.b == 0) {
                i = 1;
            } else {
                if (aVar.b != 1) {
                    if (aVar.a) {
                        i = -1;
                    } else if (z) {
                        i = 1;
                    }
                }
                i = 0;
            }
            com.startapp.common.b.b.a(activity, i);
        } catch (Throwable th) {
            new e(th).a((Context) activity);
        }
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public void setResizeProperties(Map<String, String> map) {
        new StringBuilder("setResizeProperties ").append(map);
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public void setExpandProperties(Map<String, String> map) {
        new StringBuilder("setExpandProperties ").append(map);
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public void createCalendarEvent(String str) {
        isFeatureSupported("calendar");
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public void playVideo(String str) {
        isFeatureSupported("inlineVideo");
    }

    @Override // com.startapp.sdk.adsbase.mraid.bridge.b
    public void storePicture(String str) {
        isFeatureSupported("storePicture");
    }

    public boolean openSMS(String str) {
        isFeatureSupported("sms");
        return true;
    }

    public boolean openTel(String str) {
        isFeatureSupported("tel");
        return true;
    }
}
