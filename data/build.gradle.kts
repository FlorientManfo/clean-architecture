plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    alias(libs.plugins.ksp)
}
apply<LibraryGradlePlugin>()

android {
    namespace = "com.example.data"
}

dependencies {

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.room.ktx)
    implementation(libs.gson.converter)
    ksp(libs.room.compiler)
    androidTestImplementation(libs.room.testing)

    implementation(libs.koin.core)
    implementation(libs.koin.android)
}