import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val dx = arrayOf(1, -1, 0, 0)
private val dy = arrayOf(0, 0, 1, -1)

private fun isInBoard(x: Int, y: Int, r: Int, c: Int) = x in (0 until r) && y in (0 until c)

private fun waterSpread(
    waterMap: Array<Array<Int>>,
    board: Array<Array<Char>>,
    waterSource: Queue<Pair<Int, Int>>,
    r: Int,
    c: Int
) {
    val waterQueue: Queue<Pair<Int, Int>> = ArrayDeque()
    while (waterSource.isNotEmpty()) {
        val water = waterSource.poll()
        waterMap[water.first][water.second] = 0
        waterQueue.add(water)
    }
    while (waterQueue.isNotEmpty()) {
        val here = waterQueue.poll()
        for (i in 0 until 4) {
            val nX = here.first + dx[i]
            val nY = here.second + dy[i]
            if (isInBoard(nX, nY, r, c) && board[nX][nY] == '.' && waterMap[nX][nY] == Int.MAX_VALUE) {
                waterQueue.add(Pair(nX, nY))
                waterMap[nX][nY] = waterMap[here.first][here.second] + 1
            }
        }
    }
}

private fun bfs(board: Array<Array<Char>>, waterMap: Array<Array<Int>>, hedgehog: Pair<Int, Int>, r: Int, c: Int): Int {
    val depth = Array(r) { Array(c) { -1 } }
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    queue.add(hedgehog)
    depth[hedgehog.first][hedgehog.second] = 0
    while (queue.isNotEmpty()) {
        val here = queue.poll()
        if (board[here.first][here.second] == 'D') {
            return depth[here.first][here.second]
        }
        for (i in 0 until 4) {
            val nX = here.first + dx[i]
            val nY = here.second + dy[i]
            if (isInBoard(nX, nY, r, c) && depth[here.first][here.second] + 1 < waterMap[nX][nY] &&
                (board[nX][nY] == '.' || board[nX][nY] == 'D') && depth[nX][nY] == -1) {
                queue.add(Pair(nX, nY))
                depth[nX][nY] = depth[here.first][here.second] + 1
            }
        }
    }
    return -1
}

fun probelm3055() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val board = Array(r) { Array(c) { '0' } }
    val waterMap = Array(r) { Array(c) { Int.MAX_VALUE } }
    lateinit var hedgehog: Pair<Int, Int>
    val waterSource: Queue<Pair<Int, Int>> = ArrayDeque()
    for (i in 0 until r) {
        val temp = br.readLine()
        temp.forEachIndexed { j, char ->
            board[i][j] = char
            if (char == 'S') {
                hedgehog = Pair(i, j)
                board[i][j] = '.'
            } else if (char == '*') {
                waterSource.add(Pair(i, j))
            }
        }
    }
    waterSpread(waterMap, board, waterSource, r, c)
    val ans = bfs(board, waterMap, hedgehog, r, c)
    if (ans == -1) {
        bw.write("KAKTUS")
    } else {
        bw.write(ans.toString())
    }
    br.close()
    bw.flush()
    bw.close()
}