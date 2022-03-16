import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.text.StringBuilder

fun problem_11723() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var set = 0
//    val m = readLine()?.toInt()!!
    var m = br.readLine().toInt()
    val strBuilder = StringBuilder("")
    while (m-- > 0) {
        val st = StringTokenizer(br.readLine())
        val opr = st.nextToken()
        val x = if (st.hasMoreTokens()) {
            st.nextToken().toInt()
        } else {
            -1
        }
        val bitX = 1 shl (x - 1)
        when (opr) {
            "add" -> set = set or bitX
            "remove" -> set = set and (bitX.inv())
            "check" -> check(set, bitX, strBuilder)
            "toggle" -> set = set xor bitX
            "all" -> set = 1048575
            "empty" -> set = 0
        }
    }
    bw.write(strBuilder.toString())
    bw.flush()
    bw.close()
}

private fun check(set: Int, bitX: Int, stringBuilder: StringBuilder) {
    if (set and bitX > 0) {
        stringBuilder.append("1\n")
    } else {
        stringBuilder.append("0\n")
    }
}