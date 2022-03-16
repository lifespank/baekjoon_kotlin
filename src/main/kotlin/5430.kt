import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun problem_5430() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder("")

    var testCase = br.readLine().toInt()

    while (testCase-- > 0) {
        var isFront = true
        val comm = br.readLine()
        var len = br.readLine().toInt()
        val rawArray = br.readLine()
        val deq = ArrayDeque<Int>()
        val st = StringTokenizer(rawArray.substring(1, rawArray.length - 1), ",")
        while (len-- > 0) {
            deq.add(st.nextToken().toInt())
        }
        run {
            comm.forEach { char ->
                when (char) {
                    'R' -> isFront = !isFront
                    'D' -> {
                        try {
                            if (isFront) {
                                deq.removeFirst()
                            } else {
                                deq.removeLast()
                            }
                        } catch (e: Exception) {
                            sb.append("error\n")
                            return@run
                        }
                    }
                }
            }
            sb.append("[")
            if (isFront) {
                sb.append(deq.joinToString(","))
            } else {
                sb.append(deq.reversed().joinToString(","))
            }
            sb.append("]\n")
        }
    }
    bw.write(sb.toString())

    bw.flush()
    bw.close()
}