import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private var COUNT = 0

private fun setQueen(
    rowNum: Int,
    n: Int,
    colCheck: Array<Boolean>,
    leftDiagCheck: Array<Boolean>,
    rightDiagCheck: Array<Boolean>
) {
    if (rowNum == n) {
        COUNT++
        return
    }
    repeat(n) { colNum ->
        if (!colCheck[colNum] && !leftDiagCheck[rowNum - colNum + n - 1] && !rightDiagCheck[rowNum + colNum]) {
            colCheck[colNum] = true
            leftDiagCheck[rowNum - colNum + n - 1] = true
            rightDiagCheck[rowNum + colNum] = true
            setQueen(rowNum + 1, n, colCheck, leftDiagCheck, rightDiagCheck)
            colCheck[colNum] = false
            leftDiagCheck[rowNum - colNum + n - 1] = false
            rightDiagCheck[rowNum + colNum] = false
        }
    }
}

fun problem9663() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val colCheck = Array(n) { false }
    val leftDiagCheck = Array(2 * n - 1) { false }
    val rightDiagCheck = Array(2 * n - 1) { false }
    setQueen(0, n, colCheck, leftDiagCheck, rightDiagCheck)
    bw.write(COUNT.toString())
    br.close()
    bw.flush()
    bw.close()
}