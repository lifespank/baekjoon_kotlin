import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem1339() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val alphas = Array(26) { 0 }
    repeat(n) {
        val temp = br.readLine()
        var place = 1
        temp.reversed().forEach { c ->
            alphas[c - 'A'] += place
            place *= 10
        }
    }
    alphas.sortDescending()
    bw.write(alphas.foldIndexed(0) { index, acc, i -> acc + i * (9 - index) }.toString())
    br.close()
    bw.flush()
    bw.close()
}