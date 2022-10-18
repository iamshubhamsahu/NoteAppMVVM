package com.example.notesappmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class MainViewModel(private val notesRepository: NotesRepository) : ViewModel() {

    fun getNotes(): LiveData<List<Notes>>{
        return notesRepository.getNotes()

    }

    fun insertNotes(notes: Notes){
        viewModelScope.launch(Dispatchers.IO){

            notesRepository.insertNotes(notes)
        }
    }
}