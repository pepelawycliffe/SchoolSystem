package com.example.roomjetpackcompose.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.roomjetpackcompose.navigation.NavGraph

@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier) {
        Column {
            NavGraph(
                navController = rememberNavController()
            )
        }
    }
}