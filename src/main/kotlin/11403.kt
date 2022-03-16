import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

private val MAX = Int.MAX_VALUE / 10

fun problem11403() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val board = Array(n) { Array(n) { 0 } }
    repeat(n) { row ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { col ->
            board[row][col] = st.nextToken().toInt()
            if (board[row][col] == 0) {
                board[row][col] = MAX
            }
        }
    }
    repeat(n) { mid ->
        repeat(n) { start ->
            repeat(n) { end ->
                board[start][end] = min(board[start][end], board[start][mid] + board[mid][end])
            }
        }
    }
    repeat(n) { row ->
        repeat(n) { col ->
            if (board[row][col] == MAX) {
                bw.write("0")
            } else {
                bw.write("1")
            }
            bw.write(" ")
        }
        bw.write("\n")
    }

    br.close()
    bw.flush()
    bw.close()
}