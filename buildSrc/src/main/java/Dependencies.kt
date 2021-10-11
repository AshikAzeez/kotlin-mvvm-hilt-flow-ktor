import kotlin.reflect.full.memberProperties

/**
 * @author Ashik
 * Created on 09/10/21 .
 */
object CoreLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    val kotlinKtx = "androidx.core:core-ktx:${Versions.kotlinKtxVersion}"
}


object SupportLibraries {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
}

object UiLibraries{
    val material = "com.google.android.material:material:${Versions.materialVersion}"
}

object TestLibraries {
    val jUnit = "junit:junit:${Versions.jUnitVersion}"
    val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
}

object Module {
    val app = ":app"
    val api = ":api"

    /*
    Return list of all modules in the project
     */
    fun getAllModules() = Module::class.memberProperties
        .filter { it.isConst }
        .map { it.getter.call().toString() }
        .toSet()

    /*
     Return list of feature modules in the project
     */
    fun getFeatureModules(): Set<String> {
        val featurePrefix = ":feature_"

        return getAllModules()
            .filter { it.startsWith(featurePrefix) }
            .toSet()
    }

}
