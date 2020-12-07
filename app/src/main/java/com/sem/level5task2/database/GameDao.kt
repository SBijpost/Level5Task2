package com.sem.level5task2.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sem.level5task2.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    fun getGameList(): LiveData<List<Game>>

    @Insert
    fun insertGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM gameTable")
    suspend fun deleteAllGames()

}
