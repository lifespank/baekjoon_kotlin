import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_2504() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val comm = br.readLine()
    val deq = ArrayDeque<Char>()
    val numDeq = ArrayDeque<Int>()
    var mul = 1
    var broken = false
    run {
        comm.forEachIndexed { idx, char ->
            when (char) {
                '(' -> {
                    mul *= 2
                    deq.add('(')
                }
                '[' -> {
                    mul *= 3
                    deq.add('[')
                }
                ')' -> {
                    if (idx > 0 && comm[idx - 1] == '(') {
                        numDeq.add(mul)
                    }
                    if (deq.isNotEmpty() && deq.lastOrNull() == '(') {
                        mul /= 2
                        deq.removeLastOrNull()
                    } else {
                        broken = true
                        return@run
                    }
                }
                ']' -> {
                    if (idx > 0 && comm[idx - 1] == '[') {
                        numDeq.add(mul)
                    }
                    if (deq.isNotEmpty() && deq.lastOrNull() == '[') {
                        mul /= 3
                        deq.removeLastOrNull()
                    } else {
                        broken = true
                        return@run
                    }
                }
            }
        }
    }
    if (broken || deq.isNotEmpty()) {
        bw.write("0")
    } else {
        bw.write(numDeq.sum().toString())
    }
    bw.flush()
    bw.close()
}