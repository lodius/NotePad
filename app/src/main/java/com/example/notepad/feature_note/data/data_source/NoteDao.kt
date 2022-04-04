package com.example.notepad.feature_note.data.data_source

import androidx.room.*
import com.example.notepad.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    /**
     * Returns Flow so no need to suspend.
     * In coroutines, a flow is a type that can emit multiple values sequentially,
     * as opposed to suspend functions that return only a single value.
     * For example, you can use a flow to receive live updates from a database.
     *
     * Flows are built on top of coroutines and can provide multiple values.
     * A flow is conceptually a stream of data that can be computed asynchronously.
     * The emitted values must be of the same type.
     * For example,a Flow<Int> is a flow that emits integer values.
     *
     * A flow is very similar to an Iterator that produces a sequence of values,
     * but it uses suspend functions to produce and consume values asynchronously.
     * This means, for example, that the flow can safely make a network request to produce
     * the next value without blocking the main thread.
     * */
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}