package basics

import java.util.*

fun main(args: Array<String>) {
    println("\nYour fortune is: ${getFortune()}")
    var fortune: String
    for(i in 1..10){
        fortune = getFortune()
        println("\nYour fortune is: $fortune")
        if(fortune.contains("Take it easy")) break
    }

    swim( 50,wind="mild")
    println(whatShould("angry","cloudy"))
    println(changeWater(3,6, "Monday"))

    repeat(2){
        println("Repeat this sentence")
    }
    println("\nWrite action: ")
    println(whatToDo(readLine()!!))

    val decorations = listOf("rock", "pagoda", "plant", "alligator", "flowerpot")

    var spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    val lazyMap = decorations.asSequence().map {
        println("map: $it")
        it
    }

    println(lazyMap)
    println("first : ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")

    val filterOne = spices.take(5)
    val filterTwo = spices.take(3).filter { it.startsWith('c') }
    println(filterOne)
    println(filterTwo)

    val waterFilterPre = {dirty: Int -> dirty / 2}

    println(waterFilterPre(22))

    val waterFilter : (Int) -> Int = {dirty -> dirty / 2}

    println(waterFilter(12))

    //It returns dirty + 10
    //One line function declaration
    fun addTen(dirty: Int) = dirty + 10

    println(addTen(50))

    val random1 = Random().nextInt(4)

    val random2 = {Random().nextInt(4)}

    println(random1)
    println(random2)
}

//Global variable
var dirtyTwo = 50

fun randomDay(): String{
    val week = listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    return week[Random().nextInt(7)]
}

fun getFortune(): String{
    val fortunes = listOf("Good job!","Happy Day!","Take it easy!","Thrive on!","Funny things")
    print("\nEnter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?:1
    return fortunes[birthday.rem(fortunes.size)]
}

fun swim(time: Int, speed: String="fast", wind: String = "strong"){
    println("Swimming $speed and my time is $time and the wind is $wind")
}

fun whatShould(mood: String, weather: String = "sunny"): String{
    return when{
        mood == "happy" && weather == "sunny" -> "Go for a walk"
        else -> "Stay home and read"
    }
}

fun isTooHot(temperature : Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun changeWater(temperature: Int, dirty :Int, day: String ): Boolean{
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun whatToDo(action: String): String{
    return "Action is: $action"
}