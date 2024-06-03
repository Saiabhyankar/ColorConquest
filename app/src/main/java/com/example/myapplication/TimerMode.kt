package com.example.myapplication

import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TimerMode(navigateToTimerMode:()->Unit) {
    val context3 = LocalContext.current
    val mediaPlayer =  MediaPlayer.create(context3, R.raw.wrong_move)
    var Tot=0
    var enabled by remember {
        mutableStateOf(false)
    }
    var flag by remember {
        mutableStateOf(false)
    }
    var painter3 = painterResource(id = R.drawable.winnericon)

    var timerContinue by remember {
        mutableStateOf(false)
    }
    var timeB by remember {
        mutableStateOf(60)
    }
    var timeR by remember {
        mutableStateOf(60)
    }
    var totTimeR by remember {
        mutableStateOf(60f)
    }
    var totTimeB by remember {
        mutableStateOf(60f)
    }
    var fractionB =( timeB / totTimeB )
    var fractionR = (timeR / totTimeR )
    var isGameFinished by remember { mutableStateOf(false) }
    var namel by remember{
        mutableStateOf("")
    }
    var painter4 = painterResource(id = R.drawable.reset)
    var painter5 = painterResource(id = R.drawable.exit)
    LaunchedEffect(key1 = Turn.value) {
        while (!isGameFinished) {
            if (Turn.value == 0 && timeR > 0) {
                delay(1000L)
                timeR--
            } else if (Turn.value == 1 && timeB > 0) {
                delay(1000L)
                timeB--
            }
            if (timeR == 0 || timeB == 0 || timerContinue) {
                isGameFinished = true
            }
        }
    }

    tile.value = 5
    var list = mutableListOf<Int>(25)
    var list1 = mutableListOf<Int>(25)
    var list2 = mutableListOf<Int>(25)
    var context = LocalContext.current
    val context1 = LocalContext.current
    var painter2 = painterResource(id = R.drawable.bluecircle)
    var sizeR = 85 - (tile.value * tile.value)
    var sizeB = 75 - (tile.value * tile.value)
    var painter1 = painterResource(id = R.drawable.redcircle)

    var list3 = mutableListOf<Int>(tile.value - 1)
    for (i in 1..tile.value - 1) {
        list3.add(i)
    }
    var list4 = mutableListOf<Int>(tile.value - 1)
    for (i in (2 * tile.value) - 1..(((tile.value - 1) * (tile.value)) - 1) step tile.value) {
        list4.add(i)
    }
    var list5 = mutableListOf<Int>(tile.value - 1)
    for (i in tile.value..tile.value * (tile.value - 2) step tile.value) {
        list5.add(i)
    }
    var list6 = mutableListOf<Int>(tile.value - 1)
    for (i in (((tile.value - 1) * (tile.value)) + 1)..(((tile.value - 1) * (tile.value)) + tile.value - 2)) {
        list6.add(i)
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
    fun GridLogic(index: Int) {
        if ((GridVal[index] > 3 && P1Cnt.value > 0)) {
            if (listOf(
                    0,
                    tile.value - 1,
                    tile.value * tile.value - 1,
                    tile.value * tile.value - tile.value
                ).contains(index)
            ) {
                if (index == 0) {
                    GridVal[index] = 0
                    GridVal[index + 1] += 1
                    Grid[index + 1] = 1
                    GridVal[index + tile.value] += 1
                    Grid[index + tile.value] = 1
                    ValColor[index + 1] = ValColor[index]
                    ValColor[index + tile.value] = ValColor[index]
                    Grid3[index + 1] = Grid3[index]
                    Grid3[index + tile.value] = Grid3[index]
                } else if (index == tile.value - 1) {
                    GridVal[index] = 0

                    GridVal[index - 1] += 1
                    Grid[index - 1] = 1
                    GridVal[index + tile.value] += 1
                    Grid[index + tile.value] = 1
                    ValColor[index - 1] = ValColor[index]
                    ValColor[index + tile.value] = ValColor[index]
                    Grid3[index - 1] = Grid3[index]
                    Grid3[index + tile.value] = Grid3[index]


                } else if (index == tile.value * tile.value - tile.value) {
                    GridVal[index] = 0

                    GridVal[index + 1] += 1
                    Grid[index + 1] = 1
                    GridVal[index - tile.value] += 1
                    Grid[index - tile.value] = 1
                    ValColor[index + 1] = ValColor[index]
                    ValColor[index - tile.value] = ValColor[index]
                    Grid3[index + 1] = Grid3[index]
                    Grid3[index - tile.value] = Grid3[index]

                } else {
                    GridVal[index] = 0
                    GridVal[index - 1] += 1
                    Grid[index - 1] = 1

                    GridVal[index - tile.value] += 1
                    Grid[index - tile.value] = 1


                    ValColor[index - 1] = ValColor[index]
                    ValColor[index - tile.value] = ValColor[index]

                    Grid3[index - 1] = Grid3[index]
                    Grid3[index - tile.value] = Grid3[index]
                }

            } else if (list3.contains(index)) {
                GridVal[index] = 0

                GridVal[index + 1] += 1
                Grid[index + 1] = 1
                GridVal[index - 1] += 1
                Grid[index - 1] = 1
                GridVal[index + tile.value] += 1
                Grid[index + tile.value] = 1
                ValColor[index + 1] = ValColor[index]
                ValColor[index - 1] = ValColor[index]
                ValColor[index + tile.value] = ValColor[index]
                Grid3[index + tile.value] = Grid3[index]
                Grid3[index + 1] = Grid3[index]
                Grid3[index - 1] = Grid3[index]
            } else if (list5.contains(index)) {
                GridVal[index] = 0

                GridVal[index + 1] += 1
                GridVal[index - tile.value] += 1
                GridVal[index + tile.value] += 1
                Grid[index + 1] = 1
                Grid[index - tile.value] = 1
                Grid[index + tile.value] = 1
                ValColor[index + 1] = ValColor[index]
                ValColor[index - tile.value] = ValColor[index]
                ValColor[index + tile.value] = ValColor[index]
                Grid3[index + 1] = Grid3[index]
                Grid3[index + tile.value] = Grid3[index]
                Grid3[index - tile.value] = Grid3[index]
            } else if (list6.contains(index)) {
                GridVal[index] = 0

                GridVal[index - 1] += 1
                GridVal[index - tile.value] += 1
                GridVal[index + 1] += 1
                Grid[index - 1] = 1
                Grid[index - tile.value] = 1
                Grid[index + 1] = 1
                ValColor[index + 1] = ValColor[index]
                ValColor[index - 1] = ValColor[index]
                ValColor[index - tile.value] = ValColor[index]
                Grid3[index + 1] = Grid3[index]
                Grid3[index - tile.value] = Grid3[index]
                Grid3[index - 1] = Grid3[index]
            } else if (list4.contains(index)) {
                GridVal[index] = 0

                GridVal[index - 1] += 1
                GridVal[index - tile.value] += 1
                GridVal[index + tile.value] += 1
                Grid[index - 1] = 1
                Grid[index - tile.value] = 1
                Grid[index + tile.value] = 1
                ValColor[index - 1] = ValColor[index]
                ValColor[index - tile.value] = ValColor[index]
                ValColor[index + tile.value] = ValColor[index]
                Grid3[index - 1] = Grid3[index]
                Grid3[index + tile.value] = Grid3[index]
                Grid3[index - tile.value] = Grid3[index]
            } else {
                GridVal[index] = 0

                GridVal[index + tile.value] += 1
                GridVal[index + 1] += 1
                GridVal[index - tile.value] += 1
                GridVal[index - 1] += 1
                Grid[index + tile.value] = 1
                Grid[index + 1] = 1
                Grid[index - tile.value] = 1
                Grid[index - 1] = 1
                ValColor[index + 1] = ValColor[index]
                ValColor[index - 1] = ValColor[index]
                ValColor[index + tile.value] = ValColor[index]
                ValColor[index - tile.value] = ValColor[index]
                Grid3[index + 1] = Grid3[index]
                Grid3[index + tile.value] = Grid3[index]
                Grid3[index - 1] = Grid3[index]
                Grid3[index - tile.value] = Grid3[index]

            }
        }

    }

    fun GamePoint() {
        P1Score.value = 0
        P2Score.value = 0
        for (i in 0..((tile.value) * (tile.value) - 1)) {

            if (ValColor[i] == 0) {
                P1Score.value += GridVal[i]
            } else if (ValColor[i] == 1) {
                P2Score.value += GridVal[i]
            }
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
                                PageColor.value = 0
                                var list = mutableListOf<Int>(tile.value * tile.value)
                                var list1 = mutableListOf<Int>(tile.value * tile.value)
                                var list2 = mutableListOf<Int>(tile.value * tile.value)
                                Turn.value = 0
                                P2Win.value = 0
                                P1Win.value = 0
                                Tot = 0
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
                            painter = painter4, contentDescription = "reset",
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
                            painter = painter5, contentDescription = "exit",
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
                            navigateToTimerMode()
                            DialogBox2.value = false
                            player1Name.value = ""
                            player2Name.value = ""
                            P1Cnt.value = -1
                            P2Cnt.value = -1
                            PageColor.value = 0
                            P2Win.value = 0
                            P1Win.value = 0
                            Tot = 0
                            var list = mutableListOf<Int>(tile.value * tile.value)
                            var list1 = mutableListOf<Int>(tile.value * tile.value)
                            var list2 = mutableListOf<Int>(tile.value * tile.value)
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

        Box(

        ) {
            Column {
                Card(
                    shape = RoundedCornerShape(40.dp, 40.dp, 40.dp, 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(46, 50, 58, 255)),
                    modifier = Modifier
                        .offset(-100.dp, 0.dp)
                        .size(height = 60.dp, width = 180.dp),
                    border = BorderStroke(5.dp, Color(1, 0, 1, 255))


                ) {
                    Text(
                        (P2Win.value).toString(),
                        color = Color(47, 183, 241, 255),
                        modifier = Modifier
                            .padding(16.dp)
                            .offset(120.dp, 0.dp)
                            .rotate(180f),
                        textAlign = TextAlign.Right,
                        fontSize = 24.sp,

                        )
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
                Spacer(modifier = Modifier.padding(16.dp))
                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .width(250.dp)
                        .offset(50.dp, -30.dp)
                        .border(2.dp, Color.Black, shape = RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)

                ) {
                    Row(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(fractionB + 0.0000000001f)
                                .fillMaxHeight()
                                .background(Color(47, 183, 241, 255))
                        )
                        Box(
                            modifier = Modifier
                                .weight(0.0000011f + (1 - fractionB))
                                .fillMaxHeight()
                                .background(Color.White)
                        )
                    }
                }
                Text(timeB.toString(),
                    modifier = Modifier
                        .offset(60.dp,-67.dp),
                    color=Color.White)
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
                shape = RoundedCornerShape(40.dp, 40.dp, 40.dp, 30.dp),
                colors = CardDefaults.cardColors(containerColor = Color(46, 50, 58, 255)),
                border = BorderStroke(5.dp, Color(1, 0, 1, 255)),
                modifier = Modifier
                    .offset(95.dp, 0.dp)
                    .size(height = 60.dp, width = 180.dp)

            ) {
                Text(
                    (P1Win.value).toString(),
                    color = Color(255, 94, 86, 255),
                    modifier = Modifier
                        .padding(12.dp)
                        .offset(14.dp, 0.dp),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
            Card(
                shape = CutCornerShape(5.dp, 135.dp, 135.dp, 5.dp),
                colors = CardDefaults.cardColors(containerColor = Color(46,50,58,255)),

                border = BorderStroke(2.dp, Color(1,0,1,255)),
                modifier= Modifier
                    .offset(-100.dp, -5.dp)
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .size(height = 300.dp, width = 350.dp)
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(tile.value)) {
                items(tile.value * tile.value) { index ->
                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        Button(
                            shape = RoundedCornerShape(10),

                            onClick = {

                                if (Grid[index] == 1 && (P1Cnt.value >= 0 && GridVal[index] != 0) && !(index in list1)) {
                                    list.add(index)
                                }
                                if (Grid3[index] == 0 && Grid[index] == 1) {
                                    list1.add(index)
                                } else if (Grid3[index] == 1 && Grid[index] == 1) {
                                    list2.add(index)
                                }
                                if ( ((P1Cnt.value >0 || P2Cnt.value==0) ) && ((index !in list) || (Turn.value==0 && index !in list1)||(Turn.value==1 && index !in list2)) ){
                                    Toast.makeText(
                                        context, "Invalid Option",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    mediaPlayer.start()
                                }
                                if ((index in list || P1Cnt.value == -1 || P2Cnt.value == -1)) {
                                    if (((Turn.value == 0 && index in list1) || P1Cnt.value == -1) || (P2Cnt.value == -1 && !(index in list1) || (Turn.value == 1 && index in list2))) {
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
                        }

                        if (Grid[index] == 1 && ValColor[index] == 0 && Grid3[index] == 0) {
                            if (GridVal[index] != 0) {
                                Image(
                                    painter = painter1, contentDescription = "redcircle",
                                    modifier = Modifier.size(sizeR.dp),
                                )
                                Text(
                                    GridVal[index].toString(),
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }

                        } else if (Grid[index] == 1 && ValColor[index] == 1 && Grid3[index] == 1
                        ) {
                            if (GridVal[index] != 0) {
                                Image(
                                    painter = painter2, contentDescription = "bluecircle",
                                    modifier = Modifier.size(sizeB.dp)
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
            Column(
                modifier = Modifier
                    .offset(150.dp, 250.dp)
            ) {

                Spacer(
                    modifier = Modifier
                        .padding(8.dp)
                )
                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .width(250.dp)
                        .offset(-100.dp, -10.dp)
                        .border(2.dp, Color.Black, shape = RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(fractionR + 0.0000000001f)
                                .fillMaxHeight()
                                .background(Color(255, 94, 86, 255))
                        )
                        Box(
                            modifier = Modifier
                                .weight(0.0000001f + 1 - fractionR)
                                .fillMaxHeight()
                                .background(Color.White)
                        )
                    }
                }
                Text(timeR.toString(),
                    color=Color.White,
                    modifier = Modifier
                        .offset(-85.dp,-50.dp))
                Spacer(
                    modifier = Modifier
                        .padding(8.dp)
                )


            }
        }

    if(((P1Score.value==0 || P2Score.value==0 )&& P1Cnt.value>0)||timeR==0||timeB==0){
        if(P1Score.value==0 || timeR==0){
            name= player2Name.value
            namel= player1Name.value
        }
        else if (P2Score.value==0 || timeB==0){
            name= player1Name.value
            namel= player2Name.value
        }
        enabled=true

        wScore=if(P1Score.value==0) P2Score.value else P1Score.value

        if(P1Score.value==0) {
            if(Tot<= matchNumber.value)
                P2Win.value+=1
        }
        else if(P2Score.value==0){
            if(Tot<= matchNumber.value)
                P1Win.value+=1
        }
        Tot=P1Win.value+P2Win.value
        if((Tot>= matchNumber.value)||(P1Win.value== (matchNumber.value/2)+1)||(P2Win.value==(matchNumber.value)/2+1)){
            flag=true
        }
        else{
            flag=false
        }
        if(flag){
            timerContinue=true
            writeToSharedPref(context1,"name",name,"TimerMode")
            writeToSharedPref(context1,"score", wScore.toString(),"TimerMode")
            AlertDialog(onDismissRequest = {

            }, confirmButton = { /*TODO*/ },
                containerColor =  Color(60,64,117,255),
                modifier = Modifier.size(height=350.dp,width=250.dp),
                iconContentColor =Color(193,232,250,255),
                text={
                    Column (
                    ){  Box(contentAlignment = Alignment.Center,
                        modifier= Modifier
                            .clip(shape = RoundedCornerShape(25.dp))
                            .size(width = 240.dp, height = 60.dp)
                            .background(color = Color(255, 255, 255, 255))
                            .offset(0.dp, -10.dp)){

                        Text(name.toUpperCase(),
                            color = Color.Black,
//                                    modifier=Modifier
//                                        .offset(15.dp,5.dp),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )

                    }
                        Image(painter=painter3,
                            contentDescription = "i",
                            modifier = Modifier
                                .size(50.dp)
                                .offset(75.dp, 40.dp)

                        )
                        Text("WINS !!",
                            color=Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .offset(60.dp,60.dp))
                        Column {

                            Button(onClick = {
                                timeR=60
                                timeB=60
                                totTimeB=60f
                                totTimeR=60f
                                P1Cnt.value=-1
                                P2Cnt.value=-1
                                PageColor.value=0
                                var list= mutableListOf<Int>(tile.value*tile.value)
                                var list1= mutableListOf<Int>(tile.value*tile.value)
                                var list2= mutableListOf<Int>(tile.value*tile.value)
                                Turn.value=0
                                P2Win.value=0
                                P1Win.value=0
                                Tot=0
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
                            Button(onClick = { navigateToTimerMode()
                                P1Cnt.value=-1
                                P2Cnt.value=-1
                                PageColor.value=0
                                player2Name.value=""
                                player1Name.value=""
                                var list= mutableListOf<Int>(tile.value*tile.value)
                                var list1= mutableListOf<Int>(tile.value*tile.value)
                                var list2= mutableListOf<Int>(tile.value*tile.value)
                                Turn.value=0
                                P2Win.value=0
                                P1Win.value=0
                                Tot=0
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
        else if(Tot< matchNumber.value){
            timerContinue=false
            timeR=60
            timeB=60
            totTimeB=60f
            totTimeR=60f

            if(name == player1Name.value){
                totTimeB+=15
                timeB+=15
            }
            else if(name== player2Name.value){
                totTimeR+=15
                timeR+=15
            }

            P1Cnt.value=-1
            P2Cnt.value=-1
            PageColor.value=0
            var list= mutableListOf<Int>(tile.value*tile.value)
            var list1= mutableListOf<Int>(tile.value*tile.value)
            var list2= mutableListOf<Int>(tile.value*tile.value)
            Turn.value=0
            for (i in 0..tile.value*tile.value-1){
                Grid[i]=0
                GridVal[i]=0
                Grid2[i]=-1
                Grid3[i]=-1
                ValColor[i]=-1
            }
        }
    }

}

