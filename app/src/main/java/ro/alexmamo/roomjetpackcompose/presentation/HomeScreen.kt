package ro.alexmamo.roomjetpackcompose.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ro.alexmamo.roomjetpackcompose.navigation.NavGraph

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