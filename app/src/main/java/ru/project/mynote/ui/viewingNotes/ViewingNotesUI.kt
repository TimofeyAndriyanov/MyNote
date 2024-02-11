package ru.project.mynote.ui.viewingNotes

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ViewingNotes(navController: NavController): Unit =
    Scaffold(
        topBar = {
            ToolBar(
                title = "Заметка",
                onNavigationClick = {
                    navController.navigate("main")
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(it)
            ) {

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
