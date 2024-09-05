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
import ro.alexmamo.roomjetpackcompose.domain.model.CourseEntity


@Composable
fun AddCourseAlertDialog(
    showEmptyTitleMessage: () -> Unit,
    showEmptyAuthorMessage: () -> Unit,
    addCourse: (courseEntity:CourseEntity) -> Unit,
    closeDialog: () -> Unit,
) {

//    val id: Int,
//    val unitId:String,
//    val unitName:String,
//    val lecture:String

//    var title by remember { mutableStateOf(EMPTY_STRING) }
//    var author by remember { mutableStateOf(EMPTY_STRING) }
    var unitId by remember { mutableStateOf(EMPTY_STRING) }
    var unitName by remember { mutableStateOf(EMPTY_STRING) }
    var lecture by remember { mutableStateOf(EMPTY_STRING) }
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
                    value = unitId,
                    onValueChange = { newUnitId ->
                        unitId = newUnitId
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
                    value = unitName,
                    onValueChange = { newUnitName  ->
                        unitName = newUnitName
                    },
                    placeholder = {
                        Text(
                            text = "unitName"
                        )
                    }
                )
                TextField(
                    value = lecture,
                    onValueChange = { newLecture ->
                       lecture= newLecture
                    },
                    placeholder = {
                        Text(
                            text = AUTHOR
                        )
                    }
                )
//                TextField(
//                    value = studentName,
//                    onValueChange = { newStudentName ->
//                        studentName = newStudentName
//                    },
//                    placeholder = {
//                        Text(
//                            text = AUTHOR
//                        )
//                    }
//                )
//                TextField(
//                    value = course,
//                    onValueChange = { newCourse ->
//                        course = newCourse
//                    },
//                    placeholder = {
//                        Text(
//                            text = AUTHOR
//                        )
//                    }
//                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (unitId.isEmpty()) {
                        showEmptyTitleMessage()
                        return@TextButton
                    }
                    if (unitName.isEmpty()) {
                        showEmptyAuthorMessage()
                        return@TextButton
                    }
                    if (lecture.isEmpty()) {
                        showEmptyAuthorMessage()
                        return@TextButton
                    }
//                    if (studentName.isEmpty()) {
//                        showEmptyAuthorMessage()
//                        return@TextButton
//                    }
//                    if (course.isEmpty()) {
//                        showEmptyAuthorMessage()
//                        return@TextButton
//                    }

                    addCourse(
                        CourseEntity(
                        id = 0,
                        unitId= unitId,
                        unitName = unitName,
                        lecture= lecture,
//                        studentName = studentName,
//                        course =course
                    )
                    )
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