package com.example.notesappmvvm

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel

class MainViewModelFactory(private val notesRepository: NotesRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(notesRepository) as T
    }
}