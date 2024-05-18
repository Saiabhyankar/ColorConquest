package com.example.myapplication

import android.graphics.drawable.Icon
import android.service.autofill.Validators.and
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.ArrayList

@Composable
fun PreviewPage3() {
    var painter = painterResource(id = R.drawable.appdev3)
    var list= mutableListOf<Int>()
    fun GridLogic(index: Int) {
        if ((GridVal[index] > 3 && P1Cnt.value > 0)) {



            if (listOf(0, 4, 24, 20).contains(index)) {

                if (GridVal[index] > 3 && P1Cnt.value > 0) {
                    GridVal[index] = 0

                    if (index == 0) {
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
                    GridVal[index + 5] + 1
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
                    ValColor[index+1]= ValColor[index]
                    ValColor[index-5]= ValColor[index]
                    ValColor[index+5]= ValColor[index]
                    Grid3[index+1]=Grid3[index]
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
            onClick = { /*TODO*/ },
            modifier = Modifier
                .offset(300.dp)
                .padding(6.dp)
                .height(50.dp)
                .width(50.dp)
        ) {
            Text("X",textAlign=TextAlign.Center)
        }
        Row() {
            Card() {}
            Card() {}
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp) // Add padding for better visibility
            .height(200.dp)
        //.border(width = 2.dp, color = Color.Black)

    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(5)) {
            items(25) { index ->
                Button(

                        onClick = {
                            if(P1Cnt.value==-1 || P2Cnt.value==-1){
                                index in listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24)
                            }
                            else{
                                for (i in 0..24){
                                    if(Grid[i]==1){
                                        list.add(index)
                                    }
                                }
                                index in list
                            }

                            if (Grid[index] == 0) {
                                PageColor.value = if (PageColor.value == 0) 1 else 0
                                Grid[index] = 1
                                ValColor[index] = if (PageColor.value == 0) 1 else 0
                                Grid2[index] = if (ValColor[index] == 0) 0 else 1

                                if (Grid3[index] == -1) {
                                    Grid3[index] = Grid2[index]
                                    ButtonState[index] = Grid2[index]
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
//                            else  (){
                                    //if(index in list){
//                                    PageColor.value = if (PageColor.value == 0) 1 else 0
//
//                                    ValColor[index] = if (PageColor.value == 0) 1 else 0
//                                    Grid2[index] = if (ValColor[index] == 0) 0 else 1
//
//                                    if (Grid3[index] == -1) {
//                                        Grid3[index] = Grid2[index]
//                                        ButtonState[index] = Grid2[index]
//                                    }
//                                    if (ValColor[index] == 0) {
//                                        P1Cnt.value += 1
//
//                                    } else {
//
//                                        P2Cnt.value += 1
//                                    }
//                                    if (ValColor[index] == 0) {
//                                        if (P1Cnt.value == 0) {
//                                            GridVal[index] = 3
//                                        } else {
//                                            GridVal[index] += 1
//                                        }
//                                    } else {
//                                        if (P2Cnt.value == 0) {
//                                            GridVal[index] = 3
//                                        } else {
//                                            GridVal[index] += 1
//                                        }
//
//
//                                }
//                            }
                                  //                            }

                        }

                    ,
                    modifier = Modifier
                        .padding(0.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(16.dp))
                        .shadow(elevation = 0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(244, 228, 206, 255))

                ) {



                    if(Grid[index]==1 && ValColor[index]==0 && Grid3[index]==0){

                        Text(GridVal[index].toString(),
                            color=Color(255, 94, 86, 255))
                    }
                    else if(Grid[index]==1 && ValColor[index]==1 && Grid3[index]==1
                        ){
                        Text(GridVal[index].toString(),
                            color=Color(47, 183, 241, 255))
                    }


                    GridLogic(index)


                }
            }
        }
    }
}













