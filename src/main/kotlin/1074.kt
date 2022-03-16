import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private var depth = 0

private fun traverse(x: Int, y: Int, targetX: Int, targetY: Int, size: Int, bw: BufferedWriter) {
    if (x == targetX && y == targetY) {
        bw.write(depth.toString())
        return
    }
    if (targetX in (x until x + size) && targetY in (y until y + size)) {
        traverse(x, y, targetX, targetY, size shr 1, bw)
        traverse(x, y + (size shr 1), targetX, targetY, size shr 1, bw)
        traverse(x + (size shr 1), y, targetX, targetY, size shr 1, bw)
        traverse(x + (size shr 1), y + (size shr 1), targetX, targetY, size shr 1, bw)
    } else {
        depth += size * size
    }
}

fun problem1074() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    traverse(0, 0, r, c, 1 shl n, bw)
    br.close()
    bw.flush()
    bw.close()
}