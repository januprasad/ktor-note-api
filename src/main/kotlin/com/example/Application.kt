package com.example

import com.example.data.di.modules.mainModule
import com.example.data.source.DatabaseFactory
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin

fun main() {
    embeddedServer(Netty, port = 9090, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Koin) {
        modules(mainModule)
    }
    val databaseFactory by inject<DatabaseFactory>()
    databaseFactory.init()
    configureMonitoring()
    configureSerialization()
    configureSecurity()
    configureRouting()
}