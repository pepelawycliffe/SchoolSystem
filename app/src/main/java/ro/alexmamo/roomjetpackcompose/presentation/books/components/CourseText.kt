package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


@Composable
fun CourseText(
    courseAuthor: String
) {
    Text(
        text = "by $courseAuthor",
        color = Color.DarkGray,
        fontSize = 12.sp,
        textDecoration = TextDecoration.Underline
    )
}
