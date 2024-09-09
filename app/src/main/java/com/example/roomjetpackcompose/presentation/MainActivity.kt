package com.example.roomjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.WelcomeScreen, builder = {
                composable("Welcome_A"){
                    WelcomeScreen(navController)
                }
                composable(Routes.HomeScreen){
//                    HomeScreen(navController)
                    HomeScreen(navController = navController)
                }
                composable(Routes.CoursesScreen){
//                    HomeScreen(navController)
                    CoursesScreen(navController = navController)


                }
                composable(Routes.AmountScreen){
//                    HomeScreen(navController)
                    AmountScreen(navController = navController)


                }
                composable(Routes.LectureScreen){
//                    HomeScreen(navController)
                    LecturesScreen(navController = navController)


                }
                composable(Routes.FinanceScreen){
//                    HomeScreen(navController)
                    FinancesScreen(navController = navController)


                }
//                composable(Routes.todoViewModel){
//                    todoViewModel(navController)

//                }
//                TodoListPage(todoViewModel)
            })
//            T


//            NavGraph(
//                navController = rememberNavController()
//            )
        }
    }
}