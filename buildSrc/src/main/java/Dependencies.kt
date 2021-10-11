import kotlin.reflect.full.memberProperties

/**
 * @author Ashik
 * Created on 09/10/21 .
 */
object CoreLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val kotlinKtx = "androidx.core:core-ktx:${Versions.kotlinKtxVersion}"
}


object SupportLibraries {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
}

object UiLibraries{
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
}

object TestLibraries {
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
}
