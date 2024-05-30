package com.example.myapplication


import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewPage2(navigateToThirdPage:()->Unit) {
    var context= LocalContext.current
    var context1= LocalContext.current
    val gradient = Brush.verticalGradient(
        0.0f to Color(254,194,113,255),
        1.0f to Color(254,99,109,255),
        startY = 0.0f,
        endY = 1500.0f
    )
    Box(modifier = Modifier.background(gradient))
    var painter1 = painterResource(id = R.drawable.appdev2)
    var painter2 = painterResource(id = R.drawable.image1)
    var painter3 = painterResource(id = R.drawable.appdev4)
    var painter4 = painterResource(id = R.drawable.appdev5)
    val name=readFromSharedPreferences(context,"Name","MysharedPref")
    val Score= readFromSharedPreferences(context1,"Score","MysharedPref")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {

            Card(
                shape = CutCornerShape(20.dp, 20.dp, 20.dp, 20.dp),
                border = BorderStroke(2.dp, Color(213, 186, 183, 255)),
                modifier = Modifier
                    .width(350.dp)
                    .height(45.dp)
                    .offset(0.dp, 50.dp),
                colors = CardDefaults.cardColors(containerColor = Color(254, 215, 183, 255))
            ) {
                Text(
                    "    PLAYER INFORMATION",
                    color = Color.Black,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold
                )
            }

        }


    }
    Column {
        Row(
        ) {
            Image(
                painter = painter1, contentDescription = "PlayerIcon",
                modifier = Modifier
                    .offset(-10.dp, 210.dp)
                    .size(240.dp)
            )
            Column() {
                Box(
                    modifier = Modifier
                        .size(height = 100.dp, width = 300.dp)
                        .offset(-20.dp, 215.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = Color(61, 65, 117, 255))
                ) {
                    TextField(value = player1Name.value, onValueChange = { player1Name.value = it },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(
                                61,
                                65,
                                117,
                                255
                            ),
                            unfocusedTextColor = Color.Transparent,
                            focusedTextColor = Color.Transparent
                        ),
                        textStyle = LocalTextStyle.current.copy(color = Color(254, 95, 86, 255)),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .fillMaxWidth(),
                        label = {
                            Text(
                                "Enter Player-1 Name",
                                fontSize = 8.sp,
                                color = Color(94, 107, 147, 255),
                                fontWeight = FontWeight.ExtraBold
                            )
                        })

                    Image(
                        painter = painter3, contentDescription = "Text",
                        modifier = Modifier
                            .size(150.dp)
                            .offset(0.dp, 0.dp),
                        alignment = Alignment.TopCenter
                    )
                    Text(
                        "- - - - - - - - - - - - -  ",
                        color = Color(254, 95, 86, 255),
                        modifier = Modifier.offset(5.dp, 80.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(15.dp))
                Box(
                    modifier = Modifier
                        .size(height = 100.dp, width = 300.dp)
                        .offset(-25.dp, 215.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = Color(61, 65, 117, 255))
                ) {
                    TextField(value = player2Name.value, onValueChange = { player2Name.value = it },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(
                                61,
                                65,
                                117,
                                255
                            ),
                            unfocusedTextColor = Color.Transparent,
                            focusedTextColor = Color.Transparent
                        ),
                        textStyle = LocalTextStyle.current.copy(color = Color(47, 183, 241, 255)),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .fillMaxWidth(),
                        label = {
                            Text(
                                "Enter Player-2 Name",
                                fontSize = 8.sp,
                                color = Color(94, 107, 147, 255),
                                fontWeight = FontWeight.ExtraBold
                            )
                        })

                    Image(
                        painter = painter4, contentDescription = "Text",
                        modifier = Modifier
                            .size(55.dp)
                            .offset(40.dp, 0.dp),
                        alignment = Alignment.TopCenter
                    )
                    Text(
                        "- - - - - - - - - - - - -  ",
                        color = Color(47, 183, 241, 255),
                        modifier = Modifier.offset(5.dp, 80.dp),
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                }
               }
        Image(
            painter = painter2, contentDescription = "Image",
            modifier = Modifier
                .size(height = 350.dp, width = 650.dp)
                .offset(0.dp, 80.dp)

        )
        Column {
            Button(
            onClick = { navigateToThirdPage()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(46, 182, 241, 255)),
            modifier = Modifier
                .size(width = 200.dp, height = 80.dp)
                .offset(110.dp, -10.dp)
                .shadow(25.dp, RoundedCornerShape(5.dp))

        ) {
            Text(
                "START",
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
            }

            Button(onClick = {showDetail.value=true},
                modifier = Modifier
                    .offset(130.dp,0.dp)
                    .size(width = 150.dp, height = 60.dp)
                    .shadow(25.dp, RoundedCornerShape(5.dp))) {
                Text("Winner Detail")
            }
            if(showDetail.value){
                AlertDialog(onDismissRequest = { showDetail.value=false}, confirmButton = { /*TODO*/ },
                    text={
                        Column(){
                            Row {
                                Text("Player Name",
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Right)
                                Spacer(modifier = Modifier
                                    .padding(16.dp))
                                Text("Player Score",
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center)
                            }
                            Row {
                                Text(name,fontSize = 16.sp,
                                    textAlign = TextAlign.Center)
                                Spacer(modifier = Modifier
                                    .padding(60 .dp))
                                Text(Score,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.End)
                            }
                        }
                    })}
        }
    }
}






