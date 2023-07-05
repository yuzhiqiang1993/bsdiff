plugins {
    alias(libs.plugins.xeonyu.application)
}

android {
    namespace = "com.yzq.bsdiff.demo"
    defaultConfig {
        applicationId = "com.yzq.bsdiff.demo"
        versionCode = 1
        versionName = "0.0.1"
        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.utilcodex)


    // 依赖远程库
//    implementation("com.xeonyu:bsdiff:1.0.3-SNAPSHOT")
    implementation(libs.xeonyu.bsdiff)
    // 依赖本地库
    //    implementation(project(":bsdiff"))
}
