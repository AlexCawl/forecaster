import org.gradle.accessors.dm.LibrariesForLibs

val libs = the<LibrariesForLibs>()

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp")
}

dependencies {
    // Kotlin
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    // Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.coroutines.extensions)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.lottie)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.splash)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

val java = JavaVersion.valueOf(libs.versions.java.get())
val sdkCompile = libs.versions.sdkCompile.get().toInt()
val sdkTarget = libs.versions.sdkTarget.get().toInt()
val sdkMin = libs.versions.sdkMin.get().toInt()

android {
    compileSdk = sdkCompile

    defaultConfig {
        minSdk = sdkMin
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        targetSdk = sdkTarget
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = java
        targetCompatibility = java
    }

    kotlinOptions {
        jvmTarget = java.toString()
    }
}