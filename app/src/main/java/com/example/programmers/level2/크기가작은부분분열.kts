package com.example.programmers.level2

var t = "500220839878"
var p = "7"
var answer = 0

for(i in 0.. (t.length - p.length)){
    val sub = t.substring(i,i + p.length)
    if(sub <= p ){ answer++}
}

println(answer)




