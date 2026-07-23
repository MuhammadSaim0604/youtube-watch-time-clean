package com.startapp.sdk.adsbase.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class b extends SQLiteOpenHelper {
    private static final String[] a = {"id"};
    private volatile SQLiteDatabase b;
    private final Object c;

    public b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.c = new Object();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS requests (id INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,value TEXT NOT NULL UNIQUE,CHECK (value = TRIM(value) AND LENGTH(value) > 0));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS statuses (id INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,value TEXT NOT NULL UNIQUE,CHECK (value = TRIM(value) AND LENGTH(value) > 0));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traces (requestId INTEGER NOT NULL,statusId INTEGER NOT NULL,timeMillis INTEGER NOT NULL,durationNanos INTEGER NOT NULL,FOREIGN KEY (requestId)REFERENCES requests (requestId)ON UPDATE CASCADE ON DELETE CASCADE,FOREIGN KEY (statusId)REFERENCES statuses (statusId)ON UPDATE CASCADE ON DELETE CASCADE,CHECK (timeMillis > 0),CHECK (durationNanos > 0));");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = this.b;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        if (sQLiteDatabase == null) {
            synchronized (this.c) {
                SQLiteDatabase sQLiteDatabase3 = this.b;
                sQLiteDatabase2 = sQLiteDatabase3;
                if (sQLiteDatabase3 == null) {
                    sQLiteDatabase2 = getWritableDatabase();
                    this.b = sQLiteDatabase2;
                }
            }
        }
        return sQLiteDatabase2;
    }

    public final void a(String str, String str2, long j, long j2) {
        SQLiteDatabase a2 = a();
        a2.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            long a3 = a(a2, "requests", str);
            long j3 = a3;
            if (a3 < 0) {
                contentValues.clear();
                contentValues.put("value", str);
                j3 = a2.insert("requests", null, contentValues);
            }
            long a4 = a(a2, "statuses", str2);
            long j4 = a4;
            if (a4 < 0) {
                contentValues.clear();
                contentValues.put("value", str2);
                j4 = a2.insert("statuses", null, contentValues);
            }
            contentValues.clear();
            contentValues.put("requestId", Long.valueOf(j3));
            contentValues.put("statusId", Long.valueOf(j4));
            contentValues.put("timeMillis", Long.valueOf(j));
            contentValues.put("durationNanos", Long.valueOf(j2));
            a2.insert("traces", null, contentValues);
            a2.setTransactionSuccessful();
        } finally {
            a2.endTransaction();
        }
    }

    public final Cursor a(long j) {
        return a().rawQuery("SELECT requestId, statusId, requests.value AS request, statuses.value AS status, COUNT(*), MIN(durationNanos), MAX(durationNanos), AVG(durationNanos), MIN(timeMillis) FROM traces JOIN requests ON requests.id = traces.requestId JOIN statuses ON statuses.id = traces.statusId WHERE timeMillis < ? GROUP BY requestId, statusId", new String[]{String.valueOf(j)});
    }

    public final void a(long j, long j2, long j3) {
        a().delete("traces", "requestId = ? AND statusId = ? AND timeMillis < ?", new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(j3)});
    }

    private static long a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor query = sQLiteDatabase.query(str, a, "value=?", new String[]{str2}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return query.getLong(0);
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return -1L;
    }
}
