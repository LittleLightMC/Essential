
plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.20"
}

group = "com.github.littlelightmc.essential"
version = "0.1.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/LittleLightMC/*")
        credentials {
            username = properties["llmc.usr"] as String
            password = properties["llmc.key"] as String
        }
    }
    google()
    maven("https://jitpack.io")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/") {
        name = "sonatype-oss-snapshots"
    }
    maven("https://repo.viaversion.com")
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly("org.spigotmc:spigot-api:1.17-R0.1-SNAPSHOT")
    compileOnly("pro.darc.cake", "cakeapi", "0.1.22")
    compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    compileOnly("org.redisson:redisson:3.16.0")
    compileOnly("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
    compileOnly("org.litote.kmongo:kmongo-id:4.2.8")
    compileOnly("org.litote.kmongo:kmongo-coroutine-serialization:4.2.8")
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime,kotlin.ExperimentalStdlibApi,kotlinx.coroutines.ExperimentalCoroutinesApi,kotlin.RequiresOptIn"
}

tasks.processResources {
    expand(
        "plugin_main_path" to "${project.group}.${project.name}",
        "plugin_version" to project.version,
        "plugin_name" to project.name
    )
}
