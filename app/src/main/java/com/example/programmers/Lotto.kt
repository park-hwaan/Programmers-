package com.example.programmers

/*
입력받기
1. 구입금액 입력받기 -> 예외처리(1.빈칸 2.1000원으로 나누어 떨어지지 않는다 3.double일경우)
2. 당첨번호를 입력받는다 -> 예외처리(1.빈칸이 있을경우, 2.음수가 있을경우, 3.소수가 있을경우 4.문자일 경우 5.중복일 경우)
3. 보너스 번호를 입력받는다 -> 예외처리(1.빈칸, 2.음수, 3.문자)

출력
1. 구매한 로또 갯수 출력
2. 당첨 통계출력
3. 당첨 수익률 출력
*/

// 돈 입력받음 -> 그 수량만큼 나의 로또 번호 출력 -> 로또번호 입력받고 -> 보너스 번호 입력받음

//class Lotto(private val numbers: List<Int>) {
//    init {
//        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
//        require(numbers.distinct().size == numbers.size){"[ERROR] 로또 번호가 중복됩니다"}
//
//    }
//
//    fun checkLottoNumber(){
//
//    }
//}

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