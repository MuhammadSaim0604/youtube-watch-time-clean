package com.startapp.sdk.ads.list3d;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b {
    h d;
    int e = 0;
    Hashtable<String, Bitmap> b = new Hashtable<>();
    Set<String> c = new HashSet();
    ConcurrentLinkedQueue<C0028b> f = new ConcurrentLinkedQueue<>();
    HashMap<String, com.startapp.sdk.adsbase.h> a = new HashMap<>();

    public final Bitmap a(int i, String str, String str2) {
        Bitmap bitmap = this.b.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        if (!this.c.contains(str)) {
            this.c.add(str);
            if (this.e >= 15) {
                this.f.add(new C0028b(i, str, str2));
            } else {
                this.e++;
                new a(i, str, str2).execute(new Void[0]);
            }
        }
        return null;
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    class a extends AsyncTask<Void, Void, Bitmap> {
        private int a;
        private String b;
        private String c;

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Bitmap doInBackground(Void[] voidArr) {
            return com.startapp.common.b.c.b(this.c);
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            b bVar = b.this;
            bVar.e--;
            if (bitmap2 == null) {
                return;
            }
            b.this.b.put(this.b, bitmap2);
            if (b.this.d != null) {
                b.this.d.a(this.a);
            }
            b bVar2 = b.this;
            if (bVar2.f.isEmpty()) {
                return;
            }
            C0028b poll = bVar2.f.poll();
            new a(poll.a, poll.b, poll.c).execute(new Void[0]);
        }

        public a(int i, String str, String str2) {
            this.a = -1;
            this.a = i;
            this.b = str;
            this.c = str2;
        }
    }

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.ads.list3d.b$b  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    class C0028b {
        int a;
        String b;
        String c;

        public C0028b(int i, String str, String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }
    }
}
