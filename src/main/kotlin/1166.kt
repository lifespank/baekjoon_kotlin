import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun problem1166() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val l = st.nextToken().toDouble()
    val w = st.nextToken().toDouble()
    val h = st.nextToken().toDouble()
    var low = 0.0
    var high = maxOf(l, maxOf(w, h))
    repeat(1000) {
        val mid = low + (high - low) / 2
        if ((l / mid).toLong() * (w / mid).toLong() * (h / mid).toLong() < n) {
            high = mid
        } else {
            low = mid
        }
    }
    bw.write(low.toString())
    br.close()
    bw.flush()
    bw.close()
}