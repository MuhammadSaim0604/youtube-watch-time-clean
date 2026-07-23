package com.my.youtubewatchtime.view.sa;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex
 */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/2.dex */
public class MainActivity extends AppCompatActivity {
    private CircleImageView circleimageview1;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private ProgressBar progressbar1;
    private TimerTask t;
    private TextView textview1;
    private TextView textview2;
    private Timer _timer = new Timer();
    private HashMap<String, Object> map = new HashMap<>();
    private HashMap<String, Object> m = new HashMap<>();
    private Intent i = new Intent();

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427378);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(2131230975);
        this.linear2 = (LinearLayout) findViewById(2131230976);
        this.circleimageview1 = (CircleImageView) findViewById(2131230846);
        this.textview1 = (TextView) findViewById(2131231207);
        this.progressbar1 = (ProgressBar) findViewById(2131231101);
        this.linear3 = (LinearLayout) findViewById(2131230977);
        this.textview2 = (TextView) findViewById(2131231208);
    }

    private void initializeLogic() {
        this.t = new TimerTask() { // from class: com.my.youtubewatchtime.view.sa.MainActivity.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.my.youtubewatchtime.view.sa.MainActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), HomeActivity.class);
                        MainActivity.this.startActivity(MainActivity.this.i);
                        MainActivity.this.finish();
                    }
                });
            }
        };
        this._timer.schedule(this.t, 3000L);
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf(checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
