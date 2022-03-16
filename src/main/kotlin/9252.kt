import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun problem9252() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str1 = br.readLine()
    val str2 = br.readLine()
    val dp = Array(str1.length + 1) { Array(str2.length + 1) { 0 } }
    for (i in 1..str1.length) {
        for (j in 1..str2.length) {
            dp[i][j] = if (str1[i - 1] == str2[j - 1]) {
                dp[i - 1][j - 1] + 1
            } else {
                max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    val sb = StringBuilder("")
    var i = str1.length
    var j = str2.length
    while (i > 0 && j > 0) {
        if (dp[i - 1][j] == dp[i][j]) {
            i--
        } else if (dp[i][j - 1] == dp[i][j]) {
            j--
        } else {
            sb.append(str1[i - 1])
            i--
            j--
        }
    }
    bw.write(sb.length.toString())
    bw.write("\n")
    bw.write(sb.reverse().toString())
    br.close()
    bw.flush()
    bw.close()
}