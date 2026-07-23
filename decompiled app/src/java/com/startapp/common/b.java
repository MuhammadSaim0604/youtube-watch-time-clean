package com.startapp.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class b {
    private static final Object f;
    private static b g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap<>();
    private final HashMap<String, ArrayList<C0016b>> c = new HashMap<>();
    private final ArrayList<a> d = new ArrayList<>();
    private final Handler e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.common.b$b  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public static class C0016b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;

        C0016b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public static class a {
        final Intent a;
        final ArrayList<C0016b> b;

        a(Intent intent, ArrayList<C0016b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    static {
        com.startapp.common.b.b.a(b.class);
        f = new Object();
    }

    public static b a(Context context) {
        b bVar;
        synchronized (f) {
            if (g == null) {
                g = new b(context.getApplicationContext());
            }
            bVar = g;
        }
        return bVar;
    }

    private b(Context context) {
        this.a = context;
        this.e = new Handler(context.getMainLooper()) { // from class: com.startapp.common.b.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.a();
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.b) {
            C0016b c0016b = new C0016b(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.b.get(broadcastReceiver);
            ArrayList<IntentFilter> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>(1);
                this.b.put(broadcastReceiver, arrayList2);
            }
            arrayList2.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C0016b> arrayList3 = this.c.get(action);
                ArrayList<C0016b> arrayList4 = arrayList3;
                if (arrayList3 == null) {
                    arrayList4 = new ArrayList<>(1);
                    this.c.put(action, arrayList4);
                }
                arrayList4.add(c0016b);
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.b) {
            ArrayList<IntentFilter> remove = this.b.remove(broadcastReceiver);
            if (remove != null) {
                for (int i = 0; i < remove.size(); i++) {
                    IntentFilter intentFilter = remove.get(i);
                    for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                        String action = intentFilter.getAction(i2);
                        ArrayList<C0016b> arrayList = this.c.get(action);
                        if (arrayList != null) {
                            int i3 = 0;
                            while (i3 < arrayList.size()) {
                                if (arrayList.get(i3).b == broadcastReceiver) {
                                    arrayList.remove(i3);
                                    i3--;
                                }
                                i3++;
                            }
                            if (arrayList.size() <= 0) {
                                this.c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean a(Intent intent) {
        synchronized (this.b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                new StringBuilder("Resolving type ").append(resolveTypeIfNeeded).append(" scheme ").append(scheme).append(" of intent ").append(intent);
            }
            ArrayList<C0016b> arrayList = this.c.get(intent.getAction());
            if (arrayList != null) {
                if (z) {
                    new StringBuilder("Action list: ").append(arrayList);
                }
                ArrayList arrayList2 = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    C0016b c0016b = arrayList.get(i);
                    if (z) {
                        new StringBuilder("Matching against filter ").append(c0016b.a);
                    }
                    if (c0016b.c) {
                        if (z) {
                        }
                    } else {
                        int match = c0016b.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                new StringBuilder("  Filter matched!  match=0x").append(Integer.toHexString(match));
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(c0016b);
                            c0016b.c = true;
                        }
                    }
                }
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        ((C0016b) arrayList2.get(i2)).c = false;
                    }
                    this.d.add(new a(intent, arrayList2));
                    if (!this.e.hasMessages(1)) {
                        this.e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    protected final void a() {
        a[] aVarArr;
        while (true) {
            synchronized (this.b) {
                int size = this.d.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.d.toArray(aVarArr);
                this.d.clear();
            }
            for (a aVar : aVarArr) {
                for (int i = 0; i < aVar.b.size(); i++) {
                    aVar.b.get(i).b.onReceive(this.a, aVar.a);
                }
            }
        }
    }
}
