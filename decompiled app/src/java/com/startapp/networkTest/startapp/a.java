package com.startapp.networkTest.startapp;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private static InterfaceC0026a a;

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.networkTest.startapp.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public interface InterfaceC0026a {
        void a(Throwable th);
    }

    static {
        a.class.getSimpleName();
        a = new InterfaceC0026a() { // from class: com.startapp.networkTest.startapp.a.1
            @Override // com.startapp.networkTest.startapp.a.InterfaceC0026a
            public final void a(Throwable th) {
            }
        };
    }

    public static void a(InterfaceC0026a interfaceC0026a) {
        a = interfaceC0026a;
    }

    public static void a(Throwable th) {
        InterfaceC0026a interfaceC0026a = a;
        if (interfaceC0026a != null) {
            try {
                interfaceC0026a.a(th);
            } catch (Throwable th2) {
            }
        }
    }
}
