import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toLong()
    val period = 1500000
    val fibo = Array(period + 1) { 0L }
    fibo[1] = 1
    for (i in 2 until period) {
        fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000L
    }
    bw.write((fibo[(n % period).toInt()]).toString())
    br.close()
    bw.flush()
    bw.close()
}