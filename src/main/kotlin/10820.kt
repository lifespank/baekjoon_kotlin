import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_10820() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder("")
    var line = br.readLine()
    while (line != null) {
        var lower = 0
        var upper = 0
        var number = 0
        var blank = 0
        line.forEach { char ->
            when {
                char.isLowerCase() -> lower++
                char.isUpperCase() -> upper++
                char.isDigit() -> number++
                char == ' ' -> blank++
            }
        }
        sb.append(listOf(lower, upper, number, blank).joinToString(" "))
        sb.append("\n")
        line = br.readLine()
    }
    bw.write(sb.toString())
    br.close()
    bw.flush()
    bw.close()
}