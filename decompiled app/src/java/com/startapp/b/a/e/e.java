package com.startapp.b.a.e;

import com.startapp.b.a.a.f;
import java.io.DataInput;
import java.io.IOException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class e extends d {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.startapp.b.a.e.d
    public final DataInput a(byte[] bArr) {
        DataInput a = super.a(bArr);
        try {
            a.readInt();
            return a;
        } catch (IOException e) {
            throw new RuntimeException("problem incrementInputStreamForBackwordCompatability", e);
        }
    }

    @Override // com.startapp.b.a.e.d
    protected final f a(DataInput dataInput) throws IOException {
        long readInt = dataInput.readInt();
        f fVar = new f(readInt << 6);
        a(dataInput, fVar, readInt);
        return fVar;
    }
}
