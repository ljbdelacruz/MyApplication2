// MainActivity.kt
package com.example.myapplication2.click_counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication2.click_counter.CounterViewModel
import com.example.myapplication2.ui.theme.MyApplication2Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject



@AndroidEntryPoint
class CounterActivity : ComponentActivity() {

    private val counterViewModel: CounterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen(counterViewModel)
                }
            }
        }
    }
}

@Composable
fun CounterScreen(viewModel: CounterViewModel) {
    val count = viewModel.count.observeAsState(0)
    Column {
        Text(text = "Count: ${count.value}")
        Button(onClick = { viewModel.increment() }) {
            Text(text = "Increment")
        }
        Button(onClick = { viewModel.decrement() }) {
            Text(text = "Decrement")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    MyApplication2Theme {
        CounterScreen(CounterViewModel())
    }
}