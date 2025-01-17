buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Libs.com_android_tools_build_gradle)
        classpath(Libs.kotlin_gradle_plugin)
        classpath(Libs.navigation_safe_args_gradle_plugin)
    }
}

plugins {
    buildSrcVersions
}


allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://maven.java.net/content/groups/public/")
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

