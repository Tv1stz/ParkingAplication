fun main() {
    var flag = false

    while (true) {
        when(readln()) {
            Commands.START -> {
                println("Добро пожаловать")
                flag = true
            }
            Commands.HELP -> help()
            Commands.END -> {
                if(end(flag)) break
            }
            else -> println("программа не может обработать запрос, вы можете вызвать команду \"${Commands.HELP}\"")
        }
    }
}

fun help() {
    println("""
        /start - комманда для запуска программы
        /end - комманды для завершения работы программы
    """.trimIndent())
}

fun end(flag: Boolean): Boolean =
    if (flag) {
        println("Вы завершили программу")
        true
    } else {
        println("Вы еще не запустили программу. Введите \"${Commands.START}\"")
        false
    }