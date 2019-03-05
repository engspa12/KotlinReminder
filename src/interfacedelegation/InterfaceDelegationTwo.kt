package interfacedelegation

fun main(args: Array<String>) {
    var curry = Curry("Green curry", "very hot", color = SilverSpiceColor)
    curry.prepareSpice()
    curry.grind()

    //If class interfacedelegation.CurryTwo spiceness variable doesn't have a default value, var curryTwo = interfacedelegation.CurryTwo() will throw an error
    //because it cannot use the default value from the abstract class interfacedelegation.SpiceTwo (spiceness: String = "mild")
    //for that reason in this case it would ask us for a value for spiceness when creating the object
    var curryTwo = CurryTwo()
    curryTwo.prepareSpice()
    curryTwo.grind()
}

//Abstract Class
abstract class Spice(var name:String,
                     color: SpiceColor
): SpiceColor by color {
    abstract var spiceness: String
    abstract fun prepareSpice()
}

class Curry(name: String, override var spiceness: String = "hot",
            color: SpiceColor = YellowSpiceColor
): Spice(name, color), Grinder {

    override fun prepareSpice() {
        println("Preparing interfacedelegation.Spice...${name}")
        println("Using color ${color}")
    }

    override fun grind() {
        println("Grinding...")
        println("Using spiceness level ${spiceness}")
    }
}


//Abstract Class
abstract class SpiceTwo(var name:String, var spiceness: String,
                     color: SpiceColor
): SpiceColor by color {

    abstract fun prepareSpice()
}

class CurryTwo(name: String = "Red interfacedelegation.Curry", spiceness: String = "mild",
            color: SpiceColor = YellowSpiceColor
): SpiceTwo(name, spiceness, color), Grinder {

    override fun prepareSpice() {
        println("Preparing interfacedelegation.Spice...${name}")
        println("Using color ${color}")
    }

    override fun grind() {
        println("Grinding...")
        println("Using spiceness level ${spiceness}")
    }
}

//Interface
interface Grinder{
    fun grind()
}

//Interface
interface SpiceColor{
    val color:String
}

//One instance class
object YellowSpiceColor: SpiceColor {
    override val color: String
        get() = "Yellow"
}

//One instance class
object SilverSpiceColor: SpiceColor {
    override val color: String
        get() = "Silver"
}