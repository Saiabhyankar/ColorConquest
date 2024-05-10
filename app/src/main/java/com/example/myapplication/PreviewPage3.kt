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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun PreviewPage3() {
    var painter = painterResource(id = R.drawable.appdev3)


//    @Composable
//    fun GridLogic(it: Int) {
//        if (Grid[it] == 1) {
//            if (GridVal[it] == 4)
//        }
//    }
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
                .offset(350.dp)
                .padding(12.dp)
        ) {
            Text("X")
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

    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(5)) {
            items(25) { index ->
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(244, 228, 206, 255)),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            Grid[index] = 1
                            PageColor.value = if (PageColor.value == 0) 1 else 0
                            ValColor.value = if (PageColor.value == 0) 0 else 1
                            Grid2[index] = if (ValColor.value == 0) 0 else 1
                            if (ValColor.value == 0) {
                                P1Cnt.value += 1

                            } else {

                                P2Cnt.value += 1
                            }
                            if(ValColor.value==0){
                                if(P1Cnt.value==0){
                                    GridVal[index]=3
                                }
                                else{
                                    GridVal[index]=1
                                }
                            }
                            else{
                                if(P2Cnt.value==0){
                                    GridVal[index]=3
                                }
                                else{
                                    GridVal[index]=1
                                }
                            }


                        },
                        modifier = Modifier.shadow(
                            elevation = 86.dp,
                            shape = RoundedCornerShape(16.dp)
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                244,
                                228,
                                206,
                                255
                            )
                        )
                    ) {
                        if (Grid[index] == 1) {
                            if(Grid2[index]==1){
                                if(P1Cnt.value==0){
                                    Text(
                                        GridVal[index].toString(),
                                        color = Color(255, 94, 86, 255))

                                }
                                else if(P1Cnt.value>1){
                                    Text(
                                        GridVal[index].toString(),
                                                color = Color(255, 94, 86, 255)
                                    )

                                }
                            }
                            else{
                                if(P2Cnt.value==0){
                                    Text(
                                        GridVal[index].toString(),
                                        color =  Color(47, 183, 241, 255)
                                    )

                                }
                                else if(P2Cnt.value>1){
                                    Text(Grid2[index].toString(),
                                        color = Color(47, 183, 241, 255))
                                }
                            }

                        }
                    }
                }


//        LazyVerticalGrid(columns = GridCells.Fixed(5),content={
//            items(25){
//                Box(modifier = Modifier
//                    .padding(4.dp)
//                    .aspectRatio(1f)
//                    .clip(RoundedCornerShape(16.dp))
//                    .background((Color(244, 228, 206, 255)))
//                    ,
//                    contentAlignment = Alignment.Center
//                ){
//
//                    Button(onClick = {Grid[it]=1
//                        PageColor.value=if(PageColor.value==0) 1 else 0
//                        ValColor.value=if(PageColor.value==0) 1 else 0
//                        PlayerTurn.value=if(PageColor.value==0) 1 else 0
//                        Grid2[it]=if(PageColor.value==0) 1 else 0
//
//
//                    },
//                        modifier=Modifier.shadow(elevation = 86.dp, shape = RoundedCornerShape(16.dp)),
//                        colors = ButtonDefaults.buttonColors(containerColor = Color(244, 228, 206, 255)),
//
//                        ){
//                        if(Grid[it]==1)
//                        Text(it.toString(),
//                            color=Color.Blue
//                        )
//
//                    }
//
//
//
//                }
//            }
//
//
//        })
            }
        }
    }
}











