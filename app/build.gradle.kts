plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
   // alias(libs.plugins.kapt) apply false

    id("com.google.devtools.ksp")


}

//java {
//    toolchain {
//        languageVersion = JavaLanguageVersion.of(17)
//    }
//}

android {
    namespace = "com.littlelemon.roomapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.littlelemon.roomapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "17"
//    }

    compileOptions {
       sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
//    kotlin {
//        jvmToolchain {
//            languageVersion.set(JavaLanguageVersion.of(<MAJOR_JDK_VERSION>))
//        }
//        // Or shorter:
//        jvmToolchain(<MAJOR_JDK_VERSION>)
//        // For example:
//        jvmToolchain(17)
//    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.kotlinx.coroutines.android)
    implementation (libs.kotlinx.coroutines.core)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata)
    implementation (libs.androidx.room.runtime)
  // annotationProcessor (libs.androidx.room.compiler)

    ksp(libs.androidx.room.compiler)

    implementation (libs.androidx.room.ktx)

    implementation (libs.retrofit)
    implementation (libs.converter.gson)





}