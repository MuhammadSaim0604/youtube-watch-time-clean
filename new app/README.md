# YouTube Watch Time and Views — clean Android copy

This is a standalone native Android project recreated from the imported app's
legitimate UI flow:

- purple splash screen with a three-second transition
- brown/pink home screen with the original URL input and controls
- YouTube URL validation
- one in-app WebView preview
- explicit `main.xml`, `home.xml`, `video_custom.xml`, and reusable `video_tile.xml` layouts
- a custom count field beside the YouTube URL field
- one active WebView plus inactive visual slots generated from the requested count
- no ads, ad SDKs, Firebase, or analytics dependencies

## Build with GitHub Actions

The repository workflow at `.github/workflows/android-apk.yml` builds the clean
project from `new app/` and uploads a downloadable debug APK named
`youtube-watch-time-clean-debug-apk`.

To use it:

1. Create a new GitHub repository. A private repository is fine.
2. Upload or push this project with the `.github/` directory included.
3. Open the repository's **Actions** tab.
4. Select **Build clean Android APK** and choose **Run workflow**, or push to
   the `main` branch.
5. Open the completed workflow run and download the APK from **Artifacts**.

The imported app's 5/10/15/20/25 controls opened multiple simultaneous
YouTube sessions to inflate views/watch time. That behavior is intentionally
not reproduced. The clean app replaces those fixed controls with a user-entered
layout count and one legitimate active preview player.

## Build

Open this folder in Android Studio or run:

```bash
./gradlew :app:assembleDebug
```

The project uses only the Android SDK and has no external runtime
dependencies.