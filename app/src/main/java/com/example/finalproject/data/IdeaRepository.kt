package com.example.finalproject.data

import kotlinx.coroutines.flow.Flow

class IdeaRepository(private val ideaDao: IdeaDao) {

    val allIdeas: Flow<List<IdeaEntity>> = ideaDao.getAllIdeas()

    suspend fun insert(idea: IdeaEntity) {
        ideaDao.insertIdea(idea)
    }
}
