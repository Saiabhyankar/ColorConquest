package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.fontFamily

@Composable
fun GameMode(navigateToGamePage:()->Unit){
    val gradient = Brush.verticalGradient(
        0.0f to Color(254,194,113,255),
        1.0f to Color(254,99,109,255),
        startY = 0.0f,
        endY = 1500.0f
    )
    Box(modifier = Modifier.background(gradient))
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        Box(

        ){
            Text("Game Modes",
                modifier = Modifier.padding(16.dp),
                fontSize = 24.sp,
                color = Color.Black,
               fontFamily = FontFamily.Serif
            )
        }
    }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){



        Button(onClick = {navigateToGamePage()
                         tile.value=5
                         matchNumber.value=1
                         },
            //colors = ButtonDefaults.buttonColors(containerColor = Color())

            ){
            Text("Normal Mode")
        }
        Button(onClick = {
            gameMode.value=1
        }){
            Text("Hacker Mode")
        }
        Button(onClick = {navigateToGamePage()}){
            Text("Hacker ++ Mode")
        }
        if(gameMode.value==1){
            AlertDialog(onDismissRequest = { gameMode.value=0 }, confirmButton = { /*TODO*/ },
                modifier = Modifier
                    .size(height=300.dp, width = 400.dp),
                text={
                    Column {
                        Text("Grid Size Choice")
                        Spacer(modifier = Modifier
                            .padding(10.dp))
                        Row(){
                            Button(onClick = {
                                matchNumber.value=-1
                                tile.value=2
                            gameMode.value=0}){
                                Text("2*2")
                            }
                            Spacer(modifier = Modifier
                                .padding(10.dp))
                            Button(onClick = {
                                matchNumber.value=-1
                                tile.value=3
                                gameMode.value=0}){
                                Text("3*3")
                            }
                            Spacer(modifier = Modifier
                                .padding(10.dp))
                            Button(onClick = {
                                matchNumber.value=-1
                                tile.value=4
                                gameMode.value=0}){
                                Text("4*4")
                            }

                        }
                        Spacer(modifier = Modifier
                            .padding(10.dp))
                        Button(onClick = {
                            matchNumber.value=-1
                            tile.value=5
                            gameMode.value=0}){
                            Text("5*5")
                        }


                    }


                })
        }
        if(matchNumber.value==-1){
            AlertDialog(onDismissRequest = { matchNumber.value=0 }, confirmButton = { /*TODO*/ },
                text={
                    Column(){
                        Text("Series of Matches You Want to play ")
                        Spacer(modifier = Modifier
                            .padding(10.dp))
                        Row(

                        ){

                            Button(onClick = { navigateToGamePage()
                                matchNumber.value=1}) {
                                Text("1")
                            }
                            Spacer(modifier = Modifier
                                .padding(20.dp))
                            Button(onClick = { navigateToGamePage()
                                matchNumber.value=3}) {
                                Text("3")
                            }
                            Spacer(modifier = Modifier
                                .padding(20.dp))
                            Button(onClick = { navigateToGamePage()
                                matchNumber.value=5}) {
                                Text("5")
                            }
                        }
                    }

                })
        }
    }
}