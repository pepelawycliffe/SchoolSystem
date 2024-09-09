package com.example.roomjetpackcompose.presentation.books

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomjetpackcompose.core.Constants.Companion.EMPTY_AUTHOR_MESSAGE
import com.example.roomjetpackcompose.core.Constants.Companion.EMPTY_TITLE_MESSAGE
import com.example.roomjetpackcompose.core.toastMessage
import com.example.roomjetpackcompose.presentation.books.components.AddBookFloatingActionButton
import com.example.roomjetpackcompose.presentation.books.components.AddCourseAlertDialog
import com.example.roomjetpackcompose.presentation.books.components.CourseContent
import com.example.roomjetpackcompose.presentation.books.components.CourseTopBar

@Composable
fun CourseScreen(
//    viewModel: BooksViewModel = hiltViewModel(),

    viewModel: CourseViewModel = hiltViewModel(),
    navigateToUpdateCourseScreen: (id: Int) -> Unit
) {
    val context = LocalContext.current
//    var openAddBookDialog by remember { mutableStateOf(false) }
    var openAddCourseDialog by remember { mutableStateOf(false) }
    val courseEntitys by viewModel.courseEntitys.collectAsState(
        initial = emptyList()
    )


    Scaffold(
        topBar = {
            CourseTopBar()
        },
        content = { padding ->
            CourseContent(
                padding = padding,
                courseEntitys = courseEntitys,
                deleteCourse = { courseEntity ->
                    viewModel.deleteCourse(courseEntity)
                },
                navigateToUpdateCourseScreen = navigateToUpdateCourseScreen
            )
        },
        floatingActionButton = {
            AddBookFloatingActionButton(
                openDialog = {
                    openAddCourseDialog = true
                }
            )

        }
    )

    if (openAddCourseDialog) {
        AddCourseAlertDialog(
            showEmptyTitleMessage = {
                toastMessage(context, EMPTY_TITLE_MESSAGE)
            },
            showEmptyAuthorMessage = {
                toastMessage(context, EMPTY_AUTHOR_MESSAGE)
            },
            addCourse = { courseEntity ->
                viewModel.addCourse(courseEntity)
            },

            closeDialog = {
                openAddCourseDialog = false
            }
        )

    }}