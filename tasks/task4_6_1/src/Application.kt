// Task 4.6.1: Pebble templates

import io.ktor.server.application.Application

fun Application.module() {
    // invoke template configuration module here
    configureSerialization()
    configureTemplates()
    configureRouting()
}

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}
