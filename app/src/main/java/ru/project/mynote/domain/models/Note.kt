package ru.project.mynote.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "notes"
)
data class Note(

    @PrimaryKey(
        autoGenerate = true
    ) val id: Int? = null,
    val title: String,
    val description: String
)
