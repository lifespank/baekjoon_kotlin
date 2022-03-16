import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_2010() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    var sum = 0
    (0 until n).forEach { _ ->
        sum += br.readLine().toInt()
    }
    sum -= n - 1
    bw.write(sum.toString())
    bw.flush()
    bw.close()
}