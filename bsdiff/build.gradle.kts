plugins {
    alias(libs.plugins.xeonyu.library)
    alias(libs.plugins.vanniktechPublish)
}

android {
    namespace = "com.yzq.bsdiff"

    defaultConfig {
        externalNativeBuild {
            cmake {
                cppFlags("")
            }
        }
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.10.2"
        }
    }
}