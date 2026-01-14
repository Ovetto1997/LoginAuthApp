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

    kotlin("plugin.serialization") version "2.0.0" apply false

    // KSP aligned with Kotlin 2.0.x
    id("com.google.devtools.ksp") version "2.0.0-1.0.21" apply false

    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}
