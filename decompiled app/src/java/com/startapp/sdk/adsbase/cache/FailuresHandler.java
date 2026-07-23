package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.j.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class FailuresHandler implements Serializable {
    private static final long serialVersionUID = 1;
    @com.startapp.common.parser.d(b = ArrayList.class, c = Integer.class)
    private List<Integer> intervals = Arrays.asList(10, 30, 60, 300);
    private boolean infiniteLastRetry = true;

    public final List<Integer> a() {
        return this.intervals;
    }

    public final boolean b() {
        return this.infiniteLastRetry;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FailuresHandler failuresHandler = (FailuresHandler) obj;
        return this.infiniteLastRetry == failuresHandler.infiniteLastRetry && u.b(this.intervals, failuresHandler.intervals);
    }

    public int hashCode() {
        return u.a(this.intervals, Boolean.valueOf(this.infiniteLastRetry));
    }
}
