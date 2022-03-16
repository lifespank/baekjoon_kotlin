import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun findNum(numbers: Array<Int>, toFind: Int): Boolean {
    var low = 0
    var high = numbers.lastIndex
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            numbers[mid] == toFind -> {
                return true
            }
            numbers[mid] < toFind -> {
                low = mid + 1
            }
            else -> {
                high = mid - 1
            }
        }
    }
    return false
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val numbers = Array(n) { 0 }
    var st = StringTokenizer(br.readLine())
    repeat(n) {
        numbers[it] = st.nextToken().toInt()
    }
    numbers.sort()
    val m = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    repeat(m) {
        val toFind = st.nextToken().toInt()
        if (findNum(numbers, toFind)) {
            bw.write("1")
        } else {
            bw.write("0")
        }
        bw.write("\n")
    }
    br.close()
    bw.flush()
    bw.close()
}