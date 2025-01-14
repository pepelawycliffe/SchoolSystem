package ro.alexmamo.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.job
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.ADD_BOOK
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.ADD_BUTTON
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.AUTHOR
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.BOOK_TITLE
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.DISMISS_BUTTON
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.EMPTY_STRING
import ro.alexmamo.roomjetpackcompose.domain.model.Book

@Composable
fun AddBookAlertDialog(
    showEmptyTitleMessage: () -> Unit,
    showEmptyAuthorMessage: () -> Unit,
    addBook: (book: Book) -> Unit,
    closeDialog: () -> Unit,
) {
    var title by remember { mutableStateOf(EMPTY_STRING) }
    var author by remember { mutableStateOf(EMPTY_STRING) }
    var studentId by remember { mutableStateOf(EMPTY_STRING) }
    var studentName by remember { mutableStateOf(EMPTY_STRING) }
    var course by remember { mutableStateOf(EMPTY_STRING) }
    val focusRequester = FocusRequester()

    AlertDialog(
        onDismissRequest = closeDialog,
        title = {
            Text(
                text = ADD_BOOK
            )
        },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { newTitle ->
                        title = newTitle
                    },
                    placeholder = {
                        Text(
                            text = BOOK_TITLE
                        )
                    },
                    modifier = Modifier.focusRequester(focusRequester)
                )
                LaunchedEffect(Unit) {
                    coroutineContext.job.invokeOnCompletion {
                        focusRequester.requestFocus()
                    }
                }
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                TextField(
                    value = author,
                    onValueChange = { newAuthor ->
                        author = newAuthor
                    },
                    placeholder = {
                        Text(
                            text = AUTHOR
                        )
                    }
                )
                TextField(
                    value = studentId,
                    onValueChange = { newStudentId ->
                        studentId = newStudentId
                    },
                    placeholder = {
                        Text(
                            text = AUTHOR
                        )
                    }
                )
                TextField(
                    value = studentName,
                    onValueChange = { newStudentName ->
                        studentName = newStudentName
                    },
                    placeholder = {
                        Text(
                            text = AUTHOR
                        )
                    }
                )
                TextField(
                    value = course,
                    onValueChange = { newCourse ->
                        course = newCourse
                    },
                    placeholder = {
                        Text(
                            text = AUTHOR
                        )
                    }
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (title.isEmpty()) {
                        showEmptyTitleMessage()
                        return@TextButton
                    }
                    if (author.isEmpty()) {
                        showEmptyAuthorMessage()
                        return@TextButton
                    }
                    if (studentId.isEmpty()) {
                        showEmptyAuthorMessage()
                        return@TextButton
                    }
                    if (studentName.isEmpty()) {
                        showEmptyAuthorMessage()
                        return@TextButton
                    }
                    if (course.isEmpty()) {
                        showEmptyAuthorMessage()
                        return@TextButton
                    }

                    addBook(Book(
                        id = 0,
                        title = title,
                        author = author,
                        studentId = studentId,
                        studentName = studentName,
                        course =course
                    ))
                    closeDialog()
                }
            ) {
                Text(
                    text = ADD_BUTTON
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = closeDialog
            ) {
                Text(
                    text = DISMISS_BUTTON
                )
            }
        }
    )
}