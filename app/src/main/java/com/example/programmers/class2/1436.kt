package com.example.programmers

fun main(){
    val n = readln().toInt()
    var count  = 0
    var number  = 666

    while (count < n){
        if(number.toString().contains("666")){
            count++
        }
        if(count < n ){
            number++
        }
    }

    println(number)



}