// Task 4.4: serving JSON data

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            // Write code to generate a response here
            val roll = DieRoll(6)
            call.respond(roll)
        }
    }
}
