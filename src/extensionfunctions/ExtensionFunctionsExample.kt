package extensionfunctions

import kotlin.random.Random

fun main() {
    extensionsExample()
    staticExample()

    propertyExample()
    nullableExample()

    val puppy = Puppy()
    val book = Book("Oliver Twist", "Charles Dickens", 1837, 540)

    while(book.pages > 0){
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }

    println("Sad puppy, no more pages in ${book.title}")
}

fun String.hasSpaces(): Boolean{
    val found = this.find { it == ' ' }
    return found != null
}

fun extensionsExample(){
    println("Does it have spaces?".hasSpaces())
}

fun String.hasSpacesTwo() = find { it == ' ' } != null

open class Aquarium (val color: String, private val size: Int)

class GreenPlant (size: Int): Aquarium("Green", size)

fun Aquarium.isRed() = color == "Red"

fun Aquarium.print() = println("Aquarium")
fun GreenPlant.print() = println("GreenPlant")

fun staticExample(){
    val plant = GreenPlant(size = 50)
    plant.print()

    val aquariumPlant: Aquarium = plant
    aquariumPlant.print()
}

class AquariumPlant(val color: String, private val size: Int)

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"


fun propertyExample(){
    val plant = AquariumPlant("Blue", 50)
    println(plant.isGreen)
}

fun AquariumPlant?.pull(){
    this?.apply {
        println("removing $this")
    }
    println("$this")
}

fun nullableExample(){
    val plant: AquariumPlant? = AquariumPlant("Red", 78)
    val plantTwo: AquariumPlant? = null
    plant.pull()
    plantTwo.pull()
}

class Book(val title: String, val author:String, val year: Int, var pages: Int)

class Puppy(){
    fun playWithBook(book: Book){
        book.tornPage(Random.nextInt(12))
    }
}

fun Book.weight(): Double{ return pages * 1.5}

fun Book.tornPage(torn: Int) = if(pages >= torn) pages -= torn else pages = 0





