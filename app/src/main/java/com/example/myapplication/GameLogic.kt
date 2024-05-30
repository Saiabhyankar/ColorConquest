package com.example.myapplication

class GameLogic(gridx:Int) {
    var list3= mutableListOf<Int>(tile.value-1)

    var list4= mutableListOf<Int>(tile.value-1)

    var list5= mutableListOf<Int>(tile.value-1)

    var list6= mutableListOf<Int>(tile.value-1)
    init {
        // Populate list3
        for (i in 1 until tile.value) {
            list3.add(i)
        }
        // Populate list4
        for (i in (2 * tile.value - 1) until (tile.value * (tile.value - 1)) step tile.value) {
            list4.add(i)
        }
        // Populate list5
        for (i in tile.value until tile.value * (tile.value - 1) step tile.value) {
            list5.add(i)
        }
        // Populate list6
        for (i in ((tile.value - 1) * tile.value + 1) until ((tile.value - 1) * tile.value + tile.value - 1)) {
            list6.add(i)
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
        for (i in 0 .. ((tile.value)*(tile.value)-1)){

            if(ValColor[i]==0){
                P1Score.value+=GridVal[i]}
            else if(ValColor[i]==1){
                P2Score.value+=GridVal[i]
            }
        }

    }
}