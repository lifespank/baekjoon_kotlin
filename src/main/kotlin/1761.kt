import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.log2

private fun dfs(
    tree: Array<MutableList<Pair<Int, Long>>>,
    depth: Array<Int>,
    parent: Array<Array<Int>>,
    distance: Array<Long>,
    here: Int,
    dth: Int,
) {
    depth[here] = dth
    tree[here].forEach { nextInfo ->
        val next = nextInfo.first
        val nextDist = nextInfo.second
        if (depth[next] == 0) {
            parent[0][next] = here
            distance[next] = distance[here] + nextDist
            dfs(tree, depth, parent, distance, next, dth + 1)
        }
    }
}

private fun lca(parent: Array<Array<Int>>, depth: Array<Int>, u: Int, v: Int): Int {
    var uNode = u
    var vNode = v
    if (depth[uNode] < depth[vNode]) {
        uNode = v
        vNode = u
    }
    val diff = depth[uNode] - depth[vNode]
    for (i in parent.lastIndex downTo 0) {
        if (diff and (1 shl i) != 0) {
            uNode = parent[i][uNode]
        }
    }
    if (uNode == vNode) {
        return uNode
    }
    for (i in parent.lastIndex downTo 0) {
        if (parent[i][uNode] != parent[i][vNode]) {
            uNode = parent[i][uNode]
            vNode = parent[i][vNode]
        }
    }
    return parent[0][uNode]
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val tree = Array(n + 1) { mutableListOf<Pair<Int, Long>>() }
    val logMax = log2(n.toDouble()).toInt() + 1
    val depth = Array(n + 1) { 0 }
    val distance = Array(n + 1) { 0L }
    val parent = Array(logMax + 1) { Array(n + 1) { 0 } }
    repeat(n - 1) {
        val st = StringTokenizer(br.readLine())
        val src = st.nextToken().toInt()
        val dest = st.nextToken().toInt()
        val dist = st.nextToken().toLong()
        tree[src].add(dest to dist)
        tree[dest].add(src to dist)
    }
    dfs(tree, depth, parent, distance, 1, 1)
    for (k in 1..logMax) {
        for (i in 1..n) {
            if (parent[k - 1][i] in 1..n) {
                parent[k][i] = parent[k - 1][parent[k - 1][i]]
            }
        }
    }
    val m = br.readLine().toInt()
    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        bw.write((distance[u] + distance[v] - 2 * distance[lca(parent, depth, u, v)]).toString())
        bw.write("\n")
    }
    br.close()
    bw.flush()
    bw.close()
}