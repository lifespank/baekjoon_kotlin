import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun lowerBound(lis: MutableList<Int>, key: Int): Int {
    var low = 0
    var high = lis.lastIndex
    while (low < high) {
        val mid = low + (high - low) / 2
        if (lis[mid] >= key) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return high
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val lis = mutableListOf<Int>()
    repeat(n) {
        val num = st.nextToken().toInt()
        if (lis.isEmpty()) {
            lis.add(num)
        } else if (lis.last() < num) {
            lis.add(num)
        } else {
            lis[lowerBound(lis, num)] = num
        }
    }
    bw.write((n - lis.size).toString())
    br.close()
    bw.flush()
    bw.close()
}