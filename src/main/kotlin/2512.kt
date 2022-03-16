import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private fun getMaxBudget(limit: Long, budgets: Array<Long>): Pair<Long, Long> {
    var maxVal = 0L
    val total = budgets.fold(0L) { acc, budget ->
        acc + if (limit < budget) {
            maxVal = maxOf(maxVal, limit)
            limit
        } else {
            maxVal = maxOf(maxVal, limit)
            budget
        }
    }
    return Pair(total, maxVal)
}

fun problem2512() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val budgets = Array(n) { 0L }
    var low = 0L
    var high = 0L
    repeat(n) {
        budgets[it] = st.nextToken().toLong()
        high = maxOf(high, budgets[it])
    }
    val m = br.readLine().toLong()
    var ans = 0L
    var maxBudget = 0L
    while (low <= high) {
        val mid = low + (high - low) / 2
        val budget = getMaxBudget(mid, budgets)
        if (budget.first in (maxBudget + 1)..m) {
            maxBudget = budget.first
            ans = budget.second
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    bw.write(ans.toString())
    br.close()
    bw.flush()
    bw.close()
}