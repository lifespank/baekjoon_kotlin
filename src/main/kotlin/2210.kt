import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashSet

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)
private val board = Array(5) { Array(5) { 0 } }
private val numSet: HashSet<String> = hashSetOf()

private fun isInBoard(x: Int, y: Int): Boolean {
    return x in 0..4 && y in 0..4
}

private fun dfs(x: Int, y: Int, depth: Int, sb: StringBuilder) {
    if (depth == 6) {
        numSet.add(sb.toString())
        return
    }
    repeat(4) { i ->
        val nX = x + dx[i]
        val nY = y + dy[i]
        if (isInBoard(nX, nY)) {
            sb.append(board[nX][nY])
            dfs(nX, nY, depth + 1, sb)
            sb.deleteCharAt(sb.length - 1)
        }
    }
}

fun problem_2210() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(5) { row ->
        val st = StringTokenizer(br.readLine())
        repeat(5) { col ->
            board[row][col] = st.nextToken().toInt()
        }
    }
    repeat(5) { i ->
        repeat(5) { j ->
            val sb = StringBuilder("")
            dfs(i, j, 0, sb)
        }
    }
    bw.write(numSet.size.toString())
    br.close()
    bw.flush()
    bw.close()
}