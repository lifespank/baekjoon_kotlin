import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun findRoot(parent: Array<Int>, u: Int): Int {
    if (u == parent[u]) {
        return u
    }
    parent[u] = findRoot(parent, parent[u])
    return parent[u]
}

private fun merge(parent: Array<Int>, level: Array<Int>, u: Int, v: Int) {
    val uRoot = findRoot(parent, u)
    val vRoot = findRoot(parent, v)
    if (uRoot == vRoot) {
        return
    }
    when {
        level[uRoot] < level[vRoot] -> {
            parent[uRoot] = vRoot
        }
        level[uRoot] > level[vRoot] -> {
            parent[vRoot] = uRoot
        }
        else -> {
            parent[uRoot] = vRoot
            level[vRoot]++
        }
    }
}

private fun isFriend(parent: Array<Int>, u: Int, v: Int) = findRoot(parent, u) == findRoot(parent, v)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val parent = Array(n + 1) { it }
    val level = Array(n + 1) { 1 }
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val op = st.nextToken().toInt()
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        if (op == 0) {
            merge(parent, level, u, v)
        } else if (isFriend(parent, u, v)) {
            bw.write("YES\n")
        } else {
            bw.write("NO\n")
        }
    }
    br.close()
    bw.flush()
    bw.close()
}