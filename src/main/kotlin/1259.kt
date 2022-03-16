import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun problem_1259() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder("")
    var num = br.readLine()
    while(num != "0") {
        isPalindrome(num, sb)
        num = br.readLine()
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}

private fun isPalindrome(num: String, sb: StringBuilder) {
    var l = 0
    var h = num.length - 1
    while (h > l) {
        if (num[l++] != num[h--]) {
            sb.append("no\n")
            return
        }
    }
    sb.append("yes\n")
}