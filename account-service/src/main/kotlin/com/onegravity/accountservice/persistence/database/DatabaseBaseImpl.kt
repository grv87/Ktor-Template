package com.onegravity.accountservice.persistence.database

import com.onegravity.accountservice.persistence.model.account.Accounts
import com.onegravity.accountservice.persistence.model.customer.Customers
import com.onegravity.accountservice.persistence.model.device.Devices
import com.onegravity.accountservice.persistence.model.email.Emails
import org.flywaydb.core.Flyway
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.ktorm.entity.sequenceOf
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.slf4j.Logger

abstract class DatabaseBaseImpl(logLevel: LogLevel = LogLevel.WARN, cleanDB: Boolean = false) : Database, KoinComponent {

    private val logger by inject<Logger>()

    abstract val url: String
    abstract val driver: String
    abstract val user: String
    abstract val password: String

    private val database by lazy {
        logger.debug("database url:      $url")
        logger.debug("database driver:   $driver")
        logger.debug("database user:     $user")
        logger.debug("database password: ***")

        org.ktorm.database.Database.connect(
            url = url,
            driver = driver,
            user = user,
            password = password,
            logger = ConsoleLogger(threshold = logLevel)
        ).also {
            // enable this if you want to erase the Flyway migration history (tests need to)
            if (cleanDB) flyway.clean()
            // run database migration
            flyway.migrate()
        }
    }

    private val flyway: Flyway by lazy {
        Flyway
            .configure()
            .dataSource(url, user, password)
            .load()
    }

    override fun accounts() = database.sequenceOf(Accounts)

    override fun customers() = database.sequenceOf(Customers, withReferences = true)

    override fun emails() = database.sequenceOf(Emails, withReferences = true)

    override fun devices() = database.sequenceOf(Devices, withReferences = true)

}
