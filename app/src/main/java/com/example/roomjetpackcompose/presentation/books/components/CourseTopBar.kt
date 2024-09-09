package com.example.roomjetpackcompose.presentation.books.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

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