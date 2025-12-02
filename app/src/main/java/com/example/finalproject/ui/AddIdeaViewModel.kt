package com.example.finalproject.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.AppDatabase
import com.example.finalproject.data.IdeaEntity
import com.example.finalproject.data.IdeaRepository
import kotlinx.coroutines.launch

/**
 * ViewModel for the Add Idea screen.
 * It saves new ideas to the database.
 */
class AddIdeaViewModel(application: Application) : ViewModel() {

    private val repository: IdeaRepository

    init {
        val ideaDao = AppDatabase.getDatabase(application).ideaDao()
        repository = IdeaRepository(ideaDao)
    }

    /**
     * Saves a new idea to the database.
     */
    fun saveIdea(title: String, category: String, description: String) {
        viewModelScope.launch {
            repository.insert(IdeaEntity(title = title, category = category, description = description))
        }
    }
}

/**
 * Factory for creating an AddIdeaViewModel with a constructor that takes an Application.
 */
class AddIdeaViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddIdeaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddIdeaViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}