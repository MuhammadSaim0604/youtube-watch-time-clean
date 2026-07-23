package com.startapp.b.a.c;

import java.io.Serializable;
import java.io.Writer;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class f extends Writer implements Serializable {
    private final StringBuilder b;

    public f() {
        this.b = new StringBuilder();
    }

    public f(byte b) {
        this.b = new StringBuilder(4);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        this.b.append(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.b.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        this.b.append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.b.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.b.append(cArr, i, i2);
        }
    }

    public String toString() {
        return this.b.toString();
    }
}
