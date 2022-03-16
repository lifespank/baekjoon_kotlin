import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun problem_2490() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var line = br.readLine()
    while (line != null) {
        val st = StringTokenizer(line)
        var count = 0
        while (st.hasMoreTokens()) {
            if (st.nextToken().toInt() == 0) {
                count++
            }
        }
        when (count) {
            0 -> bw.write("E\n")
            1 -> bw.write("A\n")
            2 -> bw.write("B\n")
            3 -> bw.write("C\n")
            4 -> bw.write("D\n")
        }
        line = br.readLine()
    }

    br.close()
    bw.flush()
    bw.close()
}