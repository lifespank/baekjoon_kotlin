import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_15680() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    if (n == 0) {
        bw.write("YONSEI")
    } else {
        bw.write("Leading the Way to the Future")
    }

    br.close()
    bw.flush()
    bw.close()
}