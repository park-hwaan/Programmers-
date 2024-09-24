package com.example.programmers

fun main(){
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val intArray = ArrayList<Int>()

    repeat(n){
        val num = reader.readLine().toInt()
        if(num == 0){
            intArray.removeLast()
        }else {intArray.add(num)}
    }

    println(intArray.sum())

}