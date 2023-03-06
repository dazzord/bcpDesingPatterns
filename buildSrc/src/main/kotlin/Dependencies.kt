object Versions {
    /** Plugins */
    const val buildToolsVersion = "7.2.2"
    const val kotlinVersion = "1.7.10"


    /** Libraries */
    const val compose = "1.2.1"
    const val composeCompiler = "1.3.1"
    const val ktx = "1.7.0"
    const val hilt = "2.42"
    const val ktxRuntimeLifecycle = "2.3.1"
    const val activityCompose = "1.3.1"
    const val splashScreen = "1.0.0"
    const val neumorphic = "1.0.0-alpha02"
    const val hiltNavigationCompose = "1.0.0"
    const val coroutines = "1.4.2"
    const val coil = "2.0.0"
    const val deviceUtils = "1.31.0"
    const val navigation = "2.4.2"
    const val composeViewModel = "2.4.1"
    const val accompanist = "0.25.1"
    const val sqliteJdbc = "3.34.0"
    const val dataStorePreferences = "1.0.0"
    const val gson = "2.9.1"


    /** Test Libraries */
    const val junit4 = "4.13.2"
    const val testExtJunit = "1.1.3"
    const val espresso = "3.4.0"
    const val mockk = "1.12.3"


}

object BuildPlugins {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val kotlinHiltGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val androidApplication = "com.android.application"
    const val jetbrainsKotlinAndroid = "org.jetbrains.kotlin.android"
    const val daggerHilt = "dagger.hilt.android.plugin"
    const val kapt = "kapt"
    const val library = "com.android.library"

}

object AndroidSdk {

    const val min = 23
    const val compileSdk = 33
    const val target = compileSdk
    const val versionCode = 13
    const val versionName = "1.1.0"

    const val kotlinCompileTargetVersion = "1.8"
}

object Libraries {

    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
    const val pagerIndicator =
        "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}"
    const val ktxRuntimeLifecycle =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxRuntimeLifecycle}"

    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"
    const val neumorphic = "me.nikhilchaudhari:composeNeumorphism:${Versions.neumorphic}"
    const val hiltandorid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltkapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltNavigation =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val hiltnav = "androidx.hilt:hilt-navigation-fragment:${Versions.hiltNavigationCompose}"
    const val xhiltkapt = "androidx.hilt:hilt-compiler:${Versions.hiltNavigationCompose}"
    const val koltlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    const val imagesCoil = "io.coil-kt:coil:${Versions.coil}"
    const val deviceUtils = "com.blankj:utilcodex:${Versions.deviceUtils}"
    const val composeViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val accompanist =
        "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}"
    const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
    const val sqliteJdbc = "org.xerial:sqlite-jdbc:${Versions.sqliteJdbc}"
    const val dataStore =
        "androidx.datastore:datastore-preferences:${Versions.dataStorePreferences}"


}

object TestLibraries {

    const val testIntrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testJunitExt = "androidx.test.ext:junit:${Versions.testExtJunit}"
    const val testExpreso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val composeUiTestJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeUiToolingTest = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
}
