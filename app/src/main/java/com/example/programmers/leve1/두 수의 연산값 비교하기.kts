package com.example.programmers.leve1

val a = 10
val b = 12
var answer = 0
val ab = "$a$b".toInt()
val ba = 2 * a * b
if(ab < ba){ answer = ba} else answer = ab
println(answer)

