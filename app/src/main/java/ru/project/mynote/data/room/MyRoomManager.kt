package ru.project.mynote.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.project.mynote.data.dao.NoteDAO
import ru.project.mynote.domain.models.Note

@Database(
    entities = [
        Note::class
    ],
    version = 1
)
abstract class MyRoomManager: RoomDatabase() {
    abstract fun noteDAO(): NoteDAO
}