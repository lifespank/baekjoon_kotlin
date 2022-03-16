fun problem_1026() {
    readLine()
    val a = readLine()?.split(" ")?.map { it.toInt() }?.sortedDescending()
    val b = readLine()?.split(" ")?.map { it.toInt() }?.sorted()
    print(a?.foldIndexed(0) { index, total, num ->
        total + num * (b?.get(index) ?: 0)
    })
}