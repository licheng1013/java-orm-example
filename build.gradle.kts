plugins {
    id("java")
}

group = "com.aiwan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 等同于maven中的 <dependencyManagement>...</dependencyManagement> 标签
    constraints {
        implementation("org.springframework.boot:spring-boot-dependencies:2.7.16")
        implementation("org.springframework.boot:spring-boot-starter-web:2.7.16")
    }
}

