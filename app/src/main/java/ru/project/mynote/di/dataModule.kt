package ru.project.mynote.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.dsl.module
import ru.project.mynote.data.room.MyRoomManager


val dataModule = module {
    single<MyRoomManager> {
        Room.databaseBuilder(
            context = get<Context>(),
            klass = MyRoomManager::class.java,
            name = "database"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}