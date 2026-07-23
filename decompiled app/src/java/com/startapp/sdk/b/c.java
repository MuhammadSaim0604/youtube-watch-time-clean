package com.startapp.sdk.b;

import android.content.Context;
import com.startapp.common.ThreadManager;
import com.startapp.common.a.d;
import com.startapp.sdk.adsbase.infoevents.b;
import com.startapp.sdk.adsbase.j.g;
import com.startapp.sdk.adsbase.j.r;
import com.startapp.sdk.adsbase.remoteconfig.LocationConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig;
import com.startapp.sdk.adsbase.remoteconfig.RscMetadata;
import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;
import java.util.concurrent.Executors;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public final class c {
    private static final b<c, Context> a;
    private final a<com.startapp.sdk.c.b.b> b;
    private final a<com.startapp.sdk.c.a.b> c;
    private final a<com.startapp.sdk.c.d.c> d;
    private final a<d> e;
    private final a<com.startapp.sdk.f.a> f;
    private final a<com.startapp.sdk.adsbase.consent.a> g;
    private final a<com.startapp.sdk.e.a> h;
    private final a<com.startapp.sdk.adsbase.i.a> i = new a<com.startapp.sdk.adsbase.i.a>() { // from class: com.startapp.sdk.b.c.14
        @Override // com.startapp.sdk.b.a
        protected final /* synthetic */ com.startapp.sdk.adsbase.i.a a() {
            return new com.startapp.sdk.adsbase.i.a();
        }
    };
    private final a<com.startapp.sdk.c.c.a> j;
    private final a<com.startapp.sdk.triggeredlinks.c> k;
    private final a<com.startapp.sdk.adsbase.b> l;
    private final a<com.startapp.sdk.adsbase.f.d> m;
    private final a<com.startapp.sdk.adsbase.d.b> n;

    static {
        c.class.getSimpleName();
        a = new b<c, Context>() { // from class: com.startapp.sdk.b.c.1
            @Override // com.startapp.sdk.b.b
            protected final /* synthetic */ c a(Context context) {
                return new c(context);
            }
        };
    }

    public static c a(Context context) {
        return a.b(context.getApplicationContext());
    }

    public final com.startapp.sdk.c.b.b a() {
        return this.b.b();
    }

    public final com.startapp.sdk.c.a.b b() {
        return this.c.b();
    }

    public final com.startapp.sdk.c.d.c c() {
        return this.d.b();
    }

    public final d d() {
        return this.e.b();
    }

    public final com.startapp.sdk.f.a e() {
        return this.f.b();
    }

    public final com.startapp.sdk.adsbase.consent.a f() {
        return this.g.b();
    }

    public final com.startapp.sdk.e.a g() {
        return this.h.b();
    }

    public final com.startapp.sdk.adsbase.i.a h() {
        return this.i.b();
    }

    public final com.startapp.sdk.c.c.a i() {
        return this.j.b();
    }

    public final com.startapp.sdk.triggeredlinks.c j() {
        return this.k.b();
    }

    public final com.startapp.sdk.adsbase.b k() {
        return this.l.b();
    }

    public final com.startapp.sdk.adsbase.f.d l() {
        return this.m.b();
    }

    public final com.startapp.sdk.adsbase.d.b m() {
        return this.n.b();
    }

    protected c(final Context context) {
        this.b = new a<com.startapp.sdk.c.b.b>() { // from class: com.startapp.sdk.b.c.7
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.c.b.b a() {
                return new com.startapp.sdk.c.b.b(context);
            }
        };
        this.c = new a<com.startapp.sdk.c.a.b>() { // from class: com.startapp.sdk.b.c.8
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.c.a.b a() {
                return new com.startapp.sdk.c.a.b(context);
            }
        };
        this.d = new a<com.startapp.sdk.c.d.c>() { // from class: com.startapp.sdk.b.c.9
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.c.d.c a() {
                return new com.startapp.sdk.c.d.c(context);
            }
        };
        this.e = new a<d>() { // from class: com.startapp.sdk.b.c.10
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ d a() {
                return new d(context);
            }
        };
        this.f = new a<com.startapp.sdk.f.a>() { // from class: com.startapp.sdk.b.c.11
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.f.a a() {
                return new com.startapp.sdk.f.a(context, new g<RscMetadata>() { // from class: com.startapp.sdk.b.c.11.1
                    @Override // com.startapp.sdk.adsbase.j.g
                    public final /* synthetic */ RscMetadata a() {
                        return MetaData.E().b();
                    }
                });
            }
        };
        this.g = new a<com.startapp.sdk.adsbase.consent.a>() { // from class: com.startapp.sdk.b.c.12
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.adsbase.consent.a a() {
                return new com.startapp.sdk.adsbase.consent.a(context);
            }
        };
        this.h = new a<com.startapp.sdk.e.a>() { // from class: com.startapp.sdk.b.c.13
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.e.a a() {
                return new com.startapp.sdk.e.a(context.getSharedPreferences("StartApp-54ff24db2aee60b9", 0));
            }
        };
        this.j = new a<com.startapp.sdk.c.c.a>() { // from class: com.startapp.sdk.b.c.2
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.c.c.a a() {
                return new com.startapp.sdk.c.c.a(context, new g<LocationConfig>() { // from class: com.startapp.sdk.b.c.2.1
                    @Override // com.startapp.sdk.adsbase.j.g
                    public final /* synthetic */ LocationConfig a() {
                        return MetaData.E().C();
                    }
                });
            }
        };
        this.k = new a<com.startapp.sdk.triggeredlinks.c>() { // from class: com.startapp.sdk.b.c.3
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.triggeredlinks.c a() {
                return new com.startapp.sdk.triggeredlinks.c(context, context.getSharedPreferences("StartApp-fba1a5307d96ef31", 0), new r(ThreadManager.Priority.DEFAULT), c.a(context).d(), new g<TriggeredLinksMetadata>() { // from class: com.startapp.sdk.b.c.3.1
                    @Override // com.startapp.sdk.adsbase.j.g
                    public final /* synthetic */ TriggeredLinksMetadata a() {
                        return MetaData.E().d();
                    }
                });
            }
        };
        this.l = new a<com.startapp.sdk.adsbase.b>() { // from class: com.startapp.sdk.b.c.4
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.adsbase.b a() {
                return new com.startapp.sdk.adsbase.b(context.getSharedPreferences("StartApp-790ba54ab8e69f2f", 0));
            }
        };
        this.m = new a<com.startapp.sdk.adsbase.f.d>() { // from class: com.startapp.sdk.b.c.5
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.adsbase.f.d a() {
                return new com.startapp.sdk.adsbase.f.d(context, context.getSharedPreferences("StartApp-3286f6eaf694fa40", 0), new g<com.startapp.sdk.adsbase.remoteconfig.c>() { // from class: com.startapp.sdk.b.c.5.1
                    @Override // com.startapp.sdk.adsbase.j.g
                    public final /* synthetic */ com.startapp.sdk.adsbase.remoteconfig.c a() {
                        return new com.startapp.sdk.adsbase.remoteconfig.c(MetaData.E().o());
                    }
                }, new b.a());
            }
        };
        this.n = new a<com.startapp.sdk.adsbase.d.b>() { // from class: com.startapp.sdk.b.c.6
            @Override // com.startapp.sdk.b.a
            protected final /* synthetic */ com.startapp.sdk.adsbase.d.b a() {
                return new com.startapp.sdk.adsbase.d.b(context, c.this.d(), c.this.a(), new com.startapp.sdk.adsbase.e.a(context, context.getSharedPreferences("StartApp-770c613f81fb5b52", 0), new com.startapp.sdk.adsbase.e.b(context, "StartApp-ac51a09f00e0f80c"), Executors.newSingleThreadExecutor(), new g<NetworkDiagnosticConfig>() { // from class: com.startapp.sdk.b.c.6.1
                    @Override // com.startapp.sdk.adsbase.j.g
                    public final /* synthetic */ NetworkDiagnosticConfig a() {
                        return MetaData.E().a();
                    }
                }), new g<com.startapp.sdk.adsbase.d.c>() { // from class: com.startapp.sdk.b.c.6.2
                    @Override // com.startapp.sdk.adsbase.j.g
                    public final /* synthetic */ com.startapp.sdk.adsbase.d.c a() {
                        MetaData E = MetaData.E();
                        return new com.startapp.sdk.adsbase.d.c(E.x(), E.P(), E.p());
                    }
                });
            }
        };
    }
}
