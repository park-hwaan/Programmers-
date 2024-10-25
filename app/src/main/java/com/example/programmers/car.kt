import kotlin.random.Random

fun getCarNames(): MutableList<Pair<String,Int>> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine() ?: throw IllegalArgumentException("입력값이 null입니다.")
    val names = input.split(",").map { it.trim() }
    names.forEach { name ->
        if (name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.")
        }
    }
    return names.map { Pair(it,0) }.toMutableList()
}

fun getAttemptCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해야 합니다.")
}


fun moveCars(cars: MutableList<Pair<String, Int>>) {
    cars.forEachIndexed { index, car ->
        if (Random.nextInt(10) >= 4) {
            cars[index] = car.copy(second = car.second + 1)
        }
    }
}

fun printCarPositions(cars: MutableList<Pair<String, Int>>) {
    cars.forEach { (name, position) ->
        println("$name : ${"-".repeat(position)}")
    }
    println()
}

fun printWinners(cars: List<Pair<String, Int>>) {
    val maxSecond = cars.maxOf { it.second }
    val winners = cars.filter { it.second == maxSecond }.joinToString(", ") { it.first }
    println("최종 우승자 : $winners")
}

fun main() {
    val carNames = getCarNames()
    val attemptCount = getAttemptCount()

    println("\n실행 결과")
    repeat(attemptCount) {
        moveCars(carNames)
        printCarPositions(carNames)
    }

    printWinners(carNames)

}
