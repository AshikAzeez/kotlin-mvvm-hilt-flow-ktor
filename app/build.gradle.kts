plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.daggerHilt)
    id(Plugins.kotlinKapt)
}

android {
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicatiınId
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
        versionCode = Release.versionCode
        versionName = Release.versionName
        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            //resValue("string","api_key","YOUR_RELEASE_API_KEY_HERE")

        }
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            //resValue("string","api_key","YOUR_SANDBOX_API_KEY_HERE")
        }
        testOptions {
            unitTests.isReturnDefaultValues = TestOptions.IS_RETURN_DEFAULT_VALUES
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    lint {
        // By default lint does not check test sources, but setting this option means that lint will not even parse them
        isIgnoreTestSources = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    buildFeatures {
        viewBinding = true
       // dataBinding = true
        //compose = true

    }
    configurations.all {
      //  resolutionStrategy.force("com.google.code.findbugs.jsr305:3.0.0")
    }
}

dependencies {
    implementation(CoreLibraries.kotlin)
    implementation(CoreLibraries.kotlinKtx)
    implementation(SupportLibraries.appCompat)
    implementation(UiLibraries.material)
    implementation(CoreLibraries.fragmentKtx)

    //dependency injection + Test
    implementation(DaggerLibraries.daggerAndroid)
    implementation(RoomDependency.room)
    //implementation(DaggerLibraries.hiltViewmodel)
    kapt(DaggerLibraries.daggerCompiler)

    //Network
    implementation(NetworkLibraries.retrofit2)
    implementation(NetworkLibraries.gsonConverter)


    implementation(Navigation.navigationFragment)
    implementation(Navigation.navigationUi)
    implementation(Navigation.navigationTest)
    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)
    implementation(Coroutines.lifecycleScope)

    //Test
    testImplementation(TestLibraries.jUnit)
    testImplementation(TestLibraries.androidxJunit)

    androidTestImplementation(TestLibraries.androidxJunit)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.jUnit)
    androidTestImplementation(TestLibraries.dagger)
    kaptAndroidTest(TestLibraries.daggerKaptTest)

    androidTestImplementation(TestLibraries.fragment)
    androidTestImplementation(TestLibraries.androidCore)

}
kapt {
    correctErrorTypes = true
}
