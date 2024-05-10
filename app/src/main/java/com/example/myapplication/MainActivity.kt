package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

var buttonText = mutableStateOf(0)
var pageState = mutableIntStateOf(0)
var GameState = mutableIntStateOf(0)
var PageColor= mutableIntStateOf(0)
var Grid= mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
var Grid2= mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
val Grid3= mutableStateListOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
var ValColor= mutableIntStateOf(0)
var PlayerTurn= mutableIntStateOf(0)
var PlayerIndTurn = mutableStateListOf(0,0)
var player1Name=mutableStateOf("")
var player2Name=mutableStateOf("")
var GridVal=mutableStateListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
var P1Cnt= mutableIntStateOf(-1)
var P2Cnt= mutableIntStateOf(-1)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if(pageState.intValue==0){
                        VerticalGradient()
                        PreviewPage()
                    }
                    else if(pageState.intValue==1){
                        VerticalGradient()
                        PreviewPage2()
                    }
                    else if(pageState.intValue==2){
                        PreviewPage3()

                    }



                }
            }
        }
    }
}

