package com.example.myapplication

import android.graphics.pdf.PdfDocument.Page
import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun MultiPlayer(navigateToMultiplayer:()->Unit){
    var context= LocalContext.current
    val context3 = LocalContext.current
    val mediaPlayer =  MediaPlayer.create(context3, R.raw.wrong_move)
    var painter1 = painterResource(id = R.drawable.redcircle)
    var painter2= painterResource(id = R.drawable.bluecircle)
    var painter3= painterResource(id = R.drawable.greencolor)
    var painter4= painterResource(id = R.drawable.yellowcircle)
    var painter5= painterResource(id = R.drawable.winnericon)
    var painter6=painterResource(id = R.drawable.reset)
    var painter7=painterResource(id = R.drawable.exit)
    var counter by remember {
        mutableIntStateOf(0)
    }
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
    if(playerNum.value==4){
        if(PageColor.value==3){
            Surface(
                color = Color(222,239,43,255),
                modifier = Modifier.fillMaxWidth()
            ) {}
        }
    }
    Column {
        Button(
            onClick = { DialogBox1.value = true },
            modifier = Modifier
                .offset(300.dp)
                .padding(6.dp)
                .height(50.dp)
                .width(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isDarkTheme.value) Color(
                    255,
                    254,
                    252,
                    255
                ) else Color(9, 17, 3, 255)
            )
        ) {
            Text(
                "X", textAlign = TextAlign.Center,
                color = Color(161, 184, 205, 255)
            )
        }
        if (DialogBox1.value) {
            AlertDialog(onDismissRequest = { DialogBox1.value = false },
                confirmButton = { /*TODO*/ },
                containerColor = Color.Transparent,
                text = {
                    Box(
                        modifier = Modifier
                            .size(height = 300.dp, width = 300.dp)
                            .offset(20.dp, 0.dp)
                    ) {
                        Button(
                            onClick = {
                                P1Cnt.value = -1
                                P2Cnt.value = -1
                                P3Cnt.value=-1
                                P4Cnt.value=-1
                                PageColor.value = 0
                                var list = mutableListOf<Int>(tile.value * tile.value)
                                var list1 = mutableListOf<Int>(tile.value * tile.value)
                                var list2 = mutableListOf<Int>(tile.value * tile.value)
                                var list7 = mutableListOf<Int>(tile.value * tile.value)
                                var list8 = mutableListOf<Int>(tile.value * tile.value)
                                Turn.value = 0

                                for (i in 0..((tile.value) * (tile.value) - 1)) {
                                    Grid[i] = 0
                                    GridVal[i] = 0
                                    Grid2[i] = -1
                                    Grid3[i] = -1
                                    ValColor[i] = -1
                                }
                                DialogBox1.value = false
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            modifier = Modifier.offset(110.dp, -(30.dp))
                        ) {

                        }
                        Image(
                            painter = painter6, contentDescription = "reset",
                            modifier = Modifier
                                .size(60.dp)
                                .offset(110.dp, -(30.dp))
                        )
                        Button(
                            onClick = {
                                DialogBox2.value = true

                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            modifier = Modifier.offset(200.dp, -30.dp)
                        ) {

                        }
                        Image(
                            painter = painter7, contentDescription = "exit",
                            modifier = Modifier
                                .size(60.dp)
                                .offset(200.dp, -30.dp)
                        )
                    }
                }
            )
        }
        if (DialogBox2.value) {
            DialogBox1.value = false
            AlertDialog(onDismissRequest = { /*TODO*/ }, confirmButton = { /*TODO*/ }, text = {
                Text("Do you really want to exit ?")
                Row() {
                    Button(
                        onClick = {
                            navigateToMultiplayer()
                            DialogBox2.value = false
                            player1Name.value = ""
                            player2Name.value = ""
                            P1Cnt.value = -1
                            P2Cnt.value = -1
                            PageColor.value = 0
                            player3Name.value = ""
                            player4Name.value = ""
                            P3Cnt.value = -1
                            P4Cnt.value = -1
                            var list = mutableListOf<Int>(tile.value * tile.value)
                            var list1 = mutableListOf<Int>(tile.value * tile.value)
                            var list2 = mutableListOf<Int>(tile.value * tile.value)
                            var list7 = mutableListOf<Int>(tile.value * tile.value)
                            var list8 = mutableListOf<Int>(tile.value * tile.value)
                            Turn.value = 0
                            for (i in 0..((tile.value) * (tile.value) - 1)) {
                                Grid[i] = 0
                                GridVal[i] = 0
                                Grid2[i] = -1
                                Grid3[i] = -1
                                ValColor[i] = -1
                            }
                        },
                        modifier = Modifier
                            .offset(0.dp, 40.dp)
                    ) {
                        Text("Yes")
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    Button(
                        onClick = { DialogBox2.value = false },
                        modifier = Modifier
                            .offset(0.dp, 40.dp)
                    ) {
                        Text("No")
                    }
                }
            })
        }
    }
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
            else if(ValColor[i]==3){
                P4Score.value+= GridVal[i]
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
                            else if (Grid3[index] == 3 && Grid[index] == 1) {
                                list8.add(index)
                            }
                            if (((P4Cnt.value>=0&& playerNum.value==4) ||(P3Cnt.value>=0 && playerNum.value==3)) &&((index !in list) || (Turn.value==0 && index !in list1) || (Turn.value==1 && index !in list2)
                                        || (Turn.value==2 && index !in list7) || (Turn.value==3 && index !in list8))) {
                                Toast.makeText(
                                    context, "Invalid Option",
                                    Toast.LENGTH_LONG
                                ).show()
                                mediaPlayer.start()
                            }
                            if ((index in list || P1Cnt.value == -1 || P2Cnt.value == -1 || P3Cnt.value==-1 || (P4Cnt.value==-1 && playerNum.value==4) )) {
                                if (((Turn.value == 0 && index in list1) || P1Cnt.value == -1)
                                    ||
                                    (P2Cnt.value == -1 && !(index in list1)
                                            ||
                                            (Turn.value == 1 && index in list2))
                                    ||
                                    ((P3Cnt.value==-1 && !(index in list)) ||(Turn.value==2 && index in list7))
                                    ||
                                    (P4Cnt.value==-1 && !(index in list) || (Turn.value==3 && index in list8))) {
                                    if ((P1Score.value != 0 && P2Score.value != 0 && P3Score.value != 0 && (P4Score.value!=0 || playerNum.value==3)) || P1Cnt.value <= 0) {
                                        Grid[index] = 1
                                         if(playerNum.value==3) {
                                            PageColor.value =
                                                if (PageColor.value == 0)
                                                    1
                                                else if (PageColor.value == 1)
                                                    2
                                                else
                                                    0
                                            ValColor[index] = if (PageColor.value == 0)
                                                1
                                            else if (PageColor.value == 1)
                                                2
                                            else
                                                0
                                            Grid2[index] = if (ValColor[index] == 0)
                                                0
                                            else if (ValColor[index] == 1)
                                                1
                                            else
                                                2
                                            Turn.value = if (Turn.value == 0)
                                                1
                                            else if (Turn.value == 1)
                                                2
                                            else
                                                0
                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            if (ValColor[index] == 2) {
                                                P1Cnt.value += 1
                                            } else if (ValColor[index] == 0) {
                                                P2Cnt.value += 1
                                            } else {
                                                P3Cnt.value += 1
                                            }
                                            if (P1Cnt.value == 0) {
                                                GridVal[index] = 3
                                            } else {
                                                GridVal[index] += 1
                                            }

                                        }
                                        else if(playerNum.value==4){
                                             PageColor.value =
                                                 if (PageColor.value == 0)
                                                     1
                                                 else if (PageColor.value == 1)
                                                     2
                                                 else if (PageColor.value==2)
                                                      3
                                                else
                                                    0
                                             ValColor[index] = if (PageColor.value == 0)
                                                 3
                                             else if (PageColor.value == 1)
                                                 2
                                             else if(PageColor.value==2)
                                                 0
                                             else
                                                 1
                                             Grid2[index] = if (ValColor[index] == 0)
                                                 0
                                             else if (ValColor[index] == 1)
                                                 1
                                             else if(ValColor[index]==3)
                                                 3
                                             else
                                                 2
                                             Turn.value = if (Turn.value == 0)
                                                 1
                                             else if (Turn.value == 1)
                                                 2
                                             else if(Turn.value==2)
                                                 3
                                             else
                                                 0
                                             if (Grid3[index] == -1) {
                                                 Grid3[index] = Grid2[index]
                                             }
                                             if (ValColor[index] == 2) {
                                                 P1Cnt.value += 1
                                             } else if (ValColor[index] == 0) {
                                                 P2Cnt.value += 1
                                             }
                                             else if(ValColor[index]==3){
                                                 P4Cnt.value+=1
                                             }
                                             else {
                                                 P3Cnt.value += 1
                                             }
                                             if (P1Cnt.value == 0) {
                                                 GridVal[index] = 3
                                             } else {
                                                 GridVal[index] += 1
                                             }

                                        }
                                    }
                                    if (playerNum.value == 3){
                                        if (P1Score.value == 0 && P1Cnt.value > 0) {
                                         Grid[index] = 1
                                            PageColor.value = if (PageColor.value == 2)
                                                1
                                            else
                                             2
                                        ValColor[index] =
                                            if (PageColor.value == 2)
                                                0
                                            else
                                                1
                                        Grid2[index] =
                                            if (ValColor[index] == 1)
                                                1
                                            else
                                                0
                                        if (Grid3[index] == -1) {
                                            Grid3[index] = Grid2[index]
                                        }
                                        Turn.value = if (Turn.value == 2)
                                            1
                                        else
                                            2
                                        GridVal[index] += 1

                                    } else if (P2Score.value == 0 && P1Cnt.value > 0) {
                                        Grid[index] = 1
                                        PageColor.value = if (PageColor.value == 2)
                                            0
                                        else
                                            2
                                        ValColor[index] =
                                            if (PageColor.value == 2)
                                                2
                                            else
                                                1
                                        Grid2[index] =
                                            if (ValColor[index] == 2)
                                                2
                                            else
                                                1
                                        if (Grid3[index] == -1) {
                                            Grid3[index] = Grid2[index]
                                        }
                                        Turn.value = if (Turn.value == 2)
                                            0
                                        else
                                            2
                                        GridVal[index] += 1

                                    } else if (P3Score.value == 0 && P1Cnt.value > 0) {
                                        Grid[index] = 1
                                        PageColor.value = if (PageColor.value == 0)
                                            1
                                        else
                                            0
                                        ValColor[index] =
                                            if (PageColor.value == 0)
                                                0
                                            else
                                                2
                                        Grid2[index] =
                                            if (ValColor[index] == 2)
                                                2
                                            else
                                                0
                                        if (Grid3[index] == -1) {
                                            Grid3[index] = Grid2[index]
                                        }
                                        Turn.value = if (Turn.value == 1)
                                            0
                                        else
                                            1
                                        GridVal[index] += 1

                                    }

                                   }
                                    else if(playerNum.value==4){
                                        if(P1Score.value==0 && P2Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=if(PageColor.value==2)
                                                3
                                            else 2
                                            ValColor[index]=if(PageColor.value==2)
                                                3
                                            else
                                                1
                                            Turn.value=if(Turn.value==2)
                                                3
                                            else
                                                2
                                            Grid2[index] =
                                                if (ValColor[index] == 3)
                                                    3
                                                else
                                                    1

                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            GridVal[index] += 1
                                        }
                                       else if(P1Score.value==0 && P3Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=
                                                if(PageColor.value==1)
                                                    3
                                                else
                                                    1
                                            ValColor[index]=if(PageColor.value==1)
                                                3
                                            else
                                                0
                                            Turn.value=if(Turn.value==1)
                                                3
                                            else
                                                1
                                            Grid2[index] =
                                                if (ValColor[index] == 0)
                                                    0
                                                else
                                                    3

                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            GridVal[index] += 1
                                        }
                                        else if(P2Score.value==0 && P3Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=if(PageColor.value==0)
                                                3
                                            else 0
                                            ValColor[index]=if(PageColor.value==3)
                                                2
                                            else
                                                3
                                            Turn.value=if(Turn.value==0)
                                                3
                                            else
                                                0
                                            Grid2[index] =
                                                if (ValColor[index] == 3)
                                                    3
                                                else
                                                    2

                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            GridVal[index] += 1
                                        }
                                        else if(P1Score.value==0 && P4Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=if(PageColor.value==2)
                                                1
                                            else 2
                                            ValColor[index]=if(PageColor.value==2)
                                                0
                                            else
                                                1
                                            Turn.value=if(Turn.value==1)
                                                2
                                            else
                                                1
                                            Grid2[index] =
                                                if (ValColor[index] == 0)
                                                    0
                                                else
                                                    1

                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            GridVal[index] += 1
                                        }
                                        else if(P3Score.value==0 && P4Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=if(PageColor.value==0)
                                                1
                                            else 0
                                            ValColor[index]=if(PageColor.value==0)
                                                0
                                            else
                                                2
                                            Turn.value=if(Turn.value==1)
                                                0
                                            else
                                                1
                                            Grid2[index] =
                                                if (ValColor[index] == 0)
                                                    0
                                                else
                                                    2

                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            GridVal[index] += 1
                                        }
                                        else if(P2Score.value==0 && P4Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=if(PageColor.value==0)
                                                2
                                            else 0
                                            ValColor[index]=if(PageColor.value==0)
                                                1
                                            else
                                                2
                                            Turn.value=if(Turn.value==0)
                                                2
                                            else
                                                0
                                            Grid2[index] =
                                                if (ValColor[index] == 2)
                                                    2
                                                else
                                                    1

                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            GridVal[index] += 1
                                        }
                                        else if(P1Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=if(PageColor.value==1)
                                                2
                                            else if(PageColor.value==2)
                                                3
                                            else
                                                1
                                            ValColor[index]=if(PageColor.value==1)
                                                3
                                            else if(PageColor.value==2)
                                                0
                                            else
                                                1
                                            Grid2[index] =
                                                if (ValColor[index] == 3)
                                                    3
                                                else if(ValColor[index]==1)
                                                    1
                                                else
                                                    0
                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            Turn.value=if(Turn.value==1)
                                                2
                                            else if(Turn.value==2)
                                                3
                                            else
                                                1
                                            GridVal[index] += 1
                                        }
                                         else if(P2Score.value==0 && P1Cnt.value>0){
                                             PageColor.value=if(PageColor.value==0)
                                                 2
                                             else if(PageColor.value==2)
                                                 3
                                             else
                                                 0
                                             ValColor[index]=if(PageColor.value==0)
                                                 3
                                             else if(PageColor.value==2)
                                                 2
                                             else
                                                 1
                                             Grid2[index] =
                                                 if (ValColor[index] == 3)
                                                     3
                                                 else if(ValColor[index]==1)
                                                     1
                                                 else
                                                     2
                                             if (Grid3[index] == -1) {
                                                 Grid3[index] = Grid2[index]
                                             }
                                             Turn.value=if(Turn.value==0)
                                                 2
                                             else if(Turn.value==2)
                                                 3
                                             else
                                                 0
                                             GridVal[index] += 1
                                         }
                                        else if(P3Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=if(PageColor.value==0)
                                                1
                                            else if(PageColor.value==1)
                                                3
                                            else
                                                0
                                            ValColor[index]=if(PageColor.value==0)
                                                3
                                            else if(PageColor.value==1)
                                                2
                                            else
                                                0
                                            Grid2[index] =
                                                if (ValColor[index] == 3)
                                                    3
                                                else if(ValColor[index]==2)
                                                    2
                                                else
                                                    0
                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            Turn.value=if(Turn.value==0)
                                                1
                                            else if(Turn.value==1)
                                                3
                                            else
                                                0
                                            GridVal[index] += 1
                                        }
                                        else if(P4Score.value==0 && P1Cnt.value>0){
                                            PageColor.value=
                                                if(PageColor.value==0)
                                                1
                                            else if(PageColor.value==1)
                                                2
                                            else
                                                0
                                            ValColor[index]=
                                                if(PageColor.value==0)
                                                    1
                                                else if(PageColor.value==1)
                                                    2
                                                else
                                                    0
                                            Grid2[index] =
                                                if (ValColor[index] == 2)
                                                    2
                                                else if(ValColor[index]==1)
                                                    1
                                                else
                                                    0
                                            if (Grid3[index] == -1) {
                                                Grid3[index] = Grid2[index]
                                            }
                                            Turn.value=if(Turn.value==0)
                                                1
                                            else if(Turn.value==1)
                                                2
                                            else
                                                0
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
                        if (playerNum.value == 3){
                            if (P1Score.value == 0 && P1Cnt.value > 0 && counter == 0) {
                                PageColor.value =
                                    if (PageColor.value == 0)
                                        1
                                    else
                                        2

                                Turn.value = if (Turn.value == 0)
                                    1
                                else
                                    2
                                counter += 1
                            } else if (P2Score.value == 0 && P1Cnt.value > 0 && counter == 0) {
                                PageColor.value =
                                    if (PageColor.value == 1)
                                        2
                                    else
                                        0
                                Turn.value = if (Turn.value == 1)
                                    2
                                else
                                    0
                                counter += 1
                            } else if (P3Score.value == 0 && P1Cnt.value > 0 && counter == 0) {
                                PageColor.value =
                                    if (PageColor.value == 2)
                                        0
                                    else
                                        1
                                Turn.value = if (Turn.value == 2)
                                    0
                                else
                                    1
                                counter += 1
                            }
                    }
                        else if(playerNum.value==4){

                            if(P1Score.value==0 && P1Cnt.value>0 ){
                                PageColor.value=if(PageColor.value==0)
                                    1
                                else
                                    PageColor.value
                                Turn.value=if(Turn.value==0)
                                    1
                                else
                                    Turn.value

                            }
                            if(P2Score.value==0 && P1Cnt.value>0 ){
                                PageColor.value=if(PageColor.value==1)
                                    2
                                else
                                    PageColor.value
                                Turn.value=if(Turn.value==1)
                                    2
                                else
                                    Turn.value

                            }
                            if(P3Score.value==0 && P1Cnt.value>0){
                                PageColor.value=if(PageColor.value==2)
                                    3
                                else
                                    PageColor.value
                                Turn.value=if(Turn.value==2)
                                    3
                                else
                                    Turn.value
                            }
                            if(P4Score.value==0 && P1Cnt.value>0){
                                PageColor.value=if(PageColor.value==3)
                                    0
                                else
                                    PageColor.value
                                Turn.value=if(Turn.value==3)
                                    0
                                else
                                    Turn.value
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

                        }
                        else if (Grid[index] == 1 && ValColor[index] == 0 && Grid3[index] == 0
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

                        if(playerNum.value==4){
                           if (Grid[index] == 1 && ValColor[index] == 3 && Grid3[index] == 3
                            ) {
                                if (GridVal[index] != 0) {
                                    Image(
                                        painter = painter4, contentDescription = "yellowcircle",
                                        modifier = Modifier.size(55 .dp)
                                    )
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
        if(((P1Score.value==0 && P2Score.value==0 && P3Score.value==0 && (P4Score.value!=0 || playerNum.value==3))||
            (P1Score.value==0 && P2Score.value==0 && P3Score.value!=0 && (P4Score.value==0 || playerNum.value==3))||
            (P1Score.value==0 && P2Score.value!=0 && P3Score.value==0 && (P4Score.value==0 || playerNum.value==3))||
            (P1Score.value!=0 && P2Score.value==0 && P3Score.value==0 && (P4Score.value==0 || playerNum.value==3)))
            &&(P1Cnt.value>0)){
            if(P1Score.value!=0 ){
                name= player1Name.value
            }
            else if(P2Score.value!=0){
                name= player2Name.value
            }
            else if(P3Score.value!=0){
                name= player3Name.value
            }
            else{
                name= player4Name.value
            }
            AlertDialog(onDismissRequest = {

            }, confirmButton = { /*TODO*/ },
                containerColor =  Color(60,64,117,255),
                modifier = Modifier.size(height=350.dp,width=250.dp),
                iconContentColor =Color(193,232,250,255),
                text={
                    Column (
                    ){  Box(contentAlignment = Alignment.Center,
                        modifier=Modifier
                            .clip(shape = RoundedCornerShape(25.dp))
                            .size(width=240.dp,height=60.dp)
                            .background(color = Color(255,255,255,255))
                            .offset(0.dp,-10.dp)){

                        Text(name.toUpperCase(),
                            color = Color.Black,
//                                    modifier=Modifier
//                                        .offset(15.dp,5.dp),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )

                    }
                        Image(painter=painter5,
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

                            Button(onClick = {
                                P1Cnt.value=-1
                                P2Cnt.value=-1
                                P3Cnt.value=-1
                                P4Cnt.value=-1
                                PageColor.value=0
                                var list= mutableListOf<Int>(tile.value*tile.value)
                                var list1= mutableListOf<Int>(tile.value*tile.value)
                                var list2= mutableListOf<Int>(tile.value*tile.value)
                                var list7= mutableListOf<Int>(tile.value*tile.value)
                                var list8= mutableListOf<Int>(tile.value*tile.value)
                                Turn.value=0

                                for (i in 0..tile.value*tile.value-1){
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
                            Button(onClick = { navigateToMultiplayer()
                                player2Name.value=""
                                player1Name.value=""
                                P1Cnt.value=-1
                                P2Cnt.value=-1
                                P3Cnt.value=-1
                                P4Cnt.value=-1
                                PageColor.value=0
                                var list= mutableListOf<Int>(tile.value*tile.value)
                                var list1= mutableListOf<Int>(tile.value*tile.value)
                                var list2= mutableListOf<Int>(tile.value*tile.value)
                                var list7= mutableListOf<Int>(tile.value*tile.value)
                                var list8= mutableListOf<Int>(tile.value*tile.value)
                                Turn.value=0

                                for (i in 0..tile.value*tile.value-1){
                                    Grid[i]=0
                                    GridVal[i]=0
                                    Grid2[i]=-1
                                    Grid3[i]=-1
                                    ValColor[i]=-1
                                }
                            },
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
                    Text(P4Score.value .toString(),
                        color= Color(226, 223, 45),
                        modifier = Modifier
                            .padding(16.dp)
                            .offset(120.dp, 0.dp),
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
                        .offset(120.dp, 0.dp),
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
                        .padding(16.dp),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}