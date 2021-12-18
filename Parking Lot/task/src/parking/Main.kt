package parking

class Lot {
    var isBusy = false
    var licensePlate = "Nothing"
    var color = "invisibility"

    fun park(input: MutableList<String>) {
        isBusy = true
        licensePlate = input[1]
        color = input[2]
    }

    fun leave() {
        isBusy = false
        licensePlate = "Nothing"
        color = "invisibility"
    }
}

fun main() {

    var parking = mutableListOf(Lot())
    var firstFreeSpot = 0
    var input: MutableList<String>
    var sizeDefined = false

    while (true) {
        input = readLine()!!.split(" ").toMutableList()

        if (!sizeDefined) {
            when(input.first()) {
                "exit" -> break
                "create" -> {
                    parking = MutableList(input.last().toInt()) { Lot() }
                    sizeDefined = true
                    println("Created a parking lot with ${parking.size} spots.")
                    continue
                }
                else  -> {
                    println("Sorry, a parking lot has not been created.")
                    continue
                }
            }
        }

        when(input.first()) {
            "exit" -> break
            "create" -> {
                parking = MutableList(input.last().toInt()) { Lot() }
                println("Created a parking lot with ${parking.size} spots.")
            }
            "status" -> printStatus(parking)
            "leave" -> leaveSpot(parking, input)
            "park" -> {
                var parkingIsFull = false

                for (i in parking.indices) {
                    if (!parking[i].isBusy) {
                        firstFreeSpot = i
                        break
                    } else if (i == parking.lastIndex && parking.last().isBusy) {
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

fun  parkOnSpot(parking: MutableList<Lot>, input: MutableList<String>, firstFreeSpot: Int) {

    parking[firstFreeSpot].park(input)
    println("${parking[firstFreeSpot].color} car parked in spot ${firstFreeSpot + 1}.")
}

fun leaveSpot(parking: MutableList<Lot>, input: MutableList<String>) {
    val lotNumber = input.last().toInt() - 1

    if (lotNumber <= parking.size) {
        if (parking[lotNumber].isBusy) {
            parking[lotNumber].leave()
            println("Spot ${lotNumber + 1} is free.")
        } else println("There is no car in spot ${lotNumber + 1}.")
    }

}

fun printStatus(parking: MutableList<Lot>) {
    var amountOfFreeSpots = 0
    for (i in parking.indices) {
        if (parking[i].isBusy) {
            println("${i + 1} ${parking[i].licensePlate} ${parking[i].color}")
        } else amountOfFreeSpots++
    }
    if (amountOfFreeSpots == parking.size) println("Parking lot is empty.")
}