package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun TimerMode(navigateToTimerMode:()->Unit){
    var painter= painterResource(id = R.drawable.img)
    Box(){
        Image(painter = painter, contentDescription = "BG")
    }
}