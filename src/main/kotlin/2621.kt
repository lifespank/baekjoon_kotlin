import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val regex = Regex("(100+1+|01)+")
    val line = br.readLine()
    if (regex.matches(line)) {
        bw.write("SUBMARINE")
    } else {
        bw.write("NOISE")
    }
    br.close()
    bw.flush()
    bw.close()
}