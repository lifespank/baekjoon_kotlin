import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_10808() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder("")

    val word = br.readLine()
    val bindo = Array(26) { 0 }
    word.forEach {char ->
        bindo[char.code - 'a'.code]++
    }
    bindo.forEach {
        sb.append(it)
        sb.append(' ')
    }

    br.close()
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}