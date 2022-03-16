import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val dx = arrayOf(1, -1, 0, 0, 1, 1, -1, -1)
private val dy = arrayOf(0, 0, 1, -1, 1, -1, 1, -1)

private fun isInBoard(x: Int, y: Int, w: Int, h: Int) = x in (0 until h) && y in (0 until w)

private fun bfs(startX: Int, startY: Int, board: Array<Array<Int>>, visited: Array<Array<Boolean>>, w: Int, h: Int) {
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    queue.add(Pair(startX, startY))
    visited[startX][startY] = true
    while (queue.isNotEmpty()) {
        val here = queue.poll()
        repeat(8) {
            val nX = here.first + dx[it]
            val nY = here.second + dy[it]
            if (isInBoard(nX, nY, w, h) && board[nX][nY] == 1 && !visited[nX][nY]) {
                queue.add(Pair(nX, nY))
                visited[nX][nY] = true
            }
        }
    }
}

fun problem4963() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var w = st.nextToken().toInt()
    var h = st.nextToken().toInt()
    while (w != 0 || h != 0) {
        var count = 0
        val board = Array(h) { Array(w) { 0 } }
        val visited = Array(h) { Array(w) { false } }
        repeat(h) { row ->
            st = StringTokenizer(br.readLine())
            repeat(w) { col ->
                board[row][col] = st.nextToken().toInt()
            }
        }
        repeat(h) { row ->
            repeat(w) { col ->
                if (!visited[row][col] && board[row][col] == 1) {
                    bfs(row, col, board, visited, w, h)
                    count++
                }
            }
        }
        st = StringTokenizer(br.readLine())
        w = st.nextToken().toInt()
        h = st.nextToken().toInt()
        bw.write(count.toString())
        bw.write("\n")
    }

    br.close()
    bw.flush()
    bw.close()
}