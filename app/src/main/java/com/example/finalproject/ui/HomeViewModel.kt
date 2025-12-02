package com.example.finalproject.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.finalproject.data.AppDatabase
import com.example.finalproject.data.IdeaEntity
import com.example.finalproject.data.IdeaRepository

/**
 * ViewModel for the Home screen. 
 * It retrieves all the ideas from the database and exposes them to the UI.
 */
class HomeViewModel(application: Application) : ViewModel() {

    private val repository: IdeaRepository
    val allIdeas: LiveData<List<IdeaEntity>>

    init {
        val ideaDao = AppDatabase.getDatabase(application).ideaDao()
        repository = IdeaRepository(ideaDao)
        allIdeas = repository.allIdeas.asLiveData()
    }
}

/**
 * Factory for creating a HomeViewModel with a constructor that takes an Application.
 */
class HomeViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}