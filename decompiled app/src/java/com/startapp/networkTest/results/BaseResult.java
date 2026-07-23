package com.startapp.networkTest.results;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class BaseResult implements Cloneable {
    public String GUID;
    public String ProjectId;
    public String Version = "20200514123200";

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public BaseResult(String str, String str2) {
        this.ProjectId = "";
        this.GUID = "";
        this.ProjectId = str;
        this.GUID = str2;
    }
}
