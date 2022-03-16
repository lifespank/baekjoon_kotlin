import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_1032() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val sb = StringBuilder(br.readLine())
    repeat(n - 1) {
        br.readLine().forEachIndexed { idx, char ->
            if (sb[idx] != '?' && sb[idx] != char) {
                sb[idx] = '?'
            }
        }
    }
    bw.write(sb.toString())
    br.close()
    bw.flush()
    bw.close()
}