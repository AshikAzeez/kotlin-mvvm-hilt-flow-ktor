/**
 * @author Ashik
 * Created on 09/10/21 .
 */
object Config {

    val applicatiınId = "com.sample.kotlin_mvvm_hilt_flow_ktor"
    val apiApplicatiınId = "com.sample.api"
    val testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

    
}

interface BuildType {
    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
}

object TestOptions {
    const val IS_RETURN_DEFAULT_VALUES = true
}

