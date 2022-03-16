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
    val sum = Array(n + 1) { Array(n + 1) { 0 } }
    val m = st.nextToken().toInt()
    for (row in 1..n) {
        st = StringTokenizer(br.readLine())
        for (col in 1..n) {
            sum[row][col] = sum[row][col - 1] + sum[row - 1][col] + st.nextToken().toInt() - sum[row - 1][col - 1]
        }
    }
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        bw.write((sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]).toString())
        bw.write("\n")
    }
    br.close()
    bw.flush()
    bw.close()
}