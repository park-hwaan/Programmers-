package com.example.programmers

fun main(){
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    var countNum = 0

    for(number in numbers){
        if(isPrime(number)){
            countNum += 1
        }
    }
    println(countNum)


}

fun isPrime(number : Int) : Boolean{
    if(number <= 1) return false
    if(number == 2) return true
    if (number % 2 == 0) return false

    for (i in 3 until number){
        if(number % i == 0) return false
    }
    return true
}