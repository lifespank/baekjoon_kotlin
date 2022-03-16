fun problem_5543() {
    val high = readLine()?.toInt()
    val mid = readLine()?.toInt()
    val low = readLine()?.toInt()
    val coke = readLine()?.toInt()
    val soda = readLine()?.toInt()
    print(listOf(high, mid, low).minOfOrNull { it!! }!! + minOf(coke!!, soda!!) - 50)
}