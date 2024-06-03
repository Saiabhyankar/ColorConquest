package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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



        Button(onClick = {
            tile.value=5
            matchNumber.value=1
            hackerMode.value=0
            TimerMode.value=false
            navigateToGamePage()
                         },


            ){
            Text("Normal Mode")
        }
        Button(onClick = {
            gameMode.value=1
            hackerMode.value=0
        }){
            Text("Hacker Mode")
        }
        Button(onClick = {
        hackerMode.value=3
          tile. value=5}){
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
                                gameMode.value=0
                                TimerMode.value=false}){
                                Text("2*2")
                            }
                            Spacer(modifier = Modifier
                                .padding(10.dp))
                            Button(onClick = {
                                matchNumber.value=-1
                                tile.value=3
                                gameMode.value=0
                                TimerMode.value=false}){
                                Text("3*3")
                            }
                            Spacer(modifier = Modifier
                                .padding(10.dp))
                            Button(onClick = {
                                matchNumber.value=-1
                                tile.value=4
                                gameMode.value=0
                                TimerMode.value=false}){
                                Text("4*4")
                            }

                        }
                        Spacer(modifier = Modifier
                            .padding(10.dp))
                        Button(onClick = {
                            matchNumber.value=-1
                            tile.value=5
                            gameMode.value=0
                            TimerMode.value=false}){
                            Text("5*5")
                        }
                        Spacer(modifier = Modifier
                            .padding(6.dp))
                        Button(onClick = {TimerMode.value=true
                            //navigateToGamePage()
                            matchNumber.value=-1}){
                            Text("Timer Mode")
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
        if(hackerMode.value==3){
            AlertDialog(onDismissRequest = { hackerMode.value=0}, confirmButton = { /*TODO*/ },
                modifier =Modifier.size(height=300.dp,width=300.dp),
                text={
                    Column{
                        Button(onClick = {
                            hackerMode.value=1
                            TimerMode.value=false
                            navigateToGamePage()}){
                            Text("VS Computer")
                        }
                        Button(onClick = { hackerMode.value=2
                        Multi.value=1}){
                            Text("Multiplayer Mode")
                        }
                    }

                })
        }
        if(Multi.value==1){
            AlertDialog(onDismissRequest = { Multi.value=0 }, confirmButton = { /*TODO*/ },
                text={
                    Column(){
                        Text("Choose Number Of Players")
                        Button(onClick = {
                            nameMulti.value=0
                            Multi.value=0
                            norMode.value=1
                            hackerMode.value=0
                            TimerMode.value=false
                            playerNum.value=2
                            navigateToGamePage()
                            }){
                            Text("2")
                        }
                        Button(onClick = {
                            playerNum.value=3
                            Multi.value=0
                            nameMulti.value=1
                            TimerMode.value=false
                            hackerMode.value=2
                            norMode.value=0
                            }){
                            Text("3")
                        }
                        Button(onClick = {
                            Multi.value=0
                            playerNum.value=4
                            nameMulti.value=1
                            hackerMode.value=2
                            norMode.value=0
                            TimerMode.value=false}){
                            Text("4")
                        }
                    }
                })
        }
        if (nameMulti.value == 1) {
            AlertDialog(
                onDismissRequest = { nameMulti.value = 0 },
                modifier = Modifier.size(500.dp),
                confirmButton = {
                    Button(onClick = { nameMulti.value = 0
                        hackerMode.value=2
                        norMode.value=0
                    navigateToGamePage()}) {
                        Text("OK")
                    }
                },
                text = {
                    Column{
                        TextField(
                            value = player1Name.value,
                            onValueChange = { player1Name.value = it },
                            textStyle = TextStyle(
                                color = Color(254, 95, 86, 255)
                            ),
                            modifier = Modifier
                                .fillMaxWidth(),
                            label = {

                                Text(
                                    "Enter Player-1 Name",
                                    fontSize = 8.sp,
                                    color = Color(94, 107, 147, 255),
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        )
                        Spacer(modifier=Modifier
                            .padding(16.dp))
                        TextField(
                            value = player2Name.value,
                            onValueChange = { player2Name.value = it },
                            textStyle = TextStyle(
                                color = Color(254, 95, 86, 255)
                            ),
                            modifier = Modifier
                                .fillMaxWidth(),
                            label = {
                                Text(
                                    "Enter Player-2 Name",
                                    fontSize = 8.sp,
                                    color = Color(94, 107, 147, 255),
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        )
                        Spacer(modifier=Modifier
                            .padding(16.dp))
                        if(playerNum.value>=3) {
                            TextField(
                                value = player3Name.value,
                                onValueChange = { player3Name.value = it },
                                textStyle = TextStyle(
                                    color = Color(254, 95, 86, 255)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth(),
                                label = {
                                    Text(
                                        "Enter Player-3 Name",
                                        fontSize = 8.sp,
                                        color = Color(94, 107, 147, 255),
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                            )
                        }
                            Spacer(modifier=Modifier
                                .padding(16.dp))
                        if(playerNum.value==4) {
                            TextField(
                                value = player4Name.value,
                                onValueChange = { player4Name.value = it },
                                textStyle = TextStyle(
                                    color = Color(254, 95, 86, 255)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth(),
                                label = {
                                    Text(
                                        "Enter Player-4 Name",
                                        fontSize = 8.sp,
                                        color = Color(94, 107, 147, 255),
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                            )
                        }

                    }
                }
            )
        }
    }
}