import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val sum = Array(n + 1) { 0 }
    st = StringTokenizer(br.readLine())
    repeat(n) {
        sum[it + 1] = sum[it] + st.nextToken().toInt()
    }
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()
        bw.write((sum[j] - sum[i - 1]).toString())
        bw.write("\n")
    }
    br.close()
    bw.flush()
    bw.close()
}