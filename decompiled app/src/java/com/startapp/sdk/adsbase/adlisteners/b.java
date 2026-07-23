package com.startapp.sdk.adsbase.adlisteners;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.infoevents.e;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class b {
    public abstract void a(Ad ad);

    public abstract void b(Ad ad);

    public static b a(Context context, AdEventListener adEventListener) {
        if (adEventListener instanceof b) {
            return (b) adEventListener;
        }
        if (adEventListener != null) {
            return new C0035b(context, adEventListener);
        }
        return a.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.adlisteners.b$b  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class C0035b extends b implements Handler.Callback {
        private Context a;
        private Handler b = new Handler(Looper.getMainLooper(), this);
        private AdEventListener c;

        public C0035b(Context context, AdEventListener adEventListener) {
            this.a = context;
            this.c = adEventListener;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.c == ((C0035b) obj).c;
        }

        public final int hashCode() {
            try {
                return System.identityHashCode(this.c);
            } catch (Throwable th) {
                new e(th).a(this.a);
                return 0;
            }
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.b
        public final void a(Ad ad) {
            Message.obtain(this.b, 1, ad).sendToTarget();
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.b
        public final void b(Ad ad) {
            Message.obtain(this.b, 2, ad).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1:
                        this.c.onReceiveAd((Ad) message.obj);
                        break;
                    case 2:
                        this.c.onFailedToReceiveAd((Ad) message.obj);
                        break;
                }
            } catch (Throwable th) {
                new e(th).a(this.a);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class a extends b {
        public static final a a = new a();

        a() {
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.b
        public final void a(Ad ad) {
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.b
        public final void b(Ad ad) {
        }
    }
}
