import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_2576() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var maxVal = Int.MAX_VALUE
    var sum = 0
    repeat(7) {
        val num = br.readLine().toInt()
        if (num and 1 != 0) {
            if (num < maxVal) {
                maxVal = num
            }
            sum += num
        }
    }
    if (maxVal == Int.MAX_VALUE) {
        maxVal = -1
    }
    if (sum != 0) {
        bw.write(sum.toString())
        bw.write("\n")
    }
    bw.write(maxVal.toString())

    br.close()
    bw.flush()
    bw.close()
}