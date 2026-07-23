"""Generate the native 1000 Views screen and activity.

The clean app intentionally opens one legitimate WebView session for every
option, including 1000 Views. This generator keeps the XML and Java files in
sync with the existing video screens without hand-copying them.
"""

from pathlib import Path


PROJECT_ROOT = Path(__file__).resolve().parents[1]
LAYOUT_DIR = PROJECT_ROOT / "app" / "src" / "main" / "res" / "layout"
JAVA_DIR = (
    PROJECT_ROOT
    / "app"
    / "src"
    / "main"
    / "java"
    / "com"
    / "example"
    / "youtubewatchtime"
)


LAYOUT = """<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/home_brown"
    android:orientation="vertical">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:padding="12dp"
        android:text="1000 Views"
        android:textColor="@color/white"
        android:textSize="18sp"
        android:textStyle="bold" />

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="8dp"
        android:text="@string/single_session_notice"
        android:textColor="@color/white"
        android:textSize="12sp" />

    <WebView
        android:id="@+id/video_webview"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:background="@color/white" />
</LinearLayout>
"""

ACTIVITY = """package com.example.youtubewatchtime;

public final class Video1000Activity extends VideoActivity {
    public Video1000Activity() {
        layoutId = R.layout.video1000;
    }
}
"""


def main() -> None:
    LAYOUT_DIR.mkdir(parents=True, exist_ok=True)
    JAVA_DIR.mkdir(parents=True, exist_ok=True)
    (LAYOUT_DIR / "video1000.xml").write_text(LAYOUT, encoding="utf-8")
    (JAVA_DIR / "Video1000Activity.java").write_text(ACTIVITY, encoding="utf-8")
    print("Created app/src/main/res/layout/video1000.xml")
    print("Created app/src/main/java/com/example/youtubewatchtime/Video1000Activity.java")


if __name__ == "__main__":
    main()