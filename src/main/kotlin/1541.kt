import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine(), "+-", true)
    var isDigit = true
    var ans = 0
    var isMinus = false
    while (st.hasMoreTokens()) {
        val token = st.nextToken()
        if (isDigit) {
            if (isMinus) {
                ans -= token.toInt()
            } else {
                ans += token.toInt()
            }
        } else {
            if (!isMinus && token == "-") {
                isMinus = true
            }
        }
        isDigit = !isDigit
    }
    bw.write(ans.toString())
    br.close()
    bw.flush()
    bw.close()
}