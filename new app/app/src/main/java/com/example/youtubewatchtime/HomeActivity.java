package com.example.youtubewatchtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public final class HomeActivity extends Activity {
    private EditText urlInput;
    private WebView preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        urlInput = findViewById(R.id.edittext2);
        preview = findViewById(R.id.webview1);
        urlInput.setTextColor(Color.WHITE);
        urlInput.setHintTextColor(Color.WHITE);
        urlInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_URI);
        preview.getSettings().setJavaScriptEnabled(true);
        preview.getSettings().setSupportZoom(true);
        preview.setWebViewClient(new android.webkit.WebViewClient());
        findViewById(R.id.imageview1).setOnClickListener(v -> loadPreview());
        findViewById(R.id.button1).setOnClickListener(v -> openVideo(Video5Activity.class));
        findViewById(R.id.button2).setOnClickListener(v -> openVideo(Video10Activity.class));
        findViewById(R.id.button3).setOnClickListener(v -> openVideo(Video15Activity.class));
        findViewById(R.id.button4).setOnClickListener(v -> openVideo(Video20Activity.class));
        findViewById(R.id.button5).setOnClickListener(v -> openVideo(Video25Activity.class));
        findViewById(R.id.button7).setOnClickListener(v -> openVideo(Video1000Activity.class));
        findViewById(R.id.button8).setOnClickListener(v -> openHowItWorksLink());
    }

    private void loadPreview() {
        String url = urlInput.getText().toString().trim();
        if (!isHttpUrl(url)) {
            Toast.makeText(this, getString(R.string.invalid_url), Toast.LENGTH_SHORT).show();
            return;
        }
        preview.loadUrl(url);
    }

    private void openVideo(Class<? extends Activity> activityClass) {
        String url = urlInput.getText().toString().trim();
        if (!isHttpUrl(url)) {
            Toast.makeText(this, getString(R.string.invalid_url), Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(new Intent(this, activityClass).putExtra(VideoActivity.EXTRA_URL, url));
    }

    private boolean isHttpUrl(String url) {
        Uri parsed = Uri.parse(url);
        return ("http".equalsIgnoreCase(parsed.getScheme())
                || "https".equalsIgnoreCase(parsed.getScheme()))
                && parsed.getHost() != null
                && (parsed.getHost().contains("youtube.com")
                || parsed.getHost().contains("youtu.be"));
    }

    private void showHowItWorks() {
        new AlertDialog.Builder(this)
                .setTitle("How it works")
                .setMessage("Paste a YouTube URL and open one preview player. "
                        + "The no-ads version intentionally avoids artificial multi-session "
                        + "view inflation and does not contact third-party ad or analytics SDKs.")
                .setPositiveButton("OK", null)
                .show();
    }

    private void openHowItWorksLink() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://whatsapp.com/channel/0029VavHzv259PwTIz1XxJ09")));
        } catch (android.content.ActivityNotFoundException ignored) {
            showHowItWorks();
        }
    }
}