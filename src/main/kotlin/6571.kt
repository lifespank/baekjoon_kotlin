import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger
import java.util.*

fun problem6571() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    var a = st.nextToken().toBigInteger()
    var b = st.nextToken().toBigInteger()
    val fibo = mutableListOf<BigInteger>(-BigInteger.ONE, BigInteger.ONE, BigInteger.valueOf(2))
    val limit = StringBuilder("1")
    repeat(10) {
        limit.append("0000000000")
    }
    while (fibo.last() <= BigInteger(limit.toString())) {
        fibo.add(fibo[fibo.lastIndex] + fibo[fibo.lastIndex - 1])
    }
    while (a != BigInteger.ZERO || b != BigInteger.ZERO) {
        var count = 0
        run {
            fibo.forEach {
                if (it in (a..b)) {
                    count++
                } else if (it > b) {
                    return@run
                }
            }
        }
        bw.write(count.toString())
        bw.write("\n")
        st = StringTokenizer(br.readLine())
        a = st.nextToken().toBigInteger()
        b = st.nextToken().toBigInteger()
    }
    br.close()
    bw.flush()
    bw.close()
}