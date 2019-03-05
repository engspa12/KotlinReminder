package sealedclasses

fun main(args: Array<String>) {
    println(matchSeal(SeaLion()))
    println(matchSeal(Walrus()))
    println(matchSeal(Arni()))
}

sealed class Seal()

class SeaLion: Seal()

class Walrus: Seal()

class Arni: Seal()

fun matchSeal(seal: Seal): String{
    return when(seal){
        is Walrus -> "Walrus"
        is SeaLion -> "Sea Lion"
        else -> "Unknown Species"
    }
}