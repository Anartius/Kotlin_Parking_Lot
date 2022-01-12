data class Client(val name: String, val age: Int, val balance: Int)

fun main() {
    val client1 = Client(readLine()!!, readLine()!!.toInt(), readLine()!!.toInt())
    val client2 = Client(readLine()!!, readLine()!!.toInt(), readLine()!!.toInt())

    println(client1.name == client2.name && client1.age == client2.age)
}