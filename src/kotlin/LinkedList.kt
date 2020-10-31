package kotlin

// ©2020 Mahmoud Darwish
class LinkedList<T> {
    inner class Node(
        var t: T,
        var prev: Node? = null,
        var next: Node? = null
    )

    var head: Node? = null
    var tail: Node? = null

    fun add(t: T) {
        val node = Node(t)

        when {
            head != null && tail != null -> {
                tail = tail?.run { node.prev = this; next = node; next; }
            }
            head == null && tail == null -> {
                head = node; tail = node;
            }
        }

        tail?.next = head
        head?.prev = tail
    }
}

fun main() {
    val linkedList = LinkedList<Int>()

    linkedList.add(1)
    linkedList.add(2)
    linkedList.add(3)
    linkedList.add(4)
    linkedList.add(5)


    println("Printing elements starting at the tail and going back to the head")
    var tail = linkedList.tail
    do {
        tail = tail.also { println(it?.t) }.run { this?.prev }
    } while (tail != linkedList.tail)


    //---------------------------------------------
    println("Printing elements starting at the head and going up to the tail")
    var head = linkedList.head
    do {
        head = head.also { println(it?.t) }.run { this?.next }
    } while (head != linkedList.head)
}