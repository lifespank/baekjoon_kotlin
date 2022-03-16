import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.max

private var maxVar = 0

private fun ArrayDeque<Pair<Int, Boolean>>.insertNum(num: Int) {
    if (num > 0) {
        if (this.isEmpty()) {
            this.addLast(num to false)
        } else if (!this.last().second && this.last().first == num) {
            this.removeLast()
            this.addLast(num shl 1 to true)
        } else {
            this.addLast(num to false)
        }
    }
}

private fun Array<Array<Int>>.updateCoord(row: Int, col: Int, deq: ArrayDeque<Pair<Int, Boolean>>) {
    if (deq.isNotEmpty()) {
        this[row][col] = deq.first().first
        deq.removeFirst()
    } else {
        this[row][col] = 0
    }
}

private fun moveUp(board: Array<Array<Int>>) {
    for (col in board[0].indices) {
        val deq = ArrayDeque<Pair<Int, Boolean>>()
        for (row in board.indices) {
            deq.insertNum(board[row][col])
        }
        for (row in board.indices) {
            board.updateCoord(row, col, deq)
        }
    }
}

private fun moveDown(board: Array<Array<Int>>) {
    for (col in board[0].indices) {
        val deq = ArrayDeque<Pair<Int, Boolean>>()
        for (row in board.size - 1 downTo 0) {
            deq.insertNum(board[row][col])
        }
        for (row in board.size - 1 downTo 0) {
            board.updateCoord(row, col, deq)
        }
    }
}

private fun moveLeft(board: Array<Array<Int>>) {
    for (row in board.indices) {
        val deq = ArrayDeque<Pair<Int, Boolean>>()
        for (col in board[row].indices) {
            deq.insertNum(board[row][col])
        }
        for (col in board[row].indices) {
            board.updateCoord(row, col, deq)
        }
    }
}

private fun moveRight(board: Array<Array<Int>>) {
    for (row in board.indices) {
        val deq = ArrayDeque<Pair<Int, Boolean>>()
        for (col in board[row].size - 1 downTo 0) {
            deq.insertNum(board[row][col])
        }
        for (col in board[row].size - 1 downTo 0) {
            board.updateCoord(row, col, deq)
        }
    }
}

private fun Array<Array<Int>>.maxVal(): Int {
    var maxValue = Int.MIN_VALUE
    this.forEach { row ->
        row.forEach { num ->
            maxValue = maxOf(maxValue, num)
        }
    }
    return maxValue
}

private fun Array<Array<Int>>.copy(): Array<Array<Int>> = Array(this.size) { row ->
    Array(this[row].size) { col ->
        this[row][col]
    }
}

private fun solve(board: Array<Array<Int>>, depth: Int) {
    if (depth == 5) {
        maxVar = max(maxVar, board.maxVal())
        return
    }
    for (i in 0..3) {
        val newBoard = board.copy()
        when (i) {
            0 -> moveUp(newBoard)
            1 -> moveDown(newBoard)
            2 -> moveRight(newBoard)
            3 -> moveLeft(newBoard)
        }
        solve(newBoard, depth + 1)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val board = Array(n) { Array(n) { 0 } }
    repeat(n) { row ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { col ->
            board[row][col] = st.nextToken().toInt()
        }
    }
    solve(board, 0)
    bw.write(maxVar.toString())
    br.close()
    bw.flush()
    bw.close()
}