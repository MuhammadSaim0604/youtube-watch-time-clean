package com.startapp.networkTest.e;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private long a;

    static {
        a.class.getSimpleName();
    }

    public final boolean a(String str) {
        DatagramSocket datagramSocket = null;
        try {
            try {
                DatagramSocket datagramSocket2 = new DatagramSocket();
                datagramSocket = datagramSocket2;
                datagramSocket2.setSoTimeout(10000);
                byte[] bArr = new byte[48];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, InetAddress.getByName(str), 123);
                bArr[0] = 27;
                a(bArr);
                datagramSocket.send(datagramPacket);
                datagramSocket.receive(new DatagramPacket(bArr, 48));
                datagramSocket.close();
                this.a = ((a(bArr, 32) - 2208988800L) * 1000) + ((a(bArr, 36) * 1000) / 4294967296L);
                datagramSocket.close();
                return true;
            } catch (Exception e) {
                new StringBuilder("request time failed: ").append(e);
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            throw th;
        }
    }

    public final long a() {
        return this.a;
    }

    private static long a(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        return (((b & 128) == 128 ? (b & Byte.MAX_VALUE) + 128 : b) << 24) + (((b2 & 128) == 128 ? (b2 & Byte.MAX_VALUE) + 128 : b2) << 16) + (((b3 & 128) == 128 ? (b3 & Byte.MAX_VALUE) + 128 : b3) << 8) + ((b4 & 128) == 128 ? (b4 & Byte.MAX_VALUE) + 128 : b4);
    }

    private static void a(byte[] bArr) {
        for (int i = 40; i < 48; i++) {
            bArr[i] = 0;
        }
    }
}
