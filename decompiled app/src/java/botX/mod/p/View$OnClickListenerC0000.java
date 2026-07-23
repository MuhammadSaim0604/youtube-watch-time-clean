package botX.mod.p;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* renamed from: botX.mod.p.ۦۖۤ  reason: contains not printable characters */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
class View$OnClickListenerC0000 implements View.OnClickListener {

    /* renamed from: ۢۘۤۗ  reason: not valid java name and contains not printable characters */
    private final /* synthetic */ Context f0;

    /* renamed from: ۨۚۖۗ  reason: not valid java name and contains not printable characters */
    private final /* synthetic */ AlertDialog f1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC0000(AlertDialog alertDialog, Context context) {
        this.f1 = alertDialog;
        this.f0 = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1.dismiss();
        this.f0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://chat.whatsapp.com/KjXtKzDGSph2o0VVrNQXQk")));
    }
}
