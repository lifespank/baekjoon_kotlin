import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private fun factorial(n: Int): Int {
    if (n == 0) {
        return 1
    }
    if (n == 1) {
        return 1
    }
    return (1..n).reduce { multiple, num ->
        multiple * num
    }
}

fun problem_11050() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    var k = st.nextToken().toInt()
    if (k > n / 2F) {
        k = n - k
    }
    if (k == 0) {
        bw.write("1")
    } else {
        bw.write(((n - k + 1..n).reduce { multiple, num ->
            multiple * num
        } / factorial(k)).toString())
    }
    br.close()
    bw.flush()
    bw.close()
}