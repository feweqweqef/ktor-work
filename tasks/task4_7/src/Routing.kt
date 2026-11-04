// Task 4.7

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.pebble.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondTemplate("form.peb", emptyMap())
        }

        // POST: form data
        post("/roll") {
            val params = call.receiveParameters()
            val numDice = params["num_dice"]?.toIntOrNull()
            val dieSides = params["die_sides"]?.toIntOrNull()

            if (numDice == null || dieSides == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid form data")
                return@post
            }

            try {
                val roll = DiceRoll(numDice, dieSides)
                call.respondTemplate("result.peb", mapOf("roll" to roll))
            } catch (e: IllegalArgumentException) {
                call.respond(HttpStatusCode.BadRequest, e.message ?: "Invalid roll")
            }
        }

        // GET: URLs like /roll/3d8
        get("/roll/{spec}") {
            val spec = call.parameters["spec"] ?: ""
            val match = Regex("""(\d+)d(\d+)""").matchEntire(spec)

            if (match == null) {
                call.respond(HttpStatusCode.BadRequest, "Use a format like 3d8")
                return@get
            }

            val numDice = match.groupValues[1].toInt()
            val dieSides = match.groupValues[2].toInt()

            try {
                val roll = DiceRoll(numDice, dieSides)
                call.respondTemplate("result.peb", mapOf("roll" to roll))
            } catch (e: IllegalArgumentException) {
                call.respond(HttpStatusCode.BadRequest, e.message ?: "Invalid roll")
            }
        }
    }
}