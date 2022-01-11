plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.datadoghq.dd-sdk-android-gradle-plugin")
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdkVersion = 31
    buildToolsVersion = "31.0.0"

    defaultConfig {
        applicationId "com.example.variants"
        minSdkVersion 21
        targetSdkVersion = 31
        compileSdkVersion = 31
        versionCode 1
        versionName "1.0"
        multiDexEnabled = true
    }

    buildTypes {
        release {
            minifyEnabled true
            proguardFiles getDefaultProguardFile ('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        implementation("com.datadoghq:dd-sdk-android:1.11.1")
    }

    flavorDimensions("version", "colour")
    productFlavors {
        demo {
            dimension "version"
            applicationIdSuffix ".demo"
            versionNameSuffix "-demo"
        }
        full {
            dimension "version"
            applicationIdSuffix ".full"
            versionNameSuffix "-full"
        }
        pro {
            dimension "version"
            applicationIdSuffix ".pro"
            versionNameSuffix "-pro"
        }

        red {
            dimension "colour"
        }
        green {
            dimension "colour"
        }
        blue {
            dimension "colour"
        }
    }
}
