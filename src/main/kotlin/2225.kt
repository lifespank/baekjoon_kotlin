import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun probelm2225() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val mod: Long = 1000000000
    val dp: Array<Array<Long>> = Array(k + 1) { Array(n + 1) { 0 } }
    for (i in 0..n) {
        dp[1][i] = 1
    }
    for (i in 1..k) {
        for (j in 0..n) {
            for (l in 0..j) {
                dp[i][j] = (dp[i][j] + dp[i - 1][l]) % mod
            }
        }
    }
    bw.write(dp[k][n].toString())
    br.close()
    bw.flush()
    bw.close()
}