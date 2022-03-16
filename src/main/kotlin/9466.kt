import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private var count = 0

private fun dfs(num: Int, graph: Array<Int>, finished: Array<Boolean>, visited: Array<Boolean>) {
    if (finished[num]) {
        return
    }
    if (visited[num]) {
        var next = graph[num]
        count++
        while (next != num) {
            count++
            next = graph[next]
        }
        return
    }
    visited[num] = true
    dfs(graph[num], graph, finished, visited)
    finished[num] = true
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    repeat(t) {
        count = 0
        val n = br.readLine().toInt()
        val graph = Array(n + 1) { 0 }
        val visited = Array(n + 1) { false }
        val finished = Array(n + 1) { false }
        val st = StringTokenizer(br.readLine())
        for (from in 1..n) {
            graph[from] = st.nextToken().toInt()
        }
        for (node in 1..n) {
            if (!visited[node]) {
                dfs(node, graph, finished, visited)
            }
        }
        bw.write((n - count).toString())
        bw.write("\n")
    }
    br.close()
    bw.flush()
    bw.close()
}