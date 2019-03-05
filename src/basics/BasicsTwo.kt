package basics

import classes.Fish

fun main(args: Array<String>) {

    val myTest = classes.TestKotlin(12)
    //myTest.volume = 12;

    println(myTest.width)
    println(myTest.volume)

    myTest.volume = 5670
    println(myTest.volume)

    fun makeDefaultFish() = classes.Fish(true,50)
    fishExample()

    makeFish()
}

fun fishExample(){
    val fish = Fish(true, 20)
    val secondFish = Fish()
    println("Is the fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
    println("Our second fish is friendly? ${secondFish.friendly}. It needs volume ${secondFish.size}")
}

//Abstract Class
abstract class AquariumFish{
    abstract val color: String
}

//A class without primary constructor parameters can be written with or without parenthesis
class Shark(): AquariumFish(),FishAction{
    override val color = "gray"

    override fun eat() {
        println("Shark eating")
    }
}

//A class without primary constructor parameters can be written with or without parenthesis
class Dolphin: AquariumFish(),FishAction{
    override val color = "blue"

    override fun eat() {
        println("Dolphin eating")
    }
}

//Interface
interface FishAction{
    fun eat()
}

fun feedFish(fish: FishAction){
    fish.eat()
}

fun makeFish(){

    //Object creation
    val shark = Shark()
    //Object creation
    val dolphin = Dolphin()

    println("Shark: ${shark.color} \nDolphin: ${dolphin.color}")

    shark.eat()
    dolphin.eat()

    feedFish(shark)
    feedFish(dolphin)
}