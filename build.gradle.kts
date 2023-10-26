// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {


        val hilt = "2.47"
        dependencies {
            classpath("com.google.dagger:hilt-android-gradle-plugin:$hilt")
        }

    }
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
    }
}
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}