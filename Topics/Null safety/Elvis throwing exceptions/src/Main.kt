fun main() {
    print("Elvis says: ${readLine() ?: throw IllegalStateException()}")
}