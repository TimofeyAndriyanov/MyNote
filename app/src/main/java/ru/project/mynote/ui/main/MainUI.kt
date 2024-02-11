package ru.project.mynote.ui.main

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.koin.java.KoinJavaComponent.get
import ru.project.mynote.domain.models.Note
import ru.project.mynote.domain.usecase.GetNotesAllUseCase

@Composable
fun Main(navController: NavController): Unit =
    Scaffold(
        floatingActionButton = {
            AddNoteButton {
                navController.navigate("addNote")
            }
        },
        floatingActionButtonPosition = FabPosition.End,

        topBar = {
            Toolbar()
        },
        content = {
            Column(
                modifier = Modifier.padding(it)
            ) {
                NoteList(list = get<GetNotesAllUseCase>(GetNotesAllUseCase::class.java).execute())
            }
        }
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(): Unit =
    TopAppBar(
        title = {
            Text(
                text = "Блокнот",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        }
    )

@Composable
private fun NoteList(list: List<Note>? = null): Unit =
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        list?.let {
            items(it) { note ->
                NoteTemplate(
                    note = note,
                    onClick = {
                        Toast.makeText(
                            get<Context>(Context::class.java).applicationContext,
                            note.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                )
            }
        }
    }

@Composable
private fun AddNoteButton(onClick: () -> Unit): Unit =
    FloatingActionButton(
        onClick = {
            onClick()
        }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Добавление заметки"
        )
    }