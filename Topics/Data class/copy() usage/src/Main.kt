// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val height = readLine()!!.toInt()
    val length1 = readLine()!!.toInt()
    val length2 = readLine()!!.toInt()
    val width = readLine()!!.toInt()

    val box1 = Box(height, length1, width)
    val box2 = box1.copy(length = length2)

    println("Box(height=${box1.height}, length=${box1.length}, width=${box1.width})")
    println("Box(height=${box2.height}, length=${box2.length}, width=${box2.width})")
}