package com.example.youtubewatchtime;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class VideoCustomActivity extends Activity {
    public static final String EXTRA_URL = "custom_video_url";
    public static final String EXTRA_COUNT = "custom_tile_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_custom);

        String url = getIntent().getStringExtra(EXTRA_URL);
        int requestedCount = getIntent().getIntExtra(EXTRA_COUNT, 1);
        TextView title = findViewById(R.id.custom_title);
        title.setText("Custom layout: " + requestedCount + " slots");

        LinearLayout container = findViewById(R.id.video_tile_container);
        LayoutInflater inflater = LayoutInflater.from(this);
        WebView activePlayer = null;

        for (int index = 0; index < requestedCount; index++) {
            if (index % 3 == 0) {
                LinearLayout row = new LinearLayout(this);
                row.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                row.setGravity(android.view.Gravity.CENTER);
                row.setOrientation(LinearLayout.HORIZONTAL);
                container.addView(row);
            }

            LinearLayout row = (LinearLayout) container.getChildAt(container.getChildCount() - 1);
            View tile = inflater.inflate(R.layout.video_tile, row, false);
            TextView label = tile.findViewById(R.id.tile_label);
            WebView webView = tile.findViewById(R.id.tile_webview);
            if (activePlayer == null) {
                activePlayer = webView;
                label.setText("Active player");
                activePlayer.setWebViewClient(new WebViewClient());
                activePlayer.getSettings().setJavaScriptEnabled(true);
                activePlayer.getSettings().setSupportZoom(true);
                if (url != null && !url.trim().isEmpty()) {
                    activePlayer.loadUrl(url);
                }
            } else {
                label.setText("Inactive slot " + (index + 1));
                webView.setVisibility(View.GONE);
            }
            row.addView(tile);
        }
    }
}