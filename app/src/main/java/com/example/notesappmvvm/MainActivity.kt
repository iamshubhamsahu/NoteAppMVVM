package com.example.notesappmvvm

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notesappmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val notesDao = NotesDatabase.getDatabase(applicationContext).notesDao()
        val notesRepository = NotesRepository(notesDao)
        val mainViewModel = ViewModelProvider(this, MainViewModelFactory(notesRepository)).get(MainViewModel::class.java)

        mainViewModel.getNotes().observe(this,{
            binding.textView.text = it.toString()
        })

        binding.button.setOnClickListener{
            if (binding.textET.text!!.isEmpty()){
                binding.textET.error = "Empty"

            }else{
                mainViewModel.insertNotes(Notes(0,binding.textET.text.toString()))
                Toast.makeText(this,"Done", Toast.LENGTH_SHORT).show()
                binding.textET.text = null

            }
        }

    }
}