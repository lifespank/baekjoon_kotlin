import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun permutation(
    numbers: Array<Int>,
    selected: MutableList<Int>,
    visited: Array<Boolean>,
    m: Int,
    bw: BufferedWriter
) {
    if (selected.size == m) {
        bw.write(selected.joinToString(" "))
        bw.write("\n")
        return
    }
    numbers.forEachIndexed { idx, next ->
        if (!visited[idx]) {
            visited[idx] = true
            selected.add(next)
            permutation(numbers, selected, visited, m, bw)
            selected.removeLast()
            visited[idx] = false
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val numbers = Array(n) { 0 }
    repeat(n) {
        numbers[it] = st.nextToken().toInt()
    }
    val selected = mutableListOf<Int>()
    val visited = Array(n) { false }
    numbers.sort()
    permutation(numbers, selected, visited, m, bw)
    br.close()
    bw.flush()
    bw.close()
}