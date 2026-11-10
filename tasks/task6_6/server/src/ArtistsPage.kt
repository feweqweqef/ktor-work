// Task 6.6

import io.ktor.server.pebble.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.v1.core.*
import org.jetbrains.exposed.v1.jdbc.*
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction

suspend fun RoutingCall.artistsPage() {
    suspendTransaction {
        val artists = ArtistTable
            .selectAll()
            .orderBy(ArtistTable.artistName)
            .map { it[ArtistTable.artistName] }

        respondTemplate("artists.peb", mapOf("artists" to artists))
    }
}