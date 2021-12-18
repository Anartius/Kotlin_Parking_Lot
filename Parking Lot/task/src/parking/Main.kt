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

    val parking = List(20) { Lot() }
    var firstFreeSpot = 0
    var input: MutableList<String>

    while (true) {
        input = readLine()!!.split(" ").toMutableList()

        when(input.first()) {
            "exit" -> break
            "leave" -> leaveSpot(parking, input)
            "park" -> {
                var parkingIsFull = false

                for (i in parking.indices) {
                    if (parking[i].isFree) {
                        firstFreeSpot = i
                        break
                    } else if (i == parking.lastIndex && !parking.last().isFree) {
                        println("Sorry, the parking lot is full.")
                        parkingIsFull = true
                        break
                    } else continue
                }
                if (!parkingIsFull) parkOnSpot(parking, input, firstFreeSpot)
            }
            else -> println("Incorrect input.")
        }
    }
}

fun  parkOnSpot(parking: List<Lot>, input: MutableList<String>, firstFreeSpot: Int) {

    parking[firstFreeSpot].park(input)
    println("${parking[firstFreeSpot].color} car parked in spot ${firstFreeSpot + 1}.")
}

fun leaveSpot(parking: List<Lot>, input: MutableList<String>) {
    val lotNumber = input.last().toInt() - 1

    if (lotNumber <= parking.size) {
        if (!parking[lotNumber].isFree) {
            parking[lotNumber].leave()
            println("Spot ${lotNumber + 1} is free.")
        } else println("There is no car in spot ${lotNumber + 1}.")
    }

}