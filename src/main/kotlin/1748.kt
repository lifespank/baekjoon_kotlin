import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_1748() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    var ans = 0
    var i = 1;
    while (i <= n) {
        ans += n - i + 1;
        i *= 10;
    }
    bw.write(ans.toString())
    br.close()
    bw.flush()
    bw.close()
}