import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

buildscript {
    val kotlinVersion = "1.0.6"
    val junitPlatformVersion = "1.0.0-M3"
    extra["kotlinVersion"] = kotlinVersion
    extra["junitPlatformVersion"] = junitPlatformVersion

    repositories {
        mavenCentral()
        jcenter()
        maven{
            setUrl("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.junit.platform:junit-platform-gradle-plugin:$junitPlatformVersion")
    }
}

apply {
    plugin("idea")
    plugin("kotlin")
    plugin("org.junit.platform.gradle.plugin")
}

version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { setUrl("https://repo.spring.io/milestone") }
    maven { setUrl("https://repo.spring.io/snapshot") }
}

val kotlinVersion = extra["kotlinVersion"] as String
val springVersion = "5.0.0.BUILD-SNAPSHOT"
val jacksonVersion = "2.8.5"
val reactorVersion = "3.0.4.RELEASE"
val junitPlatformVersion = extra["junitPlatformVersion"] as String
val junitJupiterVersion  = "5.0.0-M3"

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

    compile("org.springframework:spring-aop:$springVersion")
    compile("org.springframework:spring-beans:$springVersion")
    compile("org.springframework:spring-context:$springVersion")
    compile("org.springframework:spring-core:$springVersion")
    compile("org.springframework:spring-expression:$springVersion")
    compile("org.springframework:spring-tx:$springVersion")
    compile("org.springframework:spring-web:$springVersion")
    compile("org.springframework:spring-web-reactive:$springVersion")

    compile("io.projectreactor:reactor-core:$reactorVersion")
    compile("io.projectreactor.ipc:reactor-netty:0.6.0.RELEASE")
    compile("io.projectreactor:reactor-kotlin:1.0.0.BUILD-SNAPSHOT")
    testCompile("io.projectreactor.addons:reactor-test:$reactorVersion")

    compile("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    compile("commons-logging:commons-logging:1.2")
    compile("org.slf4j:slf4j-api:1.7.21")
    compile("ch.qos.logback:logback-classic:1.1.7")

    testCompile("org.junit.platform:junit-platform-runner:$junitPlatformVersion")
    testCompile("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}
