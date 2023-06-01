package com.example.notetaking.repo

import com.example.notetaking.database.Notesdatabase
import com.example.notetaking.room.Note

class NoteRepository (private  val db:Notesdatabase){

   suspend fun insertNote(notes:Note)= db.getNoteDao().insertNote(notes)
   suspend fun deleteNote(notes: Note)=db.getNoteDao().deleteNote(notes)
   suspend fun updateNote(notes: Note)=db.getNoteDao().updateNote(notes)
   fun getAllNotes()=db.getNoteDao().getAllNotes()
   fun searchNotes(query:String?)=db.getNoteDao().searchNotes(query)

}