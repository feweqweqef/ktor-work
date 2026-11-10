// Task 7.1: password authentication

import com.password4j.Password
import kotlin.io.path.*

const val HASH_FILENAME = "hash.csv"

fun register(username: String, password: String) {
    
    val hash = Password.hash(password).addRandomSalt(8).withScrypt()
    val filePath = Path(HASH_FILENAME)
    filePath.writeText("$username,${hash.result}\n")
}
