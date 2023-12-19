plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
}
apply<LibraryGradlePlugin>()

android {
    namespace = "com.example.domain"
}

dependencies {
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.koin.core)
    implementation(libs.koin.android)
}