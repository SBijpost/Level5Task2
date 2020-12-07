package com.sem.level5task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sem.level5task2.converters.Converters
import com.sem.level5task2.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class GameListRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "GAMELIST_DATABASE"

        @Volatile
        private var INSTANCE: GameListRoomDatabase? = null

        fun getDatabase(context: Context): GameListRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(GameListRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            GameListRoomDatabase::class.java, DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
