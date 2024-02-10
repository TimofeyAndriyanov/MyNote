package ru.project.mynote.data.dao

import androidx.room.*
import ru.project.mynote.domain.models.Note

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes")
    fun noteALL(): Array<Note>

    @Insert
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}