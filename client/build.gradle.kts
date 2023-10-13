plugins {
    id("java")
}

group = "com.aiwan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 依赖 common 模块
    implementation(project(":common"))
}

