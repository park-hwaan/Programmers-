package com.example.programmers

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = Integer.parseInt(readLine())
    val sb = StringBuilder()
    val score = ArrayList<Int>(n)
    val bw = System.out.bufferedWriter()

    repeat(n) {
        score.add(Integer.parseInt(readLine()))
    }
    score.sort()

    sb.append(score.joinToString("\n"))
    bw.write(sb.toString())
    bw.close()
}