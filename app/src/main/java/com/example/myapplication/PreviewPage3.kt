package com.example.myapplication

import android.graphics.drawable.Icon
import android.service.autofill.Validators.and
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.rotationMatrix
import java.util.ArrayList

@Composable
fun PreviewPage3(navigateToSecondScreen: () -> Unit) {
    var painter1 = painterResource(id = R.drawable.redcircle)
    var list= mutableListOf<Int>(25)
    var list1=  mutableListOf<Int>(25)
    var list2= mutableListOf<Int>(25)
    var painter2= painterResource(id = R.drawable.bluecircle)
    var painter3= painterResource(id = R.drawable.appdec6)
    fun GridLogic(index: Int) {
        if ((GridVal[index] >3 && P1Cnt.value > 0)) {
            if (listOf(0, 4, 24, 20).contains(index)) {

                if (GridVal[index] > 3 && P1Cnt.value > 0) {


                    if (index == 0) {
                        GridVal[index] = 0

                        GridVal[index + 1] += 1
                        Grid[index+1]=1
                        GridVal[index + 5] += 1
                        Grid[index+5]=1
                        ValColor[index+1]=ValColor[index]
                        ValColor[index+5]=ValColor[index]
                        Grid3[index+1]=Grid3[index]
                        Grid3[index+5]=Grid3[index]


                    }
                    else if (index == 4) {
                        GridVal[index] = 0

                        GridVal[index - 1] += 1
                        Grid[index-1]=1
                        GridVal[index + 5] += 1
                        Grid[index+5]=1
                        ValColor[index-1]= ValColor[index]
                        ValColor[index+5]=ValColor[index]
                        Grid3[index-1]=Grid3[index]
                        Grid3[index+5]=Grid3[index]


                    }
                    else if (index == 20) {
                        GridVal[index] = 0

                        GridVal[index + 1] += 1
                        Grid[index+1]=1
                        GridVal[index - 5] += 1
                        Grid[index-5]=1
                        ValColor[index+1]= ValColor[index]
                        ValColor[index-5]= ValColor[index]
                        Grid3[index+1]=Grid3[index]
                        Grid3[index-5]=Grid3[index]

                    }
                    else {
                        GridVal[index] = 0

                        GridVal[index - 1] += 1
                        Grid[index-1]=1
                        GridVal[index - 5] += 1
                        Grid[index-5]=1
                        ValColor[index-1]=ValColor[index]
                        ValColor[index-5]= ValColor[index]
                        Grid3[index-1]=Grid3[index]
                        Grid3[index-5]=Grid3[index]
                    }

                }

            } else if (listOf(1, 2, 3, 5, 10, 15, 21, 22, 23, 9, 14, 19).contains(index)) {
                if (listOf(1, 2, 3).contains(index)) {
                    GridVal[index] = 0

                    GridVal[index + 1] += 1
                    Grid[index+1]=1
                    GridVal[index - 1] += 1
                    Grid[index-1]=1
                    GridVal[index + 5] += 1
                    Grid[index+5]=1
                    ValColor[index+1]= ValColor[index]
                    ValColor[index-1]= ValColor[index]
                    ValColor[index+5]= ValColor[index]
                    Grid3[index+1]=Grid3[index]
                    Grid3[index+5]=Grid3[index]
                    Grid3[index-1]=Grid3[index]


                } else if (listOf(5, 10, 15).contains(index)) {
                    GridVal[index] = 0

                    GridVal[index + 1] += 1
                    GridVal[index - 5] += 1
                    GridVal[index + 5] += 1
                    Grid[index + 1] = 1
                    Grid[index - 5] = 1
                    Grid[index + 5] = 1
                    ValColor[index+1]= ValColor[index]
                    ValColor[index-5]= ValColor[index]
                    ValColor[index+5]= ValColor[index]
                    Grid3[index+1]=Grid3[index]
                    Grid3[index+5]=Grid3[index]
                    Grid3[index-5]=Grid3[index]
                } else if (listOf(21, 22, 23).contains(index)) {
                    GridVal[index] = 0

                    GridVal[index - 1] += 1
                    GridVal[index - 5] += 1
                    GridVal[index + 1] += 1
                    Grid[index - 1] = 1
                    Grid[index - 5] = 1
                    Grid[index + 1] = 1
                    ValColor[index+1]= ValColor[index]
                    ValColor[index-1]= ValColor[index]
                    ValColor[index-5]= ValColor[index]
                    Grid3[index+1]=Grid3[index]
                    Grid3[index-5]=Grid3[index]
                    Grid3[index-1]=Grid3[index]
                } else {
                    GridVal[index] = 0

                    GridVal[index - 1] += 1
                    GridVal[index - 5] += 1
                    GridVal[index + 5] += 1
                    Grid[index - 1] = 1
                    Grid[index - 5] = 1
                    Grid[index + 5] = 1
                    ValColor[index-1]= ValColor[index]
                    ValColor[index-5]= ValColor[index]
                    ValColor[index+5]= ValColor[index]
                    Grid3[index-1]=Grid3[index]
                    Grid3[index+5]=Grid3[index]
                    Grid3[index-5]=Grid3[index]
                }
            } else {
                GridVal[index] = 0

                GridVal[index + 5] += 1
                GridVal[index + 1] += 1
                GridVal[index - 5] += 1
                GridVal[index - 1] += 1
                Grid[index + 5] = 1
                Grid[index + 1] = 1
                Grid[index - 5] = 1
                Grid[index - 1] = 1
                ValColor[index+1]= ValColor[index]
                ValColor[index-1]= ValColor[index]
                ValColor[index+5]= ValColor[index]
                ValColor[index-5]=ValColor[index]
                Grid3[index+1]=Grid3[index]
                Grid3[index+5]=Grid3[index]
                Grid3[index-1]=Grid3[index]

                Grid3[index-5]=Grid3[index]

            }
        }

    }
    fun GamePoint(){
        P1Score.value=0
        P2Score.value=0
        for (i in 0 .. 24){

            if(ValColor[i]==0){
             P1Score.value+=GridVal[i]}
            else if(ValColor[i]==1){
                P2Score.value+=GridVal[i]
            }
        }

    }

    if (PageColor.value == 1) {
        Surface(
            color = Color(47, 183, 241, 255),
            modifier = Modifier.fillMaxWidth()
        ) {}
    } else if (PageColor.value == 0) {
        Surface(
            color = Color(255, 94, 86, 255),
            modifier = Modifier.fillMaxWidth()
        ) {}
    }
    Column {
        Button(
            onClick = { },
            modifier = Modifier
                .offset(300.dp)
                .padding(6.dp)
                .height(50.dp)
                .width(50.dp),
            colors=ButtonDefaults.buttonColors(containerColor = Color(255,254,252,255))
        ) {
            Text("X",textAlign=TextAlign.Center,
                color = Color(161,184,205,255))
        }
        Row(
            modifier=Modifier.fillMaxWidth()
        ) {
            Card(
                shape = RoundedCornerShape(40.dp, 40.dp, 40.dp, 30.dp),
                colors = CardDefaults.cardColors(containerColor = Color(46,50,58,255)),
                modifier = Modifier
                    .offset(-100.dp, 0.dp)
                    .size(height = 60.dp, width = 180.dp),
                border = BorderStroke(5.dp, Color(1,0,1,255))


            ) {
                Text(P2Score.value .toString(),
                    color=Color(47, 183, 241, 255),
                    modifier = Modifier
                        .padding(16.dp)
                        .offset(120.dp, 0.dp)
                        .rotate(180f),
                    textAlign = TextAlign.Right,
                    fontSize = 24.sp,

                )


            }

            Card(
                shape = CutCornerShape(45.dp, 5.dp, 5.dp, 45.dp),
                colors = CardDefaults.cardColors(containerColor = Color(46,50,58,255)),
                modifier = Modifier
                    .offset(-60.dp, 0.dp)
                    .wrapContentWidth(),
                border = BorderStroke(2.dp, Color(1,0,1,255))
            ) {
                    Text(player2Name.value.toUpperCase(),
                        color = Color(47, 183, 241, 255),
                        modifier = Modifier
                            .padding(16.dp)
                            .rotate(180f)
                            ,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                        )
            }
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .size(height = 300.dp, width = 350.dp)
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(5)) {
            items(25) { index ->
                Box(
                    contentAlignment = Alignment.Center,

                ){

                    Button(
                        shape = RoundedCornerShape(10),

                        onClick = {

                            if(Grid[index]==1 && (P1Cnt.value>=0 && GridVal[index]!=0 )&&!(index in list1)){
                                list.add(index)
                            }
                            if (Grid3[index]==0 && Grid[index]==1){
                                list1.add(index)
                            }
                            else if(Grid3[index]==1 && Grid[index]==1 ){
                                list2.add(index)
                            }
                            if ((index in list || P1Cnt.value==-1|| P2Cnt.value==-1)) {
                                if (((Turn.value == 0 && index in list1)|| P1Cnt.value==-1) ||(P2Cnt.value==-1 && !(index in list1)||(Turn.value==1 && index in list2)) ) {
                                    PageColor.value = if (PageColor.value == 0) 1 else 0
                                    Grid[index] = 1
                                    ValColor[index] = if (PageColor.value == 0) 1 else 0
                                    Grid2[index] = if (ValColor[index] == 0) 0 else 1
                                    Turn.value = if (Turn.value == 0) 1 else 0
                                    if (Grid3[index] == -1) {
                                        Grid3[index] = Grid2[index]
                                    }
                                    if (ValColor[index] == 0) {
                                        P1Cnt.value += 1
                                    } else {
                                        P2Cnt.value += 1
                                    }
                                    if (ValColor[index] == 0) {

                                        if (P1Cnt.value == 0) {
                                            GridVal[index] = 3

                                        } else {
                                            GridVal[index] += 1

                                        }
                                    } else {
                                        if (P2Cnt.value == 0) {
                                            GridVal[index] = 3

                                        } else {
                                            GridVal[index] += 1
                                        }
                                    }
                                }
                            }

                        },
                        modifier = Modifier
                            .padding(5.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(16.dp))
                            .shadow(elevation = 200.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(244, 228, 206, 255))

                    ) {
                        GamePoint()
                        GridLogic(index)
                    }

                    if(Grid[index]==1 && ValColor[index]==0 && Grid3[index]==0 ){
                        if (GridVal[index]!=0){
                            Image(painter = painter1, contentDescription = "redcircle",
                                modifier = Modifier.size(60.dp),
                            )
                            Text(
                                GridVal[index].toString(),
                                color=Color.White,
                                fontSize = 24.sp)
                        }

                    }
                    else if(Grid[index]==1 && ValColor[index]==1 && Grid3[index]==1
                    ) {
                        if (GridVal[index] != 0) {
                            Image(painter = painter2, contentDescription = "bluecircle",
                                modifier = Modifier.size(50.dp))
                            Text(
                                GridVal[index].toString(),
                                fontSize = 24.sp,
                                color = Color.White
                            )
                        }
                    }
                }

            }
        }
    }

    Row(
        modifier= Modifier
            .offset(210.dp, 650.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
        Card(
            shape = CutCornerShape(5.dp, 135.dp, 135.dp, 5.dp),
            colors = CardDefaults.cardColors(containerColor = Color(46,50,58,255)),

            border = BorderStroke(2.dp, Color(1,0,1,255)),
            modifier= Modifier
                .offset(-200.dp, 0.dp)
                .wrapContentWidth()


        ) {
            Text(player1Name.value.toUpperCase(),
                color = Color(255, 94, 86, 255),
                modifier = Modifier
                    .padding(16.dp),
                fontSize = 24.sp,
                textAlign = TextAlign.Center

            )
        }

        Card(
            shape = RoundedCornerShape(40.dp, 40.dp, 40.dp, 30.dp),
            colors = CardDefaults.cardColors(containerColor = Color(46,50,58,255))
                ,
            border = BorderStroke(5.dp, Color(1,0,1,255)),
            modifier= Modifier
                .offset(95.dp, -60.dp)
                .size(height = 60.dp, width = 180.dp)

        ) {
                Text(P1Score.value .toString(),
                    color=Color(255, 94, 86, 255),
                    modifier= Modifier
                        .padding(12.dp)
                        .offset(14.dp, 0.dp),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center)
        }
            }
        Spacer(modifier = Modifier.padding(8.dp))

    }
    if((P1Score.value==0 || P2Score.value==0 )&& P1Cnt.value>0){
            var name= if (P1Score.value==0) player2Name.value else player1Name.value
            WinnerList.add(name)
        AlertDialog(onDismissRequest = { DialogBox.value=false }, confirmButton = { /*TODO*/ },
            containerColor =  Color(60,64,117,255),
            modifier = Modifier.size(height=350.dp,width=250.dp),
            iconContentColor =Color(193,232,250,255),
            text={
                Column (
                ){
                    Card (
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(255,255,255,255)),
                        modifier=Modifier
                        .size(width = 220.dp, height = 50.dp),

                    ){
                        Text(name.toUpperCase(),
                            color = Color.Black,
                            modifier=Modifier
                                .offset(15.dp,5.dp),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Image(painter=painter3,
                        contentDescription = "i",
                        modifier = Modifier
                            .size(50.dp)
                            .offset(75.dp, 40.dp)

                    )
                    Text("WINS !!",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .offset(60.dp,60.dp))
                    Column {

                        Button(onClick = {  P1Cnt.value=-1
                                            P2Cnt.value=-1
                                            PageColor.value=0
                                            var list= mutableListOf<Int>(25)
                                            var list1= mutableListOf<Int>(25)
                                            var list2= mutableListOf<Int>(25)
                                            Turn.value=0
                                         for (i in 0..24){
                                             Grid[i]=0
                                             GridVal[i]=0
                                             Grid2[i]=-1
                                             Grid3[i]=-1
                                             ValColor[i]=-1
                                         }},
                            modifier = Modifier
                                .offset(0.dp, 80.dp)
                                .size(width = 220.dp, height = 50.dp)){
                           Text("Play Again",
                                color=Color.White,
                                fontSize = 24.sp)
                        }
                        Spacer(modifier =Modifier
                            .padding(5 .dp))
                        Button(onClick = { navigateToSecondScreen()
                                         pageState.value=0},
                            modifier = Modifier
                                .offset(0.dp, 80.dp)
                                .size(width = 220.dp, height = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(254,95,86,255))){
                            Text("Home",
                                fontSize = 24.sp,
                                color = Color.White)
                        }
                    }

                }
            }
        )
    }
}














