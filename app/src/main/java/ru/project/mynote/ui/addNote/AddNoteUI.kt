package ru.project.mynote.ui.addNote

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import org.koin.java.KoinJavaComponent.get
import ru.project.mynote.domain.models.Note
import ru.project.mynote.domain.usecase.GetAddNoteUseCase

@Composable
fun AddNote(navController: NavController): Unit =
    Scaffold(
        topBar = {
            ToolBar(
                title = "Добавить заметку",
                onNavigationClick = {
                    navController.navigate("main")
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(
                        start = 0.dp,
                        top = 150.dp,
                        end = 0.dp,
                        bottom = 0.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val addNote = get<GetAddNoteUseCase>(GetAddNoteUseCase::class.java)

                val title = inputTitle()
                val description = inputDescription()

                val note = Note(
                    title = title,
                    description = description
                )

                AddButton {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        addNote.execute(note)
                        navController.navigate("main")
                    } else {
                        Toast.makeText(
                            get<Context>(Context::class.java).applicationContext,
                            "Поля ввода пустые",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar(
    title: String,
    onNavigationClick: () -> Unit
): Unit =
    TopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onNavigationClick,
                content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Вернутся обратно на главный экран",
                        modifier = Modifier
                            .height(34.dp)
                            .width(34.dp)
                            .padding(
                                start = 0.dp,
                                top = 0.dp,
                                end = 0.dp,
                                bottom = 0.dp
                            ),
                    )
                }
            )

        }
    )

@Composable
private fun inputTitle(): String {
    val text = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .defaultMinSize(minHeight = 70.dp)
            .fillMaxWidth()
            .padding(
                start = 30.dp,
                top = 10.dp,
                end = 30.dp,
                bottom = 0.dp
            ),
        textStyle = TextStyle(
            fontSize = 20.sp
        ),
        label = {
            Text(
                text = "Название:"
            )
        },
        shape = RoundedCornerShape(15.dp)
    )
    return text.value
}

@Composable
private fun inputDescription(): String {
    val text = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .defaultMinSize(minHeight = 70.dp)
            .fillMaxWidth()
            .padding(
                start = 30.dp,
                top = 10.dp,
                end = 30.dp,
                bottom = 0.dp
            ),
        textStyle = TextStyle(
            fontSize = 20.sp
        ),
        label = {
            Text(
                text = "Описание:"
            )
        },
        shape = RoundedCornerShape(15.dp)
    )
    return text.value
}

@Composable
private fun AddButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(
                start = 30.dp,
                top = 10.dp,
                end = 30.dp,
                bottom = 0.dp
            )
            .fillMaxWidth()
            .defaultMinSize(
                minHeight = 70.dp
            ),
        onClick = onClick,
        content = {
            Text(
                text = "Добавить",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        },
        shape = RoundedCornerShape(15.dp)
    )
}