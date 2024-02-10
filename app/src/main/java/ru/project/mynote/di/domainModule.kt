package ru.project.mynote.di

import org.koin.dsl.module
import ru.project.mynote.data.room.MyRoomManager
import ru.project.mynote.domain.usecase.GetAddNoteUseCase
import ru.project.mynote.domain.usecase.GetDeleteUseCase
import ru.project.mynote.domain.usecase.GetNotesAllUseCase


val domainModule = module {
    single<GetNotesAllUseCase> {
        GetNotesAllUseCase(
            noteDAO = get<MyRoomManager>().noteDAO()
        )
    }

    single<GetAddNoteUseCase> {
        GetAddNoteUseCase(
            noteDAO = get<MyRoomManager>().noteDAO()
        )
    }

    single<GetDeleteUseCase> {
        GetDeleteUseCase(
            noteDAO = get<MyRoomManager>().noteDAO()
        )
    }
}