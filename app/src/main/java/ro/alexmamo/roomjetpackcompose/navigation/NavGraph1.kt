package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.ID
import ro.alexmamo.roomjetpackcompose.navigation.Screen.BooksScreen
import ro.alexmamo.roomjetpackcompose.navigation.Screen.UpdateBookScreen
import ro.alexmamo.roomjetpackcompose.presentation.books.BooksScreen
import ro.alexmamo.roomjetpackcompose.presentation.books.CourseScreen
import ro.alexmamo.roomjetpackcompose.presentation.update_book.UpdateBookScreen
import ro.alexmamo.roomjetpackcompose.presentation.update_book.UpdateCourseScreen


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