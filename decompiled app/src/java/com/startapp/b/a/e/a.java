package com.startapp.b.a.e;

import com.startapp.b.a.a.f;
import java.io.DataInput;
import java.io.IOException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a extends d {
    private final int a;
    private final int b;

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.startapp.b.a.e.d
    protected final f a(DataInput dataInput) throws IOException {
        f fVar = new f(this.a * this.b);
        a(dataInput, fVar, fVar.b());
        return fVar;
    }
}
