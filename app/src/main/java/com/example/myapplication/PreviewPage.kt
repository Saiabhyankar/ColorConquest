package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.fontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewPage(navigateToSecondPage:()->Unit){
    val gradient = Brush.verticalGradient(
        0.0f to Color(254,194,113,255),
        1.0f to Color(254,99,109,255),
        startY = 0.0f,
        endY = 1500.0f
    )
    Box(modifier = Modifier.background(gradient))
    val painter= painterResource(id = R.drawable.image1)
    var showDialog by remember {
        mutableStateOf(false)

    }
    Column(
        modifier= Modifier.size(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){Spacer(modifier = Modifier.size(100.dp))

            Text("COLOR",
                fontSize = 65.sp,
                fontFamily=fontFamily,
                color = Color(31,19,19,255) ,
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        colors = listOf( Color(31,19,19,255),Color(56,34,33,255),Color(78,49,47,255),Color(83,50,49,255)),
                        tileMode = TileMode.Mirror
                    )
                )
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text("CONQUEST",
                fontSize=65.sp,
                fontFamily=fontFamily,
                color = Color(147,90,86,255),
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        colors = listOf( Color(147,90,86,255),Color(158,96,92,255),Color(198,120,117),Color(206,127,120,255)),
                        tileMode = TileMode.Mirror
                    )
                )
            )
        Box(contentAlignment = Alignment.Center
        ){
            Image(painter = painter, contentDescription = "AppDev",
                modifier= Modifier
                    .size(400.dp)
                    .offset(0.dp, -(100.dp)))
            }

        Box(
            contentAlignment = Alignment.Center
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Button(onClick = { navigateToSecondPage()},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(46,182,241,255)),
                    modifier = Modifier
                        .size(width = 200.dp, height = 80.dp)
                        .offset(35.dp, -(60.dp))
                        .shadow(25.dp, RoundedCornerShape(5.dp))) {
                    Text("PLAY",
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center)
            }
                Spacer(Modifier.width(5.dp))
                Button(onClick = { showDialog=true},
                    modifier= Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .offset(40.dp, -(60.dp))
                        .shadow(15.dp, RoundedCornerShape(5.dp))
                        ,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(59,67,119,255))
                    ) {
                    Text("?",
                        fontSize = 35.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraBold
                        )
                }


                if(showDialog){
                    AlertDialog(onDismissRequest = { showDialog=false}, confirmButton = { /*TODO*/ },
                        modifier = Modifier
                            .size(height = 600.dp, width = 350.dp),
                        containerColor =  Color(232,96,43,255),
                        text={
                            Text(
                                "First Turn: \n" +
                                        "Players can choose any tile on the grid."+
                                        "Clicking a tile assigns your color and awards you 3 points on that tile.\n" +
                                        "Subsequent Turns:\n" +
                                        "Players can only click tiles that already have their color.\n" +
                                        "Clicking a tile with your color adds 1 point to that tile.\n" +
                                        "The background color indicates the next player's turn.\n" +
                                        "Conquest and Expansion:\n" +
                                        "\n" +
                                        "When a tile with your color reaches 4 points, it triggers an expansion:\n" +
                                        "The original tile's color disappears.\n" +
                                        "Your color spreads to the four surrounding squares (up, down, left, right).\n" +
                                        "Each surrounding square gains 1 point with your color.\n" +
                                        "If a surrounding square has your opponent's color, you conquer it, adding a point and erasing their color.\n" +
                                        "Expansion re-triggers if a neighboring tile also reaches 4 points.\n" +
                                        "Objective:\n" +
                                        "\n" +
                                        "Take turns clicking on tiles to eliminate your opponent's color entirely from the screen.",
                                 color=Color.White)
                        })
                }

            }
        }

        }

    }
