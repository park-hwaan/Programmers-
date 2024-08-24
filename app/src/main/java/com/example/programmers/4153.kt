package com.example.programmers

fun main(){
    val arr = readln().split(" ").map { it.toInt() * it.toInt() }.sorted()
    if(arr.contains(0)) println("wrong")
    else {
        if (arr[0] + arr[1] == arr[2]) {println("right")}
        else println("wrong")
    }
}