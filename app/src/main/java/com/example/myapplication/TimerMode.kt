package com.example.myapplication

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
    var Tot=0
    var enabled by remember {
        mutableStateOf(false)
    }
    var flag=false
    var painter3 = painterResource(id = R.drawable.appdev6)
    var painter4 = painterResource(id = R.drawable.timermode)
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Transparent),
                    startY = 0.0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
    ) {

        Image(
            painter = painter4,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
        Box(

        ) {
            Column {
                if (Turn.value == 0) {
                    Text(
                        "Red's Turn",
                        color = Color(255, 94, 86, 255)
                    )
                } else {
                    Text(
                        "Blue's Turn",
                        color = Color(47, 183, 241, 255)
                    )
                }
                Spacer(modifier = Modifier.padding(14.dp))
                Card(
                    shape = CutCornerShape(45.dp, 5.dp, 5.dp, 45.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(46, 50, 58, 255)),
                    modifier = Modifier
                        .offset(60.dp, 0.dp)
                        .wrapContentWidth(),
                    border = BorderStroke(2.dp, Color(1, 0, 1, 255))
                ) {
                    Text(
                        player2Name.value.toUpperCase(),
                        color = Color(47, 183, 241, 255),
                        modifier = Modifier
                            .padding(16.dp)
                            .rotate(180f),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.padding(16.dp))
                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .width(250.dp)
                        .offset(50.dp, -30.dp),
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
                                if (!(index in list) && ((P1Cnt.value > 0) || (P2Cnt.value == 0))) {
                                    Toast.makeText(
                                        context, "Invalid Option",
                                        Toast.LENGTH_LONG
                                    ).show()
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
                Card(
                    shape = CutCornerShape(5.dp, 135.dp, 135.dp, 5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(46, 50, 58, 255)),

                    border = BorderStroke(2.dp, Color(1, 0, 1, 255)),
                    modifier = Modifier
                        .offset(-80.dp, 50.dp)
                        .wrapContentWidth()


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
                Spacer(
                    modifier = Modifier
                        .padding(8.dp)
                )
                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .width(250.dp)
                        .offset(-100.dp, 50.dp),
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
                        .offset(-85.dp,10.dp))
                Spacer(
                    modifier = Modifier
                        .padding(8.dp)
                )

            }
        }
    if(((P1Score.value==0 || P2Score.value==0 )&& P1Cnt.value>0)||timeR==0||timeB==0){
        if(P1Score.value==0 || timeR==0){
            name= player2Name.value
        }
        else if (P2Score.value==0 || timeB==0){
            name= player1Name.value
        }
        enabled=true
        timerContinue=true
        wScore=if(P1Score.value==0) P2Score.value else P1Score.value
        if(P1Score.value==0) {
            P2Win+=1
        }
        else if(P2Score.value==0){
            P1Win+=1
        }
        Tot=P1Win+P2Win
        if((Tot>= matchNumber.value)||(P1Win== (matchNumber.value/2)+1)||(P2Win==(matchNumber.value)/2+1)){
            flag=true
        }
        else{
            flag=false
        }
        if(flag){
//            writeToSharedPref(context1,"Name",name,"MysharedPref")
//            writeToSharedPref(context1,"Score",wScore.toString(),"MysharedPref")
            AlertDialog(onDismissRequest = {

            }, confirmButton = { /*TODO*/ },
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
                                P2Win=0
                                P1Win=0
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
                                var list= mutableListOf<Int>(tile.value*tile.value)
                                var list1= mutableListOf<Int>(tile.value*tile.value)
                                var list2= mutableListOf<Int>(tile.value*tile.value)
                                Turn.value=0
                                P2Win=0
                                P1Win=0
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
            if(enabled)
            {
                AlertDialog(onDismissRequest = {enabled=false}, confirmButton = { /*TODO*/ },
                    text={
                        Text("Player 2 has been allocated extra time")
                    })
            }
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

