package pairs

fun main() {

    val equipment = "fishnet" to "catching fish"

    println(equipment.first)
    println(equipment.second)

    val secondEquipment = "fishnet" to "catching fish" to "of big size" to "and strong"

    println(secondEquipment)

    println(secondEquipment.first)
    println(secondEquipment.second)
    println(secondEquipment.first.first)
    println(secondEquipment.first.second)
    println(secondEquipment.first.first.first)
    println(secondEquipment.first.first.second)

    //It's not same as in the case of secondEquipment
    val equip = ("fishnet" to "catching fish") to ("of big size" to "and strong")

    println(equip)

    val fishnet = "fishnet" to "catching fish"

    val(tool, use) = fishnet

    println("The $tool is a tool for $use.")

    val fishnetString = fishnet.toString()

    println(fishnetString)
    println(fishnet.toList())

    val(toolTwo,useTwo) = giveMeATool()
    println(toolTwo)
    println(useTwo)

    val(a, b, c) = Triple(2 , "x", listOf(null))

    println(a)
    println(b)
    println(c)

    val book = Book("Romen", "William", 1597)

    val bookTitleAuthor = book.getTitleAuthor();
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println(bookTitleAuthor.first)
    println(bookTitleAuthor.second)

    println(bookTitleAuthorYear.first)
    println(bookTitleAuthorYear.second)
    println(bookTitleAuthorYear.third)
}


fun giveMeATool(): Pair<String, String>{
    return ("fishnet" to "catching fish again")
}

class Book(val title: String, val author: String, val year: Int){

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int>{
        return Triple(title, author, year)
    }
}

