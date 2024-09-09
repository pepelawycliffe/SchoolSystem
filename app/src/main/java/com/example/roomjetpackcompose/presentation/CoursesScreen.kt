package com.example.roomjetpackcompose.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.roomjetpackcompose.navigation.NavGraph1

@Composable
fun CoursesScreen(navController: NavController){
    Column(modifier = Modifier) {
        Column {
            NavGraph1(
                navController = rememberNavController()
            )
        }
    }
}