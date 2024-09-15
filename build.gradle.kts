// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.devtools.ksp") version "2.0.20-1.0.25" apply false
    id("com.android.library") version "8.6.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20"
}

buildscript {
    dependencies {
        val hiltVersion by extra("2.52")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}