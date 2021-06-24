
plugins {
    kotlin("jvm") version "1.5.10"
}

group = "pro.darc.cake.addon"
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
    implementation(kotlin("stdlib"))
    implementation("org.spigotmc:spigot-api:1.17-R0.1-SNAPSHOT")
    implementation("pro.darc.cake", "cakeapi", "0.1.2")
}


tasks.processResources {
    expand(
        "plugin_main_path" to "${project.group}.${project.name}",
        "plugin_version" to project.version,
        "plugin_name" to project.name
    )
}
