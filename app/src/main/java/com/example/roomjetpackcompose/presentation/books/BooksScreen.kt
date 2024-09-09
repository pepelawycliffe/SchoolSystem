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
import com.example.roomjetpackcompose.presentation.books.components.AddBookAlertDialog
import com.example.roomjetpackcompose.presentation.books.components.AddBookFloatingActionButton
import com.example.roomjetpackcompose.presentation.books.components.BooksContent
import com.example.roomjetpackcompose.presentation.books.components.BooksTopBar

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
}