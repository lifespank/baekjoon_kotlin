import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

fun problem1308() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val day0 = LocalDateTime.of(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt(), 0, 0)
    st = StringTokenizer(br.readLine())
    val dayx = LocalDateTime.of(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt(), 0, 0)
    if (dayx.year > day0.year + 1000 || (dayx.year == day0.year + 1000 && dayx.dayOfYear >= day0.dayOfYear)) {
        bw.write("gg")
    } else {
        bw.write("D-")
        bw.write(Duration.between(day0, dayx).toDays().toString())
    }
    br.close()
    bw.flush()
    bw.close()
}