import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun combination(arr: Array<Int>, sumList: MutableList<Int>, sum: Int, currIdx: Int) {
    if (currIdx == arr.size) {
        sumList.add(sum)
        return
    }
    combination(arr, sumList, sum + arr[currIdx], currIdx + 1)
    combination(arr, sumList, sum, currIdx + 1)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    val nums = Array(n) { 0 }
    st = StringTokenizer(br.readLine())
    repeat(n) {
        nums[it] = st.nextToken().toInt()
    }
    val arrA = nums.copyOfRange(0, nums.lastIndex / 2)
    val arrB = nums.copyOfRange(nums.lastIndex / 2, nums.lastIndex + 1)
    val sumListA = mutableListOf<Int>()
    val sumListB = mutableListOf<Int>()
    combination(arrA, sumListA, 0, 0)
    combination(arrB, sumListB, 0, 0)
    sumListA.sort()
    sumListB.sort()
    var count = 0L
    var pA = 0
    var pB = sumListB.lastIndex
    while (pA < sumListA.size && pB >= 0) {
        val sum = sumListA[pA] + sumListB[pB]
        when {
            sum < s -> pA++
            sum > s -> pB--
            else -> {
                val valA = sumListA[pA]
                val valB = sumListB[pB]
                var countA = 0L
                var countB = 0L
                while (pA < sumListA.size && valA == sumListA[pA]) {
                    pA++
                    countA++
                }
                while (pB >= 0 && valB == sumListB[pB]) {
                    pB--
                    countB++
                }
                count += countA * countB
            }
        }
    }
    if (s == 0) {
        count--
    }
    bw.write(count.toString())
    br.close()
    bw.flush()
    bw.close()
}