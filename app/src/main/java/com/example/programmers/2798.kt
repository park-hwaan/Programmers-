package com.example.programmers

fun main(){
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().split(" ").map { it.toInt() }
    var maxNum = n[1]
    val numbers = reader.readLine().split(" ").map { it.toInt() }.sorted()
    var sumList = mutableListOf<Int>()

    for (one in 0 until numbers.size){
        for(two in one+1 until numbers.size){
            for(three in two+1 until numbers.size){
                sumList += numbers[one] + numbers[two] + numbers[three]
            }
        }
    }

    val newSumList = sumList.filter { it <= maxNum }

    println(newSumList.last())


}