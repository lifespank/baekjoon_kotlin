import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_1100() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var count = 0
    repeat(8) { row ->
        val line = br.readLine()
        line.forEachIndexed { col, char ->
            if ((row + col) and 1 == 0 && char == 'F') { //짝수 위에 말
                count++
            }
        }
    }
    bw.write(count.toString())
    br.close()
    bw.flush()
    bw.close()
}