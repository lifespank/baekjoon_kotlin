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
    val lis = mutableListOf<Int>()
    val st = StringTokenizer(br.readLine())
    repeat(n) {
        val size = st.nextToken().toInt()
        if (lis.isEmpty()) {
            lis.add(size)
        } else if (lis.last() < size) {
            lis.add(size)
        } else {
            val lowerBoundIdx = lowerBound(lis, size)
            lis[lowerBoundIdx] = size
        }
    }
    bw.write(lis.size.toString())
    br.close()
    bw.flush()
    bw.close()
}