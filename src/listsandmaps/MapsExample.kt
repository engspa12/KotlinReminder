package listsandmaps

fun main() {

    val cures = mapOf("white spots" to "Ich",
        "red sores" to "hole disease")

    println(cures.get("white spots"))
    println(cures["white spots"])

    println(cures.getOrDefault("bloating", "Sorry, I don't know"))

    println(cures.getOrElse("bloating"){"No cure for this"})

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish net")

    println(inventory)

    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A dream")

    //We are using a set inside a map
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf<String,String>("Wilhelm Tell" to "Schiller")

    moreBooks.getOrPut("Jungle Book"){"Kipling"}
    moreBooks.getOrPut("Hamlet"){"Shakespeare"}

    println(moreBooks)
}