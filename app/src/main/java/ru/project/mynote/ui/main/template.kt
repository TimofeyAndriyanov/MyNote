package ru.project.mynote.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.project.mynote.domain.models.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteTemplate(note: Note, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                start = 5.dp,
                top = 5.dp,
                end = 5.dp,
                bottom = 0.dp
            ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Название:",
                style = TextStyle(
                    fontSize = 9.sp,
                    color = Color.Black
                )
            )
            Text(
                text = note.title,
                style = TextStyle(
                    color = Color.Black
                )
            )
        }

        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Описание:",
                style = TextStyle(
                    fontSize = 9.sp,
                    color = Color.Black
                )
            )
            Text(
                text = note.description,
                style = TextStyle(
                    color = Color.Black
                )
            )
        }
    }
}