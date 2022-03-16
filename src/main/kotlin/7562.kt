import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val dx = listOf(-2, -2, -1, -1, 1, 1, 2, 2)
private val dy = listOf(1, -1, 2, -2, 2, -2, 1, -1)

private fun bfs(startX: Int, startY: Int, destX: Int, destY: Int, size: Int): Int {
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    val depth = Array(size) { Array(size) { -1 } }
    queue.add(Pair(startX, startY))
    depth[startX][startY] = 0
    while (queue.isNotEmpty()) {
        val herePair = queue.poll()
        if (herePair.first == destX && herePair.second == destY) {
            return depth[herePair.first][herePair.second]
        }
        repeat(8) { i ->
            val nX = herePair.first + dx[i]
            val nY = herePair.second + dy[i]
            if (isInBoard(nX, nY, size) && depth[nX][nY] == -1) {
                queue.add(Pair(nX, nY))
                depth[nX][nY] = depth[herePair.first][herePair.second] + 1
            }
        }
    }
    return -1
}

private fun isInBoard(x: Int, y: Int, size: Int): Boolean {
    return x in (0 until size) && y in (0 until size)
}

fun problem_7532() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val testCase = br.readLine().toInt()
    repeat(testCase) { tc ->
        val size = br.readLine().toInt()
        var st = StringTokenizer(br.readLine())
        val currX = st.nextToken().toInt()
        val currY = st.nextToken().toInt()
        st = StringTokenizer(br.readLine())
        val destX = st.nextToken().toInt()
        val destY = st.nextToken().toInt()
        bw.write("${bfs(currX, currY, destX, destY, size)}\n")
    }

    br.close()
    bw.flush()
    bw.close()
}