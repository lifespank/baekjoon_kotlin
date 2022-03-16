import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun isBlurayFit(m: Int, size: Int, lectures: Array<Int>): Boolean {
    var count = 1
    var curSize = 0
    lectures.forEach { lecture ->
        if (curSize + lecture > size) {
            curSize = lecture
            if (curSize > size) {
                return false
            }
            count++
        } else {
            curSize += lecture
        }
    }
    return count <= m
}

fun problem2343() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val lectures = Array(n) { 0 }
    st = StringTokenizer(br.readLine())
    var low = 1
    var high = 0
    repeat(n) {
        lectures[it] = st.nextToken().toInt()
        high += lectures[it]
    }
    var ans = Int.MAX_VALUE
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (isBlurayFit(m, mid, lectures)) {
            ans = minOf(ans, mid)
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    bw.write(ans.toString())
    br.close()
    bw.flush()
    bw.close()
}