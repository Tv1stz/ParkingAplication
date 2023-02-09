object Parking {
    private val parkingPlace = mutableMapOf<String, Car?>()
    private var numberOfParkedCars = 0

    init {
        for(i in 1..20) {
            parkingPlace["p$i"] = null
        }
    }

    fun getNumberOfParkedCars() {
        println("Количество припаркованных машин за время работы: $numberOfParkedCars ")
    }

    fun showPark() {
        for (place in parkingPlace) {
            if (place.value == null) {
                println("${place.key} = свободно")
            } else {
                println(place)
            }
        }
    }

    fun parkCar(car: Car) {
        for(place in parkingPlace) {
            if (place.value == null) {
                parkingPlace[place.key] = car
                println("Машина припаркована. Место ${place.key}")
                numberOfParkedCars++
                break
            }
        }
    }

    fun returnCar(owner: Owner) {
        var flag = false
        for (place in parkingPlace) {
            if(owner == place.value?.owner) {
                println("Ваша машина на месте ${place.key}. Можете забрать её")
                parkingPlace[place.key] = null
                flag = true
            }
        }
        if(!flag) println("Некорректный ввод")
    }

    fun showInfoByCar(carNumber: String) {
        var flag = false
        for (place in parkingPlace) {
            if(carNumber == place.value?.number) {
                println("Ваша машина на месте ${place.key}.")
                flag = true
            }
        }
        if(!flag) println("Некорректный ввод")
    }

    fun showInfoByPlace(place: String) {
        if (parkingPlace[place] == null) {
            println("свободно")
        } else {
            println(parkingPlace[place])
        }
    }
}