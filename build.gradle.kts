plugins {
    id("java")
}

group = "com.aiwan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

}


subprojects {
    apply(plugin = "java")
    repositories {
        mavenCentral()
    }
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web:2.7.16")
        // lombok 必须要加上这两个依赖
        implementation("org.projectlombok:lombok:1.18.22")
        annotationProcessor("org.projectlombok:lombok:1.18.22")
    }
}