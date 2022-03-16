import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs
import kotlin.math.max

private data class Enemy(var x: Int, var y: Int, var marked: Boolean)

private fun manhattanDistance(x1: Int, y1: Int, x2: Int, y2: Int) = abs(x1 - x2) + abs(y1 - y2)

private fun getScore(
    archers: List<Int>,
    n: Int,
    d: Int,
    enemies: List<Enemy>
): Int {
    var mutableEnemies = enemies.map { it.copy() }
    var count = 0
    while (mutableEnemies.isNotEmpty()) {
        archers.forEach { archer ->
            val pq = PriorityQueue { a: Triple<Int, Int, Int>, b: Triple<Int, Int, Int> ->
                if (a.first != b.first) {
                    a.first - b.first
                } else {
                    a.second - b.second
                }
            }
            pq.addAll(mutableEnemies.mapIndexed { idx, enemy ->
                Triple(
                    manhattanDistance(n, archer, enemy.x, enemy.y),
                    enemy.y,
                    idx
                )
            })
            val killIdx = if (pq.peek().first <= d) {
                pq.peek().third
            } else {
                -1
            }
            if (killIdx != -1) {
                mutableEnemies[killIdx].marked = true
            }
        }
        count += mutableEnemies.count { it.marked }
        mutableEnemies = mutableEnemies.filter { !it.marked }
        mutableEnemies.forEach { enemy ->
            enemy.x++
            if (enemy.x == n) {
                enemy.marked = true
            }
        }
        mutableEnemies = mutableEnemies.filter { !it.marked }
    }
    return count
}

fun problem_17135() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    val board = Array(n) { Array(m) { 0 } }
    val enemies = mutableListOf<Enemy>()
    repeat(n) { row ->
        st = StringTokenizer(br.readLine())
        repeat(m) { col ->
            board[row][col] = st.nextToken().toInt()
            if (board[row][col] == 1) {
                enemies.add(Enemy(row, col, false))
            }
        }
    }
    var maxNum = 0
    repeat(m) { i ->
        (i + 1 until m).forEach { j ->
            (j + 1 until m).forEach { k ->
                maxNum = max(maxNum, getScore(listOf(i, j, k), n, d, enemies))
            }
        }
    }
    bw.write(maxNum.toString())
    br.close()
    bw.flush()
    bw.close()
}