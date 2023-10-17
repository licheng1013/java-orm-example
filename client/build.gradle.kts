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
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("com.alibaba:druid:1.1.12")

}

