package dataclasses

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations(){

    val d1 = Decorations("granite")
    println(d1)

    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations("slate")
    println(d3)

    //It prints false
    println(d1.equals(d2))
    //It prints true
    println(d3.equals(d2))

    val d4 = d3.copy()
    println(d3)
    println(d4)

    val d5 = Decorations2("crystal", "wood", "diver")
    println(d5)

    val(rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)

    var enumTest = TestEnum()
    println(enumTest.color)
    println(enumTest.color.rgb)
}

data class Decorations(val rock: String){}

data class Decorations2(val rock: String, val wood: String, val diver: String)

interface SpiceColorTwo{
    val color: Color
}

object YellowSpiceColorTwo: SpiceColorTwo {
    override val color: Color = Color.YELLOW
}

//Enum class
enum class Color(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}

class TestEnum(spiceColorTwo: SpiceColorTwo = YellowSpiceColorTwo): SpiceColorTwo by spiceColorTwo{
}
