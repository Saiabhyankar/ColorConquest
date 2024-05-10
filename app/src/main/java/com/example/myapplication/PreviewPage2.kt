package com.example.myapplication


import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewPage2(){
    var painter1= painterResource(id = R.drawable.appdev2)
    var painter2= painterResource(id = R.drawable.image1)
    var painter3= painterResource(id = R.drawable.appdev4)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){Row(){
        Card(
            shape = CutCornerShape(20.dp,20.dp,20.dp,20.dp),
            border = BorderStroke(2.dp, Color(213,186,183,255)),
            modifier = Modifier
                .width(350.dp)
                .height(45.dp)
                .offset(0.dp, 50.dp),
            colors = CardDefaults.cardColors(containerColor = Color(254,215,183,255))
        ) {
            Text("      PLAYER INFORMATION",
                color=Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold)
        }

    }


    }
    Column {
        Row(
        ){
            Image(painter = painter1, contentDescription = "PlayerIcon",
                modifier= Modifier
                    .offset(-10.dp, 200.dp)
                    .size(250.dp))
            Card(
                shape= RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(61,65,117,255)),
                modifier= Modifier
                    .size(height = 100.dp, width = 300.dp)
                    .offset(-20.dp, 215.dp)
            ){
                Image(painter = painter3, contentDescription = "Text",
                    modifier= Modifier
                        .size(150.dp)
                        .offset(0.dp, 0.dp),
                    alignment = Alignment.TopCenter
                    )
                TextField(value = "Please Enter Name", onValueChange ={player1Name.value=it},
                   colors = TextFieldDefaults.colors(Color(61,65,117,255)))


                }
            }



        Spacer(modifier = Modifier.padding(10.dp))
        Image(painter = painter2, contentDescription = "Image",
            modifier= Modifier
                .size(450.dp)
                .offset(10.dp, 0.dp))
        Button(onClick = { pageState.value=2 },
            colors = ButtonDefaults.buttonColors(containerColor = Color(46,182,241,255)),
            modifier = Modifier
                .size(width = 200.dp, height = 80.dp)
                .offset(100.dp, 1.dp)
                .shadow(25.dp, RoundedCornerShape(5.dp))) {
            Text("START",
                fontSize = 32.sp,
                textAlign = TextAlign.Center)}
        }
        }





