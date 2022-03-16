import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun problem_9093() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder("")

    var testCase = br.readLine().toInt()
    while (testCase-- > 0) {
        val st = StringTokenizer(br.readLine())
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken().reversed())
            sb.append(" ")
        }
        sb.append("\n")
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}