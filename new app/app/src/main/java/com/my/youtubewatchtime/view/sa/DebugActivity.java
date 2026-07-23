package com.my.youtubewatchtime.view.sa;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

public class DebugActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String error = getIntent().getStringExtra("error");
        String displayMessage = error != null ? error : "An unknown error occurred";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("An error occurred")
               .setMessage(displayMessage)
               .setPositiveButton("End Application", (dialog, which) -> finish())
               .create()
               .show();
    }
}