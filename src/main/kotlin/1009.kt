import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun problem_1009() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val testCase = br.readLine().toInt()

    repeat(testCase) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val answer = intPowerModulo(a, b)
        bw.write(
            if (answer == 0) {
                "10"
            } else {
                answer.toString()
            }
        )
        bw.write("\n")
    }

    br.close()
    bw.flush()
    bw.close()
}

private fun intPowerModulo(a: Int, b: Int): Int {
    if (b == 0) {
        return 1
    }
    if (b % 2 != 0) {
        return (a * intPowerModulo(a, b - 1)) % 10
    }
    return (intPowerModulo(a, b / 2) * intPowerModulo(a, b / 2)) % 10
}