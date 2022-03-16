import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

fun problem_2455() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var stations = 4
    var people = 0
    var maxPeople = 0
    while (stations-- > 0) {
        val st = StringTokenizer(br.readLine())
        var inPassenger = 0
        while (st.hasMoreTokens()) {
            val outs = st.nextToken().toInt()
            val ins = st.nextToken().toInt()
            inPassenger = ins - outs
        }
        people += inPassenger
        if (people > 10000) {
            people = 10000
        }
        maxPeople = max(people, maxPeople)
    }
    bw.write(maxPeople.toString())
    br.close()
    bw.flush()
    bw.close()
}