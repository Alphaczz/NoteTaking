package com.example.notetaking.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notetaking.repo.NoteRepository
import com.example.notetaking.room.Note

class NoteViewModelFactory(val app: Application, private val NoteRepository: NoteRepository)
    :ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(app,NoteRepository) as T
    }



}