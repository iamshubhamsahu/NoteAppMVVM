package com.example.notesappmvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[Notes::class], version = 1)
abstract class NotesDatabase: RoomDatabase() {
    abstract fun notesDao() : NotesDao

    companion object{
        @Volatile
        private var INSTANCE : NotesDatabase? = null

        fun getDatabase(context: Context) : NotesDatabase{
            synchronized(this){


                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        NotesDatabase::class.java,
                        "notesDB"
                    ).build()
                }
                return INSTANCE!!

            }
        }

    }
}