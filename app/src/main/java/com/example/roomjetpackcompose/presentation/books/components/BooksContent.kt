package com.example.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.roomjetpackcompose.domain.model.Book
import com.example.roomjetpackcompose.domain.repository.Books

@Composable
fun BooksContent(
    padding: PaddingValues,
    books: Books,
//   courseEntity: CourseEntity,
    deleteBook: (book: Book) -> Unit,
    navigateToUpdateBookScreen: (id: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = books
        ) { book ->
            BookCard(
                book = book,
                deleteBook = {
                    deleteBook(book)
                },
                updateBook = {
                    navigateToUpdateBookScreen(book.id)
                }
            )
        }
    }
}