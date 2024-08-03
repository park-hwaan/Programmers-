package com.example.programmers.level2

var players = arrayListOf<String>("mumu", "soe", "poe", "kai", "mine")
val callings = arrayListOf<String>("kai", "kai", "mine", "mine")
var answer = arrayOf<String>()

for (i in callings.indices){
    val add = callings[i]

    for(i in players.indices){
        if(players[i] == add ){
            players[i] = players[i - 1]
            players[i - 1] = add
        }
    }
}

for(i in callings){
    println()
}





