package com.startapp.networkTest.data;

import com.startapp.networkTest.enums.MemoryStates;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class b implements Cloneable {
    public long MemoryFree;
    public MemoryStates MemoryState = MemoryStates.Unknown;
    public long MemoryTotal;
    public long MemoryUsed;

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
