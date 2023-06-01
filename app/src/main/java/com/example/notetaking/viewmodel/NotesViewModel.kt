package com.example.notetaking.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetaking.repo.NoteRepository
import com.example.notetaking.room.Note
import kotlinx.coroutines.launch

class NotesViewModel(app:Application,private val NoteRepository: NoteRepository)
    :AndroidViewModel(app)
{
        fun addNotes(note: Note)=viewModelScope.launch {
            NoteRepository.insertNote(note)
        }
    fun deleteNotes(note: Note)=viewModelScope.launch {
        NoteRepository.deleteNote(note)
    }
    fun updateNotes(note: Note)=viewModelScope.launch {
        NoteRepository.updateNote(note)
    }
    fun getAllNotes()=NoteRepository.getAllNotes()

    fun searchNotes(query:String?)=  NoteRepository.searchNotes(query)


}