class Manager {
    fun getCommand() {
        println("Введите команду \"/start\":")
        while (true) {
            when (readln().lowercase()) {
                Commands.START -> start()
                Commands.END -> {
                    println("Всего доброго")
                    break
                }

                Commands.PARK -> parkCar()
                Commands.RETURN -> returnCar()
                Commands.PARK_INFO_BY_PLACE -> parkInfoByPlace()
                Commands.PARK_INFO_BY_CAR -> parkInfoByCar()
                Commands.HELP -> help()
                else -> printErrorMessage()
            }
        }
    }

    private fun parkInfoByPlace() {
        println("Введите парковочное место: \"Пример: p1\". Всего 20 мест")
        val numberPlace = readln().lowercase()
        Parking.showInfoByPlace(numberPlace)
    }

    private fun parkInfoByCar() {
        println("Введите номер машины")
        val carNumber = readln().lowercase()
        Parking.showInfoByCar(carNumber)
    }

    private fun returnCar() {
        println("Введите имя и фамилию клиента")
        val nameOwner = readln().lowercase().split(" ")
        val owner = Owner(nameOwner[0], nameOwner[1])
        Parking.returnCar(owner)
    }

    private fun parkCar() {
        val car = addCarInfo()
        if (car != null) {
            Parking.parkCar(car)
        }
    }

    private fun help() {
        println(
            """
        /start - комманда для запуска программы
        /end - комманды для завершения работы программы
        /return - возвращает автомобиль.
        /park_info_by_car - возвращает место, где припаркована машина, по ее номеру
        /park - паркует автомобиль на любое свободное место
        /park_info_by_place - возвращает информацию о машине по месту на парковке
    """.trimIndent()
        )
    }

    private fun addCarInfo(): Car? {
        var car: Car? = null
        println(
            """
            Введите данные о машине в формате:
            марка, цвет, регистрационный номер автомобиля, имя и фамилия владельца
        """.trimIndent()
        )
        val carInfo = readln().lowercase().split(" ")
        if (carInfo.size < 5) {
            println("Некорректный ввод")
        } else {
            car = Car(
                carInfo[0],
                carInfo[1],
                carInfo[2],
                Owner(
                    carInfo[3],
                    carInfo[4],
                )
            )
        }
        return car
    }

    private fun start() {
        println(
            """
            Добро пожаловать в приложение для парковки автомобилей!
            Для получения информации о командах используйте /help
        """.trimIndent()
        )
    }

    private fun printErrorMessage() {
        println("Команда недоступна, для получения информации о командах используйте /help")
    }
}