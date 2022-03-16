import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private data class Tree(
    val data: Char,
    var left: Tree? = null,
    var right: Tree? = null,
    val leftChar: Char? = null,
    val rightChar: Char? = null
)

private fun preOrderTraverse(tree: Tree?, bw: BufferedWriter) {
    tree?.let { tr ->
        bw.write(tree.data.toString())
        preOrderTraverse(tr.left, bw)
        preOrderTraverse(tr.right, bw)
    }
}

private fun inOrderTraverse(tree: Tree?, bw: BufferedWriter) {
    tree?.let { tr ->
        inOrderTraverse(tr.left, bw)
        bw.write(tree.data.toString())
        inOrderTraverse(tr.right, bw)
    }
}

private fun postOrderTraverse(tree: Tree?, bw: BufferedWriter) {
    tree?.let { tr ->
        postOrderTraverse(tr.left, bw)
        postOrderTraverse(tr.right, bw)
        bw.write(tr.data.toString())
    }
}

private fun insert(tree: Tree?, toBeInserted: Tree) {
    tree?.let { tr ->
        if (tr.leftChar == toBeInserted.data) {
            tr.left = toBeInserted
        } else if (tr.rightChar == toBeInserted.data) {
            tr.right = toBeInserted
        }
        insert(tr.left, toBeInserted)
        insert(tr.right, toBeInserted)
    }
}

fun problem1991() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    val root = Tree(st.nextToken().single(), leftChar = st.nextToken().single(), rightChar = st.nextToken().single())
    repeat(n - 1) {
        st = StringTokenizer(br.readLine())
        insert(
            root,
            Tree(st.nextToken().single(), leftChar = st.nextToken().single(), rightChar = st.nextToken().single())
        )
    }
    preOrderTraverse(root, bw)
    bw.write("\n")
    inOrderTraverse(root, bw)
    bw.write("\n")
    postOrderTraverse(root, bw)
    br.close()
    bw.flush()
    bw.close()
}