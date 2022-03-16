import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun dfs(
    graph: Array<MutableList<Int>>,
    visited: Array<Boolean>,
    currNum: Int,
    parent: Int,
    parentList: Array<Int>
) {
    visited[currNum] = true
    parentList[currNum] = parent
    graph[currNum].forEach { next ->
        if (!visited[next]) {
            dfs(graph, visited, next, currNum, parentList)
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = Array(n + 1) { false }
    val parentList = Array(n + 1) { 0 }
    repeat(n - 1) {
        val st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        graph[from].add(to)
        graph[to].add(from)
    }
    dfs(graph, visited, 1, 0, parentList)
    for (child in 2..n) {
        bw.write(parentList[child].toString())
        bw.write("\n")
    }
    br.close()
    bw.flush()
    bw.close()
}