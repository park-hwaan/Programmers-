package com.example.programmers

import java.util.*

fun main(){
    val reader = System.`in`.bufferedReader()

    val n = reader.readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()

    repeat(n){
        val st = StringTokenizer(reader.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        list.add(Pair(a, b))
    }

    val newList = list.sortedWith(compareBy({it.second}, {it.first}))

    newList.forEach {
        println("${it.first} ${it.second}")
    }

}