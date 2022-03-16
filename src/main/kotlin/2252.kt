import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun dfs(num: Int, stack: ArrayDeque<Int>, graph: Array<MutableList<Int>>, visited: Array<Boolean>) {
    visited[num] = true
    graph[num].forEach { next ->
        if (!visited[next]) {
            dfs(next, stack, graph, visited)
        }
    }
    stack.addLast(num)
}

fun problem2252() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = Array(n + 1) { false }
    val stack = ArrayDeque<Int>()
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        graph[from].add(to)
    }
    for (i in 1..n) {
        if (!visited[i]) {
            dfs(i, stack, graph, visited)
        }
    }
    while (stack.isNotEmpty()) {
        bw.write(stack.removeLast().toString())
        bw.write(" ")
    }
    br.close()
    bw.flush()
    bw.close()
}