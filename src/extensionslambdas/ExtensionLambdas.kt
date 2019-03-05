package extensionslambdas

import classes.Fish

fun main() {
//    val myCatList = listOf(Cat("Flipper"), Cat("Moby Dick"), Cat("Dury"))
//    val newList = myCatList.filter { it.name.contains("i") }.joinToString(" ") { it.name }
//    println(newList)
//
   val game = Game()
//    println("Before: " + game.path)
//    game.north()
//    game.south()
//    game.east()
//    game.west()
//    game.end()
//    println("After: " + game.path)

//    fishExamples()
//    fishExamples2()
//
//    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
//    println(numbers.divisibleBy { it.rem(3) })

    while (true){
        println("Enter a direction (n/s/e/w): ")
        game.makeMove(readLine())
    }
}

class Cat(val name: String)

enum class Direction{
    NORTH, EAST, WEST, SOUTH, START, END
}

class Game{
    var path = mutableListOf<Direction>(Direction.START)
    val north = {path.add(Direction.NORTH)}
    val south = {path.add(Direction.SOUTH)}
    val east = {path.add(Direction.EAST)}
    val west = {path.add(Direction.WEST)}
    val end = {path.add(Direction.END); println("Game Over: $path"); path.clear(); false}

    fun makeMove(command: String?){
        if(command.equals("n")) move(north)
        else if (command.equals("s")) move(south)
        else if (command.equals("e")) move(east)
        else if (command.equals("w")) move(west)
        else move(end)
    }

    fun move(where: () -> Boolean){
        where.invoke()
    }
}


data class Fish(var name: String)

fun fishExamples(){
    val fish = Fish("splashy")

    with(fish.name){
        this.capitalize()
    }
}

fun fishExamples2(){

    val fish = Fish("splashy")

    myWith(fish.name){
        println(capitalize())
    }

    println(fish.run{name})
    println(fish.apply{})

    val fish2 = Fish(name = "splashy").apply { name = "Sharky" }

    println(fish2.name)
    println(fish.let { it.name.capitalize() }
        .let { "$it fish" }
        .let { it.length }
        .let {it + 31})

}

fun myWith(name: String, block: String.() -> Unit){
    name.block()
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int>{
    val result = mutableListOf<Int>()
    for(item in this){
        if(block(item) == 0){
            result.add(item)
        }
    }

    return result
}

fun fishExamples3(){
    val fish = Fish("watty")

    myWithTwo(fish.name, object : Function1<String, Unit>{
        override fun invoke(name: String) {
            name.capitalize()
        }
    })

    //This is how it looks when we use inline, we do NOT create a lambda object every time myWithTwo() is called
    //fish.name.capitalize()
}

inline fun myWithTwo(name: String, block: String.() -> Unit){
    name.block()
}








