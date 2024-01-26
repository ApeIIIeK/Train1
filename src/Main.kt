import kotlin.random.Random

fun main() {
    // Список городов
    val cities = listOf("Бийск", "Барнаул", "Новосибирск", "Томск", "Омск", "Кемерово", "Красноярск", "Иркутск", "Улан-Удэ", "Чита", "Краснодар", "Екатеринбург", "Оренбург", "Петрозаводск", "Челябинск")

    // Флаг для продолжения или завершения работы
    var createTrainPlan = true
    while (createTrainPlan) {
        // Создание нового направления для поезда
        val fromCity = cities.random() // Выбор случайного города
        var toCity = cities.random() // Выбор случайного города
        while (toCity == fromCity) { // Проверка, что города разные
            toCity = cities.random()
        }
        println("Направление создано: $fromCity - $toCity")

        // Продажа случайного количества билетов
        val numPassengers = Random.nextInt(5, 202)
        println("Продано билетов: $numPassengers")

        // Формирование поезда
        var trainCapacity = 0
        var trainCars = 0
        while (trainCapacity < numPassengers) { // Пока в поезде меньше пассажиров, чем продано билетов
            val carCapacity = Random.nextInt(5, 26) // Случайная вместимость вагона
            trainCapacity += carCapacity // Увеличение общей вместимости поезда
            trainCars++ // Увеличение количества вагонов
        }
        println("Сформирован поезд из $trainCars вагонов с общей вместимостью $trainCapacity мест")

        // Отправка поезда
        println("Отправляем поезд $fromCity - $toCity, состоящий из $trainCars вагонов")
        println("Информация о вагонах и пассажирах...")
        for (i in 1..trainCars) {
            val carCapacity = Random.nextInt(5, 26)
            val passengers = if (i == trainCars) numPassengers % carCapacity else carCapacity // Распределение пассажиров по вагонам
            println("Вагон $i: вместимость - $carCapacity, пассажиры - $passengers")
        }

        // Запрос на завершение или продолжение работы
        println("Хотите завершить работу? Введите 'EXIT' для выхода или нажмите Enter для продолжения:")
        val input = readLine()
        if (input?.toUpperCase() == "EXIT") createTrainPlan = false
    }
}
