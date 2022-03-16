import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun problem_10797() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    var count = 0
    while (st.hasMoreTokens()) {
        if (st.nextToken().toInt() == n) {
            count++
        }
    }
    bw.write(count.toString())
    br.close()
    bw.flush()
    bw.close()
}