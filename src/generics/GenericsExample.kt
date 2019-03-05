package generics

import classes.Fish

fun main() {
    genericExample()

    Building(Wood()).build()

    val aquarium = Aquarium(TapWater())
    //Type mismatch if we do not put "out" type out in class Aquarium
    addNewItem(aquarium)
}

class MyList<T> {

    fun get(pos:Int): T? {
        return null
    }

    fun addItem(item: T){}
}

fun workWithMyList(){
    val intList: MyList<String>

    val fishList: MyList<Fish>
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater: WaterSupply(true){

    fun addChemicalCleaners(){
        needsProcessed = false
    }
}

class LakeWater: WaterSupply(true){

    fun filter(){
        needsProcessed = false
    }
}

class Aquarium <out T: WaterSupply> (val wSupply: T){

    fun addWater(cleaner: Cleaner<T>){
        //Throws an IllegalStateException if the value is false.
        //check(!wSupply.needsProcessed){"water supply needs processed"}

        //Use errorFunction() when throwing the IllegalStateException
        //check(!wSupply.needsProcessed, ::errorFunction)
        if(wSupply.needsProcessed){
            cleaner.clean(wSupply)
        }

        println("adding water from $wSupply")
    }
}

fun errorFunction(){
    return println("Error in the water supply")
}

fun genericExample(){

    val aquarium = Aquarium(TapWater())
    //aquarium.addWater()
    aquarium.wSupply.addChemicalCleaners()
    //aquarium.addWater()

    val anotherAquarium = Aquarium(LakeWater())
    //anotherAquarium.addWater()
    anotherAquarium.wSupply.filter()
    //anotherAquarium.addWater()

    val cleaner = TapWaterCleaner()
    val secondAquarium = Aquarium(TapWater())
    secondAquarium.addWater(cleaner)
}


open class BaseBuildingMaterial(){
    open val numberNeeded = 1
}

class Wood: BaseBuildingMaterial(){
    override val numberNeeded: Int
        get() = 4
}

class Brick: BaseBuildingMaterial(){
    override val numberNeeded: Int
        get() = 8
}


class Building<T: BaseBuildingMaterial>(val material: T){

    val baseMaterialsNeeded = 100

    val actualMaterialsNeeded = material.numberNeeded * baseMaterialsNeeded

    fun build(){
        println("$actualMaterialsNeeded ${material::class.simpleName} required")
    }
}

fun addNewItem(aquarium: Aquarium<WaterSupply>) = println("item added")

interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }

}

