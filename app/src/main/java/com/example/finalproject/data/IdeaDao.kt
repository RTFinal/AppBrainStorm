package com.example.finalproject.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IdeaDao {
    @Query("SELECT * FROM ideas")
    fun getAllIdeas(): Flow<List<IdeaEntity>>

    @Insert
    suspend fun insertIdea(idea: IdeaEntity)
}
