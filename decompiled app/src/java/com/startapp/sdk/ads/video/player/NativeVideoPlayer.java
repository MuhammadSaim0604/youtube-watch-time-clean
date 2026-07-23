package com.startapp.sdk.ads.video.player;

import android.media.MediaPlayer;
import android.widget.VideoView;
import com.startapp.sdk.ads.video.c;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class NativeVideoPlayer extends a implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    private MediaPlayer f;
    private VideoView g;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum MediaErrorType {
        MEDIA_ERROR_UNKNOWN,
        MEDIA_ERROR_SERVER_DIED;

        public static MediaErrorType a(int i) {
            return i == 100 ? MEDIA_ERROR_SERVER_DIED : MEDIA_ERROR_UNKNOWN;
        }
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum MediaErrorExtra {
        MEDIA_ERROR_IO,
        MEDIA_ERROR_MALFORMED,
        MEDIA_ERROR_UNSUPPORTED,
        MEDIA_ERROR_TIMED_OUT;

        public static MediaErrorExtra a(int i) {
            switch (i) {
                case -1010:
                    return MEDIA_ERROR_UNSUPPORTED;
                case -1007:
                    return MEDIA_ERROR_MALFORMED;
                case -1004:
                    return MEDIA_ERROR_IO;
                case -110:
                    return MEDIA_ERROR_TIMED_OUT;
                default:
                    return MEDIA_ERROR_IO;
            }
        }
    }

    public NativeVideoPlayer(VideoView videoView) {
        this.g = videoView;
        this.g.setOnPreparedListener(this);
        this.g.setOnCompletionListener(this);
        this.g.setOnErrorListener(this);
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a() {
        this.g.start();
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(int i) {
        new StringBuilder("seekTo(").append(i).append(")");
        this.g.seekTo(i);
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void b() {
        this.g.pause();
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void c() {
        this.g.stopPlayback();
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(boolean z) {
        new StringBuilder("setMute(").append(z).append(")");
        if (this.f != null) {
            if (z) {
                this.f.setVolume(0.0f, 0.0f);
            } else {
                this.f.setVolume(1.0f, 1.0f);
            }
        }
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final int d() {
        return this.g.getCurrentPosition();
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final int e() {
        return this.g.getDuration();
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final boolean f() {
        return this.f != null;
    }

    @Override // com.startapp.sdk.ads.video.player.a, com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void a(String str) {
        new StringBuilder("setVideoLocation(").append(str).append(")");
        super.a(str);
        this.g.setVideoPath(this.a);
    }

    @Override // com.startapp.sdk.ads.video.player.VideoPlayerInterface
    public final void g() {
        if (this.f != null) {
            this.f = null;
        }
        c.a().a((VideoPlayerInterface.c) null);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.f = mediaPlayer;
        if (this.b != null) {
            this.b.T();
        }
        if (com.startapp.sdk.adsbase.a.c(this.a) && this.f != null) {
            this.f.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.startapp.sdk.ads.video.player.NativeVideoPlayer.1
                @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                public final void onBufferingUpdate(MediaPlayer mediaPlayer2, int i) {
                    if (NativeVideoPlayer.this.e != null) {
                        NativeVideoPlayer.this.e.g(i);
                    }
                }
            });
        } else if (!com.startapp.sdk.adsbase.a.c(this.a)) {
            c.a().a(this.e);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (this.d != null) {
            this.d.U();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        new StringBuilder("onError(").append(i).append(", ").append(i2).append(")");
        if (this.c != null) {
            return this.c.b(new VideoPlayerInterface.g(MediaErrorType.a(i) == MediaErrorType.MEDIA_ERROR_SERVER_DIED ? VideoPlayerInterface.VideoPlayerErrorType.SERVER_DIED : VideoPlayerInterface.VideoPlayerErrorType.UNKNOWN, MediaErrorExtra.a(i2).toString(), mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1));
        }
        return false;
    }
}
