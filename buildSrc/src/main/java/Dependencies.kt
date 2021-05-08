object Versions {

    const val versionMajor = 1
    const val versionMinor = 0
    const val versionPatch = 0
    const val devCode = 1
    const val stageCode = 1
    const val betaCode = 1
    const val playStoreCode = 2

    const val gradleVersion = "4.2.0"
    const val kotlinVersion = "1.4.32"
    const val coroutine = "1.4.1"
    const val min = 23
    const val compile = 30

    const val jetpack = "1.1.0"
    const val constraintLayout = "2.0.0-beta4"
    const val ktx = "1.3.2"
    const val junit4 = "4.12"
    const val testRunner = "1.1.0-alpha4"
    const val espresso = "3.1.0-alpha4"
    const val mockito = "3.1.0"

    const val playLocation = "17.0.0"
    const val retrofit = "2.9.0"
    const val lifecycle = "2.2.0"
    const val rxKotlinVersion = "2.4.0"
    const val rxAndroidVersion = "2.1.1"
    const val gsonVersion = "2.8.6"
    const val firebaseAnalytics = "17.4.1"
    const val firebaseCrashlytics = "17.0.1"
    const val firebaseMessaging = "20.1.7"
    const val koinVersion = "2.0.1"
    const val googleMaterial = "1.3.0"
    const val okLoggingInterceptor = "4.3.1"
    const val timber = "4.7.1"

    const val glide = "4.11.0"
    const val camerax_version = "1.0.0-alpha06"
    const val splitties = "3.0.0-alpha06"
    const val multidex = "1.0.3"
    const val biometric = "1.0.1"
    const val security = "1.0.0-rc02"
    const val nav_version = "2.3.0"
    const val roomVersion = "2.2.6"
}

object Libraries {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"

    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"


    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"

    const val playLocationService =
        "com.google.android.gms:play-services-location:${Versions.playLocation}"
    const val playServiceMaps = "com.google.android.gms:play-services-maps:${Versions.playLocation}"

    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val okLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okLoggingInterceptor}"

    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val koin = "org.koin:koin-android:${Versions.koinVersion}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koinVersion}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koinVersion}"

    const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val multidex = "com.android.support:multidex:${Versions.multidex}"

    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseAnalytics}"
    const val firebaseCrashlytics =
        "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlytics}"
    const val firebaseMessaging =
        "com.google.firebase:firebase-messaging:${Versions.firebaseMessaging}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"


    const val hilt = "com.google.dagger:hilt-android:2.28.1-alpha"
    const val hiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
    const val hiltCompilerAndroid = "com.google.dagger:hilt-android-compiler:2.28.1-alpha"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"

    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomRxi = "androidx.room:room-rxjava2:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

}

object TestLibraries {
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockitoCore="org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoInline="org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKotlin="com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
    const val roomTesting = "androidx.room:room-testing:${Versions.roomVersion}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
    const val okHttp = "com.squareup.okhttp3:mockwebserver:4.4.0"
    const val core = "androidx.arch.core:core-testing:2.1.0"
    const val kotlinTest = "io.kotlintest:kotlintest-runner-junit5:3.3.2"
}

object Dependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
    const val googleServicePlugin = "com.google.gms:google-services:4.3.5"
    const val crashyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:2.5.0"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kapt = "kotlin-kapt"
    const val parcelize = "kotlin-parcelize"
    const val google = "com.google.gms:google-services:4.3.5"
    const val crashlytics = "com.google.firebase.crashlytics"
    const val hilt = "dagger.hilt.android.plugin"
}

object AndroidSdk {
    const val minSDK = Versions.min
    const val compileSDK = Versions.compile
    const val targetSDK = compileSDK
}
