package kotlin

fun main() {
    Array<Int>(7) { (10..20).random() }
        .also { it.insertionSort() }
        .joinToString(" ") { it.toString() }
        .also(::println)
}

fun <T : Comparable<T>> Array<T>.insertionSort() {
    for (i in 1..lastIndex) {
        var j = i
        while (j > 0 && get(j) < get(j - 1)) swap(j, --j)
    }
}

private fun <T : Comparable<T>> Array<T>.quickSort(l: Int = 0, r: Int = this.lastIndex) {
    if (l >= r) return

    val p = partition(l, r)
    this.quickSort(l, p - 2)
    this.quickSort(p, r)
}

private fun <T : Comparable<T>> Array<T>.partition(l: Int, r: Int): Int =
    run { var p = l; (l..r).forEach { if (this[it] <= this[r]) swap(it, p++) }; p }

private fun <T> Array<T>.swap(i: Int, j: Int) = apply { val t = this[i]; this[i] = this[j]; this[j] = t; }
