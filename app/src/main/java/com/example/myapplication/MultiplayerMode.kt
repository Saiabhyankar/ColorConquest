package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun MultiPlayer(navigateToMultiplayer:()->Unit){
    var painter1 = painterResource(id = R.drawable.redcircle)
    var painter2= painterResource(id = R.drawable.bluecircle)
    var painter3= painterResource(id = R.drawable.greencolor)
    var list= mutableListOf<Int>(25)
    var list1=  mutableListOf<Int>(25)
    var list2= mutableListOf<Int>(25)
    var list3= mutableListOf<Int>(tile.value-1)
    for (i in 1..tile.value-1){
        list3.add(i)
    }
    var list4= mutableListOf<Int>(tile.value-1)
    for (i in (2*tile.value)-1..(((tile.value-1)*(tile.value))-1) step tile.value){
        list4.add(i)
    }
    var list5= mutableListOf<Int>(tile.value-1)
    for (i in tile.value..tile.value*(tile.value-2) step tile.value){
        list5.add(i)
    }
    var list6= mutableListOf<Int>(tile.value-1)
    for (i in (((tile.value-1)*(tile.value))+1)..(((tile.value-1)*(tile.value))+tile.value-2) ){
        list6.add(i)
    }
    var list7 = mutableListOf<Int>(25)
    var list8 = mutableListOf<Int>(25)
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
    else if (PageColor.value == 2) {
        Surface(
            color = Color(89, 236, 96),
            modifier = Modifier.fillMaxWidth()
        ) {}
    }
//    else if (PageColor.value == 0) {
//        Surface(
//            color = Color(255, 94, 86, 255),
//            modifier = Modifier.fillMaxWidth()
//        ) {}
//    }
    fun GridLogic(index: Int) {
        if ((GridVal[index] >3 && P1Cnt.value > 0)) {
            if (listOf(0, tile.value-1, tile.value*tile.value -1, tile.value*tile.value-tile.value).contains(index)) {
                if (index == 0) {
                    GridVal[index] = 0
                    GridVal[index + 1] += 1
                    Grid[index+1]=1
                    GridVal[index + tile.value] += 1
                    Grid[index+tile.value]=1
                    ValColor[index+1]=ValColor[index]
                    ValColor[index+tile.value]=ValColor[index]
                    Grid3[index+1]=Grid3[index]
                    Grid3[index+tile.value]=Grid3[index]


                }
                else if (index == tile.value-1) {
                    GridVal[index] = 0

                    GridVal[index - 1] += 1
                    Grid[index-1]=1
                    GridVal[index + tile.value] += 1
                    Grid[index+tile.value]=1
                    ValColor[index-1]= ValColor[index]
                    ValColor[index+tile.value]=ValColor[index]
                    Grid3[index-1]=Grid3[index]
                    Grid3[index+tile.value]=Grid3[index]


                }
                else if (index == tile.value*tile.value-tile.value) {
                    GridVal[index] = 0

                    GridVal[index + 1] += 1
                    Grid[index+1]=1
                    GridVal[index - tile.value] += 1
                    Grid[index-tile.value]=1
                    ValColor[index+1]= ValColor[index]
                    ValColor[index-tile.value]= ValColor[index]
                    Grid3[index+1]=Grid3[index]
                    Grid3[index-tile.value]=Grid3[index]

                }
                else {
                    GridVal[index] = 0
                    GridVal[index - 1] += 1
                    Grid[index-1]=1

                    GridVal[index - tile.value] += 1
                    Grid[index-tile.value]=1


                    ValColor[index-1]=ValColor[index]
                    ValColor[index-tile.value]= ValColor[index]

                    Grid3[index-1]=Grid3[index]
                    Grid3[index-tile.value]=Grid3[index]
                }

            }

            else if (list3.contains(index)) {
                GridVal[index] = 0

                GridVal[index + 1] += 1
                Grid[index+1]=1
                GridVal[index - 1] += 1
                Grid[index-1]=1
                GridVal[index + tile.value] += 1
                Grid[index+tile.value]=1
                ValColor[index+1]= ValColor[index]
                ValColor[index-1]= ValColor[index]
                ValColor[index+tile.value]= ValColor[index]
                Grid3[index+tile.value]=Grid3[index]
                Grid3[index+1]=Grid3[index]
                Grid3[index-1]=Grid3[index]}

            else if (list5.contains(index)) {
                GridVal[index] = 0

                GridVal[index + 1] += 1
                GridVal[index - tile.value] += 1
                GridVal[index + tile.value] += 1
                Grid[index + 1] = 1
                Grid[index - tile.value] = 1
                Grid[index + tile.value] = 1
                ValColor[index+1]= ValColor[index]
                ValColor[index-tile.value]= ValColor[index]
                ValColor[index+tile.value]= ValColor[index]
                Grid3[index+1]=Grid3[index]
                Grid3[index+tile.value]=Grid3[index]
                Grid3[index-tile.value]=Grid3[index]
            }
            else if (list6.contains(index)) {
                GridVal[index] = 0

                GridVal[index - 1] += 1
                GridVal[index - tile.value] += 1
                GridVal[index + 1] += 1
                Grid[index - 1] = 1
                Grid[index - tile.value] = 1
                Grid[index + 1] = 1
                ValColor[index+1]= ValColor[index]
                ValColor[index-1]= ValColor[index]
                ValColor[index-tile.value]= ValColor[index]
                Grid3[index+1]=Grid3[index]
                Grid3[index-tile.value]=Grid3[index]
                Grid3[index-1]=Grid3[index]
            }
            else if(list4.contains(index)) {
                GridVal[index] = 0

                GridVal[index - 1] += 1
                GridVal[index - tile.value] += 1
                GridVal[index + tile.value] += 1
                Grid[index - 1] = 1
                Grid[index - tile.value] = 1
                Grid[index + tile.value] = 1
                ValColor[index-1]= ValColor[index]
                ValColor[index- tile.value]= ValColor[index]
                ValColor[index+ tile.value]= ValColor[index]
                Grid3[index-1]=Grid3[index]
                Grid3[index+ tile.value]=Grid3[index]
                Grid3[index- tile.value]=Grid3[index]
            }

            else {
                GridVal[index] = 0

                GridVal[index + tile.value] += 1
                GridVal[index + 1] += 1
                GridVal[index - tile.value] += 1
                GridVal[index - 1] += 1
                Grid[index + tile.value] = 1
                Grid[index + 1] = 1
                Grid[index - tile.value] = 1
                Grid[index - 1] = 1
                ValColor[index+1]= ValColor[index]
                ValColor[index-1]= ValColor[index]
                ValColor[index+ tile.value]= ValColor[index]
                ValColor[index-tile.value]=ValColor[index]
                Grid3[index+1]=Grid3[index]
                Grid3[index+tile.value]=Grid3[index]
                Grid3[index-1]=Grid3[index]
                Grid3[index-tile.value]=Grid3[index]

            }
        }

    }
    fun GamePoint(){
        P1Score.value=0
        P2Score.value=0
        P3Score.value=0
        P4Score.value=0
        for (i in 0 .. ((tile.value)*(tile.value)-1)){

            if(ValColor[i]==2){
                P1Score.value+=GridVal[i]}
            else if(ValColor[i]==0){
                P2Score.value+=GridVal[i]
            }
            else if(ValColor[i]==1){
                P3Score.value+= GridVal[i]
            }
        }
    }
    Column(){
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .offset(0.dp, 40.dp)

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
                    color= Color(47, 183, 241, 255),
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
        if(playerNum.value==3 || playerNum.value==4){
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .offset(0.dp, 60.dp)
                    .rotate(0f)

            ) {
                Card(
                    shape = RoundedCornerShape(40.dp, 40.dp, 40.dp, 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(46, 50, 58, 255)),
                    modifier = Modifier
                        .offset(-100.dp, 0.dp)
                        .size(height = 60.dp, width = 180.dp),
                    border = BorderStroke(5.dp, Color(89, 236, 96))


                ) {
                    Text(
                        P3Score.value.toString(),
                        color = Color(89, 236, 96),
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
                    colors = CardDefaults.cardColors(containerColor = Color(46, 50, 58, 255)),
                    modifier = Modifier
                        .offset(-60.dp, 0.dp)
                        .wrapContentWidth(),
                    border = BorderStroke(2.dp, Color(1, 0, 1, 255))
                ) {
                    Text(
                        player3Name.value.toUpperCase(),
                        color = Color(89, 236, 96),
                        modifier = Modifier
                            .padding(16.dp)
                            .rotate(180f),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }

    }


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .size(height = 200.dp, width = 250.dp)
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(tile.value)) {
            items(tile.value*tile.value) { index ->
                Box(
                    contentAlignment = Alignment.Center
                ) {

                    Button(
                        shape = RoundedCornerShape(15),
                        onClick = {

                            if (Grid[index] == 1 && (P1Cnt.value >= 0 && GridVal[index] != 0) && !(index in list1)) {
                                list.add(index)
                            }
                            if (Grid3[index] == 2 && Grid[index] == 1) {
                                list1.add(index)
                            } else if (Grid3[index] == 0 && Grid[index] == 1) {
                                list2.add(index)
                            }
                            else if (Grid3[index] == 1 && Grid[index] == 1) {
                                list7.add(index)
                            }
//                            else if (Grid3[index] == 3 && Grid[index] == 1) {
//                                list8.add(index)
//                            }
                            if ((index in list || P1Cnt.value == -1 || P2Cnt.value == -1 || P3Cnt.value==-1)) {
                                if (((Turn.value == 0 && index in list1) || P1Cnt.value == -1)
                                    ||
                                    (P2Cnt.value == -1 && !(index in list1)
                                            ||
                                            (Turn.value == 1 && index in list2))
                                    ||
                                    (P3Cnt.value==-1 ||(Turn.value==2 && index in list7))) {
                                    Grid[index] = 1
                                    PageColor.value =
                                            if (PageColor.value == 0 )
                                                1
                                            else if(PageColor.value==1)
                                                2
                                            else
                                                0
                                        ValColor[index] = if (PageColor.value == 0)
                                            1
                                        else if(PageColor.value==1)
                                            2
                                        else
                                            0
                                        Grid2[index] =  if (ValColor[index]== 0)
                                            0
                                        else if(ValColor[index]==1)
                                            1
                                        else
                                            2
                                        Turn.value =  if (Turn.value == 0)
                                            1
                                        else if(Turn.value==1)
                                            2
                                        else
                                            0
                                        if (Grid3[index] == -1) {
                                            Grid3[index] = Grid2[index]
                                        }
                                        if (ValColor[index] == 2) {
                                            P1Cnt.value += 1
                                        }
                                        else if(ValColor[index]==0){
                                            P2Cnt.value += 1
                                        }
                                        else{
                                            P3Cnt.value+=1
                                        }
                                        if (P1Cnt.value == 0) {
                                                GridVal[index] = 3
                                            }
                                        else {
                                                GridVal[index] += 1
                                            }

                                }
                            }

//                            if (!(index in list) && ((P1Cnt.value > 0) || (P2Cnt.value == 0))) {
//                                Toast.makeText(
//                                    context, "Invalid Option",
//                                    Toast.LENGTH_LONG
//                                ).show()
//                                mediaPlayer.start()
//                            }
                        },
                        modifier = Modifier
                            .padding(5.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(16.dp))
                            .shadow(elevation = 200.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                244,
                                228,
                                206,
                                255
                            )
                        )

                    ) {
                        GamePoint()
                        GridLogic(index)
                        if((P1Score.value==0 || P2Score.value==0 || P3Score.value==0)&& P1Cnt.value>0) {
                            if(P1Score.value==0){
                                PageColor.value =
                                    if (PageColor.value == 0 )
                                        1
                                    else if(PageColor.value==1)
                                        2
                                else
                                    1

                                ValColor[index] =
                                    if (PageColor.value == 2)
                                    1
                                else
                                    2
//
                                Grid2[index] =
                                    if(ValColor[index]==1)
                                        1
                                    else
                                        2
                                Turn.value =
                                    if(Turn.value==1)
                                        2
                                    else
                                        1
                            }
                        }
                    }
                        if (Grid[index] == 1 && ValColor[index] == 2 && Grid3[index] == 2) {
                            if (GridVal[index] != 0) {
                                Image(
                                    painter = painter1, contentDescription = "redcircle",
                                    modifier = Modifier.size(60.dp),
                                )
                                Text(
                                    GridVal[index].toString(),
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }

                        } else if (Grid[index] == 1 && ValColor[index] == 0 && Grid3[index] == 0
                        ) {
                            if (GridVal[index] != 0) {
                                Image(
                                    painter = painter2, contentDescription = "bluecircle",
                                    modifier = Modifier.size(55 .dp)
                                )
                                Text(
                                    GridVal[index].toString(),
                                    fontSize = 24.sp,
                                    color = Color.White
                                )
                            }
                        }
                        else if (Grid[index] == 1 && ValColor[index] == 1 && Grid3[index] == 1
                        ) {
                            if (GridVal[index] != 0) {
                                Image(
                                    painter = painter3, contentDescription = "greencircle",
                                    modifier = Modifier.size(55 .dp)
                                )
                                Text(
                                    GridVal[index].toString(),
                                    fontSize = 24.sp,
                                    color = Color.White
                                )
                            }
                        }
//                        else if (Grid[index] == 1 && ValColor[index] == 1 && Grid3[index] == 1
//                        ) {
//                            if (GridVal[index] != 0) {
//                                Image(
//                                    painter = painter2, contentDescription = "bluecircle",
//                                    modifier = Modifier.size(55 .dp)
//                                )
//                                Text(
//                                    GridVal[index].toString(),
//                                    fontSize = 24.sp,
//                                    color = Color.White
//                                )
//                            }
//                        }

                }
            }
        }
    }
    Column(
        modifier = Modifier
            .offset(0.dp,550.dp)
    ){
        if(playerNum.value==4){
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .offset(0.dp, 40.dp)

            ) {
                Card(
                    shape = RoundedCornerShape(40.dp, 40.dp, 40.dp, 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(46,50,58,255)),
                    modifier = Modifier
                        .offset(-100.dp, 0.dp)
                        .size(height = 60.dp, width = 180.dp),
                    border = BorderStroke(5.dp, Color(226, 223, 45))


                ) {
                    Text(P2Score.value .toString(),
                        color= Color(226, 223, 45),
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
                    Text(player4Name.value.toUpperCase(),
                        color = Color(226, 223, 45),
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

        Row(
            modifier= Modifier
                .fillMaxWidth()
                .offset(0.dp, 60.dp)
                .rotate(0f)

        ) {
            Card(
                shape = RoundedCornerShape(40.dp, 40.dp, 40.dp, 30.dp),
                colors = CardDefaults.cardColors(containerColor = Color(46, 50, 58, 255)),
                modifier = Modifier
                    .offset(-100.dp, 0.dp)
                    .size(height = 60.dp, width = 180.dp),
                border = BorderStroke(5.dp, Color(255, 94, 86, 255))


            ) {
                Text(
                    P1Score.value.toString(),
                    color = Color(255, 94, 86, 255),
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
                colors = CardDefaults.cardColors(containerColor = Color(46, 50, 58, 255)),
                modifier = Modifier
                    .offset(-60.dp, 0.dp)
                    .wrapContentWidth(),
                border = BorderStroke(2.dp, Color(1, 0, 1, 255))
            ) {
                Text(
                    player1Name.value.toUpperCase(),
                    color = Color(255, 94, 86, 255),
                    modifier = Modifier
                        .padding(16.dp)
                        .rotate(180f),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}