package com.startapp.sdk.f.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Pair;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class b extends d {
    private BroadcastReceiver b;

    static {
        b.class.getSimpleName();
    }

    public b(String str, Map<String, String> map) {
        super(str, map);
    }

    @Override // com.startapp.sdk.f.a.e
    public final void a(Context context, final com.startapp.sdk.f.a aVar) throws Exception {
        super.a(context, aVar);
        if (this.b == null) {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.startapp.sdk.f.a.b.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context2, Intent intent) {
                    aVar.a(new Pair(b.this, intent));
                }
            };
            this.b = broadcastReceiver;
            context.registerReceiver(broadcastReceiver, new IntentFilter(this.a));
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.startapp.sdk.f.a.e
    public final void a(Context context) throws Exception {
        super.a(context);
        if (this.b == null) {
            throw new IllegalStateException();
        }
        context.unregisterReceiver(this.b);
        this.b = null;
    }
}
