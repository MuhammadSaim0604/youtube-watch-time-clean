package com.startapp.sdk.ads.video.player;

import com.startapp.sdk.ads.video.player.VideoPlayerInterface;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public abstract class a implements VideoPlayerInterface {
    protected String a;
    protected VideoPlayerInterface.f b;
    protected VideoPlayerInterface.e c;
    protected VideoPlayerInterface.d d;
    protected VideoPlayerInterface.c e;
    private VideoPlayerInterface.b f;
    private VideoPlayerInterface.a g;

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public void a(String str) {
        this.a = str;
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(VideoPlayerInterface.f fVar) {
        this.b = fVar;
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(VideoPlayerInterface.e eVar) {
        this.c = eVar;
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(VideoPlayerInterface.d dVar) {
        this.d = dVar;
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(VideoPlayerInterface.b bVar) {
        this.f = bVar;
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(VideoPlayerInterface.c cVar) {
        this.e = cVar;
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(VideoPlayerInterface.a aVar) {
        this.g = aVar;
    }
}
