

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
    //    buildConfigFieldFromGradleProperty("apiBaseUrl")
    //    buildConfigField("FEATURE_MODULE_NAMES", getFeatureNames())
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled =  BuildTypeRelease.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            
        }
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
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
    //dynamicFeatures = ModuleDependency.getFeatureModules().toMutableSet()
    buildFeatures.viewBinding = true
}

/*
Takes value from Gradle project property and sets it as build config property
 */
/*
fun com.android.build.gradle.internal.dsl.BaseFlavor.buildConfigFieldFromGradleProperty(gradlePropertyName: String) {
    val propertyValue = project.properties[gradlePropertyName] as? String
    checkNotNull(propertyValue) { "Gradle property $gradlePropertyName is null" }

    val androidResourceName = "GRADLE_${gradlePropertyName.toSnakeCase()}".toUpperCase()
    buildConfigField("String", androidResourceName, propertyValue)
}
*/

//fun String.toSnakeCase() = this.split(Regex("(?=[A-Z])")).joinToString("_") { it.toLowerCase() }

/*
Adds a new field to the generated BuildConfig class
 */
/*fun DefaultConfig.buildConfigField(name: String, value: Array<String>) {
    // Create String that holds Java String Array code
    val strValue = value.joinToString(prefix = "{", separator = ",", postfix = "}", transform = { "\"$it\"" })
    buildConfigField("String[]", name, strValue)
}*/

/*
Return names of the features
 */
/*
fun getFeatureNames() = ModuleDependency.getFeatureModules()
    .map { it.replace(":feature_", "") }
    .toTypedArray()
*/




dependencies {
    implementation(CoreLibraries.kotlin)
    implementation(SupportLibraries.appCompat)
    implementation(UiLibraries.material)
    implementation(TestLibraries.androidxJunit)
    implementation(TestLibraries.espresso)
    implementation(TestLibraries.jUnit)
}
