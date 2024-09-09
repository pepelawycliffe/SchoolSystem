package com.example.roomjetpackcompose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, 
            verticalArrangement = Arrangement.Center){
            Column  (modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Button(onClick = { navController.navigate(Routes.HomeScreen)},
                    Modifier.size(width = 280.dp,
                        height = 60.dp)){
                    Text(text = "Student")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column (modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Button(onClick = { navController.navigate(Routes.CoursesScreen)},
                    Modifier.size(width = 280.dp,
                        height = 60.dp)){
                    Text(text = "Course")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column (modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Button(onClick = {
                    navController.navigate(Routes.AmountScreen)
                                 },
                    Modifier.size(width = 280.dp,
                        height = 60.dp)){
                    Text(text = "Account")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column (modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Button(onClick = {
                    navController.navigate(Routes.LectureScreen)
                                 },
                    Modifier.size(width = 280.dp,
                        height = 60.dp)){
                    Text(text = "Lecture")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column (modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){
                Button(onClick = {
                    navController.navigate(Routes.FinanceScreen)
                                 },
                    Modifier.size(width = 280.dp,
                        height = 60.dp)){
                    Text(text = "Finance")
                }
            }
        }
    }
}