---
name: Clean Android copy boundary
description: Durable product boundary for recreating the imported YouTube utility without ad dependencies or artificial view inflation.
---

The clean Android copy preserves the imported app's splash, home styling, URL preview, and informational action, but replaces the fixed 5/10/15/20/25/1000 controls with a user-entered layout count. The custom screen uses reusable tile XML, one legitimate active WebView, and inactive visual slots for the requested count.

**Why:** The imported code's main distinguishing behavior was bundled with ad/SDK code and repeated YouTube sessions intended to inflate views; reproducing that exactly would not be an appropriate clean copy.

**How to apply:** Extend the reusable custom tile flow rather than restoring fixed session buttons or loading the same YouTube URL into multiple WebViews. Maintain the no-ads/no-third-party-SDK boundary and single-session playback.