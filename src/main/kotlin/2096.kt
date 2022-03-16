import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min

private fun getMaxOrMin(max: Boolean, col: Int, dp: Array<Array<Int>>): Int {
    when (col) {
        0 -> {
            return if (max) {
                max(dp[0][0], dp[0][1])
            } else {
                min(dp[0][0], dp[0][1])
            }
        }
        1 -> {
            return if (max) {
                max(dp[0][0], max(dp[0][1], dp[0][2]))
            } else {
                min(dp[0][0], min(dp[0][1], dp[0][2]))
            }
        }
        else -> {
            return if (max) {
                max(dp[0][1], dp[0][2])
            } else {
                min(dp[0][1], dp[0][2])
            }
        }
    }
}

fun problem2096() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val dpMax = Array(2) { Array(3) { 0 } }
    val dpMin = Array(2) { Array(3) { 0 } }
    var st = StringTokenizer(br.readLine())
    dpMax[0].forEachIndexed { i, _ ->
        dpMax[0][i] = st.nextToken().toInt()
    }
    dpMax[0].copyInto(dpMin[0])
    if (n > 1) {
        repeat(n - 1) {
            st = StringTokenizer(br.readLine())
            dpMax[1].forEachIndexed { i, _ ->
                dpMax[1][i] = st.nextToken().toInt()
            }
            dpMax[1].copyInto(dpMin[1])
            dpMax[1].forEachIndexed { i, _ ->
                dpMax[1][i] += getMaxOrMin(true, i, dpMax)
                dpMin[1][i] += getMaxOrMin(false, i, dpMin)
            }
            dpMax[1].copyInto(dpMax[0])
            dpMin[1].copyInto(dpMin[0])
        }
        bw.write(dpMax[1].maxOrNull().toString())
        bw.write(" ")
        bw.write(dpMin[1].minOrNull().toString())
    } else {
        bw.write(dpMax[0].maxOrNull().toString())
        bw.write(" ")
        bw.write(dpMin[0].minOrNull().toString())
    }
    br.close()
    bw.flush()
    bw.close()
}