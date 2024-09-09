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
import com.example.roomjetpackcompose.domain.model.CourseEntity


@Composable
fun UpdateCourseContent(
    padding: PaddingValues,
    courseEntity: CourseEntity,
    showEmptyTitleMessage: () -> Unit,
    showEmptyAuthorMessage: () -> Unit,
    updateCourseUnitId: (unitId: String) -> Unit,
    updateCourseUnitName: (unitName: String) -> Unit,
    updateCourseLecture: (lecture: String) -> Unit,
    updateCourse: () -> Unit,
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
            value = courseEntity.unitId,
            onValueChange = { newUnitId ->
                updateCourseUnitId(newUnitId)
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
            value = courseEntity.unitName,
            onValueChange = { newUnitName ->
                updateCourseUnitName(newUnitName)
            },
            placeholder = {
                Text(
                    text = AUTHOR
                )
            }
        )
        TextField(
            value = courseEntity.lecture,
            onValueChange = { newLecture ->
                updateCourseLecture(newLecture)
            },
            placeholder = {
                Text(
                    text = AUTHOR
                )
            }
        )
//        TextField(
//            value = book.studentName,
//            onValueChange = { newStudentName ->
//                updateBookStudentName(newStudentName)
//            },
//            placeholder = {
//                Text(
//                    text = AUTHOR
//                )
//            }
//        )
//        TextField(
//            value = book.course,
//            onValueChange = { newCourse ->
//                updateBookCourse(newCourse)
//            },
//            placeholder = {
//                Text(
//                    text = AUTHOR
//                )
//            }
//        )

        Button(
            onClick = {
                if (courseEntity.unitId.isEmpty()) {
                    showEmptyTitleMessage()
                    return@Button
                }
                if (courseEntity.unitName.isEmpty()) {
                    showEmptyAuthorMessage()
                    return@Button
                }
                if  (courseEntity.lecture.isEmpty()) {
                    showEmptyAuthorMessage()
                    return@Button
                }
//                if  (book.studentName.isEmpty()) {
//                    showEmptyAuthorMessage()
//                    return@Button
//                }
//                if  (book.course.isEmpty()) {
//                    showEmptyAuthorMessage()
//                    return@Button
//                }
                updateCourse()
                navigateBack()
            }
        ) {
            Text(
                text = UPDATE_BUTTON
            )
        }
    }
}