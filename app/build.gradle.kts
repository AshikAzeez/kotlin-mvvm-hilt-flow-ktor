plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
}

android {
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicatiınId
        minSdk =Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
        versionCode = Release.versionCode
        versionName = Release.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled =  BuildTypeRelease.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            resValue("string","api_key","YOUR_RELEASE_API_KEY_HERE")
            
        }
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            resValue("string","api_key","YOUR_SANDBOX_API_KEY_HERE")
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


    buildFeatures{
        viewBinding = true
        dataBinding = true
        compose = true
        
    }
}



dependencies {
    implementation(CoreLibraries.kotlin)
    implementation(CoreLibraries.kotlinKtx)
    implementation(SupportLibraries.appCompat)
    implementation(UiLibraries.material)
    //Compose
    implementation(UiLibraries.composeUi)
    implementation(UiLibraries.composeMaterial)
    implementation(UiLibraries.composeUiToolingPreview)
    implementation(UiLibraries.composeActivity)


    //Test
    implementation(TestLibraries.androidxJunit)
    implementation(TestLibraries.espresso)
    implementation(TestLibraries.jUnit)
}
