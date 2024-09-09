package com.example.roomjetpackcompose.presentation.update_book

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomjetpackcompose.core.Constants.Companion.EMPTY_AUTHOR_MESSAGE
import com.example.roomjetpackcompose.core.Constants.Companion.EMPTY_TITLE_MESSAGE
import com.example.roomjetpackcompose.core.toastMessage
import com.example.roomjetpackcompose.presentation.update_book.components.UpdateCourseContent
import com.example.roomjetpackcompose.presentation.update_book.components.UpdateCourseTopBar


@Composable
fun UpdateCourseScreen(
    viewModel: UpdateCourseViewModel = hiltViewModel(),
    id: Int,
    navigateBack: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(id) {
        viewModel.getCourseById(id)
    }

    Scaffold(
        topBar = {
            UpdateCourseTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateCourseContent(
                padding = padding,
                courseEntity = viewModel.course,
                showEmptyTitleMessage = {
                    toastMessage(context, EMPTY_TITLE_MESSAGE)
                },
                updateCourseUnitId = { unitId ->
                    viewModel.updateCourseUnitId(unitId)
                },
                showEmptyAuthorMessage = {
                    toastMessage(context, EMPTY_AUTHOR_MESSAGE)
                },
                updateCourseUnitName = { unitName ->
                    viewModel.updateCourseUnitName(unitName)
                },

                updateCourseLecture = { lecture->
                    viewModel.updateCourseLecture(lecture)
                },
//                updateBookStudentName = { studentName ->
//                    viewModel.updateBookStudentName(studentName)
//                },
//                updateBookCourse = { course ->
//                    viewModel.updateBookCourse(course)
//                },
                updateCourse = {
                    viewModel.updateCourse()
                },
                navigateBack = navigateBack
            )
        }
    )
}