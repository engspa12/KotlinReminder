package constants

//constant used on top level
const val ROCKS = 3
val number = 5

const val NUM = 15

val result = complexFunction()
//error in the next line
//const val result2 = complexFunction()

const val CONSTANT = "top-level constant"

fun main() {
    //Use the constant inside object class Cat
    val foo = Cat.AGE

    println(foo)
    println(Cat.color)

    println(CONSTANT)
    println(ROCKS)
    println(NUM)

    println(number)
    println(result)

    println(MyClass.CONSTANT_EXAMPLE)
    println(ExampleConst.BASE_URL)

    println(canBorrow(15))

    printUrl()
}

fun complexFunction(): String{
    return "Hello Kotlin"
}

object Cat{
    //constant used in object type class
    const val AGE = 15
    val color = "gray"
}


class MyClass{

    //constant used inside a regular class
    companion object {
        const val CONSTANT_EXAMPLE = "constant inside companion"
    }
}

const val MAX_NUMBER = 20
val title = "Snape"

fun canBorrow(hasBooks: Int): Boolean{
    return (hasBooks < MAX_NUMBER)
}

object Constants{
    const val BASE_URL = "http://..."
}

fun printUrl(){
    println(Constants.BASE_URL + title + ".html")
}

class ExampleConst{

    companion object {
        const val BASE_URL = "http://..."
    }
}
