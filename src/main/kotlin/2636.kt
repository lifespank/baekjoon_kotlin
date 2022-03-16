import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

private fun isInBoard(n: Int, m: Int, next: Pair<Int, Int>): Boolean {
    return next.first in 0 until n && next.second in 0 until m
}

private fun bfs(board: Array<Array<Int>>, n: Int, m: Int): Int {
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    val visited = Array(n) { Array(m) { false } }
    val melt: Queue<Pair<Int, Int>> = ArrayDeque()
    queue.add(Pair(0, 0))
    visited[0][0] = true
    while (queue.isNotEmpty()) {
        val here = queue.poll()
        repeat(4) {
            val next = Pair(here.first + dx[it], here.second + dy[it])
            if (isInBoard(n, m, next) && !visited[next.first][next.second]) {
                if (board[next.first][next.second] == 0) {
                    queue.add(next)
                } else {
                    melt.add(next)
                }
                visited[next.first][next.second] = true
            }
        }
    }
    val melted = melt.size
    while (melt.isNotEmpty()) {
        val meltCoord = melt.poll()
        board[meltCoord.first][meltCoord.second] = 0
    }
    return melted
}

fun problem_2636() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val board = Array(n) { Array(m) { 0 } }

    repeat(n) { row ->
        st = StringTokenizer(br.readLine())
        repeat(m) { col ->
            board[row][col] = st.nextToken().toInt()
        }
    }

    var hours = 0
    var moltenCheese = bfs(board, n, m)
    var tempCheese = 0
    while (moltenCheese > 0) {
        hours++
        tempCheese = moltenCheese
        moltenCheese = bfs(board, n, m)
    }
    bw.write(hours.toString())
    bw.write("\n")
    bw.write(tempCheese.toString())

    br.close()
    bw.flush()
    bw.close()
}