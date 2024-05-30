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
var P1Win= 0
var P2Win= 0
var isDarkTheme= mutableStateOf(false)
var showDetail=mutableStateOf(false)
var hackerMode= mutableStateOf(0)
var TimerMode= mutableStateOf(false)
var ch =mutableIntStateOf(1)
var Multi= mutableStateOf(0)
var playerNum= mutableStateOf(2)
var nameMulti= mutableStateOf(0)
fun writeToSharedPref(context: Context, key: String, value: String,Filename:String) {
    // Obtain an instance of SharedPreferences
    val sharedPref: SharedPreferences = context.getSharedPreferences(Filename, Context.MODE_PRIVATE)
    // Get an editor to edit the SharedPreferences
    val editor: SharedPreferences.Editor = sharedPref.edit()
    // Put the value into SharedPreferences
    editor.putString(key, value)
    // Apply the changes
    editor.apply()
}
fun readFromSharedPreferences(context: Context, key: String,Filename: String): String {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences(Filename, Context.MODE_PRIVATE)
    return sharedPreferences.getString(key,"").toString() }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            MyApplicationTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                        ,
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
                        composable("fourthscreen") {
                            PreviewPage3 {
                                navController.navigate("firstscreen")
                            }
                        }
                        composable("thirdscreen") {
                            GameMode {
                                if(!TimerMode.value && hackerMode.value==1 ){
                                navController.navigate("fourthscreen")}
                                else if(TimerMode.value){
                                    navController.navigate("fifthscreen")
                                }
                                else if(hackerMode.value==2){
                                    navController.navigate("sixthscreen")
                                }
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
                }

            }

        }
    }
}




