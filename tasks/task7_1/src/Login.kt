// Task 7.1: password authentication

import com.password4j.Password
import kotlin.io.path.*
import kotlin.time.measureTime

fun login(username: String, password: String) {
    val input = Path(HASH_FILENAME).readText()
    val expectedUsername = input.substringBefore(",")
    val expectedHash = input.substringAfter(",")
    var passwordValid = false
    val timeToCheck = measureTime {
        passwordValid = Password.check(password, expectedHash).withScrypt()
}
    println("Hash check took $timeToCheck")
    when (username == expectedUsername && passwordValid) {
    true -> println("\u2705 Login succeeded!")
    false -> println("\u274c Login failed!")
}
}
