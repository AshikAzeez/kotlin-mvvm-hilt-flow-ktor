/**
 * @author Ashik
 * Created on 09/10/21 .
 */
object Config {

    const val applicatiınId = "com.sample.kotlin_mvvm_hilt_flow_ktor"
    const val apiApplicatiınId = "com.sample.api"

    //const val testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    const val testInstrumentationRunner = "com.sample.kotlin_mvvm_hilt_flow_ktor.MyTestRunner"


}

interface BuildType {
    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
    val shrinkResources: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override val shrinkResources = false
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = true
    override val shrinkResources = true
}

object TestOptions {
    const val IS_RETURN_DEFAULT_VALUES = true
}

