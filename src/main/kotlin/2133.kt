import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem2133() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val dp = Array(n + 2) { 0 }
    dp[0] = 1
    dp[2] = 3
    for (i in 4..n step 2) {
        dp[i] = dp[i - 2] * 3
        for (j in i - 4 downTo 0 step 2) {
            dp[i] += dp[j] * 2
        }
    }
    bw.write(dp[n].toString())
    br.close()
    bw.flush()
    bw.close()
}