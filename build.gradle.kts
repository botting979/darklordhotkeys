
plugins {
    id("java")
}

group = "com.darklordhotkeys"
version = "1.0.0"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.runelite.net") }
}

dependencies {
    compileOnly("net.runelite:client:1.9.15") // Adjust for Devious base version
}
