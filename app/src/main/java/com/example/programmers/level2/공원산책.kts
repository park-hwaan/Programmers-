package com.example.programmers.level2

val park = arrayListOf<String>("SOO","OOO","OOO")
val routes = arrayListOf<String>("E 2","S 2","W 1")
var answer = intArrayOf()

val map = routes.associate {
    val (direction, value) = it.split(" ")
    direction to value.toInt()
}

for (i in park.indices){
   
}



