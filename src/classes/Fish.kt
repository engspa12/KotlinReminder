package classes

open class Fish(open val friendly: Boolean = true, volumeNeeded: Int) {

    open val size: Int

    init{
       println("first init block")
    }

    //true and 9 are the default values and the constructor doesn't take any parameters
    //so we can create a fish calling only classes.Fish()
    constructor():this(true,9){
        println("running secondary constructor")
    }

    init {
        if(friendly){
            size = volumeNeeded
        } else{
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init {
        println("last init block")
    }
}