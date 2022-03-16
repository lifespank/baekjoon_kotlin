import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs
import kotlin.math.min

private fun numPressCount(n: Int, broken: Array<Boolean>): Int {
    if (n == 0) {
        if (broken[0]) {
            return 0
        }
        return 1
    }
    var count = 0
    var num = n
    while (num > 0) {
        if (broken[num % 10]) {
            return 0
        }
        num /= 10
        count++
    }
    return count
}

fun problem1107() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val broken = Array(10) { false }
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    if (m > 0) {
        val st = StringTokenizer(br.readLine())
        for (i in 0 until m) {
            broken[st.nextToken().toInt()] = true
        }
    }
    var minCount = abs(100 - n)
    for (i in 0..1000000) {
        val numPress = numPressCount(i, broken)
        if (numPress > 0) {
            minCount = min(minCount, numPress + abs(n - i))
        }
    }
    bw.write(minCount.toString())
    br.close()
    bw.flush()
    bw.close()
}