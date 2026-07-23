package com.startapp.sdk.adsbase.mraid.bridge;

import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public interface b {
    void close();

    void createCalendarEvent(String str);

    void expand(String str);

    boolean open(String str);

    void playVideo(String str);

    void resize();

    void setExpandProperties(Map<String, String> map);

    void setOrientationProperties(Map<String, String> map);

    void setResizeProperties(Map<String, String> map);

    void storePicture(String str);

    void useCustomClose(String str);
}
