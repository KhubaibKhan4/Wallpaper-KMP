# Wallpaper-CMP

Wallpaper CMP is developed using Kotlin Multiplatform and Compose Multiplatform. It supports Android, iOS, Web & Desktop Applications.

## Screenshot
### Android + iOS Screenshots
<div style="display:flex; justify-content:space-between">
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/1.png" width="260px" style="border: 1px solid #ccc; padding: 5px;"/>
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/2.png" width="260px" style="border: 1px solid #ccc; padding: 5px;"/>
</div>
<div style="display:flex; justify-content:space-between">
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/11.png" width="260px" style="border: 1px solid #ccc; padding: 5px;"/>
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/22.png" width="260px" style="border: 1px solid #ccc; padding: 5px;"/>
</div>

### Web Screenshots
<div style="display:flex; justify-content:space-between">
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/3.png" style="border: 1px solid #ccc; padding: 5px;"/>
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/4.png" style="border: 1px solid #ccc; padding: 5px;"/>
</div>
<div style="display:flex; justify-content:space-between">
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/33.png" style="border: 1px solid #ccc; padding: 5px;"/>
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/44.png" style="border: 1px solid #ccc; padding: 5px;"/>
</div>

### Desktop Screenshots
<div style="display:flex; justify-content:space-between">
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/5.png" style="border: 1px solid #ccc; padding: 5px;"/>
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/6.png" style="border: 1px solid #ccc; padding: 5px;"/>
</div>
<div style="display:flex; justify-content:space-between">
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/55.png" style="border: 1px solid #ccc; padding: 5px;"/>
    <img src="https://github.com/KhubaibKhan4/Wallpaper-KMP/blob/master/screenshots/66.png" style="border: 1px solid #ccc; padding: 5px;"/>
</div>

## Technology Used
- **Voygar**: Navigation Library for seamless navigation between screens.
- **Ktor Client**: HTTP Client for making network requests over the internet.
- **ComposeLoader**: Utility for displaying images in the Kotlin Multiplatform project.
- **Napier**: Logger Library for efficient logging.
- **FeatherIcon**: Icon Library providing a wide range of icons.
- **Serialization**: Serialization library for converting Kotlin objects to and from JSON.
- **ViewModel**: KMP View Model Library for managing UI-related data.

## Before running!
- Check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
- Install JDK 17 on your machine
- Add `local.properties` file to the project root and set a path to Android SDK there

### Android
To run the application on android device/emulator:  
- Open project in Android Studio and run imported android run configuration
- To build the application bundle:
    - Run `./gradlew :composeApp:assembleDebug`
    - Find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`

### Desktop
Run the desktop application: `./gradlew :composeApp:run`

### iOS
To run the application on iPhone device/simulator:
- Open `iosApp/iosApp.xcproject` in Xcode and run standard configuration
- Or use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio

### Browser
Run the browser application: `./gradlew :composeApp:jsBrowserDevelopmentRun`

## Support Us
If you find Wallpaper CMP helpful, consider supporting us by:
- Giving us a star on [GitHub](https://github.com/KhubaibKhan4/Wallpaper-KMP)
- Contributing to the project
- Providing feedback and suggestions for improvement

## Contributors
- [Muhammad Khubaib Imtiaz](https://github.com/KhubaibKhan4)

