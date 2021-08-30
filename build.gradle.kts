import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
    kotlin("kapt") version "1.5.21"
}

group = "com.city.weather"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_16

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui
    implementation("org.springdoc:springdoc-openapi-ui:1.5.2")

    implementation("mysql:mysql-connector-java:8.0.15")

    // https://mvnrepository.com/artifact/org.mapstruct/mapstruct
    implementation("org.mapstruct:mapstruct:1.4.2.Final")

    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.12.0")

    // https://mvnrepository.com/artifact/org.simpleflatmapper/sfm-jdbc
    implementation("org.simpleflatmapper:sfm-springjdbc:8.2.3")
    // https://mvnrepository.com/artifact/com.google.guava/guava
    implementation("com.google.guava:guava:r05")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")


    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    // https://mvnrepository.com/artifact/org.testcontainers/junit-jupiter
    testImplementation("org.testcontainers:junit-jupiter:1.16.0")

    // https://mvnrepository.com/artifact/org.testcontainers/mysql
    testImplementation("org.testcontainers:mysql:1.16.0")
}

//kapt {
//    arguments {
//        // Set Mapstruct Configuration options here
//        // https://kotlinlang.org/docs/reference/kapt.html#annotation-processor-arguments
//        // https://mapstruct.org/documentation/stable/reference/html/#configuration-options
////        arg("mapstruct.defaultComponentModel", "spring")
//    }
//}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
        jvmTarget = "16"
    }
}

 tasks.withType<Test> {
    useJUnitPlatform()
}
