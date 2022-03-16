import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

private fun isInBoard(x: Int, y: Int, m: Int, n: Int) = x in (0 until m) && y in (0 until n)

private fun bfs(
    startX: Int,
    startY: Int,
    board: Array<Array<Boolean>>,
    m: Int,
    n: Int,
    visited: Array<Array<Boolean>>
): Int {
    var area = 0
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    queue.add(Pair(startX, startY))
    visited[startX][startY] = true
    while (queue.isNotEmpty()) {
        val here = queue.poll()
        area++
        repeat(4) {
            val nX = here.first + dx[it]
            val nY = here.second + dy[it]
            if (isInBoard(nX, nY, m, n) && !visited[nX][nY] && board[nX][nY]) {
                queue.add(Pair(nX, nY))
                visited[nX][nY] = true
            }
        }
    }
    return area
}

fun problem2583() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val board = Array(m) { Array(n) { true } }
    val visited = Array(m) { Array(n) { false } }
    val pq = PriorityQueue<Int>()
    var count = 0
    repeat(k) {
        st = StringTokenizer(br.readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        (m - y2 until m - y1).forEach { row ->
            (x1 until x2).forEach { col ->
                board[row][col] = false
            }
        }
    }
    repeat(m) { row ->
        repeat(n) { col ->
            if (!visited[row][col] && board[row][col]) {
                count++
                pq.add(bfs(row, col, board, m, n, visited))
            }
        }
    }
    bw.write(count.toString())
    bw.write("\n")
    while (pq.isNotEmpty()) {
        bw.write(pq.poll().toString())
        bw.write(" ")
    }
    br.close()
    bw.flush()
    bw.close()
}