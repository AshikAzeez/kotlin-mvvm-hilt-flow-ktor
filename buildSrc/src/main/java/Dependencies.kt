/**
 * @author Ashik
 * Created on 09/10/21 .
 */
object CoreLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val kotlinKtx = "androidx.core:core-ktx:${Versions.kotlinKtxVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
}


object SupportLibraries {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
}

object UiLibraries {
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
}

object TestLibraries {
    const val fragment = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"
    const val androidCore = "androidx.test:core-ktx:${Versions.ktxTest}"
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val dagger = "com.google.dagger:hilt-android-testing:${Versions.daggerHilt}"
    const val daggerKaptTest = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
}

object DaggerLibraries {
    const val daggerAndroid = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val hiltViewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewmodels}"
}

object NetworkLibraries {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"

}

object Navigation {
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationTest = "androidx.navigation:navigation-testing:${Versions.navigation}"
}
object Coroutines{
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}
object RoomDependency {
    const val room = "androidx.room:room-ktx:${Versions.roomDb}"
}
