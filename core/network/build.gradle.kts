plugins {
    id("core-network-convention")
}

android {
    namespace = "org.alexcawl.forecaster.network"
}

dependencies {
    implementation(project(":core:common"))
}
