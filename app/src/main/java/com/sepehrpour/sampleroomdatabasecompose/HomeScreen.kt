package com.sepehrpour.sampleroomdatabasecompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController



@Composable
//fun HomeScreen(navController: NavHostController) {
//
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        Text(text = "Main Screen", style = MaterialTheme.typography.titleLarge)
//    }
//}
fun HomeScreen(
    navController: NavHostController,
    counterViewModel: CounterViewModel = hiltViewModel()
) {
    val counterValue by counterViewModel.counter.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter: ${counterValue?.value ?: 0}",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row {
            Button(
                onClick = { counterViewModel.increaseCounter() },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "افزایش")
            }

            Button(
                onClick = { counterViewModel.decreaseCounter() },
                enabled = (counterValue?.value ?: 0) > 0,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "کاهش")
            }
        }
    }
}