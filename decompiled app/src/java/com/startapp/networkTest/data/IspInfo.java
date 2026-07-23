package com.startapp.networkTest.data;

import java.io.Serializable;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class IspInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = -884736715180732782L;
    public String IpAddress = "";
    public String IspName = "";
    public String IspOrganizationalName = "";
    public String AutonomousSystemNumber = "";
    public String AutonomousSystemOrganization = "";
    public boolean SuccessfulIspLookup = false;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
