package com.example.myapplication


import android.app.Dialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

var pageState = mutableIntStateOf(0)
var PageColor= mutableIntStateOf(0)
var Grid= mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
var Grid2= mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
val Grid3= mutableStateListOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
var ValColor= mutableStateListOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
var P1Score= mutableIntStateOf(0)
var P2Score= mutableIntStateOf(0)
var player1Name=mutableStateOf("")
var player2Name=mutableStateOf("")
var GridVal=mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
var P1Cnt= mutableIntStateOf(-1)
var P2Cnt= mutableIntStateOf(-1)
var Turn = mutableIntStateOf(0)
var DialogBox1= mutableStateOf(false)
var DialogBox2= mutableStateOf(false)
var DialogBox3= mutableStateOf(false)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "firstScreen") {
                        composable("firstscreen") {
                            PreviewPage {
                                navController.navigate("secondscreen")
                            }
                        }
                        composable("secondscreen") {
                            PreviewPage2 {
                                navController.navigate(("thirdscreen"))
                            }
                        }
                        composable("thirdscreen") {
                            PreviewPage3 {
                                navController.navigate("firstscreen")
                            }
                        }
                    }

                }


            }
        }
    }
}





