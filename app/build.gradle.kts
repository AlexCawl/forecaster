plugins {
    id("application-convention")
}

android {
    namespace = libs.versions.name.get()
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":feature:current"))
    implementation(project(":feature:daily"))
    implementation(project(":feature:locations"))
    implementation(project(":feature:settings"))
}
