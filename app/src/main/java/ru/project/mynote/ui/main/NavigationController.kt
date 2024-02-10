package ru.project.mynote.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import ru.project.mynote.ui.addNote.AddNote

@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
@Composable
fun ApplicationNavigation() {
    val remember = rememberNavController()

    NavHost(navController = remember, startDestination = "main") {
        composable(route = "main") {
            Main(navController = remember)
        }

        composable(route = "addNote") {
            AddNote(navController = remember)
        }
    }
}