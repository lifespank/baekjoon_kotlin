import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun problem_5338() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(
        """       _.-;;-._
'-..-'|   ||   |
'-..-'|_.-;;-._|
'-..-'|   ||   |
'-..-'|_.-''-._|""".trimIndent()
    )
    bw.flush()
    bw.close()
}