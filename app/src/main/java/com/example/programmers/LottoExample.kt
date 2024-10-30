package com.example.programmers

import java.util.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1~45 범위의 숫자여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun matchCount(winningNumbers: List<Int>, bonusNumber: Int): Pair<Int, Boolean> {
        val matchCount = numbers.count { it in winningNumbers }
        val hasBonus = numbers.contains(bonusNumber)
        return Pair(matchCount, hasBonus)
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val purchaseAmount = promptPurchaseAmount(scanner)
    val ticketCount = purchaseAmount / 1000

    val purchasedLottos = purchaseLottos(ticketCount)
    printPurchasedLottos(purchasedLottos)

    val (winningNumbers, bonusNumber) = promptWinningNumbers(scanner)
    val statistics = calculateStatistics(purchasedLottos, winningNumbers, bonusNumber)

    printStatistics(statistics, purchaseAmount)
}

fun promptPurchaseAmount(scanner: Scanner): Int {
    println("구입금액을 입력해 주세요.")
    return scanner.nextInt()
}

fun purchaseLottos(ticketCount: Int): List<Lotto> {
    val random = Random()
    val purchasedLottos = mutableListOf<Lotto>()

    for (i in 1..ticketCount) {
        val numbers = generateRandomLottoNumbers(random)
        purchasedLottos.add(Lotto(numbers))
    }
    return purchasedLottos
}

fun generateRandomLottoNumbers(random: Random): List<Int> {
    return random.ints(1, 46)
        .distinct()
        .limit(6)
        .sorted()
        .toArray()
        .toList()
}

fun printPurchasedLottos(purchasedLottos: List<Lotto>) {
    println("${purchasedLottos.size}개를 구매했습니다.")
    purchasedLottos.forEach { lotto ->
        println(lotto.getNumbers())
    }
}

fun promptWinningNumbers(scanner: Scanner): Pair<List<Int>, Int> {
    println("당첨 번호를 입력해 주세요 (예: 1,2,3,4,5,6):")
    val winningNumbersInput = scanner.next()
    val winningNumbers = winningNumbersInput.split(",").map { it.toInt() }

    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = scanner.nextInt()

    return Pair(winningNumbers, bonusNumber)
}

fun calculateStatistics(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Int, Int> {
    val statistics = mutableMapOf<Int, Int>().withDefault { 0 }

    for (lotto in lottos) {
        val (matchCount, hasBonus) = lotto.matchCount(winningNumbers, bonusNumber)
        when {
            matchCount == 6 -> statistics[6] = statistics.getValue(6) + 1
            matchCount == 5 && hasBonus -> statistics[5] = statistics.getValue(5) + 1
            matchCount == 5 -> statistics[5] = statistics.getValue(5) + 1
            matchCount == 4 -> statistics[4] = statistics.getValue(4) + 1
            matchCount == 3 -> statistics[3] = statistics.getValue(3) + 1
        }
    }
    return statistics
}

fun printStatistics(statistics: Map<Int, Int>, purchaseAmount: Int) {
    println("당첨 통계")
    println("---")
    var totalPrize = 0

    statistics.forEach { (matchCount, count) ->
        val prize = when (matchCount) {
            6 -> 2_000_000_000
            5 -> if (count == statistics[5]) 30_000_000 * count else 1_500_000 * count
            4 -> 50_000 * count
            3 -> 5_000 * count
            else -> 0
        }
        totalPrize += prize
        println("$matchCount 개 일치 (${prize}원) - $count 개")
    }

    val profitRate = (totalPrize.toDouble() / purchaseAmount) * 100
    println("총 수익률은 ${profitRate}%입니다.")
}