import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val p = br.readLine().toInt()
    repeat(p) {
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        var count = 0
        var f1 = 0
        var f2 = 1
        while (true) {
            val temp = f1
            f1 = f2
            f2 = (temp + f1) % m
            count++
            if (f1 == 0 && f2 == 1) {
                break
            }
        }
        bw.write(n.toString())
        bw.write(" ")
        bw.write(count.toString())
        bw.write("\n")
    }
    br.close()
    bw.flush()
    bw.close()
}