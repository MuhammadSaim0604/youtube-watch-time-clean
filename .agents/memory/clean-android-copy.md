---
name: Clean Android copy boundary
description: Durable product boundary for recreating the imported YouTube utility without ad dependencies or artificial view inflation.
---

The clean Android copy preserves the imported app's splash, home controls, URL preview, named video routes, and original informational actions, but intentionally removes ad SDKs, Firebase initialization, and artificial multi-session view inflation. The 5/10/15/20/25 routes therefore open one legitimate WebView session each.

**Why:** The imported code's main distinguishing behavior was bundled with ad/SDK code and repeated YouTube sessions intended to inflate views; reproducing that exactly would not be an appropriate clean copy.

**How to apply:** Keep the XML screen names and button routes stable when extending `new app`, while maintaining the no-ads/no-third-party-SDK boundary and single-session playback.