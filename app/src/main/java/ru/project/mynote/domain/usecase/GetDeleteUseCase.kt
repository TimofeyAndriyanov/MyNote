package ru.project.mynote.domain.usecase

import ru.project.mynote.data.dao.NoteDAO
import ru.project.mynote.domain.models.Note

class GetDeleteUseCase(private val noteDAO: NoteDAO) {

    fun execute(note: Note): Unit = noteDAO.deleteNote(note)
}