package com.example.programmers.leve1

val a = 10
val b = 12
val ab = "$a$b".toInt()
val ba = "$b$a".toInt()
var answer  = 0
if (ab < ba) {answer = ba} else {answer = ab}
println(answer)
