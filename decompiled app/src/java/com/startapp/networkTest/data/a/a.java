package com.startapp.networkTest.data.a;

import com.startapp.common.parser.d;
import com.startapp.networkTest.enums.MultiSimVariants;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a implements Cloneable {
    public int ActiveSimCount = -1;
    public int ActiveSimCountMax = -1;
    public int DefaultDataSimId = -1;
    public int DefaultSmsSimId = -1;
    public int DefaultSimId = -1;
    public int DefaultVoiceSimId = -1;
    public MultiSimVariants MultiSimVariant = MultiSimVariants.Unknown;
    @d(b = ArrayList.class, c = b.class)
    public ArrayList<b> SimInfos = new ArrayList<>();

    public final b a(int i) {
        Iterator<b> it = this.SimInfos.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.SubscriptionId == i) {
                return next;
            }
        }
        return new b();
    }
}
