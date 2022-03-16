import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val dx = arrayOf(-1, 0, 1)

private fun isInBoard(x: Int, y: Int, r: Int, c: Int) = x in 0 until r && y in 0 until c

private fun dfs(board: Array<Array<Char>>, visited: Array<Array<Boolean>>, x: Int, y: Int): Boolean {
    visited[x][y] = true
    if (y == board[0].lastIndex) {
        return true
    }
    val nY = y + 1
    dx.forEach {
        val nX = x + it
        if (isInBoard(nX, nY, board.size, board[0].size) && !visited[nX][nY] && board[nX][nY] == '.' && dfs(
                board,
                visited,
                nX,
                nY
            )
        ) {
            return true
        }
    }
    return false
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val board = Array(r) { Array(c) { ' ' } }
    val visited = Array(r) { Array(c) { false } }
    repeat(r) {
        val line = br.readLine()
        line.forEachIndexed { idx, char ->
            board[it][idx] = char
        }
    }
    var pipeCount = 0
    for (i in board.indices) {
        if (dfs(board, visited, i, 0)) {
            pipeCount++
        }
    }
    bw.write(pipeCount.toString())
    br.close()
    bw.flush()
    bw.close()
}