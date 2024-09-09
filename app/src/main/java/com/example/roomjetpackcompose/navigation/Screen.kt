package com.example.roomjetpackcompose.navigation

import com.example.roomjetpackcompose.core.Constants.Companion.COURSE_SCREEN
import com.example.roomjetpackcompose.core.Constants.Companion.STUDENT_SCREEN
import com.example.roomjetpackcompose.core.Constants.Companion.AMOUNT_SCREEN
import com.example.roomjetpackcompose.core.Constants.Companion.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    data object BooksScreen: Screen(STUDENT_SCREEN)
    data object CourseScreen: Screen(COURSE_SCREEN)
    data object AmountScreen: Screen(AMOUNT_SCREEN)
    data object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)

    fun withArgs(vararg args: Int) = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}