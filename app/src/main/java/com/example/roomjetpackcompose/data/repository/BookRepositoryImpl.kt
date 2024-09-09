package com.example.roomjetpackcompose.data.repository

import com.example.roomjetpackcompose.data.dao.BookDao
import com.example.roomjetpackcompose.domain.model.Book
import com.example.roomjetpackcompose.domain.repository.BookRepository

class BookRepositoryImpl(
    private val bookDao: BookDao
) : BookRepository {
    override fun getBooks() = bookDao.getBooks()

    override suspend fun getBookById(id: Int) = bookDao.getBookById(id)

    override suspend fun insertBook(book: Book) = bookDao.addBook(book)

    override suspend fun updateBook(book: Book) = bookDao.updateBook(book)

    override suspend fun deleteBook(book: Book) = bookDao.deleteBook(book)
}