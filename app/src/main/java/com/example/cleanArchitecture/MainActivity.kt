package com.example.cleanArchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.cleanArchitecture.ui.theme.CleanArchiTheme
import com.example.domain.utils.NetworkService
import kotlinx.coroutines.flow.collectLatest
import org.koin.java.KoinJavaComponent.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NetworkMonitoring()
                }
            }
        }
    }
}

@Composable
fun NetworkMonitoring(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var amIOnline by remember {
        mutableStateOf("No i am not 😥")
    }
    val networkService: NetworkService by inject(NetworkService::class.java)
    val networkState = networkService.networkMonitoring()

    LaunchedEffect(key1 = context , block = {
        networkState.collectLatest {
            amIOnline = when(networkService.isNetworkAvailable()){
                true -> "Yes i am 😀"
                false -> "No i am not 😥"
            }
        }
    })

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = amIOnline,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchiTheme {
        NetworkMonitoring()
    }
}