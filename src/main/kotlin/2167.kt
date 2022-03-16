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
    val sum = Array(n + 1) { Array(m + 1) { 0 } }
    for (row in 1..n) {
        st = StringTokenizer(br.readLine())
        for (col in 1..m) {
            sum[row][col] = sum[row - 1][col] + sum[row][col - 1] + st.nextToken().toInt() - sum[row - 1][col - 1]
        }
    }
    val k = br.readLine().toInt()
    repeat(k) {
        st = StringTokenizer(br.readLine())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        bw.write((sum[x][y] - sum[x][j - 1] - sum[i - 1][y] + sum[i - 1][j - 1]).toString())
        bw.write("\n")
    }

    br.close()
    bw.flush()
    bw.close()
}