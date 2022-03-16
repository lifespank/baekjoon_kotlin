import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val dx = arrayOf(0, 0, 1, -1)
private val dy = arrayOf(1, -1, 0, 0)

private fun isInBoard(x: Int, y: Int, n: Int, m: Int): Boolean {
    return x in 0 until n && y in 0 until m
}

private fun bfs(board: Array<Array<Int>>): Int {
    val visited = Array(board.size) { Array(board[0].size) { 0 } }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val meltQueue: Queue<Pair<Int, Int>> = LinkedList()
    queue.offer(Pair(0, 0))
    visited[0][0] = 2
    while (queue.isNotEmpty()) {
        val here = queue.poll()
        repeat(4) {
            val nX = here.first + dx[it]
            val nY = here.second + dy[it]
            if (isInBoard(nX, nY, board.size, board[0].size) && visited[nX][nY] <= 1) {
                if (board[nX][nY] == 0) {
                    queue.offer(Pair(nX, nY))
                    visited[nX][nY] = 2
                } else {
                    visited[nX][nY]++
                    if (visited[nX][nY] == 2) {
                        meltQueue.offer(Pair(nX, nY))
                    }
                }
            }
        }
    }
    val meltCount = meltQueue.size
    while (meltQueue.isNotEmpty()) {
        val melt = meltQueue.poll()
        board[melt.first][melt.second] = 0
    }
    return meltCount
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val board = Array(n) { Array(m) { 0 } }
    var cheeseCount = 0
    repeat(n) { row ->
        st = StringTokenizer(br.readLine())
        repeat(m) { col ->
            board[row][col] = st.nextToken().toInt()
            if (board[row][col] == 1) {
                cheeseCount++
            }
        }
    }
    var meltCheeseCount = 0
    var timeCount = 0
    while (meltCheeseCount < cheeseCount) {
        meltCheeseCount += bfs(board)
        timeCount++
    }
    bw.write(timeCount.toString())
    br.close()
    bw.flush()
    bw.close()
}