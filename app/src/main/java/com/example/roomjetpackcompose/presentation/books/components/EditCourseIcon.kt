package com.example.roomjetpackcompose.presentation.books.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import com.example.roomjetpackcompose.core.Constants.Companion.EDIT_BOOK

@Composable
fun EditCourseIcon(
    editCourse: () -> Unit
) {
    IconButton(
        onClick = editCourse
    ) {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = EDIT_BOOK,
        )
    }
}