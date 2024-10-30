package com.example.programmers

fun main(){
    val (A,B,V) = readLine()!!.split(" ").map { it.toInt() }

    val days = (V - B + (A - B) - 1) / (A - B)
    println(days)
}