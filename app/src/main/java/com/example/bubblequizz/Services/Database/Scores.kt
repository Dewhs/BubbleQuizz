package com.example.bubblequizz.Services.Database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * A table representing all the scores
 *
 * They have a many-to-one relation to an individual Category
 *
 * @property score
 * @property categoryId
 * are both indexed to provide a faster search
 */
@Entity(tableName = "Scores", indices = [Index(value = ["score", "categoryId"])])
data class Score(
    @PrimaryKey val uid: Int,
    val name: String = "",
    val score: UInt = 0u,
    val categoryId: UInt,
)
