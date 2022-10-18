package com.example.notesappmvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {

    @Insert
    suspend fun insertNote(notes: Notes)

    @Delete
    suspend fun deleteNotes(note: Notes)

    @Query("SELECT * FROM notes")
    fun getNotes():LiveData<List<Notes>>



}