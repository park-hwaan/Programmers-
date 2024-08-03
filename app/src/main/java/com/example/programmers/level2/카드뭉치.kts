package com.example.programmers.level2

var cards1 = arrayListOf<String>("i", "water", "drink")
var cards2 = arrayListOf<String>("want", "to")
var goal = arrayListOf<String>("i", "want", "to", "drink", "water")
var answer = "yes"
var i = 0
var j = 0

goal.forEach {
    if (it == cards1[i]) {
        if(i < cards1.size - 1){
            i++
        }
    } else if (it == cards2[j]) {
       if(j < cards2.size - 1){
           j++
       }
    } else answer = "no"

}

println(answer)

println(cards2.size)

