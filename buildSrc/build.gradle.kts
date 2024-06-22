import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `kotlin-dsl`
}

val libs = the<LibrariesForLibs>()

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.plugin.kotlin.gradle)
    implementation(libs.plugin.kotlin.serialization)
    implementation(libs.plugin.kotlin.ksp)
    implementation(libs.plugin.android.application)
    implementation(libs.plugin.android.library)
}