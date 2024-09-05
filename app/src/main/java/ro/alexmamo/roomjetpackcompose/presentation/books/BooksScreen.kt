package ro.alexmamo.roomjetpackcompose.presentation.books

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.EMPTY_AUTHOR_MESSAGE
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.EMPTY_TITLE_MESSAGE
import ro.alexmamo.roomjetpackcompose.core.toastMessage
import ro.alexmamo.roomjetpackcompose.presentation.books.components.AddBookAlertDialog
import ro.alexmamo.roomjetpackcompose.presentation.books.components.AddBookFloatingActionButton
import ro.alexmamo.roomjetpackcompose.presentation.books.components.AddCourseAlertDialog
import ro.alexmamo.roomjetpackcompose.presentation.books.components.BooksContent
import ro.alexmamo.roomjetpackcompose.presentation.books.components.BooksTopBar

@Composable
fun BooksScreen(
//    navController: NavHostController,
    viewModel: BooksViewModel = hiltViewModel(),
    navigateToUpdateBookScreen: (id: Int) -> Unit
) {
    val context = LocalContext.current
    var openAddBookDialog by remember { mutableStateOf(false) }
    var openAddCourseDialog by remember { mutableStateOf(false) }
    val books by viewModel.books.collectAsState(
        initial = emptyList()
    )


    Scaffold(
        topBar = {
            BooksTopBar()
        },
        content = { padding ->
            BooksContent(
                padding = padding,
                books = books,
                deleteBook = { book ->
                    viewModel.deleteBook(book)
                },
                navigateToUpdateBookScreen = navigateToUpdateBookScreen
            )
        },

        floatingActionButton = {
            AddBookFloatingActionButton(
                openDialog = {
                    openAddBookDialog = true
                    
                }
            )

            
        }


        
    )


    

    if (openAddBookDialog) {
        AddBookAlertDialog(
            showEmptyTitleMessage = {
                toastMessage(context, EMPTY_TITLE_MESSAGE)
            },
            showEmptyAuthorMessage = {
                toastMessage(context, EMPTY_AUTHOR_MESSAGE)
            },
            addBook = { book ->
                viewModel.addBook(book)
            },

            closeDialog = {
                openAddBookDialog = false
            }
        )

    }
//    if (openAddCourseDialog) {
//        AddCourseAlertDialog(
//            showEmptyTitleMessage = {
//                toastMessage(context, EMPTY_TITLE_MESSAGE)
//            },
//            showEmptyAuthorMessage = {
//                toastMessage(context, EMPTY_AUTHOR_MESSAGE)
//            },
//            addCourse = { courseEntity ->
//                viewModel.addCourse(courseEntity)
//            },
//
//            closeDialog = {
//                openAddCourseDialog = false
//            }
//        )
//
//    }
}