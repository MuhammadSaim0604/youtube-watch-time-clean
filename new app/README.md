# YouTube Watch Time and Views — clean Android copy

This is a standalone native Android project recreated from the imported app's
UI flow:

- purple splash screen with a three-second transition
- brown/pink home screen with the original URL input and controls
- YouTube URL validation
- one in-app WebView preview
- original 5/10/15/20/25 WebView grid layouts
- no advertising SDKs, Firebase, or analytics dependencies

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

The original fixed video layouts are retained in this manually restored copy.
Advertising and Firebase integrations have been removed.

## Build

Open this folder in Android Studio or run:

```bash
./gradlew :app:assembleDebug
```

The project uses only the Android SDK and has no external runtime
dependencies.