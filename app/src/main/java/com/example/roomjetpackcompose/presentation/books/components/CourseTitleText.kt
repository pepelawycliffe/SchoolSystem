package com.example.roomjetpackcompose.presentation.books.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CourseTitleText(
    courseTitle: String
) {
    Text(
        text = courseTitle,
        color = Color.DarkGray,
        fontSize = 25.sp
    )
}