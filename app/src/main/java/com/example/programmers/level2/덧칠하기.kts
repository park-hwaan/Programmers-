package com.example.programmers.level2

val n = 8
val m = 4
val section = intArrayOf(2,3,6)
var answer = 0
var end = 0

section.forEach { if(it > end){ end = it + m - 1; answer++}   }

println(answer)


