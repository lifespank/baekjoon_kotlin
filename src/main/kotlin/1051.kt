import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

private fun isSquare(x: Int, y: Int, board: Array<Array<Char>>, size: Int) =
    board[x][y] == board[x + size - 1][y]
            && board[x][y] == board[x][y + size - 1]
            && board[x][y] == board[x + size - 1][y + size - 1]

fun problem1051() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val board = Array(n) { Array(m) { '0' } }
    repeat(n) { row ->
        repeat(m) { col ->
            board[row][col] = br.read().toChar()
        }
        br.read()
    }
    val minVal = min(n, m)
    var maxSize = 1
    run {
        for (size in minVal downTo 1) {
            repeat(n - size + 1) { row ->
                repeat(m - size + 1) { col ->
                    if (isSquare(row, col, board, size)) {
                        maxSize = size
                        return@run
                    }
                }
            }
        }
    }
    bw.write((maxSize * maxSize).toString())
    br.close()
    bw.flush()
    bw.close()
}