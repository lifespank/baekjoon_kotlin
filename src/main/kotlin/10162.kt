import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_10162() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var cookTime = br.readLine().toInt()
    var aCount = 0
    var bCount = 0
    var cCount = 0
    if (cookTime % 10 != 0) {
        bw.write("-1")
    } else {
        aCount += cookTime / 300
        cookTime %= 300
        bCount += cookTime / 60
        cookTime %= 60
        cCount += cookTime / 10
        bw.write(aCount.toString())
        bw.write(" ")
        bw.write(bCount.toString())
        bw.write(" ")
        bw.write(cCount.toString())
    }

    br.close()
    bw.flush()
    bw.close()
}