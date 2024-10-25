package com.example.programmers

import java.util.*

fun main(){
    val reader = System.`in`.bufferedReader()

    val n = reader.readLine().toInt()
    val list = mutableListOf<Pair<Int, String>>()

    repeat(n){
        val st = StringTokenizer(reader.readLine())
        val age = st.nextToken().toInt()
        val name = st.nextToken().toString()

        list.add(Pair(age, name))
    }

    val sortList = list.sortedWith(compareBy { it.first })

    for (i in sortList.indices){
        println("${sortList[i].first} ${sortList[i].second}")
    }

}