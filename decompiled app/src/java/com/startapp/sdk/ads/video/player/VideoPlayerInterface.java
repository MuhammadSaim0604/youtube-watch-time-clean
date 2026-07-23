package com.startapp.sdk.ads.video.player;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public interface VideoPlayerInterface {

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum VideoPlayerErrorType {
        UNKNOWN,
        SERVER_DIED,
        BUFFERING_TIMEOUT,
        PLAYER_CREATION
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface b {
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface c {
        void g(int i);
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface d {
        void U();
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface e {
        boolean b(g gVar);
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface f {
        void T();
    }

    void a();

    void a(int i);

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(String str);

    void a(boolean z);

    void b();

    void c();

    int d();

    int e();

    boolean f();

    void g();

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class g {
        private VideoPlayerErrorType a;
        private String b;
        private int c;

        public g(VideoPlayerErrorType videoPlayerErrorType, String str, int i) {
            this.a = videoPlayerErrorType;
            this.b = str;
            this.c = i;
        }

        public final VideoPlayerErrorType a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }
    }
}
