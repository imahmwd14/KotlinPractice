package kotlin

fun main() {
    println(10.fib5().joinToString())
}

fun Int.fib5(): IntArray =
    IntArray(this).apply { indices.forEach { set(it, if (it < 2) it else get(it - 2) + get(it - 1)) } }
