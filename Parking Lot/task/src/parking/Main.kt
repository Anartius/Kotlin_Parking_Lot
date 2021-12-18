package parking

class Lot {
    var isFree = true
    var licensePlate = "Nothing"
    var color = "invisibility"

    fun park(input: MutableList<String>) {
        isFree = false
        licensePlate = input[1]
        color = input[2]
    }

    fun leave() {
        isFree = true
        licensePlate = "Nothing"
        color = "invisibility"
    }
}

fun main() {

    val parking = listOf(Lot(), Lot())
    var firstFreeSpot = 0
    parking[0].park(mutableListOf("park", "Boss", "black"))

    val input = readLine()!!.split(" ").toMutableList()
    for (i in parking.indices) {
        if (parking[i].isFree) {
            firstFreeSpot = i
            break
        } else continue
    }
    changeLotStatus(parking, input, firstFreeSpot)
}

fun  changeLotStatus(parking: List<Lot>, input: MutableList<String>, firstFreeSpot: Int) {

    if (input.first() == "park") {
        parking[firstFreeSpot].park(input)
        println("${parking[firstFreeSpot].color} car parked in spot ${firstFreeSpot + 1}.")

    } else if (input.first() == "leave") {
        val lotNumber = input.last().toInt() - 1

        if (lotNumber <= parking.size) {
            if (!parking[lotNumber].isFree) {
                parking[lotNumber].leave()
                println("Spot ${lotNumber + 1} is free.")
            } else println("There is no car in spot ${lotNumber + 1}.")
        }

    } else println("Incorrect input.")

}