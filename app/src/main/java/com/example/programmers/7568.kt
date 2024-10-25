package com.example.programmers

import java.util.StringTokenizer

fun main(){
    val reader = System.`in`.bufferedReader()

    val n = reader.readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    var cnt = 1

    repeat(n){
        val st = StringTokenizer(reader.readLine())
        val weight = st.nextToken().toInt()
        val height = st.nextToken().toInt()

        list.add(Pair(weight, height))
    }

    for(i in 0 until list.size){
        cnt = 1
       for (j in 0 until list.size){
           if(list[i].first < list[j].first && list[i].second < list[j].second){
               cnt++
           }
       }
        print("$cnt ")
    }
}