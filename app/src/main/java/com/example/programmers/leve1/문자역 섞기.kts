package com.example.programmers.leve1

val s1 = "aaaaa"
val s2 = "bbbbb"
var answer : String = ""
for(i in 0..s1.length-1){
    answer += s1[i]
    answer += s2[i]
}
println(answer)