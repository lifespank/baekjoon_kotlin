fun problem_10845() {
    val dq = ArrayDeque<Int>()
    val n = readLine()?.toInt()!!
    val str = StringBuilder()
    (0 until n).forEach {
        val comm = readLine()?.split(" ")
        val opr = comm?.get(0)
        val num = if ((comm?.size ?: 0) > 1) {
            comm?.get(1)
        } else {
            0
        }.toString().toInt()
        when (opr) {
            "push" -> push(dq, num)
            "pop" -> pop(dq, str)
            "size" -> size(dq, str)
            "empty" -> empty(dq, str)
            "front" -> front(dq, str)
            "back" -> back(dq, str)
        }
    }
    print(str)
}

private fun push(dq: ArrayDeque<Int>, num: Int) {
    dq.add(num)
}

private fun pop(dq: ArrayDeque<Int>, str: StringBuilder) {
    str.append("${dq.removeFirstOrNull() ?: -1}\n")
}

private fun size(dq: ArrayDeque<Int>, str: StringBuilder) {
    str.append("${dq.size}\n")
}

private fun empty(dq: ArrayDeque<Int>, str: StringBuilder) {
    if (dq.isEmpty()) {
        str.append("1\n")
    } else {
        str.append("0\n")
    }
}

private fun front(dq: ArrayDeque<Int>, str: StringBuilder) {
    str.append("${dq.firstOrNull() ?: -1}\n")
}

private fun back(dq: ArrayDeque<Int>, str: StringBuilder) {
    str.append("${dq.lastOrNull() ?: -1}\n")
}