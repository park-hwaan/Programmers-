package com.example.programmers.lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size){"[ERROR] 로또 번호가 중복됩니다"}

    }

    fun checkLottoNumber(myLottoList : List<Int>, bonusNumber : Int) : Pair<Int,Boolean>{
        val matchCount = numbers.count{it in myLottoList}
        val isContainBonusNumber = numbers.contains(bonusNumber)
        return Pair(matchCount, isContainBonusNumber)
    }
}

fun main(){
    val money = getMoneyAmount()
    createLottoNumbers(money)

    println("당첨번호를 입력해주세요")
    val input = readLine()!!.split(",").mapNotNull { it.trim().toIntOrNull() }
    println("보너스 번호를 입력해주세요")
    val bonusNumber = readLine()!!.toIntOrNull() ?: throw IllegalArgumentException()
    val lottoNumber = input.toMutableList().apply { add(bonusNumber) }

    val lottoStart = Lotto(lottoNumber)

}

fun getMoneyAmount() : Int{
    print("구입 금액을 입력해주세요: ")
    val getInputMoney = readLine()!!.toInt()
    return getInputMoney / 1000
}

fun createLottoNumbers(lottoAmount : Int) {
    val lottoList = mutableListOf<List<Int>>()
    repeat(lottoAmount){
        val lottoNumbers = (0..45).shuffled().take(6).sorted()
        lottoList.add(lottoNumbers)
    }
    lottoList.forEach { println(it) }
}



