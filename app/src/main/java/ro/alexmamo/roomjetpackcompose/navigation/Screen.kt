package ro.alexmamo.roomjetpackcompose.navigation

import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.COURSE_SCREEN
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.STUDENT_SCREEN
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    data object BooksScreen: Screen(STUDENT_SCREEN)
    data object CourseScreen: Screen(COURSE_SCREEN)
    data object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)

    fun withArgs(vararg args: Int) = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}