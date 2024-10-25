package com.example.programmers

import java.util.LinkedList
import java.util.Queue

fun main(){
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val queue : Queue<Int> = LinkedList()

    for (i in 1 .. n){
        queue += i
    }

    while(queue.size != 1){
        queue.poll()
        queue.add(queue.poll())
    }

    queue.poll()?.let { println(it) }



}