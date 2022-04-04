package com.example.notepad.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notepad.ui.theme.*
import java.lang.Exception

@Entity
data class Note (
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        // Colors to set for a note
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)