package com.example.notetaking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notetaking.database.Notesdatabase
import com.example.notetaking.databinding.ActivityMainBinding
import com.example.notetaking.repo.NoteRepository
import com.example.notetaking.viewmodel.NoteViewModelFactory
import com.example.notetaking.viewmodel.NotesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var notesViewModel: NotesViewModel
    lateinit var binding:com.example.notetaking.databinding.ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()


    }

    private fun setUpViewModel() {
        val noteRepository=NoteRepository(Notesdatabase(this))
        val viewModelProviderFactory=NoteViewModelFactory(application,noteRepository)
        notesViewModel=ViewModelProvider(this,viewModelProviderFactory).get(NotesViewModel::class.java)

    }
}