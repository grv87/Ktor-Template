package com.onegravity

object Dependency {

    private const val ktorVersion = "1.6.2"
    private const val koinVersion = "3.1.0"

    private const val kotlinSerializationVersion = "1.2.2"
    private const val moshiVersion = "1.12.0"

    private const val postgresVersion = "42.2.20"
    private const val ktormVersion = "3.4.1"
    private const val exposedVersion = "0.17.13"
    private const val flywayVersion = "7.13.0"
    private const val hikariCPVersion = "4.0.3"

    private const val openApiGenVersion = "0.2-beta.20"
    private const val logbackVersion = "1.2.3"
    private const val dotenvVersion = "6.2.2"

    private const val kotestVersion = "4.6.1"
    private const val testcontainersVersion = "1.16.0"

    val implementation = mapOf(
        // Ktor Server
        "io.ktor:ktor-server-core" to ktorVersion,
        "io.ktor:ktor-server-netty" to ktorVersion,

        // Monitoring metrics
        "io.ktor:ktor-metrics" to ktorVersion,
        "io.ktor:ktor-metrics-micrometer" to ktorVersion,

        // Security
        "io.ktor:ktor-auth" to ktorVersion,
        "io.ktor:ktor-auth-jwt" to ktorVersion,

        // Koin / Dependency Injection
        "io.insert-koin:koin-ktor" to koinVersion,
        "io.insert-koin:koin-logger-slf4j" to koinVersion,

        // Kotlinx Serialization / Deserialization
        "io.ktor:ktor-serialization" to ktorVersion,
        "org.jetbrains.kotlinx:kotlinx-serialization-core" to kotlinSerializationVersion,
        // GSON Serialization / Deserialization
        "io.ktor:ktor-gson" to ktorVersion,
        // Moshi
        "com.squareup.moshi:moshi-kotlin" to moshiVersion,

        // Postgres
        "org.postgresql:postgresql" to postgresVersion,
        // Ktorm (ORM)
        "org.ktorm:ktorm-core" to ktormVersion,
        "org.ktorm:ktorm-support-postgresql" to ktormVersion,
        "org.ktorm:ktorm-jackson" to ktormVersion,
        // Exposed (ORM)
        "org.jetbrains.exposed:exposed" to exposedVersion,
        // HikariCP (Connection Pooling)
        "com.zaxxer:HikariCP" to hikariCPVersion,
        // Flyway (DB migration)
        "org.flywaydb:flyway-core" to flywayVersion,

        // OpenAPI Generator
        "com.github.1gravity:Ktor-OpenAPI-Generator" to openApiGenVersion,

        // Miscellaneous
        "io.github.cdimascio:dotenv-kotlin" to dotenvVersion,

        // Logging
        "ch.qos.logback:logback-classic" to logbackVersion
    ).toStringList()

    val runtime = emptyList<String>()

    val testImplementation = mapOf(
        "io.ktor:ktor-server-tests" to ktorVersion,
        "org.jetbrains.kotlin:kotlin-test" to "1.5.21",

        // Kotest
        "io.kotest:kotest-runner-junit5" to kotestVersion,
        "io.kotest:kotest-assertions-core" to kotestVersion,
        "io.kotest:kotest-property" to kotestVersion,
        "io.kotest:kotest-assertions-json" to kotestVersion,

        // Testcontainers for Postgres
        "org.testcontainers:junit-jupiter" to testcontainersVersion,
        "org.testcontainers:postgresql" to testcontainersVersion
    ).toStringList()

}
