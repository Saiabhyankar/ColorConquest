package com.example.myapplication


import android.content.Context
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.compose.currentBackStackEntryAsState

var PageColor= mutableIntStateOf(0)
var Grid= mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
var Grid2= mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
val Grid3= mutableStateListOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
var ValColor= mutableStateListOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
var P1Score= mutableIntStateOf(0)
var P2Score= mutableIntStateOf(0)
var P3Score= mutableIntStateOf(0)
var P4Score= mutableIntStateOf(0)
var player1Name=mutableStateOf("")
var player2Name=mutableStateOf("")
var player3Name=mutableStateOf("")
var player4Name=mutableStateOf("")
var GridVal=mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
var P1Cnt= mutableIntStateOf(-1)
var P2Cnt= mutableIntStateOf(-1)
var P3Cnt= mutableIntStateOf(-1)
var P4Cnt= mutableIntStateOf(-1)
var Turn = mutableIntStateOf(0)
var DialogBox1= mutableStateOf(false)
var DialogBox2= mutableStateOf(false)
var name=""
var wScore=0
var tile= mutableIntStateOf(5)
var gameMode= mutableIntStateOf(0)
var matchNumber= mutableIntStateOf(1)
var P1Win= mutableStateOf(0)
var P2Win= mutableStateOf(0)
var isDarkTheme= mutableStateOf(false)
var isDarkTheme1= mutableStateOf(false)
var showDetail=mutableStateOf(false)
var showDetailT=mutableStateOf(false)
var hackerMode= mutableStateOf(0)
var TimerMode= mutableStateOf(false)
var ch =mutableIntStateOf(1)
var Multi= mutableStateOf(0)
var playerNum= mutableStateOf(2)
var nameMulti= mutableStateOf(0)
var norMode= mutableStateOf(0)
fun writeToSharedPref(context: Context, key: String, value: String,Filename:String) {

    val sharedPref: SharedPreferences = context.getSharedPreferences(Filename, Context.MODE_PRIVATE)

    val editor: SharedPreferences.Editor = sharedPref.edit()

    editor.putString(key, value)

    editor.apply()
}
fun readFromSharedPreferences(context: Context, key: String,Filename: String): String {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences(Filename, Context.MODE_PRIVATE)
    return sharedPreferences.getString(key,"").toString() }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            MyApplicationTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                        ,
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentScreen = navBackStackEntry?.destination?.route
                    NavHost(navController = navController, startDestination = "firstScreen") {
                        composable("firstscreen") {
                            PreviewPage {
                                navController.navigate("thirdscreen")
                            }
                        }
                        composable("secondscreen") {
                            PreviewPage2 {
                                if( !TimerMode.value && (hackerMode.value==1 || hackerMode.value==0) ){
                                    navController.navigate("fourthscreen")}
                                else if(!TimerMode.value && norMode.value==1){
                                    navController.navigate("fourthscreen")
                                }
                                else if(TimerMode.value){
                                    navController.navigate("fifthscreen")
                                }
                                else if(hackerMode.value==2){
                                    navController.navigate("sixthscreen")
                                }
                            }
                        }
                        composable("fourthscreen") {
                            PreviewPage3 {
                                navController.navigate("firstscreen")
                            }
                        }
                        composable("thirdscreen") {
                            GameMode {
                                navController.navigate("secondscreen")
                            }

                        }
                        composable("fifthscreen"){
                            TimerMode{
                                navController.navigate("firstscreen")
                            }
                        }
                        composable("sixthscreen"){
                            MultiPlayer{
                                navController.navigate("firstscreen")
                            }
                        }

                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .offset(-10.dp, 30.dp),
                        contentAlignment = Alignment.TopEnd){
                        CustomToggleButton(selected = isDarkTheme,
                            onChangeValue = {
                                isDarkTheme=it
                            })}
//                    AnimatedVisibility(
//                        visible = currentScreen == "firstscreen",
//                        enter = fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)),
//                        exit = fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700))
//                    ) {
//                        if (currentScreen == "firstscreen") PreviewPage(navigateToSecondPage= {
//                            navController.navigate("thirdscreen")
//                        })
//                    }
//
//                    AnimatedVisibility(
//                        visible = currentScreen == "thirdscreen",
//                        enter = fadeIn(animationSpec = tween(700)) + slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700)),
//                        exit = fadeOut(animationSpec = tween(700)) + slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700))
//                    ) {
//                        if (currentScreen == "thirdscreen") GameMode(navigateToGamePage =  {
//                            navController.navigate("secondscreen")
//                        })
//                    }

                }

            }

        }
    }
}




