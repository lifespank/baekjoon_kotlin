import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

private fun bfs(
    startX: Int,
    startY: Int,
    board: Array<Array<Int>>,
    visited: Array<Array<Boolean>>,
    rainHeight: Int,
    size: Int
) {
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    queue.add(Pair(startX, startY))
    visited[startX][startY] = true
    while (queue.isNotEmpty()) {
        val here = queue.poll()
        repeat(4) {
            val nX = here.first + dx[it]
            val nY = here.second + dy[it]
            if (isInBoard(nX, nY, size) && board[nX][nY] > rainHeight && !visited[nX][nY]) {
                queue.add(Pair(nX, nY))
                visited[nX][nY] = true
            }
        }
    }
}

private fun isInBoard(x: Int, y: Int, size: Int) = x in (0 until size) && y in (0 until size)

fun problem2468() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val board = Array(n) { Array(n) { 0 } }
    var maxHeight = 0
    repeat(n) { row ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { col ->
            board[row][col] = st.nextToken().toInt()
            maxHeight = max(maxHeight, board[row][col])
        }
    }
    var maxSafe = 1
    (1 until maxHeight).forEach { rainHeight ->
        var safeCount = 0
        val visited = Array(n) { Array(n) { false } }
        repeat(n) { row ->
            repeat(n) { col ->
                if (!visited[row][col] && board[row][col] > rainHeight) {
                    safeCount++
                    bfs(row, col, board, visited, rainHeight, n)
                }
            }
        }
        maxSafe = max(maxSafe, safeCount)
    }
    bw.write(maxSafe.toString())
    br.close()
    bw.flush()
    bw.close()
}