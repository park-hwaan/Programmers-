package com.example.programmers

fun main(){
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().split(" ").map { it.toInt() }
    var maxNum = n[1]
    val numbers = reader.readLine().split(" ").map { it.toInt() }.sorted()
    var sumList = mutableListOf<Int>()

    for (one in 0 until numbers.size -1){
        for(two in one+1 until numbers.size-2){
            for(three in two+1 until numbers.size-3){
                sumList += numbers[one] + numbers[two] + numbers[three]
            }
        }
    }

    val newSumList = sumList.filter { it <= maxNum }
    println(newSumList)

    println(newSumList.last())


}