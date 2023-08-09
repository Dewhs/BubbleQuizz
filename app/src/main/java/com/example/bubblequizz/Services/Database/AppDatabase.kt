package com.example.bubblequizz.Services.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bubblequizz.R

/**
 * The Room database for this app
 */
@Database(entities = [Score::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scoreDao(): ScoresDao

    lateinit var db: RoomDatabase;
    fun init(applicationContext: Context) {
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, R.string.app_name.toString() //
        ).build()
    }
    // Je me suis arrêté là
    // à voir :
    // @singleton c'est quoi
    // la class est abstract ça fait rien avec init ?
    // voir si on le met static (oui)


}