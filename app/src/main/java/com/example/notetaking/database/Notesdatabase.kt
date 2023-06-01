package com.example.notetaking.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notetaking.room.Note

@Database(entities = [Note::class], version = 1)
abstract class Notesdatabase:RoomDatabase()
{
    abstract fun getNoteDao():Dao
    companion object{
        @Volatile
        private var instance:Notesdatabase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance?:
        synchronized(LOCK)
        {
            instance?:
            createDatabase(context).also{
                instance=it
            }
        }

        private fun createDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,Notesdatabase::class.java,
            "note_db"
        ).build()

    }






}