import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_17413() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder("")

    val line = br.readLine()
    var isReversed = true
    val deq = ArrayDeque<Char>()
    line.forEach { char ->
        when (char) {
            '<' -> {
                clearDequeue(deq, sb)
                sb.append('<')
                isReversed = false
            }
            '>' -> {
                sb.append('>')
                isReversed = true
            }
            ' ' -> {
                if (isReversed) {
                    clearDequeue(deq, sb)
                }
                sb.append(' ')
            }
            else -> {
                if (isReversed) {
                    deq.add(char)
                } else {
                    sb.append(char)
                }
            }
        }
    }
    clearDequeue(deq, sb)
    br.close()
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}

private fun clearDequeue(deq: ArrayDeque<Char>, sb: StringBuilder) {
    while (deq.isNotEmpty()) {
        sb.append(deq.removeLast())
    }
}