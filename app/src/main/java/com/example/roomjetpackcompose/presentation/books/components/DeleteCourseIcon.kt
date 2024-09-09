package com.example.roomjetpackcompose.presentation.books.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.example.roomjetpackcompose.core.Constants.Companion.DELETE_BOOK

@Composable
fun DeleteCourseIcon(
    deleteCourse: () -> Unit
) {
    IconButton(
        onClick = deleteCourse
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_BOOK,
        )
    }
}