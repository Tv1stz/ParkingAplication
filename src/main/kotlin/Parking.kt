object Parking {
    private val parkingPlace = mutableMapOf<String, Car?>()

    init {
        for(i in 1..20) {
            parkingPlace["p$i"] = null
        }
    }

    fun parkCar(car: Car) {
        for(place in parkingPlace) {
            if (place.value == null) {
                parkingPlace[place.key] = car
                println("Машина припаркована. Место ${place.key}")
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