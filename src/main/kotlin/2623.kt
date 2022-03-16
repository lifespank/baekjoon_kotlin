import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = Array(n + 1) { 0 }
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val singerCount = st.nextToken().toInt()
        var from = st.nextToken().toInt()
        var to: Int
        repeat(singerCount - 1) {
            to = st.nextToken().toInt()
            graph[from].add(to)
            inDegree[to]++
            from = to
        }
    }
    val q = ArrayDeque<Int>()
    val ans = mutableListOf<Int>()
    for (i in 1..n) {
        if (inDegree[i] == 0) {
            q.addLast(i)
        }
    }
    for (i in 1..n) {
        if (q.isEmpty()) {
            ans.clear()
            ans.add(0)
            break
        }
        val here = q.removeFirst()
        ans.add(here)
        graph[here].forEach { next ->
            if (--inDegree[next] == 0) {
                q.addLast(next)
            }
        }
    }
    bw.write(ans.joinToString("\n"))
    br.close()
    bw.flush()
    bw.close()
}