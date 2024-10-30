package com.example.programmers

fun main(){
    val reader = System.`in`.bufferedReader()

    while (true){
        val n = reader.readLine().toInt()
        if(n == 0) break

        val charArray = n.toString().toCharArray()
        var reverse = charArray.reversed().toCharArray()

        if(charArray.contentEquals(reverse)){
            println("yes")
        }else println("no")
    }
}