package com.example.programmers

fun main() {

}

fun add(numbers: String): Int {
    val numberList = parseInput(numbers)
    checkNegativeNumber(numberList)
    return sumNumber(numberList)
}

// 1. 입력받은 값 확인하기 (커스텀 구분자 및 기본 구분자 처리)
fun parseInput(numbers: String): List<Int> {
    if (numbers.isEmpty()) return emptyList()

    val customDelimiterRegex = Regex("//(\\[.*?])\n(.*)")
    val result = customDelimiterRegex.find(numbers)

    val delimiters = if (result != null) {
        val customDelimiter = result.groupValues[1]
        "[,$customDelimiter:]"
    } else {
        "[,:]"
    }

    val numberString = result?.groupValues?.get(2) ?: numbers
    return try {
        numberString.split(Regex(delimiters)).map { it.toInt() }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Invalid input: non-numeric value found")
    }
}

// 2. 입력받은 값 음수 확인
fun checkNegativeNumber(numberList: List<Int>) {
    numberList.forEach {
        if (it < 0) {
            throw IllegalArgumentException("Negative numbers are not allowed: $it")
        }
    }
}

// 3. 입력 받은 값 더하기
fun sumNumber(numberList: List<Int>): Int {
    return numberList.sum()
}
