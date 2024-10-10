package com.example.programmers

fun main() = with(System.`in`.bufferedReader()){
    val (N,M) = readLine().split(' ').map { it.toInt() }
    val list = mutableSetOf<String>()
    val set = mutableListOf<String>()

    repeat(N){
        set.add(readLine())
    }

    repeat(M){
        val value = readLine()
        if(set.contains(value)) list.add(value.toString())
    }

    println(list.size.toString())
    list.forEach {
        println(it)
    }
}