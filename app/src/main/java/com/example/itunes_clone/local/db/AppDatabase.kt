package com.example.itunes_clone.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.itunes_clone.local.dao.MusicDao
import com.example.itunes_clone.local.models.MusicEntity

@Database(
    entities = [
        MusicEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun musicDao(): MusicDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                databaseBuilder(context).also { INSTANCE = it }
            }

        private fun databaseBuilder(context: Context): AppDatabase {
            val dbName = "itunes_clone_db"
            val builder = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                dbName
            )
            return builder.build()
        }
    }
}