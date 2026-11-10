// Task 6.5: populating database tables using Exposed's SQL DSL

import org.jetbrains.exposed.v1.jdbc.*
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main() {
    transaction(MusicDatabase.db) {
        // Start from empty tables

        SchemaUtils.drop(ArtistTable, AlbumTable)
        SchemaUtils.create(ArtistTable, AlbumTable)

        // Add at least three artists
        
        val travisScott = ArtistTable.insertAndGetId{
            it[artistName] = "Travis, Scott"
            it[isSolo] = true
            it[info] = "https://www.travisscott.com/"
        }
        
        val slayr = ArtistTable.insertAndGetId{
            it[artistName] = "Slayr"
            it[isSolo] = true
            it[info] = "https://genius.com/artists/Slayr"
        }
        
        val fleetwoodMac = ArtistTable.insertAndGetId {
            it[artistName] = "Fleetwood Mac"
            it[isSolo] = false
            it[info] = "https://fleetwoodmac.com"
}

        // Add at least four albums
        
        AlbumTable.insert{
                it[title] = "Rodeo"
                it[artist] = travisScott
                it[year] = 2015
        }
        
        AlbumTable.insert{
                it[title] = "Astroworld"
                it[artist] = travisScott
                it[year] = 2018
        }
        
        AlbumTable.insert{
                it[title] = "Halfblood"
                it[artist] = slayr
                it[year]  = 2026
        }
        AlbumTable.insert {
            it[title] = "Rumours"
            it[artist] = fleetwoodMac
            it[year] = 1977
}
        

    }
}
