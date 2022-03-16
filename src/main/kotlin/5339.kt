import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun problem_5339() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("""     /~\
    ( oo|
    _\=/_
   /  _  \
  //|/.\|\\
 ||  \ /  ||
============
|          |
|          |
|          |""".trimIndent())
    bw.flush()
    bw.close()
}