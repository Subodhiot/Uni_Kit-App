// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath ("com.google.gms:google-services:4.3.15")
        classpath ("com.google.android.gms:oss-licenses-plugin:0.10.6")
    }
}
plugins {
    id("com.android.application") version "8.1.2" apply false
    id ("com.android.library") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id ("com.google.relay") version "0.3.06"
    id ("com.google.gms.google-services") version "4.3.15" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}