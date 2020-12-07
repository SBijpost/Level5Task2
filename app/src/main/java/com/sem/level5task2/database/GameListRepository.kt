package com.sem.level5task2.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.level5task2.model.Game

class GameListRepository(context: Context) {

    private var gameDao: GameDao

    init {
        val database = GameListRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    fun getGameList(): LiveData<List<Game>> {
        return gameDao?.getGameList()
    }

    suspend fun updateGameList(game: Game) {
        gameDao.updateGame(game)
    }

    fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }

    suspend fun deleteAllGames() {
        gameDao.deleteAllGames()
    }

}
