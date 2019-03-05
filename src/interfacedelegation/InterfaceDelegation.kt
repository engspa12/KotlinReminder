package interfacedelegation

fun main(args: Array<String>) {
    delegate()
}

private fun delegate(){
    val pleco = Pleco()
    println("classes.Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction{
    fun eat()
}

interface FishColor{
    val color: String
}


//Interface Delegation
class Pleco(fishColor: FishColor = GoldColor):
    FishColor by fishColor,
    FishAction by PrintingFishAction("Octopus") {
}

object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}

class PrintingFishAction(val food:String): FishAction {
    override fun eat() {
        println(food)
    }
}

