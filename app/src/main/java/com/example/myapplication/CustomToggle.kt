package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.theme.Dark
import com.example.myapplication.ui.theme.Light

@Composable
fun CustomToggleButton(
    selected:Boolean,
    onChangeValue:(Boolean)->Unit
){
    Card(
        modifier = Modifier.width(50.dp),
        shape = RoundedCornerShape(16.dp)
    ){
        Box(modifier = Modifier
            .background(
                if (selected) Dark else Light
            )
            .clickable {
                onChangeValue(!selected)
            },
            contentAlignment = if(selected) Alignment.TopEnd else
                Alignment.TopStart){
            CustomCheck()
        }
    }
}
@Composable
fun CustomCheck(

){
    Card(
        modifier = Modifier.size(20.dp)
            .padding(5.dp),
        shape = CircleShape
    ) {
        Box(modifier = Modifier
            .background(Color.White)){

        }
    }
}