// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (ClassPaths.gradleClasspath)
        classpath (ClassPaths.kotlinGradlePluginClasspath)
        classpath (ClassPaths.daggerHiltGradlePlugin)
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

/*
tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
*/


task<Delete>("clean") {
    delete(rootProject.buildDir)
}
