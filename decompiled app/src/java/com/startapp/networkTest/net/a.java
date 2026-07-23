package com.startapp.networkTest.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private static final String a = a.class.getSimpleName();
    private Object b;
    private InetAddress c;

    public final String a(final String str) throws UnknownHostException {
        String hostAddress;
        this.b = new Object();
        Thread thread = new Thread(new Runnable() { // from class: com.startapp.networkTest.net.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    InetAddress byName = InetAddress.getByName(str);
                    synchronized (a.this.b) {
                        a.this.c = byName;
                    }
                } catch (Exception e) {
                    String unused = a.a;
                    new StringBuilder("resolveHostname: ").append(e.toString());
                }
            }
        });
        thread.start();
        try {
            thread.join(30000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this.b) {
            if (this.c == null) {
                throw new UnknownHostException();
            }
            hostAddress = this.c.getHostAddress();
        }
        return hostAddress;
    }
}
