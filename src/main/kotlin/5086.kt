import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun problem_5086() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var line = br.readLine()
    while (line != "0 0") {
        val st = StringTokenizer(line)
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        when {
            b % a == 0 -> bw.write("factor\n")
            a % b == 0 -> bw.write("multiple\n")
            else -> bw.write("neither\n")
        }
        line = br.readLine()
    }

    br.close()
    bw.flush()
    bw.close()
}