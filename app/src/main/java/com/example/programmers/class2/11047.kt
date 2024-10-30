package com.example.programmers

fun main() = with(System.`in`.bufferedReader()){
    var(N,M) = readLine().split(" ").map { it.toInt() }

    val coinList = mutableListOf<Int>()
    var result = 0

    repeat(N){coinList.add(readLine().toInt())}

    for (i in N - 1 downTo  0){
        if(coinList[i] <= M){
            val s =  M / coinList[i]
            result += s
            M %= coinList[i]
        }
        if (M == 0) break
    }
    println(result)
}