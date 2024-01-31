plugins {
    kotlin("jvm") version "1.9.22"
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("dev.kensa:kensa:0.4.13")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
}
repositories {
    mavenCentral()
    mavenLocal()
}
kotlin {
    jvmToolchain(17)
}