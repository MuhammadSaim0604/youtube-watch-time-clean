---
name: Clean Android copy boundary
description: Durable product boundary for recreating the imported YouTube utility without ad dependencies or artificial view inflation.
---

The current clean Android project uses the manually restored `com.my.youtubewatchtime.view.sa` package and preserves the splash, home styling, URL preview, fixed video grid screens, and informational action. Its advertising and Firebase integrations are removed.

**Why:** The imported code's main distinguishing behavior was bundled with ad/SDK code and repeated YouTube sessions intended to inflate views; reproducing that exactly would not be an appropriate clean copy.

**How to apply:** Keep the Android module configuration and source package aligned, and maintain the no-ads/no-Firebase/no-analytics boundary when extending the screens.