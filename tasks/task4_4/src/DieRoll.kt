import kotlinx.serialization.Serializable
import kotlin.random.Random


// we wish to serialize instances of DieRoll
@Serializable
class DieRoll(val sides: Int) {
    val result: Int

    init {
        require(sides in setOf(4, 6, 8, 10, 12, 20)) { "Invalid sides" }
        result = Random.nextInt(sides) + 1
    }
}