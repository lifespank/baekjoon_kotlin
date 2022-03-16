import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private fun isSame(board: Array<Array<Int>>, x: Int, y: Int, size: Int, number: Int): Boolean {
    (x until x + size).forEach { row ->
        (y until y + size).forEach { col ->
            if (board[row][col] != number) {
                return false
            }
        }
    }
    return true
}

private fun quadTree(board: Array<Array<Int>>, x: Int, y: Int, size: Int, bw: BufferedWriter) {
    if (board[x][y] == 1 && isSame(board, x, y, size, 1)) {
        bw.write("1")
    } else if (board[x][y] == 0 && isSame(board, x, y, size, 0)) {
        bw.write("0")
    } else {
        bw.write("(")
        quadTree(board, x, y, size / 2, bw)
        quadTree(board, x, y + size / 2, size / 2, bw)
        quadTree(board, x + size / 2, y, size / 2, bw)
        quadTree(board, x + size / 2, y + size / 2, size / 2, bw)
        bw.write(")")
    }
}

fun problem1992() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val board = Array(n) { Array(n) { 0 } }
    repeat(n) { row ->
        val line = br.readLine()
        repeat(n) { col ->
            board[row][col] = line[col].digitToInt()
        }
    }
    quadTree(board, 0, 0, n, bw)
    br.close()
    bw.flush()
    bw.close()
}