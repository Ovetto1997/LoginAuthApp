// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.9.6"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    kotlin("plugin.serialization") version "2.3.0" apply false

    // KSP aligned with Kotlin 2.3.x
    id("com.google.devtools.ksp") version "2.3.4" apply false

    id("com.google.dagger.hilt.android") version "2.57.1" apply false
}
