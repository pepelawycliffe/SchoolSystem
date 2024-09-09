package com.example.roomjetpackcompose.presentation.update_book.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomjetpackcompose.core.Constants.Companion.AUTHOR
import com.example.roomjetpackcompose.core.Constants.Companion.BOOK_TITLE
import com.example.roomjetpackcompose.core.Constants.Companion.UPDATE_BUTTON
import com.example.roomjetpackcompose.domain.model.Book

@Composable
fun UpdateBookContent(
    padding: PaddingValues,
    book: Book,
    showEmptyTitleMessage: () -> Unit,
    updateBookTitle: (title: String) -> Unit,
    showEmptyAuthorMessage: () -> Unit,
    updateBookAuthor: (author: String) -> Unit,
    updateBookStudentId: (studentId: String) -> Unit,
    updateBookStudentName: (studentName: String) -> Unit,
    updateBookCourse: (course: String) -> Unit,
    updateBook: () -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = book.title,
            onValueChange = { newTitle ->
                updateBookTitle(newTitle)
            },
            placeholder = {
                Text(
                    text = BOOK_TITLE
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = book.author,
            onValueChange = { newAuthor ->
                updateBookAuthor(newAuthor)
            },
            placeholder = {
                Text(
                    text = AUTHOR
                )
            }
        )
        TextField(
            value = book.studentId,
            onValueChange = { newStudentId ->
                updateBookStudentId(newStudentId)
            },
            placeholder = {
                Text(
                    text = AUTHOR
                )
            }
        )
        TextField(
            value = book.studentName,
            onValueChange = { newStudentName ->
                updateBookStudentName(newStudentName)
            },
            placeholder = {
                Text(
                    text = AUTHOR
                )
            }
        )
        TextField(
            value = book.course,
            onValueChange = { newCourse ->
                updateBookCourse(newCourse)
            },
            placeholder = {
                Text(
                    text = AUTHOR
                )
            }
        )

        Button(
            onClick = {
                if (book.title.isEmpty()) {
                    showEmptyTitleMessage()
                    return@Button
                }
                if (book.author.isEmpty()) {
                    showEmptyAuthorMessage()
                    return@Button
                }
                if  (book.studentId.isEmpty()) {
                    showEmptyAuthorMessage()
                    return@Button
                }
                if  (book.studentName.isEmpty()) {
                    showEmptyAuthorMessage()
                    return@Button
                }
                if  (book.course.isEmpty()) {
                    showEmptyAuthorMessage()
                    return@Button
                }
                updateBook()
                navigateBack()
            }
        ) {
            Text(
                text = UPDATE_BUTTON
            )
        }
    }
}