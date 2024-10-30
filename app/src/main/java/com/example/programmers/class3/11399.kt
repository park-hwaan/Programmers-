package com.example.programmers

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }.sorted()
    var result = 0

    for (i in 0 until list.size){
       for(j in 0..i){
           result += list[j]
       }
    }

    println(result)

}