# Android App - Setup & Run Instructions

## Prerequisites
- Android Studio installed
- Java JDK 17 or higher
- Android SDK set up
- USB debugging enabled (for running on a physical device)
- CoinAPI API key

## Running the App

### 1. Clone the Repository
```sh
git clone https://github.com/leomarques/querosermb-leom.git
```

### 2. Configure API Key
Create or edit the `local.properties` file in the project's root directory and add:
```properties
API_KEY=your_coinapi_key_here
```

### 3. Build and Run the App
#### From Android Studio:
1. Open the project in Android Studio.
2. Sync Gradle files (`File > Sync Project with Gradle Files`).
3. Select a device/emulator and click **Run**.

#### From Command Line:
```sh
./gradlew installDebug
adb shell am start -n com.querosermb.leom/.misc.MainActivity
```

## Running Tests

### Unit Tests
To run unit tests, execute:
```sh
./gradlew testDebugUnitTest
```

### UI Tests (Instrumented Tests)
To run UI tests on an emulator or device:
```sh
./gradlew connectedDebugAndroidTest
```
Ensure an emulator or physical device is connected before running UI tests.

## Additional Notes
- Ensure the API key is valid; otherwise, network requests to CoinAPI will fail.
- Do not commit `local.properties` to version control to keep credentials safe.

