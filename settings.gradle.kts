pluginManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        /*发布到本地仓库时测试用*/
        mavenLocal()
        /*发布到snapshot仓库时使用*/
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from("com.xeonyu:version-catalog:0.0.8")
            version("xeonBsDiff", "1.0.4")
        }
    }
}

rootProject.name = "XeonBsDiff"
include(":app")
include(":bsdiff")
