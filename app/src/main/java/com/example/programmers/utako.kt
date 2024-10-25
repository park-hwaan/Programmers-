package com.example.programmers

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""
    try {
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("잘못된 입력입니다: ${e.message}")
    }
}

fun splitInput(input: String): List<String> {
    if (input.isEmpty()) {
        return emptyList()
    }
    val delimiters = arrayOf(",", ":")
    return input.split(*delimiters)
}

fun validateNumbers(numbers: List<String>) {
    numbers.forEach {
        val number = it.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다: $it")
        if (number < 0) {
            throw IllegalArgumentException("음수는 허용되지 않습니다: $number")
        }
    }
}

fun sumNumbers(numbers: List<String>): Int {
    return numbers.sumOf { it.toInt() }
}

//fun add(input: String): Int {
//    val numbers = splitInput(input)
//    validateNumbers(numbers)
//    return sumNumbers(numbers)
//}
