plugins {
    kotlin("jvm") version "1.5.20"
}

group = "me.bardy"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit5"))
}

tasks.test {
    useJUnitPlatform()
}
