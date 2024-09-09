package com.example.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.roomjetpackcompose.core.Constants.Companion.ID
import com.example.roomjetpackcompose.navigation.Screen.BooksScreen
import com.example.roomjetpackcompose.navigation.Screen.UpdateBookScreen
import com.example.roomjetpackcompose.presentation.books.CourseScreen
import com.example.roomjetpackcompose.presentation.update_book.UpdateCourseScreen


@Composable
fun NavGraph1 (
    navController: NavHostController
) {

//    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BooksScreen.route
    ) {
        composable(
            route = BooksScreen.route
        ) {
            CourseScreen(
                navigateToUpdateCourseScreen = { id ->
                    navController.navigate(
                        route = UpdateBookScreen.withArgs(id)

                    )
                }

            )


        }
//        composable("course") { CourseScreen{} }
        composable(
            route = "${UpdateBookScreen.route}/{$ID}",
            arguments = listOf(
                navArgument(ID) {
                    type = IntType
                }
            )
        ) { entry ->
            UpdateCourseScreen(
                id = entry.arguments?.getInt(ID) ?: 0,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}