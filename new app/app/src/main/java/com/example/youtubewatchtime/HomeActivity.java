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
    private EditText countInput;
    private WebView preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        urlInput = findViewById(R.id.edittext2);
        countInput = findViewById(R.id.preview_count);
        preview = findViewById(R.id.webview1);
        urlInput.setTextColor(Color.WHITE);
        urlInput.setHintTextColor(Color.WHITE);
        urlInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_URI);
        preview.getSettings().setJavaScriptEnabled(true);
        preview.getSettings().setSupportZoom(true);
        preview.setWebViewClient(new android.webkit.WebViewClient());
        findViewById(R.id.imageview1).setOnClickListener(v -> loadPreview());
        findViewById(R.id.open_custom_player).setOnClickListener(v -> openCustomPlayer());
        findViewById(R.id.how_it_works_button).setOnClickListener(v -> openHowItWorksLink());
    }

    private void loadPreview() {
        String url = urlInput.getText().toString().trim();
        if (!isHttpUrl(url)) {
            Toast.makeText(this, getString(R.string.invalid_url), Toast.LENGTH_SHORT).show();
            return;
        }
        preview.loadUrl(url);
    }

    private void openCustomPlayer() {
        String url = urlInput.getText().toString().trim();
        if (!isHttpUrl(url)) {
            Toast.makeText(this, getString(R.string.invalid_url), Toast.LENGTH_SHORT).show();
            return;
        }
        int count;
        try {
            count = Integer.parseInt(countInput.getText().toString().trim());
        } catch (NumberFormatException exception) {
            count = 0;
        }
        if (count < 1 || count > 50) {
            Toast.makeText(this, getString(R.string.count_required), Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(new Intent(this, VideoCustomActivity.class)
                .putExtra(VideoCustomActivity.EXTRA_URL, url)
                .putExtra(VideoCustomActivity.EXTRA_COUNT, count));
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