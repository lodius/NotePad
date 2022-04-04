package com.example.notepad.feature_note.domain.repository

import com.example.notepad.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    // NoteDao interface
    fun getNotes(): Flow<List<Note>>
    suspend fun getNotesById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}