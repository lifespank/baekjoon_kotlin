import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private var maxLen = 0
private var furthest = 1

private fun dfs(start: Int, graph: Array<MutableList<Pair<Int, Int>>>, visited: Array<Boolean>, depth: Int) {
    visited[start] = true
    if (depth > maxLen) {
        maxLen = depth
        furthest = start
    }
    graph[start].forEach {
        if (!visited[it.first]) {
            dfs(it.first, graph, visited, depth + it.second)
        }
    }
}

fun problem1967() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val graph = Array<MutableList<Pair<Int, Int>>>(n + 1) { mutableListOf() }
    val visited = Array(n + 1) { false }
    repeat(n - 1) {
        val st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val value = st.nextToken().toInt()
        graph[from].add(Pair(to, value))
        graph[to].add(Pair(from, value))
    }
    var t = 1
    var v = 1
    dfs(1, graph, visited, 0)
    t = furthest
    maxLen = 0
    visited.fill(false, 0)
    dfs(t, graph, visited, 0)
    bw.write(maxLen.toString())
    br.close()
    bw.flush()
    bw.close()
}