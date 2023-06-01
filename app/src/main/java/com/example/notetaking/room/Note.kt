package com.example.notetaking.room

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

@Entity(tableName="notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    val  id:Int ,
    val noteTitle:String,
    val noteBody:String
):Parcelable
