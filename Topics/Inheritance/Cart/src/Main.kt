fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = when (productType) {
        "headphones" -> Headphones(price)
        "smartphone" -> Smartphone(price)
        "tv" -> Tv(price)
        else -> Laptop(price)
    }
    println(product.totalPrice())
}

open class Product(private val price: Int) {
    open val tax = 0.0
    fun totalPrice(): Int {
        return price + (price * tax).toInt()
    }
}

class Headphones(price: Int) : Product(price) {
    override val tax = 0.11
}

class Smartphone(price: Int) : Product(price) {
    override val tax = 0.15
}

class Tv(price: Int) : Product(price) {
    override val tax = 0.17
}

class Laptop(price: Int) : Product(price) {
    override val tax = 0.19
}