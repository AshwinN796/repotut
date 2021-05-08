plugins {
    id(Plugins.androidApplication)
//    id(Plugins.google)
    id(Plugins.kotlinAndroid)
//    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kapt)
    id(Plugins.parcelize)
//    id(Plugins.crashlytics)
    id(Plugins.hilt)
}
android {

    compileSdkVersion(AndroidSdk.compileSDK)

    defaultConfig {
        applicationId = "com.repoenerytut.repotut"
        minSdkVersion(AndroidSdk.minSDK)
        targetSdkVersion(AndroidSdk.targetSDK)
        versionCode = Versions.playStoreCode
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        applicationVariants.all {
            if(this.flavorName == "dev") {
                this.mergedFlavor.manifestPlaceholders["flavoredAppName"] = "Repo Tut-Dev"
            }else {
                this.mergedFlavor.manifestPlaceholders["flavoredAppName"] = "Repo Tut"
            }
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    flavorDimensions("version")

    productFlavors {
        create("dev") {
            dimension("version")
            versionName =
                "${Versions.versionMajor}.${Versions.versionMinor}.${Versions.versionPatch}.dev${Versions.devCode}"
            applicationIdSuffix = ".dev"
        }
        create("staging") {
            dimension("version")
            versionName =
                "${Versions.versionMajor}.${Versions.versionMinor}.${Versions.versionPatch}.stage${Versions.stageCode}"
            applicationIdSuffix = ".stage"
        }
    }
}


dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.multidex)
    implementation(Libraries.glide)

    //Test
    testImplementation(TestLibraries.junit4)
//    testImplementation(TestLibraries.mockitoCore)
//    testImplementation(TestLibraries.mockitoInline)
    testImplementation(TestLibraries.mockitoKotlin)
    testImplementation(TestLibraries.okHttp)
    testImplementation(TestLibraries.core)
    testImplementation(TestLibraries.kotlinTest)
//    testImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

    api(Libraries.coroutineCore)
    testImplementation(TestLibraries.coroutineTest)

    //Hilt
    implementation(Libraries.hilt)
    implementation(Libraries.hiltLifecycle)
    kapt(Libraries.hiltCompilerAndroid)
    kapt(Libraries.hiltCompiler)

    //Retrofit
    implementation(Libraries.gson)
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGsonConverter)
    implementation(Libraries.retrofitAdapter)
    implementation(Libraries.okLoggingInterceptor)

    //Room
    implementation(Libraries.room)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)
    androidTestImplementation(TestLibraries.roomTesting)

    //Lifecycle
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.lifecycleExtension)
    implementation(Libraries.lifecycleLivedata)

    //RX
    implementation(Libraries.rxkotlin)
    implementation(Libraries.rxAndroid)

    implementation(Libraries.googleMaterial)
    implementation(Libraries.timber)

    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUi)
}