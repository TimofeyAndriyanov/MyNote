package ru.project.mynote.domain.usecase

import ru.project.mynote.data.dao.NoteDAO
import ru.project.mynote.domain.models.Note

class GetAddNoteUseCase(private val noteDAO: NoteDAO) {

    fun execute(note: Note): Unit = noteDAO.addNote(note)
}