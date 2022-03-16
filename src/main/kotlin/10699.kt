import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun problem_10699() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val current = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))
    val formatter = DateTimeFormatter.ISO_LOCAL_DATE
    val formatted = current.format(formatter)
    bw.write(formatted)

    bw.flush()
    bw.close()
}