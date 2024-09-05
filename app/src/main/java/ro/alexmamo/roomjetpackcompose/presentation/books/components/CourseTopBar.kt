package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.STUDENT_SCREEN

@Composable
fun CourseTopBar() {
    TopAppBar (
        title = {
            Text(
                text ="Course "
            )
        }
    )
}