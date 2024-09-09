package com.example.roomjetpackcompose.presentation.books.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.roomjetpackcompose.core.Constants.Companion.STUDENT_SCREEN

@Composable
fun BooksTopBar() {
    TopAppBar (
        title = {
            Text(
                text = STUDENT_SCREEN
            )
        }
    )
}