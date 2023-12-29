package com.febro.material3topppbartheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.febro.material3topppbartheme.ui.theme.Material3TopÁppBarThemeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3TopÁppBarThemeTheme(
                darkTheme = false,
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    // exp: https://youtu.be/EqCvUETekjk?t=703s
                    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

                    // container for components
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .nestedScroll(scrollBehavior.nestedScrollConnection),
                        topBar = {
                            // exp: https://youtu.be/EqCvUETekjk?t=900s
                            // for long text, text goes beneath ctas
                            // MediumTopAppBar

                            // centers the title
//                            CenterAlignedTopAppBar() {
//
//                            }
                            TopAppBar(
                                title = {
                                    Text(text = "My notes")
                                },
                                navigationIcon = {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowBack,
                                            contentDescription = "Go Back"
                                        )
                                    }
                                },

                                // up to three ctas. More than that, use a pop-up meu as the very far-right icon
                                actions = {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Mark as favorite")
                                    }
                                    
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit notes")
                                    }
                                },
                                scrollBehavior = scrollBehavior

                            )
                        },
                        

                    ) { values ->
                        LazyColumn(modifier = Modifier
                            .fillMaxSize()
                            .padding(values)) {
                            items(100) {
                                Text(text = "Item$it", modifier = Modifier.padding(16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Material3TopÁppBarThemeTheme {
        Greeting("Android")
    }
}