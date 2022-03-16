import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val dx = arrayOf(1, -1, 0, 0)
private val dy = arrayOf(0, 0, 1, -1)

private fun isInBoard(x: Int, y: Int): Boolean {
    return x in 0 until 12 && y in 0 until 6
}

private fun fall(board: Array<Array<Char>>) {
    val q: Queue<Char> = ArrayDeque()
    repeat(6) { col ->
        (11 downTo 0).forEach { row ->
            if (board[row][col] != '.') {
                q.add(board[row][col])
            }
        }
        (11 downTo 0).forEach { row ->
            if (q.isNotEmpty()) {
                board[row][col] = q.poll()
            } else {
                board[row][col] = '.'
            }
        }
    }
}

private fun bfs(board: Array<Array<Char>>, x: Int, y: Int): Int {
    val q: Queue<Pair<Int, Int>> = ArrayDeque()
    val candidate: Queue<Pair<Int, Int>> = ArrayDeque()
    val visited = Array(12) { Array(6) { false } }
    q.add(x to y)
    candidate.add(x to y)
    visited[x][y] = true
    while (q.isNotEmpty()) {
        val here = q.poll()
        repeat(4) { idx ->
            val nX = here.first + dx[idx]
            val nY = here.second + dy[idx]
            if (isInBoard(nX, nY) && !visited[nX][nY] && board[x][y] == board[nX][nY]) {
                q.add(nX to nY)
                candidate.add(nX to nY)
                visited[nX][nY] = true
            }
        }
    }
    val popped = if (candidate.size >= 4) {
        candidate.size
    } else {
        0
    }
    if (candidate.size >= 4) {
        while (candidate.isNotEmpty()) {
            val toBePopped = candidate.poll()
            board[toBePopped.first][toBePopped.second] = '.'
        }
    }
    return popped
}

private fun puyo(board: Array<Array<Char>>): Boolean {
    var popped = 0
    (11 downTo 0).forEach { row ->
        repeat(6) { col ->
            if (board[row][col] != '.') {
                popped += bfs(board, row, col)
            }
        }
    }
    fall(board)
    return popped > 0
}

fun problem_11559() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val board = Array(12) { Array(6) { '.' } }
    repeat(12) { row ->
        br.readLine().forEachIndexed { col, char ->
            board[row][col] = char
        }
    }

    var count = 0
    while (puyo(board)) {
        count++
    }
    bw.write(count.toString())
    br.close()
    bw.flush()
    bw.close()
}