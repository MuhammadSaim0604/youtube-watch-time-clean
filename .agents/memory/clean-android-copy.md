---
name: Clean Android copy boundary
description: Durable product boundary for recreating the imported YouTube utility without ad dependencies or artificial view inflation.
---

The current clean Android project uses the manually restored `com.my.youtubewatchtime.view.sa` package and preserves the splash, home styling, URL preview, fixed video grid screens, and informational action. Its advertising and Firebase integrations are removed.

**Why:** The imported code's main distinguishing behavior was bundled with ad/SDK code and repeated YouTube sessions intended to inflate views; reproducing that exactly would not be an appropriate clean copy.

**How to apply:** Keep the Android module configuration and source package aligned, and maintain the no-ads/no-Firebase/no-analytics boundary when extending the screens.

The app must use uniquely named application themes that inherit from AppCompat; never define a local style with a library name such as `Theme.AppCompat.*`, because it can shadow the dependency theme and crash `AppCompatActivity` at `setContentView`.

**Why:** The restored project previously declared a local `Theme.AppCompat.Light.DarkActionBar` style with the same name as its parent, causing the installed APK to fail when launching `HomeActivity`.

**How to apply:** Keep `Theme.YoutubeWatchTime*`-style names in app resources and reference those names from the manifest.