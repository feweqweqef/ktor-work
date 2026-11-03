// Task 4.6.1: Pebble templates

import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        // Add the new route here
         get("/") {
            val roll = DieRoll(6)
            call.respondTemplate("roll.peb", mapOf("roll" to roll))
        }

        get("/json") {
            val roll = DieRoll(6)
            call.respond(roll)
        }
    }
}
