import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun woodChoppedIsGood(m: Long, h: Long, trees: Array<Long>) =
    trees.filter { tree -> tree > h }.fold(0L) { total, tree -> total + tree - h } >= m


fun problem2805() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toLong()
    val trees = Array(n) { 0L }
    st = StringTokenizer(br.readLine())
    var high = 0L
    repeat(n) {
        trees[it] = st.nextToken().toLong()
        high = maxOf(high, trees[it])
    }
    var low = 0L
    var ans = 0L
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (woodChoppedIsGood(m, mid, trees)) {
            ans = maxOf(ans, mid)
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    bw.write(ans.toString())
    br.close()
    bw.flush()
    bw.close()
}