package ru.project.mynote.domain.usecase

import ru.project.mynote.data.dao.NoteDAO
import ru.project.mynote.domain.models.Note

class GetNotesAllUseCase(private val noteDAO: NoteDAO) {

    fun execute(): List<Note> = noteDAO.noteALL().toList()

}