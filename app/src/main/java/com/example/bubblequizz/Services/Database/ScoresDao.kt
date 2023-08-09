package com.example.bubblequizz.Services.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


/**
 * An interface to interact with the Scores table
 *
 * @property GetBestfromCategory return the top-scoring [Score] within a specified 'categoryId'
 * limited by 'limit'.
 * It is recommended to limits the number of call by querying a higher limit and caching the results
 *
 */
@Dao
interface ScoresDao {

    @Query(
        "SELECT Score FROM Scores " +
                "WHERE categoryId = :categoryId " +
                "ORDER BY score DESC " +
                "LIMIT :limit;"
    )
    fun GetBestfromCategory(limit: UInt, categoryId: UInt): List<Score>

    @Insert
    fun insert(score: Score)

    // No deletion needed
}
