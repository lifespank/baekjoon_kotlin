import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val line = br.readLine()
    val realLine = StringBuilder("")
    line.forEach {
        if (it == '*') {
            realLine.append(".*")
        } else {
            realLine.append(it)
        }
    }
    val regex = Regex(realLine.toString())
    repeat(n) {
        if (regex.matches(br.readLine())) {
            bw.write("DA\n")
        } else {
            bw.write("NE\n")
        }
    }
    br.close()
    bw.flush()
    bw.close()
}